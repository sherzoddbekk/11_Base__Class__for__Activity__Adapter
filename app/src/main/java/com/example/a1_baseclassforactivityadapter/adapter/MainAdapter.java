package com.example.a1_baseclassforactivityadapter.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a1_baseclassforactivityadapter.R;
import com.example.a1_baseclassforactivityadapter.activity.BasicActivity;
import com.example.a1_baseclassforactivityadapter.activity.MainActivity;
import com.example.a1_baseclassforactivityadapter.model.Member;

import java.util.List;

public class MainAdapter extends BasicAdapter {

    private MainActivity activity;
    private List<Member> members;

    public MainAdapter(MainActivity activity, List<Member> members) {
        this.activity = activity;
        this.members = members;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_view,parent,false);
       return  new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Member member = members.get(position);
        if (holder instanceof  CustomViewHolder){
            LinearLayout click = ((CustomViewHolder) holder).click;
            TextView first_name = ((CustomViewHolder) holder).firstName;
            TextView last_name = ((CustomViewHolder) holder).lastName;

            last_name.setText(member.getLastName());
            first_name.setText(member.getFirstName());

            click.setOnClickListener((view)-> {
                activity.openItemDetails(member);
            });
        }

    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    static class CustomViewHolder extends RecyclerView.ViewHolder {
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
