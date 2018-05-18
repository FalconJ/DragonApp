package com.example.falconp.dndapp.ui.detail;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.falconp.dndapp.AppExecutors;
import com.example.falconp.dndapp.R;
import com.example.falconp.dndapp.data.database.CharacterEntry;
import com.example.falconp.dndapp.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    /*
     * This field is used for data binding. Normally, we would have to call findViewById many
     * times to get references to the Views in this Activity. With data binding however, we only
     * need to call DataBindingUtil.setContentView and pass in a Context and a layout, as we do
     * in onCreate of this class. Then, we can access all of the Views in our layout
     * programmatically without cluttering up the code with findViewById.
     */
    private ActivityDetailBinding mDetalBinding;
    private DetailActivityViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDetalBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        mViewModel = ViewModelProviders.of(this).get(DetailActivityViewModel.class);

        // Observers changes in the CharacterEnty with the id mid
        mViewModel.getCharacter().observe(this, characterEntry -> {
            // If the character details change, update the UI
            if(characterEntry != null)
                bindCharacterToUI(characterEntry);
        });

        AppExecutors.getInstance().diskIO().execute(() -> {
            try {

                // Pretend this is the network loading data
                Thread.sleep(3000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        });
    }


    private void bindCharacterToUI(CharacterEntry charEnty){
        // TODO: Finish UI binding
    }
}
