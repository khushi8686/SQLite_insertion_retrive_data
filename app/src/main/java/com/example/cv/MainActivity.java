package com.example.cv;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    databasehelper db;
    EditText name,em,ph,dis,degree,skill,exp;
    Button submit,Retrive;
    String NM,EM,PH,DS,DG,SK,EXP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        db=new databasehelper(this);

        name=findViewById(R.id.name);
        em=findViewById(R.id.email);
        ph=findViewById(R.id.number);
        dis=findViewById(R.id.des);
        degree=findViewById(R.id.degree);
        skill=findViewById(R.id.skills);
        exp=findViewById(R.id.exp);
        submit=findViewById(R.id.submite);
        Retrive=findViewById(R.id.retrive_data);
//        Intent intent=new Intent(MainActivity.this,cv.class);
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

//                intent.putExtra("Name",NM);
//              intent.putExtra("Mail",EM);
//              intent.putExtra("Phone",PH);
//                intent.putExtra("Description",DS);
//                intent.putExtra("Degree",DG);
//                intent.putExtra("Skill",SK);
//                intent.putExtra("Experience",EXP);
                boolean checkinsertdata=db.addContact(NM,EM,PH,DS,DG,SK,EXP);
                if(checkinsertdata==true)
                    Toast.makeText(MainActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }
        });


        Retrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res =db.getallDATA();
                if(res.getCount()==0){
                    Toast.makeText(MainActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("ID :"+res.getString(0)+"\n");
                    buffer.append("Name :"+res.getString(1)+"\n");
                    buffer.append("EMAIL :"+res.getString(2)+"\n");
                    buffer.append("PHONE :"+res.getString(3)+"\n");
                    buffer.append("DESCRIPTION :"+res.getString(4)+"\n");
                    buffer.append("DEGREE :"+res.getString(5)+"\n");
                    buffer.append("SKILL :"+res.getString(6)+"\n");
                    buffer.append("EXPERIENCE :"+res.getString(7)+"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });

    }
}