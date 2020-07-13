package wjc.ivan.oschina.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by 龙心诚 on 2018/6/28 0028.
 */

public class User {
//    uid>3895708</uid>
//    <location><![CDATA[广东 深圳]]></location>
//     <name><![CDATA[wjcIvan]]></name>
//    <followers>0</followers>
//     <fans>0</fans>
//     <score>0</score>
//     <portrait></portrait>
//      <favoritecount>0</favoritecount>
//      <gender>1</gender>
    @XStreamAlias("uid")
    public String uid;
    @XStreamAlias("location")
    public String location;
    @XStreamAlias("name")
    public String name;
    @XStreamAlias("followers")
    public String followers;
    @XStreamAlias("fans")
    public String fans;
    @XStreamAlias("score")
    public String  score;
    @XStreamAlias("portrait")
    public String portrait;
    @XStreamAlias("favoritecount")
    public String  favoritecount;
    @XStreamAlias("gender")
    public String gender;
}
