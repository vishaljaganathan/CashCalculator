package com.android.cashcalculater;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text1,text2;
    String sign, val_1, val_2;
    Double num1, num2, answer;
    boolean Dot;
    Button cashpage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = (TextView) findViewById(R.id.calculation);
        text2 = (TextView) findViewById(R.id.result);
        cashpage=(Button)findViewById(R.id.cashcalculater);
        cashpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,cashpage.class);
                startActivity(intent);
            }
        });
        Dot = false;
    }
            @SuppressLint("SetTextI18n")
            public void num0(View view) {
                text1.setText(text1.getText() + "0");
            }
            @SuppressLint("SetTextI18n")
            public void num1(View view) {
                text1.setText(text1.getText() + "1");
            }
            @SuppressLint("SetTextI18n")
            public void num2(View view) {
                text1.setText(text1.getText() + "2");
            }
            @SuppressLint("SetTextI18n")
            public void num3(View view) {
                text1.setText(text1.getText() + "3");
            }
            @SuppressLint("SetTextI18n")
            public void num4(View view) {
                text1.setText(text1.getText() + "4");
            }
            @SuppressLint("SetTextI18n")
            public void num5(View view) {
                text1.setText(text1.getText() + "5");
            }
            @SuppressLint("SetTextI18n")
            public void num6(View view) {
                text1.setText(text1.getText() + "6");
            }
            @SuppressLint("SetTextI18n")
            public void num7(View view) {
                text1.setText(text1.getText() + "7");
            }
            @SuppressLint("SetTextI18n")
            public void num8(View view) {
                text1.setText(text1.getText() + "8");
            }
            @SuppressLint("SetTextI18n")
            public void num9(View view) {
                text1.setText(text1.getText() + "9");
            }
            @SuppressLint("SetTextI18n")
            public void dot(View view) {
                if (!Dot) {
                    if (text1.getText().equals("")) {
                        text1.setText("0.");
                    } else {

                        text1.setText(text1.getText() + ".");
                    }

                    Dot = true;
                }

            }
    public void add(View view) {
        sign = "+";
        val_1 = text1.getText().toString();
        text1.setText(null);
        text2.setText("+");
        Dot = false;
    }
    public void sub(View view) {
        sign = "-";
        val_1 = text1.getText().toString();
        text1.setText(null);
        text2.setText("-");
        Dot = false;
    }
    public void multi(View view) {
        sign = "*";
        val_1 = text1.getText().toString();
        text1.setText(null);
        text2.setText("x");
        Dot = false;
    }
    public void div(View view) {
        sign = "/";
        val_1 = text1.getText().toString();
        text1.setText(null);
        text2.setText("÷");
        Dot = false;
    }
    @SuppressLint("SetTextI18n")
    public void equal(View view) {
        if (sign == null) {
            text2.setText("Error!");
        } else if (text1.getText().equals("")) {
            text2.setText("Error!");
        } else if ((sign.equals("+") || sign.equals("-") || sign.equals("*") || sign.equals("/")) && val_1.equals("")) {
            text2.setText("Error!");
        } else {
            switch (sign) {
                default:
                    break;
                case "+":
                    val_2 = text1.getText().toString();
                    num1 = Double.parseDouble(val_1);
                    num2 = Double.parseDouble(val_2);
                    answer = num1 + num2;
                    text1.setText(answer + "");
                    sign = null;
                    text2.setText(null);
                    break;
                case "-":
                    val_2 = text1.getText().toString();
                    num1 = Double.parseDouble(val_1);
                    num2 = Double.parseDouble(val_2);
                    answer = num1 - num2;
                    text1.setText(answer + "");
                    sign = null;
                    text2.setText(null);
                    break;
                case "*":
                    val_2 = text1.getText().toString();
                    num1 = Double.parseDouble(val_1);
                    num2 = Double.parseDouble(val_2);
                    answer = num1 * num2;
                    text1.setText(answer + "");
                    sign = null;
                    text2.setText(null);
                    break;
                case "/":
                    val_2 = text1.getText().toString();
                    num1 = Double.parseDouble(val_1);
                    num2 = Double.parseDouble(val_2);
                    answer = num1 / num2;
                    text1.setText(answer + "");
                    sign = null;
                    text2.setText(null);
                    break;
            }
        }
    }
    public void delet(View view) {
        String str=text1.getText().toString();
        if (str.length() >1 ) {
            str = str.substring(0, str.length() - 1);
            text1.setText(str);
        }
        else if (str.length() <=1 ) {
            text1.setText(null);
        }
    }












    public void clear(View view) {

        text1.setText(null);
        text2.setText(null);
        val_1 = null;
        val_2 = null;
        sign = null;
        Dot = false;
    }




}








