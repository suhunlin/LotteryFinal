package com.suhun.lotteryfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

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
    }
    private void initView(){
        for(int i=0;i<numTextView.length;i++){
            numTextView[i] = findViewById(viewId[i]);
            numTextView[i].setText("-");
        }
        createNumButton = findViewById(R.id.createNum);
    }
}