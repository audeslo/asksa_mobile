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

public class MainActivity extends AppCompatActivity {

    private Button mbt_nouveau;
    private Button mbt_historique;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbt_nouveau = findViewById(R.id.bt_nouveau);

        mbt_nouveau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listeClientActivity = new Intent(MainActivity.this, ListeClientActivity.class);
                startActivity(listeClientActivity);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater toolbarmono = getMenuInflater();
        toolbarmono.inflate(R.menu.toolbarmono,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId()== R.id.tb_mono_quit)
        {
            Toast.makeText(this,"Quitter",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"Erreur",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
