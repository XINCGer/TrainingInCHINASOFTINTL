package com.example.administrator.moshouapplication.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.moshouapplication.R;

/**
 * Created by Administrator on 2016/9/1.
 */
public class FragmentTest3 extends Fragment{


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_test3, container, false);
        return v;
    }
}
