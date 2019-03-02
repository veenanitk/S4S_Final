package com.example.android.s4s;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

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
import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class LoginActivity extends AppCompatActivity {

    /**
     * Declaration
     */
    EditText email;
    EditText password;
    TextInputLayout email_layout,password_layout;
    Button login;
    LoginButton loginButton;
    CallbackManager callbackManager;
    //firebase auth object
    private FirebaseAuth firebaseAuth;



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
        email_layout = (TextInputLayout) findViewById(R.id.layout_login_email);
        password_layout = (TextInputLayout) findViewById(R.id.layout_login_password);
        login = (Button) findViewById(R.id.login_button);


        /**
         * When login button is clicked ,
         * checkDataEntered() is evaluated
         */
        login.setOnClickListener(new View.OnClickListener() {
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
     * To  check the validation of Password
     *
     * @param text
     * @return '1' if valid '0' if not valid
     */
    public static boolean isValidPassword(EditText text) {

        CharSequence password = text.getText().toString();
        return password.length() >= 8;

    }

    /**
     * To check the validity of all the views
     */
    void checkDataEntered() {
        boolean valid = true;

        if (isEmail(email) == false) {
            email_layout.setError("Enter valid email!");
            valid = false;
        }
        else
            email_layout.setError(null);

        if (isValidPassword(password) == false) {
            password_layout.setError("Enter Valid Password!");
            valid = false;
        }
        else
            password_layout.setError(null);

        if (valid) {
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


    private Boolean exit = false;

    @Override
    public void onBackPressed() {
        if (exit) {
            Intent a = new Intent(Intent.ACTION_MAIN);
            a.addCategory(Intent.CATEGORY_HOME);
            a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(a); // finish activity
        } else {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);

        }
    }
}
