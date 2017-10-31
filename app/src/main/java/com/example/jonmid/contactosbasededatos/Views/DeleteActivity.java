package com.example.jonmid.contactosbasededatos.Views;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jonmid.contactosbasededatos.ContactsActivity;
import com.example.jonmid.contactosbasededatos.Helpers.SqliteHelper;
import com.example.jonmid.contactosbasededatos.Models.Contact;
import com.example.jonmid.contactosbasededatos.R;

import java.util.ArrayList;
import java.util.List;

public class DeleteActivity extends AppCompatActivity {

    TextView textViewid;
    TextView textViewname;
    TextView textViewphone;
    TextView textViewemail;
    SqliteHelper sqliteHelper;
    List<Contact> contactList = new ArrayList<>();
    RecyclerView recyclerView;
    ContactsActivity contactsActivity;
    public int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        textViewid= (TextView) findViewById(R.id.id_tv_delete_id);
        textViewname= (TextView) findViewById(R.id.id_tv_delete_name);
        textViewphone= (TextView) findViewById(R.id.id_tv_delete_phone);
        textViewemail= (TextView) findViewById(R.id.id_tv_delete_email);

        sqliteHelper= new SqliteHelper(this,"db_users",null,1);

        textViewid.setText(Integer.toString(getIntent().getExtras().getInt("id")));
        textViewname.setText(getIntent().getExtras().getString("name"));
        textViewphone.setText(getIntent().getExtras().getString("phone"));
        textViewemail.setText(getIntent().getExtras().getString("email"));
        //contactsActivity.processData();

    }
    public void goActivityCancel(View view){
        Intent intent = new Intent(this, ContactsActivity.class);
        startActivity(intent);
    }


    public  void onClickDeleteContact(View view){
        //Toast.makeText(this,"mi id:" + id,Toast.LENGTH_SHORT).show();

       id  = getIntent().getExtras().getInt("id");
        SQLiteDatabase db  =sqliteHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("delete from users where id ='"+ id +"'",null);
       cursor.close();
       Toast.makeText(this,"Contacto eliminado",Toast.LENGTH_SHORT).show();
        Contact contact = new Contact();
        contact.setId(cursor.getInt(0));
        contact.setName(cursor.getString(1));
        contact.setPhone(cursor.getString(2));
        contact.setEmail(cursor.getString(3));
        contactList.remove(contact);
        goActivityCancel(view);


    }
}
