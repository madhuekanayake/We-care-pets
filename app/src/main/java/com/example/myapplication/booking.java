package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class booking extends AppCompatActivity {

    private EditText caregivernameEditText;
    private EditText numberOfHoursEditText;
    private DatePicker datePicker;
    private Button bookButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        caregivernameEditText = findViewById(R.id.caregivernameEditText);
        numberOfHoursEditText = findViewById(R.id.numberOfHoursEditText);
        datePicker = findViewById(R.id.datePicker);
        bookButton = findViewById(R.id.bookButton);


        bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bookAnimalCare();
            }
        });
    }

    private void bookAnimalCare() {

        String caregiverName = caregivernameEditText.getText().toString();
        String numberOfHours = numberOfHoursEditText.getText().toString();

        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth() + 1;
        int year = datePicker.getYear();


        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);


        double hourlyPrice = 3500;
        double totalCost = Double.parseDouble(numberOfHours) * hourlyPrice;


        String message = "Booking Details:\n" +
                "Caregiver Name: " + caregiverName + "\n" +
                "Number of Hours: " + numberOfHours + "\n" +
                "Date: " + day + "/" + month + "/" + year + "\n" +
                "Total Cost: Rs" + totalCost;

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}