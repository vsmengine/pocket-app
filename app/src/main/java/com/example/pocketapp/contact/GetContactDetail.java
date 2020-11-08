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
  String name;
  TextView lblName;
  Button showBtn;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cont_detail);

    lblName = (TextView)findViewById(R.id.cont_detail_name);
    showBtn = (Button)findViewById(R.id.show_cont_detail_name);

    Intent in = getIntent();
    HashMap<String, String> hashMapObject = (HashMap<String, String>) in.getSerializableExtra("contactHashMap");

    name = hashMapObject.get(Tags.TAG_NAME);
    String starName = translateName(name);
    lblName.setText(starName);

    showBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        lblName.setText(name);
      }
    });
  }

  public String translateName(String name) {
    String actualName = name;
    String starName = actualName.replaceAll("[A-Za-z0-9]", "*");
    return starName;
//    Log.d("wsx", "##############" + starName);
  }

}
