package com.semako.asksa.modele;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "client",
        indices ={ @Index(name = "index_telephone", value = "telephone", unique = true),
                    @Index(name = "nomComplet", value = {"identifiant1","identifiant2"}, unique = true),
                    @Index(name = "index_categorie", value = "categorie")
                    },
        foreignKeys = {@ForeignKey(
                entity =Categorie.class,
                parentColumns = "id",
                childColumns = "categorie"
        )}
)
public class Client {

                                    @PrimaryKey(autoGenerate = true)
    @SerializedName("idlocal")      private int idlocal ;

                                    @ColumnInfo(name = "referent")
    @SerializedName("referent")     private String referent;

                                    @ColumnInfo(name = "civilite")
    @SerializedName("civilite")     private String civilite ;

                                    @ColumnInfo(name = "identifiant1")
    @SerializedName("identifiant1") private String identifiant1;

                                    @ColumnInfo(name = "identifiant2")
    @SerializedName("identifiant2") private String identifiant2 ;

                                    @ColumnInfo(name = "numerocompte")
    @SerializedName("numerocompte") private String numerocompte;

                                    @ColumnInfo(name = "adresserue")
    @SerializedName("adresserue")   private String adresserue ;

                                    @ColumnInfo(name = "type")
    @SerializedName("type")         private int type;

                                    @ColumnInfo(name = "telephone")
    @SerializedName("telephone")    private String telephone ;

                                    @ColumnInfo(name = "ville")
    @SerializedName("ville")        private String ville;

                                    @ColumnInfo(name = "mail")
    @SerializedName("mail")         private String mail ;

                                    @ColumnInfo(name = "created_on")
    @SerializedName("createdOn")    private String createdOn ;

                                    @ColumnInfo(name = "created_by")
    @SerializedName("createdBy")    private String createdBy;

                                    @ColumnInfo(name = "id")
    @SerializedName("id")           private int id ;

                                    @ColumnInfo(name = "categorie")
    @SerializedName("categorie")    private int categorieId ;

                                    @ColumnInfo(name = "img")
    @SerializedName("img")           private String img ;

                                    @ColumnInfo(name = "sync")
    @SerializedName("sync")           private boolean sync ;

    public boolean isSync() {
        return sync;
    }

    public void setSync(boolean sync) {
        this.sync = sync;
    }

    public Client(String referent, String civilite, String identifiant1, String identifiant2,
                  String numerocompte, String adresserue, int type, String telephone, String ville,
                  String mail, String createdOn, String createdBy, int id, int categorieId, String img) {
        this.referent = referent;
        this.civilite = civilite;
        this.identifiant1 = identifiant1;
        this.identifiant2 = identifiant2;
        this.numerocompte = numerocompte;
        this.adresserue = adresserue;
        this.type = type;
        this.telephone = telephone;
        this.ville = ville;
        this.mail = mail;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.id = id;
        this.categorieId = categorieId;
        this.img = img;
    }

    public int getIdlocal() {
        return idlocal;
    }

    public void setIdlocal(int idlocal) {
        this.idlocal = idlocal;
    }

    public String getReferent() {
        return referent;
    }

    public void setReferent(String referent) {
        this.referent = referent;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getIdentifiant1() {
        return identifiant1;
    }

    public void setIdentifiant1(String identifiant1) {
        this.identifiant1 = identifiant1;
    }

    public String getIdentifiant2() {
        return identifiant2;
    }

    public void setIdentifiant2(String identifiant2) {
        this.identifiant2 = identifiant2;
    }

    public String getNumerocompte() {
        return numerocompte;
    }

    public void setNumerocompte(String numerocompte) {
        this.numerocompte = numerocompte;
    }

    public String getAdresserue() {
        return adresserue;
    }

    public void setAdresserue(String adresserue) {
        this.adresserue = adresserue;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(int categorieId) {
        this.categorieId = categorieId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Client{" +
                "identifiant1='" + identifiant1 + '\'' +
                ", identifiant2='" + identifiant2 + '\'' +
                '}';
    }
}
