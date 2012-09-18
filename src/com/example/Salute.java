package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Salute extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.salute);
        Intent i = getIntent();
        Bundle extras = i.getExtras();
        String nombre = extras.getString("name");
        TextView viewById = (TextView) findViewById(R.id.salute_id);
        viewById.setText("Hola " + nombre);
//        viewById.invalidate();

    }
}
