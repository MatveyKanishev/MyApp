package com.example.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button plus, ce, division, multiplication, erase, seven, eight, nine, four, five, six, minus, one, two, three, comma, zero, result;
    TextView line, line_two;
    String Line="";
    double a, b, c;
    int znak=0, indikator=0;
    Handler handler = new Handler();


    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Я стартовал", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Я остановился", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "ааааааа", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "Я востановление(после остановки)", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "востановление(после паузы)", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Я родился", Toast.LENGTH_LONG).show();
        zero=findViewById(R.id.zero);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);
        five=findViewById(R.id.five);
        six=findViewById(R.id.six);
        seven=findViewById(R.id.seven);
        eight=findViewById(R.id.eight);
        nine=findViewById(R.id.nine);
        comma=findViewById(R.id.point);
        plus=findViewById(R.id.plus);
        minus=findViewById(R.id.minus);
        multiplication=findViewById(R.id.multiplication);
        division=findViewById(R.id.division);
        erase=findViewById(R.id.erase);
        ce=findViewById(R.id.ce);
        result=findViewById(R.id.result);
        line=findViewById(R.id.line);
        line_two=findViewById(R.id.line_two);
        ce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Line="";
                znak=0;

                line.setText(Line);
                line_two.setText(Line);

            }
        });
//        erase.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String num=line.getText().toString();
//                if (num.equals(""))
//                    line.setText(num);
//                else {
//                    String[]as=num.split("");
//                    Line="";
//                    for (int i = 0; i <as.length-1; i++) {
//                        Line=Line+as[i];
//                    }
//                    line.setText(Line);
//                }
//
//
//
//            }
//        });
    }
    public void num(View button){
        String num=line.getText().toString();
        if (indikator==1){
            Line="";
            line.setText(Line);
            indikator=0;
        }
        if (num.length()<11){
        switch (button.getId()){
            case R.id.zero:
                Line=Line+"0";break;
            case R.id.one:
                Line = Line + "1";
                break;
            case R.id.two:
                Line = Line + "2";
                break;
            case R.id.three:
                Line = Line + "3";
                break;
            case R.id.four:
                Line = Line + "4";
                break;
            case R.id.five:
                Line = Line + "5";
                break;
            case R.id.six:
                Line = Line + "6";
                break;
            case R.id.seven:
                Line = Line + "7";
                break;
            case R.id.eight:
                Line = Line + "8";
                break;
            case R.id.nine:
                Line = Line + "9";
                break;
            case R.id.point:

                if (num.length() <= 9 && num.length() > 0) {
                    String[] as = num.split("");
                    int gg = 0;
                    for (int i = 0; i < num.length() - 1; i++) {
                        if (as[i + 2].equals(".")) {
                            gg = 1;
                        }

                    }
                    if (gg != 1) {
                        Line = Line + ".";
                    }
                }
                break;
        }
            line.setText(Line);
        }



    }

    public void firstNum(View button){
        String num=line.getText().toString();
        String num_two = line_two.getText().toString();
        if(!num.equals("") && num_two.equals("")){
            switch (button.getId()){
                case R.id.plus: Line=Line+" +";break;
                case R.id.minus: Line=Line+" -";break;
                case R.id.multiplication: Line=Line+" *";break;
                case R.id.division: Line=Line+" /";break;
            }
            line_two.setText(Line);
            Line="";
            line.setText(Line);
        }
        if(!num.equals("") && !num_two.equals("")){
           String []b_=num_two.split(" ");
           String []c_=num.split(",");
           a=Double.parseDouble(c_[0]);
            b=Double.parseDouble(b_[0]);
            String Char=b_[1];
            switch (Char) {
                case "+":
                    c = b + a;
                    break;
                case "-":
                    c = b - a;
                    break;
                case "*":
                    c = b * a;
                    break;
                case "/":
                    if (a != 0) {
                        c = b / a;
                    }
                    break;
            }
            Line=""+c;
            if (Line.length()>11){
            String[] s = Line.split("E");
            if (s.length == 2) {


                String[] s1 = s[0].split("");
                String Line2 = "";
                for (int i = 0; i <5; i++) {
                    Line2 = Line2 + s1[i];
                }
                Line = Line2 + "E" + s[1];
            }
            else{
                String[] s1 = Line.split("\\.");
                String[] s2 = s1[1].split("");
                String Line2="";
                for (int i = 0; i < 6; i++) {
                    Line2=Line2+s2[i];
                }
                Line=s1[0]+"."+Line2;
                }
            }
            c=Double.parseDouble(Line);
            if (c%1==0 && Line.indexOf("E")<0){
                String []s1=Line.split("\\.");
                Line=s1[0];

            }

            switch (button.getId()){
                case R.id.plus:
                    Line=Line+" +";break;
                case R.id.minus:
                    Line=Line+" -";break;
                case R.id.multiplication:
                    Line=Line+" *";break;
                case R.id.division:
                    Line=Line+" /";break;
            }

            line_two.setText(Line);
            line.setText("");
            Line="";

        }

    }
    public void result(View button){
        String num=line.getText().toString();
        String num_two = line_two.getText().toString();
        if(!num.equals("") && !num_two.equals("")){
            String []b_=num_two.split(" ");

            a=Double.parseDouble(num);
            b=Double.parseDouble(b_[0]);

            if (!line_two.getText().equals("")){
                String Char=b_[1];
                switch (Char){
                    case "+": c=b+a;break;
                    case "-": c=b-a;break;
                    case "*": c=b*a;break;
                    case "/": if(a!=0) {c=b/a;}break;

                }

                Line=""+c;
                if (Line.length()>11){

                String[] s = Line.split("E");
                if (s.length == 2) {
                    String[] s1 = s[0].split("");
                    String Line2 = "";
                    for (int i = 0; i <6; i++) {
                        Line2 = Line2 + s1[i];
                    }
                    Line = Line2 + "E" + s[1];
                }
                else{

                        String[] s1 = Line.split("\\.");
                        String[] s2 = s1[1].split("");
                        String Line2 = "";
                        for (int i = 0; i < 6; i++) {
                            Line2 = Line2 + s2[i];
                        }
                        Line = s1[0] + "." + Line2;
                    }
                }
                }
            c=Double.parseDouble(Line);
            if (c%1==0 && Line.indexOf("E")<0){
                String []s1=Line.split("\\.");
                Line=s1[0];

            }

                line_two.setText("");
                line.setText(Line);
                indikator=1;
        }

    }







    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Я на паузе", Toast.LENGTH_LONG).show();
    }
}
