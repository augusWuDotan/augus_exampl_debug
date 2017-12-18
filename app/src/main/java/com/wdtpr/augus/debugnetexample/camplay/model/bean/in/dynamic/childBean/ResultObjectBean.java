package com.wdtpr.augus.debugnetexample.camplay.model.bean.in.dynamic.childBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/5.
 */

public class ResultObjectBean implements Serializable {
//,IItemType
//    public static final int ADS = R.layout.adapter_dynamic_ads_view;
//    public static final int NORMAL = R.layout.adapter_graffiti_dynamic;
         /*
       {
          "ActiveMessage_ID": 228, 動態序號
      "ActiveMessageType_ID": 1, 動態使用版面類型
      "Blog_Article_ID": 18137, 動態內 具有部落客文章id
      "Member_ID": null,  發佈這篇的發佈者「若為系統產生就不會有這個項目」
      "CampSite_ID": null, 動態內 具有營地資料
      "ActiveMessage_Content": null, 動態內 發布的文字內容
      "Activity_ID": null, 動態「官方發佈活動」之id
      "Tab_ID": null, 動態[官方推薦主題]
      "ActiveMessage_Time": "2017-09-18T01:37:00", 動態發布的時間
      "ActiveMessage_Location": null, 動態 「打卡」標注地點的座標
      "Bloger_ID": 82, 動態 [內容具有關聯到部落客 則具有id]
      "MemberComment_ID": null,
      "CampSiteComment_ID": null,
      "CamplayFlag_Name": null, 動態 「插旗才具有營地名稱」
      "CamplayFlag_coordinate": null, 「插旗座標」
      "RecommendArticle_ID": null,
      "RecommendCount": 0, [推薦數量]
      "CommentCount": 0, 「留言數量」
      "IsEnable": false,
      "DidRecommend": false, [是否點擊推薦]
      "CampNum": 0,  [第幾露-插旗]
      "FacebookPostID": "1570347613042416_1628383897238787",
      "member": null, 「由人發布 發布者的詳細資訊」
      "with_members": [], [誰被標註]
      "source_members": [], 「回應、推薦、標注」
      "images": [], [圖示 1 2 3 4 4以上]
      "comment": null, 「評論內容」
      "campsite": null, //
      "tab": null,  [官方推薦活動]
      "activity": null, [活動詳細資訊]
      "article": { 「如果有帶任何文章」
        "Bloger_Name": "寶寶溫旅行親子生活",
        "BlogerHeadImg": "https://campimages.blob.core.windows.net/images/Bloger/20170711021710723.jpg",
        "BlogArticle_Title": "露營野餐裝備 | Snow Peak 折疊板凳布椅~好收納、露營野餐都適合 ( LV-071RD)",
        "BlogArticle_Cover": "https://campimages.blob.core.windows.net/images/Article/20170918093710346.jpg",
        "BlogArticle_URL": "http://lulucampback.azurewebsites.net/blog_Article/GetArticleHtml/18137"
      }
        }
        */

    private int ActiveMessage_ID;//動態序號
    private int ActiveMessageType_ID;//動態使用版面類型
    private int Blog_Article_ID;//動態內 具有部落客文章id
    private int Member_ID;//發佈這篇的發佈者「若為系統產生就不會有這個項目」
    private int CampSite_ID;//動態內 具有營地資料
    private String ActiveMessage_Content;//動態內 發布的文字內容
    private int Activity_ID;//動態「官方發佈活動」之id
    private int Tab_ID;// 動態[官方推薦主題]
    private String ActiveMessage_Time; // time //base
    private String ActiveMessage_Location;//動態 「打卡」標注地點的座標
    private int Bloger_ID;//動態 [內容具有關聯到部落客 則具有id]
    private String MemberComment_ID;//X
    private String CampSiteComment_ID;//X
    private String CamplayFlag_Name;// 動態 「插旗才具有營地名稱」
    private String CamplayFlag_coordinate;//「插旗座標」
    private int RecommendArticle_ID;//X
    private int RecommendCount;//[推薦數量]
    private int CommentCount;//「留言數量」
    private Boolean IsEnable;//X
    private Boolean DidRecommend;//[用戶否點擊推薦]
    private int CampNum;//[第幾露-插旗]
    private String FacebookPostID;//是否有同步fb訊息
    private Member member;//發布者資訊
    private List<WithMembers> with_members;
    private List<SourceMember> source_members;
    private List<String> images;//[圖示 1 2 3 4 4以上]
    private Comment comment;//評論內容
    private String campsite;//Ｘ
    private Tab tab;//[官方推薦活動]
    private Activitys activity; //[活動詳細資訊]
    private Article article; //「如果有帶任何文章」
//    private int itemType; //viewtype
//    private NativeAd ad;

