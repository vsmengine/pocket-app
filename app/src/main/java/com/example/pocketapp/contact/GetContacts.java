package com.example.pocketapp.contact;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pocketapp.R;
import com.example.pocketapp.other.Tags;
import com.example.pocketapp.services.DownloadService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GetContacts extends ListActivity {
  public String downloadUrl = "https://api.androidhive.info/contacts/";
  private ProgressDialog dialog;
  private DownloadService downloadService;
  private JSONArray contactsArray = null;
  private ArrayList<HashMap<String, String>> contactsList;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cont);

    contactsList = new ArrayList<HashMap<String, String>>();

    ListView listView = getListView();
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent in = new Intent(getApplicationContext(), GetContactDetail.class);
        in.putExtra("contactHashMap", contactsList.get(i));
        startActivity(in);
      }
    });
    DownloadContacts downloadContacts = new DownloadContacts();
    downloadContacts.execute();
  };

  public class DownloadContacts extends AsyncTask<Void, Void, Void> {

    //Pre Download Execution Function
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

    //Post Download Execution Function
    @Override
    protected void onPostExecute(Void aVoid) {
      super.onPostExecute(aVoid);
      if(dialog.isShowing()){
        dialog.dismiss();
        ListAdapter listAdapter = new SimpleAdapter(
                GetContacts.this,
                contactsList,
                R.layout.activity_cont_single,
                new String[]{ Tags.TAG_NAME, Tags.TAG_EMAIL, Tags.TAG_MOBILE },
                new int[]{ R.id.cont_name, R.id.cont_email, R.id.cont_mobile }
        );
        setListAdapter(listAdapter);
      }
    }

    //Background Execution Function
    @Override
    protected Void doInBackground(Void... voids) {
      DownloadService service = new DownloadService();
      String stringContacts = service.downloadServiceCall(downloadUrl);
      if(stringContacts != null) {
        try {
          JSONObject jsonContacts = new JSONObject(stringContacts);
          contactsArray = jsonContacts.getJSONArray(Tags.TAG_CONTACTS);

          for(int i = 0; i < contactsArray.length(); i++) {
            JSONObject contact = contactsArray.getJSONObject(i);
            JSONObject phone = contact.getJSONObject(Tags.TAG_PHONE);

            String newId = contact.getString(Tags.TAG_ID);
            String newName = contact.getString(Tags.TAG_NAME);
            String newEmail = contact.getString(Tags.TAG_EMAIL);
            String newAddress = contact.getString(Tags.TAG_ADDRESS);
            String newGender = contact.getString(Tags.TAG_GENDER);
            String newMobile = phone.getString(Tags.TAG_MOBILE);
            String newHome = phone.getString(Tags.TAG_HOME);
            String newOffice = phone.getString(Tags.TAG_OFFICE);

            HashMap<String, String> contSingle = new HashMap<String, String>();
            contSingle.put(Tags.TAG_ID, newId);
            contSingle.put(Tags.TAG_NAME, newName);
            contSingle.put(Tags.TAG_EMAIL, newEmail);
            contSingle.put(Tags.TAG_ADDRESS, newAddress);
            contSingle.put(Tags.TAG_GENDER, newGender);
            contSingle.put(Tags.TAG_MOBILE, newMobile);
            contSingle.put(Tags.TAG_HOME, newHome);
            contSingle.put(Tags.TAG_OFFICE, newOffice);

            contactsList.add(contSingle);
          }
        } catch (JSONException e) {
          e.printStackTrace();
        }
      }
      return null;
    }
  }
}
