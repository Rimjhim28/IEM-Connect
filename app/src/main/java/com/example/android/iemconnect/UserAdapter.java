package com.example.android.iemconnect;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {

    public UserAdapter(@NonNull Context context, @NonNull ArrayList<User> searchUser) {
        super(context, 0,searchUser);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        User currentUser = getItem(position);
        //Setting user name in list view
        TextView userName = listItemView.findViewById(R.id.txt_user_name);
        userName.setText(currentUser.getName());

        //Setting user contact in list view
        TextView userContact = listItemView.findViewById(R.id.txt_user_contact);
        userContact.setText(currentUser.getContact());

        return listItemView;
    }
}
