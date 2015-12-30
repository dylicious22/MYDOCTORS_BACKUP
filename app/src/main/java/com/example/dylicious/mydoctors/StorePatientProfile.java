package com.example.dylicious.mydoctors;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class StorePatientProfile extends Activity {

    EditText inputUserName;
    EditText inputUserMed;
    EditText inputUserTreatment;
    EditText inputUserAllergy;
    DatabaseHandler patDBHandler;
    Button btnSaveUserProfile;
    Button btnViewUserProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_patient_profile);
        setTitle("User Profile");

        patDBHandler = new DatabaseHandler(this);
        inputUserName = (EditText)findViewById(R.id.patname);
        inputUserMed = (EditText)findViewById(R.id.patmed);
        inputUserTreatment = (EditText)findViewById(R.id.pattreatment);
        inputUserAllergy = (EditText)findViewById(R.id.patallergy);
        btnSaveUserProfile = (Button)findViewById(R.id.savepat);
        btnViewUserProfile = (Button)findViewById(R.id.viewpatall);
        addPatient();
//        btnSaveUserProfile.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intentVPF = new Intent(getApplicationContext(), ViewPatientProfile.class);
//
////
//
//                //send data to next screen
//                intentVPF.putExtra("patname", inputUserName.getText().toString());
//                intentVPF.putExtra("patmed", inputUserMed.getText().toString());
//                intentVPF.putExtra("pattreatment", inputUserTreatment.getText().toString());
//                intentVPF.putExtra("patallergy", inputUserAllergy.getText().toString());
//
//
//                    String a = inputUserName.getText() + "." + inputUserMed.getText() + "." +
//                            inputUserTreatment.getText() + "." + inputUserAllergy.getText();
//
//                    startActivity(intentVPF);
//                }
//            });
        }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_store_patient_profile, menu);
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

    public void addPatient ()
    {
        btnSaveUserProfile.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                patDBHandler.addUser(inputUserName.getText().toString(),
                        inputUserTreatment.getText().toString(),
                        inputUserMed.getText().toString(), inputUserAllergy.getText().toString());

            }
        });

    }


}
