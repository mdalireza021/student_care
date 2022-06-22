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
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.srsofttech.studentcare.MainActivity;
import com.srsofttech.studentcare.R;
import com.srsofttech.studentcare.model.User;

public class SignupActivity extends AppCompatActivity {
    EditText Std_id,Guardian_name,SignUpMail,SignUpPhone,SignUpPass;
    Button SignUpButton;
    private FirebaseAuth auth;
    ProgressDialog progressDialog;
    TextView sign_in;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        SignUpMail = findViewById(R.id.id_signup_guardian_email);
        SignUpPass = findViewById(R.id.id_signup_password);
        Std_id=findViewById(R.id.id_signup_std_id);
        Guardian_name=findViewById(R.id.id_signup_guardian_name);
        SignUpPhone=findViewById(R.id.id_signup_guardian_phone);
        SignUpButton = findViewById(R.id.id_btn_signup);
        progressDialog=new ProgressDialog(this);
        sign_in=findViewById(R.id.id_sign_in_page);
        auth = FirebaseAuth.getInstance();

        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SignInActivity.class));

            }
        });


    }


    private void registerUser(){


        String std_id=Std_id.getText().toString().trim();
        String guardian_name=Guardian_name.getText().toString().trim();
        String phone=SignUpPhone.getText().toString().trim();
        String email = SignUpMail.getText().toString().trim();
        String password  = SignUpPass.getText().toString().trim();

        //checking if email and passwords are empty
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(std_id)){
            Toast.makeText(this,"Please enter unique id.",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(guardian_name)){
            Toast.makeText(this,"Please enter guardian name",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(phone)){
            Toast.makeText(this,"Please enter phone no.",Toast.LENGTH_LONG).show();
            return;
        }

        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();

        //creating a new user
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if(task.isSuccessful()){

                            //display some message here
                            DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("users");
                            String userId = mDatabase.push().getKey();
                            User user = new User(std_id,guardian_name,email,phone,password);
                            mDatabase.child(userId).setValue(user);
                            Toast.makeText(getApplicationContext(),"Successfully registered",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }
                        else
                        {
                            //display some message here
                            Toast.makeText(getApplicationContext(),"Registration Error",Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }
                });
    }
}


