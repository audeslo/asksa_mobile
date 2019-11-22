package com.semako.asksa.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

import com.semako.asksa.R;

public class MainActivity extends AppCompatActivity {

    private Button mBTN_Nouveau;
    private Button mBTN_Historique;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBTN_Nouveau = findViewById(R.id.BTN_Nouveau);

        mBTN_Nouveau.setOnClickListener(new View.OnClickListener() {
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
}
