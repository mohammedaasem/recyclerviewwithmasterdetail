package com.aasem.recyclerviewwithmasterdetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView tvData, tvRollNumber, tvContactNumber;
    ImageView ivImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tvData = findViewById(R.id.tv_name);
        tvRollNumber = findViewById(R.id.tv_roll_number);
        tvContactNumber = findViewById(R.id.tv_contact_number);
        ivImage=findViewById(R.id.iv_image);
        Intent intent = getIntent();
        String name = intent.getExtras().getString("name");
        String rollNumber = intent.getExtras().getString("roll_number");
        String contactNumber = intent.getExtras().getString("contact_number");
        int image=intent.getExtras().getInt("image");
        ivImage.setImageResource(image);
        tvData.setText(name);
        tvContactNumber.setText(contactNumber);
        tvRollNumber.setText(rollNumber);
    }
}
