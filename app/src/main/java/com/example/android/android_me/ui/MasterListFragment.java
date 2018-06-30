package com.example.android.android_me.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.List;

public class MasterListFragment extends Fragment {
    MasterListAdapter mMasterListAdapter;
    GridView mGridView;

    public MasterListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_master_list,
                container, false);

        // get a reference to the gridview in fragment_master_list
        mGridView = (GridView) rootView.findViewById(R.id.images_gird_view);

        // gets the context and a reference to the list of image ids needed for the MasterListAdapter
        Context context = getContext();
        List<Integer> mImageIds = AndroidImageAssets.getAll();

        // Create the adapter
        mMasterListAdapter = new MasterListAdapter(context,mImageIds);

        // set the adapter on the gridView
        mGridView.setAdapter(mMasterListAdapter);

        // returns the rootView
        return rootView;
    }
}
