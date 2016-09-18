package edu.oakland.test;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 *
 * @author mrkokko
 * GrizzPS
 * Oakland University - CSE 480 Senior Capstone Project
 * Winter 2014
 * Mitchell Kokko, Daniela Martignani, Adeline Miller, Stefan Reich
 */

// allows user to select destination for outdoor navigation part, and both origin and destination for indoor navigation part

public class SelectLocation extends ActionBarActivity {

    static String roomName = null;
    String index = null;
    // variables captured from user input and passed to GraphStuff2 class for route creation
    EditText room = null;
    EditText room2 = null;
    EditText building = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_select_location);

        Button nav_button = (Button) findViewById(R.id.go_btn);
        nav_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                // switch to SelectLocation screen
                Intent switch2 = new Intent(v.getContext(), OutdoorNav.class);// if user wants to navigate outdoors
                switch2.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                building=(EditText) findViewById(R.id.editText);
                switch2.putExtra("building",building.getText().toString());
                v.getContext().startActivity(switch2);
            }
        });

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                // switch to SelectLocation screen
                Intent switch3 = new Intent(v.getContext(), IndoorNav.class); // if the user wants to navigate indoors
                switch3.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                room = (EditText) findViewById(R.id.editTextCurrentLocationIndoor);
                room2 = (EditText) findViewById(R.id.editTextDestinationIndoor);
                switch3.putExtra("startPoint", room.getText().toString());
                switch3.putExtra("destination", room2.getText().toString());
                v.getContext().startActivity(switch3);
            }
        });

        // USED ONLY FOR DISPLAY BUILDINGS AND BUILDING CODES
        Spinner buildingSpinner;
        buildingSpinner = (Spinner) findViewById(R.id.building);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.OU_buildings, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        buildingSpinner.setAdapter(adapter);
        //buildingSpinner.setOnItemSelectedListener();


   }// ends method


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.select_location, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_select_location, container, false);
            return rootView;
        }
    }

}
