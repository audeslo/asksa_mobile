package com.semako.asksa.vue;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.semako.asksa.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private static final String TAG = "RecyclerAdapter";
   // int count=0;

    List<String> movieslist;

    public RecyclerAdapter(List<String> movieslist) {
        this.movieslist = movieslist;
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






