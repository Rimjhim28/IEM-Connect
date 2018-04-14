package com.example.android.iemconnect;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class EnterDetailsActivity extends AppCompatActivity {

    EditText txtName, txtDept, txtContact, txtTech1, txtTech2, txtTech3;
    Button btnDone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_details);

        txtName = findViewById(R.id.txt_name);
        txtContact = findViewById(R.id.txt_contact);
        txtDept = findViewById(R.id.txt_dept);
        txtTech1 = findViewById(R.id.tech_1);
        txtTech2 = findViewById(R.id.tech_2);
        txtTech3 = findViewById(R.id.tech_3);
        btnDone = findViewById(R.id.btn_done);
    }
}
