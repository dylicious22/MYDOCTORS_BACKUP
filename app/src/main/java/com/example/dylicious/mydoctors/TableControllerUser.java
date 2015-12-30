package com.example.dylicious.mydoctors;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class TableControllerUser extends DatabaseHandler
{
    public TableControllerUser(Context context)
    {
        super(context);
    }

    public boolean create(Patient user) {

        ContentValues values = new ContentValues();

        values.put("KEY_NAME", user._patname);
        values.put("KEY_TREATMENT", user._pattreat);
        values.put("KEY_MEDICATION", user._patmed);
        values.put("KEY_ALLERGY", user._patallergy);

        SQLiteDatabase db = this.getWritableDatabase();

        boolean createSuccessful = db.insert("User", null, values) > 0;
        db.close();

        return createSuccessful;
    }
}
