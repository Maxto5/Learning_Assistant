package com.learningassistant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewConfig {
    private Context mContext;

    public void setConfig(RecyclerView recyclerView,Context context,List<Units>units,List<String> keys){
        mContext = context;
        LectureAdapter mLectureAdapter = new LectureAdapter(units, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mLectureAdapter);
    }

    class LectureItemView extends RecyclerView.ViewHolder{
        private final TextView mCode,mName,msession,mDay,mTime;


        public LectureItemView(@NonNull ViewGroup parent) {
            super(LayoutInflater.from(mContext).inflate(R.layout.lecture_list_item,parent,false));
            mCode = itemView.findViewById(R.id.unit_code);
            mName = itemView.findViewById(R.id.unit_name);
            mDay = itemView.findViewById(R.id.day);
            mTime = itemView.findViewById(R.id.time);
            msession = itemView.findViewById(R.id.unit_session);
        }
        public void bind(Units units){
            mCode.setText(units.getUnit_code());
            mName.setText(units.getUnit_name());
            mDay.setText(units.getDay());
            mTime.setText(units.getTime());
            msession.setText(units.getSession());
        }
    }
    class LectureAdapter extends RecyclerView.Adapter<LectureItemView>{
            private final List<Units> mLectureList;

        public LectureAdapter(List<Units> mLectureList, List<String> mKeys) {
                this.mLectureList = mLectureList;
        }

            @NonNull
            @Override
            public LectureItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new LectureItemView(parent);
            }

            @Override
            public void onBindViewHolder(@NonNull LectureItemView holder, int position) {
                holder.bind(mLectureList.get(position));
            }

            @Override
            public int getItemCount() {
                return mLectureList.size();
            }
        }
    }

