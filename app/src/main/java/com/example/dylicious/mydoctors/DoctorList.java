package com.example.dylicious.mydoctors;

import android.app.Activity;
import android.app.ListActivity;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.orm.query.Select;

import java.lang.reflect.Array;
import java.util.List;

public class DoctorList extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);

        DatabaseHandler db = new DatabaseHandler(this);

        Log.d("Reading: ", "Reading.....");

        List<Patient> user = db.getAllUser();

        for(Patient usr : user)
        {
            String log = "Id: " + usr.getPatID() + "\n" + "Name: " + usr.getPatName() + "\n" +
                    "Medication: " + usr.getPatMed() + "\n" + "Treatment: " + usr.getPatTreat() +
                    "\n" + "Allergy: " + usr.getPatAllergy();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_doctor_list, menu);
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
