package com.example.jonmid.contactosbasededatos.Views;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.jonmid.contactosbasededatos.ContactsActivity;
import com.example.jonmid.contactosbasededatos.Helpers.SqliteHelper;
import com.example.jonmid.contactosbasededatos.R;
import com.example.jonmid.contactosbasededatos.Utilities.Constants;

public class RegisterContactActivity extends AppCompatActivity {

    TextInputEditText textInputEditTextName;
    TextInputEditText textInputEditTextPhone;
    TextInputEditText textInputEditTextEmail;
    SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_contact);

        textInputEditTextName = (TextInputEditText) findViewById(R.id.id_tv_detail_name);
        textInputEditTextPhone = (TextInputEditText) findViewById(R.id.id_tv_detail_phone);
        textInputEditTextEmail = (TextInputEditText) findViewById(R.id.id_tv_detail_email);

        sqliteHelper = new SqliteHelper(this, "db_contacts", null, 1);
    }

    public void onClickCreateUser(View view){
        String stringName = textInputEditTextName.getText().toString();
        String stringPhone = textInputEditTextPhone.getText().toString();
        String stringEmail = textInputEditTextEmail.getText().toString();

        if (TextUtils.isEmpty(stringName)){
            Toast.makeText(this, "El campo de nombre esta vacio", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(stringPhone)){
            Toast.makeText(this, "El campo de telefono esta vacio", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(stringEmail)){
            Toast.makeText(this, "El campo de email esta vacio", Toast.LENGTH_SHORT).show();
        }else{
            createUser();
        }
    }

    public void createUser(){
        SQLiteDatabase db = sqliteHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Constants.TABLA_FIELD_NAME, textInputEditTextName.getText().toString());
        values.put(Constants.TABLA_FIELD_PHONE, textInputEditTextPhone.getText().toString());
        values.put(Constants.TABLA_FIELD_EMAIL, textInputEditTextEmail.getText().toString());

        Long idResult = db.insert(Constants.TABLA_NAME_USERS, Constants.TABLA_FIELD_ID, values);

        textInputEditTextName.setText("");
        textInputEditTextPhone.setText("");
        textInputEditTextEmail.setText("");

        Toast.makeText(this, "El contacto se registro correctamente", Toast.LENGTH_SHORT).show();
        goActivityOne();

    }

    public void goActivityOne(){
        Intent intent = new Intent(this, ContactsActivity.class);
        startActivity(intent);
    }
}
