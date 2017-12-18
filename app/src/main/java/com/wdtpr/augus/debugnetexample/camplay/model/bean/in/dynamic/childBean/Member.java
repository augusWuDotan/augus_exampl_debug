package com.wdtpr.augus.debugnetexample.camplay.model.bean.in.dynamic.childBean;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/5.
 * //發布者資訊
 */

public class Member implements Serializable {
     /*
            "member": {
                        "Member_ID": 4695,
                        "Member_Name": "王冠綸",
                        "Member_HeadImg": "https://campimages.blob.core.windows.net/images/member/20171003155034663.jpg"
                      },
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
        return "Member{" +
                "Member_ID='" + Member_ID + '\'' +
                ", Member_Name='" + Member_Name + '\'' +
                ", Member_HeadImg='" + Member_HeadImg + '\'' +
                '}';
    }

    //    public static class memberAdapter extends TypeAdapter<GraffitiDynamic_.ResultObjectBean.member> {
//
//        @Override
//        public void write(JsonWriter out, GraffitiDynamic_.ResultObjectBean.member value) throws IOException {
//            out.beginObject();
//            if (!value.Member_ID.isEmpty()) {
//                out.name("Member_ID").value(value.Member_ID);
//            }
//            if (!value.Member_Name.isEmpty()) {
//                out.name("Member_Name").value(value.Member_Name);
//            }
//            if (!value.Member_HeadImg.isEmpty()) {
//                out.name("Member_HeadImg").value(value.Member_HeadImg);
//            }
//            out.endObject();
//        }
//
//        @Override
//        public GraffitiDynamic_.ResultObjectBean.member read(JsonReader in) throws IOException {
//            if (in.peek() == JsonToken.NULL) {
//                in.nextNull();
//                return new GraffitiDynamic_.ResultObjectBean.member();
//            } else {
//                GraffitiDynamic_.ResultObjectBean.member member = new GraffitiDynamic_.ResultObjectBean.member();
//                in.beginObject();
//                while (in.hasNext()) {
//                    switch (in.nextName()) {
//                        case "Member_ID":
//                            member.Member_ID = in.nextString();
//                            break;
//                        case "Member_Name":
//                            member.Member_Name = in.nextString();
//                            break;
//                        case "Member_HeadImg":
//                            member.Member_HeadImg = in.nextString();
//                            break;
//                    }
//                }
//                in.endObject();
//                return member;
//            }
//        }
//    }
}
