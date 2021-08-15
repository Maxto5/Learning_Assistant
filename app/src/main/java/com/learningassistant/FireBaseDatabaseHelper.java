package com.learningassistant;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public  class FireBaseDatabaseHelper extends AppCompatActivity {
     private final DatabaseReference mReferenceUnits;
     private final List<Units> units = new ArrayList<>();
     private final List<String>keys = new ArrayList<>();
    public interface Datastatus{
        void DataIsLoaded(List<Units> units, List<String>keys);
        void DataIsInserted();
        void DataIsDeleted();
        void DataIsUpdated();
    }

    public FireBaseDatabaseHelper() {

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        mReferenceUnits = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public Context getApplicationContext() {
        return null;
    }

    public void readtimetable( Datastatus datastatus){

        mReferenceUnits.orderByChild("session").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                units.clear();

                for (DataSnapshot keynode: datasnapshot.getChildren()){
                    keys.add(keynode.getKey());
                    Units lecture = keynode.getValue(Units.class);
                    units.add(lecture);
                }
                datastatus.DataIsLoaded(units,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
