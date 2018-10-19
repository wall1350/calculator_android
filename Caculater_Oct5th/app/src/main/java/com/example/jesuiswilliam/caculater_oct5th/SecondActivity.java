package com.example.jesuiswilliam.caculater_oct5th;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

//The view controller for the horizontal view
//Je doute donc je pense, je pense donc je suis
public class SecondActivity extends AppCompatActivity {
    double sum = 0;
    double secondNum = 0;
    String symbol = "";
    String passValue = "";
    boolean hasAPoint1 = false;
    boolean hasAPoint2 = false;
    boolean changeToSecond = false;
    boolean infinity = false;
    public TextView sumText;

    boolean negativeIsBanned = false;//in some specail cases , there is not allowed negative number existed
    boolean logIsActivated = false;         //log10 flag
    boolean poewrOfTenActivated = false;    //10^x flag
    boolean powerOfEActivated = false;      //e^x flag

    boolean lnActivated = false;            //ln flag
    boolean xPowYActivated = false;         //xPowY flag
    boolean xSqrt2Activated = false;
    boolean xSqrt3Activated = false;
    boolean xSqrtYActivated = false;

    boolean sinActivated = false;           //sin flag
    boolean cosActivated = false;           //cos flag
    boolean tanActivated = false;           //tan flag
    boolean xFacActivated = false;          //fac flag

