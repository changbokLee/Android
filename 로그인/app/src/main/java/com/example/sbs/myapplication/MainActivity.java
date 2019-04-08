package com.example.sbs.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static List<Map> users;
    private EditText editTextLoginEmail;
    private EditText editTextLoginPassword;
    private Button buttonLogin;

    static {
        users = new ArrayList<>();

        Map<String, Object> user;
        user = new LinkedHashMap<>();

        user.put("아이디", "jangka512@gmail.com");
        user.put("비밀번호", "test1234");
        user.put("이름", "홍길동1");
        user.put("나이", 22);
        user.put("성별", "남자");
        user.put("직업", "의적");
        users.add(user);

        user = new LinkedHashMap<>();

        user.put("아이디", "jangka513@gmail.com");
        user.put("비밀번호", "test1234");
        user.put("이름", "홍길동2");
        user.put("나이", 22);
        user.put("성별", "남자");
        user.put("직업", "의적");
        users.add(user);

        user = new LinkedHashMap<>();

        user.put("아이디", "jangka514@gmail.com");
        user.put("비밀번호", "test1234");
        user.put("이름", "홍길동3");
        user.put("나이", 22);
        user.put("성별", "남자");
        user.put("직업", "의적");
        users.add(user);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextLoginEmail = findViewById(R.id.editTextLoginEmail);
        editTextLoginPassword = findViewById(R.id.editTextLoginPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginEmail = editTextLoginEmail.getText().toString().trim();
                String loginPassword = editTextLoginPassword.getText().toString().trim();

                login(loginEmail, loginPassword);
            }
        });
    }

    private void login(String loginEmail, String loginPassword) {
        Map<String, Object> user = findUser(loginEmail, loginPassword);

        if (user == null) {
            Toast.makeText(this, "일치하는 회원이 없습니다.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "로그인 되었습니다.", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this, UserActivity.class);
            intent.putExtra("loginedUserEmail", loginEmail);
            startActivity(intent);
        }
    }

    private static Map<String, Object> findUser(String loginEmail, String loginPassword) {
        for (Map<String, Object> user : users) {
            if (user.get("아이디").equals(loginEmail) && user.get("비밀번호").equals(loginPassword)) {
                return user;
            }
        }

        return null;
    }

    public static Map<String, Object> findUser(String loginEmail) {
        for (Map<String, Object> user : users) {
            if (user.get("아이디").equals(loginEmail)) {
                return user;
            }
        }

        return null;
    }
}