package com.ouyangzn.module.multiItem;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import com.ouyangzn.R;
import com.ouyangzn.base.BaseActivity;
import com.ouyangzn.base.CommonConstants.ItemType;
import com.ouyangzn.recyclerview.BaseRecyclerViewAdapter;
import java.util.ArrayList;
import java.util.List;

public class MultiItemActivity extends BaseActivity
    implements BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener,
    BaseRecyclerViewAdapter.OnRecyclerViewItemLongClickListener,
    BaseRecyclerViewAdapter.OnRecyclerViewItemChildClickListener {

  private BaseRecyclerViewAdapter<TestData> mMultiAdapter;
  private RecyclerView mRecyclerView;

  @Override protected void initData() {
    SparseArray<Integer> array = new SparseArray<>();
    array.put(ItemType.TYPE_1, R.layout.item_recycler_type_1);
    array.put(ItemType.TYPE_2, R.layout.item_recycler_type_2);
    array.put(ItemType.TYPE_3, R.layout.item_recycler_type_3);
    mMultiAdapter = new MultipleItemAdapter(array, getTestData());
    mMultiAdapter.setOnRecyclerViewItemClickListener(this);
    mMultiAdapter.setOnRecyclerViewItemLongClickListener(this);
    mMultiAdapter.setOnRecyclerViewItemChildClickListener(this);
  }

  @Override protected void initView(Bundle savedInstanceState) {
    setContentView(R.layout.activity_multi_item);
    setTitle("多类型item");
    mRecyclerView = (RecyclerView) findViewById(R.id.list);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
    //mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));
    LayoutInflater inflater = getLayoutInflater();
    mMultiAdapter.addHeaderView(
        inflater.inflate(R.layout.item_recycler_header, mRecyclerView, false));
    mMultiAdapter.addFooterView(
        inflater.inflate(R.layout.item_recycler_footer, mRecyclerView, false));
    mRecyclerView.setAdapter(mMultiAdapter);
  }

  @Override public void onItemClick(View view, int position) {
    TestData data = mMultiAdapter.getItem(position);
    toast("点击了:" + data.getName());
  }

  @Override public boolean onItemLongClick(View view, int position) {
    TestData data = mMultiAdapter.getItem(position);
    toast("长按:" + data.getName());
    return true;
  }

  @Override public void onItemChildClick(BaseRecyclerViewAdapter adapter, View view, int position) {
    TestData data = mMultiAdapter.getItem(position);

    switch (view.getId()) {
      case R.id.btn_click_me:
        toast("点击了:" + data.getName() + "的按钮");
        break;
      case R.id.img_type2:
      case R.id.img_type3:
        toast("点击了:" + data.getName() + "的图片");
        break;
      default:
        toast("点击了:" + data.getName() + "的其他控件");
        break;
    }
  }

  private List<TestData> getTestData() {
    ArrayList<TestData> list = new ArrayList<>();
    TestData data;
    for (int i = 1; i < 16; i++) {
      data = new TestData();
      data.setName("我是多类型测试数据" + i);
      if (i % 3 == 0) {
        data.setType(ItemType.TYPE_3);
      } else if (i % 3 == 1) {
        data.setType(ItemType.TYPE_1);
      } else if (i % 3 == 2) {
        data.setType(ItemType.TYPE_2);
      }
      list.add(data);
    }
    return list;
  }
}
