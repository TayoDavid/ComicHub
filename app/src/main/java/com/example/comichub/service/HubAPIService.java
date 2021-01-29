package com.example.comichub.service;

import com.example.comichub.model.ApiResponse;
//import com.example.comichub.model.characters.Character;
//import com.example.comichub.model.comics.Comic;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface HubAPIService {

    @GET("/v1/public/characters")
    Call<ApiResponse> getCharacters(@QueryMap Map<String, String> options);

    @GET("/v1/public/characters")
    Call<ApiResponse<Character>> getCharacters2(@QueryMap Map<String, String> options);

    @GET("/v1/public/characters/{characterId}")
    Call<ApiResponse<Character>> getCharacterById(@Path("characterId") int id, @QueryMap Map<String, String> options);

//    @GET("/v1/public/characters/{characterId}/comics")
//    Call<List<Comic>> getComicsByCharacterId(@Path("characterId") int id, @QueryMap Map<String, String> options);
//
//    @GET("/v1/public/comics")
//    Call<List<Comic>> getComics(@QueryMap Map<String, String> options);
//
//    @GET("/v1/public/comic/{comicId}")
//    Call<Comic> getComicsById(@Path("comicId") int id, @QueryMap Map<String, String> options);
}
