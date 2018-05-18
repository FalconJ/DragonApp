package com.example.falconp.dndapp.data.database;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface CharacterDao {
    /**
     *  Gets all the characters of player id
     *  @param playerId The player id you want characters for
     *  @return Character list of the player
     */
    @Query("SELECT * FROM character WHERE playerId = :playerId")
    List<CharacterEntry> getCharacterById(int playerId);

    /**
     *  Insert a list of {@link CharacterEntry} into characters table. If there is a conflicting id
     * he weather entry uses the {@link OnConflictStrategy} of replacing the character.
     * The required uniqueness of these values is defined in the {@link CharacterEntry}.
     *
     * @param characters A list of characters to insert
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void bulkInssert(CharacterEntry... characters);

}
