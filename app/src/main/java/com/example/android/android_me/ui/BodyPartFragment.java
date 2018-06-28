package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

public class BodyPartFragment extends Fragment {
    private ImageView mImageView;

    public BodyPartFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // inflates the root layout when the fragment is called
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);

        // Gets a reference to the image view in the root layout
        mImageView = (ImageView) rootView.findViewById(R.id.body_part_image_view);

        // Set the image resource to display
        mImageView.setImageResource(AndroidImageAssets.getHeads().get(0));

        // return root view
        return rootView;

    }
}
