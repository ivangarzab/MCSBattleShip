package mcs.salazar.jesus.mcsbattleship.cloudmsg;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import mcs.salazar.jesus.mcsbattleship.LoginActivity;

/**
 * Created by Ivan on 2/6/2018
 */
public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    public static final String TAG = "MAGIC_TOKEN: ";

    @Override
    public void onTokenRefresh() {
        //For registration of token
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        //To displaying token on logcat
        Log.d(TAG, refreshedToken);

    }
}
