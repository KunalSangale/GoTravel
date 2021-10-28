package com.example.gotravel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class HotelListActivity extends AppCompatActivity {
    ListView list;
    ImageView img;
    TextView headerText;
    String hotels[]={
            "The Taj",
            "Oberoi",
            "Trident",
            "Grand Hyatt",
            "Four Seasons",
            "The Leela",
            "ITC Maratha"
    };
    Integer[] imageId={
            R.drawable.hotel
    };
    String id="hotel";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_hotel_list);
        setContentView(R.layout.list);
        img=findViewById(R.id.header_img);
        headerText=findViewById(R.id.header_text);
        img.setImageResource(R.drawable.hotel);
        headerText.setText("Hotels");
//        HotelListAdapter adapter=new HotelListAdapter(HotelListActivity.this,hotels,imageId);
        ListAdapter adapter=new ListAdapter(HotelListActivity.this,id,hotels,imageId);
        list=findViewById(R.id.typeOfPlace_listview);
        list.setAdapter(adapter);
    }
}