package com.example.gotravel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class TempleListActivity extends AppCompatActivity {
    ListView list;
    ImageView img;
    TextView headerText;
    String temples[]={
            "Shiv Mandir",
            "Shri Mahalakshmi Temple",
            "ISKCON Temple",
            "Siddhivinayak Temple",
            "Mumbadevi Temple",
            "Babulnath Temple",
            "Walkeshwar Temple",
            "Swaminarayan Temple"
    };
    Integer[] imageId={
            R.drawable.common_full_open_on_phone

    };
    String id="temple";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        img=findViewById(R.id.header_img);
        headerText=findViewById(R.id.header_text);
        img.setImageResource(R.drawable.temple);
        headerText.setText("Temples");
        ListAdapter adapter=new ListAdapter(TempleListActivity.this,id,temples,imageId);
        list=findViewById(R.id.typeOfPlace_listview);
        list.setAdapter(adapter);
    }
}