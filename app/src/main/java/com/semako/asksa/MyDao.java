package com.semako.asksa;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.semako.asksa.modele.Categorie;
import com.semako.asksa.modele.Client;

import java.util.List;

@Dao
public interface MyDao {

    // CATEGORIE*****************************
        @Query("SELECT * FROM categorie ORDER BY libelle ASC")
        List<Categorie> findAllCategories();

        @Query("SELECT * FROM categorie WHERE libelle LIKE :pLibelle ORDER BY libelle")
        List<Categorie> findByCategorieByLibelle(String pLibelle);

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        long insertCategorie(Categorie categorie);

        @Update
        int updateCategorie(Categorie categorie);

        @Delete
        int deleteCategorie(Categorie categorie);


    // CLIENT*************************************
        @Query("SELECT * FROM client ORDER BY identifiant1 ASC")
        List<Client> findAllClients();

        @Query("SELECT * FROM client WHERE identifiant1 LIKE :pNom OR identifiant2 " +
                "LIKE :pNom ORDER BY identifiant1")
        List<Client> findByClientByIdentifiant(String pNom);

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        long insertClient(Client client);

        @Update
        int updateClient(Client client);

        @Delete
        int deleteClient(Client client);
}
