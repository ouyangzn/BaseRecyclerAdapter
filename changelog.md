# 更新记录
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