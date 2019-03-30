package com.example.sbs.myapplication;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToUrlButtonClicked(View view) {
        String url = ((EditText) findViewById(R.id.editTextUrl)).getText().toString().trim();

        goToUrl(url);
    }

    private void goToUrl(String url) {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void searchButtonClicked(View view) {
        String searchKeyword = ((EditText) findViewById(R.id.editTextSearchKeyword)).getText().toString().trim();

        searchOnWeb(searchKeyword);
    }

    private void searchOnWeb(String searchKeyword) {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, searchKeyword);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void dialPhoneButtonClicked(View view) {
        String phoneNumber = ((EditText) findViewById(R.id.editTextPhoneNumber)).getText().toString().trim();

        dialPhone(phoneNumber);
    }

    private void dialPhone(String phoneNumber) {
        // 암시적 인텐트인 ACTION_DIAL을 설정
        Intent intent = new Intent(Intent.ACTION_DIAL);
        // URI 형태의 전화번호를 데이터로 설정
        intent.setData(Uri.parse("tel:" + phoneNumber));
        // 이러한 Intent를 처리할 수 있는 Activity를 찾는다면 액티비티를 시작
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}