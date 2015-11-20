package kr.co.kj_studio.exbuddy.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by KJ_Studio on 2015-11-16.
 */
public class ContextUtil {
    private static final String PREFERENCE_NAME = "RepotPreferences";
    private static final String LOGGED_IN = "isLogin";

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
}
