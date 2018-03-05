package mcs.salazar.jesus.mcsbattleship.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import mcs.salazar.jesus.mcsbattleship.R;

/**
 * Created by berekethaile on 2/27/18.
 */

public class ResetPasswordActivity extends AppCompatActivity {

    private EditText inputEmail;
    private Button resetButton;
    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        inputEmail = findViewById(R.id.email);
        resetButton = findViewById(R.id.reset_password);

        mFirebaseAuth= FirebaseAuth.getInstance();

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = inputEmail.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplication(), "Enter your registered email id", Toast.LENGTH_LONG).show();
                    return;
                }

                mFirebaseAuth.sendPasswordResetEmail(email)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(ResetPasswordActivity.this, "Check your email for a link to reset your password", Toast.LENGTH_LONG).show();
                                    loginPage();
                                } else {
                                    Toast.makeText(ResetPasswordActivity.this, "Enter correct email address", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });

    }

    private void loginPage() {
        Intent intent = new Intent(ResetPasswordActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}
