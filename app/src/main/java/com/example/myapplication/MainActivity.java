package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.adapter.UserAdapter;
import com.example.myapplication.models.UserData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton btn_add;
    ArrayList<UserData> data = new ArrayList();

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add = findViewById(R.id.addBtn);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddActivity.class);
                startActivity(intent);

            }
        });

        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);
        UserAdapter adapter = new UserAdapter(this, data);
        recyclerView.setAdapter(adapter);

        DatabaseHandler db = new DatabaseHandler(this);

        List<Contact> contacts = db.getAllContacts();
        adapter.notifyDataSetChanged();

        for (Contact cn : contacts) {
            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " +
                    cn.getPhoneNumber();
            // Writing Contacts to log
            Log.d("Name: ", log);
            data.add(new UserData(cn.getName(),cn.getPhoneNumber()));

        }

        adapter.notifyDataSetChanged();

    }

}