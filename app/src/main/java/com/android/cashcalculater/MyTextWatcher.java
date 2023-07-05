package com.android.cashcalculater;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MyTextWatcher implements TextWatcher {
    private TextView textView;
    private EditText editText;
    private int note;
    private String hint;
    private  cashpage cashpage;
    public MyTextWatcher(TextView textView,EditText editText,int note, String hint, cashpage cashpage)
    {
        this.textView = textView;
        this.editText = editText;
        this.note = note;
        this.hint = hint;
        this.cashpage = cashpage;
    }

    public void afterTextChanged(Editable s) {
        String noOfNotes = editText.getText().toString();
        String text = "";
        if(editText.getText() == null || editText.getText().length() == 0) {
            text = hint;
        }
        else
        {
            text = String.valueOf(Double.parseDouble(noOfNotes) * note);
        }
        textView.setText(""+text);
        cashpage.calculateNoOfNotes();
        cashpage.calculateTotalAmount();

    }
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }


}
