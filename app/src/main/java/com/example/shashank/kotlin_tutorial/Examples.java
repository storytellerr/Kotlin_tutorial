package com.example.shashank.kotlin_tutorial;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import static com.example.shashank.kotlin_tutorial.R.array.examarr;

/**
 * Created by shashank on 22-04-2017.
 */

public class Examples extends Fragment {

    ListView lv;
    String [] arr;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.examples_fragment,null);
        lv= (ListView) v.findViewById(R.id.exmplist);
        arr=getResources().getStringArray(examarr);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,arr);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(),"hj"+position,Toast.LENGTH_LONG).show();
            }
        });
        return v;
    }
}