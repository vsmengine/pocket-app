package com.example.pocketapp.calculator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pocketapp.R;

import static com.example.pocketapp.R.id.answer_cal;

public class GetCalculator extends AppCompatActivity {

  TextView answerCal, inputOld;
  EditText editText;
  Button button_0, button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9;
  Button button_plus, button_minus, button_multiply, button_divide, button_equal, button_reset, button_float;
  Double value_a;
  String current_operation;
  int clickCount = 0;

  StringBuilder inputPlaceHolder;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cal);

    inputPlaceHolder = new StringBuilder("");

    editText = (EditText)findViewById(R.id.input_cal);
    inputOld = (TextView)findViewById(R.id.input_old);
    answerCal = (TextView)findViewById(answer_cal);

    button_1 = (Button)findViewById(R.id.num_1);
    button_2 = (Button)findViewById(R.id.num_2);
    button_3 = (Button)findViewById(R.id.num_3);
    button_4 = (Button)findViewById(R.id.num_4);
    button_5 = (Button)findViewById(R.id.num_5);
    button_6 = (Button)findViewById(R.id.num_6);
    button_7 = (Button)findViewById(R.id.num_7);
    button_8 = (Button)findViewById(R.id.num_8);
    button_9 = (Button)findViewById(R.id.num_9);
    button_0 = (Button)findViewById(R.id.num_0);

    button_plus = (Button)findViewById(R.id.plus);
    button_minus = (Button)findViewById(R.id.minus);
    button_multiply = (Button)findViewById(R.id.multiply);
    button_divide = (Button)findViewById(R.id.divide);
    button_equal = (Button)findViewById(R.id.equal);
    button_reset = (Button)findViewById(R.id.reset);
    button_float = (Button)findViewById(R.id.floatPoint);

    button_0.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        inputPlaceHolder.append("0");
        editText.setText(inputPlaceHolder);
      }
    });
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
    button_3.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        inputPlaceHolder.append("3");
        editText.setText(inputPlaceHolder);
      }
    });
    button_4.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        inputPlaceHolder.append("4");
        editText.setText(inputPlaceHolder);
      }
    });
    button_5.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        inputPlaceHolder.append("5");
        editText.setText(inputPlaceHolder);
      }
    });
    button_6.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        inputPlaceHolder.append("6");
        editText.setText(inputPlaceHolder);
      }
    });
    button_7.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        inputPlaceHolder.append("7");
        editText.setText(inputPlaceHolder);
      }
    });
    button_8.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        inputPlaceHolder.append("8");
        editText.setText(inputPlaceHolder);
      }
    });
    button_9.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        inputPlaceHolder.append("9");
        editText.setText(inputPlaceHolder);
      }
    });
    button_float.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if(!inputPlaceHolder.toString().isEmpty()) {
          inputPlaceHolder.append(".");
          editText.setText(inputPlaceHolder);
        }
      }
    });

    button_plus.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if(!editText.getText().toString().isEmpty() || value_a != null) {
          calTempValue();
          current_operation = "+";
          answerCal.setText(value_a.toString());
          inputOld.setText(inputPlaceHolder);
          inputPlaceHolder = new StringBuilder("");
          editText.setText(inputPlaceHolder);
        }
        clickCount =+ 1;
      }
    });
    button_minus.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if(!editText.getText().toString().isEmpty() || value_a != null) {
          calTempValue();
          current_operation = "-";
          answerCal.setText(value_a.toString());
          inputOld.setText(inputPlaceHolder);
          inputPlaceHolder = new StringBuilder("");
          editText.setText(inputPlaceHolder);
        }
        clickCount =+ 1;
      }
    });
    button_multiply.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if(!editText.getText().toString().isEmpty() || value_a != null) {
          calTempValue();
          current_operation = "*";
          answerCal.setText(value_a.toString());
          inputOld.setText(inputPlaceHolder);
          inputPlaceHolder = new StringBuilder("");
          editText.setText(inputPlaceHolder);
        }
        clickCount =+ 1;
      }
    });
    button_divide.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if(!editText.getText().toString().isEmpty() || value_a != null) {
          calTempValue();
          current_operation = "/";
          answerCal.setText(value_a.toString());
          inputOld.setText(inputPlaceHolder);
          inputPlaceHolder = new StringBuilder("");
          editText.setText(inputPlaceHolder);
        }
        clickCount =+ 1;
      }
    });

    button_equal.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if(!editText.getText().toString().isEmpty()) {
          calTempValue();
          answerCal.setText(value_a.toString());
          inputOld.setText(inputPlaceHolder);
          inputPlaceHolder = new StringBuilder("");
          editText.setText(inputPlaceHolder);
          current_operation = "";
        }
      }
    });
    button_reset.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        clickCount = 0;
        value_a = 0.0;
        inputPlaceHolder = new StringBuilder("");
        editText.setText(inputPlaceHolder);
        inputOld.setText("");
        answerCal.setText("");
        current_operation = "";
      }
    });
  };

  public void calTempValue() {
    if(clickCount == 0) {
      value_a = Double.parseDouble(editText.getText().toString());
    } else {
      switch (current_operation) {
        case "+":
          value_a = value_a + Double.parseDouble(editText.getText().toString());
          break;
        case "-":
          value_a = value_a - Double.parseDouble(editText.getText().toString());
          break;
        case "*":
          value_a = value_a * Double.parseDouble(editText.getText().toString());
          break;
        case "/":
          value_a = value_a / Double.parseDouble(editText.getText().toString());
          break;
        case "":
          break;
      }
    }
    Log.d("final calculate value", "#############" + value_a);
  }

}
