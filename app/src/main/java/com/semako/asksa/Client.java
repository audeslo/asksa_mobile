package com.semako.asksa;

import com.google.gson.annotations.SerializedName;


public class Client {


    @SerializedName("id")           private int id ;

    @SerializedName("referent")     private String referent;

    @SerializedName("civilite")     private String civilite ;

    @SerializedName("identifiant1") private String identifiant1;

    @SerializedName("identifiant2") private String identifiant2 ;

    @SerializedName("numerocompte") private String numerocompte;

    @SerializedName("adresserue")   private String adresserue ;

    @SerializedName("type")         private String type;

    @SerializedName("telephone")    private String telephone ;

    @SerializedName("ville")        private String ville;

    @SerializedName("mail")         private String mail ;

    @SerializedName("slug")         private String slug;

    @SerializedName("createdOn")    private String createdOn ;

    @SerializedName("createdBy")    private String createdBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
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

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
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
}
