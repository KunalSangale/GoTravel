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

public class TempleDetailActivity extends AppCompatActivity {
    public String title;
    public static final String TAG="Database";
    private TextView tTitle,tAddress,tDescription;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temple_detail);
        Bundle bundle=getIntent().getExtras();
        title=bundle.getString("key");
        Toast.makeText(this,title,Toast.LENGTH_SHORT).show();
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference ref=database.getReference();
        myRef=ref.child("temple").child(title);
        tTitle=findViewById(R.id.name);
        tAddress=findViewById(R.id.address);
        tDescription=findViewById(R.id.description);
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
                Toast.makeText(TempleDetailActivity.this,"Failed to load post",Toast.LENGTH_SHORT).show();
            }
        });

    }
}