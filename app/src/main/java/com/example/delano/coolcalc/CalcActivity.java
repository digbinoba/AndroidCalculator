package com.example.delano.coolcalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CalcActivity extends Activity {

    TextView resultView;

    public enum Operation {
        ADD,SUBTRACT,DIVIDE,MULTIPLY,EQUAL
    }
    String runningNumber = "";
    String leftValueString = "";
    String rightValueString = "";
    Operation currentOperation;
    int result = 0;

    void numberPressed(int number){
        runningNumber += String.valueOf(number);
        resultView.setText(runningNumber);
    }

    void processOperation(Operation operation){
        if(currentOperation != null){
            if(runningNumber != ""){
                rightValueString = runningNumber;
                runningNumber = "";

                switch (currentOperation){
                    case ADD:
                        result = Integer.parseInt(leftValueString) + Integer.parseInt(rightValueString);
                        break;
                    case SUBTRACT:
                        result = Integer.parseInt(leftValueString) - Integer.parseInt(rightValueString);
                        break;
                    case MULTIPLY:
                        result = Integer.parseInt(leftValueString) * Integer.parseInt(rightValueString);
                        break;
                    case DIVIDE:
                        result = Integer.parseInt(leftValueString) / Integer.parseInt(rightValueString);
                        break;
                }
                leftValueString = String.valueOf(result);
                resultView.setText(leftValueString);
            }
        }
        else{
            leftValueString = runningNumber;
            runningNumber = "";
        }
        currentOperation = operation;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        Button oneBtn = (Button) findViewById(R.id.oneBtn);
        Button twoBtn = (Button) findViewById(R.id.twoBtn);
        Button threeBtn = (Button) findViewById(R.id.threeBtn);
        Button fourBtn = (Button) findViewById(R.id.fourBtn);
        Button fiveBtn = (Button) findViewById(R.id.fiveBtn);
        Button sixBtn = (Button) findViewById(R.id.sixBtn);
        Button sevenBtn = (Button) findViewById(R.id.sevenBtn);
        Button eightBtn = (Button) findViewById(R.id.eightBtn);
        Button nineBtn = (Button) findViewById(R.id.nineBtn);
        Button zeroBtn = (Button) findViewById(R.id.zeroBtn);

        ImageButton calcBtn = (ImageButton) findViewById(R.id.calcBtn);
        ImageButton addBtn = (ImageButton) findViewById(R.id.addBtn);
        ImageButton subtractBtn = (ImageButton) findViewById(R.id.substractBtn);
        ImageButton multiplyBtn = (ImageButton) findViewById(R.id.multiplyBtn);
        ImageButton divideBtn = (ImageButton) findViewById(R.id.divideBtn);

        Button clearButton = (Button) findViewById(R.id.clearBtn);
        resultView = (TextView) findViewById(R.id.resultsText);
        //When app loads, the text is set to empty
        resultView.setText("");

        oneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                numberPressed(1);
            }
        });

        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                numberPressed(2);

            }
        });

        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                numberPressed(3);

            }
        });
        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                numberPressed(4);

            }
        });

        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                numberPressed(5);

            }
        });

        sixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                numberPressed(6);

            }
        });
        sevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                numberPressed(7);

            }
        });
        eightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                numberPressed(8);

            }
        });
        nineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                numberPressed(9);

            }
        });
        zeroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                numberPressed(0);

            }
        });

        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                processOperation(Operation.EQUAL);
            }
        });
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                processOperation(Operation.ADD);
            }
        });
        subtractBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                processOperation(Operation.SUBTRACT);

            }
        });
        multiplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                processOperation(Operation.MULTIPLY);

            }
        });
        divideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                processOperation(Operation.DIVIDE);

            }
        });
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                leftValueString = "";
                rightValueString = "";
                result = 0;
                currentOperation = null;
                runningNumber = "";
                resultView.setText("0");
            }
        });


    }
}
