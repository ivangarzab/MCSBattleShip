package mcs.salazar.jesus.mcsbattleship.util;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import mcs.salazar.jesus.mcsbattleship.BattleField_Board;
import mcs.salazar.jesus.mcsbattleship.model.Battlefield;
import mcs.salazar.jesus.mcsbattleship.model.Session;
import mcs.salazar.jesus.mcsbattleship.model.User;

/**
 * Created by berekethaile on 3/1/18.
 */

public class FirebaseService extends Service {

    User opponent, player;
    int size, NumberOfShips;

    FirebaseDatabase mFirebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference mDatabaseReference = mFirebaseDatabase.getReference().child("mcsbattleship");

    Session mSession = new Session(opponent, player);
    User mUser = new User();
    Battlefield mBattlefield = new Battlefield(size, NumberOfShips);

    public FirebaseService() {}

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    Query mQuery = mDatabaseReference;

    @Override
    public void onCreate() {
        super.onCreate();
        mUser.setEmail("buru@gmail.com");
        mSession.setOpponent(mUser);
        mDatabaseReference.setValue(mSession);
    }
}
