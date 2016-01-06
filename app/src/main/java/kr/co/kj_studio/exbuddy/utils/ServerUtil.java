package kr.co.kj_studio.exbuddy.utils;


import android.content.Context;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ServerUtil {
	private static final String TAG = ServerUtil.class.getSimpleName();

	public final static String BASE_URL = "http://yohun92.cafe24.com/ci/gb_dongari/";



    public interface JsonResponseHandler {
		void onResponse(JSONObject json);
	}

	public static void getMissions(final Context context, final JsonResponseHandler handler){
        String url = BASE_URL + "getMissions";
        Map<String, Object> data = new HashMap<String, Object>();

        AsyncHttpRequest.post(context, url,  data, false, new AsyncHttpRequest.HttpResponseHandler() {

            @Override
            public boolean onPrepare() {
                return true;
            }

            @Override
            public void onResponse(String response) {
                Log.v("CHO", response);
                try {
                    JSONObject json = new JSONObject(response);

                    if (handler != null)
                        handler.onResponse(json);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFinish() {

            }

            @Override
            public void onCancelled() {

            }

        });

	}
	public static void facebookLogin(final Context context, final String name, final String uid, final String email, final JsonResponseHandler handler) {
		String url = BASE_URL + "facebookLogin";
		//		String registrationId = ContextUtil.getRegistrationId(context);

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("name", name);
		data.put("uid", uid);
		data.put("email", email);
		final String profilePicturePath = "https://graph.facebook.com/" + uid + "/picture?type=large";
		data.put("profilePhoto", profilePicturePath);
		data.put("os", "Android");
		data.put("deviceToken", "tempDeviceToken");
//		data.put("userPhoneNum", objectData.userPhoneNum);

		AsyncHttpRequest.post(context, url,  data, false, new AsyncHttpRequest.HttpResponseHandler() {

			@Override
			public boolean onPrepare() {
				return true;
			}

			@Override
			public void onResponse(String response) {
				Log.v("CHO", response);
				try {
					JSONObject json = new JSONObject(response);

					if (handler != null)
						handler.onResponse(json);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			@Override
			public void onFinish() {

			}

			@Override
			public void onCancelled() {

			}

		});
	}


	public static void registerUser(final Context context, final JsonResponseHandler handler) {
		String url = BASE_URL + "registerUser";
		//		String registrationId = ContextUtil.getRegistrationId(context);

		Map<String, Object> data = new HashMap<String, Object>();
//		data.put("userPhoneNum", objectData.userPhoneNum);

		AsyncHttpRequest.post(context, url,  data, false, new AsyncHttpRequest.HttpResponseHandler() {

			@Override
			public boolean onPrepare() {
				return true;
			}

			@Override
			public void onResponse(String response) {
				Log.v("CHO", response);
				try {
					JSONObject json = new JSONObject(response);

					if (handler != null)
						handler.onResponse(json);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			@Override
			public void onFinish() {

			}

			@Override
			public void onCancelled() {

			}

		});
	}

}
