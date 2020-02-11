package com.example.tp_1_1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    //ListView listview;
    ItemAdapter adapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      // cest le code pour faire la liste view
       /* AnimalList ListAnamal = new AnimalList();
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
        });*/
        ArrayList<String> strings = new ArrayList();
        recyclerView = findViewById(R.id.recycler);
        adapter = new ItemAdapter(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.recycl_div));
        recyclerView.addItemDecoration(dividerItemDecoration);
       // recyclerView.setAdapter(new RecyclerViewAdapter(strings));

    }


}