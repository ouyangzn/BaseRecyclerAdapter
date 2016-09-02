package com.ouyangzn.module.normal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import com.ouyangzn.R;
import com.ouyangzn.base.BaseActivity;
import com.ouyangzn.module.multiItem.MultiItemActivity;
import com.ouyangzn.recyclerview.BaseRecyclerViewAdapter;
import java.util.ArrayList;

public class RecyclerViewActivity extends BaseActivity
    implements BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener,
    BaseRecyclerViewAdapter.OnRecyclerViewItemLongClickListener,
    BaseRecyclerViewAdapter.OnRecyclerViewItemChildClickListener, View.OnClickListener {

  private LayoutInflater mInflater;
  private RecyclerView mRecyclerView;
  private BaseRecyclerViewAdapter<String> mAdapter;

  @Override protected void initData() {
    ArrayList<String> list = getTestData(5);
    mAdapter = new ChildClickRecyclerViewAdapter(R.layout.item_recycler_type_1, list);
    mAdapter.setOnRecyclerViewItemClickListener(this);
    mAdapter.setOnRecyclerViewItemLongClickListener(this);
    mAdapter.setOnRecyclerViewItemChildClickListener(this);
    mInflater = getLayoutInflater();
  }

  @Override protected void initView(Bundle savedInstanceState) {
    setContentView(R.layout.activity_recycler_view);
    setTitle("普通recyclerView");

    mRecyclerView = (RecyclerView) findViewById(R.id.list);
    mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 2));
    mAdapter.addHeaderView(mInflater.inflate(R.layout.item_recycler_header, mRecyclerView, false));
    mAdapter.addFooterView(mInflater.inflate(R.layout.item_recycler_footer, mRecyclerView, false));
    mRecyclerView.setAdapter(mAdapter);
    mRecyclerView.postDelayed(new Runnable() {
      @Override public void run() {
        //mAdapter.addData("测试数据null", 2);
        mAdapter.addData("测试数据null");
        mRecyclerView.postDelayed(new Runnable() {
          @Override public void run() {
            mAdapter.resetData(getTestData(10));
          }
        }, 2000);
      }
    }, 2000);
    findViewById(R.id.add_fab).setOnClickListener(this);
  }

  @Override public void onClick(View v) {
    switch (v.getId()) {
      case R.id.add_fab:
        //mAdapter.addData(getTestData(3));
        mAdapter.addData(getTestData(3), 0);
        break;
    }
  }

  @Override public void onItemClick(View view, int position) {
    toast("点击了第" + (position + 1) + "项");
  }

  @Override public boolean onItemLongClick(View view, int position) {
    toast("长按删除第" + (position + 1) + "项");
    //mAdapter.remove(position);
    mAdapter.remove(mAdapter.getItem(position));
    return true;
  }

  @Override public void onItemChildClick(BaseRecyclerViewAdapter adapter, View view, int position) {
    switch (view.getId()) {
      case R.id.btn_click_me:
        toast("点击了第" + (position + 1) + "项的按钮");
        break;
      default:
        toast("点击了第" + (position + 1) + "项的其他控件");
        break;
    }
  }

  @NonNull private ArrayList<String> getTestData(int length) {
    ArrayList<String> list = new ArrayList<>();
    for (int i = 1; i < length + 1; i++) {
      list.add("测试数据" + i);
    }
    return list;
  }
}
