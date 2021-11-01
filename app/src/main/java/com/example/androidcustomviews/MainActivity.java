package com.example.androidcustomviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FrameLayout flContainer;

    String userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flContainer = findViewById(R.id.flContainer);
        SignFormView signFormView = new SignFormView(getBaseContext());

        signFormView.setOnSubmitButtonClicked(new SignFormView.OnSubmitButtonClicked() {
            @Override
            public void onSubmitButtonClicked(String email) {
                userEmail = email;
                Toast.makeText(MainActivity.this, userEmail + " - got it in activity.", Toast.LENGTH_SHORT).show();
            }
        });

        flContainer.addView(signFormView);
    }
}