package com.example.contactsqlite.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.contactsqlite.R;
import com.example.contactsqlite.model.Contact;

import org.w3c.dom.Text;

import java.util.List;

public class ContactAdapter extends BaseAdapter {

    private Context context;
    private List<Contact> dataSource;
    private LayoutInflater layoutInflater;

    public ContactAdapter(Context context, List<Contact> dataSource) {
        this.context = context;
        this.dataSource = dataSource;
        this.layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return dataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return dataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // ViewHolder
        convertView = layoutInflater.inflate(R.layout.item_contact, parent,false);
        // Bind Id
        TextView tvName = convertView.findViewById(R.id.tv_item_contact_name);
        TextView tvPhone = convertView.findViewById(R.id.tv_item_contact_phone);
        // Do du lieu: Contact vi tri position => view contact tai position
        Contact contact = (Contact) getItem(position);
        tvName.setText(contact.getName());
        tvPhone.setText(contact.getPhone());
        return convertView;
    }
}
