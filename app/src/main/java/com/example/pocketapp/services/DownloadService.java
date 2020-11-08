package com.example.pocketapp.services;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class DownloadService {
  static String response = null;

  public String downloadServiceCall(String url) {
    BufferedReader bufferedReader = null;
    URLConnection urlConnection;

    try {

      URL urlObject = new URL(url);
      urlConnection = urlObject.openConnection();
      bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
      StringBuffer stringBuffer = new StringBuffer();
      String line;

      while ((line = bufferedReader.readLine()) != null) {
        stringBuffer.append(line);
      }
      response = stringBuffer.toString();
      return response;

    } catch (Exception e) {

      Log.e("APP", "***** PocketApp Exception *****", e);

    } finally {

      if (bufferedReader != null) {
        try {
          bufferedReader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

    }
    return response;
  }
}

