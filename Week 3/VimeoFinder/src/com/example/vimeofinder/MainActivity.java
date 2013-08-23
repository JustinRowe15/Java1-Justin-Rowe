package com.example.vimeofinder;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.lib.FileStuff;
import com.example.lib.WebStuff;
import com.example.tweetfinder.R;
import com.example.tweetfinder.helpers.FindTweets;
import com.example.vimeofinder.helpers.FavoriteVideos;
import com.example.vimeofinder.helpers.ShowVideos;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
	
	Context context;
	LinearLayout linearlayout;
	TextView tweetsView;
	Button getTweetsButton;
	ShowVideos showTweets;
	FindTweets search;
	FavoriteVideos favoriteTweets;
	Boolean connected = false;
	HashMap<String, String> history;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context = this;
		linearlayout = new LinearLayout(this);
		history = getHistory();
		
		search = new FindTweets(context, "Enter Vimeo Username", "GO");
		
		//Add Search Handler
		Button searchButton = search.getButton();
		
		searchButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				getTweet(search.getField().getText().toString());
			}
		});
		
		//Detect Network Connection
		connected = WebStuff.getConnectionStatus(context);
		if(connected){
			Log.i("NETWORK CONNECTION", WebStuff.getConnectionType(context));
		}
		
		//Add Tweet Display
		showTweets = new ShowVideos(context);
		
		//Add Favorites Display
		favoriteTweets = new FavoriteVideos(context);
		
		//Add Views to Main Layout
		linearlayout.addView(search);
		linearlayout.addView(showTweets);
		linearlayout.addView(favoriteTweets);
		linearlayout.setOrientation(LinearLayout.VERTICAL);
		setContentView(linearlayout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private void getTweet(String username){
		String baseURL = "http://vimeo.com/api/v2/" + username + "/videos.json";
		URL finalURL;
		try{
			finalURL = new URL(baseURL);
			TweetRequest tr = new TweetRequest();
			tr.execute(finalURL);
		} catch (MalformedURLException e){
			Log.e("BAD URL", "MALFORMED URL");
			finalURL = null;
		}
	}
	
	@SuppressWarnings("unchecked")
	private HashMap<String, String> getHistory(){
		Object stored = FileStuff.readObjectFile(context, "history", false);
		
		HashMap<String, String> history;
		if(stored == null){
			Log.i("HISTORY", "NO HISTORY FILE FOUND");
			history = new HashMap <String, String>();
		} else {
			history = (HashMap<String, String>) stored;
		}
		return history;
	}

	private class TweetRequest extends AsyncTask<URL, Void, String>{
		@Override
		protected String doInBackground(URL... urls){
			String response = "";
			for (URL url: urls){
				response = WebStuff.getURLStringResponse(url);
			}
			return response;
		}
		
		@Override
		protected void onPostExecute(String result){
			Log.i("URL RESPONSE", result);
			try{
			JSONObject json = new JSONObject(result);
			JSONObject results = json.getJSONObject("id");
				if(results.getString("col1").compareTo("N/A")==0){
					Toast toast = Toast.makeText(context, "Invalid User", Toast.LENGTH_SHORT);
					toast.show();
				} else {
					Toast toast = Toast.makeText(context, "Valid User " + results.getString("user_name"), Toast.LENGTH_SHORT);
					toast.show();
					history.put(results.getString("name"), results.toString());
					FileStuff.storeObjectFile(context, "history", history, false);
					FileStuff.storeStringFile(context, "temp", results.toString(), true);
				}
			} catch (JSONException e){
				Log.e("JSON", "JSON OBJECT EXCEPTION");
			}
			
		}
	}
}
