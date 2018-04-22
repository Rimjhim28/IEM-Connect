package com.example.android.iemconnect;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EnterDetailsActivity extends AppCompatActivity {

    EditText txtName, txtDept, txtEnrollNum, txtContact, txtTech1, txtTech2, txtTech3;
    Button btnDone, btn;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference();
    int count = 0;
    String query = "Android";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_details);

        txtName = findViewById(R.id.txt_name);
        txtContact = findViewById(R.id.txt_contact);
        txtDept = findViewById(R.id.txt_dept);
        txtEnrollNum = findViewById(R.id.txt_enroll_num);
        txtTech1 = findViewById(R.id.tech_1);
        txtTech2 = findViewById(R.id.tech_2);
        txtTech3 = findViewById(R.id.tech_3);
        btnDone = findViewById(R.id.btn_done);
        btn = findViewById(R.id.button);

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeInDatabase();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EnterDetailsActivity.this, SearchResults.class);
                startActivity(intent);
            }
        });
    }

    void writeInDatabase(){
        User mUser = new User(txtName.getText().toString(),txtContact.getText().toString(), txtDept.getText().toString(),txtTech1.getText().toString(),txtTech2.getText().toString(),txtTech3.getText().toString());
        DatabaseReference usersRef = ref.child("users");
        usersRef.child(txtEnrollNum.getText().toString()).setValue(mUser);
    }

    void readFromDatabase(){
        final ArrayList<User> users  = new ArrayList<>();
        ref.child("users").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Iterable<DataSnapshot> snapshotIterator = dataSnapshot.getChildren();
                Iterator<DataSnapshot> iterator = snapshotIterator.iterator();
                while (iterator.hasNext()){
                    User user = iterator.next().getValue(User.class);
                    users.add(user);
                }
                for( count = 0; count < users.size(); count++) {
                    if(users.get(count).getTech1().equalsIgnoreCase(query) || users.get(count).getTech2().equalsIgnoreCase(query) || users.get(count).getTech3().equalsIgnoreCase(query))
                    Log.d("Data Read: ", "Value is: " + users.get(count).getName());
                    else
                        Log.d("Data Read: ", " NO VALUE" );

                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Not able to read data", "Failed to read value.", error.toException());
            }
        });
    }
}
