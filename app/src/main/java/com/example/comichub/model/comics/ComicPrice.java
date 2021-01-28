package com.example.comichub.model.comics;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ComicPrice {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("price")
    @Expose
    private float price;
}
