package com.example.cv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class myadapter extends BaseAdapter {
    Context context;
    ArrayList<contantmodel> arrayList;
    public myadapter(Context context, ArrayList<contantmodel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return this.arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view =inflater.inflate(R.layout.layout_file,null);
            TextView t1_id=(TextView) view.findViewById(R.id.id_txt);
            TextView t2_name=(TextView) view.findViewById(R.id.name_txt);
            TextView t3_email=(TextView) view.findViewById(R.id.email_txt);
            TextView t4_phone=(TextView) view.findViewById(R.id.phone_txt);
            TextView t5_descr=(TextView) view.findViewById(R.id.descr_txt);
            TextView t6_degree=(TextView) view.findViewById(R.id.degree_txt);
            TextView t7_skill=(TextView) view.findViewById(R.id.skill_txt);
            TextView t8_exper=(TextView) view.findViewById(R.id.exper_txt);

            contantmodel contantmodel=arrayList.get(i);
            t1_id.setText(String.valueOf(contantmodel.getId()));
        t2_name.setText(contantmodel.getName());
        t3_email.setText(contantmodel.getMail());
        t4_phone.setText(contantmodel.getPhone_no());
        t5_descr.setText(contantmodel.getDescripation());
        t6_degree.setText(contantmodel.getDegree());
        t7_skill.setText(contantmodel.getSkill());
        t8_exper.setText(contantmodel.getExperience());

        return view;
    }
}
