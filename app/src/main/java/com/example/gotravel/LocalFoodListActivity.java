package com.example.gotravel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class LocalFoodListActivity extends AppCompatActivity {
    ListView list;
    ImageView img;
    TextView headerText;
    String places[]={
            "Vada pav",
            "Samosa",
            "Pao Bhaji",
            "Bun Maska",
            "Bombay Duck",
            "Bhelpuri ",
            "Chinese Bhel",
            "Bombay Sandwich",
            "Ragda pattice"
    };
    Integer[] imageId={
            R.drawable.common_full_open_on_phone

    };
    String id="local_food";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        img=findViewById(R.id.header_img);
        headerText=findViewById(R.id.header_text);
        img.setImageResource(R.drawable.local_food);
        headerText.setText("Local Food");
        ListAdapter adapter=new ListAdapter(LocalFoodListActivity.this,id,places,imageId);
        list=findViewById(R.id.typeOfPlace_listview);
        list.setAdapter(adapter);
    }
}