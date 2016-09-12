# BaseRecyclerAdapter

Super RecyclerView Adapter

## Features：
- 1、支持item和item中某个控件的click事件：
```java
    mAdapter.setOnRecyclerViewItemClickListener(this);
    mAdapter.setOnRecyclerViewItemLongClickListener(this);
    mAdapter.setOnRecyclerViewItemChildClickListener(this);
```
- 2、支持自由添加header、footer、emptyView：
```java
    mAdapter.addHeaderView(mInflater.inflate(R.layout.item_recycler_header, mRecyclerView, false));
    mAdapter.addFooterView(mInflater.inflate(R.layout.item_recycler_footer, mRecyclerView, false));
    mAdapter.setEmptyView(mInflater.inflate(R.layout.item_empty, mRecyclerView, false));
    mAdapter.setShowHeaderFooterWhenEmpty(true);
```
- 3、支持多种类型item的adapter，多类型item使用接口定义各自的itemType：
```java
    public class TestData implements MultipleEntity
```
- 4、支持loadMore：
```java
    mAdapter.setOnLoadingMoreListener(this);
    mAdapter.setHasMore(true);
```
## 使用（usage）：
compile 'com.ouyangzn.lib:BaseRecyclerViewAdapter:1.0.0'
    
### 具体用法见Exmaple

## 参考Thanks：
[BaseRecyclerViewAdapterHelper](https://github.com/CymChad/BaseRecyclerViewAdapterHelper)

## License
Copyright 2016 ouyangzn

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
