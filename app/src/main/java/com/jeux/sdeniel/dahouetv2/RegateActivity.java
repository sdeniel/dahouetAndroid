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

import metier.Regate;
import rest.RegateService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sdeniel on 09/11/17.
 */

public class RegateActivity extends AppCompatActivity {

    public static final String ENDPOINT = "http://10.0.2.2:8000";
    public static List<Regate> regates = new ArrayList<>();
    public static Retrofit retrofit = null;
    ListView listeRegate;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regate);
        listeRegate = (ListView) findViewById(R.id.nomRegateView);

        // Nouvelle page récupérée
        Intent intent = getIntent();
        int challIdSelected = intent.getIntExtra("challIdSelected", 0);

        connectAndGetApiData();

    }

    public void connectAndGetApiData() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        RegateService regateService = retrofit.create(RegateService.class);
        Call<List<Regate>> callSerie = regateService.listRegate();

        callSerie.enqueue(new Callback<List<Regate>>() {
            @Override
            public void onResponse(Call<List<Regate>> call, Response<List<Regate>> response) {
                regates = response.body();
                listeRegate.setAdapter(new ArrayAdapter<Regate>(RegateActivity.this, android.R.layout.simple_list_item_1, regates));

                // Envoi vers la page Regate lorsque l'on clique sur l'un des challenges affichés
                listeRegate.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Regate reg_temp = (Regate) listeRegate.getItemAtPosition(position);
                        int regIdSelected = reg_temp.getChallengeID();
                        // intent permet de passer d'une page A à une page B ici de MainActivity à RegateActivity
                        Intent i = new Intent(RegateActivity.this, ResultatActivity.class);
                        i.putExtra("regIdSelected", regIdSelected);
                        startActivity(i);
                    }
                });
                // Fin de morceau de programme qui gère l'envoi vers une nouvelle page (activity_Regate)
            }

            @Override
            public void onFailure(Call<List<Regate>> call, Throwable t) {
                Log.e(RegateActivity.class.getName(), "Erreur", t);
            }
        });

    }

}
