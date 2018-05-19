package com.example.falconp.dndapp.CustomList;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.falconp.dndapp.R;

/**
 * Created by Mauricio on 18/02/2018.
 */

public class CustomListView extends ArrayAdapter<String>{


    private String[] names,races,classes;
    private Integer[] imag;
    private Activity context;
    int index;


    public CustomListView(Activity context, String[] names, String[] races, String[] classes, Integer[] imag) {
            super(context, R.layout.characterlayout,names);

            this.context=context;
            this.names=names;
            this.races=races;
            this.classes=classes;
            this.imag=imag;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View r=convertView;
        ViewHolder viewHolder = null;
        if(r==null){

            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.characterlayout,null,true);
            viewHolder= new ViewHolder(r);
            r.setTag(viewHolder);

        }else{

            viewHolder= (ViewHolder) r.getTag();

        }

        viewHolder.ivw.setImageResource(imag[position]);
        viewHolder.tvw1.setText(names[position]);
        viewHolder.tvw2.setText(races[position]);
        viewHolder.tvw3.setText(classes[position]);

        return r;
    }
    class ViewHolder
    {
        TextView tvw1, tvw2, tvw3;
        ImageView ivw;

        ViewHolder(View v)
        {
            tvw1=v.findViewById(R.id.nametxt);
            tvw2=v.findViewById(R.id.racetxt);
            tvw3=v.findViewById(R.id.classtxt);
            ivw=v.findViewById(R.id.imageView);
        }

    }
}
