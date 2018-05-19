package com.example.falconp.dndapp.data.database;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "character", indices = {@Index(value = {"id"}, unique = true)})
public class CharacterEntry {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String charName;
    private String charClass;
    private String background;
    private String race;
    private String alignment;
    private int playerId;
    private int level;
    private int exp;
    private int str;
    private int dex;
    private int con;
    private int intel;
    private int wis;
    private int cha;
    private int modStr;
    private int modDex;
    private int modCon;
    private int modInt;
    private int modWis;
    private int modCha;
    private int proficiency;
    private int armorClass;
    private int initiative;
    private int speed;
    private int hp;
    private String skill_1;
    private String skill_2;
    private int saveStr;
    private int saveDex;
    private int saveCon;
    private int saveInt;
    private int saveWis;
    private int saveCha;

    /**
     * This constructor is used by CharacterJsonParser. When the network fetch has JSON data, it
     * converts this data to CharacterEntry objects using this constructor.
     * @param charName Name of the D&D character
     * @param charClass Class of the D&D character
     * @param background Background of the D&D character
     * @param race Race of the D&D character
     * @param alignment Alignment of the D&D character
     * @param playerId Id of the account that created the character
     * @param level Level of the D&D character
     * @param exp Experience of the D&D character
     * @param str Strength of the D&D character
     * @param dex Dexterity of the D&D character
     * @param con Constitution of the D&D character
     * @param intel Intelligence of the D&D character
     * @param wis Wisdom of the D&D character
     * @param cha Charisma of the D&D character
     * @param modStr Strength modifier of the D&D character
     * @param modDex Dexterity modifier of the D&D character
     * @param modCon Constitution modifier of the D&D character
     * @param modInt Intelligence modifier of the D%&D character
     * @param modWis Wisdom modifier of the D&D character
     * @param modCha Charisma modifier of the D&D character
     * @param proficiency Proficiency of the D&D character
     * @param armorClass Armor class of the D&D character
     * @param initiative Initiative of the D&D character
     * @param speed Speed of the D&D character
     * @param hp Hitpoints of the D&D character
     * @param skill_1 First skill of the D&D character
     * @param skill_2 Second skill of the D&D character
     * @param saveStr Strength saving throw of the D&D character
     * @param saveDex Dexterity saving throw of the D&D character
     * @param saveCon Constitution saving throw of the D&D character
     * @param saveInt Intelligence saving throw of the D&D character
     * @param saveWis Widsom saving throw of the D&D character
     * @param saveCha Charisma saving throw of the D&D character
     */
    @Ignore
    public CharacterEntry
            (String charName, String charClass, String background, String race, String alignment,
             int playerId, int level, int exp, int str, int dex, int con, int intel, int wis,
             int cha, int modStr, int modDex, int modCon, int modInt, int modWis, int modCha,
             int proficiency, int armorClass, int initiative,
             int speed, int hp, String skill_1, String skill_2,
             int saveStr, int saveDex, int saveCon, int saveInt, int saveWis, int saveCha){
        this.charName = charName;
        this.charClass = charClass;
        this.background = background;
        this.race = race;
        this.alignment = alignment;
        this.playerId = playerId;
        this.level = level;
        this.exp = exp;
        this.str = str;
        this.dex = dex;
        this.con = con;
        this.intel = intel;
        this.wis = wis;
        this.cha = cha;
        this.modStr = modStr;
        this.modDex = modDex;
        this.modCon = modCon;
        this.modInt = modInt;
        this.modWis = modWis;
        this.modCha = modCha;
        this.proficiency = proficiency;
        this.armorClass = armorClass;
        this.initiative = initiative;
        this.speed = speed;
        this.hp = hp;
        this.skill_1 = skill_1;
        this.skill_2 = skill_2;
        this.saveStr = saveStr;
        this.saveDex = saveDex;
        this.saveCon = saveCon;
        this.saveInt = saveInt;
        this.saveWis = saveWis;
        this.saveCha = saveCha;
    }

