package com.example.gasparyan.homeworke2;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class RegistrationActivity extends AppCompatActivity {

    private String imgUrl;
    private static int RESULT_LOAD_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


//        Intent intent = new Intent(this,ProfileUser.class);
//        intent.putExtra("image",imgUrl);
//        startActivity(intent);
    }


    public void choosePhoto(View view) {
        Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, RESULT_LOAD_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            imgUrl = cursor.getString(columnIndex);
            cursor.close();
            checkCheckBoxByCheckingValue(R.id.Photo, true);
            chackEditebleButton(R.id.save);

        }
    }

    private void chackEditebleButton(int id){
        Button button =(Button) findViewById(id);
        if(!button.isEnabled()){
            button.setEnabled(true);
        }
    }

    private void checkCheckBoxByCheckingValue(int id, boolean value) {
        CheckBox checkBox = (CheckBox) findViewById(id);
        checkBox.setChecked(value);
    }

    public void saveUser(View view) {
        User user = createUser();
        goToProfileUser(user);
    }



    private User createUser(){
        EditText name = (EditText) findViewById(R.id.name);
        EditText lastName = (EditText) findViewById(R.id.lastname);
        RadioGroup gender = (RadioGroup) findViewById(R.id.gender);
        EditText emale = (EditText) findViewById(R.id.email);
        EditText password = (EditText) findViewById(R.id.password);
        RadioButton radioButton = (RadioButton) findViewById(gender.getCheckedRadioButtonId());
        return new User(name.getText().toString(), lastName.getText().toString(),
                radioButton.getText().toString(), emale.getText().toString(),
                password.getText().toString(), imgUrl);
    }


    public void   goToProfileUser(User user){
        Intent intent = new Intent(RegistrationActivity.this,ProfileUser.class);
        intent.putExtra("userData",user);
        startActivity(intent);
    }



}
