package com.example.examenopdracht;

public class Recept {
    private String rimageUrl;
    private String rreceptTitel;
    private int rreceptId;


    public Recept(String imageUrl, String receptTitel, int receptid){
        rimageUrl = imageUrl;
        rreceptTitel = receptTitel;
        rreceptId = receptid;
    }


    public String getRimageUrl() {
        return rimageUrl;
    }
    public int getReceptId() {
        return rreceptId;
    }

    public String getRreceptTitel() {
        return rreceptTitel;
    }



}
