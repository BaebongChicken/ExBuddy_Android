package kr.co.kj_studio.exbuddy.dataClass;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by KJ_Studio on 2015-11-28.
 */
public class UserData implements Serializable {

    // 사용자 정보에 넣을 항목이 결정되면 여기에 형식 맞춰서 저장하면 된다.


    public String name;
    public String uid;
    public String email;
    public String profilePhoto;
    public String phoneNum;


    // JSON에서 UserData 뽑아낼때 최대한 편한 코드르 구상해봤다.
    // 원하는곳에서 UserData myData = UserData.getUserDataFromJson(json);
    // 이런 방식으로 사용하면 바로 유저데이터를 뽑아낼 수 있게 코딩함.



    public static  UserData getUserDataFromJson(JSONObject json) {
        UserData userData = null;

        try {
            userData = new UserData();
            userData.uid = json.getString("uid");
            userData.email = json.getString("email");
            userData.name = json.getString("name");
            userData.profilePhoto = json.getString("profilePhoto");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return userData;
    }

    public static  UserData getUserDataFromJsonWhenRegister(JSONObject json) {
        UserData userData = null;

        try {
            userData = new UserData();
            userData.uid = json.getString("uid");
            userData.email = json.getString("email");
            userData.name = json.getString("name");
            userData.profilePhoto = json.getString("profilePhoto");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return userData;
    }



}
