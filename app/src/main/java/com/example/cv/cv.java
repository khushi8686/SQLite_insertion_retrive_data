package com.example.cv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class cv extends AppCompatActivity {

    TextView names,like,share,views,info;
    Button btnfol,btn;
    ImageView back;
    String getephone;
    String getemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv);


        back=findViewById(R.id.goback);
        names=findViewById(R.id.names);
        btnfol=findViewById(R.id.btnfoll);
        btn=findViewById(R.id.btnmsg);
        info=findViewById(R.id.descrip);
        like=findViewById(R.id.likes);
        share=findViewById(R.id.shares);
        views=findViewById(R.id.viewss);



        Intent intent= getIntent();
        String getname = intent.getStringExtra("name");
        getemail=intent.getStringExtra("email");
        getephone=intent.getStringExtra("phone");
        String getedescription=intent.getStringExtra("description");
        String getedegree=intent.getStringExtra("degree");
        String geteskill=intent.getStringExtra("skill");
        String geteexperience=intent.getStringExtra("experience");

        names.setText(getname);
        info.setText(getedescription);
        like.setText(getedegree);
        share.setText(geteskill);
        views.setText(geteexperience);


    }

    public void phone(View view) {
        btnfol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri=Uri.parse("tel:"+getephone);
                Intent phone=new Intent(Intent.ACTION_DIAL,uri);
                startActivity(phone);
            }
        });
    }

    public void mail(View view) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri=Uri.parse("mailto:"+getemail);
                Intent mails=new Intent(Intent.ACTION_SENDTO,uri);
                startActivity(mails);
            }
        });
    }
}