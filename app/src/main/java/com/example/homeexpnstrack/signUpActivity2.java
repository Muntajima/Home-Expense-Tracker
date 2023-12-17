package com.example.homeexpnstrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.text.TextUtils;
public class signUpActivity2 extends AppCompatActivity {

    EditText ArrowBack, UserName, Phone, Password, LoginBack;
    Button ComSignUp;
    DbHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        ArrowBack = (EditText) findViewById(R.id.arrowBack);
        UserName = (EditText) findViewById(R.id.username);
        Phone = (EditText) findViewById(R.id.phone);
        Password = (EditText) findViewById(R.id.password);
        //LoginBack = (EditText) findViewById(R.id.loginback);
        ComSignUp = (Button) findViewById(R.id.comSignUpbtn);
        DB = new DbHelper(this);
        ArrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        SignUpActivity.class);
                startActivity(intent);
            }
        });

        ComSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username1 = UserName.getText().toString();
                String phone1 = Phone.getText().toString();
                String password1 = Password.getText().toString();

                if (TextUtils.isEmpty(phone1)) {
                    Phone.setError("Phone number is required.");
                    return;
                }

                if (TextUtils.isEmpty(password1)) {
                    Password.setError("Password is required.");
                    return;
                }

                if (password1.length() < 6) {
                    Password.setError("Password must be more than six characters");
                    return;
                } else {

                    boolean registationCom = DB.insertData(username1, phone1, password1);
                    if (registationCom)
                        Toast.makeText(signUpActivity2.this, "Ragistration Successful", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(signUpActivity2.this, "Ragistration Unuccessful..", Toast.LENGTH_SHORT).show();

                }
                Intent intent = new Intent(getApplicationContext(),
                        DashBoardActivity.class);
                startActivity(intent);
            }

        });


    }
}