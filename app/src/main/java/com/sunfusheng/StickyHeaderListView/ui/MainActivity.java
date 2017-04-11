package com.sunfusheng.StickyHeaderListView.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.sunfusheng.StickyHeaderListView.R;
import com.sunfusheng.StickyHeaderListView.adapter.TravelingAdapter;
import com.sunfusheng.StickyHeaderListView.model.ChannelEntity;
import com.sunfusheng.StickyHeaderListView.model.FilterData;
import com.sunfusheng.StickyHeaderListView.model.OperationEntity;
import com.sunfusheng.StickyHeaderListView.model.TravelingEntity;
import com.sunfusheng.StickyHeaderListView.util.ColorUtil;
import com.sunfusheng.StickyHeaderListView.util.DensityUtil;
import com.sunfusheng.StickyHeaderListView.util.ModelUtil;
import com.sunfusheng.StickyHeaderListView.util.StatusBarUtil;
import com.sunfusheng.StickyHeaderListView.util.ToastUtil;
import com.sunfusheng.StickyHeaderListView.view.HeaderBannerView;
import com.sunfusheng.StickyHeaderListView.view.HeaderChannelView;
import com.sunfusheng.StickyHeaderListView.view.HeaderOperationView;
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

    @BindView(R.id.fab_menu)
    FloatingActionMenu fam;
    @BindView(R.id.fab1)
    FloatingActionButton fabAdd;
    @BindView(R.id.fab2)
    FloatingActionButton fabEdit;
    @BindView(R.id.fab3)
    FloatingActionButton fabDelete;

    private Context mContext;
    private Activity mActivity;
    private int mScreenHeight; // 屏幕高度

    private List<Integer> bannerList = new ArrayList<>(); // 广告数据
    private List<ChannelEntity> channelList = new ArrayList<>(); // 频道数据
    private List<OperationEntity> operationList = new ArrayList<>(); // 运营数据
    private List<TravelingEntity> travelingList = new ArrayList<>(); // ListView数据

    private HeaderBannerView headerBannerView; // 广告视图
    private HeaderChannelView headerChannelView; // 频道视图
    private HeaderOperationView headerOperationView; // 运营视图
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
        floatingActionButton();
    }

    private void floatingActionButton() {

        fam.setOnMenuToggleListener(new FloatingActionMenu.OnMenuToggleListener() {
            @Override
            public void onMenuToggle(boolean opened) {
                if (opened) {
                    fam.getMenuIconView().setImageResource(R.mipmap.edit);
                    ToastUtil.show(mContext, "Menu is opened");
                } else {
                    fam.getMenuIconView().setImageResource(R.drawable.fab_add);
                    ToastUtil.show(mContext, "Menu is closed");
                }
            }
        });

        //handling each floating action button clicked
        fabDelete.setOnClickListener(onButtonClick());
        fabEdit.setOnClickListener(onButtonClick());
        fabAdd.setOnClickListener(onButtonClick());

        fam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fam.isOpened()) {
                    fam.close(true);
                }
            }
        });
    }

    View.OnClickListener onButtonClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == fabAdd) {
                    ToastUtil.show(mContext, "Button Add clicked");
                } else if (view == fabDelete) {
                    ToastUtil.show(mContext, "Button Delete clicked");
                } else {
                    ToastUtil.show(mContext, "Button Edit clicked");
                }
                fam.close(true);
            }
        };
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
                Toast.makeText(MainActivity.this, ""+ position, Toast.LENGTH_SHORT).show();
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
        channelList = ModelUtil.getChannelData();
        // ListView数据
        travelingList = ModelUtil.getTravelingData();
    }

    private void initView() {
        // 设置广告数据
        headerBannerView = new HeaderBannerView(this);
        headerBannerView.fillView(bannerList, smoothListView);

        // 设置频道数据
        headerChannelView = new HeaderChannelView(this);
        headerChannelView.fillView(channelList, smoothListView);

        // 设置运营数据
        headerOperationView = new HeaderOperationView(this);
        headerOperationView.fillView(operationList, smoothListView);

        // 设置ListView数据
        mAdapter = new TravelingAdapter(this, travelingList);
        smoothListView.setAdapter(mAdapter);

        filterViewPosition = smoothListView.getHeaderViewsCount() - 1;
    }

    private void initListener() {
        // 关于
        flActionMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mActivity, AboutActivity.class));
            }
        });

        smoothListView.setRefreshEnable(true);
        smoothListView.setLoadMoreEnable(true);
        smoothListView.setSmoothListViewListener(this);
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
            return ;
        }

        float space = Math.abs(bannerViewTopMargin) * 1f;
        fraction = space / (bannerViewHeight - titleViewHeight);
        if (fraction < 0f) fraction = 0f;
        if (fraction > 1f) fraction = 1f;
        rlBar.setAlpha(1f);

        if (fraction >= 1f || isStickyTop) {
            isStickyTop = true;
            viewNevBg.setAlpha(0f);
            viewActionMoreBg.setAlpha(0f);
            rlBar.setBackgroundColor(mContext.getResources().getColor(R.color.colorPrimary));
        } else {
            viewNevBg.setAlpha(1f - fraction);
            viewActionMoreBg.setAlpha(1f - fraction);
            rlBar.setBackgroundColor(ColorUtil.getNewColorByStartEndColor(mContext, fraction, R.color.transparent, R.color.colorPrimary));
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
