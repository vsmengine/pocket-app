package com.example.pocketapp.contact;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pocketapp.R;
import com.example.pocketapp.other.Tags;
import com.example.pocketapp.services.DownloadService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetContacts extends AppCompatActivity {
  private ProgressDialog progressDialog = null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cont);

    DownloadContacts downloadContacts = new DownloadContacts();
    downloadContacts.execute();
  };

  public class DownloadContacts extends AsyncTask<Void, Void, Void> {

    public String downloadUrl = "https://api.androidhive.info/contacts/";
    private ProgressDialog dialog;
    private DownloadService downloadService;
    private JSONArray contactsArray = null;
//  ArrayList<HashMap<String, String>> contactList;

    @Override
    protected void onPreExecute() {
      super.onPreExecute();
      dialog = new ProgressDialog(GetContacts.this);
      dialog.setTitle("Pocket App");
      dialog.setMessage("contacts are downloading");
      dialog.setIndeterminate(true);
      dialog.setCancelable(false);
      dialog.show();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
      super.onPostExecute(aVoid);
      if(dialog.isShowing()){
        dialog.dismiss();
      }
    }

    @Override
    protected Void doInBackground(Void... voids) {
      DownloadService service = new DownloadService();
      String stringContacts = service.downloadServiceCall(downloadUrl);
//      Log.d("Response",">" + stringContacts);
      if(stringContacts != null) {
        try {
          JSONObject jsonContacts = new JSONObject(stringContacts);
          contactsArray = jsonContacts.getJSONArray(Tags.TAG_CONTACTS);
          for(int i = 0; i < contactsArray.length(); i++) {
            JSONObject contact = contactsArray.getJSONObject(i);

          }
//          Log.d("Response",">" + jsonContacts);
        } catch (JSONException e) {
          e.printStackTrace();
        }
      } else {

      }
      return null;
    }
  }
}
