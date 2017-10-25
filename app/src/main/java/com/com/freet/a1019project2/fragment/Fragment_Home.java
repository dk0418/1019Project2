package com.com.freet.a1019project2.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import com.com.freet.a1019project2.R;
import com.com.freet.a1019project2.view.RecyclerViewAdapter;

/**
 * Created by freet on 2017-10-18.
 */

public class Fragment_Home extends Fragment{
    public Fragment_Home() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView view = (RecyclerView)layout.findViewById(R.id.fr_home_recyclerview_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter();

        view.setLayoutManager(layoutManager);
        view.setAdapter(recyclerViewAdapter);

        final ViewFlipper viewFlipper = (ViewFlipper) layout.findViewById(R.id.view_viewflipper_main);
        viewFlipper.startFlipping();
        viewFlipper.setFlipInterval(2000);

        return layout;
    }
}
