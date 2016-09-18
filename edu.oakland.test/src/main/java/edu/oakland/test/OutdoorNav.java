package edu.oakland.test;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ZoomControls;
import android.graphics.*;

import com.polites.android.GestureImageView;

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

// computes view display after user selects to do indoor navigation part

public class OutdoorNav extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_outdoor_nav);

        //TextView origin = (TextView) findViewById(R.id.origin_outdoors);
        TextView route = (TextView) findViewById(R.id.route);
        //TextView dest = (TextView) findViewById(R.id.dest_outdoors);
        TextView distance = (TextView) findViewById(R.id.dist_eta_outdoors);

        // webview to display OU map with navigation nodes, as plotted on the map, was not implemented

        //WebView map = (WebView) findViewById(R.id.webView);
        //map.loadUrl("https://a.tiles.mapbox.com/v3/mrkokko.hme6i27h/page.html?secure=1#19/42.67365/-83.21595");
        //map.loadUrl("http://www.google.com");
        Button button = (Button) findViewById(R.id.continue_outdoors);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                // switch to SelectLocation screen
                Intent switch2 = new Intent(v.getContext(), SelectLocation.class); // allows user to go back and start a new navigation session
                switch2.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                v.getContext().startActivity(switch2);
            }
        });
        Intent intent = getIntent();
        Bundle message = intent.getExtras();
        String start = message.getString("building");

        Stack<IntersectionNode> stuff = GraphStuff2.initializeOutdoor(start);

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
            // displays path/route info
            path+="Follow n"+things.pop().getIntersect().getId() + "\n";
        }
        route.setText(path+"You have reached your destination!");
        double aveSpeed = 50;// 3 kilometers per hour - standard speed selected
        double eta = GraphStuff2.totalDist/aveSpeed; // ETA- Estimated Time of Arrival
        // displaying on textview
        distance.setText("Total Distance: " + new DecimalFormat("#.##").format(GraphStuff2.totalDist)+ " meters!\nETA: " + new DecimalFormat("#.#").format(eta) + " minutes");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.outdoor_nav, menu);
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

}
