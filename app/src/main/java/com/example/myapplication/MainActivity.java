package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener
{
    String[] continents={"-Continent-","Africa","Asia","Europe","N. America", "Oceania","S. America"};

    String[][] countries={{"Angola","Botswana","Cameroon","Egypt","Eritrea","Liberia","Senegal","S. Africa"},
                          {"Hong Kong","Israel","Japan","Nepal","Singapore","Sri Lanka","S. Korea","Taiwan"},
                          {"Albania","Belgium","Finland","France","Germany","Norway","Spain","United Kingdom"},
                          {"Anguila","Belize","Bermuda","Canada","Cayman Islands","Greenland","St. Martin","United States"},
                          {"Australia","French Polynesia","Guam","Marshall Islands","New Caledonia","New Zealand","Pitcairn Islands","Samoa"},
                          {"Argentina","Bolivia","Brazil","Chile","Falkland Islands","French Guiana","Peru","Uruguay"}};

    String[][] capitals={{"Luanda","Gaborone","Yaounde","Cairo","Asmara","Monrovia","Dakar","Cape Town"},
                         {"Hong Kong","Jerusalem","Tokyo","Kathmandu","Singapore","Colombo","Seoul","Taipei"},
                         {"Tirana","Brussles","Helsinki","Paris","Berlin","Oslo","Madrid","London"},
                         {"The Valley","Belize City","Hamilton","Ottawa","George Town","Nuuk","Marigot","Washington D.C."},
                         {"Canberra","Papeete","Hagatna","Majuro","Noumea","Wellington","Adamstown","Apia"},
                         {"Buenos Aires","Sucre","Brasilia","Santiago","Port Stanley","Cayenne","Lima","Montevideo"}};

    Spinner continetsSpinner;
    ListView countriesListView;
    TextView capitalTV, populationTV, languageTV, anthemTV;

    int continent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        continetsSpinner=(Spinner)findViewById(R.id.continentsSpinner);
        countriesListView=(ListView)findViewById(R.id.countriesListView);
        capitalTV=(TextView)findViewById(R.id.capitalTV);
        populationTV=(TextView)findViewById(R.id.populationTV);
        languageTV=(TextView)findViewById(R.id.languageTV);
        anthemTV=(TextView)findViewById(R.id.anthemTV);

        continetsSpinner.setOnItemSelectedListener(this);
        countriesListView.setOnItemClickListener(this);
        countriesListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter<String> adp=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,continents);
        continetsSpinner.setAdapter(adp);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        capitalTV.setText("Capital: "+capitals[continent][position]);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        if (position==0) return;
        ArrayAdapter<String> adp=new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, countries[position-1]);
        countriesListView.setAdapter(adp);
        continent=position-1;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }
}