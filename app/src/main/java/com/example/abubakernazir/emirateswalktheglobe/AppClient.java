package com.example.abubakernazir.emirateswalktheglobe;

/**
 * Created by abubakernazir on 11/3/16.
 */


import android.app.AlertDialog;
        import android.app.ProgressDialog;
        import android.content.Context;
        import android.content.DialogInterface;
        import android.os.AsyncTask;
        import android.util.Log;
        import android.widget.Toast;

        import java.io.BufferedReader;
        import java.io.BufferedWriter;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.io.OutputStream;
        import java.io.OutputStreamWriter;
        import java.net.HttpURLConnection;
        import java.net.MalformedURLException;
        import java.net.URL;
        import java.net.URLEncoder;

public class AppClient  {

    private static final String TAG_SUCCESS = "success";
    String BaseURL=ServiceMethod.BaseUrl;
    public String Url = "";
    public String Post;
    Context ctx;
    AppClientListerner ml;

    // constructor

    Context ref;
    private static final String TAG = "SellerUpdateService";
    public String SetDict(String Key,String Value, int method){
        try {


            if (method == 0) {

                return URLEncoder.encode(Key, "UTF-8") + "=" + URLEncoder.encode(Value, "UTF-8");
            }
            else
            return URLEncoder.encode(Key, "UTF-8") + "=" + URLEncoder.encode(Value, "UTF-8")+"&";
        }catch (Exception e) {
            Log.e(TAG, "UpdateStaff error=" + e);

            return "";
        }
    }
    public  AppClient(AppClientListerner ml){

        this.ml=ml;
    }
    public void ShowDialog(Context ctx, String Title,String Message ){
        new AlertDialog.Builder(ctx)
                .setTitle(Title)
                .setMessage(Message)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();

    }
   public void callWebSerVice(String serviceName, int i){

       this.Url=serviceName;


       new UpdateSellerDetail().execute("0");

   }
    public  boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }
    /**
     * Background Async Task to fetch all services
     */
    class UpdateSellerDetail extends AsyncTask<String, String, String> {



        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected String doInBackground(String... input) {
            try {
                URL url = new URL(BaseURL+Url);
//                Log.e(TAG, "UpdateSeller url=" + url);
//                Log.e(TAG, "UpdateSeller values=" + fromTime+" && "+toTime);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setReadTimeout(30000);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String post_data =Post;
                        ;
//                }
                bufferedWriter.write(post_data);

                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

                String result = "";
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();

                return result;

            } catch (MalformedURLException e) {
                Log.e(TAG, "UpdateStaff error=" + e);

                return null;
            } catch (Exception e) {
                Log.e(TAG, "UpdateStaff Exception=" + e);

                return null;
            }
        }


        protected void onPostExecute(String response) {
            if(response!=null) {
                ml.callback(response,Url);
                Log.e(TAG, "UpdateSeller PostExec" + response);
            }
        }
    }
}
