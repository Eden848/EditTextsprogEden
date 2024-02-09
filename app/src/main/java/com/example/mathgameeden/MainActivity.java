package com.example.mathgameeden;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{

    private TextView num1;
    private TextView num2;
    private TextView num3;
    private TextView num4;
    private TextView num5;
    private TextView num6;
    private EditText answ1;
    private EditText answ2;
    private EditText answ3;
    private Button check1;
    private Button check2;
    private Button check3;
    private Button newgame;
    private ImageView wrong1;
    private ImageView wrong2;
    private ImageView wrong3;
    private int rand_num1;
    private int rand_num2;
    private int rand_num3;
    private int rand_num4;
    private int rand_num5;
    private int rand_num6;
    int counter;
    double score;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1=findViewById(R.id.textView1);
        num2=findViewById(R.id.textView2);
        num3=findViewById(R.id.textView3);
        num4=findViewById(R.id.textView4);
        num5=findViewById(R.id.textView5);
        num6=findViewById(R.id.textView6);
        answ1=(EditText)findViewById(R.id.editTextNumber);
        answ2=findViewById(R.id.editTextNumber2);
        answ3=findViewById(R.id.editTextNumber3);
        check1=findViewById(R.id.button1);
        check2=findViewById(R.id.button2);
        check3=findViewById(R.id.button3);
        newgame=findViewById(R.id.buttonnew);
        wrong1=findViewById(R.id.imageView1);
        wrong2=findViewById(R.id.imageView2);
        wrong3=findViewById(R.id.imageView3);

         rand_num1=get_randomNum();
         rand_num2=get_randomNum();

        num1.setText(""+rand_num1);
        num2.setText(""+rand_num2);
        num3.setText("number");
        num4.setText("number");
        num5.setText("number");
        num6.setText("number");

        wrong1.setVisibility(View.INVISIBLE);
        wrong2.setVisibility(View.INVISIBLE);
        wrong3.setVisibility(View.INVISIBLE);

    }
    public static int get_randomNum()
    {
        Random random=new Random();
        return(int)(Math.random()*89+10);
    }

    public void check1(View view)
    {
        String st1=answ1.getText().toString();
        wrong1.setVisibility(view.VISIBLE);
        if (Integer.parseInt(st1)== (rand_num1+rand_num2))
        {
            wrong1.setImageResource(R.drawable.vsighn);
            counter++;
        }
        else
        {
            wrong1.setImageResource(R.drawable.xsighn);
        }
        rand_num3=(rand_num1+rand_num2);
        num3.setText(""+rand_num3);
        rand_num4=get_randomNum();
        num4.setText(""+rand_num4);
    }


    public void check2(View view)
    {
        String st2=answ2.getText().toString();
        wrong2.setVisibility(view.VISIBLE);
         if (Integer.parseInt(st2) == (rand_num3+rand_num4))
        {
            wrong2.setImageResource(R.drawable.vsighn);
            counter++;
        }
        else
        {
            wrong2.setImageResource(R.drawable.xsighn);
        }
        rand_num5=rand_num3+rand_num4;
        num5.setText(""+ rand_num5);
        rand_num6=get_randomNum();
        num6.setText(""+rand_num6);


    }

    public void check3(View view)
    {
        String st3=answ3.getText().toString();
        wrong3.setVisibility(view.VISIBLE);
        if (Integer.parseInt(st3) == (rand_num5+rand_num6))
        {
            wrong3.setImageResource(R.drawable.vsighn);
            counter++;
        }
        else
        {
            wrong3.setImageResource(R.drawable.xsighn);
        }
        score= ((double)counter/3) *100;
        Toast.makeText(MainActivity.this, (counter+ "/3, "+score+"%"), Toast.LENGTH_SHORT).show();
        counter=0;
        rand_num1 = (rand_num5 + rand_num6);
        num1.setText("" + rand_num1);
    }

    public void restart(View view)
    {
        wrong1.setVisibility(View.INVISIBLE);
        wrong2.setVisibility(View.INVISIBLE);
        wrong3.setVisibility(View.INVISIBLE);

        rand_num1 =  get_randomNum();
        rand_num2 =  get_randomNum();

        num1.setText("" + rand_num1);
        num2.setText("" + rand_num2);
        num3.setText("number");
        num4.setText("number");
        num5.setText("number");
        num6.setText("number");

        answ1.setText(null);
        answ2.setText(null);
        answ3.setText(null);

    }
}