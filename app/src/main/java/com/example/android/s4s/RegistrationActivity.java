package com.example.android.s4s;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegistrationActivity extends AppCompatActivity {

    /**
     * Declaration of views
     */
    EditText name;
    EditText email;
    EditText phone;
    EditText password;
    EditText confirmpassword;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        /**
         * Declaration and linking of views
         */
        name = (EditText) findViewById(R.id.name_text_view);
        email = (EditText) findViewById(R.id.email_text_view);
        phone = (EditText) findViewById(R.id.phone_text_view);
        password = (EditText) findViewById(R.id.password_text_view);
        confirmpassword = (EditText) findViewById(R.id.confirm_password_text_view);
        register = (Button) findViewById(R.id.register_button);

        /**
         * When register button is clicked ,
         * checkDataEntered() is evaluated
         */
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataEntered();
            }
        });

    }

    /**
     * To check the validation of Email address
     *
     * @param text
     * @return '1' for accepted email and '0' for not accepted email
     */
    private boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    /**
     * To Check if EditText View is empty
     *
     * @param text
     * @return '1' for empty and '0' for not empty
     */
    private boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    /**
     * To check the validation of Phone Number
     *
     * @param text
     * @return '1' if valid '0' if not valid
     */
    private boolean isValidMobile(EditText text) {
        CharSequence phone = text.getText().toString();
        Pattern pattern;
        Matcher matcher;
        final String PHONE_PATTERN = "/[2-9]{2}\\d{8}/";
        pattern = Pattern.compile(PHONE_PATTERN);
        matcher = pattern.matcher(phone);

        return matcher.matches();
       // return (!TextUtils.isEmpty(phone) && Patterns.PHONE.matcher(phone).matches());
    }

    /**
     * To  check the validation of Password
     *
     * @param password
     * @return '1' if valid '0' if not valid
     */
    public static boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }

    /**
     * To check the validity of all the views
     */
    void checkDataEntered() {

        boolean valid = true;
        /**
         * Error display for invalid name
         */
        if (isEmpty(name)) {
            name.setError("Name is required!");
            valid  = false;
        }

        /**
         * Error display for invalid email
         */
        if (isEmail(email) == false) {
            email.setError("Enter valid email!");
            valid = false;
        }

        /**
         * Error display for invalid phone
         */
        if (phone.getText().toString().length() != 10 && !isValidMobile(phone)) {
            phone.setError("Phone Number must have 10 digits!");
            valid = false;
        }

        /**
         * Error display for invalid password
         */
        if (password.getText().toString().length() < 8 && !isValidPassword(password.getText().toString())) {
            password.setError("Password must be at least 8 characters!");
            valid = false;
        }

        /**
         * Password entered in confirm password view is checked for a match ,
         * with already entered password
         */
        if (!password.getText().toString().equals(confirmpassword.getText().toString())) {
            confirmpassword.setError("Password did not match!");
            valid = false;
        }

        if(valid)
        {
            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);
        }
    }

    /**
     * openTerms() is evaluated when user clicks <u>terms</u>,
     * Terms and conditions are displayed
     *
     * @param view
     */
    public void openTerms(View view) {
        Intent i = new Intent(this, TermsActivity.class);
        startActivity(i);
    }


    /**
     * To check the status of radio button
     *
     * @param view
     */
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_create_account:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.radio_login:
                if (checked) {
                    Intent i = new Intent(this, LoginActivity.class);
                    startActivity(i);
                    break;
                }
        }
    }


}
