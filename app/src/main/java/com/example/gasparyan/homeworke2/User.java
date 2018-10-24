package com.example.gasparyan.homeworke2;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Gasparyan on 23.10.2018.
 */

public class User implements Serializable{

   private String name ;
   private   String lastName;
   private   String gender;
   private String password;
   private   String email;
   private String imgUrl;

    User (String name,String lastName,String gender,String password,String email,String imgUrl){
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.password = password;
        this.email = email;
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
