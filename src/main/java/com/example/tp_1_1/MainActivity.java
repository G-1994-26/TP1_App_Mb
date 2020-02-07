package com.example.tp_1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;


public class MainActivity extends AppCompatActivity {

    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnimalList ListAnamal = new AnimalList();
        final ListView listview = (ListView) findViewById(R.id.listview);
        String[] values = ListAnamal.getNameArray();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, values);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {

                final String item = (String) parent.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this, SecondeActivity.class);
                String name = listview.getItemAtPosition(position).toString();
                intent.putExtra("name",name);
                startActivity(intent);

            }
        });
    }


}