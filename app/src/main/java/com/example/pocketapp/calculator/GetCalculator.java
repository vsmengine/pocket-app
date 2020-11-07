package com.example.pocketapp.calculator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pocketapp.R;

import static com.example.pocketapp.R.id.answer_cal;

public class GetCalculator extends AppCompatActivity {

  EditText editText;
  Button button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9;
  Button button_plus, button_minus, button_multiply, button_divide, button_equal, button_reset, button_float;

  StringBuilder inputPlaceHolder;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cal);

    inputPlaceHolder = new StringBuilder("");

    editText = (EditText)findViewById(R.id.input_cal);

    button_1 = (Button)findViewById(R.id.num_1);
    button_2 = (Button)findViewById(R.id.num_2);
    button_3 = (Button)findViewById(R.id.num_3);
    button_4 = (Button)findViewById(R.id.num_4);
    button_5 = (Button)findViewById(R.id.num_5);
    button_6 = (Button)findViewById(R.id.num_6);
    button_7 = (Button)findViewById(R.id.num_7);
    button_8 = (Button)findViewById(R.id.num_8);
    button_9 = (Button)findViewById(R.id.num_9);

    button_plus = (Button)findViewById(R.id.plus);
    button_minus = (Button)findViewById(R.id.minus);
    button_multiply = (Button)findViewById(R.id.multiply);
    button_divide = (Button)findViewById(R.id.divide);
    button_equal = (Button)findViewById(R.id.equal);
    button_reset = (Button)findViewById(R.id.reset);
    button_float = (Button)findViewById(R.id.floatPoint);

    button_1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        inputPlaceHolder.append("1");
        editText.setText(inputPlaceHolder);
      }
    });

    button_2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        inputPlaceHolder.append("2");
        editText.setText(inputPlaceHolder);
      }
    });

    button_float.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        inputPlaceHolder.append(".");
        editText.setText(inputPlaceHolder);
      }
    });

    button_equal.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Double number_a = Double.parseDouble(inputPlaceHolder.toString());
//        editText.setText(inputPlaceHolder);
        Log.d("qaz", "#############" + (number_a + 1));
      }
    });





  };
}