    public int getActiveMessage_ID() {
        return ActiveMessage_ID;
    }

    public void setActiveMessage_ID(int activeMessage_ID) {
        ActiveMessage_ID = activeMessage_ID;
    }

    public int getActiveMessageType_ID() {
        return ActiveMessageType_ID;
    }

    public void setActiveMessageType_ID(int activeMessageType_ID) {
        ActiveMessageType_ID = activeMessageType_ID;
    }

    public int getBlog_Article_ID() {
        return Blog_Article_ID;
    }

    public void setBlog_Article_ID(int blog_Article_ID) {
        Blog_Article_ID = blog_Article_ID;
    }

    public int getMember_ID() {
        return Member_ID;
    }

    public void setMember_ID(int member_ID) {
        Member_ID = member_ID;
    }

    public int getCampSite_ID() {
        return CampSite_ID;
    }

    public void setCampSite_ID(int campSite_ID) {
        CampSite_ID = campSite_ID;
    }

    public String getActiveMessage_Content() {
        return ActiveMessage_Content;
    }

    public void setActiveMessage_Content(String activeMessage_Content) {
        ActiveMessage_Content = activeMessage_Content;
    }

    public int getActivity_ID() {
        return Activity_ID;
    }

    public void setActivity_ID(int activity_ID) {
        Activity_ID = activity_ID;
    }

    public int getTab_ID() {
        return Tab_ID;
    }

    public void setTab_ID(int tab_ID) {
        Tab_ID = tab_ID;
    }

    public String getActiveMessage_Time() {
        return ActiveMessage_Time;
    }

    public void setActiveMessage_Time(String activeMessage_Time) {
        ActiveMessage_Time = activeMessage_Time;
    }

    public String getActiveMessage_Location() {
        return ActiveMessage_Location;
    }

    public void setActiveMessage_Location(String activeMessage_Location) {
        ActiveMessage_Location = activeMessage_Location;
    }

    public int getBloger_ID() {
        return Bloger_ID;
    }

    public void setBloger_ID(int bloger_ID) {
        Bloger_ID = bloger_ID;
    }

    public String getMemberComment_ID() {
        return MemberComment_ID;
    }

    public void setMemberComment_ID(String memberComment_ID) {
        MemberComment_ID = memberComment_ID;
    }

    public String getCampSiteComment_ID() {
        return CampSiteComment_ID;
    }

    public void setCampSiteComment_ID(String campSiteComment_ID) {
        CampSiteComment_ID = campSiteComment_ID;
    }

    public String getCamplayFlag_Name() {
        return CamplayFlag_Name;
    }

    public void setCamplayFlag_Name(String camplayFlag_Name) {
        CamplayFlag_Name = camplayFlag_Name;
    }

    public String getCamplayFlag_coordinate() {
        return CamplayFlag_coordinate;
    }

    public void setCamplayFlag_coordinate(String camplayFlag_coordinate) {
        CamplayFlag_coordinate = camplayFlag_coordinate;
    }

    public int getRecommendArticle_ID() {
        return RecommendArticle_ID;
    }

