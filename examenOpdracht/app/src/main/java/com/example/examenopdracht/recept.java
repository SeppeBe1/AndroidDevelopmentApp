package com.example.examenopdracht;

public class Recept {
    private String RimageUrl;
    private String RreceptTitel;
    private String RreceptDescription;

    public Recept(String imageUrl, String receptTitel, String receptDescription){
        RimageUrl = imageUrl;
        RreceptTitel = receptTitel;
        RreceptDescription = receptDescription;
    }


    public String getRimageUrl() {
        return RimageUrl;
    }

    public String getRreceptTitel() {
        return RreceptTitel;
    }

    public String getRreceptDescription() {
        return RreceptDescription;
    }

    public void setRimageUrl(String rimageUrl) {
        RimageUrl = rimageUrl;
    }

    public void setRreceptDescription(String rreceptDescription) {
        RreceptDescription = rreceptDescription;
    }

    public void setRreceptTitel(String rreceptTitel) {
        RreceptTitel = rreceptTitel;
    }
}
