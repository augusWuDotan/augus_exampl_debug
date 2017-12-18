package com.wdtpr.augus.debugnetexample.camplay.model.bean.in.dynamic.childBean;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/5.
 */

public class Article implements Serializable {

    /*
           {
               "Bloger_Name": "寶寶溫旅行親子生活",
               "BlogerHeadImg": "https://campimages.blob.core.windows.net/images/Bloger/20170711021710723.jpg",
               "BlogArticle_Title": "露營野餐裝備 | Snow Peak 折疊板凳布椅~好收納、露營野餐都適合 ( LV-071RD)",
               "BlogArticle_Cover": "https://campimages.blob.core.windows.net/images/Article/20170918093710346.jpg",
               "BlogArticle_URL": "http://lulucampback.azurewebsites.net/blog_Article/GetArticleHtml/18137"
             }
            */
    private String Bloger_Name;
    private String BlogerHeadImg;
    private String BlogArticle_Title;
    private String BlogArticle_Cover;
    private String BlogArticle_URL;

    public String getBloger_Name() {
        return Bloger_Name;
    }

    public void setBloger_Name(String bloger_Name) {
        Bloger_Name = bloger_Name;
    }

    public String getBlogerHeadImg() {
        return BlogerHeadImg;
    }

    public void setBlogerHeadImg(String blogerHeadImg) {
        BlogerHeadImg = blogerHeadImg;
    }

    public String getBlogArticle_Title() {
        return BlogArticle_Title;
    }

    public void setBlogArticle_Title(String blogArticle_Title) {
        BlogArticle_Title = blogArticle_Title;
    }

    public String getBlogArticle_Cover() {
        return BlogArticle_Cover;
    }

    public void setBlogArticle_Cover(String blogArticle_Cover) {
        BlogArticle_Cover = blogArticle_Cover;
    }

    public String getBlogArticle_URL() {
        return BlogArticle_URL;
    }

    public void setBlogArticle_URL(String blogArticle_URL) {
        BlogArticle_URL = blogArticle_URL;
    }

    @Override
    public String toString() {
        return "Article{" +
                "Bloger_Name='" + Bloger_Name + '\'' +
                ", BlogerHeadImg='" + BlogerHeadImg + '\'' +
                ", BlogArticle_Title='" + BlogArticle_Title + '\'' +
                ", BlogArticle_Cover='" + BlogArticle_Cover + '\'' +
                ", BlogArticle_URL='" + BlogArticle_URL + '\'' +
                '}';
    }
}
