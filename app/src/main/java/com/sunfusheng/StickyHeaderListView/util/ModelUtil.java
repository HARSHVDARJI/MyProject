package com.sunfusheng.StickyHeaderListView.util;

import com.sunfusheng.StickyHeaderListView.R;
import com.sunfusheng.StickyHeaderListView.model.ChannelEntity;
import com.sunfusheng.StickyHeaderListView.model.FilterEntity;
import com.sunfusheng.StickyHeaderListView.model.FilterTwoEntity;
import com.sunfusheng.StickyHeaderListView.model.TravelingEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 好吧，让你找到了，这是假的数据源
 *
 * Created by sunfusheng on 16/4/22.
 */
@SuppressWarnings("ALL")
public class ModelUtil {

    public static final String type_scenery = "landscape";
    public static final String type_building = "building";
    public static final String type_animal = "animal";
    public static final String type_plant = "plant";

    // 广告数据
    public static List<Integer> getBannerData() {
        List<Integer> adList = new ArrayList<>();
        adList.add(R.drawable.cms);
        adList.add(R.drawable.howto);
        adList.add(R.drawable.lang);
        adList.add(R.drawable.os);
        adList.add(R.drawable.game);
        return adList;
    }


    // 频道数据
    public static List<ChannelEntity> getChannelData() {
        List<ChannelEntity> channelList = new ArrayList<>();
        channelList.add(new ChannelEntity("CMS", R.drawable.cms));
        channelList.add(new ChannelEntity("HOW TO", R.drawable.howto));
        channelList.add(new ChannelEntity("LANGUAGES", R.drawable.lang));
        channelList.add(new ChannelEntity("OS", R.drawable.os));
        channelList.add(new ChannelEntity("SEO", R.drawable.seo));
        channelList.add(new ChannelEntity("GAMES", R.drawable.game));
        return channelList;
    }

    // 运营数据
//    public static List<OperationEntity> getOperationData() {
//        List<OperationEntity> operationList = new ArrayList<>();
//        operationList.add(new OperationEntity("Holiday travel", "Vacation paradise", "http://img2.imgtn.bdimg.com/it/u=4081165325,36916497&fm=21&gp=0.jpg"));
//        operationList.add(new OperationEntity("Honeymoon", "Romantic harbor", "http://img4.imgtn.bdimg.com/it/u=4141168524,78676102&fm=21&gp=0.jpg"));
//        return operationList;
//    }
    static String[] title = new String[]{
            "Keyboard Shortcuts You’ll Ever Need :: GeekSperm",
            "This is title 2 for community app",
            "This is title 3 for community app",
            "This is title 4 for community app",
            "This is title 5 for community app",
            "This is title 6 for community app",
            "This is title 7 for community app",
            "This is title 8 for community app",
            "This is title 9 for community app",
            "This is title 10 for community app"
    };

    static String[] username = new String[]{
            "Harsh Darji",
            "username2",
            "username3",
            "username4",
            "username5",
            "username6",
            "username7",
            "username8",
            "username9",
            "username10"
    };

    static String[] tag = new String[]{"How to", "lang", "cms","seo", "game",
            "os", "lang", "cms","seo", "game" };

    static Integer[] like = new Integer[] {
      12, 15, 25, 36, 25, 26, 54, 86, 25, 75 };

    static Integer[] comments = new Integer[]{
            2, 5, 6, 2, 3, 4, 7, 6, 5, 1
    };

    static Integer [] profile = new Integer[]{ R.drawable.civil,
            R.drawable.comp, R.drawable.ec, R.drawable.electronics,
            R.drawable.general, R.drawable.mechanical, R.drawable.civil,
            R.drawable.comp, R.drawable.ec, R.drawable.electronics };
    // ListView数据
    public static List<TravelingEntity> getTravelingData() {
        List<TravelingEntity> travelingList = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            TravelingEntity item = new TravelingEntity
                    (title[i], username[i], tag[i], profile[i], like[i], comments[i]);
            travelingList.add(item);
        }
        return travelingList;
    }
