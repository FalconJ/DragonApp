package com.example.falconp.dndapp.CustomList;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.falconp.dndapp.R;

/**
 * Created by Mauricio on 24/02/2018.
 */

public class CustomListView2 extends ArrayAdapter{

    private String[] names;
    private Activity context;

    public CustomListView2(Activity context, String[] names){
        super(context, R.layout.equipmentlayout,names);

        this.context=context;
        this.names=names;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View r=convertView;
        CustomListView2.ViewHolder viewHolder = null;
        if(r==null){

            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.equipmentlayout,null,true);
            viewHolder= new CustomListView2.ViewHolder(r);
            r.setTag(viewHolder);

        }else{

            viewHolder= (CustomListView2.ViewHolder) r.getTag();

        }

        viewHolder.tvw1.setText(names[position]);

        return r;
    }
    class ViewHolder
    {
        TextView tvw1;

        ViewHolder(View v)
        {
            tvw1=v.findViewById(R.id.nametxt);
        }

    }
}
