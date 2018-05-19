package com.example.falconp.dndapp.Classes;
import com.example.falconp.dndapp.Entidades.Skills;
import com.example.falconp.dndapp.Entidades.Character;
import com.example.falconp.dndapp.Entidades.Spell;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LogicCreation {

    public Character RaceModif(Character newcharacter){

        if(newcharacter.getRace().equals("Human")){

            newcharacter.setSpeed(30);
            newcharacter.setStrength(newcharacter.getStrength()+1);
            newcharacter.setDexterity(newcharacter.getDexterity()+1);
            newcharacter.setConstitution(newcharacter.getConstitution()+1);
            newcharacter.setInteligence(newcharacter.getInteligence()+1);
            newcharacter.setWisdom(newcharacter.getWisdom()+1);
            newcharacter.setCharisma(newcharacter.getCharisma()+1);

        } if(newcharacter.getRace().equals("Dwarf")){

            newcharacter.setSpeed(25);
            newcharacter.setConstitution(newcharacter.getConstitution()+2);

        } if(newcharacter.getRace().equals("Elf")){

            newcharacter.setSpeed(30);
            newcharacter.setDexterity(newcharacter.getDexterity()+2);

        }

        return newcharacter;
    }

    public Character CalcularMods(Character newcharacter){

        int[] stats = new int[6];
        stats[0]=newcharacter.getStrength();
        stats[1]=newcharacter.getDexterity();
        stats[2]=newcharacter.getConstitution();
        stats[3]=newcharacter.getInteligence();
        stats[4]=newcharacter.getWisdom();
        stats[5]=newcharacter.getCharisma();

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

        newcharacter.setModStrength(stats[0]);
        newcharacter.setModDexterity(stats[1]);
        newcharacter.setModConstitution(stats[2]);
        newcharacter.setModInteligence(stats[3]);
        newcharacter.setModWisdom(stats[4]);
        newcharacter.setModCharisma(stats[5]);

        return newcharacter;
    }

    public Character CalcularExtras(Character newcharacter){

        newcharacter.setIniciative(newcharacter.getModDexterity());

        Skills skills = new Skills();


        if(newcharacter.getCharacterClass().equals("Paladin")){

            newcharacter.setHitPoints(10+newcharacter.getModConstitution());
            newcharacter.setArmorClass(16+newcharacter.getModDexterity());
            newcharacter.setSaveStr(newcharacter.getModStrength());
            newcharacter.setSaveDex(newcharacter.getModDexterity());
            newcharacter.setSaveCons(newcharacter.getModConstitution());
            newcharacter.setSaveInte(newcharacter.getModInteligence());
            newcharacter.setSaveWis(newcharacter.getModWisdom()+newcharacter.getProficiency());
            newcharacter.setSaveCha(newcharacter.getModCharisma()+newcharacter.getProficiency());

        } if(newcharacter.getCharacterClass().equals("Druid")){

            newcharacter.setHitPoints(8+newcharacter.getModConstitution());
            newcharacter.setArmorClass(11+newcharacter.getModDexterity());
            newcharacter.setSaveStr(newcharacter.getModStrength());
            newcharacter.setSaveDex(newcharacter.getModDexterity());
            newcharacter.setSaveCons(newcharacter.getModConstitution());
            newcharacter.setSaveInte(newcharacter.getModInteligence()+newcharacter.getProficiency());
            newcharacter.setSaveWis(newcharacter.getModWisdom()+newcharacter.getProficiency());
            newcharacter.setSaveCha(newcharacter.getModCharisma());

        } if(newcharacter.getCharacterClass().equals("Rogue")){

            newcharacter.setHitPoints(8+newcharacter.getModConstitution());
            newcharacter.setArmorClass(11+newcharacter.getModDexterity());
            newcharacter.setSaveStr(newcharacter.getModStrength());
            newcharacter.setSaveDex(newcharacter.getModDexterity()+newcharacter.getProficiency());
            newcharacter.setSaveCons(newcharacter.getModConstitution());
            newcharacter.setSaveInte(newcharacter.getModInteligence()+newcharacter.getProficiency());
            newcharacter.setSaveWis(newcharacter.getModWisdom());
            newcharacter.setSaveCha(newcharacter.getModCharisma());

        }

        skills.setAcrobatics(newcharacter.getModDexterity());
        skills.setAnimalHandling(newcharacter.getModWisdom());
        skills.setArcana(newcharacter.getModInteligence());
        skills.setAthletics(newcharacter.getModStrength());
        skills.setDeception(newcharacter.getModCharisma());
        skills.setHistory(newcharacter.getModInteligence());
        skills.setInsight(newcharacter.getModWisdom());
        skills.setIntimidation(newcharacter.getModCharisma());
        skills.setInvestigation(newcharacter.getModInteligence());
        skills.setMedicine(newcharacter.getModWisdom());
        skills.setNature(newcharacter.getModInteligence());
        skills.setPerception(newcharacter.getModWisdom());
        skills.setPerformance(newcharacter.getModCharisma());
        skills.setPersuasion(newcharacter.getModCharisma());
        skills.setReligion(newcharacter.getModInteligence());
        skills.setSleghtOfHand(newcharacter.getModDexterity());
        skills.setStealth(newcharacter.getModDexterity());
        skills.setSurvival(newcharacter.getModWisdom());

        newcharacter.setSkills(skills);

        return  newcharacter;
    }

    public List<Spell> spells(String spell1, String spell2){
        Spell spell = new Spell();
        Spell spell3 = new Spell();
        List<Spell> spells  = new ArrayList<>();

        spell.setName(spell1);
        if(spell.getName().equals("Burning Hands"))
            spell.setDice("3d6");
        if(spell.getName().equals("Ray of Sickness"))
            spell.setDice("2d8");
        if(spell.getName().equals("Magic Missile"))
            spell.setDice("1d4+1");
        spells.add(spell);


        spell3.setName(spell2);
        if(spell3.getName().equals("Burning Hands"))
            spell3.setDice("3d6");
        if(spell3.getName().equals("Ray of Sickness"))
            spell3.setDice("2d8");
        if(spell3.getName().equals("Magic Missile"))
            spell3.setDice("1d4+1");
        spells.add(spell3);

        return spells;
    }

    public Character SkillIncrees(Character newcharacter){

        if(newcharacter.getSkill1().equals("Acrobatics") || newcharacter.getSkill2().equals("Acrobatics"))
        newcharacter.getSkills().setAcrobatics(newcharacter.getSkills().getAcrobatics()+2);
        if(newcharacter.getSkill1().equals("Animal Handling") || newcharacter.getSkill2().equals("Animal Handling"))
        newcharacter.getSkills().setAnimalHandling(newcharacter.getSkills().getAnimalHandling()+2);
        if(newcharacter.getSkill1().equals("Arcana") || newcharacter.getSkill2().equals("Arcana"))
        newcharacter.getSkills().setArcana(newcharacter.getSkills().getArcana()+2);
        if(newcharacter.getSkill1().equals("Athletics") || newcharacter.getSkill2().equals("Athletics"))
        newcharacter.getSkills().setAthletics(newcharacter.getSkills().getAthletics()+2);
        if(newcharacter.getSkill1().equals("Deception") || newcharacter.getSkill2().equals("Deception"))
        newcharacter.getSkills().setDeception(newcharacter.getSkills().getDeception()+2);
        if(newcharacter.getSkill1().equals("History") || newcharacter.getSkill2().equals("History"))
        newcharacter.getSkills().setHistory(newcharacter.getSkills().getHistory()+2);
        if(newcharacter.getSkill1().equals("Insight") || newcharacter.getSkill2().equals("Insight"))
        newcharacter.getSkills().setInsight(newcharacter.getSkills().getInsight()+2);
        if(newcharacter.getSkill1().equals("Intimidation") || newcharacter.getSkill2().equals("Intimidation"))
        newcharacter.getSkills().setIntimidation(newcharacter.getSkills().getIntimidation()+2);
        if(newcharacter.getSkill1().equals("Investigation") || newcharacter.getSkill2().equals("Investigation"))
        newcharacter.getSkills().setInvestigation(newcharacter.getSkills().getInvestigation()+2);
        if(newcharacter.getSkill1().equals("Medicine") || newcharacter.getSkill2().equals("Medicine"))
        newcharacter.getSkills().setMedicine(newcharacter.getSkills().getMedicine()+2);
        if(newcharacter.getSkill1().equals("Nature") || newcharacter.getSkill2().equals("Nature"))
        newcharacter.getSkills().setNature(newcharacter.getSkills().getNature()+2);
        if(newcharacter.getSkill1().equals("Perception") || newcharacter.getSkill2().equals("Perception"))
        newcharacter.getSkills().setPerception(newcharacter.getSkills().getPerception()+2);
        if(newcharacter.getSkill1().equals("Performance") || newcharacter.getSkill2().equals("Performance"))
        newcharacter.getSkills().setPerformance(newcharacter.getSkills().getPerformance()+2);
        if(newcharacter.getSkill1().equals("Persuasion") || newcharacter.getSkill2().equals("Persuasion"))
        newcharacter.getSkills().setPersuasion(newcharacter.getSkills().getPersuasion()+2);
        if(newcharacter.getSkill1().equals("Religion") || newcharacter.getSkill2().equals("Religion"))
        newcharacter.getSkills().setReligion(newcharacter.getSkills().getReligion()+2);
        if(newcharacter.getSkill1().equals("Sleght Of Hand") || newcharacter.getSkill2().equals("Sleght Of Hand"))
        newcharacter.getSkills().setSleghtOfHand(newcharacter.getSkills().getSleghtOfHand()+2);
        if(newcharacter.getSkill1().equals("Stealth") || newcharacter.getSkill2().equals("Stealth"))
        newcharacter.getSkills().setStealth(newcharacter.getSkills().getStealth()+2);
        if(newcharacter.getSkill1().equals("Survival") || newcharacter.getSkill2().equals("Survival"))
        newcharacter.getSkills().setSurvival(newcharacter.getSkills().getSurvival()+2);

        return newcharacter;
    }


    public Integer randomNumber(Integer min, Integer max){

        Random rand = new Random();

        int randomNum = rand.nextInt((max-min)+1)+min;

        return randomNum;
    }

    public String getJson(Character newcharacter){

        String json = "";

        Gson gson = new Gson();

        json = gson.toJson(newcharacter);

        return json;
    }

    public Character getCharacter(String json){
        Gson gson = new Gson();

        Character character = gson.fromJson(json, Character.class);

        return character;
    }

}
