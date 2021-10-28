package com.example.gotravel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class RestaurantListActivity extends AppCompatActivity {
    ListView list;
    ImageView img;
    TextView headerText;
    String restaurants[]={
            "The Bombay Canteen",
            "JW Cafe",
            "Chembur 65",
            "Romanos",
            "Barbeque Nation",
            "Chaayos",
            "Boulevard",
            "Seven Kitchens"
    };
    Integer[] imageId={
            R.drawable.common_full_open_on_phone

    };
    String id="restaurant";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_restaurant_list);
        setContentView(R.layout.list);
        img=findViewById(R.id.header_img);
        headerText=findViewById(R.id.header_text);
        img.setImageResource(R.drawable.restaurant);
        headerText.setText("Restaurants");
//        RestaurantListAdapter adapter=new RestaurantListAdapter(RestaurantListActivity.this,restaurants,imageId);
        ListAdapter adapter=new ListAdapter(RestaurantListActivity.this,id,restaurants,imageId);
        list=findViewById(R.id.typeOfPlace_listview);
        list.setAdapter(adapter);
    }
}