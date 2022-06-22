package com.srsofttech.studentcare.auth;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.srsofttech.studentcare.MainActivity;
import com.srsofttech.studentcare.R;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn_sign_in;
    TextView sign_up_here;
    private CircularProgressIndicator progressBar;
    EditText editText_email,editText_password;
    ProgressDialog progressDialog;
   private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        progressBar=findViewById(R.id.id_progressbar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        progressDialog=new ProgressDialog(this);



        auth=FirebaseAuth.getInstance();

        sign_up_here = findViewById(R.id.id_sign_up_page);
        sign_up_here.setOnClickListener(this);
        btn_sign_in = findViewById(R.id.id_btn_sign_in);
        btn_sign_in.setOnClickListener(this);

        editText_email=findViewById(R.id.id_sign_in_email);
        editText_password=findViewById(R.id.id_sign_in_password);


    }


    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.id_btn_sign_in){
           userLogin();


        }

        if(view.getId()==R.id.id_sign_up_page){
            finish();
            Intent it = new Intent(SignInActivity.this, SignupActivity.class);
            startActivity(it);
        }
    }


    private void userLogin() {
        //first getting the values
        final String email = editText_email.getText().toString();
        final String password = editText_password.getText().toString();

        //validating inputs
        if (TextUtils.isEmpty(email)) {
            editText_email.setError("Please enter your email address");
            editText_password.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            editText_password.setError("Please enter your password");
            editText_password.requestFocus();
            return;
        }

        //if everything is fine
        //progressBar.setVisibility(View.VISIBLE);


        progressDialog.setMessage("Loading...");
        progressDialog.show();
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(
                                    @NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(),
                                                    "Login success!",
                                                    Toast.LENGTH_SHORT)
                                            .show();

                                    // hide the progress bar
                                    progressBar.setVisibility(View.GONE);

                                    // if sign-in is successful
                                    // intent to home activity
                                    Intent intent
                                            = new Intent(getApplicationContext(),
                                            MainActivity.class);
                                    startActivity(intent);
                                } else {

                                    // sign-in failed
                                    Toast.makeText(getApplicationContext(),
                                                    "Login failed!",
                                                    Toast.LENGTH_LONG)
                                            .show();

                                    // hide the progress bar
                                   // progressBar.setVisibility(View.GONE);
                                    progressDialog.dismiss();
                                }
                            }
                        });


    }

    }



