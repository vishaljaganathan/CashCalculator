package com.android.cashcalculater;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class cashpage extends AppCompatActivity {
    Button calculaterpage;
    ImageButton delete;
    EditText plusrs,minusrs,text2000,text500,text200,text100,text50,text20,text10,text5,text2,text1,remark,name,anum,mnum;
    TextView number2000,number500,number200,number100,number50,number20,number10,number05,number02,number01,total,totalNote;
    double tot,answer,ta,num1,num2,num5,num10,num20,num50,num100,num200,num500,num2000,tot1,tot2,tot5,tot10,tot20,tot50,tot100,tot200,tot500,tot2000,plu,minu;
    String val_tot,val_2000,val_500,val_200,val_100,val_50,val_20,val_10,val_5,val_2,val_1,tot_2000,tot_500,tot_200,tot_100,tot_50,tot_20,tot_10,tot_5,tot_2,tot_1,val_plu,val_minu;
    int noOfNotes = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cashpage);
        calculaterpage=(Button)findViewById(R.id.calculator);
        calculaterpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(cashpage.this,MainActivity.class);
                startActivity(intent1);
            }
        });
        delete = (ImageButton)findViewById(R.id.imageButton);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total.setText(null);
                totalNote.setText(null);
                plusrs.setText(null);
                minusrs.setText(null);
                number2000.setText(null);
                number500.setText(null);
                number200.setText(null);
                number100.setText(null);
                number50.setText(null);
                number20.setText(null);
                number10.setText(null);
                number05.setText(null);
                number02.setText(null);
                number01.setText(null);
                text2000.setText(null);
                text500.setText(null);
                text200.setText(null);
                text100.setText(null);
                text50.setText(null);
                text20.setText(null);
                text10.setText(null);
                text5.setText(null);
                text2.setText(null);
                text1.setText(null);
                name.setText(null);
                mnum.setText(null);
                anum.setText(null);
                remark.setText(null);
            }
        });



        total = (TextView)findViewById(R.id.total);
        totalNote = (TextView)findViewById(R.id.totalNote);
        plusrs = (EditText) findViewById(R.id.plusrs);
        minusrs = (EditText) findViewById(R.id.minusrs);
        name = (EditText)findViewById(R.id.editText);
        mnum = (EditText)findViewById(R.id.editText2);
        anum = (EditText)findViewById(R.id.editText4);
        remark = (EditText)findViewById(R.id.editText3);
        number2000 =(TextView)findViewById(R.id.number2000);
        number500 =(TextView)findViewById(R.id.number500);
        number200 =(TextView)findViewById(R.id.number200);
        number100 =(TextView)findViewById(R.id.number100);
        number50 =(TextView)findViewById(R.id.number50);
        number20 =(TextView)findViewById(R.id.number20);
        number10 =(TextView)findViewById(R.id.number10);
        number05 =(TextView)findViewById(R.id.number05);
        number02 =(TextView)findViewById(R.id.number02);
        number01 =(TextView)findViewById(R.id.number01);

        text2000 = (EditText)findViewById(R.id.text2000);
        text500 = (EditText)findViewById(R.id.text500);
        text200 = (EditText)findViewById(R.id.text200);
        text100 = (EditText)findViewById(R.id.text100);
        text50 = (EditText)findViewById(R.id.text50);
        text20 = (EditText)findViewById(R.id.text20);
        text10 = (EditText)findViewById(R.id.text10);
        text5 = (EditText)findViewById(R.id.textfive);
        text2 = (EditText)findViewById(R.id.texttwo);
        text1 = (EditText)findViewById(R.id.textone);


        plusrs.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                plu = plusrs.getText() != null && plusrs.getText().toString().length() > 0 ? Double.parseDouble(plusrs.getText().toString()): 0;
                minu = minusrs.getText() != null && minusrs.getText().toString().length() > 0 ? Double.parseDouble(minusrs.getText().toString()) : 0;
                tot = calculateTotalAmount();


            }
        });
        minusrs.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {



            }

            @Override
            public void afterTextChanged(Editable s) {
                plu = plusrs.getText() != null && plusrs.getText().toString().length() > 0 ? Double.parseDouble(plusrs.getText().toString()): 0;
                minu = minusrs.getText() != null && minusrs.getText().toString().length() > 0 ? Double.parseDouble(minusrs.getText().toString()) : 0;
                tot = calculateTotalAmount();


            }
        });


        MyTextWatcher myTextWatcher2000 = new MyTextWatcher(number2000,text2000,2000,"0.0", this);
        text2000.addTextChangedListener(myTextWatcher2000);
        MyTextWatcher myTextWatcher500 = new MyTextWatcher(number500,text500,500,"0.0", this);
        text500.addTextChangedListener(myTextWatcher500);
        MyTextWatcher myTextWatcher200 = new MyTextWatcher(number200,text200,200,"0.0", this);
        text200.addTextChangedListener(myTextWatcher200);
        MyTextWatcher myTextWatcher100 = new MyTextWatcher(number100,text100,100,"0.0", this);
        text100.addTextChangedListener(myTextWatcher100);
        MyTextWatcher myTextWatcher50 = new MyTextWatcher(number50,text50,50,"0.0", this);
        text50.addTextChangedListener(myTextWatcher50);
        MyTextWatcher myTextWatcher20 = new MyTextWatcher(number20,text20,20,"0.0", this);
        text20.addTextChangedListener(myTextWatcher20);
        MyTextWatcher myTextWatcher10 = new MyTextWatcher(number10,text10,10,"0.0", this);
        text10.addTextChangedListener(myTextWatcher10);
        MyTextWatcher myTextWatcher5 = new MyTextWatcher(number05,text5,5,"0.0", this);
        text5.addTextChangedListener(myTextWatcher5);
        MyTextWatcher myTextWatcher2 = new MyTextWatcher(number02,text2,2,"0.0", this);
        text2.addTextChangedListener(myTextWatcher2);
        MyTextWatcher myTextWatcher1 = new MyTextWatcher(number01,text1,1,"0.0", this);
        text1.addTextChangedListener(myTextWatcher1);
    }

    public void calculateNoOfNotes()
    {

        val_1 = text1.getText().toString();
        val_2 = text2.getText().toString();
        val_5 = text5.getText().toString();
        val_10 = text10.getText().toString();
        val_20 = text20.getText().toString();
        val_50 = text50.getText().toString();
        val_100 = text100.getText().toString();
        val_200 = text200.getText().toString();
        val_500 = text500.getText().toString();
        val_2000 = text2000.getText().toString();

        num1 = val_1 != null && val_1.length() > 0 ? Double.parseDouble(val_1): 0;
        num2 = val_2 != null && val_2.length() > 0 ? Double.parseDouble(val_2): 0;
        num5 = val_5 != null && val_5.length() > 0 ? Double.parseDouble(val_5): 0;
        num10 = val_10 != null && val_10.length() > 0 ? Double.parseDouble(val_10): 0;
        num20 = val_20 != null && val_20.length() > 0 ? Double.parseDouble(val_20): 0;
        num50 = val_50 != null && val_50.length() > 0 ? Double.parseDouble(val_50): 0;
        num100 = val_100 != null && val_100.length() > 0 ? Double.parseDouble(val_100): 0;
        num200 = val_200 != null && val_200.length() > 0 ? Double.parseDouble(val_200): 0;
        num500 = val_500 != null && val_500.length() > 0 ? Double.parseDouble(val_500): 0;
        num2000 = val_2000 != null && val_2000.length() > 0 ? Double.parseDouble(val_2000) : 0;
        totalNote.setText((num1 + num2 + num5 + num10 + num20 + num50 + num100 + num200 + num500 + num2000)+" Note(s)");
    }
    public double calculateTotalAmount()
    {
        tot_1 = number01.getText().toString();
        tot_2 = number02.getText().toString();
        tot_5 = number05.getText().toString();
        tot_10 = number10.getText().toString();
        tot_20 = number20.getText().toString();
        tot_50 = number50.getText().toString();
        tot_100 = number100.getText().toString();
        tot_200 = number200.getText().toString();
        tot_500 = number500.getText().toString();
        tot_2000 = number2000.getText().toString();
        tot1 = tot_1 != null && tot_1.length() > 0 ? Double.parseDouble(tot_1): 0;
        tot2 = tot_2 != null && tot_2.length() > 0 ? Double.parseDouble(tot_2): 0;
        tot5 = tot_5 != null && tot_5.length() > 0 ? Double.parseDouble(tot_5): 0;
        tot10 = tot_10 != null && tot_10.length() > 0 ? Double.parseDouble(tot_10): 0;
        tot20 = tot_20 != null && tot_20.length() > 0 ? Double.parseDouble(tot_20): 0;
        tot50 = tot_50 != null && tot_50.length() > 0 ? Double.parseDouble(tot_50): 0;
        tot100 = tot_100 != null && tot_100.length() > 0 ? Double.parseDouble(tot_100): 0;
        tot200 = tot_200 != null && tot_200.length() > 0 ? Double.parseDouble(tot_200): 0;
        tot500 = tot_500 != null && tot_500.length() > 0 ? Double.parseDouble(tot_500): 0;
        tot2000 = tot_2000 != null && tot_2000.length() > 0 ? Double.parseDouble(tot_2000) : 0;
        double  TotalAmount = (tot1 + tot2 + tot5 + tot10 + tot20 + tot50 + tot100 + tot200 + tot500 + tot2000 + (plu - minu));
        total.setText("₹ "+ TotalAmount );
        return TotalAmount;

    }




}