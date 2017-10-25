package com.com.freet.a1019project2.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.com.freet.a1019project2.R;

import java.util.ArrayList;

/**
 * Created by freet on 2017-10-13.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private ArrayList<MemberDTD> memberDTD = new ArrayList<>();

    public RecyclerViewAdapter()
    {
        memberDTD.add(new MemberDTD("전화번호","010-2042-1142"));
        memberDTD.add(new MemberDTD("요금제","선불 절약 요금제"));
        memberDTD.add(new MemberDTD("현재상태","정상"));
        memberDTD.add(new MemberDTD("현재잔액","12,123 원"));
        memberDTD.add(new MemberDTD("착발신일자","-"));
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //XML 가져오는 메소드

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_main_item, parent, false);

        return new Rowcell(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //데이터 셋팅하는 부분
        ((Rowcell)holder).name.setText(memberDTD.get(position).name);
        ((Rowcell)holder).msg.setText(memberDTD.get(position).msg);
    }

    @Override
    public int getItemCount() {
        return memberDTD.size();
    }

    private class Rowcell extends RecyclerView.ViewHolder {
        TextView name, msg;

        public Rowcell(View view) {
            super(view);
            name = (TextView)view.findViewById(R.id.name);
            msg = (TextView)view.findViewById(R.id.msg);
        }
    }
}
