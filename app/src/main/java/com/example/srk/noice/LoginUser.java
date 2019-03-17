package com.example.srk.noice;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.srk.noice.R;
import com.example.srk.noice.SQLiteHelper1;
import com.example.srk.noice.UserRegister;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginUser extends AppCompatActivity {

    private EditText inputEmail, inputPassword;
    private FirebaseAuth auth;
    private ProgressBar progressBar;
    private Button btnSignup, btnLogin, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        if(auth.getCurrentUser()!= null){
            startActivity(new Intent(LoginUser.this, OnScreen.class));
            finish();
        }
        setContentView(R.layout.activity_login_user);



        inputEmail= (EditText)findViewById(R.id.email);
        inputPassword= (EditText)findViewById(R.id.password);
        progressBar= (ProgressBar)findViewById(R.id.progressBar);
        btnSignup=(Button)findViewById(R.id.btn_signup);
        btnLogin=(Button)findViewById(R.id.btn_login);
        btnReset=(Button)findViewById(R.id.btn_reset_password);



        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginUser.this,UserRegister.class));
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginUser.this,ResetPassword.class));
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = inputEmail.getText().toString();
                final String password = inputPassword.getText().toString();

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(),"Enter email address !",Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(),"Enter password ! ",Toast.LENGTH_LONG).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);

                //auth user
                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(LoginUser.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        if(!task.isSuccessful()){
                            //there was an error
                            if(password.length()<6){
                                inputPassword.setError(getString(R.string.minimum_pass));
                            }else {
                                Toast.makeText(LoginUser.this,getString(R.string.auth_failed),Toast.LENGTH_LONG).show();
                            }
                        }else {
                            Intent intent = new Intent(LoginUser.this,OnScreen.class);
                            startActivity(intent);
                            finish();
                        }

                    }
                });
            }
        });

    }

}