//        travelingList.add(new TravelingEntity(type_scenery, "Dali", "China", 1, "http://img5.imgtn.bdimg.com/it/u=2769726205,1778838650&fm=21&gp=0.jpg"));
//        travelingList.add(new TravelingEntity(type_scenery, "", "Spain", 20, "http://img1.imgtn.bdimg.com/it/u=1832737924,144748431&fm=21&gp=0.jpg"));
//        travelingList.add(new TravelingEntity(type_scenery, "", "Italy", 21, "http://img5.imgtn.bdimg.com/it/u=2091366266,1524114981&fm=21&gp=0.jpg"));
//        travelingList.add(new TravelingEntity(type_scenery, "arch", "United States", 5, "http://img4.imgtn.bdimg.com/it/u=3673198446,2175517238&fm=206&gp=0.jpg"));
//        travelingList.add(new TravelingEntity(type_plant, "Lotus", "China", 4, "http://img4.imgtn.bdimg.com/it/u=3052089044,3887933556&fm=21&gp=0.jpg"));
//        travelingList.add(new TravelingEntity(type_building, "", "Spain", 18, "http://img2.imgtn.bdimg.com/it/u=140083303,1086773509&fm=21&gp=0.jpg"));
//        travelingList.add(new TravelingEntity(type_scenery, "", "Spain", 19, "http://img5.imgtn.bdimg.com/it/u=1424970962,1243597989&fm=21&gp=0.jpg"));
//        travelingList.add(new TravelingEntity(type_animal, "Mink", "United States", 7, "http://img4.imgtn.bdimg.com/it/u=1387833256,3665925904&fm=21&gp=0.jpg"));
//        travelingList.add(new TravelingEntity(type_plant, "cactus", "United States", 8, "http://img1.imgtn.bdimg.com/it/u=3808801622,1608105009&fm=21&gp=0.jpg"));
//        travelingList.add(new TravelingEntity(type_scenery, "Wales", "United Kingdom", 9, "http://img4.imgtn.bdimg.com/it/u=2440866214,1867472386&fm=21&gp=0.jpg"));
//        travelingList.add(new TravelingEntity(type_building, "Tower Bridgeaaaaaaaaaaaaaaaaaaa", "United Kingdom", 10, "http://img3.imgtn.bdimg.com/it/u=3040385967,1031044866&fm=21&gp=0.jpg"));
//        travelingList.add(new TravelingEntity(type_animal, "", "United Kingdom", 11, "http://img3.imgtn.bdimg.com/it/u=1896821840,3837942977&fm=21&gp=0.jpg"));
//        travelingList.add(new TravelingEntity(type_plant, "", "United Kingdom", 12, "http://img3.imgtn.bdimg.com/it/u=2745651862,279304559&fm=21&gp=0.jpg"));
//        travelingList.add(new TravelingEntity(type_scenery, "", "Germany", 13, "http://img3.imgtn.bdimg.com/it/u=4137420324,1489843447&fm=206&gp=0.jpg"));
//        travelingList.add(new TravelingEntity(type_building, "Statue of Liberty", "United States", 6, "http://img3.imgtn.bdimg.com/it/u=2566161363,1140447270&fm=206&gp=0.jpg"));
//        travelingList.add(new TravelingEntity(type_building, "Lhasa", "China", 2, "http://img1.imgtn.bdimg.com/it/u=372954611,2699392190&fm=21&gp=0.jpg"));
//        travelingList.add(new TravelingEntity(type_animal, "panda", "China", 3, "http://img0.imgtn.bdimg.com/it/u=1022702848,645282860&fm=206&gp=0.jpg"));
//        travelingList.add(new TravelingEntity(type_building, "", "Germany", 14, "http://img1.imgtn.bdimg.com/it/u=3436675019,2609348874&fm=206&gp=0.jpg"));
//        travelingList.add(new TravelingEntity(type_animal, "Bear", "Germany", 15, "http://img4.imgtn.bdimg.com/it/u=4280994062,276434784&fm=21&gp=0.jpg"));
//        travelingList.add(new TravelingEntity(type_plant, "", "Germany", 16, "http://img0.imgtn.bdimg.com/it/u=1644854868,3172549858&fm=21&gp=0.jpg"));
//        travelingList.add(new TravelingEntity(type_scenery, "", "Spain", 17, "http://img4.imgtn.bdimg.com/it/u=620137884,621556624&fm=21&gp=0.jpg"));
//        travelingList.add(new TravelingEntity(type_building, "", "Italy", 22, "http://img0.imgtn.bdimg.com/it/u=3631118072,1530723002&fm=206&gp=0.jpg"));
//        return travelingList;
//    }

    // 分类数据
    public static List<FilterTwoEntity> getCategoryData() {
        List<FilterTwoEntity> list = new ArrayList<>();
        list.add(new FilterTwoEntity(type_scenery, getFilterData()));
        list.add(new FilterTwoEntity(type_building, getFilterData()));
        list.add(new FilterTwoEntity(type_animal, getFilterData()));
        list.add(new FilterTwoEntity(type_plant, getFilterData()));
        return list;
    }

    // 排序数据
    public static List<FilterEntity> getSortData() {
        List<FilterEntity> list = new ArrayList<>();
        list.add(new FilterEntity("Sort from high to low", "1"));
        list.add(new FilterEntity("Sort from low to high", "2"));
        return list;
    }

    // 筛选数据
    public static List<FilterEntity> getFilterData() {
        List<FilterEntity> list = new ArrayList<>();
        list.add(new FilterEntity("China", "1"));
        list.add(new FilterEntity("United States", "2"));
        list.add(new FilterEntity("United Kingdom", "3"));
        list.add(new FilterEntity("Germany", "4"));
        list.add(new FilterEntity("Spain", "5"));
        list.add(new FilterEntity("Italy", "6"));
        return list;
    }

    public static String[] getMenudata() {
        String[] item = new String[]{"My Profile","My Posts","Friends",
                "Groups","Settings","About Us"};
        return item;
    }

    public static String[] getSpinnerdata() {
        String[] item = new String[]{"-SELECT TAG","CMS","HOW TO",
                "OS","SEO","LANGUAGES","GAME"};
        return item;
    }

    // ListView分类数据 ListView classification data
