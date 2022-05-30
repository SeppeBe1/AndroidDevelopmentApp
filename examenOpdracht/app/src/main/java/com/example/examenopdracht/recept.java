package com.example.examenopdracht;

public class Recept {
    private String rimageUrl;
    private String rreceptTitel;
    private String rreceptDescription;

    public Recept(String imageUrl, String receptTitel, String receptDescription){
        rimageUrl = imageUrl;
        rreceptTitel = receptTitel;
        rreceptDescription = receptDescription;
    }


    public String getRimageUrl() {
        return rimageUrl;
    }

    public String getRreceptTitel() {
        return rreceptTitel;
    }

    public String getRreceptDescription() {
        return rreceptDescription;
    }

}
