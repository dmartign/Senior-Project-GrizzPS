package edu.oakland.test;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Stack;

/**
 *
 * @author mrkokko
 * GrizzPS
 * Oakland University - CSE 480 Senior Capstone Project
 * Winter 2014
 * Mitchell Kokko, Daniela Martignani, Adeline Miller, Stefan Reich
 */

public class IndoorNav extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_indoor_nav);

        Button nav_button = (Button) findViewById(R.id.continue_indoors);
        TextView route = (TextView) findViewById(R.id.route);
        TextView distance = (TextView) findViewById(R.id.dist_eta_indoors);
        nav_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                // switch to SelectLocation screen
                Intent switch2 = new Intent(v.getContext(), SelectLocation.class);
                switch2.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                v.getContext().startActivity(switch2);
            }
        });
        Intent intent = getIntent();
        Bundle message = intent.getExtras();
        String start = message.getString("startPoint");
        String destination = message.getString("destination");
        Stack<IntersectionNode> stuff = GraphStuff2.initializeIndoor(start, destination);
        String path = "Route:\n";
        Stack<IntersectionNode> things = new Stack<IntersectionNode>();

        // IF CANNOT FIND SOURCE OR DESTINATION
        if(stuff.empty())
        {
            path+="No path available";
        }
        while(!stuff.empty())
        {
            things.push(stuff.pop());
        }
        while(!things.empty())
        {
            // prints path/route info
            path+="Follow " + things.pop().getIntersect().getName().toString()+"\n";
        }
        route.setText(path+"You have reached your destination!");
        double aveSpeed = 50;// 3 kilometers per hour
        double eta = GraphStuff2.totalDist/aveSpeed;// ETA - Estimated Time of Arrival
        // display in the textview
        distance.setText("Total Distance: " + new DecimalFormat("#.##").format(GraphStuff2.totalDist)+ " meters!\nETA: " + new DecimalFormat("#.#").format(eta) + " minutes");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.indoor_nav, menu);
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
    /*public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_indoor_nav, container, false);
            return rootView;
        }
    }*/

}
