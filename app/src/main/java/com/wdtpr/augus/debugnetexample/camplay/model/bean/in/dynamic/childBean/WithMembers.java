package com.wdtpr.augus.debugnetexample.camplay.model.bean.in.dynamic.childBean;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/5.
 * //與誰在一起
 */

public class WithMembers implements Serializable {
    /*
            [
               {
                 "Member_ID": 14,
                 "Member_Name": "邱馬克",
                 "Member_HeadImg": "https://campimages.blob.core.windows.net/images/member/20171003120546053.jpg"
               }
             ]
            */
    private String Member_ID;
    private String Member_Name;
    private String Member_HeadImg; //img avatar url

    public String getMember_ID() {
        return Member_ID;
    }

    public void setMember_ID(String member_ID) {
        Member_ID = member_ID;
    }

    public String getMember_Name() {
        return Member_Name;
    }

    public void setMember_Name(String member_Name) {
        Member_Name = member_Name;
    }

    public String getMember_HeadImg() {
        return Member_HeadImg;
    }

    public void setMember_HeadImg(String member_HeadImg) {
        Member_HeadImg = member_HeadImg;
    }

    @Override
    public String toString() {
        return "WithMembers{" +
                "Member_ID='" + Member_ID + '\'' +
                ", Member_Name='" + Member_Name + '\'' +
                ", Member_HeadImg='" + Member_HeadImg + '\'' +
                '}';
    }
}
