package com.aasem.recyclerviewwithmasterdetail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<DataStudent> studentArrayList;
    Adapter adapter;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        studentArrayList = new ArrayList<>();
        adapter = new Adapter(this, studentArrayList);
        Collections.sort(studentArrayList, DataStudent.SORT_BY_NAME);
        recyclerView.setAdapter(adapter);
        addData();
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, "Clicked " + position, Toast.LENGTH_SHORT).show();
            }
        }));
    }

    private void addData() {
        studentArrayList.add(new DataStudent(1, "Apple", "Apple", "97676",R.drawable.apple));
        studentArrayList.add(new DataStudent(2, "Mangos", "Mangos", "1297676",R.drawable.mangos));
        studentArrayList.add(new DataStudent(3, "Banana", "Banana", "1397676",R.drawable.banana));
        studentArrayList.add(new DataStudent(4, "Chicko", "Chicko", "1497676",R.drawable.chikoo));
        studentArrayList.add(new DataStudent(5, "Grapes", "Grapes", "1597676",R.drawable.grapes));
        studentArrayList.add(new DataStudent(6, "Lemon", "Lemon", "1697676",R.drawable.lemon));
    }


}