package com.example.user.kk.bean;

import java.util.List;

/**
 * Created by user on 2016/9/19.
 */
public class Me_Family_Bean {
    public List<FamilyList>familyList;
    public String pathPrefix;         /*拼接网址用的字符串*/

    public class FamilyList{
        public String familyName;       /*线条上面的家族名字*/
        public String familyLeader;      /*家族族长*/
        public String actorCount;        /*家族主播人数*/
        public String memberCount;       /*家族成员*/
        public FamilyPoster familyPoster;   /*里面的每个图片*/

    }
    public class FamilyPoster{
        public String path_222;
    }
}
