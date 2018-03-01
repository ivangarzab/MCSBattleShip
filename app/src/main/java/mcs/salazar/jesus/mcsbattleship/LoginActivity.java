package mcs.salazar.jesus.mcsbattleship;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

import butterknife.BindView;
import butterknife.ButterKnife;

import mcs.salazar.jesus.mcsbattleship.databinding.GridLayoutBinding;
import mcs.salazar.jesus.mcsbattleship.model.Session;
import mcs.salazar.jesus.mcsbattleship.model.User;
import mcs.salazar.jesus.mcsbattleship.util.InGameUtil;
import mcs.salazar.jesus.mcsbattleship.view.BattlefieldView;
import mcs.salazar.jesus.mcsbattleship.viewmodel.SessionGameViewModel;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class LoginActivity extends AppCompatActivity   {

    //defining views
    private Button buttonSignIn;
    private EditText editTextEmail;
    private EditText editTextPassword;

    // Firebase auth object
    private FirebaseAuth firebaseAuth;

    public static final String TAG = LoginActivity.class.getName();

    @BindView(R.id.login_facebook_button) LoginButton mFacebookButton;

    private FirebaseAuth mAuth;

    private CallbackManager mCallbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create SessionGameView bind to ViewModel which contains Model
        GridLayoutBinding binding = DataBindingUtil
                .setContentView(this, R.layout.grid_layout);
        binding.setViewmodel(new SessionGameViewModel(new Session(new User(), new User())));

        // Bind OpponentBattlefield
        InGameUtil.bindOpponentBattlefield(this,
                binding.getViewmodel().getOpponentBattlefield(),
                (BattlefieldView) findViewById(R.id.session_game_opponent_battlefield));

        // Bind PlayerBattlefield
        InGameUtil.bindPlayerBattlefield(this,
                binding.getViewmodel().getPlayerBattlefield(),
                (BattlefieldView) findViewById(R.id.session_game_player_battlefield));
        /*
        Bundle bundle = new Bundle();
        bundle.putParcelable("battlefield", new Battlefield(5, 3));
        Battlefield ship = bundle.getParcelable("battlefield");
        Log.i("TRASH", "SOMETHING");
        setupFacebookAuth();
        setupEmailLogin();
        */
    }


    private void setupFacebookAuth() {
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        ButterKnife.bind(this);

        // Initialize Facebook Login button
        mCallbackManager = CallbackManager.Factory.create();
        // Defined the information needed from user
        mFacebookButton.setReadPermissions(getResources().getString(R.string.string_email));
        mFacebookButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d(TAG, getString(R.string.facebook_login_success) + loginResult);
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

    private void setupEmailLogin() {
        // Gettting firebase auth object
        firebaseAuth = FirebaseAuth.getInstance();
        //initializing views
        editTextEmail =  findViewById(R.id.editTextEmail);
        editTextPassword =  findViewById(R.id.editTextPassword);
        buttonSignIn = findViewById(R.id.buttonSignin);

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = editTextEmail.getText().toString();

                String password = editTextPassword.getText().toString();

                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(LoginActivity.this, "Successful login", Toast.LENGTH_LONG).show();
                                } else {
                                    Toast toast = Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_LONG);
                                    toast.show();
                                }
                            }
                        });

            }
        });
    }

    /*@Override
    protected void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and act accordingly
        FirebaseUser currentUser = mAuth.getCurrentUser();
        // If user is already signed-in
        if (currentUser != null) {
            //TODO: What to do if user is already signed-in
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Pass the activity result back to the Facebook SDK
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }*/

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
