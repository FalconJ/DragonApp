package com.example.falconp.dndapp.data.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.falconp.dndapp.R;
import com.example.falconp.dndapp.data.database.CharacterEntry;

import java.util.List;

public class CharacterListAdapter extends RecyclerView.Adapter<CharacterListAdapter.CharacterViewHolder> {

    public class CharacterViewHolder extends RecyclerView.ViewHolder {
        private final TextView characterItemView;

        private CharacterViewHolder(View itemView){
            super(itemView);
            characterItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater mInflater;
    private List<CharacterEntry> mCharacters;

    public CharacterListAdapter(Context context){mInflater = LayoutInflater.from(context); }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new CharacterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        if( mCharacters != null){
            CharacterEntry current = mCharacters.get(position);
            holder.characterItemView.setText(current.getCharName());
        } else {
            // Covers the case of data not being ready yet.
            holder.characterItemView.setText("No characters yet.");
        }
    }

    public void setCharacters(List<CharacterEntry> characters){
        mCharacters = characters;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).

    @Override
    public int getItemCount() {
        if(mCharacters != null){
            return mCharacters.size();
        } else {
            return 0;
        }
    }
}
