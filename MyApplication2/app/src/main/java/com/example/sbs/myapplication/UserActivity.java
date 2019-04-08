package com.example.sbs.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.Map;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        String loginedUserEmail = getIntent().getStringExtra("loginedUserEmail");

        Map<String, Object> user = MainActivity.findUser(loginedUserEmail);

        String 이름 = (String) user.get("이름");
        String 성별 = (String) user.get("성별");
        String 직업 = (String) user.get("직업");
        int 나이 = (int) user.get("나이");

        String msg = "이름 : " + 이름 + ", 나이 : " + 나이 + ", 직업 : " + 직업 + ", 성별 : " + 성별;

        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}