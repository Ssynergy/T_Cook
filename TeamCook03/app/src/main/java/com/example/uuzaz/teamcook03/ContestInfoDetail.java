package com.example.uuzaz.teamcook03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ContestInfoDetail extends AppCompatActivity {

    ImageButton btn_back;
    ImageView iv_one;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contest_info_detail);
        iv_one=(ImageView)findViewById(R.id.info_picture);
        //나머지 TextView 바인딩
        Log.e("onLIstBtnClick",toString().valueOf(Main_Fragment_INFO.listPosition));
        switch (Main_Fragment_INFO.listPosition){
            case 0:
                iv_one.setImageDrawable(getDrawable(R.drawable.info_pic));
                //셋팅
                break;
            case 1:
                iv_one.setImageDrawable(getDrawable(R.drawable.info_pic01));
                break;
            case 2:
                iv_one.setImageDrawable(getDrawable(R.drawable.info_pic02));
                break;
            case 3:
                iv_one.setImageDrawable(getDrawable(R.drawable.info_pic03));
                break;
            case 4:
                iv_one.setImageDrawable(getDrawable(R.drawable.info_pic04));
                break;
            default:
                break;
        }

        btn_back = (ImageButton) findViewById(R.id.id_back02);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContestInfoDetail.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}