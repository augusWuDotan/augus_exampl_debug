package com.wdtpr.augus.ranking.model.bean.in.ranking;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2018/1/25.
 */

public class Rank_all implements Serializable {
    /*
  {
    "result_status": true,
    "result_message": "100",
    "result_content": [
        {
            "Ranking": 4,
            "Student_Name": "徐英杰",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "金华市美华分校",
            "Class_Name": "Boston"
        },
        {
            "Ranking": 4,
            "Student_Name": "陈子俊",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "金华市美华分校",
            "Class_Name": "Boston"
        },
        {
            "Ranking": 4,
            "Student_Name": "盛天晨",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "金华市美华分校",
            "Class_Name": "Boston"
        },
        {
            "Ranking": 4,
            "Student_Name": "贾景雅",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "金华市美华分校",
            "Class_Name": "Hawaii"
        },
        {
            "Ranking": 4,
            "Student_Name": "苏子睿",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "金华市美华分校",
            "Class_Name": "Denver"
        },
        {
            "Ranking": 4,
            "Student_Name": "李佳颖",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "金华市美华分校",
            "Class_Name": "Denver"
        },
        {
            "Ranking": 4,
            "Student_Name": "余思萱",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "金华市美华分校",
            "Class_Name": "Hawaii"
        },
        {
            "Ranking": 4,
            "Student_Name": "项晨曦",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "金华市美华分校",
            "Class_Name": "Denver"
        },
        {
            "Ranking": 4,
            "Student_Name": "金佳琪",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "金华市美华分校",
            "Class_Name": "Denver"
        },
        {
            "Ranking": 4,
            "Student_Name": "江和琦",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "金华市美华分校",
            "Class_Name": "Seattle"
        },
        {
            "Ranking": 4,
            "Student_Name": "王子玉",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江浦江分校",
            "Class_Name": "E1-1"
        },
        {
            "Ranking": 4,
            "Student_Name": "张力中",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江浦江分校",
            "Class_Name": "E1-1"
        },
        {
            "Ranking": 4,
            "Student_Name": "盛琳杉",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江浦江分校",
            "Class_Name": "E1-1"
        },
        {
            "Ranking": 4,
            "Student_Name": "芮晟翔",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江浦江分校",
            "Class_Name": "C1-1"
        },
        {
            "Ranking": 4,
            "Student_Name": "金川楠",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江浦江分校",
            "Class_Name": "E1-1"
        },
        {
            "Ranking": 4,
            "Student_Name": "张湘隆",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江浦江分校",
            "Class_Name": "E1-1"
        },
        {
            "Ranking": 4,
            "Student_Name": "石之锴",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江浦江分校",
            "Class_Name": "E1-1"
        },
        {
            "Ranking": 4,
            "Student_Name": "季俊睿",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江浦江分校",
            "Class_Name": "E1-1"
        },
        {
            "Ranking": 4,
            "Student_Name": "张锦浩",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江浦江分校",
            "Class_Name": "D1-1"
        },
        {
            "Ranking": 4,
            "Student_Name": "颜君诺",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "Blair BJ3(9)班"
        },
        {
            "Ranking": 4,
            "Student_Name": "姚俊豪",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "Blair BJ3(9)班"
        },
        {
            "Ranking": 4,
            "Student_Name": "宋佳璇",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "Blair BJ3(9)班"
        },
        {
            "Ranking": 4,
            "Student_Name": "陆景科",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "Blair BJ3(9)班"
        },
        {
            "Ranking": 4,
            "Student_Name": "白嘉沐",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "Blair BJ3(9)班"
        },
        {
            "Ranking": 4,
            "Student_Name": "鲍梓沫",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "Blair BJ3(9)班"
        },
        {
            "Ranking": 4,
            "Student_Name": "吴佳乐",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "IvyBJ3(7)班"
        },
        {
            "Ranking": 4,
            "Student_Name": "杨朝生",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "IvyBJ3(7)班"
        },
        {
            "Ranking": 4,
            "Student_Name": "黄子涵",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "IvyBJ3(7)班"
        },
        {
            "Ranking": 4,
            "Student_Name": "兰凝",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "ShirleyBJ3级周六下午"
        },
        {
            "Ranking": 4,
            "Student_Name": "崔丹婷",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "ShirleyBJ3级周六下午"
        },
        {
            "Ranking": 4,
            "Student_Name": "项昱欣",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "IvyBJ3(7)班"
        },
        {
            "Ranking": 4,
            "Student_Name": "童千芷",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "IvyBJ3(7)班"
        },
        {
            "Ranking": 4,
            "Student_Name": "刘昕睿",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "IvyBJ3(7)班"
        },
        {
            "Ranking": 4,
            "Student_Name": "姜奇贝",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "IvyBJ3(7)班"
        },
        {
            "Ranking": 4,
            "Student_Name": "林科宏",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "ShirleyBJ3级周六下午"
        },
        {
            "Ranking": 4,
            "Student_Name": "朱楚格",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "IvyBJ3(7)班"
        },
        {
            "Ranking": 4,
            "Student_Name": "章迈",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "IvyBJ3(7)班"
        },
        {
            "Ranking": 4,
            "Student_Name": "朱奕达",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "ShirleyBJ3级周六下午"
        },
        {
            "Ranking": 4,
            "Student_Name": "何依函",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "IvyBJ3(7)班"
        },
        {
            "Ranking": 4,
            "Student_Name": "欧阳罗赫",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "IvyBJ3(7)班"
        },
        {
            "Ranking": 4,
            "Student_Name": "陈泽菡",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "IvyBJ3(7)班"
        },
        {
            "Ranking": 4,
            "Student_Name": "吴楷歌",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "IvyBJ3(7)班"
        },
        {
            "Ranking": 4,
            "Student_Name": "方俊杰",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "ShirleyBJ3级周六下午"
        },
        {
            "Ranking": 4,
            "Student_Name": "徐铭阳",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "ShirleyBJ3级周六下午"
        },
        {
            "Ranking": 4,
            "Student_Name": "祝铭远",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "ShirleyBJ3级周六下午"
        },
        {
            "Ranking": 4,
            "Student_Name": "吴念恩",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "ShirleyBJ3级周六下午"
        },
        {
            "Ranking": 4,
            "Student_Name": "曾馨瑶",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "ShirleyBJ3级周六下午"
        },
        {
            "Ranking": 4,
            "Student_Name": "汪小雅",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "ShirleyBJ3级周六下午"
        },
        {
            "Ranking": 4,
            "Student_Name": "祝恺泽",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "ShirleyBJ3级周六下午"
        },
        {
            "Ranking": 4,
            "Student_Name": "陈筱晗",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "ShirleyBJ3级周六下午"
        },
        {
            "Ranking": 4,
            "Student_Name": "潘潘妮",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "ShirleyBJ3级周六下午"
        },
        {
            "Ranking": 4,
            "Student_Name": "许宸恺",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "ShirleyBJ3级周六下午"
        },
        {
            "Ranking": 4,
            "Student_Name": "刘灵智",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "Emily BJ3+ShortE班"
        },
        {
            "Ranking": 4,
            "Student_Name": "吴俊辰",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "Emily BJ3+ShortE班"
        },
        {
            "Ranking": 4,
            "Student_Name": "童一诺",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "Emily BJ3+ShortE班"
        },
        {
            "Ranking": 4,
            "Student_Name": "孙顺怡",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "Blair BJ3(9)班"
        },
        {
            "Ranking": 4,
            "Student_Name": "廖惟依",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "Blair BJ3(9)班"
        },
        {
            "Ranking": 4,
            "Student_Name": "李欣润",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "Emily BJ3+ShortE班"
        },
        {
            "Ranking": 4,
            "Student_Name": "刘雨婷",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "Emily BJ3+ShortE班"
        },
        {
            "Ranking": 4,
            "Student_Name": "唐欣怡",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "Emily BJ3+ShortE班"
        },
        {
            "Ranking": 4,
            "Student_Name": "徐晨飞",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "Emily BJ3+ShortE班"
        },
        {
            "Ranking": 4,
            "Student_Name": "范佳乐",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "Emily BJ3+ShortE班"
        },
        {
            "Ranking": 4,
            "Student_Name": "林珈羽",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "Emily BJ3+ShortE班"
        },
        {
            "Ranking": 4,
            "Student_Name": "叶奕成",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "Emily BJ3+ShortE班"
        },
        {
            "Ranking": 4,
            "Student_Name": "傅煜宸",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "Emily BJ3+ShortE班"
        },
        {
            "Ranking": 4,
            "Student_Name": "夏潘越",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "Emily BJ3+ShortE班"
        },
        {
            "Ranking": 4,
            "Student_Name": "郭思羽",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "Emily BJ3+ShortE班"
        },
        {
            "Ranking": 4,
            "Student_Name": "范丞轩",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "Emily BJ3+ShortE班"
        },
        {
            "Ranking": 4,
            "Student_Name": "孙珺豪",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "Emily BJ3+ShortE班"
        },
        {
            "Ranking": 4,
            "Student_Name": "邵薪颐",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "浙江建德分校",
            "Class_Name": "Emily BJ3+ShortE班"
        },
        {
            "Ranking": 4,
            "Student_Name": "吴俊成",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "东阳分校",
            "Class_Name": "Cassie图书馆BJ4B"
        },
        {
            "Ranking": 4,
            "Student_Name": "吴晨帆",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "东阳分校",
            "Class_Name": "Cassie图书馆BJ4B"
        },
        {
            "Ranking": 4,
            "Student_Name": "吴铭轩",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "东阳分校",
            "Class_Name": "Kinno儿童公园BJ3A"
        },
        {
            "Ranking": 4,
            "Student_Name": "杜川",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "东阳分校",
            "Class_Name": "Amy图书馆BJ4C"
        },
        {
            "Ranking": 4,
            "Student_Name": "张宇呈",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "东阳分校",
            "Class_Name": "Cassie图书馆BJ4B"
        },
        {
            "Ranking": 4,
            "Student_Name": "龚邵俊",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "东方外语培训学",
            "Class_Name": "Saturday 2017年秋爱美语4--Sunny(3)"
        },
        {
            "Ranking": 4,
            "Student_Name": "朱家铖",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "东方外语培训学",
            "Class_Name": "Saturday 2017年秋爱美语4--Sunny(3)"
        },
        {
            "Ranking": 4,
            "Student_Name": "孙一超",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "东方外语培训学",
            "Class_Name": "Saturday 2017年秋爱美语4--Sunny(3)"
        },
        {
            "Ranking": 4,
            "Student_Name": "吴安哲",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "东阳分校",
            "Class_Name": "Sally儿童公园BJ 3B"
        },
        {
            "Ranking": 4,
            "Student_Name": "郭惠茜",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "东阳分校",
            "Class_Name": "Mickey儿童公园BJ4A"
        },
        {
            "Ranking": 4,
            "Student_Name": "麻晨曦",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "东阳分校",
            "Class_Name": "Mickey儿童公园BJ4A"
        },
        {
            "Ranking": 4,
            "Student_Name": "张庚浩",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "东阳分校",
            "Class_Name": "Sally儿童公园BJ 3B"
        },
        {
            "Ranking": 4,
            "Student_Name": "卢俊泰",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "东阳分校",
            "Class_Name": "Mickey儿童公园BJ4A"
        },
        {
            "Ranking": 4,
            "Student_Name": "陈潘翔",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "东阳分校",
            "Class_Name": "Sally儿童公园BJ 3B"
        },
        {
            "Ranking": 4,
            "Student_Name": "郭寒韬",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "东阳分校",
            "Class_Name": "Sally儿童公园BJ 3B"
        },
        {
            "Ranking": 4,
            "Student_Name": "赵睿涵",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "东阳分校",
            "Class_Name": "Mickey儿童公园BJ4A"
        },
        {
            "Ranking": 4,
            "Student_Name": "黄申浩",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "东阳分校",
            "Class_Name": "Mickey儿童公园BJ4A"
        },
        {
            "Ranking": 4,
            "Student_Name": "刘彦孜",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "东方外语培训学",
            "Class_Name": "Saturday 2017年秋爱美语4--Sunny(3)"
        },
        {
            "Ranking": 4,
            "Student_Name": "赵宇涵",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "东方外语培训学",
            "Class_Name": "Saturday 2017年秋爱美语4--Sunny(3)"
        },
        {
            "Ranking": 4,
            "Student_Name": "赵妍",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "东方外语培训学",
            "Class_Name": "Saturday 2017年秋爱美语4--Sunny(3)"
        },
        {
            "Ranking": 4,
            "Student_Name": "王禾琪",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "东方外语培训学",
            "Class_Name": "Saturday（1） 2017秋爱美语4---Sunny"
        },
        {
            "Ranking": 4,
            "Student_Name": "张祎",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "东方外语培训学",
            "Class_Name": "Saturday 2017年秋爱美语4--Sunny(3)"
        },
        {
            "Ranking": 4,
            "Student_Name": "丁鑫",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "东方外语培训学",
            "Class_Name": "2017秋周六爱6(15:20-17:20)--Sandy"
        },
        {
            "Ranking": 4,
            "Student_Name": "钱怡彤",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "东方外语培训学",
            "Class_Name": "2017秋周六爱6(15:20-17:20)--Sandy"
        },
        {
            "Ranking": 4,
            "Student_Name": "陈立威",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "东方外语培训学",
            "Class_Name": "2017秋周日爱4（7：50-9：50）--Sandy"
        },
        {
            "Ranking": 4,
            "Student_Name": "季岚轩",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "东方外语培训学",
            "Class_Name": "2017秋周日爱4（7：50-9：50）--Sandy"
        },
        {
            "Ranking": 4,
            "Student_Name": "成佳峰",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "东方外语培训学",
            "Class_Name": "2017秋周日爱4（7：50-9：50）--Sandy"
        },
        {
            "Ranking": 4,
            "Student_Name": "王昱杰",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "东方外语培训学",
            "Class_Name": "2017秋周日爱4（7：50-9：50）--Sandy"
        },
        {
            "Ranking": 4,
            "Student_Name": "郝靓",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "东方外语培训学",
            "Class_Name": "2017秋周日爱4（7：50-9：50）--Sandy"
        },
        {
            "Ranking": 4,
            "Student_Name": "郑子聪",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "东方外语培训学",
            "Class_Name": "暑二上午爱美语6--Annie"
        }
    ]
}
     */

    private Boolean result_status;
    private String result_message;
    private List<RankingItem> result_content;

    @Override
    public String toString() {
        return "ranking{" +
                "result_status=" + result_status +
                ", result_message='" + result_message + '\'' +
                ", result_content=" + result_content +
                '}';
    }

    public Boolean getResult_status() {
        return result_status;
    }

    public void setResult_status(Boolean result_status) {
        this.result_status = result_status;
    }

    public String getResult_message() {
        return result_message;
    }

    public void setResult_message(String result_message) {
        this.result_message = result_message;
    }

    public List<RankingItem> getResult_content() {
        return result_content;
    }

    public void setResult_content(List<RankingItem> result_content) {
        this.result_content = result_content;
    }
}
