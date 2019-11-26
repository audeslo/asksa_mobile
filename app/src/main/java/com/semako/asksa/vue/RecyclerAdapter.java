package com.semako.asksa.vue;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.semako.asksa.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> implements Filterable {

    private static final String TAG = "RecyclerAdapter";
   // int count=0;

    List<String> movieslist;
    List<String> moviesListAll;

    public RecyclerAdapter(List<String> movieslist) {
        this.movieslist = movieslist;
        this.moviesListAll = new ArrayList<>(movieslist);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       // Log.i(TAG, "onCreateViewHolder: "+ count++);

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.rcv_row_item, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.rcvRowCountTextView.setText(String.valueOf(position));
        holder.textView.setText(movieslist.get(position));

    }

    @Override
    public int getItemCount() {
        return movieslist.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {

        // run on background thread
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            List<String> filteredList = new ArrayList<>();

            if (constraint.toString().isEmpty()){
                filteredList.addAll(moviesListAll);
            }else {
                for (String movie : moviesListAll){
                    if(movie.toLowerCase().contains(constraint.toString().toLowerCase())){
                        filteredList.add(movie);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();

            filterResults.values=filteredList;
            return filterResults;
        }

        // runs on a ui thread
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            movieslist.clear();
            movieslist.addAll((Collection<? extends String>) results.values);

            notifyDataSetChanged();

        }
    };

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imageView;
        TextView textView, rcvRowCountTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView   = itemView.findViewById(R.id.imageView);
            textView    = itemView.findViewById(R.id.rc_Nom);
            rcvRowCountTextView= itemView.findViewById(R.id.rcv_RowCount);

            itemView.setOnClickListener(this);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    movieslist.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());

                    return true;
                }
            });

        }

        @Override
        public void onClick(View v) {
            Toast.makeText(imageView.getContext(), movieslist.get(getAdapterPosition()), Toast.LENGTH_SHORT).show();
        }
    }
}






