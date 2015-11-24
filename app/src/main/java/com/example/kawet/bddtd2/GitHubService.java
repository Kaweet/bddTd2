package com.example.kawet.bddtd2;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Kawet on 17/11/2015.
 */
public interface GitHubService {
    @GET("/users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);
}