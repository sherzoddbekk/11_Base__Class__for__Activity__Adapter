package com.example.a1_baseclassforactivityadapter.activity;

import android.content.Context;
import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a1_baseclassforactivityadapter.R;
import com.example.a1_baseclassforactivityadapter.adapter.DetailAdapter;
import com.example.a1_baseclassforactivityadapter.adapter.MainAdapter;
import com.example.a1_baseclassforactivityadapter.model.Member;

import java.util.List;

public class DetailActivity extends BasicActivity{
    private Context context;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        List<Member> members = prepareMemberList();
        refreshAdapter(members);
    }

    private  void initView(){
        context = this;
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
    }

    private void refreshAdapter(List<Member> members){
        DetailAdapter adapter = new DetailAdapter(context,members);
        recyclerView.setAdapter(adapter);
    }
}
