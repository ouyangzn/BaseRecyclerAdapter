package com.ouyangzn.module.emptyRecycler;

import com.ouyangzn.recyclerview.BaseRecyclerViewAdapter;
import com.ouyangzn.recyclerview.BaseViewHolder;
import java.util.List;

/**
 * Description：
 */
public class EmptyRecyclerAdapter extends BaseRecyclerViewAdapter<String> {

  public EmptyRecyclerAdapter(List<String> data) {
    super(0, data);
  }

  @Override protected void convert(BaseViewHolder holder, String item) {

  }
}
