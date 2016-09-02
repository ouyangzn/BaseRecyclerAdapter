package com.ouyangzn.module.emptyRecycler;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import com.ouyangzn.R;
import com.ouyangzn.base.BaseActivity;

public class EmptyRecyclerActivity extends BaseActivity {

  private RecyclerView mRecyclerView;
  private EmptyRecyclerAdapter mAdapter;
  private LayoutInflater mInflater;

  @Override protected void initData() {
    mAdapter = new EmptyRecyclerAdapter(null);
    mInflater = getLayoutInflater();
  }

  @Override protected void initView(Bundle savedInstanceState) {
    setContentView(R.layout.activity_empty_recycler);
    setTitle("无数据测试");
    mRecyclerView = (RecyclerView) findViewById(R.id.list);
    //mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
    mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));
    mAdapter.setEmptyView(mInflater.inflate(R.layout.item_empty, mRecyclerView, false));
    mAdapter.setShowHeaderFooterWhenEmpty(true);
    mAdapter.addHeaderView(mInflater.inflate(R.layout.item_recycler_header, mRecyclerView, false));
    mAdapter.addFooterView(mInflater.inflate(R.layout.item_recycler_footer, mRecyclerView, false));
    mRecyclerView.setAdapter(mAdapter);
  }
}
