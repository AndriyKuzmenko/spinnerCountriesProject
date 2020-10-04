package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity
{
    String[] continents={"-Continent-","Africa","Asia","Europe","North America", "Oceania","South America"};
    Spinner continetsSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        continetsSpinner=(Spinner)findViewById(R.id.continentsSpinner);

        ArrayAdapter<String> adpSpinner=new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, continents);
        continetsSpinner.setAdapter(adpSpinner);
    }
}