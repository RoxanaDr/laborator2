package com.roxana_dragomir.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.roxana_dragomir.myapplication2.user.User;

public class Profile extends AppCompatActivity {
 private TextView mail;
    private TextView password;
    private Button button;

    private User user;
    private void getParameters(){
        Bundle extras=getIntent().getExtras();
        try{
            user.setEmail(extras.getString("email"));
            user.setPassword(extras.getString("password"));
        }catch(NullPointerException e){
            Log.e("Profile", "getparameters", e);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        mail=findViewById(R.id.emailtextview);
        password=findViewById(R.id.passwordlenghttextview);
        button=findViewById(R.id.button2);
        user= new User();
        getParameters();
        mail.setText(user.getEmail());
        password.setText(user.getPassword());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}