package com.example.uuzaz.teamcook02_specail;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Info_ListViewAdapter extends ArrayAdapter implements View.OnClickListener{
    //private ArrayList<Info_ListItem> listViewItemList = new ArrayList<Info_ListItem>() ;

    // 버튼 클릭 이벤트를 위한 Listener 인터페이스 정의
    public interface ListBtnClickListener {
        void onListBtnClick(int position) ;
    }

    // 생성자로부터 전달된 resource id 값을 저장.
    int resourceId ;
    // 생성자로부터 전달된 ListBtnClickListener  저장.
    private ListBtnClickListener listBtnClickListener ;


    // Info_ListViewAdapter 생성자. 마지막에 ListBtnClickListener 추가.
    Info_ListViewAdapter(Context context, int resource, ArrayList<Info_ListItem> list, ListBtnClickListener clickListener) {
        super(context, resource, list) ;

        // resource id 값 복사. (super로 전달된 resource를 참조할 방법이 없음.)
        this.resourceId = resource ;

        this.listBtnClickListener = clickListener ;
    }

    /*// ListViewAdapter의 생성자
    public Info_ListViewAdapter() {
    }*/

    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    /*@Override
    public int getCount() {
        return listViewItemList.size() ;
    }*/

    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현 ->
    // -> 새롭게 만든 Layout을 위한 View를 생성하는 코드
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.->
        // -> 생성자로부터 저장된 resourceId(listview_btn_item)에 해당하는 Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(this.resourceId/*R.layout.listitem_info*/, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        final ImageButton i_btnImageButton = (ImageButton) convertView.findViewById(R.id.info_picture) ;
        final ImageView iconImageView = (ImageView) convertView.findViewById(R.id.love_up) ;
        final TextView the_dayTextView = (TextView) convertView.findViewById(R.id.info_date) ;
        final TextView d_dayTextView = (TextView) convertView.findViewById(R.id.d_day) ;
        final TextView titleTextView = (TextView) convertView.findViewById(R.id.info_name_output) ;

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        /*Info_ListItem info_listItem = listViewItemList.get(position);*/

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        final Info_ListItem info_listItem = (Info_ListItem) getItem(position);

        // 아이템 내 각 위젯에 데이터 반영
        i_btnImageButton.setImageResource(info_listItem.getI_btn());
        iconImageView.setImageResource(info_listItem.getIcon());
        the_dayTextView.setText(info_listItem.getThe_day());
        d_dayTextView.setText(info_listItem.getD_day());
        titleTextView.setText(info_listItem.getTitle());



       /* Button info = (Button) view.findViewById(R.id.btn_contest_info);
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
        });*/



      /*  // button1 클릭 시 TextView(textView1)의 내용 변경.
        Button button0 = (Button) convertView.findViewById(R.id.info_picture_s);
        button0.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                //titleTextView.setText(Integer.toString(pos + 1) + "번 아이템 선택.");
            }
        });
*/

        // button1 클릭 시 TextView(textView1)의 내용 변경.
        Button button1 = (Button) convertView.findViewById(R.id.team_search_btn);
        button1.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

                //titleTextView.setText(Integer.toString(pos + 1) + "번 아이템 선택.");
            }
        });

        // button2의 TAG에 position값 지정. Adapter를 click listener로 지정.
        Button button2 = (Button) convertView.findViewById(R.id.team_create_btn);
        button2.setTag(position);
        button2.setOnClickListener(this);


        return convertView;
    }

    /*// 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
        return position ;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position) ;
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem( Drawable i_btn, String the_day, String d_day, String title ) {
        Info_ListItem item = new Info_ListItem();

        item.setI_btn(i_btn);
        //item.setIcon(icon);
        item.setThe_day(the_day);
        item.setD_day(d_day);
        item.setTitle(title);

        listViewItemList.add(item);
    }*/

    // button2가 눌려졌을 때 실행되는 onClick함수.
    public void onClick(View v) {
        // ListBtnClickListener(MainActivity)의 onListBtnClick() 함수 호출.
        if (this.listBtnClickListener != null) {
            this.listBtnClickListener.onListBtnClick((int)v.getTag()) ;
        }
    }

}
