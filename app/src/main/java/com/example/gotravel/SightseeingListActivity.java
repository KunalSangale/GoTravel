package com.example.gotravel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class SightseeingListActivity extends AppCompatActivity {
    ListView list;
    ImageView img;
    TextView headerText;
    String places[]={
            "Gateway of India",
            "Chhatrapati Shivaji Terminus (CST)",
            "Elephanta Caves",
            "Marin Drive",
            "Sanjay Gandhi National Park",
            "Juhu Beach",
            "Nehru Center",
            "Taraporewala Aquarium"
    };
    Integer[] imageId={
            R.drawable.common_full_open_on_phone

    };
    String id="sightseeing";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        img=findViewById(R.id.header_img);
        headerText=findViewById(R.id.header_text);
        img.setImageResource(R.drawable.sightseeing);
        headerText.setText("Sight Seeing");
        ListAdapter adapter=new ListAdapter(SightseeingListActivity.this,id,places,imageId);
        list=findViewById(R.id.typeOfPlace_listview);
        list.setAdapter(adapter);
    }
}