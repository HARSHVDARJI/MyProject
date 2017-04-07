package com.sunfusheng.StickyHeaderListView.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sunfusheng.StickyHeaderListView.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunfusheng on 16/4/20.
 */
public class HeaderBannerAdapter extends PagerAdapter {

    private ArrayList<ImageView> ivList;
    private Context mContext = null;
    LayoutInflater inflater;


    public HeaderBannerAdapter(Context context, List<ImageView> ivList) {
        mContext = context;
        this.ivList = new ArrayList<ImageView>();

        Resources resource = mContext.getResources();
        Bitmap bMap1 = BitmapFactory.decodeResource(resource,
                R.drawable.cms);
        ImageView image1 = new ImageView(mContext);
        image1.setImageBitmap(bMap1);
        this.ivList.add(image1);

        Bitmap bMap2 = BitmapFactory.decodeResource(resource,
                R.drawable.howto);
        ImageView image2 = new ImageView(mContext);
        image2.setImageBitmap(bMap2);
        this.ivList.add(image2);

        Bitmap bMap3 = BitmapFactory.decodeResource(resource,
                R.drawable.lang);
        ImageView image3 = new ImageView(mContext);
        image3.setImageBitmap(bMap3);
        this.ivList.add(image3);

        Bitmap bMap4 = BitmapFactory.decodeResource(resource,
                R.drawable.os);
        ImageView image4 = new ImageView(mContext);
        image3.setImageBitmap(bMap4);
        this.ivList.add(image4);

        Bitmap bMap5 = BitmapFactory.decodeResource(resource,
                R.drawable.game);
        ImageView image5 = new ImageView(mContext);
        image5.setImageBitmap(bMap5);
        this.ivList.add(image5);
    }
//    private List<ImageView> ivList; // ImageView的集合
//    private int count = 1; // 广告的数量

//    public HeaderBannerAdapter(Context context, List<ImageView> ivList) {
//        super();
//        this.ivList = ivList;
//        if(ivList != null && ivList.size() > 0){
//            count = ivList.size();
//        }
//    }

//    @Override
//    public int getCount() {
//        if (count == 1) {
//            return 1;
//        } else {
//            return Integer.MAX_VALUE;
//        }
//    }

//    @Override
//    public boolean isViewFromObject(View arg0, Object arg1) {
//        return arg0 == arg1;
//    }

//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//    }

    @Override
    public int getCount() {
        return ivList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.swipe,container,false);
        ImageView img =(ImageView)v.findViewById(R.id.imageView);
//        TextView tv  = (TextView)v.findViewById(R.id.textView);
        img = ivList.get(position);
//        tv.setText("Image :"+position);
//        container.addView(v);
        ((ViewPager) container).removeView(img);
        ((ViewPager) container).addView(img);
        return img;
    }

    @Override
    public void destroyItem(View container, int position, Object object) {
//        container.refreshDrawableState();
//        ((ViewPager) container).removeView((LinearLayout) object);
    }

//    @Override
//    public Object instantiateItem(ViewGroup container, int position) {
//        int newPosition = position % count;
//        // 先移除在添加，更新图片在container中的位置（把iv放至container末尾）
//        ImageView iv = ivList.get(newPosition);
//        container.removeView(iv);
//        container.addView(iv);
//        return iv;
//    }
}
