package mcs.salazar.jesus.mcsbattleship;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by berekethaile on 2/14/18.
 */

public class SignUpActivity extends AppCompatActivity {

    private EditText inputEmail, inputPassword;
    private Button registerButton;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Get Firebase auth instance
        mAuth = FirebaseAuth.getInstance();

        registerButton = findViewById(R.id.register);
        inputEmail = findViewById(R.id.register_email);
        inputPassword = findViewById(R.id.register_password);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = inputEmail.getText().toString();

                String password = inputPassword.getText().toString();

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(SignUpActivity.this, "Successful Register", Toast.LENGTH_LONG).show();
                                    loginPage();
                                } else {
                                    Toast toast = Toast.makeText(SignUpActivity.this, "Register failed", Toast.LENGTH_LONG);
                                    toast.show();
                                }
                            }
                        });

            }
        });

    }

    private void loginPage() {
        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}
