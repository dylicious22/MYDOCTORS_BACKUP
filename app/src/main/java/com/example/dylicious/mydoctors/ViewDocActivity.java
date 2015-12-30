package com.example.dylicious.mydoctors;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.database.sqlite.*;

public class ViewDocActivity extends Activity
{
    EditText inputDocName;
    EditText inputDocAddress;
    EditText inputLoc;
    EditText inputSpecialty;
    EditText inputPhoneNumber;
    EditText inputDate;
    EditText inputTime;
    Button promptDateBtn;
    Button promptTimeBtn;
    final Context context = this;

    DatePickerDialog dateConsult;
    TimePickerDialog timeConsult;

    SimpleDateFormat dateFormatter;

    static final int TIME_DIALOG_ID = 999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_doc);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        inputDocName = (EditText)findViewById(R.id.docname);
        inputDocAddress = (EditText)findViewById(R.id.docadd);
        inputLoc = (EditText)findViewById(R.id.docloc);
        inputSpecialty = (EditText)findViewById(R.id.docspecialty);
        inputPhoneNumber = (EditText)findViewById(R.id.docnum);


        Button saveDocDtl = (Button)findViewById(R.id.proceed2);
        saveDocDtl.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                Intent intentVD2 = new Intent(getApplicationContext(), ViewDoc2.class);

//                docTable.save();

                //send data to next screen
//                intentVD2.putExtra("docname", inputDocName.getText().toString());
//                intentVD2.putExtra("docadd", inputDocAddress.getText().toString());
//                intentVD2.putExtra("docloc", inputLoc.getText().toString());
//                intentVD2.putExtra("docspecialty", inputSpecialty.getText().toString());
//                intentVD2.putExtra("docnum", inputPhoneNumber.getText().toString());



//                String a = inputDocName.getText() + "." + inputDocAddress.getText() + "." +
//                        inputLoc.getText() + "." + inputSpecialty.getText() + "." +
//                        inputPhoneNumber.getText();
//                Log.e(a, "ERROR");
//                Log.d(a, "DEBUG MODE");

                startActivity(intentVD2);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_doc, menu);
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
