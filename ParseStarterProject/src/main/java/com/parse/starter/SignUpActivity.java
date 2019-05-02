package com.parse.starter;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {
    String signInText = "Already have a account? ";
    String signInTextBold = " Sign in.";

    TextView signInTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signInTextView.findViewById(R.id.signInTextView);


        signInTextView.setOnClickListener(goBackToLogin);

        setBoldTexts();

    }

    public void setBoldTexts(){
        int fullStringSizeSignUp = signInText.length() + signInTextBold.length();
        SpannableString str = new SpannableString(signInText + signInTextBold);
        str.setSpan(new StyleSpan(Typeface.BOLD), signInText.length(), fullStringSizeSignUp , SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        signInTextView.setText(str);
    }

    private View.OnClickListener goBackToLogin = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };
}
