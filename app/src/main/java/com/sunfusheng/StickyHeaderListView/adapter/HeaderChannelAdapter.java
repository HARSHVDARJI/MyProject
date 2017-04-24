package com.sunfusheng.StickyHeaderListView.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sunfusheng.StickyHeaderListView.R;
import com.sunfusheng.StickyHeaderListView.model.ChannelEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sunfusheng on 16/4/20.
 */
public class HeaderChannelAdapter extends BaseListAdapter<ChannelEntity> {

    private List<ChannelEntity> list;

    public HeaderChannelAdapter(Context context, List<ChannelEntity> list) {
        super(context, list);
        this.list = list;
        Log.d("myapp", "const");
    }

    @Override
    public int getCount() {
        Log.d("myapp", "count "+list.size());
        return list.size();
    }

    @Override
    public ChannelEntity getItem(int position) {
        Log.d("myapp", "item "+list.get(position));
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        Log.d("myapp", "item "+position);
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_channel, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        ChannelEntity entity = list.get(position);
        if (entity == null){
            Log.d("myapp","entity null");
        } else{
            Log.d("myapp","entity not null");
        }
        assert entity != null;
        holder.tvTitle.setText(entity.getCat_name());
//        mImageManager.loadResImage(entity.getImage(), holder.ivImage);
        holder.ivImage.setImageResource(entity.getImg());
        Log.d("myapp",""+entity.getCat_name());
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.iv_image)
        ImageView ivImage;
        @BindView(R.id.tv_title)
        TextView tvTitle;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
