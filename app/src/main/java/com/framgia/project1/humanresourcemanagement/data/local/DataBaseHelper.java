package com.framgia.project1.humanresourcemanagement.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nguyenxuantung on 11/03/2016.
 */
public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "staffManager.db"; // name of database
    private static final int DATABASE_VERSION = 1; // database version

    // department table's name
    public static final String TABLE_DEPARTMENT = "tblDepartment";

    // staff table's name
    public static final String TABLE_STAFF= "tblStaff";

    // columns of tblDepartment
    public static final String COLUMN_ID_DEPARTMENT = "idDep";
    public static final String COLUMN_NAME_DEPARTMENT = "nameDep";
    public static final String COLUMN_IMAGE_DEPARTMENT = "imageDep";

    //columns of tblStaff
    public static final String COLUMN_ID_STAFF="idSta";
    public static final String COLUMN_NAME_STAFF="nameSta";
    public static final String COLUMN_PLACEOFBIRTH="placeOfBirth";
    public static final String COLUMN_BIRTHDAY="birthDay";
    public static final String COLUMN_PHONENUMBER="phoneNumber";
    public static final String COLUMN_STATUS="status";
    public static final String COLUMN_POSITION="position";
    public static final String COLUMN_AVATAR="avatar";

    //create table department
    private static final String CREATE_TABLE_DEPARTMENT="create table "+TABLE_DEPARTMENT+" ( "
            +COLUMN_ID_DEPARTMENT +" integer primary key autoincrement,"
            +COLUMN_NAME_DEPARTMENT+" text,"
            +COLUMN_IMAGE_DEPARTMENT+" text)";
    //create table staff
    private static final String CREATE_TABLE_STAFF="create table "+TABLE_STAFF+" ( "
            +COLUMN_ID_STAFF+" integer primary key autoincrement, "
            + COLUMN_NAME_STAFF+" text,"
            + COLUMN_PLACEOFBIRTH+" text,"
            + COLUMN_BIRTHDAY+" text,"
            + COLUMN_PHONENUMBER+" text,"
            + COLUMN_STATUS+" integer,"
            + COLUMN_POSITION+" integer,"
            + COLUMN_AVATAR+" text,"
            + COLUMN_ID_DEPARTMENT+" integer)";
    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_DEPARTMENT);
        sqLiteDatabase.execSQL(CREATE_TABLE_STAFF);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+TABLE_DEPARTMENT );
        sqLiteDatabase.execSQL("drop table if exists "+TABLE_STAFF);
        onCreate(sqLiteDatabase);
    }
}
