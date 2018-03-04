package mcs.salazar.jesus.mcsbattleship;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import mcs.salazar.jesus.mcsbattleship.model.Battlefield;
import mcs.salazar.jesus.mcsbattleship.model.Session;
import mcs.salazar.jesus.mcsbattleship.model.User;
import mcs.salazar.jesus.mcsbattleship.util.FirebaseService;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class LoginActivity extends AppCompatActivity   {

    public static final String TAG = LoginActivity.class.getName();

    private FirebaseAuth mAuth;

    private CallbackManager mCallbackManager;

    @BindView(R.id.buttonSignin) Button buttonSignIn;

    @BindView(R.id.buttonRegister) Button buttonRegister;

    @BindView(R.id.editTextEmail) EditText editTextEmail;

    @BindView(R.id.editTextPassword) EditText editTextPassword;

    @BindView(R.id.login_facebook_button) LoginButton mFacebookButton;

    User opponent, player;
    int size, NumberOfShips;
    Session mSession = new Session(opponent, player);
    User mUser = new User();
    Battlefield mBattlefield = new Battlefield(size, NumberOfShips);

    FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    DatabaseReference mBattlefieldRef = mDatabase.getReference().child("Battlefields");
    DatabaseReference mSessionRef = mDatabase.getReference().child("Sessions");
    DatabaseReference mUserRef = mDatabase.getReference().child("Users");

    Query mBattlefieldQuery = mBattlefieldRef;
    Query mSessionsQuery = mSessionRef;
    Query mUsersQuery = mUserRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupActivity();

        setupFacebookAuth();
        setupEmailLogin();
        setUpEmailRegister();
        setResetPassword();

        userList();
        sessionsList();
        battlefieldsList();

    }

    private void userList() {

        mUsersQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String, String > usersList = (HashMap<String, String>) dataSnapshot.getValue();
                JSONObject jsonObject = new JSONObject();
                for (String key: usersList.keySet()) {
                    Object value = usersList.get(key);
                    try {
                        jsonObject.put(key, value);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void sessionsList() {
        mSessionsQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String, String > sessionsList = (HashMap<String, String>) dataSnapshot.getValue();
                JSONObject jsonObject = new JSONObject();
                for (String key: sessionsList.keySet()) {
                    Object value = sessionsList.get(key);
                    try {
                        jsonObject.put(key, value);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void battlefieldsList() {
//        final ArrayList<Battlefield> battlefieldArrayList = new ArrayList<>();

        mBattlefieldQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Map<String, String > battlefieldsList = (HashMap<String, String>) dataSnapshot.getValue();

                JSONObject jsonObject = new JSONObject();
                for (String key: battlefieldsList.keySet()) {
                    Object value = battlefieldsList.get(key);
                    try {
                        jsonObject.put(key, value);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and act accordingly
        FirebaseUser currentUser = mAuth.getCurrentUser();
        // If user is already signed-in
        if (currentUser != null) {
            gotoDashboard();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Pass the activity result back to the Facebook SDK
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void setupActivity() {
        // Binding ButterKnife!
        ButterKnife.bind(this);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
    }


    private void setUpEmailRegister() {
        // Initializing views
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });
    }

    private void setupEmailLogin() {
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(LoginActivity.this, "Please Enter Email", Toast.LENGTH_LONG).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(LoginActivity.this, "Please Enter password", Toast.LENGTH_LONG).show();
                    return;
                }

                if(password.length() < 6) {
                    Toast.makeText(LoginActivity.this, "Password too short, Enter Again", Toast.LENGTH_LONG).show();
                    return;
                }

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    //Toast.makeText(LoginActivity.this, "Successful login", Toast.LENGTH_LONG).show();
                                    gotoDashboard();
                                } else {
                                    Toast toast = Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_LONG);
                                    toast.show();
                                }
                            }
                        });
            }
        });
    }

    private void setResetPassword() {
        TextView resetPassword = findViewById(R.id.reset_password);
        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ResetPassword.class));
            }
        });
    }

    private void gotoDashboard() {
        Intent intent = new Intent(LoginActivity.this, PlayerDashBoard.class);
        startActivity(intent);
    }

    private void setupFacebookAuth() {
        // Initialize Facebook Login button
        mCallbackManager = CallbackManager.Factory.create();
        // Defined the information needed from user
        mFacebookButton.setReadPermissions(getResources().getString(R.string.string_email));
        mFacebookButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                gotoDashboard();
                handleFacebookAccessToken(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                Log.d(TAG, getString(R.string.facebook_login_cancel));
                //TODO: Handle Facebook login cancellation
            }

            @Override
            public void onError(FacebookException error) {
                Log.d(TAG, getString(R.string.facebook_login_error), error);
                //TODO: Handle Facebook login error
            }
        });
    }

    private void handleFacebookAccessToken(AccessToken token) {
        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, getString(R.string.facebook_signin_success));
                            // Get user for future use
                            //FirebaseUser user = mAuth.getCurrentUser();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, getString(R.string.facebook_signin_success),
                                    task.getException());
                            Toast.makeText(LoginActivity.this,
                                    getString(R.string.authentication_failed),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
