package com.example.user.kk.bean;

import java.util.List;

/**
 * Created by user on 2016/9/13.
 */
public class Live_year_item_bean {
   public List<RoomList> roomList;
    public String pathPrefix;

    public class RoomList{
        public String nickname;
        public String roomTheme;
        public String liveStream;
        public String poster_path_original;
        public String onlineCount;
        public Integer liveType;
        public String poster_path_756;

    }


}
