package com.example.abubakernazir.emirateswalktheglobe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterAuthClient;
import com.twitter.sdk.android.core.models.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity implements AppClientListerner {

    private static final String TWITTER_KEY = "hN9IO3OudmPHhfXyU4QUj8eo6";
    private static final String TWITTER_SECRET = "icd59AQv8waY9LENU2KioOnH9rwQKQi7Q1BMghvm5HHSBiGYTb";

    TextView txtloginInstructions;
    EditText txtUserName,txtPassword;
    Button btnLogin,btnFacebook,btnTwitter,btnCreateAccount;
    AppClient APP;
    com.facebook.login.LoginManager fbLoginManager;
    String TAG = "FacebookLogin";
    String  facebookURL;
    CallbackManager mFacebookCallbackManager;
    LoginManager mLoginManager;

    TextView mUserNameTextView;
    AccessTokenTracker mAccessTokenTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
        setContentView(R.layout.activity_main);
        txtloginInstructions=(TextView)findViewById(R.id.txtloginInstructions);
        APP=new AppClient(this);
        txtUserName=(EditText)findViewById(R.id.etEmail);
        txtPassword=(EditText)findViewById(R.id.etPass);
        btnLogin=(Button)findViewById(R.id.btnSingIn);
        btnFacebook=(Button)findViewById(R.id.btnFaceBookSingIn);
        btnTwitter=(Button)findViewById(R.id.btnTwitterSingIn);
        setupFacebookStuff();
        SharedPreferences prefs = getSharedPreferences("loginInfo", MODE_PRIVATE);
        String restoredText = prefs.getString("loginInfo", null);
        if (restoredText != null) {
           startActivity(new Intent( MainActivity.this,HomeActivity.class));
        }
        btnCreateAccount=(Button)findViewById(R.id.btnCreateAccount);

        btnTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TwitterAuthClient mTwitterAuthClient = new TwitterAuthClient();
                mTwitterAuthClient.authorize(MainActivity.this, new com.twitter.sdk.android.core.Callback<TwitterSession>() {

                    @Override
                    public void success(Result<TwitterSession> twitterSessionResult) {
                        // Success
                        int i=0;
                    }

                    @Override
                    public void failure(TwitterException e) {
                        e.printStackTrace();
                    }
                });
            }
        });
        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fbLoginManager.logInWithReadPermissions(MainActivity.this, Arrays.asList("email", "public_profile", "user_birthday"));
            }
        });

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), RegisterActivity.class);

                startActivity(i);
            }
        });
        Gethashkey();

