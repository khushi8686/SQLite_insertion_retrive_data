package com.example.cv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name,em,ph,dis,degree,skill,exp;
    Button submit;
    String NM,EM,PH,DS,DG,SK,EXP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        em=findViewById(R.id.email);
        ph=findViewById(R.id.number);
        dis=findViewById(R.id.des);
        degree=findViewById(R.id.degree);
        skill=findViewById(R.id.skills);
        exp=findViewById(R.id.exp);
        submit=findViewById(R.id.submite);

        Intent intent=new Intent(MainActivity.this,cv.class);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NM=name.getText().toString();
                EM=em.getText().toString();
                PH=ph.getText().toString();
                DS=dis.getText().toString();
                DG=degree.getText().toString();
                SK=skill.getText().toString();
                EXP=exp.getText().toString();

                intent.putExtra("name",NM);
              intent.putExtra("email",EM);
              intent.putExtra("phone",PH);
                intent.putExtra("description",DS);
                intent.putExtra("degree",DG);
                intent.putExtra("skill",SK);
                intent.putExtra("experience",EXP);
                startActivity(intent);
            }
        });





    }
}