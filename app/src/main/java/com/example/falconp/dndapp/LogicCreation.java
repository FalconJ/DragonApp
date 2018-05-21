package com.example.falconp.dndapp;

import com.example.falconp.dndapp.data.database.CharacterEntry;
import com.example.falconp.dndapp.data.network.NakamaSessionManager;
import com.google.gson.Gson;
import java.util.Random;

public class LogicCreation {

    NakamaSessionManager nakamaSessionManager;

    public CharacterEntry RaceModif(CharacterEntry newcharacter){

        if(newcharacter.getRace().equals("Human")){

            newcharacter.setSpeed(30);
            newcharacter.setStr(newcharacter.getStr()+1);
            newcharacter.setDex(newcharacter.getDex()+1);
            newcharacter.setCon(newcharacter.getCon()+1);
            newcharacter.setIntel(newcharacter.getIntel()+1);
            newcharacter.setWis(newcharacter.getWis()+1);
            newcharacter.setCha(newcharacter.getCha()+1);

        } if(newcharacter.getRace().equals("Dwarf")){

            newcharacter.setSpeed(25);
            newcharacter.setCon(newcharacter.getCon()+2);

        } if(newcharacter.getRace().equals("Elf")){

            newcharacter.setSpeed(30);
            newcharacter.setDex(newcharacter.getDex()+2);

        }

        return newcharacter;
    }

    public CharacterEntry CalcularMods(CharacterEntry newcharacter){

        int[] stats = new int[6];
        stats[0]=newcharacter.getStr();
        stats[1]=newcharacter.getDex();
        stats[2]=newcharacter.getCon();
        stats[3]=newcharacter.getIntel();
        stats[4]=newcharacter.getWis();
        stats[5]=newcharacter.getCha();

        for(int i = 0; i<6; i++){

            if(stats[i]==1){
                stats[i]=-5;
            } if(stats[i]>1 && stats[i]<4){
                stats[i]=-4;
            } if(stats[i]>3 && stats[i]<6){
                stats[i]=-3;
            } if(stats[i]>5 && stats[i]<8){
                stats[i]=-2;
            } if(stats[i]>7 && stats[i]<10){
                stats[i]=-1;
            } if(stats[i]>9 && stats[i]<12){
                stats[i]=0;
            } if(stats[i]>11 && stats[i]<14){
                stats[i]=1;
            } if(stats[i]>13 && stats[i]<16){
                stats[i]=2;
            } if(stats[i]>15 && stats[i]<18){
                stats[i]=3;
            } if(stats[i]>17 && stats[i]<20){
                stats[i]=4;
            } if(stats[i]>19 && stats[i]<22){
                stats[i]=5;
            } if(stats[i]>21 && stats[i]<24){
                stats[i]=6;
            }

        }

        newcharacter.setModStr(stats[0]);
        newcharacter.setModDex(stats[1]);
        newcharacter.setModCon(stats[2]);
        newcharacter.setModInt(stats[3]);
        newcharacter.setModWis(stats[4]);
        newcharacter.setModCha(stats[5]);

        return newcharacter;
    }

    public CharacterEntry CalcularExtras(CharacterEntry newcharacter){

        newcharacter.setInitiative(newcharacter.getModDex());


        if(newcharacter.getCharClass().equals("Paladin")){

            newcharacter.setHp(10+newcharacter.getModCon());
            newcharacter.setArmorClass(16+newcharacter.getModDex());
            newcharacter.setSaveStr(newcharacter.getModStr());
            newcharacter.setSaveDex(newcharacter.getModDex());
            newcharacter.setSaveCon(newcharacter.getModCon());
            newcharacter.setSaveInt(newcharacter.getModInt());
            newcharacter.setSaveWis(newcharacter.getModWis()+newcharacter.getProficiency());
            newcharacter.setSaveCha(newcharacter.getModCha()+newcharacter.getProficiency());

        } if(newcharacter.getCharClass().equals("Druid")){

            newcharacter.setHp(8+newcharacter.getModCon());
            newcharacter.setArmorClass(11+newcharacter.getModDex());
            newcharacter.setSaveStr(newcharacter.getModStr());
            newcharacter.setSaveDex(newcharacter.getModDex());
            newcharacter.setSaveCon(newcharacter.getModCon());
            newcharacter.setSaveInt(newcharacter.getModInt()+newcharacter.getProficiency());
            newcharacter.setSaveWis(newcharacter.getModWis()+newcharacter.getProficiency());
            newcharacter.setSaveCha(newcharacter.getModCha());

        } if(newcharacter.getCharClass().equals("Rogue")){

            newcharacter.setHp(8+newcharacter.getModCon());
            newcharacter.setArmorClass(11+newcharacter.getModDex());
            newcharacter.setSaveStr(newcharacter.getModStr());
            newcharacter.setSaveDex(newcharacter.getModDex()+newcharacter.getProficiency());
            newcharacter.setSaveCon(newcharacter.getModCon());
            newcharacter.setSaveInt(newcharacter.getModInt()+newcharacter.getProficiency());
            newcharacter.setSaveWis(newcharacter.getModWis());
            newcharacter.setSaveCha(newcharacter.getModCha());

        }

        return  newcharacter;
    }

    public Integer randomNumber(Integer min, Integer max){

        Random rand = new Random();

        int randomNum = rand.nextInt((max-min)+1)+min;

        return randomNum;
    }

    public String getJson(CharacterEntry newcharacter){

        String json = "";

        Gson gson = new Gson();

        json = gson.toJson(newcharacter);

        return json;
    }

    public CharacterEntry getCharacter(String json){
        Gson gson = new Gson();


        CharacterEntry character = gson.fromJson(json, CharacterEntry.class);

        return character;
    }

}