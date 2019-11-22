package com.semako.asksa.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import com.semako.asksa.R;

public class ListeClientActivity extends AppCompatActivity {

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
}
