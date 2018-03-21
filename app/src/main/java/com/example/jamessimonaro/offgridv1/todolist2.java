package com.example.jamessimonaro.offgridv1;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class todolist2 extends AppCompatActivity {

    //Initialize variables and GUI components
    public Context k;
    String insert_command;
    String DB = "to_do_list_database";
    String output;
    TextView to_do_list_;
    EditText txtInput_;
    String newItem;
    Button btAdd2_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todolist2);

        //Wire GUI components to Java
        to_do_list_=(TextView) findViewById(R.id.to_do_list);
        txtInput_=(EditText)findViewById(R.id.txtInput);
        btAdd2_=(Button)findViewById(R.id.btAdd2);

        //Onclick listener for Add button
        btAdd2_.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {  additem();     }});

        k = this;

        //database initialization
        //create database
        create_database(DB);

        //create table
        String table_details = "(item VARCHAR)";
        create_table("todo", table_details, DB);

        //display the current to-do's
        //set text view to new input
        output = select_data_from_table_to_string("select * from todo", DB);
        to_do_list_.setText(output);


    }

    public void additem() {

        //Get user entry
        newItem = txtInput_.getText().toString();

        //insert command for sqlite
        insert_command = "INSERT INTO todo (item) VALUES('"+  newItem + "')";

        //insert data to database
        table_operation(insert_command, DB);

        //set text view to new input
        output = select_data_from_table_to_string("select * from todo", DB);
        to_do_list_.setText(output);

        //Remove item from textbox after added
        txtInput_.setText("");

        //hide keyboard
        hidekeyboard(this);
    }


    public void create_database(String database_name)
    {
        //utility function to create a database

        SQLiteDatabase myDB= null;
        myDB = k.openOrCreateDatabase("database_name", MODE_PRIVATE, null);

        //close database
        if (myDB != null) myDB.close();
    }

    public void create_table(String table_name, String table_details, String database_name )
    {
        //utility function to create a table
        //usage:
        //		string table_details = "(person_id INT(4), firstname VARCHAR, lastname VARCHAR)"
        //		create_table(table_name, table_details, database_name);

        //open database
        SQLiteDatabase myDB;
        myDB = k.openOrCreateDatabase(database_name, MODE_PRIVATE, null);

        myDB.execSQL("CREATE TABLE IF NOT EXISTS "
                + table_name
                + " " + table_details + ";");

        //close database
        if (myDB != null) myDB.close();
    }

    public void table_operation(String command, String database_name)
    {
        //utility function to execute a SQL command on a table
        //usage:
        //		string insert_command = "INSERT INTO table_name (person_id, firstname, lastname) VALUES (1, 'Greg', 'Erickson')"
        //		table_operation(insert_command, database_name);

        //		string delete_command = "DELETE from table_name WHERE firstname = 'frank'"
        //		table_operation(delete_command, database_name);

        //		string update_command = "UPDATE table_name SET firstname = 'Gregg' WHERE firstname = 'Greg'"
        //		table_operation(update_command, database_name);

        //open database
        SQLiteDatabase myDB;
        myDB = k.openOrCreateDatabase(database_name, MODE_PRIVATE, null);

        myDB.execSQL(command + ";");

        //close database
        if (myDB != null) myDB.close();
    }

    public String select_data_from_table_to_string(String select_statement, String database_name)
    {
        //utility function to select and return information from the database
        //usage:
        //		String output = select_data_from_table_to_string("select * from test", database_name);

        //open database
        SQLiteDatabase myDB;
        myDB = k.openOrCreateDatabase(database_name, MODE_PRIVATE, null);

        String ShowData = "";

		/*Fetch data from database table */
        Cursor c = myDB.rawQuery(select_statement , null);
        int no_columns = c.getColumnCount();

        // Check result.
        c.moveToFirst();
        if (c != null)
        {
            do // Loop through all Results
            {
                for (int n=0; n< no_columns; n++)  //for each column
                {
                    ShowData = ShowData + " " + c.getString(n);
                }
                ShowData = ShowData + System.getProperty("line.separator"); //better than \n
            }
            while(c.moveToNext()); //move to the next record
        }

        //close database
        if (myDB != null) myDB.close();

        return ShowData.trim(); //trim any end white-space
    }


    public static void hidekeyboard(Activity activity){
        //hide keyboard method
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}
