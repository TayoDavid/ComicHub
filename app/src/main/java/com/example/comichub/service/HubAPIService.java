package com.example.comichub.service;

import com.example.comichub.model.ApiResponse;
import com.example.comichub.model.characters.Character;
import com.example.comichub.model.comics.Comic;
import com.example.comichub.model.series.Series;
import com.example.comichub.model.stories.Story;

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

    @GET("/v1/public/stories")
    Call<ApiResponse<Character>> getStories(@QueryMap Map<String, String> options);

    @GET("/v1/public/stories/{comicId}/comics")
    Call<ApiResponse<Story>> getComicByStoryId(@Path("comicId") int id, @QueryMap Map<String, String> options);

    @GET("/v1/public/series")
    Call<ApiResponse<Series>> getSeries(@QueryMap Map<String, String> options);

    @GET("/v1/public/series/{seriesId}/characters")
    Call<ApiResponse<Character>> getCharactersInSeries(@Path("seriesId") int id, @QueryMap Map<String, String> options);

}
