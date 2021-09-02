package com.learningassistant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerView_Config {
    private Context mContext;
    private  LectureAdapter mLectureAdapter;
    public void setConfig(RecyclerView recyclerView,Context context,List<Lecture> lectures,List<String>keys){
        mContext = context;
        mLectureAdapter = new LectureAdapter(lectures,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mLectureAdapter);

    }
    class LectureItemView extends RecyclerView.ViewHolder{
        private TextView mUnit_code,mUnit_name,mUnit_session,mday,mtime,mlecturer;
        private String key;

        public LectureItemView(ViewGroup parent){
            super(LayoutInflater.from(mContext) .inflate(R.layout.lecture_list_item,parent,false));

            mUnit_code = itemView.<TextView>findViewById(R.id.unit_code);
            mUnit_name = itemView.<TextView>findViewById(R.id.unit_name);
            mUnit_session = itemView.<TextView>findViewById(R.id.unit_session);
            mday = itemView.<TextView>findViewById(R.id.day);
            mtime = itemView.<TextView>findViewById(R.id.time);
            mlecturer = itemView.<TextView>findViewById(R.id.lecturer);
        }
        public void bind(Lecture lecture,String key){
            mUnit_code.setText(lecture.getUnit_code());
            mUnit_name.setText(lecture.getUnit_name());
            mUnit_session.setText(lecture.getSession());
            mday.setText(lecture.getDay());
            mtime.setText(lecture.getTime());
            mlecturer.setText(lecture.getLecturer_name());
            this.key = key;
        }

    }
    class LectureAdapter extends RecyclerView.Adapter<LectureItemView>{
        private List<Lecture> mLectureList;
        private List<String> mKeys;

        public LectureAdapter(List<Lecture> mLectureList, List<String> mKeys) {
            this.mLectureList = mLectureList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public LectureItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new LectureItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull LectureItemView holder, int position) {
            holder.bind(mLectureList.get(position),mKeys.get(position));

        }

        @Override
        public int getItemCount() {
            return mLectureList.size();
        }
    }

}
