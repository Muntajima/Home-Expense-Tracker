package com.example.homeexpnstrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText ArrowBack, Name, Password, SignUp;
    Button Login;
    DbHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ArrowBack = (EditText) findViewById(R.id.arrowBack);
        Name = (EditText) findViewById(R.id.name);
        Password = (EditText) findViewById(R.id.password);
        SignUp = (EditText) findViewById(R.id.signUp);
        Login = (Button) findViewById(R.id.comlogin_btn);
        DB = new DbHelper(this);

        ArrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        SignUpActivity.class);
                startActivity(intent);
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isloggedId = DB.CheckUsernamePassword(Name.getText().toString(), Password.getText().toString());
                if (isloggedId){
                    Intent intent = new Intent(getApplicationContext(),
                            DashBoardActivity.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(LoginActivity.this, "Login Unuccessful", Toast.LENGTH_SHORT).show();
            }
        });

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        signUpActivity2.class);
                startActivity(intent);
            }
        });

    }
}