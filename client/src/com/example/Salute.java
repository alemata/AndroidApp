package com.example;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.adapters.BolicheEntryAdapter;
import com.example.model.Boliche;

public class Salute extends ListActivity {

    static final String[] PEOPLE = new String[]{"Leoz", "Bargas", "Mataloni",
            "Majul", "Pompa", "Merlo"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        setContentView(R.layout.salute);
        BolicheEntryAdapter bolicheEntryAdapter = new BolicheEntryAdapter(this, R.layout.boliche_entry_list);
        for (int i = 0; i < 25; i++) {
            bolicheEntryAdapter.add(new Boliche("Honduras","Boliche en Palermo","Honduras 3550"));
            bolicheEntryAdapter.add(new Boliche("Kika","Boliche en Palermo", "Fitz Roy 2367"));
        }

        BolichesLongRequest bolichesLongRequest = new BolichesLongRequest();
        bolichesLongRequest.execute();


        setListAdapter(bolicheEntryAdapter);

//        Intent i = getIntent();
//        Bundle extras = i.getExtras();
//        String nombre = extras.getString("name");
//        TextView viewById = (TextView) findViewById(R.id.salute_id);
//        viewById.setText("Hola " + nombre);


    }
}
