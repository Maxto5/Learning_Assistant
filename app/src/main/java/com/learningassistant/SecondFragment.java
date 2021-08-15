package com.learningassistant;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.learningassistant.databinding.FragmentSecondBinding;

import java.util.ArrayList;
import java.util.List;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private static RecyclerView recyclerView;
    private static RecyclerView.Adapter adapter;
    private final List<Units> units = new ArrayList<>();
    private final List<String>keys = new ArrayList<>();
    public static FireBaseDatabaseHelper db0 = new FireBaseDatabaseHelper();
    ValueEventListener valueEventListener;
    public static List<String> data;
    public static String keyword;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint({"SetTextI18n", "UseRequireInsteadOfGet"})
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText course_input, session_input, lecturer_input;
        TextView output;

        course_input = requireView().findViewById(R.id.editCourse);
        session_input = requireView().findViewById(R.id.editSession);
        lecturer_input = requireView().findViewById(R.id.editLecturer);
        output = requireView().findViewById(R.id.output_text);
        ViewGroup operations = requireView().findViewById(R.id.ope_query);
        String lec_query = lecturer_input.getText().toString();

        binding.complete.setOnClickListener(view1 -> {
            Intent switchActivityIntent = new Intent(requireContext().getApplicationContext(), Global.class);
            startActivity(switchActivityIntent);

        });
        binding.LecQuery.setOnClickListener(view1 -> {
            output.setText("Weekly lectures: " + lec_query);
            operations.removeView(requireView().findViewById(R.id.query_instruction));
            //Query Lec = FirebaseDatabase.getInstance().getReference("timetable").orderByChild("session").equalTo(lec_query);

            /*try{
                db0.readtimetable(new FireBaseDatabaseHelper.Datastatus() {

                    @Override public void DataIsLoaded(List<Units> units, List<String> keys) {
                        new RecyclerViewConfig().setConfig(requireView().findViewById(R.id.frecycle), requireContext().getApplicationContext(), units, keys);
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
                });
            } catch(Exception ignored){ }*/

        });
        binding.StuQuery.setOnClickListener(view1 -> {
            operations.removeView(requireView().findViewById(R.id.query_instruction));
            keyword = course_input.getText().toString() + " " + session_input.getText().toString();
            output.setText("Weekly lectures: " + keyword);

            try{
                db0.readtimetable(new FireBaseDatabaseHelper.Datastatus() {

                    @Override public void DataIsLoaded(List<Units> units, List<String> keys) {
                        new RecyclerViewConfig().setConfig(requireView().findViewById(R.id.frecycle), requireContext().getApplicationContext(), units, keys);
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
                });
            } catch(Exception ignored){ }
            recyclerView = requireView().findViewById(R.id.frecycle);
            recyclerView.setLayoutManager(new LinearLayoutManager(requireContext().getApplicationContext()));
        });

        }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        }
    }



