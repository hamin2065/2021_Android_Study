package com.example.project1_calculator_image;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MemoActivity extends AppCompatActivity {

    EditText editTitle;
    EditText editContent;
    TextView buttonMemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        editTitle = findViewById(R.id.edit_title);
        editContent = findViewById(R.id.edit_content);
        buttonMemo = findViewById(R.id.button_memo);

        buttonMemo.setOnClickListener(view -> {

            //memo(editTitle.getText().toString(), editContent.getText().toString());

            //String title = editTitle.getText().toString();
            //String content = editContent.getText().toString();
            //memo(title, content);

            String titleTrim = editTitle.getText().toString();
            String contentTrim = editContent.getText().toString();

            if (!titleTrim.trim().equals("") && !contentTrim.equals(""))
                memo(titleTrim, contentTrim);
            else
                Toast.makeText(getApplicationContext(), "Please Enter All the Value", Toast.LENGTH_LONG).show();


        });
    }



    private void memo(String title, String content) {
        String toastText = "제목 : " + title +"/n본문 : " + content;
        Toast.makeText(getApplicationContext(),
                toastText,
                Toast.LENGTH_LONG).show();
        }
    }
