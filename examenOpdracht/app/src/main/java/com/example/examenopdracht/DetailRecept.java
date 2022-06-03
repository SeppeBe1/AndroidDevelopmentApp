package com.example.examenopdracht;

import static com.example.examenopdracht.MainActivity.EXTRA_RECEPT_ID;
import static com.example.examenopdracht.MainActivity.EXTRA_RECEPT_TITLE;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class DetailRecept extends AppCompatActivity {
    private RequestQueue rRequestQueue;
    String shareBody = "Here is the share content body";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_recept);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Intent intent = getIntent();
        String id = intent.getStringExtra(EXTRA_RECEPT_ID);
//        parseJSON(id);
        String titel = intent.getStringExtra(EXTRA_RECEPT_TITLE);

        TextView titleTextView = findViewById(R.id.titleDetail);
        titleTextView.setText(titel);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.detailmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.shareMenu){
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
            sendIntent.setType("text/plain");
            startActivity(Intent.createChooser(sendIntent, "Share"));
            }
        return super.onOptionsItemSelected(item);
    }


//    private void parseJSON(String id){
//
//        ImageView imageView = findViewById(R.id.imageViewDetail);
//        TextView descriptionTextView = findViewById(R.id.descriptionDetail);
//        TextView instructionTextView = findViewById(R.id.instructionDetail);
//
//        String host = "https://api.spoonacular.com/recipes/";
//        String urlid =  id;
//        String what = "/information?";
//        String key = "apiKey=f370281a5a7947a08019c2134d25b356";
//        String params = "&includeNutrition=false";
//
//
//        String url = host + urlid +  what + key + params;
//
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new
//                Response.Listener<JSONObject>() {
//                    //Responsen aanvragen met GET en de url
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                                String image = response.getString("image");
//                                String summary = response.getString("summary");
//                                String instructions = response.getString("instructions");
//
//                                //String imageUrl = result.getString("image");
//                                //Responsen opvangen en uithalen wat nodig
//                            Picasso.get().load(image).fit().centerInside().into(imageView);
//                            descriptionTextView.setText(summary);
//                            instructionTextView.setText(instructions);
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                error.printStackTrace();
//            }
//
//        });
//    }
}