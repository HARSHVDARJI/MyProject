package com.sunfusheng.StickyHeaderListView.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sunfusheng.StickyHeaderListView.R;
import com.sunfusheng.StickyHeaderListView.model.TravelingEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sunfusheng on 16/4/20.
 */
public class TravelingAdapter extends BaseListAdapter<TravelingEntity> {
    Context context;
    List<TravelingEntity> list;

    public TravelingAdapter(Context context) {
        super(context);
    }

    public TravelingAdapter(Context context, List<TravelingEntity> list) {
        super(context, list);
        this.context= context;
        this.list = list;
    }

    @Override
    public int getViewTypeCount() {
        // return the total number of view types. this value should never change
        // at runtime
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        // return a value between 0 and (getViewTypeCount - 1)
        return position % 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TravelingAdapter.ViewHolder holder = null;

        // inflate layout from xml
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        int layoutResource = 0; // determined by view type
        int viewType = getItemViewType(position);
        switch (viewType) {
            case 0:
                layoutResource = R.layout.item_even_listview;
                break;

            case 1:
                layoutResource = R.layout.item_odd_listview;
                break;
        }

        if (convertView != null) {
            holder = (TravelingAdapter.ViewHolder) convertView.getTag();
        } else {
            convertView = inflater.inflate(layoutResource, parent, false);
            holder = new TravelingAdapter.ViewHolder(convertView);
            convertView.setTag(holder);
        }
        holder.tvCat_tag.setText(list.get(position).getTag());
        holder.tvTitle.setText(list.get(position).getTitle());
        holder.tvUsername.setText(list.get(position).getUsername());
        holder.ivImage.setImageResource(list.get(position).getProfile());
        holder.tvLikes.setId(list.get(position).getLike());
        holder.tvComments.setId(list.get(position).getComments());
        // set data to views
//        if (getItem(position).isGender()) {
//            holder.gender.setImageResource(R.drawable.male);
//        } else {
//            holder.gender.setImageResource(R.drawable.female);
//        }
//        holder.name.setText(getItem(position).getName());

        return convertView;
    }
    static class ViewHolder {
//        @BindView(R.id.ll_root_view)
//        LinearLayout llRootView;
        @BindView(R.id.iv_image)
        ImageView ivImage;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.username)
        TextView tvUsername;
        @BindView(R.id.cat_tag)
        TextView tvCat_tag;
        @BindView(R.id.num_likes)
        TextView tvLikes;
        @BindView(R.id.num_comments)
        TextView tvComments;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

//    private boolean isNoData;
//    private int mHeight;
//    public static final int ONE_SCREEN_COUNT = 8; // 一屏能显示的个数，这个根据屏幕高度和各自的需求定
//    public static final int ONE_REQUEST_COUNT = 10; // 一次请求的个数
//
//    public TravelingAdapter(Context context) {
//        super(context);
//    }
//
//    public TravelingAdapter(Context context, List<TravelingEntity> list) {
//        super(context, list);
//    }
//
//    // 设置数据
//    public void setData(List<TravelingEntity> list) {
//        clearAll();
//        addALL(list);
//
//        isNoData = false;
//        if (list.size() == 1 && list.get(0).isNoData()) {
//            // 暂无数据布局
//            isNoData = list.get(0).isNoData();
//            mHeight = list.get(0).getHeight();
//        } else {
//            // 添加空数据
//            if (list.size() < ONE_SCREEN_COUNT) {
//                addALL(createEmptyList(ONE_SCREEN_COUNT - list.size()));
//            }
//        }
//        notifyDataSetChanged();
//    }
//
//    // 创建不满一屏的空数据
//    public List<TravelingEntity> createEmptyList(int size) {
//        List<TravelingEntity> emptyList = new ArrayList<>();
//        if (size <= 0) return emptyList;
//        for (int i=0; i<size; i++) {
//            emptyList.add(new TravelingEntity());
//        }
//        return emptyList;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        // 暂无数据
//        if (isNoData) {
//            convertView = mInflater.inflate(R.layout.item_no_data_layout, null);
//            AbsListView.LayoutParams params = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, mHeight);
//            RelativeLayout rootView = ButterKnife.findById(convertView, R.id.rl_root_view);
//            rootView.setLayoutParams(params);
//            return convertView;
//        }
//
//        // 正常数据
//        final ViewHolder holder;
//        if (convertView != null && convertView instanceof LinearLayout) {
//            holder = (ViewHolder) convertView.getTag();
//        } else {
//            convertView = mInflater.inflate(R.layout.item_travel, null);
//            holder = new ViewHolder(convertView);
//            convertView.setTag(holder);
//        }
//
//        TravelingEntity entity = getItem(position);
//
//        holder.llRootView.setVisibility(View.VISIBLE);
//        if (TextUtils.isEmpty(entity.getType())) {
//            holder.llRootView.setVisibility(View.INVISIBLE);
//            return convertView;
//        }
//
//        final String title = entity.getFrom() + entity.getTitle() + entity.getType();
//        holder.tvTitle.setText(title);
//        holder.tvRank.setText("Ranking：" + entity.getRank());
//        mImageManager.loadUrlImage(entity.getImage_url(), holder.ivImage);
//
//        convertView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ToastUtil.show(mContext, title);
//            }
//        });
//
//        return convertView;
//    }
//

