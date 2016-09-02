package com.ouyangzn.module.loadMore;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import com.ouyangzn.R;
import com.ouyangzn.base.BaseActivity;
import com.ouyangzn.recyclerview.BaseRecyclerViewAdapter;
import com.ouyangzn.utils.ThreadUtil;
import java.util.ArrayList;

public class LoadMoreActivity extends BaseActivity
    implements BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener,
    BaseRecyclerViewAdapter.OnRecyclerViewItemLongClickListener,
    BaseRecyclerViewAdapter.OnRecyclerViewItemChildClickListener,
    BaseRecyclerViewAdapter.OnLoadingMoreListener {

  private final int DATA_COUNT_ONCE = 5;
  private final int DATA_COUNT_INIT = 15;
  private final int DATA_COUNT_MAX = 30;

  private LayoutInflater mInflater;
  private RecyclerView mRecyclerView;
  private BaseRecyclerViewAdapter<String> mAdapter;

  @Override protected void initData() {
    mInflater = getLayoutInflater();
    ArrayList<String> list = getTestData(DATA_COUNT_INIT);
    mAdapter = new LoadMoreAdapter(R.layout.item_recycler_type_1, list);
    mAdapter.setOnRecyclerViewItemClickListener(this);
    mAdapter.setOnRecyclerViewItemLongClickListener(this);
    mAdapter.setOnRecyclerViewItemChildClickListener(this);
    mAdapter.setOnLoadingMoreListener(this);
    mAdapter.setHasMore(true);
  }

  @Override protected void initView(Bundle savedInstanceState) {
    setContentView(R.layout.activity_recycler_load_more);
    setTitle("LoadMore");

    mRecyclerView = (RecyclerView) findViewById(R.id.list);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
    mAdapter.addHeaderView(mInflater.inflate(R.layout.item_recycler_header, mRecyclerView, false));
    //mAdapter.addFooterView(mInflater.inflate(R.layout.item_recycler_footer, mRecyclerView, false));
    mAdapter.setLoadMoreView(mInflater.inflate(R.layout.item_loading, mRecyclerView, false));
    mRecyclerView.setAdapter(mAdapter);
  }

  @Override public void onItemClick(View view, int position) {
    toast("点击了第" + (position + 1) + "项的:" + mAdapter.getItem(position));
  }

  @Override public boolean onItemLongClick(View view, int position) {
    toast("长按了第" + (position + 1) + "项的:" + mAdapter.getItem(position));
    return true;
  }

  @Override public void onItemChildClick(BaseRecyclerViewAdapter adapter, View view, int position) {
    switch (view.getId()) {
      case R.id.btn_click_me:
        toast("点击了第" + (position + 1) + "项的:" + mAdapter.getItem(position) + " 的按钮");
        break;
      default:
        toast("点击了第" + (position + 1) + "项的:" + mAdapter.getItem(position) + " 的其他控件");
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

  @Override public void requestMoreData() {
    if (mAdapter.getData().size() >= DATA_COUNT_MAX) {
      mRecyclerView.postDelayed(new Runnable() {
        @Override public void run() {
          mAdapter.loadMoreFinish(false, null);
        }
      }, 50);
      return;
    }
    ThreadUtil.execute(new Runnable() {
      @Override public void run() {
        ThreadUtil.sleep(3000);
        final ArrayList<String> list = getTestData(DATA_COUNT_ONCE);
        mRecyclerView.post(new Runnable() {
          @Override public void run() {
            mAdapter.loadMoreFinish(true, list);
          }
        });
      }
    });
  }
}
