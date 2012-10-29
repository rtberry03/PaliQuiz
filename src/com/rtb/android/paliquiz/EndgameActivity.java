/**
 * 
 */
package com.rtb.android.paliquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.rtb.android.paliquiz.R;
import com.rtb.android.paliquiz.quiz.Constants;
import com.rtb.android.paliquiz.quiz.GamePlay;
import com.rtb.android.paliquiz.quiz.Helper;

/**
 * @author robert.hinds
 * with a lot of alterations by RTBerry
 */
public class EndgameActivity extends Activity implements OnClickListener {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		String temp_string = getString(R.string.you_scored);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.endgame);
		GamePlay currentGame = ((PaliQuiz)getApplication()).getCurrentGame();
		String result = temp_string + " " + currentGame.getRight() + "/" + currentGame.getNumRounds() + ".. ";
		String comment = Helper.getResultComment(currentGame.getRight(), currentGame.getNumRounds());
		
		
		TextView results = (TextView)findViewById(R.id.endgameResult);
		results.setText(result + "\n" + comment);
		
	
		//handle button actions
		Button finishBtn = (Button) findViewById(R.id.finishBtn);
		finishBtn.setOnClickListener(this);
		Button answerBtn = (Button) findViewById(R.id.answerBtn);
		answerBtn.setOnClickListener(this);
		
	}
	
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onKeyDown(int, android.view.KeyEvent)
	 * 
	 * This method is to override the back button on the phone
	 * to prevent users from navigating back in to the quiz
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		switch (keyCode)
		{
		//case KeyEvent.KEYCODE_BACK :
			//return true;
		}
		
		return super.onKeyDown(keyCode, event);
	}


	public void onClick(View arg1) {
		switch (arg1.getId()){
		case R.id.finishBtn :
			finish();
			break;
			

			
		case R.id.answerBtn :
			Intent i1 = new Intent(this, AnswersActivity.class);
			startActivityForResult(i1, Constants.PLAYBUTTON);
			break;
		}
	}

}
