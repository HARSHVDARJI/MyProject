package com.sunfusheng.StickyHeaderListView.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sunfusheng.StickyHeaderListView.R;
import com.sunfusheng.StickyHeaderListView.adapter.TravelingAdapter;
import com.sunfusheng.StickyHeaderListView.model.ChannelEntity;
import com.sunfusheng.StickyHeaderListView.model.FilterData;
import com.sunfusheng.StickyHeaderListView.model.TravelingEntity;
import com.sunfusheng.StickyHeaderListView.util.ColorUtil;
import com.sunfusheng.StickyHeaderListView.util.DensityUtil;
import com.sunfusheng.StickyHeaderListView.util.ModelUtil;
import com.sunfusheng.StickyHeaderListView.util.StatusBarUtil;
import com.sunfusheng.StickyHeaderListView.view.HeaderBannerView;
import com.sunfusheng.StickyHeaderListView.view.HeaderChannelView;
import com.sunfusheng.StickyHeaderListView.view.SmoothListView.SmoothListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：孙福生
 *
 * 个人博客：sunfusheng.com
 */
public class MainActivity extends AppCompatActivity implements SmoothListView.ISmoothListViewListener {

    @BindView(R.id.listView)
    SmoothListView smoothListView;
    @BindView(R.id.rl_bar)
    RelativeLayout rlBar;
    @BindView(R.id.view_nevbtn_bg)
    View viewNevBg;
    @BindView(R.id.view_action_more_bg)
    View viewActionMoreBg;
    @BindView(R.id.fl_action_more)
    FrameLayout flActionMore;
    @BindView(R.id.drawer_layout)
    DrawerLayout dLayout;
    @BindView(R.id.nev_btn)
    ImageView nevbtn;
    @BindView(R.id.add_post)
    ImageView addnewpost;
    @BindView(R.id.txt_appname)
    TextView txtappname;


    private Context mContext;
    private Activity mActivity;
    private int mScreenHeight; // 屏幕高度

    private List<Integer> bannerList = new ArrayList<>(); // 广告数据
    private List<ChannelEntity> channelList; //= new ArrayList<>(); // 频道数据
    private List<TravelingEntity> travelingList = new ArrayList<>(); // ListView数据

    private List<ChannelEntity> channelList1 = new ArrayList<>();

    private HeaderBannerView headerBannerView; // 广告视图
    private HeaderChannelView headerChannelView;
    private FilterData filterData; // 筛选数据
    private TravelingAdapter mAdapter; // 主页数据
    private View itemHeaderBannerView; // 从ListView获取的广告子View
    private View itemHeaderFilterView; // 从ListView获取的筛选子View
    private boolean isScrollIdle = true; // ListView是否在滑动
    private boolean isStickyTop = false; // 是否吸附在顶部
    private boolean isSmooth = false; // 没有吸附的前提下，是否在滑动
    private int titleViewHeight = 65; // 标题栏的高度

    private int bannerViewHeight = 180; // 广告视图的高度
    private int bannerViewTopMargin; // 广告视图距离顶部的距离

    private int filterViewPosition = 4; // 筛选视图的位置
    private int filterViewTopMargin; // 筛选视图距离顶部的距离

    String[] menu;
    ListView dList;
    LinearLayout header;
    ArrayAdapter<String> adapter;

