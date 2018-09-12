package com.example.uuzaz.teamcook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class M_f_Info_Detail extends AppCompatActivity {

    ImageButton btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.f_m_f__info__detail);


        btn_back = (ImageButton) findViewById(R.id.id_back02);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(M_f_Info_Detail.this, Main_Fragment_INFO.class);
                startActivity(intent);
            }
        });
    }
}
