package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class bookcare extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CaregiverAdapter caregiverAdapter;
    private List<Caremodel> caregiverList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookcare);

        // Assuming you have a reference to the "caregivers" node in your Firebase database
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("caregivers");

        recyclerView = findViewById(R.id.bookcare);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        caregiverList = new ArrayList<>();
        caregiverAdapter = new CaregiverAdapter(caregiverList, this);
        recyclerView.setAdapter(caregiverAdapter);

        // ValueEventListener to fetch data from Firebase
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                caregiverList.clear(); // Clear the existing list

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    // Assuming "Caregiver" class has a constructor that takes a DataSnapshot
                    Caremodel caregiver = dataSnapshot.getValue(Caremodel.class);
                    if (caregiver != null) {
                        caregiverList.add(caregiver);
                    }
                }

                caregiverAdapter.notifyDataSetChanged(); // Notify the adapter of the data change
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle database error
            }
        });

        Button bookNowButton = findViewById(R.id.btn_booking);
        bookNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(bookcare.this, booking.class);
                startActivity(intent);
            }
        });
    }
}