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
    String[] continents={"-Continent-","Africa","Asia","Europe","N. America", "Oceania","S. America"};
    String[][] countries={{"Angola","Botswana","Cameroon","Egypt","Eritrea","Liberia","Senegal","S. AFrica"},
                          {"Hong Kong","Israel","Japan","Nepal","Singapore","Sri Lanka","S. Korea","Taiwan"},
                          {"Albania","Belgium","Finland","France","Germany","Norway","Spain","United Kingdom"},
                          {"Anguila","Belize","Bermuda","Canada","Cayman Islands","Greenland","St. Martin","United States"},
                          {"Australia","French Polynesia","Guam","Marshall Islands","New Caledonia","New Zealand","Pitcairn Islands","Samoa"},
                          {"Argentina","Bolivia","Brazil","Chile","Peru","Uruguay","Falkland Islands","French Guiana"}};

    Spinner continetsSpinner;
    ListView countriesListView;
    int continent;

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
            continent=position;
        }
        else
        {
            switch (continent)
            {
                case 1:
                    checkAfrica(position);
                    break;
                case 2:
                    checkAsia(position);
                    break;
                case 3:
                    checkEurope(position);
                    break;
                case 4:
                    checkNorthAmerica(position);
                    break;
                case 5:
                    checkOceania(position);
                    break;
                case 6:
                    checkSouthAmerica(position);
                    break;
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }

    public void checkAfrica(int position)
    {

    }

    public void checkAsia(int position)
    {

    }

    public void checkEurope(int position)
    {

    }

    public void checkNorthAmerica(int position)
    {

    }

    public void checkOceania(int position)
    {

    }

    public void checkSouthAmerica(int position)
    {

    }
}