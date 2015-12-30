package com.example.dylicious.mydoctors;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AppointmentViewer extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_viewer);

        //declare TextView
        TextView viewAppName = (TextView)findViewById(R.id.app_nameview);
        TextView viewAppDesc = (TextView)findViewById(R.id.app_descview);
        TextView viewAppTime = (TextView)findViewById(R.id.app_timeview);
        TextView viewAppDate = (TextView)findViewById(R.id.app_dateview);

        Intent intentGetApp = getIntent();
        String appName = intentGetApp.getStringExtra("app_name");
        String appDesc = intentGetApp.getStringExtra("app_desc");
        String appTime = intentGetApp.getStringExtra("app_time");
        String appDate = intentGetApp.getStringExtra("app_date");

        String a = appName + appDesc ;

        Log.e(a, "ERROR");
        Log.d(a, "DEBUG");

        viewAppName.setText(appName);
        viewAppDesc.setText(appDesc);
        viewAppTime.setText(appTime);
        viewAppDate.setText(appDate);

        ImageButton btnAddMenuFooter = (ImageButton)findViewById(R.id.addmenufooter);
        btnAddMenuFooter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentADF = new Intent(getApplicationContext(), AddMenu.class);
                startActivity(intentADF);
            }
        });

        ImageButton btnViewDocProfFooter = (ImageButton)findViewById(R.id.viewdocfooter);
        btnViewDocProfFooter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVDPF = new Intent (getApplicationContext(), ViewDoctorProf.class);
                startActivity(intentVDPF);
            }
        });

        ImageButton btnAppViewerFooter = (ImageButton)findViewById(R.id.viewappfooter);
        btnAppViewerFooter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long startMillis = System.currentTimeMillis();
                Uri.Builder builder = CalendarContract.CONTENT_URI.buildUpon();
                builder.appendPath("time");
                ContentUris.appendId(builder, startMillis);
                Intent intent = new Intent(Intent.ACTION_VIEW).setData(builder.build());
                startActivity(intent);
            }
        });

//        ImageButton btnSearchDocFooter = (ImageButton)findViewById(R.id.searchdocfooter);
//        btnSearchDocFooter.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intentSDF = new Intent(getApplicationContext(), SearchDoc.class);
//                startActivity(intentSDF);
//            }
//        });

        ImageButton btnViewProfFooter = (ImageButton)findViewById(R.id.viewproffooter);
        btnViewProfFooter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVPF = new Intent (getApplicationContext(), ViewPatientProfile.class);
                startActivity(intentVPF);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_appointment_viewer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
