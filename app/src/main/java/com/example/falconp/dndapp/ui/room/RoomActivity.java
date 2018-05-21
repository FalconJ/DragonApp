package com.example.falconp.dndapp.ui.room;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.falconp.dndapp.R;
import com.example.falconp.dndapp.data.network.NakamaSessionManager;
import com.example.falconp.dndapp.databinding.ActivityRoomBinding;

public class RoomActivity extends AppCompatActivity {
    private ActivityRoomBinding mActivityRoomBinding;
    private NakamaSessionManager mSessionManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityRoomBinding = DataBindingUtil.setContentView(this, R.layout.activity_room);
        mSessionManager = new NakamaSessionManager();
        mSessionManager.restoreSessionAndConnect(this);

        onClickListeners();
    }

    private void onClickListeners(){
        mActivityRoomBinding.roomButtons.createRoomButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mSessionManager.createMatch();
                        mActivityRoomBinding.roomButtons.fieldRoomId.setText(mSessionManager.getNewMatch().getId());
                        mActivityRoomBinding.primaryInfo.roomId.setText(mSessionManager.getNewMatch().getId());

                    }
                }
        );
    }
}
