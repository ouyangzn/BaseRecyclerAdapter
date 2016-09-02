package com.ouyangzn.module.multiItem;

import com.ouyangzn.base.CommonConstants.ItemType;
import com.ouyangzn.recyclerview.MultipleEntity;

/**
 * Description：
 */
public class TestData implements MultipleEntity {

  private String name;

  private int type;

  public TestData() {
  }

  public TestData(String name, int type) {
    this.name = name;
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  @Override public int getItemType() {
    switch (type) {
      case 1:
        return ItemType.TYPE_1;
      case 2:
        return ItemType.TYPE_2;
      case 3:
        return ItemType.TYPE_3;
      default:
        return ItemType.TYPE_1;
    }
  }
}