    public void setRecommendArticle_ID(int recommendArticle_ID) {
        RecommendArticle_ID = recommendArticle_ID;
    }

    public int getRecommendCount() {
        return RecommendCount;
    }

    public void setRecommendCount(int recommendCount) {
        RecommendCount = recommendCount;
    }

    public int getCommentCount() {
        return CommentCount;
    }

    public void setCommentCount(int commentCount) {
        CommentCount = commentCount;
    }

    public Boolean getEnable() {
        return IsEnable;
    }

    public void setEnable(Boolean enable) {
        IsEnable = enable;
    }

    public Boolean getDidRecommend() {
        return DidRecommend;
    }

    public void setDidRecommend(Boolean didRecommend) {
        DidRecommend = didRecommend;
    }

    public int getCampNum() {
        return CampNum;
    }

    public void setCampNum(int campNum) {
        CampNum = campNum;
    }

    public String getFacebookPostID() {
        return FacebookPostID;
    }

    public void setFacebookPostID(String facebookPostID) {
        FacebookPostID = facebookPostID;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<WithMembers> getWith_members() {
        return with_members;
    }

    public void setWith_members(List<WithMembers> with_members) {
        this.with_members = with_members;
    }

    public List<SourceMember> getSource_members() {
        return source_members;
    }

    public void setSource_members(List<SourceMember> source_members) {
        this.source_members = source_members;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public String getCampsite() {
        return campsite;
    }

    public void setCampsite(String campsite) {
        this.campsite = campsite;
    }

    public Tab getTab() {
        return tab;
    }

    public void setTab(Tab tab) {
        this.tab = tab;
    }

    public Activitys getActivity() {
        return activity;
    }

    public void setActivity(Activitys activity) {
        this.activity = activity;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

//    public int getItemType() {
//        return itemType;
//    }
//
//    public void setItemType(int itemType) {
//        this.itemType = itemType;
//    }
////
//    public NativeAd getAd() {
//        return ad;
//    }
//
//    public void setAd(NativeAd ad) {
//        this.ad = ad;
//    }

    @Override
    public String toString() {
        return "ResultObjectBean{" +
                "ActiveMessage_ID=" + ActiveMessage_ID +
                ", ActiveMessageType_ID=" + ActiveMessageType_ID +
                ", Blog_Article_ID=" + Blog_Article_ID +
                ", Member_ID=" + Member_ID +
                ", CampSite_ID=" + CampSite_ID +
                ", ActiveMessage_Content='" + ActiveMessage_Content + '\'' +
                ", Activity_ID=" + Activity_ID +
                ", Tab_ID=" + Tab_ID +
                ", ActiveMessage_Time='" + ActiveMessage_Time + '\'' +
                ", ActiveMessage_Location='" + ActiveMessage_Location + '\'' +
                ", Bloger_ID=" + Bloger_ID +
                ", MemberComment_ID='" + MemberComment_ID + '\'' +
                ", CampSiteComment_ID='" + CampSiteComment_ID + '\'' +
                ", CamplayFlag_Name='" + CamplayFlag_Name + '\'' +
                ", CamplayFlag_coordinate='" + CamplayFlag_coordinate + '\'' +
                ", RecommendArticle_ID=" + RecommendArticle_ID +
                ", RecommendCount=" + RecommendCount +
                ", CommentCount=" + CommentCount +
                ", IsEnable=" + IsEnable +
                ", DidRecommend=" + DidRecommend +
                ", CampNum=" + CampNum +
                ", FacebookPostID='" + FacebookPostID + '\'' +
                ", member=" + member +
                ", with_members=" + with_members +
                ", source_members=" + source_members +
                ", images=" + images +
                ", comment=" + comment +
                ", campsite='" + campsite + '\'' +
                ", tab=" + tab +
                ", activity=" + activity +
                ", article=" + article +
                '}';
    }


//    @Override
//    public int itemType() {
//        return this.itemType == 1001 ? NORMAL :ADS ;
//    }
}
