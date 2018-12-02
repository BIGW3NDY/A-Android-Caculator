package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class MainActivity extends AppCompatActivity {
    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btnC;
    Button btnBracket;
    Button btnDel;
    Button btnDiv;
    Button btnMul;
    Button btnMin;
    Button btnAdd;
    Button btnDot;
    Button btnEqual;
    String input = "";
    String output ="";
    EditText text;
    EditText text1;

    ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
    int bracketStat = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = (Button)findViewById(R.id.btn0);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn7 = (Button)findViewById(R.id.btn7);
        btn8 = (Button)findViewById(R.id.btn8);
        btn9 = (Button)findViewById(R.id.btn9);
        btnC = (Button)findViewById(R.id.C);
        btnBracket = (Button)findViewById(R.id.bracket);
        btnDel = (Button)findViewById(R.id.back);
        btnDiv =(Button)findViewById(R.id.divid);
        btnMul = (Button)findViewById(R.id.mul);
        btnMin = (Button)findViewById(R.id.min);
        btnAdd = (Button)findViewById(R.id.add);
        btnDot = (Button)findViewById(R.id.dot);
        btnEqual = (Button)findViewById(R.id.equal);
        text = (EditText) findViewById(R.id.text);
        text1 = (EditText) findViewById(R.id.text1);

        btn0.setOnClickListener(buttonListener);
        btn1.setOnClickListener(buttonListener);
        btn2.setOnClickListener(buttonListener);
        btn3.setOnClickListener(buttonListener);
        btn4.setOnClickListener(buttonListener);
        btn5.setOnClickListener(buttonListener);
        btn6.setOnClickListener(buttonListener);
        btn7.setOnClickListener(buttonListener);
        btn8.setOnClickListener(buttonListener);
        btn9.setOnClickListener(buttonListener);
        btnC.setOnClickListener(buttonListener);
        btnDel.setOnClickListener(buttonListener);
        btnDiv.setOnClickListener(buttonListener);
        btnMul.setOnClickListener(buttonListener);
        btnMin.setOnClickListener(buttonListener);
        btnAdd.setOnClickListener(buttonListener);
        btnDot.setOnClickListener(buttonListener);
        btnEqual.setOnClickListener(buttonListener);
        btnBracket.setOnClickListener(buttonListener);
    }

    public Button.OnClickListener buttonListener = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn0:
                    input += "0";
                    bracketStat = 1;
                    break;
                case R.id.btn1:
                    input += "1";
                    bracketStat = 1;
                    break;
                case R.id.btn2:
                    input += "2";
                    bracketStat = 1;
                    break;
                case R.id.btn3:
                    input += "3";
                    bracketStat = 1;
                    break;
                case R.id.btn4:
                    input += "4";
                    bracketStat = 1;
                    break;
                case R.id.btn5:
                    input += "5";
                    bracketStat = 1;
                    break;
                case R.id.btn6:
                    input += "6";
                    bracketStat = 1;
                    break;
                case R.id.btn7:
                    input += "7";
                    bracketStat = 1;
                    break;
                case R.id.btn8:
                    input += "8";
                    bracketStat = 1;
                    break;
                case R.id.btn9:
                    input += "9";
                    bracketStat = 1;
                    break;
                case R.id.C:
                    input = "";
                    bracketStat = 0;
                    output = "";
                    break;
                case R.id.back:
                    input = input.substring(0,input.length()-1);
                    break;
                case R.id.divid:
                    input +="/";
                    bracketStat = 0;
                    break;
                case R.id.min:
                    input +="-";
                    bracketStat = 0;
                    break;
                case R.id.add:
                    input +="+";
                    bracketStat = 0;
                    break;
                case R.id.mul:
                    input +="*";
                    bracketStat = 0;
                    break;
                case R.id.dot:
                    input +=".";
                    bracketStat = -1;
                    break;
                case R.id.bracket:
                    if(bracketStat == 0){
                        input += "(";
                    }
                    else {
                        input +=")";
                    }
                    break;
                case R.id.equal:
                    System.out.println(input);
                    try {
//                        System.out.println("!!!!!!!!!!!"+engine.eval(input));
//                        System.out.println("|||||||||||"+engine.eval(input).getClass().getName());
                        output = input;
                        input = String.valueOf(engine.eval(input));
                    } catch (ScriptException e) {
                        e.printStackTrace();
                    }
            }
            text1.setText(output);
            if(text1.length()>20) text1.setTextSize(25);
            else text1.setTextSize(30);

            text.setText(input);
            if(text.length()>10) text.setTextSize(30);
            else text.setTextSize(50);

            text.setSelection(input.length());
        }
    };
}
