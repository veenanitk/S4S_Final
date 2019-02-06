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

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class LoginActivity extends AppCompatActivity {

    /**
     * Declaration
     */
    EditText email;
    EditText password;
    Button login;
    LoginButton loginButton;
    CallbackManager callbackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(this, gso);


        /**
         * email and public_profile can be read from facebook,
         * on clicking facebook login button
         */
        loginButton = (LoginButton) findViewById(R.id.login_button_fb);
        loginButton.setReadPermissions("email", "public_profile");

        /**
         * Sign-in is continued with facebook
         */
        callbackManager = CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                String userid = loginResult.getAccessToken().getUserId();

                GraphRequest graphRequest = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {

                    }
                });
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

        /**
         * Declaration and linking of views
         */
        email = (EditText) findViewById(R.id.email_login_text_view);
        password = (EditText) findViewById(R.id.password_login_text_view);
        login = (Button) findViewById(R.id.login_button);

        /**
         * When login button is clicked ,
         * checkDataEntered() is evaluated
         */
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  {

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

        if (isEmail(email) == false) {
            email.setError("Enter valid email!");
            valid = false;

        }

        if (password.getText().toString().length() < 8 && !isValidPassword(password.getText().toString())) {
            password.setError("Enter valid password!");
            valid =  false;
        }

        if(valid)
        {
            Intent i = new Intent(this, MainActivity.class);
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
                if (checked) {
                    Intent i = new Intent(this, RegistrationActivity.class);
                    startActivity(i);
                    break;
                }
            case R.id.radio_login:
                if (checked) {
                    break;
                }
        }
    }
}
