package com.example.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sbs.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<String> listData = new ArrayList<String>();
        final ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        final ListView listView = findViewById(R.id.listView1);
        listView.setAdapter(listAdapter);

        findViewById(R.id.btnAddListItem).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listData.add(listData.size() + 1 + "번 데이터");
                listAdapter.notifyDataSetChanged();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                final int indexToDelete = position;

                DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case DialogInterface.BUTTON_POSITIVE:
                                listData.remove(indexToDelete);
                                listAdapter.notifyDataSetChanged();
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                //No button clicked
                                break;
                        }
                    }
                };

                new AlertDialog.Builder(MainActivity.this)
                        .setMessage("삭제하시겠습니까?")
                        .setPositiveButton("예", onClickListener)
                        .setNegativeButton("아니오", onClickListener)
                        .show();

                return false;
            }
        });
    }
}