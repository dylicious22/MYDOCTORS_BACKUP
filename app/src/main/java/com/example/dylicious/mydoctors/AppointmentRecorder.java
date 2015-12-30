package com.example.dylicious.mydoctors;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AppointmentRecorder extends Activity {

    EditText inputAppName;
    EditText inputAppDesc;
    EditText inputAppTime;
    EditText inputAppDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_recorder);

        inputAppName = (EditText)findViewById(R.id.app_name);
        inputAppDesc = (EditText)findViewById(R.id.app_desc);
        inputAppTime = (EditText)findViewById(R.id.app_time);
        inputAppDate = (EditText)findViewById(R.id.app_date);

        Button btnSaveApp = (Button)findViewById(R.id.saveapp);
        btnSaveApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAV = new Intent (getApplicationContext(), AppointmentViewer.class);

                //send data to next screen
                intentAV.putExtra("app_name", inputAppName.getText().toString());
                intentAV.putExtra("app_desc", inputAppDesc.getText().toString());
                intentAV.putExtra("app_time", inputAppTime.getText().toString());
                intentAV.putExtra("app_date", inputAppDate.getText().toString());

                String a = inputAppName.getText() + "." + inputAppDesc.getText() + "." +
                        inputAppTime.getText() + "." + inputAppDate.getText();

                Log.e(a, "ERROR");
                Log.d(a, "DEBUG");

                startActivity(intentAV);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_appointment_recorder, menu);
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
