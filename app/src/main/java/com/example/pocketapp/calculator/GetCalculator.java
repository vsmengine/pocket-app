package com.example.pocketapp.calculator;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pocketapp.R;

public class GetCalculator extends AppCompatActivity {

  TextView answerCal, inputOld;
  EditText editText;
  Double value_temp;
  String current_operation;
  StringBuilder inputPlaceHolder;
  int clickCount = 0;
  String ERROR_MSG = "Please add a number!";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cal);

    inputPlaceHolder = new StringBuilder("");
    editText = (EditText)findViewById(R.id.cal_activity_input_txt);
    inputOld = (TextView)findViewById(R.id.cal_activity_old_txt);
    answerCal = (TextView)findViewById(R.id.cal_activity_answer_txt);
    final Button button_1 = (Button)findViewById(R.id.num_1);
    final Button button_2 = (Button)findViewById(R.id.num_2);
    final Button button_3 = (Button)findViewById(R.id.num_3);
    final Button button_4 = (Button)findViewById(R.id.num_4);
    final Button button_5 = (Button)findViewById(R.id.num_5);
    final Button button_6 = (Button)findViewById(R.id.num_6);
    final Button button_7 = (Button)findViewById(R.id.num_7);
    final Button button_8 = (Button)findViewById(R.id.num_8);
    final Button button_9 = (Button)findViewById(R.id.num_9);
    final Button button_0 = (Button)findViewById(R.id.num_0);
    final Button button_plus = (Button)findViewById(R.id.plus);
    final Button button_minus = (Button)findViewById(R.id.minus);
    final Button button_multiply = (Button)findViewById(R.id.multiply);
    final Button button_divide = (Button)findViewById(R.id.divide);
    final Button button_equal = (Button)findViewById(R.id.equal);
    final Button button_reset = (Button)findViewById(R.id.reset);
    final Button button_float = (Button)findViewById(R.id.floatPoint);

    //Number Button Click Listeners
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
        } else {
          toastMsg(ERROR_MSG);
        }
      }
    });

    //Operation Button Click Listeners
    button_plus.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if(!editText.getText().toString().isEmpty() || value_temp != null) {
          calTempValue();
          current_operation = "+";
          answerCal.setText(value_temp.toString());
          inputOld.setText(inputPlaceHolder);
          inputPlaceHolder = new StringBuilder("");
          editText.setText(inputPlaceHolder);
        } else {
          toastMsg(ERROR_MSG);
        }
        clickCount =+ 1;
      }
    });
    button_minus.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if(!editText.getText().toString().isEmpty() || value_temp != null) {
          calTempValue();
          current_operation = "-";
          answerCal.setText(value_temp.toString());
          inputOld.setText(inputPlaceHolder);
          inputPlaceHolder = new StringBuilder("");
          editText.setText(inputPlaceHolder);
        } else {
          toastMsg(ERROR_MSG);
        }
        clickCount =+ 1;
      }
    });
    button_multiply.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if(!editText.getText().toString().isEmpty() || value_temp != null) {
          calTempValue();
          current_operation = "*";
          answerCal.setText(value_temp.toString());
          inputOld.setText(inputPlaceHolder);
          inputPlaceHolder = new StringBuilder("");
          editText.setText(inputPlaceHolder);
        } else {
          toastMsg(ERROR_MSG);
        }
        clickCount =+ 1;
      }
    });
    button_divide.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if(!editText.getText().toString().isEmpty() || value_temp != null) {
          calTempValue();
          current_operation = "/";
          answerCal.setText(value_temp.toString());
          inputOld.setText(inputPlaceHolder);
          inputPlaceHolder = new StringBuilder("");
          editText.setText(inputPlaceHolder);
        } else {
          toastMsg(ERROR_MSG);
        }
        clickCount =+ 1;
      }
    });

    //Equal & Reset Button Click Listeners
    button_equal.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if(!editText.getText().toString().isEmpty()) {
          calTempValue();
          answerCal.setText(value_temp.toString());
          inputOld.setText(inputPlaceHolder);
          inputPlaceHolder = new StringBuilder("");
          editText.setText(inputPlaceHolder);
          current_operation = "";
        } else {
          toastMsg(ERROR_MSG);
        }
      }
    });
    button_reset.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        clickCount = 0;
        value_temp = 0.0;
        inputPlaceHolder = new StringBuilder("");
        editText.setText(inputPlaceHolder);
        inputOld.setText("");
        answerCal.setText("");
        current_operation = "";
      }
    });
  };

  //Number Calculate Function
  public void calTempValue() {
    if(clickCount == 0) {
      value_temp = Double.parseDouble(editText.getText().toString());
    } else {
      switch (current_operation) {
        case "+":
          value_temp = value_temp + Double.parseDouble(editText.getText().toString());
          break;
        case "-":
          value_temp = value_temp - Double.parseDouble(editText.getText().toString());
          break;
        case "*":
          value_temp = value_temp * Double.parseDouble(editText.getText().toString());
          break;
        case "/":
          value_temp = value_temp / Double.parseDouble(editText.getText().toString());
          break;
        case "":
          break;
      }
    }
  }

  //Toast Message Function
  public void toastMsg(String text) {
    Context context = getApplicationContext();
    int duration = Toast.LENGTH_SHORT;
    Toast toast = Toast.makeText(context, text, duration);
    toast.show();
  }

}
