package com.example.jonmid.contactosbasededatos.Utilities;

/**
 * Created by jonmid on 26/10/17.
 */

public class Constants {
    public static final String TABLA_NAME_USERS = "users";
    public static final String TABLA_FIELD_ID = "id";
    public static final String TABLA_FIELD_NAME = "name";
    public static final String TABLA_FIELD_PHONE = "phone";
    public static final String TABLA_FIELD_EMAIL = "email";
    public static final String CREATE_TABLE_USERS =
            "CREATE TABLE "+ TABLA_NAME_USERS+" ("+
                TABLA_FIELD_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    TABLA_FIELD_NAME+" TEXT, "+
                    TABLA_FIELD_PHONE+" TEXT, "+
                    TABLA_FIELD_EMAIL+" TEXT)";
}
