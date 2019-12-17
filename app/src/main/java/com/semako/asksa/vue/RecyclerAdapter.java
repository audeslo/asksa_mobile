package com.semako.asksa.vue;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.semako.asksa.modele.Client;
import com.semako.asksa.R;

import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {


    private List<Client> clientList;
    private Context     context;


    public RecyclerAdapter(List<Client> clientList, Context context) {
        this.clientList = clientList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rcv_row_item,parent,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if ( clientList.get(position).getType() == 1){
           holder.rcvNomcomplet.setText(String.format("%s %s",
                   clientList.get(position).getIdentifiant1(),
                   clientList.get(position).getIdentifiant2()));
       }else {
           holder.rcvNomcomplet.setText(clientList.get(position).getIdentifiant1());
       }

        holder.rcvTelephone.setText(clientList.get(position).getTelephone());


    }

    @Override
    public int getItemCount() {
        return clientList.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView rcvNomcomplet, rcvTelephone;

        public ViewHolder(View itemView) {
            super(itemView);
            rcvNomcomplet   = itemView.findViewById(R.id.rc_NomComplet);
            rcvTelephone    = itemView.findViewById(R.id.rcv_Telephone);

            // parentLayout
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {

            Intent venteActivity = new Intent(v.getContext(), ScanCodeActivity.class);
            v.getContext().startActivity(venteActivity);
            //Toast.makeText(v.getContext(), clientList.get(getAdapterPosition()).getIdentifiant1(), Toast.LENGTH_SHORT).show();
        }
    }



}






