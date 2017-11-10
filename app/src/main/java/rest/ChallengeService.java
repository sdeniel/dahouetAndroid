package rest;

import java.util.List;
import metier.Challenge;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ChallengeService {

    @GET("/challenge")
    Call<List<Challenge>> listChallenge();

}
