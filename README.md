# BaseRecyclerAdapter

Super RecyclerView Adapter

<p><b>Features：</b></p>
<li>
1、支持item和item中某个控件的click事件：</br>
    mAdapter.setOnRecyclerViewItemClickListener(this);
    mAdapter.setOnRecyclerViewItemLongClickListener(this);
    mAdapter.setOnRecyclerViewItemChildClickListener(this);
</li>    
<li>
2、支持自由添加header、footer、emptyView：</br>
    mAdapter.addHeaderView(mInflater.inflate(R.layout.item_recycler_header, mRecyclerView, false));
    mAdapter.addFooterView(mInflater.inflate(R.layout.item_recycler_footer, mRecyclerView, false));
    mAdapter.setEmptyView(mInflater.inflate(R.layout.item_empty, mRecyclerView, false));
    mAdapter.setShowHeaderFooterWhenEmpty(true);
</li>     

<li>   
3、支持多种类型item的adapter，多类型item使用接口定义各自的itemType：</br>
    public class TestData implements MultipleEntity
</li> 

<li>
4、支持loadMore：</br>
    mAdapter.setOnLoadingMoreListener(this);
    mAdapter.setHasMore(true);
</li>    

</br><b>具体用法见Exmaple</b>

<p><b>参考Thanks：</b></p>
<a href = https://github.com/CymChad/BaseRecyclerViewAdapterHelper>BaseRecyclerViewAdapterHelper</a>

<p><b>License</b></p>
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
