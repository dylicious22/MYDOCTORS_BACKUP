package com.example.dylicious.mydoctors;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHandler extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "mydoctors.db";
    private static final String TABLE_USER = "User";
    private static final String TABLE_DOCTOR = "Doctor";

    //Columns for Patients
    private static final String KEY_ID = "pat_id";
    private static final String KEY_NAME = "pat_name";
    private static final String KEY_TREATMENT = "pat_treat";
    private static final String KEY_MEDICATION = "pat_med";
    private static final String KEY_ALLERGY = "pat_allergy";

    //Columns for Doctors
    private static final String KEY_DOCID = "docID";
    private static final String KEY_DOCNAME = "docName";
    private static final String KEY_ADDRESS = "docAdd";
    private static final String KEY_LOCATION = "docLoc";
    private static final String KEY_PHONE = "docPhone";
    private static final String KEY_SPECIALTY = "docSpecialty";
    //private static final String KEY_TIME = "docTime";
    //private static final String KEY_DAY = "docDay";

    public DatabaseHandler(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        Log.e("DATABASE OPERATIONS", "DATABASE CREATED/OPENED...");
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String CREATE_USER_TABLE = " CREATE TABLE " + TABLE_USER + " ( " + KEY_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                KEY_NAME + " TEXT," + KEY_TREATMENT + " TEXT," + KEY_MEDICATION + " TEXT," +
                KEY_ALLERGY + " TEXT," + " ) ";
        db.execSQL(CREATE_USER_TABLE);

        String CREATE_DOCTOR_TABLE = " CREATE TABLE " + TABLE_DOCTOR + " ( " + KEY_DOCID +
                " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_DOCNAME + " TEXT," + KEY_ADDRESS +
                " TEXT," + KEY_LOCATION + " TEXT," + KEY_PHONE + " TEXT," + KEY_SPECIALTY + " TEXT," +" ) ";
        db.execSQL(CREATE_DOCTOR_TABLE);
    }

    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_DOCTOR);
        onCreate(db);
    }

    public void addUser(Patient user)
    {
        SQLiteDatabase db_pat = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, user.getPatName());
        values.put(KEY_TREATMENT, user.getPatTreat());
        values.put(KEY_MEDICATION, user.getPatMed());
        values.put(KEY_ALLERGY, user.getPatAllergy());

        db_pat.insert(TABLE_USER, null, values);
        db.close();
    }

    public void addDoctor (Doctor docs)
    {
        SQLiteDatabase db_docs = this.getWritableDatabase();

        ContentValues docs_value = new ContentValues();
        docs_value.put(KEY_DOCNAME, docs.getDocName());
        docs_value.put(KEY_ADDRESS, docs.getDocAdd());
        docs_value.put(KEY_LOCATION, docs.getDocLoc());
        docs_value.put(KEY_PHONE, docs.getDocNum());
        docs_value.put(KEY_SPECIALTY, docs.getDocSpecialty());

        Log.e("DATABASE OPERATION", "Inserting....");

        db_docs.insert(TABLE_DOCTOR, null, docs_value);
        db_docs.close();

    }

    public Cursor getAllPatData()
    {
        SQLiteDatabase patDB = this.getWritableDatabase();
        Cursor patRes = patDB.rawQuery("SELECT * FROM " + TABLE_USER, null);

        return patRes;
    }


    public List<Patient> getAllUser()
    {
        List<Patient> patientList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_USER;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(TABLE_USER, null, null);

        while (cursor.moveToNext())
        {
            patientList.add(getRec)
        }

//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        if (cursor.moveToFirst())
//        {
//            do
//            {
//                Patient user = new Patient();
//                user.setPatID(cursor.getInt(1));
//                user.setPatName(cursor.getString(1));
//                user.setPatMed(cursor.getString(1));
//                user.setPatTreat(cursor.getString(1));
//                user.setPatAllergy(cursor.getString(1));
//
//                patientList.add(user);
//
//
//            }while (cursor.moveToNext());
//
//
//        }
//        return patientList;
    }

    public int updateUser(Patient user)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("KEY_NAME", user.getPatName());
        values.put("KEY_TREATMENT", user.getPatTreat());
        values.put("KEY_MEDICATION", user.getPatMed());
        values.put("KEY_ALLERGY", user.getPatAllergy());

        return db.update(TABLE_USER, values, KEY_ID + " = ?" , new String[]
                {String.valueOf(user.getPatID())});

    }

    public void deleteAllUser(String pat_Name, String pat_Treatment, String pat_Medication, String pat_Allergy)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE * FROM " + TABLE_USER);

        db.close();
    }

    //delete a user
    public void deleteUser(String pat_Name, String pat_Treatment, String pat_Medication, String pat_Allergy)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(" DELETE FROM " + TABLE_USER + " WHERE " + KEY_NAME + "=\"" + pat_Name + "\";");
    }

    //print database to String
    public String databasetoString()
    {
        String userDBString = " ";
        SQLiteDatabase db = this.getWritableDatabase();
        String userQuery = " SELECT * FROM " + TABLE_USER + " WHERE 1";

        //Cursor
        Cursor c = db.rawQuery(userQuery, null);
        //
        c.moveToFirst();

        while (!c.isAfterLast())
        {
            if(c.getString(c.getColumnIndex()))
        }


    }

    public int getUserCounts()
    {
        String countQuery = "SELECT * FROM " + TABLE_USER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }

}
