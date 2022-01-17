package com.example.a1_baseclassforactivityadapter.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.a1_baseclassforactivityadapter.R;
import com.example.a1_baseclassforactivityadapter.adapter.DetailAdapter;
import com.example.a1_baseclassforactivityadapter.adapter.MainAdapter;
import com.example.a1_baseclassforactivityadapter.model.Member;

import java.util.List;

public class MainActivity extends BasicActivity {
 private Context context;
private RecyclerView recyclerView;
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
      recyclerView.setLayoutManager(new GridLayoutManager(context,1));
    }

    private void refreshAdapter(List<Member> members){
        MainAdapter adapter = new MainAdapter(this,members);// o`rin almashtirish kerak ekan
        recyclerView.setAdapter(adapter);
    }


    public  void openItemDetails(Member member){
       // Log.d("@@@@@", "item list clicked : " + member.getFirstName());
        Intent intent = new Intent(context, DetailActivity.class);
        startActivity(intent);
    }
}