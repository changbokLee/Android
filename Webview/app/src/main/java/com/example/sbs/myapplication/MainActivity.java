package com.example.sbs.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUrl;
    private WebView webView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUrl = findViewById(R.id.editTextUrl);

        webView1 = findViewById(R.id.webView1);

        // 웹 세팅 객체 가져와서
        WebSettings webSettings = webView1.getSettings();
        // 수정한다.(자바스크립트 엔진 활성화)
        webSettings.setJavaScriptEnabled(true);


        // 이걸 안하면 휴대폰의 기본 웹 브라우저 앱이 삽입된다.
        // 이걸 하면 기본 웹뷰가 삽입된다.
        webView1.setWebViewClient(new WebViewClient());

        // 액션 버튼 클릭에 대한 구독자를 등록한다.
        editTextUrl.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            // 에디터 액션 클릭하면 아래 메서드 실행된다.
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    // 검색
                    String url = editTextUrl.getText().toString().trim();

                    if (url.startsWith("http://") == false) {
                        url = "http://" + url;

                        editTextUrl.setText(url);
                    }

                    goToUrl(url);

                    // 키보드 내리기
                    InputMethodManager imm = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                    return true;
                }

                return false;
            }
        });
    }

    // 뒤로가기 버튼 눌리면
    @Override
    public void onBackPressed() {
        if (webView1.canGoBack()) {
            webView1.goBack();
        } else {
            super.onBackPressed();
        }
    }

    private void goToUrl(String url) {
        if (url.startsWith("http://") == false) {
            url = "http://" + url;
        }

        webView1.loadUrl(url);
    }

    public void refreshButtonClicked(View view) {
        // 웹뷰 리프레시
        webView1.reload();
    }
}