    boolean sinhActivated = false;           //sinh flag
    boolean coshActivated = false;           //cosh flag
    boolean tanhActivated = false;           //tanh flag
    boolean eeActivated = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sumText = (TextView)findViewById(R.id.sumText1);


        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.i("info", "landscape"); // horizontal screen
            setContentView(R.layout.changed_view);

        }
        else if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            Log.i("info", "portrait"); // vertical screen
            setContentView(R.layout.activity_main);
            Intent intent1=new Intent(SecondActivity.this,MainActivity.class); //建立一個intent
            //intent1.putExtra("sumText",passValue);
            startActivity(intent1);
            finish();
        }
    }
    //the method to clear all
    public  void ac(){
        sumText = (TextView)findViewById(R.id.sumText1);
        sumText.setText("0");
        sum = 0;
        acButRemainSum();
    }

    public  void acButRemainSum(){
        changeToSecond = false;
        secondNum = 0;
        hasAPoint1 = false;
        hasAPoint2 = false;
        infinity = false;
        negativeIsBanned = false;
        logIsActivated = false;
        poewrOfTenActivated = false;
        powerOfEActivated = false;
        lnActivated = false;
        xPowYActivated = false;
        xSqrt2Activated = false;
        xSqrt3Activated = false;
        xSqrtYActivated = false;
        sinActivated = false;
        cosActivated = false;
        tanActivated = false;
        xFacActivated =false;
        sinhActivated = false;
        coshActivated = false;
        tanhActivated = false;
        eeActivated = false;
    }
    //calculate the add or sub or mul or div
    public double deal(double a,double b,String s){
        if(s ==" + "){
            a = a + b;
        }
        else if(s ==" - "){
            a = a - b;
        }
        else if(s ==" × "){
            a = a * b;
        }
        else if(s ==" ÷ " && b!=0){
            a = a / b;
        }
        return a;
    }
    //calculate factorial
    public double fac(double number) {
        if (number <= 1)
            return 1;
        else
            return number * fac(number - 1);
    }

    //controllers ~ the following is button controllers ~~  //

    //button ac controller
    public void func_ac(View view){
        ac();
    }
    //button ± controller
    public void func_NeativePositive(View view){
        sumText = (TextView)findViewById(R.id.sumText1);
        if(changeToSecond == false && negativeIsBanned==false){
            if(sum != 0){ //0 mul anything is equal to "0"!!!!
                sum = sum * -1;


                if(sum<0){
                    sumText.setText("("+String.valueOf(sum)+")");
                }
                else{
                    sumText.setText(String.valueOf(sum));
                }

            }
        }
        else if(negativeIsBanned==false){
            if(secondNum != 0) { //0 mul anything is equal to "0"!!!!
                secondNum = secondNum * -1;
                String [] tempArray = null;
                tempArray = sumText.getText().toString().split(" ");

                if (tempArray.length ==3){
                    if(secondNum<0){
                        sumText.setText(tempArray[0] + " "+tempArray[1] + " "+"("+String.valueOf(secondNum)+")");

                    }
                    else{
                        sumText.setText(String.valueOf(tempArray[0] + " "+tempArray[1] + " " +String.valueOf(secondNum)));
                    }
                }

            }
        }


    }
    //button 0~9 controller
    public void input(View view){
        sumText = (TextView)findViewById(R.id.sumText1);
        if (changeToSecond == false){
            if (sum == 0.0 && hasAPoint1 ==false){                    //if the value is equal to 0, input new number to replace it
                switch (view.getId()) {         //I found out this method on the web , it can distinguish which button I press
                    case R.id.bt_0:
                        sumText.setText("0");
                        sum = 0;
                        break;
                    case R.id.bt_1:
                        sumText.setText("1");
                        sum = 1;
                        break;
                    case R.id.bt_2:
                        sumText.setText("2");
                        sum = 2;
                        break;
                    case R.id.bt_3:
                        sumText.setText("3");
                        sum = 3;
                        break;
                    case R.id.bt_4:
                        sumText.setText("4");
                        sum = 4;
                        break;
                    case R.id.bt_5:
                        sumText.setText("5");
                        sum = 5;
                        break;
                    case R.id.bt_6:
                        sumText.setText("6");
                        sum = 6;
                        break;
                    case R.id.bt_7:
                        sumText.setText("7");
                        sum = 7;
                        break;
                    case R.id.bt_8:
                        sumText.setText("8");
                        sum = 8;
                        break;
                    case R.id.bt_9:
                        sumText.setText("9");
                        sum = 9;
                        break;
                    case R.id.bt_point:
                        sumText.setText("0.");
                        hasAPoint1 = true;
                        sum = 0;
                        break;

                    default:
                        break;
                }
            }
            else{
                String tempS="";
                String [] tempArray = null;
                switch (view.getId()) {
                    case R.id.bt_0:
                        tempS = sumText.getText().toString()+"0";
                        sumText.setText(tempS);
                        tempArray = tempS.split(" ");
                        sum = Double.valueOf(tempArray[0]).doubleValue();
                        break;
                    case R.id.bt_1:
                        tempS = sumText.getText().toString()+"1";   //positivie value
                        sumText.setText(tempS);
                        tempArray = tempS.split(" ");
                        sum = Double.valueOf(tempArray[0]).doubleValue();
                        break;
                    case R.id.bt_2:
                        tempS = sumText.getText().toString()+"2";
                        sumText.setText(tempS);
                        tempArray = tempS.split(" ");
                        sum = Double.valueOf(tempArray[0]).doubleValue();
                        break;
                    case R.id.bt_3:
                        tempS = sumText.getText().toString()+"3";
                        sumText.setText(tempS);
                        tempArray = tempS.split(" ");
                        sum = Double.valueOf(tempArray[0]).doubleValue();
                        break;
                    case R.id.bt_4:
                        tempS = sumText.getText().toString()+"4";
                        sumText.setText(tempS);
                        tempArray = tempS.split(" ");
                        sum = Double.valueOf(tempArray[0]).doubleValue();
                        break;
                    case R.id.bt_5:
                        tempS = sumText.getText().toString()+"5";
                        sumText.setText(tempS);
                        tempArray = tempS.split(" ");
                        sum = Double.valueOf(tempArray[0]).doubleValue();
                        break;
                    case R.id.bt_6:
                        tempS = sumText.getText().toString()+"6";
                        sumText.setText(tempS);
                        tempArray = tempS.split(" ");
                        sum = Double.valueOf(tempArray[0]).doubleValue();
                        break;
                    case R.id.bt_7:
                        tempS = sumText.getText().toString()+"7";
                        sumText.setText(tempS);
                        tempArray = tempS.split(" ");
                        sum = Double.valueOf(tempArray[0]).doubleValue();
                        break;
                    case R.id.bt_8:
                        tempS = sumText.getText().toString()+"8";
                        sumText.setText(tempS);
                        tempArray = tempS.split(" ");
                        sum = Double.valueOf(tempArray[0]).doubleValue();
                        break;
                    case R.id.bt_9:
                        tempS = sumText.getText().toString()+"9";
                        sumText.setText(tempS);
                        tempArray = tempS.split(" ");
                        sum = Double.valueOf(tempArray[0]).doubleValue();
                        break;
                    default:
                        break;
                }

            }
        }
        else{
            if (secondNum == 0.0 && hasAPoint2 ==false){    //if the value is equal to 0, input new number to replace it
                switch (view.getId()) {                     //I found out this method on the web , it can distinguish which button I press
                    case R.id.bt_0:
                        sumText.setText(sumText.getText().toString()+"0");
                        secondNum = 0;
                        break;
                    case R.id.bt_1:
                        sumText.setText(sumText.getText().toString()+"1");
                        secondNum = 1;
                        break;
                    case R.id.bt_2:
                        sumText.setText(sumText.getText().toString()+"2");
                        secondNum = 2;
                        break;
                    case R.id.bt_3:
                        sumText.setText(sumText.getText().toString()+"3");
                        secondNum = 3;
                        break;
                    case R.id.bt_4:
                        sumText.setText(sumText.getText().toString()+"4");
                        secondNum = 4;
                        break;
                    case R.id.bt_5:
                        sumText.setText(sumText.getText().toString()+"5");
                        secondNum = 5;
                        break;
                    case R.id.bt_6:
                        sumText.setText(sumText.getText().toString()+"6");
                        secondNum = 6;
                        break;
                    case R.id.bt_7:
                        sumText.setText(sumText.getText().toString()+"7");
                        secondNum = 7;
                        break;
                    case R.id.bt_8:
                        sumText.setText(sumText.getText().toString()+"8");
                        secondNum = 8;
                        break;
                    case R.id.bt_9:
                        sumText.setText(sumText.getText().toString()+"9");
                        secondNum = 9;
                        break;

                    default:
                        break;
                }
            }
            else{
                String tempS="";
                String [] tempArray = null;
                switch (view.getId()) {
                    case R.id.bt_0:
                        tempS = sumText.getText().toString()+"0";
                        sumText.setText(tempS);

                        tempArray = tempS.split(" ");
                        //sumText.setText("測試一下" + temp[2]);
                        secondNum = Double.valueOf(tempArray[2]).doubleValue();

                        break;
                    case R.id.bt_1:
                        tempS = sumText.getText().toString()+"1";   //positivie value
                        sumText.setText(tempS);
                        tempArray = tempS.split(" ");
                        //sumText.setText("測試一下" + temp[2]);
                        secondNum = Double.valueOf(tempArray[2]).doubleValue();
                        break;
                    case R.id.bt_2:
                        tempS = sumText.getText().toString()+"2";
                        sumText.setText(tempS);
                        tempArray = tempS.split(" ");
                        //sumText.setText("測試一下" + temp[2]);
                        secondNum = Double.valueOf(tempArray[2]).doubleValue();
                        break;
                    case R.id.bt_3:
                        tempS = sumText.getText().toString()+"3";
                        sumText.setText(tempS);
                        tempArray = tempS.split(" ");
                        //sumText.setText("測試一下" + temp[2]);
                        secondNum = Double.valueOf(tempArray[2]).doubleValue();
                        break;
                    case R.id.bt_4:
                        tempS = sumText.getText().toString()+"4";
                        sumText.setText(tempS);
                        tempArray = tempS.split(" ");
                        //sumText.setText("測試一下" + temp[2]);
                        secondNum = Double.valueOf(tempArray[2]).doubleValue();
                        break;
                    case R.id.bt_5:
                        tempS = sumText.getText().toString()+"5";
                        sumText.setText(tempS);
                        tempArray = tempS.split(" ");
                        //sumText.setText("測試一下" + tempArray[2]);
                        secondNum = Double.valueOf(tempArray[2]).doubleValue();
                        break;
                    case R.id.bt_6:
                        tempS = sumText.getText().toString()+"6";
                        sumText.setText(tempS);
                        tempArray = tempS.split(" ");
                        //sumText.setText("測試一下" + temp[2]);
                        secondNum = Double.valueOf(tempArray[2]).doubleValue();
                        break;
                    case R.id.bt_7:
                        tempS = sumText.getText().toString()+"7";
                        sumText.setText(tempS);
                        tempArray = tempS.split(" ");
                        //sumText.setText("測試一下" + temp[2]);
                        secondNum = Double.valueOf(tempArray[2]).doubleValue();
                        break;
                    case R.id.bt_8:
                        tempS = sumText.getText().toString()+"8";
                        sumText.setText(tempS);
                        tempArray = tempS.split(" ");
                        //sumText.setText("測試一下" + temp[2]);
                        secondNum = Double.valueOf(tempArray[2]).doubleValue();
                        break;
                    case R.id.bt_9:
                        tempS = sumText.getText().toString()+"9";
                        sumText.setText(tempS);
                        tempArray = tempS.split(" ");
                        //sumText.setText("測試一下" + temp[2]);
                        secondNum = Double.valueOf(tempArray[2]).doubleValue();
                        break;
                    default:
                        break;
                }

            }
        }
    }
    //button % controller
    public void persent(View view){
        sumText = (TextView)findViewById(R.id.sumText1);
        String [] tempArray = null;
        tempArray = sumText.getText().toString().split(" ");
        if(sum!=0 && tempArray.length == 1 ){     //0 mul 0.01 still equal to 0
            sum = sum * 0.01;
            if(sum<0){
                sumText.setText("("+String.valueOf(sum)+")");
            }
            else{
                sumText.setText(String.valueOf(sum));
            }

        }
        else if(secondNum !=0 && tempArray.length == 3 ){     //0 mul 0.01 still equal to 0
            secondNum = secondNum * 0.01;

            if(secondNum<0){
                sumText.setText(tempArray[0]+" "+tempArray[1]+" "+ "("+String.valueOf(secondNum)+")");
            }
            else{
                sumText.setText(tempArray[0]+" "+tempArray[1]+" "+String.valueOf(secondNum));
            }
        }
    }
    //button + controller
    public void add(View view){
        sumText = (TextView)findViewById(R.id.sumText1);
        if(changeToSecond == false && logIsActivated==false){

            changeToSecond = true;
            symbol = " + ";
            sumText.setText(sumText.getText().toString()+ symbol);
        }
        else if(symbol!=" + " && logIsActivated==false&&changeToSecond == false){

            symbol = " + ";
            String [] tempArray = null;
            tempArray = sumText.getText().toString().split(" ");
            //String theOrignalNumS = tempArray[0];
            if (tempArray.length ==3){
                sumText.setText(tempArray[0] + symbol +tempArray[2]);
            }
            else if(tempArray.length < 3){
                sumText.setText(tempArray[0] + symbol);
            }
            changeToSecond = true;
        }

    }
    //button - controller
    public void sub(View view){
        sumText = (TextView)findViewById(R.id.sumText1);
        if(changeToSecond == false && logIsActivated==false){

            changeToSecond = true;
            symbol = " - ";
            sumText.setText(sumText.getText().toString()+ symbol);
        }
        else if(symbol!=" - " && logIsActivated==false&&changeToSecond == false){

            symbol = " - ";
            String [] tempArray = null;
            tempArray = sumText.getText().toString().split(" ");
            //String theOrignalNumS = tempArray[0];
            if (tempArray.length ==3){
                sumText.setText(tempArray[0] + symbol +tempArray[2]);
            }
            else if(tempArray.length < 3){
                sumText.setText(tempArray[0] + symbol);
            }
            changeToSecond = true;
        }
    }
    //button × controller
    public void mul(View view){
        sumText = (TextView)findViewById(R.id.sumText1);
        if(changeToSecond == false && logIsActivated==false){
            changeToSecond = true;
            symbol = " × ";
            sumText.setText(sumText.getText().toString()+ symbol);
        }
        else if(symbol!=" × " && logIsActivated==false &&changeToSecond == false){

            symbol = " × ";
            String [] tempArray = null;
            tempArray = sumText.getText().toString().split(" ");
            //String theOrignalNumS = tempArray[0];
            if (tempArray.length ==3){
                sumText.setText(tempArray[0] + symbol +tempArray[2]);
            }
            else if(tempArray.length < 3){
                sumText.setText(tempArray[0] + symbol);
            }
            changeToSecond = true;
        }

    }
    //button ÷ controller
    public void div(View view){
        sumText = (TextView)findViewById(R.id.sumText1);
        if(changeToSecond == false && logIsActivated==false){

            changeToSecond = true;
            symbol = " ÷ ";
            sumText.setText(sumText.getText().toString()+ symbol);
        }
        else if(symbol!=" ÷ " && logIsActivated==false &&changeToSecond == false){

            symbol = " ÷ ";
            String [] tempArray = null;
            tempArray = sumText.getText().toString().split(" ");
            //String theOrignalNumS = tempArray[0];
            if (tempArray.length ==3){
                sumText.setText(tempArray[0] + symbol +tempArray[2]);
            }
            else if(tempArray.length < 3){
                sumText.setText(tempArray[0] + symbol);
            }
            changeToSecond = true;

        }

    }
    //button = controller
    public void equal(View view){


        sumText = (TextView)findViewById(R.id.sumText1);
        //the case for x div 0
        if(symbol==" ÷ "&& secondNum==0 && infinity == false) {
            sumText.setText("無限大");
            infinity = true;

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {

                @Override
                public void run() {
                    //the thing after a second will be happened
                    ac();
                }
            }, 1000);

        }
        //the case for add sub mul div
        else if( infinity == false
                && secondNum!=0
                && logIsActivated==false
                && poewrOfTenActivated == false
                && powerOfEActivated == false
                && lnActivated==false
                && xPowYActivated == false
                && xSqrt2Activated == false
                && xSqrt3Activated == false
                && xSqrtYActivated == false
                && sinActivated==false
                && cosActivated==false
                && tanActivated==false
                && xFacActivated ==false
                && sinhActivated==false
                && coshActivated==false
                && tanhActivated==false
                && eeActivated == false){
            sum = deal(sum,secondNum,symbol);
            sumText.setText(String.valueOf(sum));

            acButRemainSum();
        }
        //the case for log10
        else if(infinity == false && logIsActivated == true){
            if(secondNum>0){
                sum = Math.log10(secondNum);
                sumText.setText(String.valueOf(sum));
                acButRemainSum();
            }
            else{
                sumText.setText("無限小");
                infinity = true;

                Handler handler = new Handler();
                handler.postDelayed(new Runnable(){

                    @Override
                    public void run() {
                        //the thing after a second will be happened
                        ac();
                    }}, 1000);
            }

        }
        //the case for power of ten
        else if(infinity == false && poewrOfTenActivated == true){
            sum = Math.pow(10,secondNum);
            sumText.setText(String.valueOf(sum));
            acButRemainSum();
        }
        //the case for power of e
        else if(infinity == false && powerOfEActivated == true){
            sum = Math.pow(2.71828182846,secondNum);
            sumText.setText(String.valueOf(sum));
            acButRemainSum();
        }

        //the case for ln
        else if(infinity == false && lnActivated == true){
            if(secondNum>0){
                sum = Math.log(secondNum);
                sumText.setText(String.valueOf(sum));
                acButRemainSum();
                hasAPoint2 = true;
            }
            else{
                sumText.setText("無限小");
                infinity = true;

                Handler handler = new Handler();
                handler.postDelayed(new Runnable(){

                    @Override
                    public void run() {
                        //the thing after a second will be happened
                        ac();
                    }}, 1000);
            }

        }

        //the case for x^y
        else if(infinity == false && xPowYActivated == true){
            sum = Math.pow(sum,secondNum);
            sumText.setText(String.valueOf(sum));
            acButRemainSum();
        }
        //the case for x^(1/y)
        else if(infinity == false && xSqrtYActivated == true){
            sum = Math.pow(sum,1/secondNum);
            sumText.setText(String.valueOf(sum));
            acButRemainSum();
        }

        else if(infinity == false && sinActivated == true){

            sum = Math.sin(secondNum);
            sumText.setText(String.valueOf(sum));
            acButRemainSum();

        }
        else if(infinity == false && cosActivated == true){

            sum = Math.cos(secondNum);
            sumText.setText(String.valueOf(sum));
            acButRemainSum();

        }
        else if(infinity == false && tanActivated == true){

            sum = Math.tan(secondNum);
            sumText.setText(String.valueOf(sum));
            acButRemainSum();

        }
