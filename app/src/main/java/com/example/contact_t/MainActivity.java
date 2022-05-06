package com.example.contact_t;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        userAdapter = new UserAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        userAdapter.setData(getListUser());
        recyclerView.setAdapter(userAdapter);
    }

    private List<User> getListUser(){

        List<User> list = new ArrayList<>();
        list.add(new User(R.drawable.ic_baseline_location_on_24,"Find People Nearby",true));
        list.add(new User(R.drawable.ic_baseline_person_add_24,"Invite Friends",true));

        list.add(new User(R.drawable.user3,"John Mark",false));
        list.add(new User(R.drawable.user2,"John Mark",false));
        list.add(new User(R.drawable.user3,"John Mark",false));
        list.add(new User(R.drawable.user2,"John Mark",false));
        list.add(new User(R.drawable.user3,"John Mark",false));
        list.add(new User(R.drawable.user2,"John Mark",false));
        list.add(new User(R.drawable.user3,"John Mark",false));
        list.add(new User(R.drawable.user2,"John Mark",false));
        list.add(new User(R.drawable.user3,"John Mark",false));
        list.add(new User(R.drawable.user2,"John Mark",false));
        list.add(new User(R.drawable.user3,"John Mark",false));
        list.add(new User(R.drawable.user2,"John Mark",false));
        list.add(new User(R.drawable.user3,"John Mark",false));

        return list;
    }
}