package com.semako.asksa.vue;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.semako.asksa.ApiClient;
import com.semako.asksa.ApiInterface;
import com.semako.asksa.Client;
import com.semako.asksa.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListeClientActivity extends AppCompatActivity {
private Button mbt_client_newpp;
private List<Client> clientsList;
private RecyclerView recyclerView;
private RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_client);

        recyclerView=findViewById(R.id.rcv_ListeClient);
        recyclerView.setHasFixedSize(true);

        fetchClients();

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);

       recyclerView.addItemDecoration(dividerItemDecoration);







        // getClient();
        //movieslist = new ArrayList<>();
        // RecycleView

        //recyclerView    =   findViewById(R.id.rcv_ListeClient);
        //recyclerAdapter = new RecyclerAdapter(movieslist);

       // DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);

        //recyclerView.addItemDecoration(dividerItemDecoration);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater toolbarclient = getMenuInflater();
        toolbarclient.inflate(R.menu.toolbarclient,menu);

        MenuItem item = menu.findItem(R.id.tb_client_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //recyclerAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent form_clientpm = new Intent(ListeClientActivity.this,FormClientpmActivity.class);
        Intent form_clientpp = new Intent(ListeClientActivity.this,FormClientppActivity.class);
        switch (item.getItemId())
        {
            case R.id.tb_client_ventes:
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

    public void fetchClients(){

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<Client>> call =  apiInterface.getClients();
        call.enqueue(new Callback<List<Client>>() {
            @Override
            public void onResponse(@NonNull Call<List<Client>> call,@NonNull Response<List<Client>> response) {
                clientsList = response.body();
                recyclerAdapter= new RecyclerAdapter(clientsList,ListeClientActivity.this);
                recyclerView.setAdapter(recyclerAdapter);
                recyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(@NonNull Call<List<Client>> call,@NonNull Throwable t) {
                Toast.makeText(ListeClientActivity.this, "Erreur on : "+t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }


}
