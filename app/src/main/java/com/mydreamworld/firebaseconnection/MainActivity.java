package com.mydreamworld.firebaseconnection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseReference reference= FirebaseDatabase.getInstance().getReference();

        Map<String,String> values=new HashMap<>();

        values.put("Name","Prawin");

        reference.push().setValue(values, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {

           if(databaseError==null){
               Log.i("Save","successs");
           }else{
               Log.i("Save","Failed");
           }
            }
        });
    }
}
