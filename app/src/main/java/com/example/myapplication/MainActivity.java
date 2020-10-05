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
    String[] continents={"-Continent-","Africa","Asia","Europe","N. America", "Oceania","S. America"}; //N.=North    S.=South

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

    String[][] populations={{"31,127,674","2,254,068","16,545,864","100,075,480","6,081,196","5,073,296","15,854,323","59,622,350"},
                            {"7,500,700","9,258,200","125,960,000","28,095,714","5,703,600","21,803,000","51,709,098","23,780,452"},
                            {"2,845,955","11,492,641","5,528,737","67,081,00","83,166,711","5,432,580","47,431,256","67,886,004"},
                            {"14,731","408,487","71,176","38,005,238","65,813","56,081","35,334","328,239,523"},
                            {"25,673,600","275,918","168,485","58,413","271,407","5,092,100","50","195,843"},
                            {"44,938,712","11,428,245","210,147,125","17,574,003","3,398","290,691","32,824,358","3,518,552"}};

    String[][] languages={{"Portugese","English","French, English","Arabic","Tigrinya","English","French","English, Afrikaans"},
                          {"Cantonese, English","Hebrew","Japanese","Nepali","English","Sinhala, Tamil","Korean","Chinese"},
                          {"Albanian","Dutch, French, German","Finnish","French","German","Norwegian","Spanish","English"},
                          {"English","English","English","English, French","English","Greenlandic","French","English"},
                          {"English","French","English","English","French","English","English, Pitkern","Samoan, English"},
                          {"Spanish","Spanish","Portuguese","Spanish","English","French","Spanish","Spanish"}};

    String[][] anthems={{"Angola Avante","Blessed Be Our Noble Land","Oh Cameroon, Cradle of our Forefathers","Biladi, Biladi, Biladi","Eritrea, Eritrea, Eritrea","All Hail, Liberia, Hail!","Everyone strum your karos, strike the balafons","National Anthem of South Africa"},
                        {"Glory to Hong Kong","Hatikvah","His Imperial Majesty's Reign","Made of Hundreds of Flowers","Onward, Singapore","Mother Sri Lanka","Hongik Ingan","Natinal Anthem of the Republic of China"},
                        {"Hymn to the Flag","Unity makes strength","Our Land","La Marseillaise","Song of Germany","Yes, we love this country","Marcha Real","God Save the Queen"},
                        {"God Bless Anguilla","Land of the Free","Hail to Bermuda","O Canada","Beloved Isle Cayman","You Our Ancient Land","O Sweet Saint Martin","The Star-Spangled Banner"},
                        {"Advance Australia Fair","Great Tahiti of the Golden Haze","Stand Ye Guamanians","Forever Marshall Islands","Soyons unis, devenons freres","God Defend New Zealand","Come Ye Blessed","The Banner of Freedom"},
                        {"Argentine National Anthem","Himno Nacional de Bolivia","Brazilian National Anthem","By Right or Might","Song of the Falkalnds","La Marseillaise","National Anthm of Peru","National Anthem of Uruguay"}};

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
        populationTV.setText("Population: "+populations[continent][position]);

        if (languages[continent][position].contains(","))
        {
            languageTV.setText("Languages: " + languages[continent][position]);
        }
        else
        {
            languageTV.setText("Language: " + languages[continent][position]);
        }

        anthemTV.setText("Anthem: "+anthems[continent][position]);
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