package com.example.examenopdracht;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ReceptAdapter.onReceptClickListener {
    public static final String EXTRA_RECEPT_ID = "id";
    public static final String EXTRA_RECEPT_TITLE = "title";
    private RecyclerView rRecyclerView;
    private ReceptAdapter rReceptAdapter;
    private ArrayList<Recept> rReceptList;
    private RequestQueue rRequestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rRecyclerView = findViewById(R.id.recyclerView);
        rRecyclerView.setHasFixedSize(true);
        rRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        rReceptList = new ArrayList<>();
        rRequestQueue = Volley.newRequestQueue(this);
        parseJSON();
    }
    private void parseJSON(){

        String host = "https://api.spoonacular.com/recipes/";
        String what = "complexSearch?";
        String key = "apiKey=f370281a5a7947a08019c2134d25b356";

        String number = "&number=2";
        String inputsearch = "chicken";
        String search = "&query=" + inputsearch;
        String params = number + search;

        String url = host + what + key + params;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new
                Response.Listener<JSONObject>() {
                    //Responsen aanvragen met GET en de url
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("results");
                            for(int i = 0; i <jsonArray.length(); i++){
                                JSONObject result = jsonArray.getJSONObject(i);

                                String receptId = result.getString("id");
                                String receptTitle = result.getString("title");
                                String imageUrl = result.getString("image");
                                //Responsen opvangen en uithalen wat nodig

                                rReceptList.add(new Recept(imageUrl,receptTitle,receptId));
                                //Responsen in Recept object steken
                            }

                            rReceptAdapter = new ReceptAdapter(MainActivity.this,rReceptList);
                            rRecyclerView.setAdapter(rReceptAdapter);
                            rReceptAdapter.setOnReceptClickListener(MainActivity.this);

                            //zorgen er voor dat data in recyclerview terechtkomt

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
        });

        rRequestQueue.add(request);

    }

    @Override
    public void onReceptClick(int position) {
        Intent detailIntent = new Intent(this,DetailRecept.class);
        Recept clickedRecept = rReceptList.get(position);

        detailIntent.putExtra(EXTRA_RECEPT_ID, clickedRecept.getReceptId());
        detailIntent.putExtra(EXTRA_RECEPT_TITLE, clickedRecept.getRreceptTitel());

        startActivity(detailIntent);
    }
}