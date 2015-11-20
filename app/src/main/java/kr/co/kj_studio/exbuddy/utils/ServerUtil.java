package kr.co.kj_studio.exbuddy.utils;


import android.content.Context;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ServerUtil {
	private static final String TAG = ServerUtil.class.getSimpleName();

	private final static String BASE_URL = "http://repot2015.cafe24.com/ci/repot/";

	public interface JsonResponseHandler {
		void onResponse(JSONObject json);
	}

	public interface StringResponseHandler {
		void onResponse(String response);
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
