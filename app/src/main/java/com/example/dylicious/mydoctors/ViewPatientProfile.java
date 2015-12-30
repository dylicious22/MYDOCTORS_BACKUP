package com.example.dylicious.mydoctors;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class ViewPatientProfile extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_patient_profile);

        //declare TextView
        TextView viewPatName = (TextView)findViewById(R.id.patnameview);
        TextView viewPatMed = (TextView)findViewById(R.id.patmedview);
        TextView viewPatTreatment = (TextView)findViewById(R.id.pattreatmentview);
        TextView viewPatAllergy = (TextView)findViewById(R.id.patallergyview);

        Intent intentGetPat = getIntent();

        String patName = intentGetPat.getStringExtra("patname");
        String patMed = intentGetPat.getStringExtra("patmed");
        String patTreatment = intentGetPat.getStringExtra("pattreatment");
        String patAllergy = intentGetPat.getStringExtra("patallergy");

        String a = patName + patMed + patTreatment + patAllergy;

        Log.e(a, "ERROR");
        Log.d(a, "DEBUG");

        viewPatName.setText(patName);
        viewPatMed.setText(patMed);
        viewPatTreatment.setText(patTreatment);
        viewPatAllergy.setText(patAllergy);

        if (patName == null)
        {
            setTitle("User Profile");
        }
        else
        {
            setTitle(patName + "'s Profile");
        }

        ImageButton btnEditUserProfile = (ImageButton)findViewById(R.id.edituser);
        btnEditUserProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intentEUP = new Intent(getApplicationContext(), StorePatientProfile.class);
//                startActivity(intentEUP);
                finish();
            }
        });

        ImageButton btnAddMenuFooter = (ImageButton)findViewById(R.id.addmenufooter);
        btnAddMenuFooter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAMF = new Intent(getApplicationContext(), AddMenu.class);
                startActivity(intentAMF);
            }
        });

        ImageButton btnViewDocFooter = (ImageButton)findViewById(R.id.viewdocfooter);
        btnViewDocFooter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVDF = new Intent (getApplicationContext(), ViewDoctorProf.class);
                startActivity(intentVDF);
            }
        });

        ImageButton btnAppViewFooter = (ImageButton)findViewById(R.id.viewappfooter);
        btnAppViewFooter.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
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
//                Intent intentSDF = new Intent (getApplicationContext(), SearchDoc.class);
//                startActivity(intentSDF);
//            }
//        });

        ImageButton btnViewProfileFooter = (ImageButton)findViewById(R.id.viewproffooter);
        btnViewProfileFooter.setOnClickListener(new View.OnClickListener() {
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
        getMenuInflater().inflate(R.menu.menu_view_patient_profile, menu);
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
