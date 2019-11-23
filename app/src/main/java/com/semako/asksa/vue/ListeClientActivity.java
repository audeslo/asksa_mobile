package com.semako.asksa.vue;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_client);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater toolbarclient = getMenuInflater();
        toolbarclient.inflate(R.menu.toolbarclient,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.tb_client_newpp:

                mbt_client_newpp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent form_clientpp = new Intent(ListeClientActivity.this,FormClientppActivity.class);
                        startActivity(form_clientpp);
                    }
                });

                return true;

            case R.id.tb_client_new:
                Toast.makeText(this,"Créatiion dual",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.tb_client_sb_newpm:
                Toast.makeText(this,"Créatiion sub pm",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.tb_client_sb_newpp:
                Toast.makeText(this,"Créatiion sub pp",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.tb_client_quit:
                Toast.makeText(this,"Quitter depuis client",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
