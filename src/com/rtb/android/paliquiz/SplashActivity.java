package com.rtb.android.paliquiz;

import java.io.IOException;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.SQLException;
import android.os.Bundle;
// import android.util.Log;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.rtb.android.paliquiz.R;
import com.rtb.android.paliquiz.db.DBHelper;
import com.rtb.android.paliquiz.quiz.Constants;
import com.rtb.android.paliquiz.quiz.GamePlay;
import com.rtb.android.paliquiz.quiz.Question;

public class SplashActivity extends Activity implements OnClickListener{

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		
		//new
		//DBHelper initialDbHelper = new DBHelper(this);
		//Log.e("LOOK 111", "got to here1");
		//initialDbHelper.createDatabase();
		//Log.e("LOOK 111", "got to here2");
		//initialDbHelper.openDataBase();
		//Log.e("LOOK 111", "got to here3");	
		//initialDbHelper.close();
		//Log.e("LOOK 111", "got to here3");
		//initialDbHelper.openDataBase();
		//Log.e("LOOK 111", "got to here4");	
		//initialDbHelper.close();
		//Log.e("LOOK 111", "got to here5");
		//end new
		
		DBHelper myDbHelper = new DBHelper(this);
 
        try {
 
        	myDbHelper.createDataBase();
 
 	} catch (IOException ioe) {
 
 		throw new Error("Unable to create database");
 
 	}
 
 	try {
 
 		myDbHelper.openDataBase();
 		myDbHelper.close();
 
 	}catch(SQLException sqle){
 
 		throw sqle;
 
 	}
		
		
		
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.welcome);
		
		
		try {
		    String version = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
		    TextView results = (TextView)findViewById(R.id.the_versionName);
			results.setText("Ver " + version);
		} catch (NameNotFoundException e) {
		    Log.e("tag", e.getMessage());
		}
		

		//////////////////////////////////////////////////////////////////////
		//////// GAME MENU  /////////////////////////////////////////////////
		Button playBtn = (Button) findViewById(R.id.playBtn);
		playBtn.setOnClickListener(this);
		Button settingsBtn = (Button) findViewById(R.id.settingsBtn);
		settingsBtn.setOnClickListener(this);
		Button exitBtn = (Button) findViewById(R.id.exitBtn);
		exitBtn.setOnClickListener(this);
		Button aboutBtn = (Button) findViewById(R.id.aboutBtn);
		aboutBtn.setOnClickListener(this);
	}


	/**
	 * Listener for game menu
	 */
	public void onClick(View v) {
		Intent i;
		
		switch (v.getId()){
		case R.id.playBtn :
			//once logged in, load the main page
			//Log.d("LOGIN", "User has started the game");
			
			//Get Question set //
			List<Question> questions = getQuestionSetFromDb();

			//Initialise Game with retrieved question set ///
			GamePlay c = new GamePlay();
			c.setQuestions(questions);
			c.setNumRounds(getNumQuestions());
			((PaliQuiz)getApplication()).setCurrentGame(c);  

			//Start Game Now.. //

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.PLAYBUTTON);
			break;
			
			
		case R.id.settingsBtn :
			i = new Intent(this, SettingsActivity.class);
			startActivityForResult(i, Constants.SETTINGSBUTTON);
			break;
			
		case R.id.aboutBtn :
			AboutDialogActivity about = new AboutDialogActivity(this);
			about.setTitle(R.string.info_str);
			about.show();
			break; 
			
		case R.id.exitBtn :
			finish();
			break;
		}

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		switch (keyCode)
		{
	
		
		case KeyEvent.KEYCODE_BACK :

			return true; 
			
		case KeyEvent.KEYCODE_SEARCH :

			return true; 
			
		case KeyEvent.KEYCODE_MENU :
			
			AboutDialogActivity about = new AboutDialogActivity(this);
			about.setTitle(R.string.info_str);
			about.show();
			return true; 
				
		}
		
		return super.onKeyDown(keyCode, event);
	}
	
	/**
	 * Method that retrieves a random set of questions from
	 * the database for the given chapter
	 * @return
	 * @throws Error
	 */
	private List<Question> getQuestionSetFromDb() throws Error {
		int chapter_num = getChapterSettings();
		int numQuestions = getNumQuestions();
		
		DBHelper myDbHelper = new DBHelper(this);
		//Log.e("LOOK", "got to here1");
		//try {
		//	myDbHelper.createDataBase();
		//} catch (IOException e) {
		//	e.printStackTrace();
		//}
		// Log.e("LOOK", "about to dopen database in ListQuestion");
		myDbHelper.openDataBase();
		// Log.e("LOOK", "opened it");	
		List<Question> questions = myDbHelper.getQuestionSet(chapter_num, numQuestions);
		// Log.e("LOOK", "done with questions");
		myDbHelper.close();
		return questions;
	}


	/**
	 * Method to return the chapter settings
	 * @return
	 */
	private int getChapterSettings() {
		SharedPreferences settings = getSharedPreferences(Constants.SETTINGS, 0);
		int chap = settings.getInt(Constants.CHAPTER, Constants.CH_01);
		return chap;
	}

	/**
	 * Method to return the number of questions for the game
	 * @return
	 */
	private int getNumQuestions() {
		SharedPreferences settings = getSharedPreferences(Constants.SETTINGS, 0);
		int numRounds = settings.getInt(Constants.NUM_ROUNDS, 20);
		return numRounds;
	}

}