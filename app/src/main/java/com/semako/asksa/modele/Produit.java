package com.semako.asksa.modele;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class Produit {
                                @PrimaryKey
                                @ColumnInfo(name = "id")
@SerializedName("id")           private int id;

                                @ColumnInfo(name = "designation")
@SerializedName("designation")  private String designation;

                                @ColumnInfo(name = "description")
@SerializedName("description")  private String description;

                                @ColumnInfo(name = "categprod")
@SerializedName("categprod")    private String categprod;

                                @ColumnInfo(name = "img")
@SerializedName("img")          private String img;

                                @ColumnInfo(name = "prix")
@SerializedName("prix")         private int prix;

                                @ColumnInfo(name = "stockalerte")
@SerializedName("stockalerte")  private int stockalerte;


    public Produit(int id, String designation, String description,
                   String categprod, String img, int prix, int stockalerte) {
        this.id = id;
        this.designation = designation;
        this.description = description;
        this.categprod = categprod;
        this.img = img;
        this.prix = prix;
        this.stockalerte = stockalerte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategprod() {
        return categprod;
    }

    public void setCategprod(String categprod) {
        this.categprod = categprod;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getStockalerte() {
        return stockalerte;
    }

    public void setStockalerte(int stockalerte) {
        this.stockalerte = stockalerte;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "designation='" + designation + '\'' +
                '}';
    }
}
