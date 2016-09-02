package com.ouyangzn.module.multiItem;

import android.util.SparseArray;
import com.ouyangzn.R;
import com.ouyangzn.base.CommonConstants.ItemType;
import com.ouyangzn.recyclerview.BaseRecyclerViewAdapter;
import com.ouyangzn.recyclerview.BaseViewHolder;
import java.util.List;

/**
 * Created by ouyangzn on 2016/8/11.<br/>
 * Description：
 */
public class MultipleItemAdapter extends BaseRecyclerViewAdapter<TestData> {

  public MultipleItemAdapter(SparseArray<Integer> layoutMap, List<TestData> data) {
    super(layoutMap, data);
  }

  @Override protected void convert(BaseViewHolder holder, TestData item) {
    int itemType = holder.getItemViewType();
    switch (itemType) {
      case ItemType.TYPE_1:
        holder.setText(R.id.string, item.getName());
        holder.setOnClickListener(R.id.btn_click_me, new OnItemChildClickListener());
        break;
      case ItemType.TYPE_2:
        holder.setImageResource(R.id.img_type2, R.mipmap.ic_launcher);
        holder.setOnClickListener(R.id.img_type2, new OnItemChildClickListener());
        break;
      case ItemType.TYPE_3:
        holder.setText(R.id.string_type_3, item.getName());
        holder.setImageResource(R.id.img_type3, R.mipmap.ic_launcher);
        holder.setOnClickListener(R.id.img_type3, new OnItemChildClickListener());
        break;
    }
  }
}
