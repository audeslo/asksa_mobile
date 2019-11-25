package com.semako.asksa.vue;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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

public class ListeClientActivity extends AppCompatActivity {
private Button mbt_client_newpp;

        RecyclerView recyclerView;
        RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_client);

        // RecycleView
        recyclerView    =   findViewById(R.id.rcv_ListeClient);
        recyclerAdapter = new RecyclerAdapter();

        //recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(recyclerAdapter);

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
