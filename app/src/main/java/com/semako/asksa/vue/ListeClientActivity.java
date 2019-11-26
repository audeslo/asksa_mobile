package com.semako.asksa.vue;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.semako.asksa.R;

import java.util.ArrayList;
import java.util.List;

public class ListeClientActivity extends AppCompatActivity {
private Button mbt_client_newpp;

        RecyclerView recyclerView;
        RecyclerAdapter recyclerAdapter;

        List<String> movieslist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_client);

        movieslist = new ArrayList<>();


        // RecycleView
        recyclerView    =   findViewById(R.id.rcv_ListeClient);
        recyclerAdapter = new RecyclerAdapter(movieslist);

        //recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(recyclerAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);

        recyclerView.addItemDecoration(dividerItemDecoration);

        movieslist.add("2 face");
        movieslist.add("house on the rock");
        movieslist.add("Stalker");
        movieslist.add("land of fury");
        movieslist.add("raison");
        movieslist.add("Alobacou");
        movieslist.add("Blood on alter");
        movieslist.add("Breaken pitch");
        movieslist.add("Exemplary");
        movieslist.add("Gbemi");
        movieslist.add("Poupy");
        movieslist.add("Epopée");
        movieslist.add("Sun set at miday");
        movieslist.add("Lost for ever");
        movieslist.add("Final contest");
        movieslist.add("The accumptant");
        movieslist.add("The manager");
        movieslist.add("Free but cost");
        movieslist.add("hanter shadow");
        movieslist.add("Life of Badmos");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater toolbarclient = getMenuInflater();
        toolbarclient.inflate(R.menu.toolbarclient,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent form_clientpm = new Intent(ListeClientActivity.this,FormClientpmActivity.class);
        Intent form_clientpp = new Intent(ListeClientActivity.this,FormClientppActivity.class);
        switch (item.getItemId())
        {
            case R.id.tb_client_newpp:
               startActivity(form_clientpp);
                return true;

            case R.id.tb_client_new:
                return true;

            case R.id.tb_client_sb_newpm:
                startActivity(form_clientpm);
                return true;

            case R.id.tb_client_sb_newpp:
                startActivity(form_clientpp);
                return true;

            case R.id.tb_client_quit:
                Toast.makeText(this,"Quitter depuis client",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
