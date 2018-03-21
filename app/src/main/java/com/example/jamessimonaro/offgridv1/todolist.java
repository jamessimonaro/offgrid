package com.example.jamessimonaro.offgridv1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;


public class todolist extends AppCompatActivity {

    public Context k;

    ArrayAdapter<String> adapter;
    EditText editText;
    ArrayList<String> itemList;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todolist);

        k = this;

        /*
        Testing SQL Lite.. Still not working

        String DB = "to_do_list_database";

        //create database
        create_database(DB);

        //create table
        String table_details = "(item VARCHAR)";
        create_table("todo", table_details, DB);

        //insert some information
        String insert_command = "INSERT INTO todo (item 'Do 498 homework')";

        table_operation(insert_command, DB);

        //select out information
        String output;
        output = select_data_from_table_to_string("select * from test", DB);
        itemList.add(output);

        */


        //Default items in the to-do list
        String[] items={"Do 498 homework","Go to the gym","Cook dinner"};
        itemList=new ArrayList<String>(Arrays.asList(items));
        adapter=new ArrayAdapter<String>(this,R.layout.list_item,R.id.txtview,itemList);
        ListView listV=(ListView)findViewById(R.id.list);
        listV.setAdapter(adapter);

        //Wire GUI Components to Java
        editText=(EditText)findViewById(R.id.txtInput);
        Button btAdd=(Button)findViewById(R.id.btAdd);


        btAdd.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {     additem();       }});}


              public void additem() {

                  //Get user entry
                  String newItem = editText.getText().toString();

                  // add new item to array list
                  itemList.add(newItem);

                  // notify list view of data changed
                  adapter.notifyDataSetChanged();

                  //Remove item from textbox after added
                  editText.setText("");
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



}

