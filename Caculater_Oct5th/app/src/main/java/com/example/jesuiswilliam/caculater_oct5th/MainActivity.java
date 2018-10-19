package com.example.jesuiswilliam.caculater_oct5th;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import android.widget.TextView;

//為了酷炫，以下註解打英文（可能有法文旦起碼沒有中文ＸＤＤＤ）
//Je suis William , finished at Oct/7 2018

//The view controller for the portrait view
public class MainActivity extends AppCompatActivity {
    double sum = 0;
    double secondNum = 0;
    String symbol = "";
    String passValue = "";
    boolean hasAPoint1 = false;
    boolean hasAPoint2 = false;
    boolean changeToSecond = false;
    boolean infinity = false;
    public TextView sumText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sumText = (TextView)findViewById(R.id.sumText1);


        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.i("info", "landscape"); // horizontal screen
            setContentView(R.layout.changed_view);


            Intent intent1=new Intent(MainActivity.this,SecondActivity.class); //建立一個intent
            sumText = (TextView)findViewById(R.id.sumText1);
            passValue = sumText.getText().toString();
            intent1.putExtra("passValue",passValue);
            intent1.putExtra("sum",sum);
            intent1.putExtra("secondNum",secondNum);
            intent1.putExtra("symbol",symbol);
            intent1.putExtra("hasAPoint1",hasAPoint1);
            intent1.putExtra("hasAPoint2",hasAPoint2);
            intent1.putExtra("changeToSecond",changeToSecond);
            intent1.putExtra("infinity",infinity);
            startActivity(intent1);
            finish();
        }
        else if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            Log.i("info", "portrait"); // vertical screen
            setContentView(R.layout.activity_main);
        }

    }
    //the method to clear all
    public  void ac(){
        sumText = (TextView)findViewById(R.id.sumText1);
        sumText.setText("0");
        sum = 0;
        changeToSecond = false;
        secondNum = 0;
        hasAPoint1 = false;
        hasAPoint2 = false;
        infinity = false;
    }
    //button ac controller
    public void func_ac(View view){
        ac();
    }
    //button ± controller
    public void func_NeativePositive(View view){
        sumText = (TextView)findViewById(R.id.sumText1);
        if(changeToSecond == false){
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
        else{
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
            if (secondNum == 0.0 && hasAPoint2 ==false){                    //if the value is equal to 0, input new number to replace it
                switch (view.getId()) {         //I found out this method on the web , it can distinguish which button I press
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
                        //sumText.setText("測試一下" + temp[2]);
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
        if(changeToSecond == false){

            changeToSecond = true;
            symbol = " + ";
            sumText.setText(sumText.getText().toString()+ symbol);
        }
        if(symbol!=" + "){

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
        }

    }
    //button - controller
    public void sub(View view){
        sumText = (TextView)findViewById(R.id.sumText1);
        if(changeToSecond == false){

            changeToSecond = true;
            symbol = " - ";
            sumText.setText(sumText.getText().toString()+ symbol);
        }
        if(symbol!=" - "){

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
        }
    }
    //button × controller
    public void mul(View view){
        sumText = (TextView)findViewById(R.id.sumText1);
        if(changeToSecond == false){
            changeToSecond = true;
            symbol = " × ";
            sumText.setText(sumText.getText().toString()+ symbol);
        }
        if(symbol!=" × "){

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
        }

    }
    //button ÷ controller
    public void div(View view){
        sumText = (TextView)findViewById(R.id.sumText1);
        if(changeToSecond == false){

            changeToSecond = true;
            symbol = " ÷ ";
            sumText.setText(sumText.getText().toString()+ symbol);
        }
        if(symbol!=" ÷ "){

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

        }

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
    //button = controller
    public void equal(View view){


        sumText = (TextView)findViewById(R.id.sumText1);
        if(symbol==" ÷ "&& secondNum==0 && infinity == false){
            sumText.setText("無限大");
            infinity = true;

            Handler handler = new Handler();
            handler.postDelayed(new Runnable(){

                @Override
                public void run() {
                    //the thing after a second will be happened
                    ac();
                }}, 1000);
        }
        else if(infinity == false && secondNum!=0){
            sum = deal(sum,secondNum,symbol);
            sumText.setText(String.valueOf(sum));

            secondNum = 0;
            hasAPoint1 = false;
            hasAPoint2 = false;
            changeToSecond = false;
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

    public void floatingAction(View view){
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);

        dialog.setTitle("離開");
        dialog.setNegativeButton("否", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {

            }

        });
        dialog.setNegativeButton("是", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                finish();
            }

        });
        dialog.show();
    }

}
