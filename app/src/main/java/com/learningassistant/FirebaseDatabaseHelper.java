package com.learningassistant;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceLectures;
    private List<Lecture> lectures = new ArrayList<>();
    static {FirebaseDatabase.getInstance().setPersistenceEnabled(true);}

    public interface DataStatus{
        void DataIsLoaded(List<Lecture>lectures,List<String>keys);
        void DataIsInserted();void DataIsUpdated();void DataIsDeleted();
    }

    public FirebaseDatabaseHelper() {
            mReferenceLectures = FirebaseDatabase.getInstance().getReference();

    }
    public void readLectures(final DataStatus dataStatus){
        mReferenceLectures.orderByChild("session").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                lectures.clear();
                List<String>keys = new ArrayList<>();
                for(DataSnapshot keyNode: snapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Lecture lecture =keyNode.getValue(Lecture.class);
                    lectures.add(lecture);
                }
                dataStatus.DataIsLoaded(lectures,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void studentLectures(final DataStatus dataStatus,String keyword){
        Query stuquery = FirebaseDatabase.getInstance().getReference().orderByChild("session").equalTo(keyword);
        stuquery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                lectures.clear();
                List<String>keys = new ArrayList<>();
                for(DataSnapshot keyNode: snapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Lecture lecture =keyNode.getValue(Lecture.class);
                    lectures.add(lecture);
                }
                dataStatus.DataIsLoaded(lectures,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void LecLectures(final DataStatus dataStatus,String lec_query){
        Query lequery = FirebaseDatabase.getInstance().getReference().orderByChild("lecturer_name").equalTo(lec_query);
        lequery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                lectures.clear();
                List<String>keys = new ArrayList<>();
                for(DataSnapshot keyNode: snapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Lecture lecture =keyNode.getValue(Lecture.class);
                    lectures.add(lecture);
                }
                dataStatus.DataIsLoaded(lectures,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