    // Constructor used by Room to create CharacterEntries
    public CharacterEntry
    (int id, String charName, String charClass, String background, String race, String alignment,
     int playerId, int level, int exp, int str, int dex, int con, int intel, int wis,
     int cha, int modStr, int modDex, int modCon, int modInt, int modWis, int modCha,
     int proficiency, int armorClass, int initiative,
     int speed, int hp, String skill_1, String skill_2,
     int saveStr, int saveDex, int saveCon, int saveInt, int saveWis, int saveCha){
        this.id = id;
        this.charName = charName;
        this.charClass = charClass;
        this.background = background;
        this.race = race;
        this.alignment = alignment;
        this.playerId = playerId;
        this.level = level;
        this.exp = exp;
        this.str = str;
        this.dex = dex;
        this.con = con;
        this.intel = intel;
        this.wis = wis;
        this.cha = cha;
        this.modStr = modStr;
        this.modDex = modDex;
        this.modCon = modCon;
        this.modInt = modInt;
        this.modWis = modWis;
        this.modCha = modCha;
        this.proficiency = proficiency;
        this.armorClass = armorClass;
        this.initiative = initiative;
        this.speed = speed;
        this.hp = hp;
        this.skill_1 = skill_1;
        this.skill_2 = skill_2;
        this.saveStr = saveStr;
        this.saveDex = saveDex;
        this.saveCon = saveCon;
        this.saveInt = saveInt;
        this.saveWis = saveWis;
        this.saveCha = saveCha;
    }

    public int getId() {
        return id;
    }


    public String getCharName() {
        return charName;
    }

    public String getCharClass() {
        return charClass;
    }

    public String getBackground() {
        return background;
    }

    public String getRace() {
        return race;
    }

    public String getAlignment() {
        return alignment;
    }

    public int getPlayerId() {
        return playerId;
    }

    public int getLevel() {
        return level;
    }

    public int getExp() {
        return exp;
    }

    public int getStr() {
        return str;
    }

    public int getDex() {
        return dex;
    }

    public int getCon() {
        return con;
    }

    public int getIntel() {
        return intel;
    }

    public int getWis() {
        return wis;
    }

    public int getCha() {
        return cha;
    }

    public int getModStr() {
        return modStr;
    }

    public int getModDex() {
        return modDex;
    }

    public int getModCon() {
        return modCon;
    }

    public int getModInt() {
        return modInt;
    }

    public int getModWis() {
        return modWis;
    }

    public int getModCha() {
        return modCha;
    }

    public int getProficiency() {
        return proficiency;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public int getInitiative() {
        return initiative;
    }

    public int getSpeed() {
        return speed;
    }

    public int getHp() {
        return hp;
    }

    public String getSkill_1() {
        return skill_1;
    }

    public String getSkill_2() {
        return skill_2;
    }

    public int getSaveStr() {
        return saveStr;
    }

    public int getSaveDex() {
        return saveDex;
    }

    public int getSaveCon() {
        return saveCon;
    }

    public int getSaveInt() {
        return saveInt;
    }

    public int getSaveWis() {
        return saveWis;
    }

    public int getSaveCha() {
        return saveCha;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public void setCharClass(String charClass) {
        this.charClass = charClass;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public void setCon(int con) {
        this.con = con;
    }

    public void setIntel(int intel) {
        this.intel = intel;
    }

    public void setWis(int wis) {
        this.wis = wis;
    }

    public void setCha(int cha) {
        this.cha = cha;
    }

    public void setModStr(int modStr) {
        this.modStr = modStr;
    }

    public void setModDex(int modDex) {
        this.modDex = modDex;
    }

    public void setModCon(int modCon) {
        this.modCon = modCon;
    }

    public void setModInt(int modInt) {
        this.modInt = modInt;
    }

    public void setModWis(int modWis) {
        this.modWis = modWis;
    }

    public void setModCha(int modCha) {
        this.modCha = modCha;
    }

    public void setProficiency(int proficiency) {
        this.proficiency = proficiency;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setSkill_1(String skill_1) {
        this.skill_1 = skill_1;
    }

    public void setSkill_2(String skill_2) {
        this.skill_2 = skill_2;
    }

    public void setSaveStr(int saveStr) {
        this.saveStr = saveStr;
    }

    public void setSaveDex(int saveDex) {
        this.saveDex = saveDex;
    }

    public void setSaveCon(int saveCon) {
        this.saveCon = saveCon;
    }

    public void setSaveInt(int saveInt) {
        this.saveInt = saveInt;
    }

    public void setSaveWis(int saveWis) {
        this.saveWis = saveWis;
    }

    public void setSaveCha(int saveCha) {
        this.saveCha = saveCha;
    }
}

