package com.ouyangzn.module.loadMore;

import com.ouyangzn.R;
import com.ouyangzn.recyclerview.BaseRecyclerViewAdapter;
import com.ouyangzn.recyclerview.BaseViewHolder;
import java.util.List;

/**
 * Description：
 */
public class LoadMoreAdapter extends BaseRecyclerViewAdapter<String> {

  public LoadMoreAdapter(int layoutResId, List<String> data) {
    super(layoutResId, data);
  }

  @Override protected void convert(BaseViewHolder holder, String item) {
    holder.setText(R.id.string, item);
    holder.setOnClickListener(R.id.btn_click_me, new OnItemChildClickListener());
  }
}
