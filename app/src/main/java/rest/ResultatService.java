package rest;

import java.util.List;

import metier.Resultat;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sdeniel on 10/11/17.
 */

public interface ResultatService {
    @GET("/resultat")
    Call<List<Resultat>> listResultats();
}