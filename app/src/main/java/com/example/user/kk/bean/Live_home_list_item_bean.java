package com.example.user.kk.bean;

import java.util.List;

/**
 * Created by user on 2016/9/22.
 */
public class Live_home_list_item_bean {

    public String pathPrefix;
    public List<RoomList> roomList;
    public class RoomList{
        public String liveStream;
        public String liveType;
        public String nickname;
        public String onlineCount;
        public String poster_path_756;
        public String roomTheme;
    }

}
