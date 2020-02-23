package com.example.periodic_table;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class element_details extends AppCompatActivity {
    DatabaseReference databaseReference;
    TextView textView1;
    Button h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element_details);
        textView1=findViewById(R.id.details);
        h=findViewById(R.id.E_0);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("elements");


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int j= getIntent().getIntExtra("i",1);
                String i=Integer.toString(j);
                String element=dataSnapshot.child(i).getValue().toString();
                textView1.setText(element);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(element_details.this, "ohh no...", Toast.LENGTH_SHORT).show();

            }
        });
    }

}
