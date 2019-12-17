package com.semako.asksa.modele;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "categorie")
public class Categorie {
                                @PrimaryKey
                                @ColumnInfo(name = "id")
@SerializedName("id")           private int id;

                                @ColumnInfo(name = "libelle")
@SerializedName("lobelle")      private String libelle;

                                @ColumnInfo(name = "description")
@SerializedName("description")  private String description;

    public Categorie(int id, String libelle, String description) {
        this.id = id;
        this.libelle = libelle;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "libelle='" + libelle + '\'' +
                '}';
    }
}
