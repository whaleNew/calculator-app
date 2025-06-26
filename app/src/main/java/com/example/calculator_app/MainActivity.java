package com.example.calculator_app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txt_tinh, txt_result;
    MaterialButton button_c, button_ac, button_mo_ngoac, button_dong_ngoac, button_chia,
            button_7, button_8, button_9, button_nhan,
            button_4, button_5, button_6, button_cong,
            button_1, button_2, button_3, button_tru,
            button_0, button_dot, button_bang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // ánh xạ
        txt_tinh = findViewById(R.id.txt_tinh);
        txt_result = findViewById(R.id.txt_result);

        // Ánh xạ các Button
        assignId(button_c, R.id.button_c);
        assignId(button_ac, R.id.button_ac);
        assignId(button_mo_ngoac, R.id.button_mo_ngoac);
        assignId(button_dong_ngoac, R.id.button_dong_ngoac);
        assignId(button_chia, R.id.button_chia);

        assignId(button_7, R.id.button_7);
        assignId(button_8, R.id.button_8);
        assignId(button_9, R.id.button_9);
        assignId(button_nhan, R.id.button_nhan);

        assignId(button_4, R.id.button_4);
        assignId(button_5, R.id.button_5);
        assignId(button_6, R.id.button_6);
        assignId(button_cong, R.id.button_cong);

        assignId(button_1, R.id.button_1);
        assignId(button_2, R.id.button_2);
        assignId(button_3, R.id.button_3);
        assignId(button_tru, R.id.button_tru);

        assignId(button_0, R.id.button_0);
        assignId(button_dot, R.id.button_dot);
        assignId(button_bang, R.id.button_bang);





    }

    void assignId(MaterialButton btn, int id)
    {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();
        String dataCal = txt_tinh.getText().toString();

        if(buttonText.equals("AC"))
        {
            txt_tinh.setText("");
            txt_result.setText("0");
            return;
        }
        if(buttonText.equals("="))
        {
            txt_tinh.setText(txt_result.getText());
            return;
        }
        if(buttonText.equals("C"))
        {
            dataCal = dataCal.substring(0, dataCal.length()-1);

        } else {
            dataCal = dataCal+buttonText;
        }

        txt_tinh.setText(dataCal);

        String finalResult = getResult(dataCal);
        if(!finalResult.equals("Error"))
        {
            txt_result.setText(finalResult);
        }
    }
    String getResult(String data)
    {
       try {
           Context context = Context.enter();
           context.setOptimizationLevel(-1);
           Scriptable scriptable = context.initStandardObjects();
           String finalResult = context.evaluateString(scriptable,data,"Javascript",1,null).toString();
           if(finalResult.endsWith(".0"))
           {
               finalResult = finalResult.replace(".0", "");
           }
           return finalResult;
       } catch (Exception e) {
           return "Error";
       }
    }
}