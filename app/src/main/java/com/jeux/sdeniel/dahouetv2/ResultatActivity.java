package com.jeux.sdeniel.dahouetv2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import metier.Resultat;
import rest.ResultatService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ResultatActivity extends AppCompatActivity {

    public static final String ENDPOINT = "http://10.0.2.2:8000";
    public static List<Resultat> resultats = new ArrayList<>();
    public static Retrofit retrofit = null;
    ListView listeResultat;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);
        listeResultat = (ListView) findViewById(R.id.nomResultatView);

        // Nouvelle page récupérée
        Intent intent = getIntent();
        int listIdSelected = intent.getIntExtra("listIdSelected", 0);

        connectAndGetApiData();

    }
   public void connectAndGetApiData() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        ResultatService resultatService = retrofit.create(ResultatService.class);
        Call<List<Resultat>> callSerie = resultatService.listResultats();

        callSerie.enqueue(new Callback<List<Resultat>>() {
            @Override
            public void onResponse(Call<List<Resultat>> call, Response<List<Resultat>> response) {
                resultats = response.body();
                listeResultat.setAdapter(new ArrayAdapter<Resultat>(ResultatActivity.this, android.R.layout.simple_list_item_1, resultats));
            }

            @Override
            public void onFailure(Call<List<Resultat>> call, Throwable t) {
                Log.e(RegateActivity.class.getName(), "Erreur", t);
            }
        });

    }
}
