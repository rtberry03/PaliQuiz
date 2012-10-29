/**
 * 
 */
package com.rtb.android.paliquiz;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.rtb.android.paliquiz.R;
import com.rtb.android.paliquiz.quiz.GamePlay;
import com.rtb.android.paliquiz.util.Utility;

/**
 * @author robert.hinds
 * with a lot of alterations by RTBerry
 */
public class AnswersActivity extends Activity implements OnClickListener {
	
	
	public void setFont(TextView name, String path, int res)
    {
    	name=(TextView)findViewById(res);
        Typeface font = Typeface.createFromAsset(this.getAssets(), path);
       
        name.setTypeface(font);

    }
	
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.answers);
		GamePlay currentGame = ((PaliQuiz)getApplication()).getCurrentGame();
		
		TextView results = (TextView)findViewById(R.id.answers);
		String answers = Utility.getAnswers(currentGame.getQuestions());
		results.setText(answers);

		setFont(results, "Verajjab.ttf", R.id.answers);

		
		//handle button actions
		Button finishBtn = (Button) findViewById(R.id.finishBtn);
		finishBtn.setOnClickListener(this);
		
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
		case KeyEvent.KEYCODE_BACK :
			return true;
		}
		
		return super.onKeyDown(keyCode, event);
	}


	public void onClick(View v) {
		switch (v.getId()){
		case R.id.finishBtn :
			finish();
		}
	}

}
