package rest;

import java.util.List;
import metier.Regate;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RegateService {

    @GET("/regate")
    Call<List<Regate>> listRegate();

}