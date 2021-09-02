package com.learningassistant;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.FirebaseDatabase;
import com.learningassistant.databinding.FragmentSecondBinding;

import java.util.List;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private RecyclerView mRecyclerView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @SuppressLint({"SetTextI18n", "UseRequireInsteadOfGet"})
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText course_input, session_input, lecturer_input;
        TextView output;

        //collect user input
        course_input = requireView().findViewById(R.id.editCourse);
        session_input = requireView().findViewById(R.id.editSession);
        lecturer_input = requireView().findViewById(R.id.editLecturer);

        //output user input for confirmation
        output = requireView().findViewById(R.id.output_text);
        ViewGroup operations = requireView().findViewById(R.id.ope_query);
        mRecyclerView = requireView().findViewById(R.id.frecycler);
        //recyclerView.setLayoutManager(new LinearLayoutManager(requireContext().getApplicationContext()));

        //button actions
        binding.complete.setOnClickListener(view1 -> {
            operations.removeView(requireView().findViewById(R.id.query_instruction));
            new FirebaseDatabaseHelper().readLectures(new FirebaseDatabaseHelper.DataStatus() {
                @Override
                public void DataIsLoaded(List<Lecture> lectures, List<String> keys) {
                    new RecyclerView_Config().setConfig(mRecyclerView,getContext().getApplicationContext(),lectures,keys);
                }

                @Override
                public void DataIsInserted() {

                }

                @Override
                public void DataIsUpdated() {

                }

                @Override
                public void DataIsDeleted() {

                }
            });
            //dbreference = FirebaseDatabase.getInstance().getReference("timetable");
            //dbreference.addListenerForSingleValueEvent(valueEventListener);
        });
        binding.LecQuery.setOnClickListener(view1 -> {
            operations.removeView(requireView().findViewById(R.id.query_instruction));

            String lec_query = lecturer_input.getText().toString().trim();

            output.setText("Weekly lectures for : " + lec_query);
            new FirebaseDatabaseHelper().LecLectures(new FirebaseDatabaseHelper.DataStatus() {
                @Override
                public void DataIsLoaded(List<Lecture> lectures, List<String> keys) {
                    new RecyclerView_Config().setConfig(mRecyclerView,getContext().getApplicationContext(),lectures,keys);
                }

                @Override
                public void DataIsInserted() {

                }

                @Override
                public void DataIsUpdated() {

                }

                @Override
                public void DataIsDeleted() {

                }
            },lec_query);

        });
        binding.StuQuery.setOnClickListener(view1 -> {
            operations.removeView(requireView().findViewById(R.id.query_instruction));
            String keyword = course_input.getText().toString().trim() + " " + session_input.getText().toString().trim();
            keyword = keyword.toUpperCase();
            output.setText("Weekly lectures: " + keyword);

            new FirebaseDatabaseHelper().studentLectures(new FirebaseDatabaseHelper.DataStatus() {
                @Override
                public void DataIsLoaded(List<Lecture> lectures, List<String> keys) {
                    new RecyclerView_Config().setConfig(mRecyclerView,getContext().getApplicationContext(),lectures,keys);
                }

                @Override
                public void DataIsInserted() {

                }

                @Override
                public void DataIsUpdated() {

                }

                @Override
                public void DataIsDeleted() {

                }
            },keyword);
        });

        }
}
