package com.example.myapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Fragment.dierFragment;
import com.example.myapplication.Fragment.disanFragment;
import com.example.myapplication.Fragment.disiFragment;
import com.example.myapplication.Fragment.diyiFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button b1,b2,b3,b4;

    private diyiFragment diyiFragment;
    private dierFragment dierFragment;
    private disanFragment disanFragment;
    private disiFragment disiFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        zhufangfa(0);
    }

    //初始化
    private void initViews(){
        b1 = (Button)findViewById(R.id.btn_an1);
        b2 = (Button)findViewById(R.id.btn_an2);
        b3 = (Button)findViewById(R.id.btn_an3);
        b4 = (Button)findViewById(R.id.btn_an4);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
    }

    //主方法
    private void zhufangfa(int i){
        FragmentManager fm = getSupportFragmentManager();    //获得一个管理器
        FragmentTransaction ft = fm.beginTransaction();     //开启一个事务
        yinchang(ft);
        switch (i){
            case 0:
                b1.setTextColor(getResources().getColor(R.color.cl_btn_textb));
                if (diyiFragment == null){
                    diyiFragment = new diyiFragment();
                    ft.add(R.id.fl_fragment1,diyiFragment);
                }else {
                    ft.show(diyiFragment);
                }
                break;
            case 1:
                b2.setTextColor(getResources().getColor(R.color.cl_btn_textb));
                if (dierFragment == null){
                    dierFragment = new dierFragment();
                    ft.add(R.id.fl_fragment1,dierFragment);
                }else {
                    ft.show(dierFragment);
                }
                break;
            case 2:
                b3.setTextColor(getResources().getColor(R.color.cl_btn_textb));
                if (disanFragment == null){
                    disanFragment = new disanFragment();
                    ft.add(R.id.fl_fragment1,disanFragment);
                }else {
                    ft.show(disanFragment);
                }
                break;
            case 3:
                b4.setTextColor(getResources().getColor(R.color.cl_btn_textb));
                if (disiFragment == null){
                    disiFragment = new disiFragment();
                    ft.add(R.id.fl_fragment1,disiFragment);
                }else {
                    ft.show(disiFragment);
                }
                break;
        }
        ft.commit();    //提交事务

    }

    //隐藏Fragment
    private void yinchang(FragmentTransaction fragmentTransaction){
        if (diyiFragment != null){
            fragmentTransaction.hide(diyiFragment);
        }
        if (dierFragment != null){
            fragmentTransaction.hide(dierFragment);
        }
        if (disanFragment != null){
            fragmentTransaction.hide(disanFragment);
        }
        if (disiFragment != null){
            fragmentTransaction.hide(disiFragment);
        }
    }

    //还原
    private void huanyuan(){
        b1.setTextColor(getResources().getColor(R.color.cl_btn_text));
        b2.setTextColor(getResources().getColor(R.color.cl_btn_text));
        b3.setTextColor(getResources().getColor(R.color.cl_btn_text));
        b4.setTextColor(getResources().getColor(R.color.cl_btn_text));
    }

    //点击事件
    @Override
    public void onClick(View v) {
        huanyuan();
        switch (v.getId()){
            case R.id.btn_an1:
                zhufangfa(0);
                break;
            case R.id.btn_an2:
                zhufangfa(1);
                break;
            case R.id.btn_an3:
                zhufangfa(2);
                break;
            case R.id.btn_an4:
                zhufangfa(3);
                break;
        }
    }
}
