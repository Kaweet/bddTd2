package com.example.kawet.bddtd2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.Callback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);

        final Call<List<Repo>> repos= service.listRepos("kaweet");
        repos.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Response response, Retrofit retrofit) {
                Toast.makeText(getApplicationContext(), String.format("OK"), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(getApplicationContext(), String.format("KO"), Toast.LENGTH_SHORT).show();

            }
        });
    }

}
