package com.wdtpr.augus.debugnetexample.camplay.api;

import com.wdtpr.augus.debugnetexample.camplay.model.bean.in.ServerToken;
import com.wdtpr.augus.debugnetexample.camplay.model.bean.in.bloger.Bloger;
import com.wdtpr.augus.debugnetexample.camplay.model.bean.in.dynamic.GraffitiDynamic_;
import com.wdtpr.augus.debugnetexample.camplay.model.bean.in.dynamic.GraffitiDynamic_ob;
import com.wdtpr.augus.debugnetexample.camplay.model.bean.in.order.OrderCallBack;
import com.wdtpr.augus.debugnetexample.camplay.model.bean.in.order.ProductOrderBean;

import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Ray on 2017/8/14.
 * Api
 */

public interface Api {

    @FormUrlEncoded
    @POST("api/Article/ServerAccess")
    Flowable<ServerToken> getServerToken(@Field("s_ServerAccount") String account, @Field("s_ServerAccountPassword") String password);
//
//    @POST("api/Member/GetShareText")
//    Flowable<Status> getShareText(@Header("server_token") String token);
//
//    @POST("api/Article/GetAllAreas")
//    Flowable<Area> getAreas(@Header("server_token") String token);
//
//    @POST("api/Article/GetAllArticle")
//    Flowable<Article> getArticles(@Header("server_token") String token);
//
//    // use for notification
//    @FormUrlEncoded
//    @POST("api/Article/GetSingleArticle")
//    Flowable<ArticleNotification> getNotificationArticle(@Header("server_token") String token,
//                                                         @Field("Blog_Article_ID") int articleID);
//
//    @FormUrlEncoded
//    @POST("api/Article/GetModifiedArticle")
//    Flowable<ArticleModified> getModifyArticles(@Header("server_token") String token, @Field("LastUpdateTime") String lastUpdate);
//
//    // 更新文章瀏覽次數
//    @FormUrlEncoded
//    @POST("api/Article/ViewArticle")
//    Flowable<Status> updateArticleViewCount(@Header("server_token") String token, @Field("Blog_Article_ID") int blogArticleID,
//                                            @Field("MemberView_ID") int memberViewID, @Field("Member_ID") int memberID,
//                                            @Field("Member_Name") String memberName, @Field("ViewTime") String viewTime);
//
//    @FormUrlEncoded
//    @POST("api/Member/GetNotifyList")
//    Flowable<NotificationBean> getNotificationList(@Header("server_token") String token, @Field("Member_ID") int memberID,
//                                                   @Field("deviceToken") String fcmToken);
//
//    /**
//     * 將FCM tokent register資料庫
//     */
//    @FormUrlEncoded
//    @POST("api/Member/ReSendToken")
//    Flowable<Status> registerFCMToken(@Header("server_token") String token, @Header("Access_Token") String accountToken,
//                                      @Field("Member_ID") int memberID, @Field("deviceToken") String fcmToken, @Field("OS") String os);
//
//    /**
//     * 取得活動資訊
//     */
//    @POST("api/Activity/GetAllActivity")
//    Flowable<ActivityBean> getActivityList(@Header("server_token") String token);
//
//
//    /**
//     * 取得現在開啟中的活動資訊
//     */
//    @POST("api/Activity/GetActiveActivity")
//    Flowable<ActivityBean> getActiveActivity(@Header("server_token") String token);
//
//    /**
//     * 取得分類主題資訊
//     */
//    @POST("api/Activity/GetAllTab")
//    Flowable<Subject> getAllSubjectList(@Header("server_token") String token);
//
//    /**
//     * 取得區域營地
//     */
//    @POST("api/Article/GetAllCampsites")
//    Flowable<Camplay> getAllCamps(@Header("server_token") String token);
//
//    /**
//     * 依據id取得區域營地
//     */
//    @POST("api/Article/GetSingleCampsite")
//    Flowable<Camplay> getSingleCampsite(@Header("server_token") String token, @Field("CampSite_ID") int CampSite_ID);
//
//    /**
//     * Facebook Login and Member Register
//     */
//    @FormUrlEncoded
//    @POST("api/Member/Register")
//    Flowable<Member> register(@Header("server_token") String token, @Field("Member_Account") String account,
//                              @Field("Member_Name") String name, @Field("facebookID") String facebookID,
//                              @Field("deviceToken") String fcmToken, @Field("Friends") List<String> firends,
//                              @Field("OS") String os, @Field("HeadImg") String headImg, @Field("CoverImg") String coverImg);
//
//    /**
//     * Member Login if accountToken expired
//     */
//    @FormUrlEncoded
//    @POST("api/Member/Register")
//    Flowable<Member> login(@Header("server_token") String token, @Field("Member_Account") String account,
//                           @Field("Member_Name") String name, @Field("facebookID") String facebookID);
//
    @FormUrlEncoded
    @POST("api/Member/GetAllBloger")
    Flowable<Bloger> getAllBloger(@Header("server_token") String token, @Header("Access_Token") String accountToken,
                                  @Field("Member_ID") int memberID);

//    @FormUrlEncoded
//    @POST("api/Member/AddMemberTraceBloger")
//    Flowable<Status> addTraceBloger(@Header("server_token") String token, @Header("Access_Token") String accountToken,
//                                    @Field("Member_ID") int memberID, @Field("Bloger_ID") int blogerID);
//
//    @FormUrlEncoded
//    @POST("api/Member/CancelMemberTraceBloger")
//    Flowable<Status> cancelTraceBloger(@Header("server_token") String token, @Header("Access_Token") String accountToken,
//                                       @Field("Member_ID") int memberID, @Field("Bloger_ID") int blogerID);
//
//    // 追蹤好友
//    @FormUrlEncoded
//    @POST("api/Member/GetTraceFriends")
//    Flowable<Friend> getTraceFriends(@Header("server_token") String token, @Header("Access_Token") String accountToken,
//                                     @Field("Member_ID") int memberID, @Field("Friends") List<String> firends);
//
//    @FormUrlEncoded
//    @POST("api/Member/AddMemberTraceDetail")
//    Flowable<Status> addTraceFriend(@Header("server_token") String token, @Header("Access_Token") String accountToken,
//                                    @Field("Member_ID") int memberID, @Field("Trace_ID") int friendID);
//
//    @FormUrlEncoded
//    @POST("api/Member/CancelMemberTraceDetail")
//    Flowable<Status> cancelTraceFriend(@Header("server_token") String token, @Header("Access_Token") String accountToken,
//                                       @Field("Member_ID") int memberID, @Field("Trace_ID") int friendID);
//
//    @FormUrlEncoded
//    @POST("api/Article/GetComment")
//    Flowable<Comment> getComment(@Header("server_token") String token, @Header("Access_Token") String accountToken,
//                                 @Field("Member_ID") int memberID, @Field("Article_ID") String blogArticleID);
//
//
//    @FormUrlEncoded
//    @POST("api/Article/AddComment")
//    Flowable<Status> addComment(@Header("server_token") String token, @Header("Access_Token") String accountToken,
//                                @Field("Blog_Article_ID") int blogArticleID, @Field("MemberComment_ID") int memberCommentID,
//                                @Field("Member_ID") int memberID, @Field("Member_Name") String memberName,
//                                @Field("CommentContent") String commentContent, @Field("CommentImage") String commentImg,
//                                @Field("CommentStars") int commentStars, @Field("CommentTime") String commentTime,
//                                @Field("Arr_CommentImage") String arrCommentImg);
//
//    @FormUrlEncoded
//    @POST("api/Article/GetCampSiteComment")
//    Flowable<CommentCamp> getCampSiteComment(@Header("server_token") String token, @Header("Access_Token") String accountToken,
//                                             @Field("Member_ID") int memberID, @Field("CampSite_ID") String campsiteID);
//
//    @FormUrlEncoded
//    @POST("api/Article/AddCampSiteComment")
//    Flowable<Status> addCampComment(@Header("server_token") String token, @Header("Access_Token") String accountToken,
//                                    @Field("CampSite_ID") int campsiteID, @Field("MemberComment_ID") int memberCommentID,
//                                    @Field("Member_ID") int memberID, @Field("Member_Name") String menberName,
//                                    @Field("CommentContent") String commentContent, @Field("CommentImage") String commentImg,
//                                    @Field("CommentStars") int commentStars, @Field("CommentTime") String commentTime,
//                                    @Field("Arr_CommentImage") String arrCommentImg);
//
//    // 新增或移除推薦
//    @FormUrlEncoded
//    @POST("api/Article/RecommendArticle")
//    Flowable<Status> editRecommend(@Header("server_token") String token, @Header("Access_Token") String accountToken,
//                                   @Field("Member_ID") int memberID, @Field("Article_ID") int articleID,
//                                   @Field("Reason") String reason);
//
//    // 新增或移除收藏
//    @FormUrlEncoded
//    @POST("api/Article/KeepArticle")
//    Flowable<Status> editKeep(@Header("server_token") String token, @Header("Access_Token") String accountToken,
//                              @Field("Member_ID") int memberID, @Field("Article_ID") int articleID,
//                              @Field("Reason") String reason);
//
//
//    //----------------------------- augus
//
//
    //動態 - 讀取動態
    //動態 - 推薦
    @FormUrlEncoded
    @POST("/api/ActiveMessage/GetActiveMessage")
    Flowable<GraffitiDynamic_> GetActiveMessage(@Header("server_token") String token, @Header("Access_Token") String accountToken,
                                                @Field("Member_ID") int Member_ID, @Field("PageNum") int PageNum);

