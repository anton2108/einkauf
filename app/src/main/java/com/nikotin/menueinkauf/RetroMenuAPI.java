package com.nikotin.menueinkauf;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface RetroMenuAPI {
        //DV: Base URL is defined in the Retro Builder /changes/ is the Call of type http get
        @GET("changes/")
        Call<List<RetroMenuNormal>> loadChanges(@Query("q") String status);
}
