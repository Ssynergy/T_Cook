package com.example.uuzaz.teamcook02_specail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ContestInfoDetail extends AppCompatActivity {

    ImageButton btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contest_info_detail);


        btn_back = (ImageButton) findViewById(R.id.id_back02);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContestInfoDetail.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ImageView info_pictureDrawable = (ImageView)findViewById(R.id.info_picture);
        ImageView love_upDrawable = (ImageView)findViewById(R.id.love_up);
        TextView info_name_outputStr = (TextView)findViewById(R.id.info_name_output);
        TextView info_dateStr = (TextView)findViewById(R.id.info_date);
        TextView d_dayStr = (TextView)findViewById(R.id.d_day);

        Intent intent = getIntent(); //보내온 Intent를 얻는다
        info_pictureDrawable.setImageResource(intent.getIntExtra("info_picture",0));
        love_upDrawable.setImageResource(intent.getIntExtra("love_up",0));
        info_name_outputStr.setText(intent.getStringExtra("info_name"));
        info_dateStr.setText(intent.getStringExtra("info_date"));
        d_dayStr.setText(intent.getStringExtra("d_day"));
    }
}