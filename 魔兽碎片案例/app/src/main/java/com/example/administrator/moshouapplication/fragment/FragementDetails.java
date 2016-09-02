package com.example.administrator.moshouapplication.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.moshouapplication.R;


/**
 * Created by Administrator on 2016/8/30.
 */
public class FragementDetails extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        return inflater.inflate(R.layout.frag_detail, container,false);
    }

    public void setText(String item){
        TextView txt = (TextView) getView().findViewById(R.id.detail);
        txt.setText(item);
    }


}
