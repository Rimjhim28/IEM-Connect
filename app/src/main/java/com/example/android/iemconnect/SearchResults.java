package com.example.android.iemconnect;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;

public class SearchResults extends AppCompatActivity {

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference();
    int count = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
        showSearchResults();
    }

    void showSearchResults(){
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
                        Log.d("Data Read: ", "Value is: " + users.get(count).getName());
                    Log.d("Data Read: ", "Value is: " + users.get(count).getContact());
                    Log.d("Data Read: ", "Value is: " + users.get(count).getDepartment());
                    Log.d("Data Read: ", "Value is: " + users.get(count).getTech1());
                    Log.d("Data Read: ", "Value is: " + users.get(count).getTech2());
                    Log.d("Data Read: ", "Value is: " + users.get(count).getTech3());
                }
                UserAdapter adapter = new UserAdapter(SearchResults.this,users);
                ListView listView = findViewById(R.id.list_view);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Not able to read data", "Failed to read value.", error.toException());
            }
        });
    }
}
