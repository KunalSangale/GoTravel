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

public class SightseeingDetailActivity extends AppCompatActivity {
    public String title;
    public static final String TAG="Database";
    private TextView tTitle,tAddress,tDescription;
    Button submit;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sightseeing_detail);
        Bundle bundle=getIntent().getExtras();
        title=bundle.getString("key");
        Toast.makeText(this,title,Toast.LENGTH_SHORT).show();
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference ref=database.getReference();
        myRef=ref.child("sightseeing").child(title);
        tTitle=findViewById(R.id.name);
        tAddress=findViewById(R.id.address);
        tDescription=findViewById(R.id.description);
        //submit=findViewById(R.id.btn_confirm);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DetailModel temp=snapshot.getValue(DetailModel.class);
                tTitle.setText(temp.title);
                tAddress.setText(temp.address);
                tDescription.setText(temp.description);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG,"Failed to read value",error.toException());
                Toast.makeText(SightseeingDetailActivity.this,"Failed to load post",Toast.LENGTH_SHORT).show();
            }
        });
//        submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(SightseeingDetailActivity.this,"Booking Confirmed",Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}