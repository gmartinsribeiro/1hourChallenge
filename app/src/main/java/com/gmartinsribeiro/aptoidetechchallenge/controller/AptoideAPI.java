package com.gmartinsribeiro.aptoidetechchallenge.controller;

import com.gmartinsribeiro.aptoidetechchallenge.entity.AptoideResponse;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Gonçalo Martins Ribeiro on 20-08-2015.
 */
public interface AptoideAPI {
    @GET("/listApps")
    public void getAllApps(Callback<AptoideResponse> response);
}
