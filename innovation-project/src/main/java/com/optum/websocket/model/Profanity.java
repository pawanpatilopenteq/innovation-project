package com.optum.websocket.model;

import java.util.ArrayList;
import java.util.List;


public final class Profanity {

    private static List<String> profanityList;

    private Profanity(){

    }

    public static List<String> getProfanityList() {
        if(profanityList == null){
            profanityList = new ArrayList<>();
            profanityList.add("Idiot");
            profanityList.add("Stupid");
            profanityList.add("Fool");
            profanityList.add("dumb");
            return profanityList;
        } else {
            return profanityList;
        }
    }
}
