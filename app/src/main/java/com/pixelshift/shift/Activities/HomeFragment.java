package com.pixelshift.shift.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.pixelshift.shift.R;
import com.pixelshift.shift.Utils.CaptureManager;

public class HomeFragment extends Fragment {

    ImageView imgSetting;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        imgSetting = view.findViewById(R.id.imageViewSettings);

        imgSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettings();
            }
        });
    }

    private void openSettings() {
        startActivity(new Intent(requireActivity(), SettingsActivity.class));
    }
}
