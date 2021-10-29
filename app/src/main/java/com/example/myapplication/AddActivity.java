package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.models.UserData;

import java.util.ArrayList;

public class AddActivity extends AppCompatActivity {
    private Button btn_save;
    private EditText user_name, user_number;
    ArrayList<UserData> data = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        btn_save = findViewById(R.id.btn_save);
        user_name = findViewById(R.id.edit_text_name);
        user_number = findViewById(R.id.edit_text_phone_number);

        DatabaseHandler db = new DatabaseHandler(this);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = user_name.getText().toString().trim();
                String phone_number = user_number.getText().toString().trim();

                db.addContact(new Contact(name,phone_number));

                Intent intent = new Intent(AddActivity.this,MainActivity.class);
                intent.putExtra("NAME",name);
                intent.putExtra("NUMBER",phone_number);

                startActivity(intent);
                finish();

            }
        });



    }
}