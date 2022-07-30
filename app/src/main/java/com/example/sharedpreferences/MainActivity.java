package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText xusername,xphone;
    Button xsave,xback;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xusername=(EditText)findViewById(R.id.username);
        xphone=(EditText)findViewById(R.id.phone);
        xsave=(Button) findViewById(R.id.save);
        xback=(Button)findViewById(R.id.back);

        xsave.setOnClickListener(new SavClick());
        xback.setOnClickListener(new bakClick());

        sp=getSharedPreferences("data",MODE_PRIVATE);
        editor=sp.edit();
    }

    private class SavClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            editor.putString("name",xusername.getText().toString().trim());//将用户输入的姓名保存到编辑器中，getText()提取输入框的内容，toString()将其转换为字符串类型，trim()过滤掉输入内容中的空格
            editor.putString("phone",xphone.getText().toString().trim());
            editor.commit();
        }
    }

    private class bakClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            xusername.setText(sp.getString("name",""));
            xphone.setText(sp.getString("phone",""));
        }
    }
}