    //動態 - 讀取動態
    //動態 - 推薦
    @FormUrlEncoded
    @POST("/api/ActiveMessage/GetActiveMessageNew")
    Flowable<GraffitiDynamic_> GetActiveMessage1(@Header("server_token") String token, @Header("Access_Token") String accountToken,
                                                @Field("Member_ID") int Member_ID, @Field("PageNum") int PageNum);

//    //動態 - 讀取動態
//    //動態 - 藉由部落客id讀取動態資訊
    @FormUrlEncoded
    @POST("/api/ActiveMessage/GetActiveMessageByBloger")
    Flowable<GraffitiDynamic_> GetActiveMessageByBloger(@Header("server_token") String token, @Header("Access_Token") String accountToken,
                                                        @Field("Member_ID") int Member_ID, @Field("PageNum") int PageNum, @Field("Bloger_ID") int Bloger_ID);
//
//    //動態 - 讀取動態
//    //動態 - 藉由動態編號讀取單筆資訊
    @FormUrlEncoded
    @POST("api/ActiveMessage/GetActiveMessageByActiveID")
    Flowable<GraffitiDynamic_ob> GetActiveMessageByActiveID(@Header("server_token") String token, @Header("Access_Token") String accountToken,
                                                            @Field("Member_ID") int Member_ID, @Field("Active_ID") int Active_ID);
//
//
//    //動態 - 推薦
//    @FormUrlEncoded
//    @POST("/api/ActiveMessage/RecommendActive")
//    Flowable<Status> DynamicRecommendActive(@Header("server_token") String token, @Header("Access_Token") String accountToken,
//                                            @Field("Member_ID") int Member_ID, @Field("ActiveMessage_ID") int ActiveMessage_ID);
//
//    //動態 - 留言
//    @FormUrlEncoded
//    @POST("/api/ActiveMessage/AddActiveComment")
//    Flowable<Status> DynamicAddActiveComment(@Header("server_token") String token, @Header("Access_Token") String accountToken,
//                                             @Field("Member_ID") int Member_ID, @Field("ActiveMessage_ID") int ActiveMessage_ID,
//                                             @Field("CommentContent") String CommentContent);
//
//    //動態 - 下載留言列表
//    @FormUrlEncoded
//    @POST("/api/ActiveMessage/GetActiveComment")
//    Flowable<Dynamic_Message> DynamicGetActiveComment(@Header("server_token") String token, @Header("Access_Token") String accountToken,
//                                                      @Field("Member_ID") int Member_ID, @Field("ActiveMessage_ID") int ActiveMessage_ID);
//
//    //
//    @FormUrlEncoded
//    @POST("/api/ActiveMessage/AddActiveMessage")
//    Flowable<Status> AddActiveMessage(@Header("server_token") String token, @Header("Access_Token") String accountToken,
//                                      @Field("ActiveMessageType") int ActiveMessageType, @Field("Member_ID") int Member_ID,
//                                      @Field("CampSite_ID") int CampSite_ID, @Field("CampNum") int CampNum
//            , @Field("ActiveMessage_Content") String ActiveMessage_Content, @Field("ActiveMessage_Location") String ActiveMessage_Location
//            , @Field("CamplayFlag_Name") String CamplayFlag_Name, @Field("CamplayFlag_coordinate") String CamplayFlag_coordinate
//            , @Field("CamplayFlag_Date") String CamplayFlag_Date, @Field("ActiveImages") List<String> ActiveImages
//            , @Field("ActiveMembers") List<Integer> ActiveMembers, @Field("FacebookPostID") String FacebookPostID);
//
//
//    //營地進階搜索 tag
//    @FormUrlEncoded
//    @POST("/api/Article/GetAllCampsiteTags")
//    Flowable<CamplayTagsBean> GetAllCampsiteTags(@Header("server_token") String token, @Header("Access_Token") String accountToken,
//                                                 @Field("City_ID") int City_ID);
//
//
//    //第幾露 地點標註
//    //動態 - 下載留言列表
//    @FormUrlEncoded
//    @POST("/api/ActiveMessage/GetMemberFlags")
//    Flowable<Situation> getMemberFlags(@Header("server_token") String token, @Header("Access_Token") String accountToken,
//                                       @Field("Member_ID") int Member_ID);
//
//    //第幾露 營本部資訊
//    @FormUrlEncoded
//    @POST("/api/Member/GetCampBaseData")
//    Flowable<CampBaseData> GetCampBaseData(@Header("server_token") String token, @Header("Access_Token") String accountToken,
//                                           @Field("Member_ID") int Member_ID);
//
//
//    //member point 總露點
//    @FormUrlEncoded
//    @POST("/api/Member/GetMemberPoints")
//    Flowable<MemberPoint> GetMemberPoints(@Header("server_token") String token, @Header("Access_Token") String accountToken,
//                                          @Field("Member_ID") int Member_ID);
//
//    //point list 會員點數列表
//    @FormUrlEncoded
//    @POST("/api/Member/GetPointList")
//    Flowable<PointBean> GetPointList(@Header("server_token") String token, @Header("Access_Token") String accountToken,
//                                     @Field("Member_ID") int Member_ID, @Field("PageNum") int PageNum);
//
//
//    //product  商品列表 //
//    @FormUrlEncoded
//    @POST("/api/Product/GetProductList")
//    Flowable<ProductBean> GetProductList(@Header("server_token") String token, @Header("Access_Token") String accountToken,
//                                         @Field("ProductClass_ID") String ProductClass_ID);
//
//    //product  商品詳細資訊 //
//    @FormUrlEncoded
//    @POST("/api/Product/GetSingleProduct")
//    Flowable<ProductItemBean> GetSingleProduct(@Header("server_token") String token, @Header("Access_Token") String accountToken,
//                                               @Field("Product_ID") int Product_ID);
//
//    //product  商品種類列表
//    @FormUrlEncoded
//    @POST("/api/Product/GetProductClassList")
//    Flowable<ProductTypeBean> GetProductClassList(@Header("server_token") String token, @Header("Access_Token") String accountToken);
//

//
    //product  新增訂單
    @POST("/api/Product/AddOrder")
    Flowable<OrderCallBack> AddOrder(@Header("server_token") String token, @Header("Access_Token") String accountToken, @Body ProductOrderBean bean);
//
//    //order 訂單列表
//    @FormUrlEncoded
//    @POST("/api/Product/GetMemberOrders")
//    Flowable<Order> GetMemberOrders(@Header("server_token") String token, @Header("Access_Token") String accountToken,
//                                    @Field("Member_ID") int Member_ID);
//
//    //order 訂單詳細內容
//    @FormUrlEncoded
//    @POST("/api/Product/GetMemberSingleOrder")
//    Flowable<OrderDetail> GetMemberSingleOrder(@Header("server_token") String token, @Header("Access_Token") String accountToken,
//                                               @Field("Order_ID") int Order_ID);
//
//    //api/AppToturial/GetAppToturialList
//
//    //教學內容api
//    @FormUrlEncoded
//    @POST("api/AppToturial/GetAppToturialList")
//    Flowable<ToturialList> GetAppToturialList(@Header("server_token") String token, @Field("OsType") boolean OsType, @Field("version") String version);
}
