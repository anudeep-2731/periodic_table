package com.example.periodic_table;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class search_activity extends AppCompatActivity {
    DatabaseReference databaseReference;

    String id,string;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<String> list;
    ArrayList<String> idss= new ArrayList<>();
    private RecyclerAdapter adapter;
    Context context;

    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_activity);
        context = this;

        databaseReference = FirebaseDatabase.getInstance().getReference().child("elements");

        databaseReference.addValueEventListener(new ValueEventListener() {

            @Override

            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    id = ds.child("name").getValue(String.class);

                    idss.add(id);

                    i++;

                    string = string + id;

                    if (i == 118) {

                        hii();

                    }

                }

            }



            @Override

            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(context, "ohh no...", Toast.LENGTH_SHORT).show();



            }

        });


    }

    private void hii() {
        recyclerView=findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter(idss,context);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

    }
}
