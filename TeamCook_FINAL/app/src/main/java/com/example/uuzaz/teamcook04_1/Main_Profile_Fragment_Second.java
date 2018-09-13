package com.example.uuzaz.teamcook04_1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


public class Main_Profile_Fragment_Second extends Fragment {

    public Main_Profile_Fragment_Second() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main__profile__fragment__second, container, false);
        //ListView02
        TeamList_ListViewAdapter adapter;
        ListView listView;

        //ListView02
        // Adapter 생성
        adapter = new TeamList_ListViewAdapter() ;

        // 리스트뷰 참조 및 Adapter달기
        listView = (ListView) view.findViewById(R.id.list_teamlist) ;
        listView.setAdapter(adapter) ;

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),Main_Profile_Fragments_Second_TeamList_Detail.class);
                startActivity(intent);
            }
        });

        // 첫 번째 아이템 추가.
        adapter.addItem("9/15",
                "해커톤 공모전 같이 준비해요~~!!", "D - 12", "8","최하윤") ;
        // 두 번째 아이템 추가.
        adapter.addItem("9/24",
                "부산아이디어 경진대회 여기 모여라", "D - 09", "7","김재인") ;
        // 세 번째 아이템 추가.
        adapter.addItem("9/29",
                "Start up, Step up 급구합니다~~", "D - 18", "7","김태형") ;
        // 네 번째 아이템 추가.
        adapter.addItem("10/04",
                "공모전 여기 붙어라,뿜 모두 모여라~", "D - 35", "4","김기현") ;
        // 다섯 번째 아이템 추가.
        adapter.addItem("10/17",
                "부산 대중교통 공모전 아이디어 급구", "D - 51", "6","이교원") ;
        // 여섯 번째 아이템 추가.
        adapter.addItem("9/15",
                "해커톤 공모전 같이 준비해요~~!!", "D - 12", "8","김동근") ;
        // 일곱 번째 아이템 추가.
        adapter.addItem("9/24",
                "부산아이디어 경진대회 여기 모여라", "D - 09", "7","임호연") ;
        // 여덟 번째 아이템 추가.
        adapter.addItem("9/29",
                "Start up, Step up 급구합니다~~", "D - 18", "7","김용희") ;
        // 아홉 번째 아이템 추가.
        adapter.addItem("10/04",
                "공모전 여기 붙어라,뿜 모두 모여라~", "D - 35", "4","장유리") ;
        // 열 번째 아이템 추가.
        adapter.addItem("10/17",
                "부산 대중교통 공모전 아이디어 급구", "D - 51", "6","권석") ;

        return view;
    }

}