    int[] img = new int[]{R.drawable.os,
            R.drawable.howto, R.drawable.cms, R.drawable.seo,
            R.drawable.lang, R.drawable.game};

//    String URL = "[\n" +
//            "\n" +
//            "    {\n" +
//            "        \"id\": 1,\n" +
//            "        \"cat_name\": \"OS\"\n" +
//            "    },\n" +
//            "    {\n" +
//            "        \"id\": 2,\n" +
//            "        \"cat_name\": \"LANGUAGE\"\n" +
//            "    },\n" +
//            "    {\n" +
//            "        \"id\": 3,\n" +
//            "        \"cat_name\": \"CMS\"\n" +
//            "    },\n" +
//            "    {\n" +
//            "        \"id\": 4,\n" +
//            "        \"cat_name\": \"SEO\"\n" +
//            "    },\n" +
//            "    {\n" +
//            "        \"id\": 5,\n" +
//            "        \"cat_name\": \"GAME\"\n" +
//            "    },\n" +
//            "    {\n" +
//            "        \"id\": 6,\n" +
//            "        \"cat_name\": \"HOW_TO\"\n" +
//            "    }\n" +
//            "\n" +
//            "]";         response
    String URL = "http://192.168.1.100:8000/categories/?format=json";
                //"http://192.168.1.5:8000/categories/?format=json";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        StatusBarUtil.setStatusBarTranslucent(this, false);

