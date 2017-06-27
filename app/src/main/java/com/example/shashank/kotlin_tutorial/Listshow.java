package com.example.shashank.kotlin_tutorial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import static com.example.shashank.kotlin_tutorial.R.array.card0;
import static com.example.shashank.kotlin_tutorial.R.array.card1;
import static com.example.shashank.kotlin_tutorial.R.array.card2;
import static com.example.shashank.kotlin_tutorial.R.array.card3;
import static com.example.shashank.kotlin_tutorial.R.array.card4;
import static com.example.shashank.kotlin_tutorial.R.array.card5;
import static com.example.shashank.kotlin_tutorial.R.array.card6;
import static com.example.shashank.kotlin_tutorial.R.array.card7;
import static com.example.shashank.kotlin_tutorial.R.array.card8;
import static com.example.shashank.kotlin_tutorial.R.array.card9;

public class Listshow extends AppCompatActivity {

    ListView lv;
    String [] card;
    int value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listshow);
        Toolbar toolbar = (Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        value=getIntent().getIntExtra("value",10);
        arrayvall(value);
        lv=(ListView) findViewById(R.id.listsh);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(Listshow.this,android.R.layout.simple_list_item_1,card);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(Listshow.this,"hh"+position,Toast.LENGTH_LONG).show();
            }
        });
    }

    public String[] arrayvall(int value)
    {
        switch (value)
        {
            case 0:
                card=getResources().getStringArray(card0);
                break;
            case 1:
                card=getResources().getStringArray(card1);
                 break;
            case 2:
                card=getResources().getStringArray(card2);
                break;
            case 3:
                card=getResources().getStringArray(card3);
                break;
            case 4:
                card=getResources().getStringArray(card4);
                break;
            case 5:
                card=getResources().getStringArray(card5);
                break;
            case 6:
                card=getResources().getStringArray(card6);
                break;
            case 7:
                card=getResources().getStringArray(card7);
                break;
            case 8:
                card=getResources().getStringArray(card8);
                break;
            case 9:
                card=getResources().getStringArray(card9);
                break;
        }
        return card;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
}
