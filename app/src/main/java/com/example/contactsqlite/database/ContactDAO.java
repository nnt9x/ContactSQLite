package com.example.contactsqlite.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.contactsqlite.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactDAO {
    // Them, sua, xoa, truy van bang contact
    private ContactDbHelper dbHelper;

    public ContactDAO(ContactDbHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    // Them contact
    public Contact insertContact(Contact contact) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", contact.getName());
        contentValues.put("phone", contact.getPhone());
        long id = db.insert("contacts", null, contentValues);
        contact.setId(id);
        return contact;
    }

    // Xoa lien he: true xoa thanh cong, false - that bai
    public boolean deleteById(long id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String where = " id = " + id;
        int rs = db.delete("contacts", where, null);
        if (rs == 0) return false;
        return true;
    }

    // Sua lien he (da co id)
    public boolean editContact(Contact contact) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", contact.getName());
        contentValues.put("phone", contact.getPhone());
        String where = " id = " + contact.getId();

        int rs = db.update("contacts", contentValues, where, null);
        if (rs == 0) {
            return false;
        }
        return true;
    }
    // Doc du lieu
    public List<Contact> getAll(){
        List<Contact> contacts = new ArrayList<>();
        // Truy van
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("contacts",null,null,null,null,null,null);

        while(cursor.moveToNext()) {
            Contact contact = new Contact();
            contact.setId(cursor.getLong(0));
            contact.setName(cursor.getString(1));
            contact.setPhone(cursor.getString(2));
            contacts.add(contact);
        }
        cursor.close();

        return contacts;
    }

}
