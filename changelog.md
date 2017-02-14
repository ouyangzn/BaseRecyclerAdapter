# 更新记录
## 1.1.1
* 1、修复adapter.remove()、adapter.add()引起的bug
* 2、增加方法，当修改item的数据时，调用此方法可以不用考虑是否有headerView
```java
adapter.notifyItemChangedIgnoreHeader()
adapter.notifyItemRangeChangedIgnoreHeader()
```

## 1.1.0
增加loadMoreFailureView
```java
View loadMoreFail = mInflater.inflate(R.layout.item_load_more_failure, mRecyclerView, false);
    loadMoreFail.setOnClickListener(new View.OnClickListener() {
          @Override public void onClick(View v) {
            mAdapter.reloadMore();
          }
        });
    mAdapter.setLoadMoreFailureView(loadMoreFail);
    
// on request data failure:
mAdapter.loadMoreFailure();
```

## 1.0.2
修复一些小问题