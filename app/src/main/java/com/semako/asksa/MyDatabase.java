package com.semako.asksa;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.semako.asksa.modele.Categorie;
import com.semako.asksa.modele.Client;
import com.semako.asksa.modele.Produit;

@Database(entities = {Client.class, Categorie.class, Produit.class},
            version = 1,
            exportSchema = false
        )
public abstract class MyDatabase extends RoomDatabase {
    private static MyDatabase myDatabase = null;

    // This is abstract method, implemented by Room Framework
    public abstract MyDao getDao();

    public static MyDatabase createDBInstance (Context context){
        if (myDatabase == null){
            myDatabase = Room.databaseBuilder(
                    context.getApplicationContext(),
                    MyDatabase.class,
                    "ASKSA"
            )
                    .allowMainThreadQueries()
                    .build();
        }
        return myDatabase;
    }
}
