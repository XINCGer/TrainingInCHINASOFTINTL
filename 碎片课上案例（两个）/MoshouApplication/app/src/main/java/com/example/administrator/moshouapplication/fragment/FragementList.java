package com.example.administrator.moshouapplication.fragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.administrator.moshouapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/30.
 */
public class FragementList extends ListFragment {


    private String[] values = new String[] { "侏儒", "人类", "暗夜精灵", "矮人", "兽人","亡灵" };
    private int[] images = new int[] {
            R.drawable.zhuru,  R.drawable.men,R.drawable.anyejingling,  R.drawable.airen,R.drawable.shouren,
            R.drawable.wangling};

 //   @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        System.out.println("==========1==============");
//        View v= inflater.inflate(R.layout.frag_list, container, false);
//        System.out.println("==========2==============");
//        return v;
//    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < values.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("values", values[i]);
            listItem.put("images", images[i]);
            listItems.add(listItem);
        }
        SimpleAdapter adapter = new SimpleAdapter(getActivity(), listItems,
                R.layout.list_item, new String[] { "images" , "values"},
                new int[] { R.id.itemImage, R.id.itemTitle });
        setListAdapter(adapter);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        System.out.println("==========5==================");
        // String item = (String) getListAdapter().getItem(position);
       // System.out.println("==========6=================="+item);
        FragementDetails frag = (FragementDetails) getFragmentManager()
                .findFragmentById(R.id.frag_detail);
        if (frag != null && frag.isInLayout()) {
            switch (position) {
                case 0:
                    frag.setText(getString(R.string.Gnome));
                    break;
                case 1:
                    frag.setText(getString(R.string.Human));
                    break;
                case 2:
                    frag.setText(getString(R.string.NightElf));
                    break;
                case 3:
                    frag.setText(getString(R.string.Dwarf));
                    break;
                case 4:
                    frag.setText(getString(R.string.Draenei));
                    break;
                case 5:
                    frag.setText(getString(R.string.Werewolf));
                    break;
            }
        }

        Log.i("PDA", "position = " + position);
    }


}
