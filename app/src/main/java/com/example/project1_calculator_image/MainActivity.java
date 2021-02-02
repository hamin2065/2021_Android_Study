package com.example.project1_calculator_image;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;


public class MainActivity extends AppCompatActivity {

    enum Operation{
        MINUS, PLUS, MULTIPLE, DIVIDE
    }

    enum Page{
        TAMAGO, MEMO, RECYCLE
    }

    double num1;
    double num2;
    Operation operation;
    boolean isOperated = false;

    TextView textViewAnswer;
    Button buttonC;
    Button buttonMC;
    Button buttonMR;
    Button buttonMPlus;
    ImageView buttonBackSpace;
    Button buttonPlusMinus;
    Button buttonPercentage;
    Button buttonDivide;
    Button buttonMultiple;
    Button buttonMinus;
    Button buttonPlus;
    Button buttonResult;
    Button buttonPoint;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewAnswer = (TextView) findViewById(R.id.textViewAnswer);
        buttonC = (Button)findViewById(R.id.buttonC);
        buttonMC = (Button)findViewById(R.id.buttonMC);
        buttonMR = (Button)findViewById(R.id.buttonMR);
        buttonMPlus = (Button)findViewById(R.id.buttonMPlus);
        //BackSpace -> image view
        buttonBackSpace = (ImageView)findViewById(R.id.buttonBackSpace);
        buttonPlusMinus = (Button)findViewById(R.id.buttonPlusMinus);
        buttonPercentage = (Button)findViewById(R.id.buttonPercentage);
        buttonDivide = (Button)findViewById(R.id.buttonDivide);
        buttonMultiple = (Button)findViewById(R.id.buttonMultiple);
        buttonMinus = (Button)findViewById(R.id.buttonMinus);
        buttonPlus = (Button)findViewById(R.id.buttonPlus);
        buttonResult = (Button)findViewById(R.id.buttonResult);
        buttonPoint = (Button)findViewById(R.id.buttonPoint);
        button0 = (Button)findViewById(R.id.button0);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        button5 = (Button)findViewById(R.id.button5);
        button6 = (Button)findViewById(R.id.button6);
        button7 = (Button)findViewById(R.id.button7);
        button8 = (Button)findViewById(R.id.button8);
        button9 = (Button)findViewById(R.id.button9);


        button0.setOnClickListener(view -> {numButton(0);});
        button1.setOnClickListener(view -> {numButton(1);});
        button2.setOnClickListener(view -> {numButton(2);});
        button3.setOnClickListener(view -> {numButton(3);});
        button4.setOnClickListener(view -> {numButton(4);});
        button5.setOnClickListener(view -> {numButton(5);});
        button6.setOnClickListener(view -> {numButton(6);});
        button7.setOnClickListener(view -> {numButton(7);});
        button8.setOnClickListener(view -> {numButton(8);});
        button9.setOnClickListener(view -> {numButton(9);});

        buttonC.setOnClickListener(view -> {clear();});
        buttonMC.setOnClickListener(view -> {
            try {
                goToPage(Page.TAMAGO);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        buttonMR.setOnClickListener(view -> {
            try {
                goToPage(Page.MEMO);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        buttonMPlus.setOnClickListener(view -> {
            try {
                goToPage(Page.RECYCLE);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        buttonBackSpace.setOnClickListener(view -> {backSpace();});
        buttonPlusMinus.setOnClickListener(view -> {PlusMinus();});
        buttonPercentage.setOnClickListener(view -> {percentage();});
        buttonDivide.setOnClickListener(view -> {operateButton(Operation.DIVIDE);});
        buttonMultiple.setOnClickListener(view -> {operateButton(Operation.MULTIPLE);});
        buttonMinus.setOnClickListener(view -> {operateButton(Operation.MINUS);});
        buttonPlus.setOnClickListener(view -> {operateButton(Operation.PLUS);});
        buttonResult.setOnClickListener(view -> {result();});
        buttonPoint.setOnClickListener(view -> {Point();});

    }


    //Intent, getApplicationContext - 특히 Context가 뭔지 알아오기

    private void goToPage(Page page) throws IllegalAccessException {
        Intent intent;
        switch(page){
            case TAMAGO:
                intent = new Intent(getApplicationContext(), TamagoActivity.class);
                break;
            case MEMO:
                intent = new Intent(getApplicationContext(), MemoActivity.class);
                break;
            case RECYCLE:
                intent = new Intent(getApplicationContext(), RecycleActivity.class);
                break;
            default:
                throw new IllegalAccessException("Unexpected value: " + page);
        }
        startActivity(intent);
    }

    private void backSpace(){
        String nowNum = textViewAnswer.getText().toString();
        StringBuffer sb = new StringBuffer(nowNum);
        sb.deleteCharAt(sb.length()-1);
        //if(sb.length()-1 >= 0) sb.deleteCharAt(sb.length()-1);
        //else Toast.makeText(getApplicationContext(), "NO more num to erase", Toast.LENGTH_LONG).show();
        if(sb.toString().equals("")) sb.append("0");
        textViewAnswer.setText(sb.toString());

        //지우기 전에 (deleteCharAt 하기 전에) sb.length() == 1 이면 문자를 0으로 바꿔준다.
        //지우고 나서 (deleteCharAt 하고 나서) sb.length() == 1 이면 문자를 0으로 바꿔준다.
        //지우기 나서 (deleteCharAt 하고 나서) sb.length() == 1 이면 문자를 0으로 바꿔준다.
    }

    private void clear(){
        textViewAnswer.setText("0");
        isOperated = false;
        num1 = 0;
        num2 = 0;
    }

    private void PlusMinus(){
        textViewAnswer.setText(String.valueOf(Double.parseDouble(textViewAnswer.getText().toString())*(-1)));
    }

    private void Point(){
        String result = textViewAnswer.getText().toString();
        if(!result.contains(".")){
            result += ".";
            textViewAnswer.setText(result);
        }
    }

    private void percentage(){
        textViewAnswer.setText(String.valueOf(Double.parseDouble(textViewAnswer.getText().toString())*(0.01)));
    }


    private void numButton(int num){
        if(isOperated){
            textViewAnswer.setText(String.valueOf(num));
        }else{
            String result = textViewAnswer.getText().toString();
            if(result.equals("0"))result = String.valueOf(num);
            else result += String.valueOf(num);
            textViewAnswer.setText(result);
        }
        isOperated = false;
    }

    private void operateButton(Operation operate){
        num1 = Double.parseDouble(textViewAnswer.getText().toString());
        operation = operate;
        isOperated = true;
    }
    private void result(){

        num2 = Double.parseDouble(textViewAnswer.getText().toString());
        switch(operation){
            case PLUS:
                num1 += num2;
                //textViewAnswer.setText(String.valueOf(num1));
                break;
            case MINUS:
                num1 -= num2;
                //textViewAnswer.setText(String.valueOf(num1));
                break;
            case MULTIPLE:
                num1 *= num2;
                //textViewAnswer.setText(String.valueOf(num1));
                break;
            case DIVIDE:
                num1 /= num2;
                //textViewAnswer.setText(String.valueOf(num1));
                break;
        }

        textViewAnswer.setText(String.valueOf(num1));
    }

}