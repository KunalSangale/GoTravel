package com.example.gotravel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LocalFoodDetailActivity extends AppCompatActivity {
    public String title;
    public static final String TAG="Database";
    private TextView tTitle,tPrice,tDescription;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_food_detail);
        Bundle bundle=getIntent().getExtras();
        title=bundle.getString("key");
        Toast.makeText(this,title,Toast.LENGTH_SHORT).show();
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference ref=database.getReference();
        myRef=ref.child("local_food").child(title);
        tTitle=findViewById(R.id.name);
        tPrice=findViewById(R.id.price);
        tDescription=findViewById(R.id.description);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DetailModel temp=snapshot.getValue(DetailModel.class);
                tTitle.setText(temp.title);
                tDescription.setText(temp.description);
                tPrice.setText(temp.price);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG,"Failed to read value",error.toException());
                Toast.makeText(LocalFoodDetailActivity.this,"Failed to load post",Toast.LENGTH_SHORT).show();
            }
        });
    }
}