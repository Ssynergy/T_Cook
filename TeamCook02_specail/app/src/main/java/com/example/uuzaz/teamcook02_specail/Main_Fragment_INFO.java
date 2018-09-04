package com.example.uuzaz.teamcook02_specail;


import android.content.ClipData;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main_Fragment_INFO extends Fragment implements Info_ListViewAdapter.ListBtnClickListener {

    /*//ListView01
    static final String[] LIST_MENU = {"LIST1", "LIST2", "LIST3"};*/

    //ListVIew00
    //private ArrayList<Info_ListItem> data = null;

    public boolean loadItemsFromDB(ArrayList<Info_ListItem> list) {
        Info_ListItem item ;
        int i ;

        if (list == null) {
            list = new ArrayList<Info_ListItem>() ;
        }

        // 순서를 위한 i 값을 1로 초기화.
        i = 1 ;

        // 아이템 생성.loadItemsFromDB
        item = new Info_ListItem() ;
        item.setI_btn(R.drawable.info_pic);
        item.setIcon( R.drawable.icon_love);
        //item.setThe_day(Integer.toString(i) + "번 아이템입니다.");
        item.setThe_day("2018-09-15");
        item.setD_day("D - 9");
        item.setTitle("인천시 SNS 통합 명칭 공모전");
        list.add(item) ;
        i++ ;

        item = new Info_ListItem() ;
        item.setI_btn(R.drawable.info_pic01);
        item.setIcon(R.drawable.icon_love);
        item.setThe_day("2018-09-27");
        item.setD_day("D - 21");
        item.setTitle("초 단편 영화 공모전");
        list.add(item) ;
        i++ ;

        item = new Info_ListItem() ;
        item.setI_btn(R.drawable.info_pic02);
        item.setIcon(R.drawable.icon_love);
        item.setThe_day("2018-10-1");
        item.setD_day("D - 25");
        item.setTitle("대구 캐주얼 게임 공모전");
        list.add(item) ;
        i++ ;

        item = new Info_ListItem() ;
        item.setI_btn(R.drawable.info_pic03);
        item.setIcon(R.drawable.icon_love);
        item.setThe_day("2018-10-8");
        item.setD_day("D - 32");
        item.setTitle("상반기 구민 아이디어 공모");
        list.add(item) ;

        item = new Info_ListItem() ;
        item.setI_btn(R.drawable.info_pic04);
        item.setIcon(R.drawable.icon_love);
        item.setThe_day("2018-10-22");
        item.setD_day("D - 46");
        item.setTitle("2018 강원 창의 디자인 공모전");
        list.add(item) ;

        return true ;
    }

    public Main_Fragment_INFO() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_main__fragment__info, container, false);

        View view = inflater.inflate(R.layout.fragment_main__fragment__info, null);

        Button info = (Button) view.findViewById(R.id.btn_contest_info);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ContestInfoDetail.class);
                startActivity(intent);
            }
        });

        Button start = (Button) view.findViewById(R.id.btn_create_team_temp);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CreateTeamActivity.class);
                startActivity(intent);


            }
        });




        /*//ListView01
        ArrayAdapter adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,LIST_MENU);
        ListView listView = (ListView) view.findViewById(R.id.list_info);
        listView.setAdapter(adapter);*/

        //ListView02
        Info_ListViewAdapter adapter;
        ListView listView;

        //Button 예시
        final ArrayList<Info_ListItem> items = new ArrayList<Info_ListItem>() ;

        // items 로드.
        loadItemsFromDB(items) ;

        //ListView02
        // Adapter 생성
        adapter = new Info_ListViewAdapter(getActivity(), R.layout.listitem_info, items, this) ;

        // 리스트뷰 참조 및 Adapter달기
        listView = (ListView) view.findViewById(R.id.list_info) ;
        listView.setAdapter(adapter) ;

        // Button 예시
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                // TODO : item click

                // 상세정보 화면으로 이동하기(인텐트 날리기)
                // 1. 다음화면을 만든다
                // 2. AndroidManifest.xml 에 화면을 등록한다
                // 3. Intent 객체를 생성하여 날린다
                Intent intent = new Intent(
                        getActivity(), // 현재화면의 제어권자
                        ContestInfoDetail.class); // 다음넘어갈 화면



                // intent 객체에 데이터를 실어서 보내기
                // 리스트뷰 클릭시 인텐트 (Intent) 생성하고 position 값을 이용하여 인텐트로 넘길값들을 넘긴다
                intent.putExtra("info_picture",items.get(position).getI_btn());
                intent.putExtra("love_up", items.get(position).getIcon());
                intent.putExtra("info_name", items.get(position).getTitle());
                intent.putExtra("info_date", items.get(position).getThe_day());
                intent.putExtra("d_day", items.get(position).getD_day());

                startActivity(intent);

            }
        }) ;


        /*// 첫 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.info_pic),
                "2018-08-10", "D - 12", "해커톤") ;
        // 두 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.info_pic01),
                "2018-08-19", "D - 09", "부산아이디어 경진대회") ;
        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.info_pic02),
                "2018-09-24", "D - 18", "Start up, Step up 꿈터 경진대회") ;
        // 네 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.info_pic03),
                "2018-10-19", "D - 35", "창업동아리") ;
        // 다섯 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.info_pic04),
                "2018-11-28", "D - 51", "장영실 공모전") ;*/





       /* // 위에서 생성한 listview에 클릭 이벤트 핸들러 정의.
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // get item
                Info_ListItem item = (Info_ListItem) parent.getItemAtPosition(position) ;

                Drawable iconDrawable = item.getIcon() ;
                String the_dayStr = item.getThe_day() ;
                String d_dayStr = item.getD_day() ;
                String titleStr = item.getTitle() ;


            }
        }) ;
*/

        //return super.onCreateView(inflater, container, savedInstanceState);
        return view;



        //ListView00
       /* View view = inflater.inflate(R.layout.fragment_main__fragment__info, null);
        ArrayAdapter Adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1);

        ListView listview = (ListView) view.findViewById(R.id.list_info);

        data = new ArrayList<>();

        Info_ListViewAdapter adapter = new Info_ListViewAdapter(this, R.layout.listitem_info, data);
        listview.setAdapter(adapter);


        return view;*/
    }

    @Override
    public void onListBtnClick(int position) {
        Intent intent = new Intent(getActivity(), ContestInfoDetail.class);
        startActivity(intent);

        //Toast.makeText(getActivity(), Integer.toString(position+1) + " Item is selected..", Toast.LENGTH_SHORT).show() ;
    }

    //ListView02


  /*  public void addItem(Drawable icon, String the_day, String d_day, String title) {
        adapter.addItem(icon, the_day,d_day, title);
    }*/







}
