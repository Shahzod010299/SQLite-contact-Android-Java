package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btn_save;
    private EditText user_name, user_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);

        btn_save = findViewById(R.id.btn_save);
        user_name = findViewById(R.id.edit_text_name);
        user_number = findViewById(R.id.edit_text_phone_number);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = user_name.getText().toString().trim();
                String phone_number = user_number.getText().toString().trim();

                // Inserting Contacts
                Log.d("Insert: ", "Inserting ..");
                Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();

                db.addContact(new Contact(name, phone_number));

            }
        });

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.getAllContacts();

        for (Contact cn : contacts) {
            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " +
                    cn.getPhoneNumber();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }
    }
}