package mcs.salazar.jesus.mcsbattleship.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import mcs.salazar.jesus.mcsbattleship.R;

/**
 * Created by Ivan on 2/15/2018
 */
public class UserView extends RelativeLayout implements MVVMView {

    private View mView;

    public UserView(Context context) {
        super(context);
    }

    public UserView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getUserDetails();
        setupUserView(context);
    }

    private void getUserDetails() {
        //TODO: Call VM to get the details for the User
    }

    private void setupUserView(Context context) {
        LayoutInflater inflater;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            mView = inflater.inflate(R.layout.user_card_layout, this);
        }
    }
}
