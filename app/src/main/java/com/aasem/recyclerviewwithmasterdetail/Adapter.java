package com.aasem.recyclerviewwithmasterdetail;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by inspire_info_soft on 5/2/2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    Context context;
    ArrayList<DataStudent> dataStudents;

    public Adapter(Context context, ArrayList<DataStudent> dataStudents) {
        this.context = context;
        this.dataStudents = dataStudents;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvRollNumber;
        public CardView cardView;

        public MyViewHolder(View view) {
            super(view);
            tvRollNumber = (TextView) view.findViewById(R.id.tv_roll_number);
            cardView = (CardView) view.findViewById(R.id.card_view);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final DataStudent dataStudent = dataStudents.get(position);
        Collections.sort(dataStudents, DataStudent.SORT_BY_NAME);
        holder.tvRollNumber.setText(dataStudent.getRollNumber());
        holder.cardView.setTag(position);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = (int) view.getTag();
                openDetailActivity(dataStudent.getRollNumber(), dataStudent.getName(), dataStudent.getContactNumber(),dataStudent.getImage());
            }
        });
    }

    private void openDetailActivity(String rollNumber, String name, String contactNumber,int image) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("roll_number", rollNumber);
        intent.putExtra("contact_number", contactNumber);
        intent.putExtra("image", image);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return dataStudents.size();
    }
}