//    public static List<TravelingEntity> getCategoryTravelingData(FilterTwoEntity leftEntity, FilterEntity rightEntity) {
//        List<TravelingEntity> list = getTravelingData();
//        List<TravelingEntity> travelingList = new ArrayList<>();
//        int size = list.size();
//        for (int i=0; i<size; i++) {
//            if (list.get(i).getType().equals(leftEntity.getType()) && list.get(i).getFrom().equals(rightEntity.getKey())) {
//                travelingList.add(list.get(i));
//            }
//        }
//        return travelingList;
//    }

    // ListView排序数据
//    public static List<TravelingEntity> getSortTravelingData(FilterEntity entity) {
//        List<TravelingEntity> list = getTravelingData();
//        Comparator<TravelingEntity> ascComparator = new TravelingEntityComparator();
//        if (entity.getKey().equals("Sort from high to low")) {
//            Collections.sort(list);
//        } else {
//            Collections.sort(list, ascComparator);
//        }
//        return list;
//    }

    // ListView筛选数据
//    public static List<TravelingEntity> getFilterTravelingData(FilterEntity entity) {
//        List<TravelingEntity> list = getTravelingData();
//        List<TravelingEntity> travelingList = new ArrayList<>();
//        int size = list.size();
//        for (int i=0; i<size; i++) {
//            if (list.get(i).getFrom().equals(entity.getKey())) {
//                travelingList.add(list.get(i));
//            }
//        }
//        return travelingList;
//    }

    // 暂无数据 no data
//    public static List<TravelingEntity> getNoDataEntity(int height) {
//        List<TravelingEntity> list = new ArrayList<>();
//        TravelingEntity entity = new TravelingEntity();
//        entity.setNoData(true);
//        entity.setHeight(height);
//        list.add(entity);
//        return list;
//    }

}
