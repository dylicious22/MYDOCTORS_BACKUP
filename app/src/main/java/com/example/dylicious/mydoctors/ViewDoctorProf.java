package com.example.dylicious.mydoctors;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class ViewDoctorProf extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_doctor_prof);

        //declare textview
        TextView viewDocName = (TextView)findViewById(R.id.docnameview);
        TextView viewDocLoc = (TextView)findViewById(R.id.doclocview);
        TextView viewDocAdd = (TextView)findViewById(R.id.docaddview);
        TextView viewDocNum = (TextView)findViewById(R.id.docnumview);
        TextView viewDocSpecialty = (TextView)findViewById(R.id.docspecialtyview);

        //retrieving data
        Intent intentGet = getIntent();
        String docname = intentGet.getStringExtra("docname");
        String docloc = intentGet.getStringExtra("docloc");
        String docadd = intentGet.getStringExtra("docadd");
        String docnum = intentGet.getStringExtra("docnum");
        String docspecialty = intentGet.getStringExtra("docspecialty");

        //log
        String a = docname+ "." + docloc + "." + docadd + "." + docnum + "." + docspecialty;
        Log.e(a, "ERROR");
        Log.d(a, "DEBUG MODE");

        viewDocName.setText(docname);
        viewDocSpecialty.setText(docspecialty);
        viewDocLoc.setText(docloc);
        viewDocNum.setText(docnum);
        viewDocAdd.setText(docadd);

        setTitle("Dr. " + docname +"'s Profile");

        ImageButton btnAddMenuFooter = (ImageButton)findViewById(R.id.addmenufooter);
        btnAddMenuFooter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAMF = new Intent(getApplicationContext(), AddMenu.class);
                startActivity(intentAMF);
            }
        });


        ImageButton btnDocProfFooter = (ImageButton)findViewById(R.id.viewdocfooter);
        btnDocProfFooter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVDPF = new Intent(getApplicationContext(), ViewDoctorProf.class);
                startActivity(intentVDPF);
            }
        });

        ImageButton btnAppViewer = (ImageButton)findViewById(R.id.viewappfooter);
        btnAppViewer.setOnClickListener(new View.OnClickListener() {
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

        ImageButton btnUserProfileFooter = (ImageButton)findViewById(R.id.viewproffooter);
        btnUserProfileFooter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentUPF = new Intent(getApplicationContext(), ViewPatientProfile.class);
                startActivity(intentUPF);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_doctor_prof, menu);
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
