package com.example.gotravel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class EntertainmentListActivity extends AppCompatActivity {
    ListView list;
    ImageView img;
    TextView headerText;
    String entertainment[]={
            "Cubic Mall",
            "K Star",
            "Carnival Cinemas",
            "INOX R City",
            "Phoenix",
            "INOX InOrbit",
            "PVR Cinemas",
            "Movietime Suburbia"
    };
    Integer[] imageId={
            R.drawable.common_full_open_on_phone

    };
    String id="entertainment";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        img=findViewById(R.id.header_img);
        headerText=findViewById(R.id.header_text);
        img.setImageResource(R.drawable.entertainment);
        headerText.setText("Entertainment");
        ListAdapter adapter=new ListAdapter(EntertainmentListActivity.this,id,entertainment,imageId);
        list=findViewById(R.id.typeOfPlace_listview);
        list.setAdapter(adapter);
    }
}