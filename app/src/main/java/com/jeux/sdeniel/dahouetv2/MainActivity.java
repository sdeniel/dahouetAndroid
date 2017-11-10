package com.jeux.sdeniel.dahouetv2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import metier.Challenge;
import rest.ChallengeService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String ENDPOINT = "http://10.0.2.2:8000";
    public static List<Challenge> challenges = new ArrayList<>();
    public static Retrofit retrofit = null;
    ListView listeChallenge;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listeChallenge = (ListView) findViewById(R.id.nomChallengeView);

        connectAndGetApiData();
    }

    public void connectAndGetApiData() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        ChallengeService challengeService = retrofit.create(ChallengeService.class);
        Call<List<Challenge>> callSerie = challengeService.listChallenge();

        callSerie.enqueue(new Callback<List<Challenge>>() {
            @Override
            public void onResponse(Call<List<Challenge>> call, Response<List<Challenge>> response) {
                challenges = response.body();
                listeChallenge.setAdapter(new ArrayAdapter<Challenge>(MainActivity.this, android.R.layout.simple_list_item_1, challenges));

                // Envoi vers la page Regate lorsque l'on clique sur l'un des challenges affichés
                listeChallenge.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Challenge chal_temp = (Challenge) listeChallenge.getItemAtPosition(position);
                        int challIdSelected = chal_temp.getChallengeID();
                        // intent permet de passer d'une page A à une page B ici de MainActivity à RegateActivity
                        Intent i = new Intent(MainActivity.this, RegateActivity.class);
                        i.putExtra("challIdSelected", challIdSelected);
                        startActivity(i);
                    }
                });
                // Fin de morceau de programme qui gère l'envoi vers une nouvelle page (activity_Regate)
            }

            @Override
            public void onFailure(Call<List<Challenge>> call, Throwable t) {
                Log.e(MainActivity.class.getName(), "Erreur", t);
            }
        });

    }


}
