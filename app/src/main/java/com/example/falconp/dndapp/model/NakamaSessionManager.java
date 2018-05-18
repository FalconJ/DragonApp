package com.example.falconp.dndapp.model;

/**
 * Created by FalconP on 15/05/2018.
 */

import com.heroiclabs.nakama.Client;
import com.heroiclabs.nakama.DefaultClient;

public class NakamaSessionManager {
    private final Client client;

    public NakamaSessionManager(){
        client = DefaultClient.builder("5LwHhurhMM")
                .host("104.196.168.44")
                .port(7350)
                .ssl(false)
                .build();
    }
}
