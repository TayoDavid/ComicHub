package com.example.comichub.service;

import com.example.comichub.model.ApiResponse;
import com.example.comichub.model.characters.Character;
import com.example.comichub.model.comics.Comic;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface HubAPIService {

    @GET("/v1/public/characters")
    Call<ApiResponse<Character>> getCharacters(@QueryMap Map<String, String> options);

    @GET("/v1/public/comics")
    Call<ApiResponse<Comic>> getComics(@QueryMap Map<String, String> options);

    @GET("/v1/public/creator/{characterId}")
    Call<ApiResponse<Character>> getCreator(@Path("characterId") int id, @QueryMap Map<String, String> options);

}
