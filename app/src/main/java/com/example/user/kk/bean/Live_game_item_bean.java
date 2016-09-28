package com.example.user.kk.bean;

import java.util.List;

/**
 * Created by user on 2016/9/13.
 */
public class Live_game_item_bean {
   public String pathPrefix;
    public List<RoomList> roomList;
    public class RoomList{
        public String liveStream;
        public String liveType;
        public String live_poster_756;
        public String nickname;
        public String onlineCount;
        public String roomTheme;
    }
}