//        btnFacebook.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FacebookSdk.sdkInitialize(getApplicationContext());
//
//                mAccessTokenTracker = new AccessTokenTracker() {
//                    @Override
//                    protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
//
//                    }
//                };
//
//                mLoginManager = LoginManager.getInstance();
//                mFacebookCallbackManager = CallbackManager.Factory.create();
//
//                LoginManager.getInstance().registerCallback(mFacebookCallbackManager, new FacebookCallback<LoginResult>() {
//                    @Override
//                    public void onSuccess(LoginResult loginResult) {
//int i=0;
//                    }
//
//                    @Override
//                    public void onCancel() {
//                        int i=0;
//                    }
//
//                    @Override
//                    public void onError(FacebookException error) {
//                        int i=0;
//                    }
//
//                });
//
//            }
//            });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtUserName.getText().length()==0){
                    APP.ShowDialog(MainActivity.this,"Required!","Email is Required");
                    return;
                }
                if(txtPassword.getText().length()==0){
                    APP.ShowDialog(MainActivity.this,"Required!","Password is Required");
                    return;
                }
                if(!APP.isValidEmail(txtUserName.getText())){

                    APP.ShowDialog(MainActivity.this,"Invalid Email!","Invalid Email format");
                    return;

                }
                APP.Post=APP.SetDict("email",txtUserName.getText().toString(),1)+
                        APP.SetDict("password",txtPassword.getText().toString(),1)+
                        APP.SetDict("deviceid","",0);
                APP.callWebSerVice(ServiceMethod.Login,0);
            }
        });

    }

    private void Initilize_Control(){


    }
    private void SetEvent(){



    }



    private void setupFacebookStuff() {

        // This should normally be on your application class
        FacebookSdk.sdkInitialize(MainActivity.this);


        fbLoginManager = com.facebook.login.LoginManager.getInstance();
        mFacebookCallbackManager= CallbackManager.Factory.create();
        fbLoginManager.registerCallback(mFacebookCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
             int i=0;
                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(
                                    JSONObject object,
                                    GraphResponse response) {
                                // Application code
                                try {
//                                    @"email":[dict valueForKey:@"email"],
//                                    @"username":[NSString stringWithFormat:@"%@ %@",[dict valueForKey:@"first_name"], [dict valueForKey: @"last_name"] ],
//                                    @"socialid":[dict valueForKey:@"id"],
//                                    @"profilepic": @"facebook",
//                                    @"flag":@"fb",

                                        APP.Post=  APP.SetDict("email",object.getString("email"),1) +
                                                APP.SetDict("socialid",object.getString("id"),1)+
                                                APP.SetDict("flag","fb",1)+
                                                APP.SetDict("password","",1)+
                                                APP.SetDict("username",object.getString("first_name")+" "+object.getString("last_name"),1)+
                                                APP.SetDict("profilepic","facebook",0)

                                                ;
                                        facebookURL=object.getJSONObject("picture").getJSONObject("data").getString("url");
                                         APP.callWebSerVice(ServiceMethod.Register,0);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                Log.e("GraphResponse", "-------------" + response.toString());
                            }
                        });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,link,gender,birthday,email,first_name,last_name,location,locale,timezone,picture");
                request.setParameters(parameters);
                request.executeAsync();

                Log.e("Total Friend in List", "----------------------");
                new GraphRequest(
                        loginResult.getAccessToken(),
                        "/me/friends",
                        null,
                        com.facebook.HttpMethod.GET,
                        new GraphRequest.Callback() {
                            public void onCompleted(GraphResponse response) {
                                /* handle the result */
                                Log.e("Friend in List", "-------------" + response.toString());
                            }
                        }
                ).executeAsync();
                // here write code When Login successfully
            }

            @Override
            public void onCancel() {
                updateFacebookButtonUI();
             int i=0;
            }

            @Override
            public void onError(FacebookException e) {
                // here write code when get error
            }
        });

    }

    private void updateFacebookButtonUI(){
        if (AccessToken.getCurrentAccessToken() != null){
            GraphRequest request = GraphRequest.newMeRequest(
                    AccessToken.getCurrentAccessToken() ,
                    new GraphRequest.GraphJSONObjectCallback() {
                        @Override
                        public void onCompleted(
                                JSONObject object,
                                GraphResponse response) {
                            // Application code
                            try {
//                                    @"email":[dict valueForKey:@"email"],
//                                    @"username":[NSString stringWithFormat:@"%@ %@",[dict valueForKey:@"first_name"], [dict valueForKey: @"last_name"] ],
//                                    @"socialid":[dict valueForKey:@"id"],
//                                    @"profilepic": @"facebook",
//                                    @"flag":@"fb",

                                APP.Post=  APP.SetDict("email","",1) +
                                        APP.SetDict("socialid",object.getString("id"),1)+
                                        APP.SetDict("flag","fb",1)+
                                        APP.SetDict("password","",1)+
                                        APP.SetDict("username",object.getString("first_name")+" "+object.getString("last_name"),1)+
                                        APP.SetDict("profilepic","facebook",0)

                                ;
                                facebookURL=object.getJSONObject("picture").getJSONObject("data").getString("url");
                                APP.callWebSerVice(ServiceMethod.Register,0);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    });
            Bundle parameters = new Bundle();
            parameters.putString("fields", "id,name,link,gender,birthday,email,first_name,last_name,location,locale,timezone,picture");
            request.setParameters(parameters);
            request.executeAsync();

            Log.e("Total Friend in List", "----------------------");
            new GraphRequest(
                    AccessToken.getCurrentAccessToken() ,
                    "/me/friends",
                    null,
                    com.facebook.HttpMethod.GET,
                    new GraphRequest.Callback() {
                        public void onCompleted(GraphResponse response) {
                                /* handle the result */
                            Log.e("Friend in List", "-------------" + response.toString());
                        }
                    }
            ).executeAsync();

        }else{


        }
    }



    private void handleFacebookLogin() {
        mLoginManager.logInWithReadPermissions(MainActivity.this, Arrays.asList("public_profile"));

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mFacebookCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void Gethashkey()
    {
        try {
            PackageInfo info;

            info = getPackageManager().getPackageInfo("com.example.abubakernazir.emirateswalktheglobe", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md;
                md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                // String something = new String(Base64.encode(md.digest(), 0));
                //String something = new String(Base64.encodeBytes(md.digest()));
                //Base64.encodeToString(md.digest(),Base64.DEFAULT)
                Log.e("Hash key:", Base64.encodeToString(md.digest(),Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e1) {
            Log.e("name not found", e1.toString());
        } catch (NoSuchAlgorithmException e) {
            Log.e("no such an algorithm", e.toString());
        } catch (Exception e) {
            Log.e("exception", e.toString());
        }
    }

    @Override
    public void callback( String result,String ServiceName) {
        if(ServiceName == ServiceMethod.Login){
            try {
                JSONObject jsd = new JSONObject(result);
                if(jsd.getString("error").toLowerCase()=="false") {
                    SharedPreferences.Editor editor = getSharedPreferences("loginInfo", MODE_PRIVATE).edit();
                    editor.putString("loginInfo", result);
                    editor.commit();

                    finish();
                    startActivity(new Intent( MainActivity.this,HomeActivity

                            .class));
                }else{
                    APP.ShowDialog(MainActivity.this,"Failed to Login","Invalid User name and password");

                }

            }catch (Exception ex){


            }
        }
        if(ServiceName == ServiceMethod.Register){
            try {
                JSONObject jsd = new JSONObject(result);
                JSONObject users=jsd.getJSONObject("data").getJSONArray("users").getJSONObject(0);
                if(users.getString("profilepic")=="facebook"){
                  result.replace("\"profilepic\":\"facebook\"","\"profilepic\":\""+facebookURL+"\"");
                }

                SharedPreferences.Editor editor = getSharedPreferences("loginInfo", MODE_PRIVATE).edit();
                editor.putString("loginInfo", result);
                editor.commit();
                finish();

                startActivity(new Intent( MainActivity.this,HomeActivity.class));

            }
            catch(Exception ex){
                int i=0;

            }




        }
        // do your stuff here
    }
}
