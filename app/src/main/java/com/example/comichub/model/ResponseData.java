package com.example.comichub.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseData<T> {

    @SerializedName("offset")
    @Expose
    private int offset;
    @SerializedName("limit")
    @Expose
    private int limit;

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    @SerializedName("total")
    @Expose
    private int total;
    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("results")
    @Expose
    private List<T> results = null;

}
