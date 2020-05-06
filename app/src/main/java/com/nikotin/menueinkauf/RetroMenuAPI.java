package com.nikotin.menueinkauf;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface RetroMenuAPI {

        @GET("changes/")
        Call<List<RetroMenuNormal>> loadRandMenue(@Query("q") String status);

        @GET("v1/menu/random")
        Call<MenuNormal> loadRandomMenu();
}
