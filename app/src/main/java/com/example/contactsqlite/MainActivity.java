package com.example.contactsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.contactsqlite.adapter.ContactAdapter;
import com.example.contactsqlite.database.ContactDAO;
import com.example.contactsqlite.database.ContactDbHelper;
import com.example.contactsqlite.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvContacts;
    private ContactAdapter contactAdapter;
    private List<Contact> dataSource;
    private ContactDbHelper dbHelper;
    private ContactDAO contactDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvContacts = findViewById(R.id.lv_contacts);
        dataSource = new ArrayList<>();
        dbHelper = new ContactDbHelper(this);
        contactDAO = new ContactDAO(dbHelper);

        // listview da hoat dong -> can load du lieu tu SQLite..
        // Them 1 vai ban ghi => lay ra tu db
//        contactDAO.insertContact(new Contact("Contact 1","0123456789"));
//        contactDAO.insertContact(new Contact("Contact 2","0123456788"));
//        contactDAO.insertContact(new Contact("Contact 3","0123456787"));

        // Lay tu db ra
        dataSource = contactDAO.getAll();


        // setAdapter cho listview
        contactAdapter = new ContactAdapter(this, dataSource);
        lvContacts.setAdapter(contactAdapter);
    }


    @Override
    protected void onDestroy() {
        dbHelper.close();
        super.onDestroy();
    }

    public void showDialog(View view) {
        // Hien thi dialog nhap du lieu lien he

    }
}