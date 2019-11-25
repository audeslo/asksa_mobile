package com.semako.asksa.vue;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.semako.asksa.R;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private static final String TAG = "RecyclerAdapter";
    int count=0;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Log.i(TAG, "onCreateViewHolder: "+ count++);

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.rcv_row_item, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.rcvRowCountTextView.setText(String.valueOf(position));

    }

    @Override
    public int getItemCount() {
        return 200;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView, rcvRowCountTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView   = itemView.findViewById(R.id.imageView);
            textView    = itemView.findViewById(R.id.rc_Nom);
            rcvRowCountTextView= itemView.findViewById(R.id.rcv_RowCount);


        }
    }
}






