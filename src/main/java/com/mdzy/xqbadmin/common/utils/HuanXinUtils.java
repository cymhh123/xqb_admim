package com.mdzy.xqbadmin.common.utils;

import com.mdzy.xqbadmin.common.config.Global;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 环信操作
 * Created by Administrator on 2016/6/21.
 */
public class HuanXinUtils {
    public static final String DEL_URL="http://a1.easemob.com/mdzy/beizhiyuan/users/";
    public static final String TOKEN_URL="http://a1.easemob.com/mdzy/beizhiyuan/token";
    public static final String CHAT_URL ="http://a1.easemob.com/mdzy/beizhiyuan/chatmessages";
    public static final String CHATROOMS_URL="http://a1.easemob.com/mdzy/beizhiyuan/chatrooms";

    /**
     * 删除用户
     * @param userName
     * @return
     */
    public static int deleteUser(String userName){
        String deleteUrl = DEL_URL + userName;
        Map<String,String> paramMap=new HashMap<String,String>();
        paramMap.put("grant_type", "client_credentials");
        paramMap.put("client_id", Global.getConfig("hxclient_id"));
        paramMap.put("client_secret", Global.getConfig("hxclient_secret"));
        String jsonStr = HttpTools.post(TOKEN_URL,paramMap);
        Map<String, Object> tokenMap= JsonTools.jsonStrToMap(jsonStr);

        List<Map<String,String>> headerList=new ArrayList<Map<String,String>>();
        Map<String,String>header=new HashMap<String, String>();
        header.put("headerName", "Authorization");
        header.put("headerValue", "Bearer "+tokenMap.get("access_token").toString());
        headerList.add(header);
        return HttpTools.DeleteCode(deleteUrl,headerList);
    }

    /**
     *
     {
     "action": "get",
     "params": {
        "limit": ["20"],
        "ql": ["select * where timestamp>1267804800000"]
     },
     "path": "/chatmessages",
     "uri": "http://a1.easemob.com/mdzy/beizhiyuan/chatmessages",
     "entities": [
        {
         "uuid": "c4a3d20a-386d-11e6-95c7-73ec90722c91",
         "type": "chatmessage",
         "created": 1466595478304,
         "modified": 1466595478304,
         "timestamp": 1466595477697,
         "from": "18088888882",
         "msg_id": "210585157155947508",
         "to": "18615503755",
         "chat_type": "chat",
         "payload": {
             "bodies": [
                 {
                 "type": "txt",
                 "msg": "不会"
                 }
              ],
              "ext": {}
         }
        }
     ],
     "timestamp": 1466911719501,//消息发送时间"duration": 6,
     "count": 1
     }
     * @param startDate
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String findChatHistory(Long startDate) throws UnsupportedEncodingException {

        Map<String,String>paramMap=new HashMap<String,String>();
        paramMap.put("grant_type", "client_credentials");
        paramMap.put("client_id", Global.getConfig("hxclient_id"));
        paramMap.put("client_secret", Global.getConfig("hxclient_secret"));
        Map<String, Object>tokenMap=JsonTools.jsonStrToMap(HttpTools.post(TOKEN_URL,paramMap));

        List<Map<String,String>>headerList=new ArrayList<Map<String,String>>();
        Map<String,String>header=new HashMap<String, String>();
        Map<String,String>header2=new HashMap<String, String>();
        header.put("headerName", "Authorization");
        header.put("headerValue", "Bearer "+tokenMap.get("access_token").toString());
        header2.put("headerName", "Content-Type");
        header2.put("headerValue", "application/json");
        headerList.add(header);
        //在此处要判断上次同步完成后的最后一条消息的时间，按照时间同步后面的数据
        String chatUrl = CHAT_URL + "?ql=select+*+where+timestamp"+URLEncoder.encode(">","utf-8")+startDate+"&limit=20";
//        String chatUrl = CHAT_URL +"?ql=select+*+where+timestamp>"+startDate.getTime()+"&limit=100";

        String json=HttpTools.getSetHeader(chatUrl, headerList);
//        JSONObject o = JSON.parseObject(json);
        return json;
    }

    /**
     * 创建聊天室
     * @param name 聊天室名字
     * @param description 聊天室描述
     * @param maxusers 人数
     * @param owner 管理员
     * @return
     */
    public static String createChatrooms(String name,String description,String maxusers,String owner){
        Map<String,String>paramMap=new HashMap<String,String>();
        paramMap.put("grant_type", "client_credentials");
        paramMap.put("client_id", Global.getConfig("hxclient_id"));
        paramMap.put("client_secret", Global.getConfig("hxclient_secret"));
        Map<String, Object>tokenMap=JsonTools.jsonStrToMap(HttpTools.post(TOKEN_URL,paramMap));

        List<Map<String,String>>headerList=new ArrayList<Map<String,String>>();
        Map<String,String>header=new HashMap<String, String>();
        header.put("headerName", "Authorization");
        header.put("headerValue", "Bearer "+tokenMap.get("access_token").toString());
        headerList.add(header);

        Map<String,String> roomMap = new HashMap<>();
        roomMap.put("name","bzy_room");
        roomMap.put("description","server create chatroom");
        roomMap.put("maxusers","300");
        roomMap.put("owner","18000000011");
        String json=HttpTools.executePost(CHATROOMS_URL,roomMap ,headerList);
        return json;
    }
    public static void main(String[] args){
        String result = createChatrooms("bzy_room","专题聊天室测试","300","18000000011");
        System.out.println(result);
//        Date date = DateUtils.parseDate("2010/3/6");
//        String result = null;
//        try {
//            result = findChatHistory(date);
//            System.out.print(result);
//            BgChatListBean bgChatBean = (BgChatListBean)JsonMapper.fromJsonString(result, BgChatListBean.class);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        System.out.print(result);
    }
}
