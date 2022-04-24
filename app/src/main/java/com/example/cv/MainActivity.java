package com.example.cv;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    databasehelper db;
    EditText name,em,ph,dis,degree,skill,exp;
    Button submit,Retrive,count,update;
    String NM,EM,PH,DS,DG,SK,EXP;
    static int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        db=new databasehelper(this);
        name=findViewById(R.id.name_txt);
        em=findViewById(R.id.email);
        ph=findViewById(R.id.number);
        dis=findViewById(R.id.des);
        degree=findViewById(R.id.degree);
        skill=findViewById(R.id.skills);
        exp=findViewById(R.id.exp);
        submit=findViewById(R.id.submite);
        Retrive=findViewById(R.id.retrive_data);
        count=findViewById(R.id.count_row);
        update=findViewById(R.id.update);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NM=name.getText().toString();
                if(NM.length()!=0)
                {
                    EM=em.getText().toString();
                PH=ph.getText().toString();
                DS=dis.getText().toString();
                DG=degree.getText().toString();
                SK=skill.getText().toString();
                EXP=exp.getText().toString();
                    i++;
                boolean checkinsertdata=db.addContact(NM,EM,PH,DS,DG,SK,EXP);
                if(checkinsertdata==true)

                    Toast.makeText(MainActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Some Thing IS Empty", Toast.LENGTH_SHORT).show();
                }

            }
        });
        Retrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,testing.class);
                startActivity(intent);
            }
        });
        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "There are "+i+" Rows..!", Toast.LENGTH_SHORT).show();
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idd = name.getText().toString();

                if (TextUtils.isEmpty(idd)) {
                    Toast.makeText(MainActivity.this, "Please enter ID which you want to update", Toast.LENGTH_LONG).show();
                    return;
                }
                boolean isUpdate = db.updateData(
                        name.getText().toString(),
                        em.getText().toString(),
                        ph.getText().toString(),
                        dis.getText().toString(),
                        degree.getText().toString(),
                        skill.getText().toString(),
                        exp.getText().toString());
                if (isUpdate == true) {
                    Toast.makeText(MainActivity.this, "Data Update", Toast.LENGTH_LONG).show();
                    name.setText("");
                    name.setText("");
                    em.setText("");
                    ph.setText("");
                    dis.setText("");
                    degree.setText("");
                    skill.setText("");
                    exp.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Data not Updated", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}