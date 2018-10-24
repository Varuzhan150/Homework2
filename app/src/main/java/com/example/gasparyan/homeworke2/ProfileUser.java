package com.example.gasparyan.homeworke2;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileUser extends AppCompatActivity {

    private Bitmap imagSrc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_user);
        User user = (User) this.getIntent().getSerializableExtra("userData");
        init(user);
    }


    private void init(User user) {
        TextView userName = (TextView) findViewById(R.id.userName);
        TextView userLasteName = (TextView) findViewById(R.id.lastname);
        ImageView userImage = (ImageView) findViewById(R.id.userImage);
        userName.setText(user.getName());
        userLasteName.setText(user.getLastName());
        if (user.getImgUrl() != null)
            userImage.setImageBitmap(BitmapFactory.decodeFile(user.getImgUrl()));
    }


    public void goToRegistrationActivity(View view) {
        Intent intent = new Intent(ProfileUser.this, RegistrationActivity.class);
        startActivity(intent);


    }
}