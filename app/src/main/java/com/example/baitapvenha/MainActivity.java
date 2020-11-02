package com.example.baitapvenha;
//
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.Random;
public class MainActivity extends AppCompatActivity {
    private ConstraintLayout layout;
    private int mColor;
    private Button button;
    private SharedPreferences mPreferences;
    private final String COLOR_KEY = "color";
    private static final String mSharedPrefFile = "com.example.baitapvenha";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.layout);
        button = findViewById(R.id.button);
        mPreferences = getSharedPreferences(mSharedPrefFile, MODE_PRIVATE);
        mColor = mPreferences.getInt(COLOR_KEY, mColor);
        layout.setBackgroundColor(mColor);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
//                layout.setBackgroundColor(color);
                SharedPreferences.Editor preferencesEditor = mPreferences.edit();
                preferencesEditor.putInt(COLOR_KEY, color);
                preferencesEditor.commit();
                layout.setBackgroundColor(color);
            }

        });


    }
}
