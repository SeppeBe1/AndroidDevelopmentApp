package com.example.examenopdracht;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ReceptAdapter extends RecyclerView.Adapter<ReceptAdapter.ReceptViewHolder> {
    private Context rContext;
    private ArrayList<Recept> rReceptList;

    public ReceptAdapter(Context context, ArrayList<Recept> receptList){
        rContext = context;
        rReceptList = receptList;
    }

    @NonNull
    @Override
    public ReceptViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(rContext).inflate(R.layout.recept_item,parent, false);
        return new ReceptViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ReceptViewHolder holder, int position) {
        Recept receptPosition = rReceptList.get(position);

        String imageUrl = receptPosition.getRimageUrl();
        String receptTitel = receptPosition.getRreceptTitel();
        int receptId = receptPosition.getReceptId();

        holder.rTextViewName.setText(receptTitel);
        Picasso.get().load(imageUrl).fit().centerInside().into(holder.rImageViewImage);


    }

    @Override
    public int getItemCount() {
        return rReceptList.size() ;
    }

    public class ReceptViewHolder extends RecyclerView.ViewHolder{

        public ImageView rImageViewImage;
        public TextView rTextViewName;

        public ReceptViewHolder(@NonNull View itemView) {
            super(itemView);
            rImageViewImage = itemView.findViewById(R.id.imageRecept);
            rTextViewName = itemView.findViewById(R.id.receptName);

        }
    }
}
