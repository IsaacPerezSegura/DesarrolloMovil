package com.isaacperezsegura.calculadora;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private String firstAmount = "",secondAmount = "";
    private static Button value;
    private EditText input,error;
    private char operator = ' ';
    String operators = "/*-+";
    private boolean period = false, result = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (EditText) findViewById(R.id.input);
        error = (EditText) findViewById(R.id.error);
    }
    public void writting(View view){
        value = (Button) view;
        try{
            Integer.parseInt(value.getText().toString());
            if(firstAmount.length()<=Double.SIZE) {
                if (operator == ' ' && !result) {
                    firstAmount = firstAmount + value.getText().toString();
                    input.setText(firstAmount);
                } else if(operator != ' '){
                    secondAmount = secondAmount + value.getText().toString();
                    input.setText(firstAmount+operator+secondAmount);
                }
            }
        }catch(Exception e){
            if(operator==' ') {
                switch (value.getText().charAt(0)) {
                    case '/':
                        input.setText(input.getText().toString() + "/");
                        period = false;
                        operator = '/';
                        break;
                    case '*':
                        input.setText(input.getText().toString() + "*");
                        period = false;
                        operator = '*';
                        break;
                    case '+':
                        input.setText(input.getText().toString() + "+");
                        period = false;
                        operator = '+';
                        break;
                    case '-':
                        input.setText(input.getText().toString() + "-");
                        period = false;
                        operator = '-';
                        break;
                    case '.':
                        if(!period){
                            period=true;
                            firstAmount = firstAmount + ".";
                            input.setText(firstAmount);
                        }
                        break;
                }
            }else if(operator!=' ' && value.getText().toString().equals(".")){
                switch (value.getText().charAt(0)) {
                    case '.':
                        if(!period){
                            period=true;
                            secondAmount = secondAmount + ".";
                            input.setText(firstAmount+operator+secondAmount);
                        }
                        break;
                }
            }else if((operators.indexOf(value.getText().charAt(0))!=-1 || value.getText().toString().equals("="))
                    && !secondAmount.equals("") && !firstAmount.equals("")
                    && secondAmount.charAt(secondAmount.length()-1)!='.'){
                result = true;
                error.setText("el punto es "+period);
                switch (operator) {
                    case '/':
                        if(Double.parseDouble(secondAmount)==0.0){
                            error.setText("No se puede dividir entre cero");
                            error.setTextColor(Color.RED);
                        }else {
                            firstAmount = String.valueOf(Double.parseDouble(firstAmount) /  Double.parseDouble(secondAmount));
                            secondAmount = "";
                            if(!value.getText().toString().equals("=")){
                                operator = operators.charAt(operators.indexOf(value.getText().charAt(0)));
                                period = false;
                                input.setText(firstAmount + operator);
                            }else {
                                operator = ' ';
                                period = true;
                                input.setText(firstAmount);
                            }
                        }
                        break;
                    case '*':
                        firstAmount = String.valueOf(Double.parseDouble(firstAmount) *  Double.parseDouble(secondAmount));
                        secondAmount = "";
                        if(!value.getText().toString().equals("=")){
                            operator = operators.charAt(operators.indexOf(value.getText().charAt(0)));
                            period = false;
                            input.setText(firstAmount + operator);
                        }else {
                            operator = ' ';
                            period = true;
                            input.setText(firstAmount);
                        }
                        break;
                    case '+':
                        firstAmount = String.valueOf(Double.parseDouble(firstAmount) +  Double.parseDouble(secondAmount));
                        secondAmount = "";
                        if(!value.getText().toString().equals("=")){
                            operator = operators.charAt(operators.indexOf(value.getText().charAt(0)));
                            period = false;
                            input.setText(firstAmount + operator);
                        }else {
                            operator = ' ';
                            period = true;
                            input.setText(firstAmount);
                        }
                        break;
                    case '-':
                        firstAmount = String.valueOf(Double.parseDouble(firstAmount) -  Double.parseDouble(secondAmount));
                        secondAmount = "";
                        if(!value.getText().toString().equals("=")){
                            operator = operators.charAt(operators.indexOf(value.getText().charAt(0)));
                            period = false;
                            input.setText(firstAmount + operator);
                        }else {
                            operator = ' ';
                            period = true;
                            input.setText(firstAmount);
                        }
                        break;
                }
            }
        }
    }
}
