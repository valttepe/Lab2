package com.example.valtteri.lab2;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /*
    String[] cheeses = {
            "Parmesan",
            "Ricotta",
            "Fontina",
            "Mozzarella",
            "Cheddar"
    };
    */
    Presidents[] press = {
            new Presidents("Stahlberg, Kaarlo Juho", 1919, 1925, "First one"),
            new Presidents("Relander, Lauri Kristian", 1925, 1931, "Second one"),
            new Presidents("Svinhufvud, Pehr Evind", 1931, 1937, "Third one"),
            new Presidents("Kallio, Kyosti", 1937, 1940, "Fourth one"),
            new Presidents("Ryti, Risto Heikki", 1940, 1944, "Fifth one"),
            new Presidents("Mannerheim, Carl Gustav Emil", 1944, 1946, "Sixth one"),
            new Presidents("Paasikivi, Juho Kusti", 1946, 1956, "Seventh one"),
            new Presidents("Kekkonen, Urho Kaleva", 1956, 1982, "Eighth one"),
            new Presidents("Koivisto, Mauno Henrik", 1982, 1994, "Ninth one"),
            new Presidents("Ahtisaari, Martti Oiva Kalevi", 1994, 2000, "Tenth one"),
            new Presidents("Halonen, Tarja Kaarina", 2000, 2012, "Eleventh one")

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<Presidents> pressAdapter =
                new ArrayAdapter<Presidents>(this, 0, press) {
                    @Override
                    public View getView(int position,
                                        View convertView,
                                        ViewGroup parent) {
                        Presidents currentPresident = press[position];
                        // Inflate only once
                        if(convertView == null) {
                            convertView = getLayoutInflater()
                                    .inflate(R.layout.custom_item, null, false);
                        }
                        TextView presidentName = (TextView)convertView.findViewById(R.id.president_name);
                        TextView presidentDescription = (TextView)convertView.findViewById(R.id.president_description);
                        TextView presidentStartYear = (TextView)convertView.findViewById(R.id.startYear);
                        TextView presidentEndYear = (TextView)convertView.findViewById(R.id.endYear);


                        presidentName.setText(currentPresident.name);
                        presidentDescription.setText(currentPresident.desc);
                        presidentStartYear.setText(Integer.toString(currentPresident.start));
                        presidentEndYear.setText(Integer.toString(currentPresident.end));
                        return convertView;
                    }
                };

        ListView presidentList = new ListView(this);

        setContentView(presidentList);
        presidentList.setAdapter(pressAdapter);

        /*

       ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(
               this, R.layout.activity_main, R.id.showDetails, "here presdident");

        ListView cheeseList = new ListView(this);

        setContentView(cheeseList);
        cheeseList.setAdapter(myAdapter);

        cheeseList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long rowId) {


            }
        });
        */

        presidentList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int position, long rowId) {

                // Generate a message based on the position
                String message = "You clicked on " + press[position].name;

                // Use the message to create a Snackbar
                Snackbar.make(adapterView, message, Snackbar.LENGTH_LONG)
                        .show(); // Show the Snackbar
            }
        });

    }
}
