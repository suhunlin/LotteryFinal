package com.suhun.lotteryfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity {
    String tag = MainActivity.class.getSimpleName();
    int textViewLen = 6;
    TextView[] numTextView = new TextView[textViewLen];
    Button createNumButton;
    int[] viewId = {R.id.num0, R.id.num1, R.id.num2, R.id.num3, R.id.num4, R.id.num5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        createNumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLotteryNumberToViewText();
            }
        });
    }
    private void initView(){
        for(int i=0;i<numTextView.length;i++){
            numTextView[i] = findViewById(viewId[i]);
            numTextView[i].setText("-");
        }
        createNumButton = findViewById(R.id.createNum);
    }

    private void setLotteryNumberToViewText(){
        int[] lotteryNumber = createLottery();
        for(int i=0;i<lotteryNumber.length;i++){
            Log.d(tag, "The number is "+lotteryNumber[i]);
            numTextView[i].setText(""+lotteryNumber[i]);
        }
    }

    private int[] createLottery(){
        TreeSet<Integer> numSet = new TreeSet<>();

        while (numSet.size()<textViewLen){
            numSet.add(new Random().nextInt(49) + 1);
        }
        int i=0;int[] numTemp = new int[numSet.size()];
        for(Integer num:numSet){
            numTemp[i++] = num;
        }
        return numTemp;
    }
}