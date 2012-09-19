package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    /** Called when the user touches the button */
    public void sayHello(View view) {
        Intent intent = new Intent(this, Salute.class);
        Bundle bundle = new Bundle();
        TextView viewById = (TextView) findViewById(R.id.nameInput);
        bundle.putString("name", viewById.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);
        // Do something in response to button click
    }
}
