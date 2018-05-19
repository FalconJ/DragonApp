package com.example.falconp.dndapp.Entidades;

import java.util.List;

public class Character {
    private int playerId;
    private String CharacterName;
    private String Class;
    private String Backround;
    private String Race;
    private String Alignment;
    private Integer Level;
    private Integer Experience;
    private Integer Strength;
    private Integer Dexterity;
    private Integer Constitution;
    private Integer Inteligence;
    private Integer Wisdom;
    private Integer Charisma;
    private Integer ModStrength;
    private Integer ModDexterity;
    private Integer ModConstitution;
    private Integer ModInteligence;
    private Integer ModWisdom;
    private Integer ModCharisma;
    private Integer Proficiency;
    private Integer ArmorClass;
    private Integer Iniciative;
    private Integer Speed;
    private Integer HitPoints;
    private String skill1;
    private String skill2;
    private Integer SaveStr;
    private Integer SaveDex;
    private Integer SaveCons;
    private Integer SaveInte;
    private Integer SaveWis;
    private Integer SaveCha;


    private Skills skills;
    private List<Spell> Spells;

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public Skills getSkills() {
        return skills;
    }

    public void setSkills(Skills skills) {
        this.skills = skills;
    }

    public List<Spell> getSpells() {
        return Spells;
    }

    public void setSpells(List<Spell> spells) {
        Spells = spells;
    }

    public Integer getSaveStr() {
        return SaveStr;
    }

    public void setSaveStr(Integer saveStr) {
        SaveStr = saveStr;
    }

    public Integer getSaveDex() {
        return SaveDex;
    }

    public void setSaveDex(Integer saveDex) {
        SaveDex = saveDex;
    }

    public Integer getSaveCons() {
        return SaveCons;
    }

    public void setSaveCons(Integer saveCons) {
        SaveCons = saveCons;
    }

    public Integer getSaveInte() {
        return SaveInte;
    }

    public void setSaveInte(Integer saveInte) {
        SaveInte = saveInte;
    }

    public Integer getSaveWis() {
        return SaveWis;
    }

    public void setSaveWis(Integer saveWis) {
        SaveWis = saveWis;
    }

    public Integer getSaveCha() {
        return SaveCha;
    }

    public void setSaveCha(Integer saveCha) {
        SaveCha = saveCha;
    }

    public String getCharacterName() {
        return CharacterName;
    }

    public void setCharacterName(String characterName) {
        CharacterName = characterName;
    }

    public String getCharacterClass() {
        return Class;
    }

    public void setCharacterClass(String characterClass) {
        Class = characterClass;
    }

    public String getBackround() {
        return Backround;
    }

    public void setBackround(String backround) {
        Backround = backround;
    }

    public String getRace() {
        return Race;
    }

    public void setRace(String race) {
        Race = race;
    }

    public String getAlignment() {
        return Alignment;
    }

    public void setAlignment(String alignment) {
        Alignment = alignment;
    }

    public Integer getLevel() {
        return Level;
    }

    public void setLevel(Integer level) {
        Level = level;
    }

    public Integer getExperience() {
        return Experience;
    }

    public void setExperience(Integer experience) {
        Experience = experience;
    }

    public Integer getStrength() {
        return Strength;
    }

    public void setStrength(Integer strength) {
        Strength = strength;
    }

    public Integer getDexterity() {
        return Dexterity;
    }

    public void setDexterity(Integer dexterity) {
        Dexterity = dexterity;
    }

    public Integer getConstitution() {
        return Constitution;
    }

    public void setConstitution(Integer constitution) {
        Constitution = constitution;
    }

    public Integer getInteligence() {
        return Inteligence;
    }

    public void setInteligence(Integer inteligence) {
        Inteligence = inteligence;
    }

    public Integer getWisdom() {
        return Wisdom;
    }

    public void setWisdom(Integer wisdom) {
        Wisdom = wisdom;
    }

    public Integer getCharisma() {
        return Charisma;
    }

    public void setCharisma(Integer charisma) {
        Charisma = charisma;
    }

    public Integer getModStrength() {
        return ModStrength;
    }

    public void setModStrength(Integer modStrength) {
        ModStrength = modStrength;
    }

    public Integer getModDexterity() {
        return ModDexterity;
    }

    public void setModDexterity(Integer modDexterity) {
        ModDexterity = modDexterity;
    }

    public Integer getModConstitution() {
        return ModConstitution;
    }

    public void setModConstitution(Integer modConstitution) {
        ModConstitution = modConstitution;
    }

    public Integer getModInteligence() {
        return ModInteligence;
    }

    public void setModInteligence(Integer modInteligence) {
        ModInteligence = modInteligence;
    }

    public Integer getModWisdom() {
        return ModWisdom;
    }

    public void setModWisdom(Integer modWisdom) {
        ModWisdom = modWisdom;
    }

    public Integer getModCharisma() {
        return ModCharisma;
    }

    public void setModCharisma(Integer modCharisma) {
        ModCharisma = modCharisma;
    }

    public Integer getProficiency() {
        return Proficiency;
    }

    public void setProficiency(Integer proficiency) {
        Proficiency = proficiency;
    }

    public Integer getArmorClass() {
        return ArmorClass;
    }

    public void setArmorClass(Integer armorClass) {
        ArmorClass = armorClass;
    }

    public Integer getIniciative() {
        return Iniciative;
    }

    public void setIniciative(Integer iniciative) {
        Iniciative = iniciative;
    }

    public Integer getSpeed() {
        return Speed;
    }

    public void setSpeed(Integer speed) {
        Speed = speed;
    }

    public Integer getHitPoints() {
        return HitPoints;
    }

    public void setHitPoints(Integer hitPoints) {
        HitPoints = hitPoints;
    }

    public String getSkill1() {
        return skill1;
    }

    public void setSkill1(String skill1) {
        this.skill1 = skill1;
    }

    public String getSkill2() {
        return skill2;
    }

    public void setSkill2(String skill2) {
        this.skill2 = skill2;
    }
}
