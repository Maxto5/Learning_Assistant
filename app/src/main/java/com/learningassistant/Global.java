package com.learningassistant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.List;

public class Global extends AppCompatActivity {
    private static RecyclerView mrecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global);
        mrecyclerView = findViewById(R.id.recycle_view);

        try{
        SecondFragment.db0.readtimetable(new FireBaseDatabaseHelper.Datastatus() {

            @Override public void DataIsLoaded(List<Units> units, List<String> keys) {
                new RecyclerViewConfig().setConfig(mrecyclerView, mrecyclerView.getContext(), units, keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsDeleted() {

            }

            @Override
            public void DataIsUpdated() {

            }
        }
           );} catch(Exception ignored){}
    }
}
