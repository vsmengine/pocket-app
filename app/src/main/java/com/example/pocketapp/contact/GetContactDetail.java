package com.example.pocketapp.contact;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pocketapp.R;
import com.example.pocketapp.other.Tags;

import java.util.HashMap;

public class GetContactDetail extends AppCompatActivity {
  String name, email, gender, address, mobile, home, office;
  TextView lblName, lblEmail, lblGender, lblAddress, lblMobile, lblHome, lblOffice;
  Button showBtn;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cont_detail);

    Intent in = getIntent();
    HashMap<String, String> hashMapObject = (HashMap<String, String>) in.getSerializableExtra("contactHashMap");

    lblName = (TextView)findViewById(R.id.cont_detail_name);
    lblEmail = (TextView)findViewById(R.id.cont_detail_email);
    lblGender = (TextView)findViewById(R.id.cont_detail_gender);
    lblAddress = (TextView)findViewById(R.id.cont_detail_address);
    lblMobile = (TextView)findViewById(R.id.cont_detail_mobile);
    lblHome = (TextView)findViewById(R.id.cont_detail_home);
    lblOffice = (TextView)findViewById(R.id.cont_detail_office);
    showBtn = (Button)findViewById(R.id.show_cont_detail_name);

    name = hashMapObject.get(Tags.TAG_NAME);
    email = hashMapObject.get(Tags.TAG_EMAIL);
    gender = hashMapObject.get(Tags.TAG_GENDER);
    address = hashMapObject.get(Tags.TAG_ADDRESS);
    mobile = hashMapObject.get(Tags.TAG_MOBILE);
    home = hashMapObject.get(Tags.TAG_HOME);
    office = hashMapObject.get(Tags.TAG_OFFICE);

    String starName = translateName(name);
    lblName.setText(starName);
    lblEmail.setText(email);
    lblGender.setText(gender);
    lblAddress.setText(address);
    lblMobile.setText(mobile);
    lblHome.setText(home);
    lblOffice.setText(office);

    showBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        lblName.setText(name);
      }
    });
  }

  //Star Translate Function
  public String translateName(String name) {
    String actualName = name;
    String starName = actualName.replaceAll("[A-Za-z0-9]", "*");
    return starName;
  }

}
