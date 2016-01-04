package kr.co.kj_studio.exbuddy.utils;

import android.content.Context;
import android.content.SharedPreferences;

import kr.co.kj_studio.exbuddy.dataClass.UserData;

/**
 * Created by KJ_Studio on 2015-11-16.
 */
public class ContextUtil {
    private static final String PREFERENCE_NAME = "RepotPreferences";
    private static final String LOGGED_IN = "isLogin";
    private static final String USER_ID = "User_ID";
    private static final String USER_EMAIL = "USER_EMAIL";
    private static final String USER_NAME = "USER_NAME";
    private static final String location = "location";
    private static final String isTrainer = "isTrainer";
    private static final String activityAndLevel = "activityAndLevel";
    private static final String gender = "gender";
    private static final String age = "age";
    private static final String speciality = "speciality";
    private static final String concern = "concern";
    private static final String spokenLanguage = "spokenLanguage";
    private static final String affiliation = "affiliation";
    private static final String profileLine = "profileLine";
    private static final String aboutMe = "aboutMe";
    private static final String profilePhoto = "profilePhoto";
    private static final String imagePaths = "imagePaths";

    public static boolean isUserLoggedin(Context context)
    {
        SharedPreferences prefs = context.getSharedPreferences(PREFERENCE_NAME,
                Context.MODE_PRIVATE);

        return prefs.getBoolean(LOGGED_IN, false);
    }

    public static void setLoggedIn(Context context, boolean value)
    {
        SharedPreferences prefs = context.getSharedPreferences(PREFERENCE_NAME,
                Context.MODE_PRIVATE);

        prefs.edit().putBoolean(LOGGED_IN, value).commit();

    }


    public static void setUserDataWhenRegister(Context context, UserData userData) {

        SharedPreferences prefs = context.getSharedPreferences(PREFERENCE_NAME,
                Context.MODE_PRIVATE);
        //DateTime now = new DateTime(new Date());
        prefs.edit().putString(USER_EMAIL, userData.email).commit();
        prefs.edit().putString(USER_NAME, userData.name).commit();
        prefs.edit().putString(USER_ID, userData.uid).commit();
        prefs.edit().putString(profilePhoto, userData.profilePhoto).commit();

    }


    public static UserData getUserData(Context context) {

        SharedPreferences prefs = context.getSharedPreferences(PREFERENCE_NAME,
                Context.MODE_PRIVATE);
        //DateTime now = new DateTime(new Date());

        UserData userData = new UserData();
        userData.email = prefs.getString(USER_EMAIL, "");
        userData.name = prefs.getString(USER_NAME, "");
        userData.uid = prefs.getString(USER_ID, "");
        userData.profilePhoto = prefs.getString(profilePhoto, "");

        return userData;
    }
}
