package com.example.falconp.dndapp.model;

/**
 * Created by FalconP on 03/03/2018.
 */

public class CharacterSheet {
    /* Character general information */
    private String charName;
    private String charClass;
    private String charRace;
    private String charAlignment;
    private int charLevel;
    private int idBackground;
    private int charExp;

    /* Character attributes
    *   TODO: Util function to calculate bonus attrs
    */
    private int strength;
    private int dexterity;
    private int consstitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    private int proficiencyBonus;
    private int improvedInit;

    /*
    *   Health & Armor
    */
    private int currentHealth;
    private int maxHealth;
    private int tempHealth;
    private int armorBonus;
    private int shieldBonus;





}
