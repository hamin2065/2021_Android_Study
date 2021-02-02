package com.example.project1_calculator_image;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MemoActivity extends AppCompatActivity {

    EditText editTitle;
    EditText editContent;
    TextView buttonMemo;

    SharedPreferences sf; // 앱 내 데이터를 저장할 객체
    SharedPreferences.Editor editor; // 앱 내 데이터를 수정할 객체

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        sf = getSharedPreferences("sFile", MODE_PRIVATE);//앱 내 데이터를 저장할 객체를 초기화 ->"sFile"이라는 저장소, PRIVATE이라는 모드
        editor = sf.edit(); //앱 내 데이터를 수정할 객첸데 어떤 데이터를 수정할거냐 ->sf에 대한 데이터를 수정할 객체다 라고 초기화

        editTitle = findViewById(R.id.edit_title);
        editContent = findViewById(R.id.edit_content);
        buttonMemo = findViewById(R.id.button_memo);

        String title = sf.getString("memoTitle","");
        String content = sf.getString("memoContent","");

        editTitle.setText(title);
        editContent.setText(content);

        buttonMemo.setOnClickListener(view -> {

            //memo(editTitle.getText().toString(), editContent.getText().toString());

            //String title = editTitle.getText().toString();
            //String content = editContent.getText().toString();
            //memo(title, content);

            String titleTrim = editTitle.getText().toString(); //SharedPreference 객체에서 직접적으로 key값에 해당하는 값을 불러옴
            String contentTrim = editContent.getText().toString(); //SharedPreference 객체에서 직접적으로 key값에 해당하는 값을 불러옴

            if (!titleTrim.trim().equals("") && !contentTrim.equals(""))
                memo(titleTrim, contentTrim);
            else
                Toast.makeText(getApplicationContext(), "Please Enter All the Value", Toast.LENGTH_LONG).show();


        });
    }



    private void memo(String title, String content) {
        String toastText = "제목 : " + title +"/n본문 : " + content;

        editor.putString("memoTitle",title).commit(); //SharedPreference Editor 객체를 통해 key값에 해당하는 값을 넣어줌
        editor.putString("memoContent",content).commit(); //SharedPreference Editor 객체를 통해 key값에 해당하는 값을 넣어줌

        Toast.makeText(getApplicationContext(),
                toastText,
                Toast.LENGTH_LONG).show();
        }
    }
