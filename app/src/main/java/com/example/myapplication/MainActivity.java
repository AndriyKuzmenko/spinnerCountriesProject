package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    String[] continents={"-Continent-","Africa","Asia","Europe","North America", "Oceania","South America"};
    String[][] countries={{"Angola","Botswana","Cameroon","Egypt","Eritrea","Liberia","Senegal"},
                          {"Armenia","Georgia","Hong Kong","Israel","Japan","Singapore","Taiwan"},
                          {"Albania","Belgium","Finland","France","Norway","Spain","United Kingdom"},
                          {"Anguila","Bermuda","Canada","Cayman Islands","Greenland","St. Martin","United States"},
                          {"Australia","French Polynesia","Guam","Marshall Islands","New Caledonia","New Zealand","Pitcairn Islands"},
                          {"Argentina","Brazil","Chile","Peru","Uruguay","Falkland Islands","French Guiana"}};

    Spinner continetsSpinner;
    ListView countriesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        continetsSpinner=(Spinner)findViewById(R.id.continentsSpinner);
        countriesListView=(ListView)findViewById(R.id.countriesListView);

        continetsSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<String> adp=new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, continents);
        continetsSpinner.setAdapter(adp);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        if (parent.getId()==continetsSpinner.getId())
        {
            if (position==0) return;
            ArrayAdapter<String> adp=new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, countries[position-1]);
            countriesListView.setAdapter(adp);
        }
        else
        {

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }
}