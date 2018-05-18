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
    private int inspiration;
    private int perception;
    private int armorClass;
    private int initiative;
    private int speed;
    private int hp;
    private String skill_1;
    private String skill_2;
    private String skill_3;
    private String skill_4;
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
     * @param inspiration Inspiration of the D&D character (1 = true  || 0 = false)
     * @param perception Perception of the D&D character
     * @param armorClass Armor class of the D&D character
     * @param initiative Initiative of the D&D character
     * @param speed Speed of the D&D character
     * @param hp Hitpoints of the D&D character
     * @param skill_1 First skill of the D&D character
     * @param skill_2 Second skill of the D&D character
     * @param skill_3 Third skill of the D&D character
     * @param skill_4 Fourth skill of the D&D character
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
             int proficiency, int inspiration, int perception, int armorClass, int initiative,
             int speed, int hp, String skill_1, String skill_2, String skill_3, String skill_4,
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
        this.inspiration = inspiration;
        this.perception = perception;
        this.armorClass = armorClass;
        this.initiative = initiative;
        this.speed = speed;
        this.hp = hp;
        this.skill_1 = skill_1;
        this.skill_2 = skill_2;
        this.skill_3 = skill_3;
        this.skill_4 = skill_4;
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
     int proficiency, int inspiration, int perception, int armorClass, int initiative,
     int speed, int hp, String skill_1, String skill_2, String skill_3, String skill_4,
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
        this.inspiration = inspiration;
        this.perception = perception;
        this.armorClass = armorClass;
        this.initiative = initiative;
        this.speed = speed;
        this.hp = hp;
        this.skill_1 = skill_1;
        this.skill_2 = skill_2;
        this.skill_3 = skill_3;
        this.skill_4 = skill_4;
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

    public int getInspiration() {
        return inspiration;
    }

    public int getPerception() {
        return perception;
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

    public String getSkill_3() {
        return skill_3;
    }

    public String getSkill_4() {
        return skill_4;
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
}
