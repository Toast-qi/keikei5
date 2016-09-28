package com.example.user.kk.bean;

import java.util.List;

/**
 * Created by user on 2016/9/18.
 */
public class DynamicHotTopicBean {
    public List<HotTopicList> hotTopicList;
    public List<HotNewsList> hotNewsList;
    public String mediaPathPrefix;
    public String pathPrefix;
    public String videoPathPrefix;
    public class HotTopicList {
        public String content;
        public String imageUrl;
        public String introduction;
        public String topicId;
    }

    public class HotNewsList {
        public List<CommentList>commentList;
        public String content;
        public String gender;
        public String isFollowed;
        public String isLive;
        public String newsId;
        public String newsType;
        public String portrait_path_256;
        public String publishedTime;
        public String richLevel;
        public String roomSource;
        public String screenType;
        public String topicId;
        public String topic;
        public String userId;
        public String nickname;
        public List<PicArray> picArray;

    }

    public class CommentList {
        public String commentId;
        public String commentTime;
        public String content;
        public String newsId;
        public String platform;
        public String praiseNum;
        public String userId;
        public String portrait_path;


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
