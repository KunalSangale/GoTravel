package com.example.gotravel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EntertainmentDetailActivity extends AppCompatActivity {
    public String title;
    public static final String TAG="Database";
    private TextView tTitle,tAddress,tPrice,tType;
    Button submit;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entertainment_detail);
        Bundle bundle=getIntent().getExtras();
        title=bundle.getString("key");
        Toast.makeText(this,title,Toast.LENGTH_SHORT).show();
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference ref=database.getReference();
        myRef=ref.child("entertainment").child(title);
        tTitle=findViewById(R.id.name);
        tAddress=findViewById(R.id.address);
        tPrice=findViewById(R.id.ticketPrice);
        tType=findViewById(R.id.type);
        submit=findViewById(R.id.btn_confirm);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DetailModel temp=snapshot.getValue(DetailModel.class);
                tTitle.setText(temp.title);
                tAddress.setText(temp.address);
                tPrice.setText(temp.ticketPrice);
                tType.setText(temp.type);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG,"Failed to read value",error.toException());
                Toast.makeText(EntertainmentDetailActivity.this,"Failed to load post",Toast.LENGTH_SHORT).show();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EntertainmentDetailActivity.this,"Booking Confirmed",Toast.LENGTH_SHORT).show();
            }
        });
    }
}