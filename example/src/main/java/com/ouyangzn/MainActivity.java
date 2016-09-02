package com.ouyangzn;

import android.os.Bundle;
import android.view.View;
import com.ouyangzn.base.BaseActivity;
import com.ouyangzn.module.emptyRecycler.EmptyRecyclerActivity;
import com.ouyangzn.module.loadMore.LoadMoreActivity;
import com.ouyangzn.module.multiItem.MultiItemActivity;
import com.ouyangzn.module.normal.RecyclerViewActivity;

public class MainActivity extends BaseActivity {

  @Override protected void initData() {
  }

  @Override protected void initView(Bundle savedInstanceState) {
    setContentView(R.layout.activity_main);
    setTitle("RecyclerViewDemo");
  }

  public void testNormalRecycler(View view) {
    openActivity(RecyclerViewActivity.class);
  }

  public void testMultiItem(View view) {
    openActivity(MultiItemActivity.class);
  }

  public void testEmpty(View view) {
    openActivity(EmptyRecyclerActivity.class);
  }

  public void testLoadMore(View view) {
    openActivity(LoadMoreActivity.class);
  }
}
