package com.semako.asksa.vue;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.semako.asksa.ApiClient;
import com.semako.asksa.ApiInterface;
import com.semako.asksa.MyDao;
import com.semako.asksa.modele.Client;
import com.semako.asksa.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListeClientActivity extends AppCompatActivity {

private static final String TAG="ListeClientActivity";

private Button mbt_client_newpp;
private List<Client> clientsList;
private RecyclerView recyclerView;
private RecyclerAdapter recyclerAdapter;
private ProgressBar progressBar;
private static MyDao myDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_client);
        progressBar = findViewById(R.id.cli_progress);

        recyclerView=findViewById(R.id.rcv_ListeClient);
        recyclerView.setHasFixedSize(true);

        synchronizeClient("");

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

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.tb_client_search).getActionView();

        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName())
        );

        searchView.setIconifiedByDefault(false);
               /* MenuItem item = menu.findItem(R.id.tb_client_search);
        SearchView searchView = (SearchView) item.getActionView();*/
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                fetchClients(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                fetchClients(newText);
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

    public void fetchClients(String key){

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<Client>> call =  apiInterface.getClients(key);
        call.enqueue(new Callback<List<Client>>() {
            @Override
            public void onResponse(@NonNull Call<List<Client>> call,@NonNull Response<List<Client>> response) {
                progressBar.setVisibility(View.GONE);
                clientsList = response.body();
                recyclerAdapter= new RecyclerAdapter(clientsList,ListeClientActivity.this);
                recyclerView.setAdapter(recyclerAdapter);
                recyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(@NonNull Call<List<Client>> call,@NonNull Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(ListeClientActivity.this, "Erreur on : "+t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }


    private void synchronizeClient(String key){

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<Client>> call =  apiInterface.getClients(key);
        call.enqueue(new Callback<List<Client>>() {
            @Override
            public void onResponse(@NonNull Call<List<Client>> call,@NonNull Response<List<Client>> response) {
                progressBar.setVisibility(View.GONE);
                clientsList = response.body();

                for(Client  clt:clientsList){
                    Log.d(TAG, "run: "+clt.toString());
                }


            }

            @Override
            public void onFailure(@NonNull Call<List<Client>> call,@NonNull Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(ListeClientActivity.this, "Erreur on : "+t.toString(), Toast.LENGTH_LONG).show();
            }
        });

    }


    private class FindAllClients extends AsyncTask<String, Void, Void>{
        List<Client> clientList =null;
        @Override
        protected Void doInBackground(String... strings) {
            clientList= myDao.findByClientByIdentifiant(strings[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (clientList == null){
                Toast.makeText(ListeClientActivity.this, "Chargement clients échoué",
                        Toast.LENGTH_SHORT).show();
            }else if(clientList.size()==0){
                Toast.makeText(ListeClientActivity.this, "Base vide", Toast.LENGTH_SHORT).show();

            }else {
                Toast.makeText(ListeClientActivity.this, "Données existe", Toast.LENGTH_SHORT).show();
            }
        }
    }


}
