/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

import java.util.List;


public class MainActivity extends AppCompatActivity {
  String forgotPass = " Forgot your login details? ";
  String forgotPassBold = "Get help signing in.";
  String signUp = "Don't have an account? ";
  String signUpBold = "Sign up.";

  TextView forgotPassTextView;
  TextView signUpTextView;
  Button logInButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    forgotPassTextView = findViewById(R.id.forgotPassTextView);
    signUpTextView     = findViewById(R.id.signUpTextView);
    logInButton        = findViewById(R.id.logInButton);

    signUpTextView.setOnClickListener(this.goToSignUpListener);
    forgotPassTextView.setOnClickListener(this.goToForgotPassListener);


    setBoldTexts();


    ParseAnalytics.trackAppOpenedInBackground(getIntent());
  }


  public void setBoldTexts(){
      int fullStringSizeForgot = forgotPass.length() + forgotPassBold.length();
      SpannableString str = new SpannableString(forgotPass + forgotPassBold);
      str.setSpan(new StyleSpan(Typeface.BOLD),forgotPass.length(), fullStringSizeForgot, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
      forgotPassTextView.setText(str);

      int fullStringSizeSignUp = signUp.length() + signUpBold.length();
      str = new SpannableString(signUp + signUpBold);
      str.setSpan(new StyleSpan(Typeface.BOLD), signUp.length(), fullStringSizeSignUp , SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
      signUpTextView.setText(str);
  }

  private View.OnClickListener goToSignUpListener = new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          Intent i = new Intent(getApplicationContext(), SignUpActivity.class);
          startActivity(i);
      }
  };
  
  private View.OnClickListener goToForgotPassListener = new View.OnClickListener(){
      @Override
      public void onClick(View v){
          Toast.makeText(MainActivity.this, "Not implemented yet.", Toast.LENGTH_SHORT).show();
      }
  };

  private View.OnClickListener LogIn = new View.OnClickListener(){
      @Override
      public void onClick(View v){
          Toast.makeText(MainActivity.this, "Not implemented yet.", Toast.LENGTH_SHORT).show();
      }
  };
}