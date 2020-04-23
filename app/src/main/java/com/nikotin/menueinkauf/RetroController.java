package com.nikotin.menueinkauf;

import android.util.Log;
import android.widget.Toast;

import java.util.Iterator;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import static com.nikotin.menueinkauf.MainActivity.LOG_TAG;

//DV: This Class implements the Retro Interface. In the Activity or Fragment this can be used
public class RetroController implements Callback<List<RetroMenuNormal>> {
    //DV: todo: here will be our base URL for Einkauf Application
    static final String BASE_URL = "https://git.eclipse.org/r/";

    //DV: todo: this would be the call for the menu e.g. RetroController.start() or RetroController.getMenu() -->just adpat here
    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RetroMenuAPI retroMenuAPI = retrofit.create(RetroMenuAPI.class);

        Call<List<RetroMenuNormal>> call = retroMenuAPI.loadChanges("status:open");
        call.enqueue(this); //führt den call aus

    }



    @Override
    public void onResponse(Call<List<RetroMenuNormal>> call, Response<List<RetroMenuNormal>> response) {
        //DV: The response Object is in the Body.
        Iterator<RetroMenuNormal> iter=response.body().iterator();
        while(iter.hasNext()){
            RetroMenuNormal temp=iter.next();
            Log.d(LOG_TAG,temp.subject+"....bubu...."+temp.project);
        }
    }

    @Override
    public void onFailure(Call<List<RetroMenuNormal>> call, Throwable t) {
        t.printStackTrace();
    }
}
