package com.example.a1_baseclassforactivityadapter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a1_baseclassforactivityadapter.R;
import com.example.a1_baseclassforactivityadapter.activity.MainActivity;
import com.example.a1_baseclassforactivityadapter.model.Member;

import java.util.List;

public class DetailAdapter extends BasicAdapter{
    private Context context;
    private List<Member> members;

    public DetailAdapter(Context context, List<Member> members) {
        this.context = context;
        this.members = members;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_view,parent,false);
        return  new MainAdapter.CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Member member = members.get(position);
        if (holder instanceof MainAdapter.CustomViewHolder){
            LinearLayout click = ((MainAdapter.CustomViewHolder) holder).click;
            TextView first_name = ((MainAdapter.CustomViewHolder) holder).firstName;
            TextView last_name = ((MainAdapter.CustomViewHolder) holder).lastName;
            last_name.setText(member.getLastName());
            first_name.setText(member.getFirstName());


        }

    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    private class CustomViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView firstName,lastName;
        LinearLayout click;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            firstName = itemView.findViewById(R.id.firstName);
            lastName = itemView.findViewById(R.id.lastName);
            click = itemView.findViewById(R.id.click);// bosganimizda kirish uchun
        }
    }
}
