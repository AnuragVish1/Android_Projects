package com.example.calculatorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    public double currentNumber = 0;
    public int currentOpperator = 0;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onClickBtn7(View view){
        String input = (String) tv.getText();
        if (Objects.equals(input, "0")){
            tv.setText("7");
        }
        else {
            tv.setText(String.format("%s7", input));
        }

    }
    public void onClickBtn8(View view){
        String input = (String) tv.getText();
        if (Objects.equals(input, "0")){
            tv.setText("8");
        }
        else {
            tv.setText(String.format("%s8", input));
        }

    }

    public void onClickDecimal(View view){
        String input = (String) tv.getText();
        if(!input.contains(".")){
            tv.setText(String.format("%s.", input));
        }
    }
    public void onClickBtn9(View view){
        String input = (String) tv.getText();
        if (Objects.equals(input, "0")){
            tv.setText("9");
        }
        else {
            tv.setText(String.format("%s9", input));
        }
    }
    public void onClickBtn4(View view){
        String input = (String) tv.getText();
        if (Objects.equals(input, "0")){
            tv.setText("4");
        }
        else {
            tv.setText(String.format("%s4", input));
        }

    }
    public void onClickBtn5(View view){
        String input = (String) tv.getText();
        if (Objects.equals(input, "0")){
            tv.setText("5");
        }
        else {
            tv.setText(String.format("%s5", input));
        }

    }
    public void onClickBtn6(View view){
        String input = (String) tv.getText();
        if (Objects.equals(input, "0")){
            tv.setText("6");
        }
        else {
            tv.setText(String.format("%s6", input));
        }
    }
    public void onClickBtn1(View view){
        String input = (String) tv.getText();
        if (Objects.equals(input, "0")){
            tv.setText("1");
        }
        else {
            tv.setText(String.format("%s1", input));
        }
    }
    public void onClickBtn2(View view){
        String input = (String) tv.getText();
        if (Objects.equals(input, "0")){
            tv.setText("2");
        }
        else {
            tv.setText(String.format("%s2", input));
        }
    }
    public void onClickBtn3(View view){
        String input = (String) tv.getText();
        if (Objects.equals(input, "0")){
            tv.setText("3");
        }
        else {
            tv.setText(String.format("%s3", input));
        }
    }
    public void onClickBtn0(View view){
        String input = (String) tv.getText();
        if (Objects.equals(input, "0")){
            tv.setText("0");
        }
        else {
            tv.setText(String.format("%s0", input));
        }
    }

    public void onAllClearBtnClick(View view){
        tv.setText("0");
        currentNumber = 0;
    }

    public void onClearBtnClick(View view){
        tv.setText("0");
    }


    public void onAddBtnClick(View view){
        try {
            currentNumber = (double) (currentNumber + Double.parseDouble((String) tv.getText()));
            currentOpperator = 1;
            tv.setText("0");
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

    public void onMinusBtnClick(View view){
        if (currentNumber == 0){
            currentNumber = (double) Double.parseDouble((String) tv.getText());
        }
        else {
            currentNumber = (double) (currentNumber - Double.parseDouble((String) tv.getText()));
        }
        currentOpperator = 2;
        tv.setText("0");
    }

    public void onMultiplyBtnClick(View view){
        if (currentNumber == 0)
        {
            currentNumber = (double) Double.parseDouble((String) tv.getText());
        }
        else {
            currentNumber = (double) (currentNumber * Double.parseDouble((String) tv.getText()));
        }
        currentOpperator = 3;
        tv.setText("0");
    }

    public void onDivideBtnClick(View view){
        try {
            if (currentNumber == 0){
                currentNumber = Double.parseDouble((String) tv.getText());
            }
            else {
                currentNumber = (double) (currentNumber / Double.parseDouble((String) tv.getText()));
            }
            currentOpperator = 4;
            tv.setText("0");
        } catch (NumberFormatException e) {
            currentNumber = 0;
            tv.setText("0");
        }
    }

    public void onEqualsBtnClick(View view){
        if (currentOpperator == 1){
            currentNumber = (currentNumber + Double.parseDouble((String) tv.getText()));
        } else if (currentOpperator == 2) {
            currentNumber = (currentNumber - Double.parseDouble((String) tv.getText()));
        } else if (currentOpperator == 3) {
            currentNumber = (currentNumber * Double.parseDouble((String) tv.getText()));
        }else if (currentOpperator == 4) {
            currentNumber = (currentNumber / Double.parseDouble((String) tv.getText()));
        }

        if (currentNumber % 1 != 0){
            tv.setText(String.valueOf(currentNumber));
        }
        else{
            int intNumber = (int) currentNumber;
            tv.setText(String.valueOf(intNumber));
        }

        currentNumber = 0;
    }
}