package com.example.hellosbvcapp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity{

    boolean notPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        notPressed = true;
    }

    public void clickMe(View view){
        final TextView text=findViewById(R.id.button);

        if(notPressed) {
            text.setText("Clicked!");
            notPressed = false;
        }
        else {
            text.setText("Click Me!");
            notPressed = true;
        }

        //Code adapted from https://www.geeksforgeeks.org/handling-click-events-button-android-java/
    }
}