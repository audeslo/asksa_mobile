package com.semako.asksa;

import com.semako.asksa.modele.Client;
import com.semako.asksa.modele.Vente;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {


    @GET("get_clients.php")
    Call <List<Client>> getClients(@Query("key") String keyword);



    @FormUrlEncoded
    @POST("add_client.php")
    Call<Client> insertClient(
            @Field("key") String key,
            @Field("identifiant1") String identifiant1,
            @Field("identifiant2") String identifiant2,
            @Field("adrebreed") String breed,
            @Field("gender") int gender,
            @Field("birth") String birth,
            @Field("picture") String picture);

    @FormUrlEncoded
    @POST("update_client.php")
    Call<Client> updatePet(
            @Field("key") String key,
            @Field("id") int id,
            @Field("name") String name,
            @Field("species") String species,
            @Field("breed") String breed,
            @Field("gender") int gender,
            @Field("birth") String birth,
            @Field("picture") String picture);

    @FormUrlEncoded
    @POST("client_pet.php")
    Call<Client> deletePet(
            @Field("key") String key,
            @Field("id") int id,
            @Field("picture") String picture);

    @FormUrlEncoded
    @POST("add_vente.php")
    Call<Vente> updateLove(
            @Field("key") String key,
            @Field("id") int id,
            @Field("love") boolean love);

}
