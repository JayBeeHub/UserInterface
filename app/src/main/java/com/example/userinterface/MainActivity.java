package com.example.userinterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    //Declaring linear_layout to support onclick listening
    LinearLayout submit_linearLayout;

    //Declarations for Date and Calender Picker - displays the date selected in a text view
    TextView selectDate;
    TextView date;
    DatePickerDialog datePickerDialog;
    int year;
    int month;
    int dayOfMonth;
    Calendar calender;

    //Declarations for string.xml of the delivery statuses
    String s1[], s2[], s3[];

    //Declare RecyclerView and parse it an id used in the activity.xml
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectDate = findViewById(R.id.calender_text_view);
        date = findViewById(R.id.day_text_view);

        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calender = Calendar.getInstance();
                year = calender.get(Calendar.YEAR);
                month = calender.get(Calendar.MONTH);
                dayOfMonth = calender.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                calender.set(Calendar.YEAR, year);
                                calender.set(Calendar.MONTH, month);
                                calender.set(Calendar.DAY_OF_MONTH, day);


                                String dateString= new SimpleDateFormat("EEE d MMM yyyy", Locale.getDefault()).format(calender.getTime());
                                date.setText(getString(R.string.date_format,dateString) );

                                String monthString= new SimpleDateFormat("MMMM yyyy", Locale.getDefault()).format(calender.getTime());
                                selectDate.setText(monthString) ;
                            }
                        },year,month,dayOfMonth);
                datePickerDialog.show();


                //Linear layout and Id created to support Toast message when clicked
                submit_linearLayout = findViewById(R.id.submit_linear_layout);
                submit_linearLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "Your request is been processed", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

        //Assigning id recyclerView created as Global variable
        recyclerView = findViewById(R.id.recycler_view);

        //Assigning the strings created in the string.xml file by the use of getResources and its Id
        s1 = getResources().getStringArray(R.array.delivery_type);
        s2 = getResources().getStringArray(R.array.delivery_description);
        s3 = getResources().getStringArray(R.array.delivery_time);

        MyRecyclerAdapter myRecyclerAdapter = new MyRecyclerAdapter(this,s1,s2,s3);
        recyclerView.setAdapter(myRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


}