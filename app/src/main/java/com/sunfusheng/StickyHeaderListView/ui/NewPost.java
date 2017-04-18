package com.sunfusheng.StickyHeaderListView.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.sunfusheng.StickyHeaderListView.R;
import com.sunfusheng.StickyHeaderListView.util.ModelUtil;

/**
 * Created by harsh on 12/4/17.
 */

public class NewPost extends AppCompatActivity{

    String[] SPINNER_DATA;
    Context context;
    Spinner selecttag;
    ImageView done;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpost);


        selecttag = (Spinner) findViewById(R.id.select_tag);
        done = (ImageView) findViewById(R.id.done);

        SPINNER_DATA = ModelUtil.getSpinnerdata();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(NewPost.this,
                android.R.layout.simple_dropdown_item_1line, SPINNER_DATA);
        selecttag.setAdapter(adapter);

        selecttag.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NewPost.this, "post save successfully", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
