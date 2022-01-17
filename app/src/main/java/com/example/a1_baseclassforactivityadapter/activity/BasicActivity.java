package com.example.a1_baseclassforactivityadapter.activity;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a1_baseclassforactivityadapter.NetWork.BaseServer;
import com.example.a1_baseclassforactivityadapter.model.Member;

import java.util.ArrayList;
import java.util.List;

public class BasicActivity extends AppCompatActivity implements BaseServer {
    protected  String getServes(){
        if (IS_TESTER){
            return SERVER_DEVELOPMENT;
        }
        return SERVER_DEPLOYMENT;
    }
    protected List<Member> prepareMemberList(){
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            members.add(new Member("Sherzod", "Jurabekov"));
        }
        return members;
    }
    protected static boolean isEmpty(final  String s){
        return s == null || s.trim().isEmpty();
    }
}