        initData();
        initView();
        initListener();
        customnavigationdrawer();

//        if (headerChannelView == null){
//            Log.d("myapp", "adapter null");
//        }
//        else{
//            Log.d("myapp", "adapter not null");
//        }
    }


    private void customnavigationdrawer() {
        menu =  ModelUtil.getMenudata();
        dLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        dList = (ListView) findViewById(R.id.left_drawer);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, menu);

        header = (LinearLayout) findViewById(R.id.nev_header);

        dList.setAdapter(adapter);
        dList.setSelector(android.R.color.holo_blue_dark);

        nevbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dLayout.openDrawer(GravityCompat.START);
            }
        });

        dList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dLayout.closeDrawers();
                startActivity(new Intent(MainActivity.this, UserPost.class));
            }
        });
    }

    private void initData() {
        mContext = this;
        mActivity = this;
        mScreenHeight = DensityUtil.getWindowHeight(this);

        // 筛选数据
        filterData = new FilterData();
        filterData.setCategory(ModelUtil.getCategoryData());
        filterData.setSorts(ModelUtil.getSortData());
        filterData.setFilters(ModelUtil.getFilterData());
        // 广告数据
        bannerList = ModelUtil.getBannerData();
        // 频道数据
//        channelList = ModelUtil.getChannelData();
        // ListView数据
        travelingList = ModelUtil.getTravelingData();

        Log.d("myapp", "channelList "+travelingList.size());
        channelList = ModelUtil.getChannelData();
//
        Log.d("myapp", "channelList "+channelList.size());
//        new WebserviceCall(this, URL, null, "Loading...", true, new AsyncResponse() {
//            @Override
//            public void onCallback(String response) {
//
//                ChannelEntity[] model = new Gson().fromJson(response, ChannelEntity[].class);
//                Log.d("myapp", ""+ model.length);
//                for (int i = 0; i <model.length ; i++) {
//                    ChannelEntity item = new ChannelEntity
//                            (model[i].getId(), model[i].getCat_name(), cat_img[i]);
//                    channelList.add(item);
////                    Log.d("myapp", "for loop "+ channelList.add(item));
////                    Log.d("myapp", "for loop "+ model[i].getCat_name());
////                    Log.d("myapp", "for loop "+ cat_img[i]);
//                }
//            }
//        }).execute();
    }

    private void initView() {
        // 设置广告数据
        headerBannerView = new HeaderBannerView(this);
        headerBannerView.fillView(bannerList, smoothListView);

        if (channelList == null){
            Log.d("myapp", "null");
        }
        else{
            Log.d("myapp", "not null");
        }
        // 设置频道数据
        headerChannelView = new HeaderChannelView(this);
        headerChannelView.fillView(channelList, smoothListView);

        // 设置ListView数据
        mAdapter = new TravelingAdapter(this, travelingList);
        smoothListView.setAdapter(mAdapter);

        filterViewPosition = smoothListView.getHeaderViewsCount() - 1;
    }


    private void initListener() {
        // 关于
//        flActionMore.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(mActivity, AboutActivity.class));
//            }
//        });


        addnewpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mActivity, NewPost.class));
            }
        });

        smoothListView.setRefreshEnable(true);
        smoothListView.setLoadMoreEnable(true);
        smoothListView.setSmoothListViewListener(this);
        smoothListView.setItemsCanFocus(true);
        smoothListView.setOnItemClickListener(new SmoothListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MainActivity.this, UserPost.class));
            }
        });
        smoothListView.setOnScrollListener(new SmoothListView.OnSmoothScrollListener() {
            @Override
            public void onSmoothScrolling(View view) {}

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                isScrollIdle = (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE);
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (isScrollIdle && bannerViewTopMargin < 0) return;

                // 获取广告头部View、自身的高度、距离顶部的高度
                if (itemHeaderBannerView == null) {
                    itemHeaderBannerView = smoothListView.getChildAt(1-firstVisibleItem);
                }
                if (itemHeaderBannerView != null) {
                    bannerViewTopMargin = DensityUtil.px2dip(mContext, itemHeaderBannerView.getTop());
                    bannerViewHeight = DensityUtil.px2dip(mContext, itemHeaderBannerView.getHeight());
                }

                // 获取筛选View、距离顶部的高度
                if (itemHeaderFilterView == null) {
                    itemHeaderFilterView = smoothListView.getChildAt(filterViewPosition - firstVisibleItem);
                }
                if (itemHeaderFilterView != null) {
                    filterViewTopMargin = DensityUtil.px2dip(mContext, itemHeaderFilterView.getTop());
                }

                // 没有吸附在顶部
                isStickyTop = filterViewTopMargin <= titleViewHeight || firstVisibleItem > filterViewPosition;
                if (isSmooth && isStickyTop) {
                    isSmooth = false;
                }

                // 处理标题栏颜色渐变
                handleTitleBarColorEvaluate();
            }
        });
    }


    // 处理标题栏颜色渐变
    private void handleTitleBarColorEvaluate() {
        float fraction;
        if (bannerViewTopMargin > 0) {
            fraction = 1f - bannerViewTopMargin * 1f / 60;
            if (fraction < 0f) fraction = 0f;
            rlBar.setAlpha(fraction);
            txtappname.setAlpha(fraction);
            return ;
        }

        float space = Math.abs(bannerViewTopMargin) * 1f;
        fraction = space / (bannerViewHeight - titleViewHeight);
        if (fraction < 0f) fraction = 0f;
        if (fraction > 1f) fraction = 1f;
        rlBar.setAlpha(1f);
        txtappname.setAlpha(1f);

        if (fraction >= 1f || isStickyTop) {
            isStickyTop = true;
            viewNevBg.setAlpha(0f);
            viewActionMoreBg.setAlpha(0f);
            rlBar.setBackgroundColor(mContext.getResources().getColor(R.color.colorPrimary));
            txtappname.setTextColor(mContext.getResources().getColor(R.color.white));
        } else {
            viewNevBg.setAlpha(1f - fraction);
            viewActionMoreBg.setAlpha(1f - fraction);
            rlBar.setBackgroundColor(ColorUtil.getNewColorByStartEndColor(mContext, fraction,
                    R.color.transparent, R.color.colorPrimary));
            txtappname.setTextColor(ColorUtil.getNewColorByStartEndColor(mContext, fraction,
                    R.color.transparent, R.color.white));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        headerBannerView.enqueueBannerLoopMessage();
    }

    @Override
    protected void onStop() {
        super.onStop();
        headerBannerView.removeBannerLoopMessage();
    }

//    @Override
//    public void onBackPressed() {
//        if (!filterView.isShowing()) {
//            super.onBackPressed();
//        } else {
//            filterView.resetAllStatus();
//        }
//    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                smoothListView.stopRefresh();
                smoothListView.setRefreshTime("just");
            }
        }, 2000);
    }

    @Override
    public void onLoadMore() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                smoothListView.stopLoadMore();
            }
        }, 2000);
    }

}
