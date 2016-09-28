package com.example.user.kk.bean;

import java.util.List;

/**
 * Created by user on 2016/9/19.
 */
public class DynamicAttentionBean {
    public String mediaPathPrefix;
    public String pathPrefix;
    public String videoPathPrefix;
    public List<NewsList> newsList;


    public class NewsList {
        public String content;
        public String gender;
        public String isLive;
        public String newsId;
        public String newsType;
        public String nickname;
        public String portrait_path_128;
        public String portrait_path_48;
        public String publishedTime;
        public String richLevel;
        public String roomSource;
        public String screenType;
        public String topic;
        public String topicId;
        public String userId;
        public List<CommentList> commentList;
        public List<PicArray> picArray;

    }
    public class CommentList{
        public String commentId;
        public String commentTime;
        public String content;
        public String isPraise;
        public String newsId;
        public String platform;
        public String praiseNum;
        public String userId;
    }

    public class PicArray {
        public String imageUrl_128;
        public String imageUrl_1280;
        public String imageUrl_272;
        public String imageUrl_400;
        public String imageUrl_720;
        public String mediaType;
    }
}