//
        else if(infinity == false && sinhActivated == true){

            sum = Math.sinh(secondNum);
            sumText.setText(String.valueOf(sum));
            acButRemainSum();

        }
        else if(infinity == false && coshActivated == true){

            sum = Math.cosh(secondNum);
            sumText.setText(String.valueOf(sum));
            acButRemainSum();

        }
        else if(infinity == false && tanhActivated == true){

            sum = Math.tanh(secondNum);
            sumText.setText(String.valueOf(sum));
            acButRemainSum();

        }
        else if(infinity == false && eeActivated == true){
            secondNum = Math.pow(10,secondNum);
            sum = sum * secondNum;
            sumText.setText(String.valueOf(sum));
            acButRemainSum();
        }
        else{
            sumText.setText("錯誤");
            Handler handler = new Handler();
            handler.postDelayed(new Runnable(){

                @Override
                public void run() {
                    //the thing after a second will be happened
                    ac();
                }}, 1000);
        }
    }
    //button . controller
    public void addPoint(View view){
        sumText = (TextView)findViewById(R.id.sumText1);
        if(hasAPoint1 ==false && infinity == false && changeToSecond ==false) {
            if(sum == 0){
                sumText.setText("0.");
            }
            else{
                String tempS = sumText.getText().toString();
                sumText = (TextView) findViewById(R.id.sumText1);
                sumText.setText(tempS + ".");
            }
            hasAPoint1 = true;
        }
        else if(hasAPoint2 ==false &&infinity == false && changeToSecond ==true){
            String tempS = sumText.getText().toString();
            sumText = (TextView) findViewById(R.id.sumText1);

            if(secondNum == 0){
                sumText.setText(tempS+"0.");
            }
            else{
                sumText.setText(tempS + ".");
            }
            hasAPoint2 = true;

        }
    }
    //button e  controller
    public void exp(View view){
        sumText = (TextView)findViewById(R.id.sumText1);
        if(sum==0 && changeToSecond==false){
            sum = 2.71828182846;
            sumText.setText("2.71828182846");
            hasAPoint1 = true;
        }
        else if(secondNum==0 && changeToSecond==true){
            secondNum = 2.71828182846;
            sumText.setText(sumText.getText().toString()+"2.71828182846");
            hasAPoint2 = true;
        }
    }
    //button log10  controller
    public void log10(View view){
        sumText = (TextView)findViewById(R.id.sumText1);
        if(changeToSecond==false && logIsActivated==false){
            negativeIsBanned = true;// In log (x), x must larger than 0, this is math rule ~~~~
            sum = 0;
            sumText.setText(" log ");//don't change this format , I use split (" ")in the input()to get the x of logX
            changeToSecond = true;
            logIsActivated = true;
        }

    }
    //button 10^  controller
    public void powerOfTen(View view){
        sumText = (TextView)findViewById(R.id.sumText1);
        if(changeToSecond==false && poewrOfTenActivated==false){
            sum = 0;
            sumText.setText(" 10^ ");//don't change this format , I use split (" ")in the input()to get the x of logX
            changeToSecond = true;
            poewrOfTenActivated = true;
        }

    }
    //button e^  controller
    public void powerOfE(View view){
        sumText = (TextView)findViewById(R.id.sumText1);
        if(changeToSecond==false && powerOfEActivated==false){
            sum = 0;
            sumText.setText(" e^ ");//don't change this format , I use split (" ")in the input()to get the x of logX
            changeToSecond = true;
            powerOfEActivated = true;
        }

    }
    //button   controller
    public void pi(View view){
        sumText = (TextView)findViewById(R.id.sumText1);
        if(sum==0 && changeToSecond==false){
            sum = 3.14159265359;
            sumText.setText("3.14159265359");
            hasAPoint1 = true;
        }
        else if(secondNum==0 && changeToSecond==true){
            secondNum = 3.14159265359;
            sumText.setText(sumText.getText().toString()+"3.14159265359");
            hasAPoint2 = true;
        }
    }
    public void ln(View view){
        sumText = (TextView)findViewById(R.id.sumText1);
        if(changeToSecond==false && lnActivated==false){
            negativeIsBanned = true;// In log (x), x must larger than 0, this is math rule ~~~~
            sum = 0;
            sumText.setText(" ln ");//don't change this format , I use split (" ")in the input()to get the x of logX
            hasAPoint1 = true;
            changeToSecond = true;
            lnActivated = true;
        }

    }
    public void xPowY(View view){
        sumText = (TextView)findViewById(R.id.sumText1);
        if(changeToSecond == false && xPowYActivated==false){
            changeToSecond = true;
            symbol = " ^ ";
            xPowYActivated = true;
            sumText.setText(sumText.getText().toString()+ symbol);
        }
        else if(symbol!=" ^ " && xPowYActivated==false){

            symbol = " ^ ";
            String [] tempArray = null;
            tempArray = sumText.getText().toString().split(" ");
            xPowYActivated = true;
            if (tempArray.length ==3){
                sumText.setText(tempArray[0] + symbol +tempArray[2]);
            }
            else if(tempArray.length < 3){
                sumText.setText(tempArray[0] + symbol);
            }
        }

    }
    public void xSqrt2(View view){
        sumText = (TextView)findViewById(R.id.sumText1);
        if(changeToSecond==false && sinActivated==false){

            sum = Math.sqrt(sum);
            sumText.setText(String.valueOf(sum));
            acButRemainSum();
        }

    }
    public void xSqrt3(View view){
        sumText = (TextView)findViewById(R.id.sumText1);
        if(changeToSecond==false && sinActivated==false){

            sum = Math.pow(sum, 1.0/3.0);// be careful here , if you use 1/3 , the result will be "0"(int format)
            sumText.setText(String.valueOf(sum));
            acButRemainSum();
        }

    }
    public void xSqrtY(View view){
        sumText = (TextView)findViewById(R.id.sumText1);
        if(changeToSecond == false && xSqrtYActivated==false){
            changeToSecond = true;
            symbol = " 開 ";
            xSqrtYActivated = true;
            sumText.setText(sumText.getText().toString()+ symbol);
        }
        else if(symbol!=" 開 " && xSqrtYActivated==false){

            symbol = " 開 ";
            String [] tempArray = null;
            tempArray = sumText.getText().toString().split(" ");
            xSqrtYActivated = true;
            if (tempArray.length ==3){
                sumText.setText(tempArray[0] + "開" +tempArray[2]+"次方");
            }
            else if(tempArray.length < 3){
                sumText.setText(tempArray[0] + symbol);
            }
        }

    }
    public void sin(View view){
        sumText = (TextView)findViewById(R.id.sumText1);
        if(changeToSecond==false && sinActivated==false){

            sum = 0;
            sumText.setText(" sin ");//don't change this format , I use split (" ")in the input()to get the x of logX
            changeToSecond = true;
            sinActivated = true;
        }

    }
    public void cos(View view){
        sumText = (TextView)findViewById(R.id.sumText1);
        if(changeToSecond==false && cosActivated==false){

            sum = 0;
            sumText.setText(" cos ");//don't change this format , I use split (" ")in the input()to get the x of logX
            changeToSecond = true;
            cosActivated = true;
        }

    }
    public void tan(View view){
        sumText = (TextView)findViewById(R.id.sumText1);
        if(changeToSecond==false && tanActivated==false){

            sum = 0;
            sumText.setText(" tan ");//don't change this format , I use split (" ")in the input()to get the x of logX
            changeToSecond = true;
            tanActivated = true;
        }

    }
    public void xFactorial(View view){
        sumText = (TextView)findViewById(R.id.sumText1);
        if(changeToSecond==false && xFacActivated==false){

            //sum = 0;
            String tempS = sumText.getText().toString();
           // sumText.setText(tempS+"!");//don't change this format , I use split (" ")in the input()to get the x of logX

            xFacActivated = true;
             if(sum%2==0||sum%2==1 ||sum<0 ){
                if(sum>170){
                    sumText.setText(String.valueOf("太大了我算不出來"));
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable(){

                        @Override
                        public void run() {
                            //the thing after a second will be happened
                            ac();
                        }}, 1000);
                }
                else{
                    sum = fac(sum);
                    sumText.setText(String.valueOf(sum));
                    acButRemainSum();
                    //changeToSecond = true;
                }
            }

            else{
                sumText.setText("不是正整數，無法計算");
                Handler handler = new Handler();
                handler.postDelayed(new Runnable(){

                    @Override
                    public void run() {
                        //the thing after a second will be happened
                        ac();
                    }}, 1000);
            }
        }
        else if (changeToSecond==true && xFacActivated==false){


            String tempS = sumText.getText().toString();
            xFacActivated = true;
            if(secondNum%2==0||secondNum%2==1 ||secondNum<0 ){
                if(secondNum>170){
                    sumText.setText(String.valueOf("太大了我算不出來"));
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable(){

                        @Override
                        public void run() {
                            //the thing after a second will be happened
                            ac();
                        }}, 1000);
                }
                else{
                    Double tempDouble = secondNum;
                    acButRemainSum();
                    changeToSecond = true;
                    tempS = sumText.getText().toString();   //positivie value
                    sumText.setText(tempS);
                    String []tempArray = tempS.split(" ");


                    secondNum = fac(tempDouble);
                    sumText.setText(tempArray[0]+tempArray[1] + String.valueOf(secondNum));



                }
            }

            else{
                sumText.setText("不是正整數，無法計算");
                Handler handler = new Handler();
                handler.postDelayed(new Runnable(){

                    @Override
                    public void run() {
                        //the thing after a second will be happened
                        ac();
                    }}, 1000);
            }
        }
    }
    public void oneDivX(View view){
        sumText = (TextView)findViewById(R.id.sumText1);
        if(changeToSecond==false && sinActivated==false){

            sum = 1.0 / sum;
            sumText.setText(String.valueOf(sum));
            acButRemainSum();
        }

    }
    public void sinh(View view){
        sumText = (TextView)findViewById(R.id.sumText1);
        if(changeToSecond==false && sinhActivated==false){

            sum = 0;
            sumText.setText(" sinh ");//don't change this format , I use split (" ")in the input()to get the x of logX
            changeToSecond = true;
            sinhActivated = true;
        }

    }
    public void cosh(View view){
        sumText = (TextView)findViewById(R.id.sumText1);
        if(changeToSecond==false && coshActivated==false){

            sum = 0;
            sumText.setText(" cosh ");//don't change this format , I use split (" ")in the input()to get the x of logX
            changeToSecond = true;
            coshActivated = true;
        }

    }
    public void tanh(View view){
        sumText = (TextView)findViewById(R.id.sumText1);
        if(changeToSecond==false && tanhActivated==false){

            sum = 0;
            sumText.setText(" tanh ");//don't change this format , I use split (" ")in the input()to get the x of logX
            changeToSecond = true;
            tanhActivated = true;
        }

    }
    public void rand(View view){
        sumText = (TextView)findViewById(R.id.sumText1);
        if(sum==0 && changeToSecond==false){
            sum = Math.random();

            //the format I want ,such as 1.2345
            DecimalFormat mDecimalFormat = new DecimalFormat("#.####");
            //turn the double number into string and change the format
            String text = mDecimalFormat.format(sum);
            //the format is done, turn the string turn into double value
            sum =  Double.parseDouble(text);

            sumText.setText(String.valueOf(sum));
            hasAPoint1 = true;
        }
        else if(secondNum==0 && changeToSecond==true){
            secondNum = Math.random();
            DecimalFormat mDecimalFormat = new DecimalFormat("#.####");
            String text = mDecimalFormat.format(secondNum);
            secondNum =  Double.parseDouble(text);
            sumText.setText(sumText.getText().toString()+ String.valueOf(secondNum));
            hasAPoint2 = true;
        }
    }
    public void ee(View view){
        sumText = (TextView)findViewById(R.id.sumText1);
        if(changeToSecond == false && eeActivated==false){
            changeToSecond = true;
            eeActivated = true;
            symbol = " *10^ ";
            sumText.setText(sumText.getText().toString()+ symbol);

        }
        else if(symbol!=" *10^ " && eeActivated==false){

            symbol = " *10^ ";
            String [] tempArray = null;
            tempArray = sumText.getText().toString().split(" ");
            eeActivated = true;
            if (tempArray.length ==3){
                sumText.setText(tempArray[0] + "*10^" +tempArray[2]);
            }
            else if(tempArray.length < 3){
                sumText.setText(tempArray[0] + symbol);
            }
        }

    }
}