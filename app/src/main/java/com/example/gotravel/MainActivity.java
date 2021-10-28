package com.example.gotravel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import org.apache.commons.io.FileUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button hotels,restaurants,temples,sightseeing,local_food,entertainment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hotels=findViewById(R.id.hotel);
        hotels.setOnClickListener(this);
        restaurants=findViewById(R.id.restaurant);
        restaurants.setOnClickListener(this);
        temples=findViewById(R.id.temple);
        temples.setOnClickListener(this);
        local_food=findViewById(R.id.local_food);
        local_food.setOnClickListener(this);
        entertainment=findViewById(R.id.entertainment);
        entertainment.setOnClickListener(this);
        sightseeing=findViewById(R.id.sightseeing);
        sightseeing.setOnClickListener(this);
        Toolbar toolBar=findViewById(R.id.toolbar);
        if(toolBar != null)
        {
            setSupportActionBar(toolBar);
        }
//        hotels.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this,HotelListActivity.class));
//                finish();
//            }
//        });
//        restaurants.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this,RestaurantListActivity.class));
//                finish();
//            }
//        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.signOut){
            FirebaseAuth.getInstance().signOut();
            finish();
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.hotel:
                startActivity(new Intent(MainActivity.this,HotelListActivity.class));
                //finish();
                break;
            case R.id.restaurant:
                startActivity(new Intent(MainActivity.this,RestaurantListActivity.class));
                //finish();
                break;
            case R.id.entertainment:
                startActivity(new Intent(MainActivity.this,EntertainmentListActivity.class));
                //finish();
                break;
            case R.id.temple:
                startActivity(new Intent(MainActivity.this,TempleListActivity.class));
               // finish();
                break;
            case R.id.local_food:
                startActivity(new Intent(MainActivity.this,LocalFoodListActivity.class));
                //finish();
                break;
            case R.id.sightseeing:
                startActivity(new Intent(MainActivity.this,SightseeingListActivity.class));
                //finish();
                break;
            default:
                break;
        }

    }

}