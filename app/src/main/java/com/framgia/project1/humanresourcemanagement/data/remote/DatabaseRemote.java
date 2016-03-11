package com.framgia.project1.humanresourcemanagement.data.remote;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.framgia.project1.humanresourcemanagement.data.local.DataBaseHelper;
import com.framgia.project1.humanresourcemanagement.data.model.Department;
import com.framgia.project1.humanresourcemanagement.data.model.Staff;

import java.sql.SQLData;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nguyenxuantung on 11/03/2016.
 */
public class DatabaseRemote {

    private SQLiteDatabase database;
    private DataBaseHelper dbHelper;

    public DatabaseRemote(Context context) {
        dbHelper = new DataBaseHelper(context);
    }

    //open database
    public void openDataBase() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    //close database
    public void closeDataBase() throws SQLException {
        database.close();
    }

    //insert data into table department
    public boolean insertDepartment(Department department) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseHelper.COLUMN_NAME_DEPARTMENT, department.getName());
        contentValues.put(DataBaseHelper.COLUMN_IMAGE_DEPARTMENT, department.getImage());
        try {
            long result = database.insertOrThrow(DataBaseHelper.TABLE_DEPARTMENT, null, contentValues);
        }catch (Exception e){
            return false;
        }

        return true;
    }

    // get list of department
    public List<Department> getDepartmentList() {
        String quey = "select * from " + DataBaseHelper.TABLE_DEPARTMENT;
        Cursor cursor = database.rawQuery(quey, null);
        List<Department> departmentList = new ArrayList<>();
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();

            while (!cursor.isAfterLast()) {
                int id = cursor.getInt(cursor.getColumnIndex(DataBaseHelper.COLUMN_ID_DEPARTMENT));
                String name = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COLUMN_NAME_DEPARTMENT));
                String image = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COLUMN_IMAGE_DEPARTMENT));
                Department de = new Department(name, id, image);
                departmentList.add(de);
                cursor.moveToNext();

            }
            cursor.close();
        }
        return departmentList;
    }

    //delete a record in department
    public boolean deleteDepartment(int id) {
        try {
            database.delete(DataBaseHelper.TABLE_DEPARTMENT, DataBaseHelper.COLUMN_ID_DEPARTMENT + " = " + id, null);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    //insert a record into table staff
    public boolean insertStaff(Staff staff) {
        ContentValues values = new ContentValues();
        values.put(DataBaseHelper.COLUMN_ID_DEPARTMENT, staff.getIdDepartment());
        values.put(DataBaseHelper.COLUMN_NAME_STAFF, staff.getName());
        values.put(DataBaseHelper.COLUMN_PHONENUMBER, staff.getPhoneNumber());
        values.put(DataBaseHelper.COLUMN_PLACEOFBIRTH, staff.getPlaceOfBirth());
        values.put(DataBaseHelper.COLUMN_POSITION, staff.getPosition());
        values.put(DataBaseHelper.COLUMN_STATUS, staff.getStatus());
        values.put(DataBaseHelper.COLUMN_AVATAR, staff.getImageAvatar());
        values.put(DataBaseHelper.COLUMN_BIRTHDAY, staff.getBirthday());
        try {
            long result = database.insertOrThrow(DataBaseHelper.TABLE_STAFF, null, values);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    //get list of staff
    public List<Staff> getListStaff() {
        String query = "select * from " + DataBaseHelper.TABLE_STAFF;
        Cursor cursor = database.rawQuery(query, null);
        cursor.moveToFirst();
        List<Staff> staffList = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            int id = cursor.getInt(cursor.getColumnIndex(DataBaseHelper.COLUMN_ID_STAFF));
            int id_department = cursor.getInt(cursor.getColumnIndex(DataBaseHelper.COLUMN_ID_STAFF));
            int status = cursor.getInt(cursor.getColumnIndex(DataBaseHelper.COLUMN_ID_STAFF));
            int position = cursor.getInt(cursor.getColumnIndex(DataBaseHelper.COLUMN_ID_STAFF));
            String name = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COLUMN_NAME_STAFF));
            String birthDay = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COLUMN_BIRTHDAY));
            String placeOfBirth = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COLUMN_PLACEOFBIRTH));
            String phoneNumber = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COLUMN_PHONENUMBER));
            String avatar = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COLUMN_AVATAR));

            Staff staff = new Staff(id, id_department, status, position, name, birthDay, placeOfBirth, phoneNumber, avatar);
            staffList.add(staff);

            cursor.moveToNext();
        }
        cursor.close();
        return staffList;
    }

    //delete a record in staff
    public boolean deleteStaff(int id) {
        try {
            database.delete(DataBaseHelper.TABLE_STAFF, DataBaseHelper.COLUMN_ID_STAFF + " = " + id, null);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
