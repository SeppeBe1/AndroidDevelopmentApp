package com.example.examenopdracht;

public class Recept {
    private String rimageUrl;
    private String rreceptTitel;
    private String rreceptId;


    public Recept(String imageUrl, String receptTitel, String receptid){
        rimageUrl = imageUrl;
        rreceptTitel = receptTitel;
        rreceptId = receptid;
    }


    public String getRimageUrl() {
        return rimageUrl;
    }
    public String getReceptId() {
        return rreceptId;
    }

    public String getRreceptTitel() {
        return rreceptTitel;
    }



}
