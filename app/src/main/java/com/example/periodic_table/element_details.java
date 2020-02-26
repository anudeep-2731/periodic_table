package com.example.periodic_table;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
    TextView name1,density1,atomic_mass1,category1,discovered_by1,electronic_config1,symbol1,phase1,apperarance1,melting_point1,boiling_point1,summary1;
    Button h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element_details);
        name1=findViewById(R.id.name);
        density1=findViewById(R.id.density);
        atomic_mass1=findViewById(R.id.atomic_mass);
        category1=findViewById(R.id.category);
        discovered_by1=findViewById(R.id.discoverd_by);
        symbol1=findViewById(R.id.symbol);
        phase1=findViewById(R.id.phase);
        apperarance1=findViewById(R.id.appearance);
        melting_point1=findViewById(R.id.melt);
        boiling_point1=findViewById(R.id.boil);
        summary1=findViewById(R.id.summary);
        electronic_config1=findViewById(R.id.electronic_config);
        h=findViewById(R.id.E_0);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("elements");


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int j= getIntent().getIntExtra("i",1);
                String i=Integer.toString(j);
                String electronuc_config=dataSnapshot.child(i).child("electron_configuration").getValue().toString();
                String name=dataSnapshot.child(i).child("name").getValue().toString();
                String density=dataSnapshot.child(i).child("density").getValue().toString();
                String atomic_mass=dataSnapshot.child(i).child("atomic_mass").getValue().toString();
                String category=dataSnapshot.child(i).child("category").getValue().toString();
                String discovered_by=dataSnapshot.child(i).child("discovered_by").getValue().toString();
                String symbol=dataSnapshot.child(i).child("symbol").getValue().toString();
                String phase=dataSnapshot.child(i).child("phase").getValue().toString();
                String apperarance=dataSnapshot.child(i).child("appearance").getValue().toString();
                String melting_point=dataSnapshot.child(i).child("melt").getValue().toString();
                String boiling_point=dataSnapshot.child(i).child("boil").getValue().toString();
                String summary=dataSnapshot.child(i).child("summary").getValue().toString();
                name1.setText(name);density1.setText(density);atomic_mass1.setText(atomic_mass);category1.setText(category);discovered_by1.setText(discovered_by);
                symbol1.setText(symbol);phase1.setText(phase);apperarance1.setText(apperarance);
                melting_point1.setText(melting_point);boiling_point1.setText(boiling_point);
                summary1.setText(summary);
                electronic_config1.setText(electronuc_config);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(element_details.this, "ohh no...", Toast.LENGTH_SHORT).show();

            }
        });
    }

}
