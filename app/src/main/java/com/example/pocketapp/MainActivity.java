package com.example.pocketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pocketapp.calculator.GetCalculator;
import com.example.pocketapp.contact.GetContacts;
import com.example.pocketapp.other.GetBlank;

public class MainActivity extends AppCompatActivity {

//    Button btn_cal, btn_blk, btn_cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btn_cal = (Button)findViewById(R.id.btn_get_calculator);
        final Button btn_blk = (Button)findViewById(R.id.btn_get_blank);
        final Button btn_cont = (Button)findViewById(R.id.btn_get_contacts);

        //Calculator Button Navigation Function
        btn_cal.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                  Intent inCal = new Intent(getApplicationContext(), GetCalculator.class);
                  startActivity(inCal);
                }
           }
        );

        //Blank Button Navigation Function
        btn_blk.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                  Intent inCal = new Intent(getApplicationContext(), GetBlank.class);
                  startActivity(inCal);
                }
            }
        );

        //Contacts Button Navigation Function
        btn_cont.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                  Intent inCal = new Intent(getApplicationContext(), GetContacts.class);
                  startActivity(inCal);
                }
            }
        );

    }
}