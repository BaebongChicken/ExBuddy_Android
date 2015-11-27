package kr.co.kj_studio.exbuddy.dataClass;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by KJ_Studio on 2015-11-28.
 */
public class UserData implements Serializable {

    // 사용자 정보에 넣을 항목이 결정되면 여기에 형식 맞춰서 저장하면 된다.


    public String userId;
    public String email;
    public String phoneNum;
    public String name;
    public DateTime birthDate;


    // JSON에서 UserData 뽑아낼때 최대한 편한 코드르 구상해봤다.
    // 원하는곳에서 UserData myData = UserData.getUserDataFromJson(json);
    // 이런 방식으로 사용하면 바로 유저데이터를 뽑아낼 수 있게 코딩함.



    public static  UserData getUserDataFromJson(JSONObject json) {
        UserData userData = null;

        try {
            userData = new UserData();
            userData.userId = json.getString("userId");
            userData.email = json.getString("email");
            userData.phoneNum = json.getString("phoneNum");
            userData.name = json.getString("name");
            userData.birthDate = DateTime.parse(json.getString("birthDate"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return userData;
    }



}
