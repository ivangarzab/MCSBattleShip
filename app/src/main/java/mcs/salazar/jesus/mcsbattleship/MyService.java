package mcs.salazar.jesus.mcsbattleship;

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

/**
 * Created by berekethaile on 2/6/18.
 */

public class MyService extends Service{

    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference mDatabaseReference = database.getReference().child("session");

    Session mSession = new Session();
    User mUser = new User();
    Battlefield mBattlefield = new Battlefield();

    DatabaseReference mDatabaseRef;

    public MyService() {}

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    Query mQuery = mDatabaseReference;



    @Override
    public void onCreate() {
        super.onCreate();
        mUser.setEmail("bk@gmail.com");
        mSession.setDateFinished("");
        mSession.setDateStarted("");
        mSession.setTotalTurns(2);
        mSession.setChallengee(mUser);
        mSession.setChallenger(mUser);
        mSession.setChallengeeBattlefield(mBattlefield);
        mSession.setChallengerBattlefield(mBattlefield);
        mSession.setNextTurn(mUser);
        //mDatabaseReference = database.getReference().child("session").push();
        //mDatabaseReference.setValue(mSession);


        mQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mDatabaseReference.equals("bk@gmail.com");
                Session sesh = dataSnapshot.getValue(Session.class);
               /* for (DataSnapshot child : dataSnapshot.getChildren()) {
                    Session sesh = child.getValue(Session.class);
                    String email = sesh.getNextTurn().getEmail();

                    Toast.makeText(getApplicationContext(), email, Toast.LENGTH_LONG).show();
                }*/

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //Toast.makeText(getApplicationContext(), "Service started", Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);
    }
}
