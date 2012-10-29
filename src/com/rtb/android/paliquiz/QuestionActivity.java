/**
 * 
 */
package com.rtb.android.paliquiz;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.rtb.android.paliquiz.R;
import com.rtb.android.paliquiz.quiz.GamePlay;
import com.rtb.android.paliquiz.quiz.Question;
import com.rtb.android.paliquiz.util.Utility;

/**
 * @author robert.hinds
 * with a lot of alterations by RTBerry
 */
public class QuestionActivity extends Activity implements OnClickListener{

	private Question currentQ;
	private GamePlay currentGame;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        
//    	Log.e("ONCREATE", "drawing new view");
    	    	
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.question);
        /**
         * Configure current game and get question
         */
        currentGame = ((PaliQuiz)getApplication()).getCurrentGame();
         
        //bad idea... indexing problems...
        //currentQ = currentGame.getNextQuestion();
        
        currentQ = currentGame.getCurrentQuestion();
        
        
        //if (currentGame.return_ok_to_increment()==1) {
        //	Log.e("CHECK OK2Inc", "OK_TO_INCREMENT==1");
        //	currentGame.increment();
        //}
     
        Button nextBtn = (Button) findViewById(R.id.nextBtn);
		nextBtn.setOnClickListener(this);
        
        /**
         * Update the question and answer options..
         */
        setQuestions();
        
    }
public void setFont(TextView name, String path, int res)
    {
    	name=(TextView)findViewById(res);
        Typeface font = Typeface.createFromAsset(this.getAssets(), path); 
        name.setTypeface(font);
        

    }

	/**
	 * Method to set the text for the question and answers from the current games
	 * current question
	 */
	private void setQuestions() {
		//set the question text from current question
		
		
		int question_number = currentGame.getRound();
		int total_questions = currentGame.getTotalRounds();
		TextView this_number = (TextView) findViewById(R.id.this_number_view);
        this_number.setText("Question " + String.valueOf(question_number+1) + " / " + String.valueOf(total_questions));
        
		
		String question = Utility.capitalise(currentQ.getQuestion());
        TextView qText = (TextView) findViewById(R.id.question);
        qText.setText(question);
        setFont(qText, "Verajjab.ttf", R.id.question);
        int text_height = 18;
        qText.setTextSize(text_height);
        
        
        //set the available options
        List<String> answers = currentQ.getQuestionOptions();
        TextView option1 = (TextView) findViewById(R.id.answer1);
        option1.setText(Utility.capitalise(answers.get(0)));
        setFont(qText, "Verajjab.ttf", R.id.answer1);
        
        TextView option2 = (TextView) findViewById(R.id.answer2);
        option2.setText(Utility.capitalise(answers.get(1)));
        setFont(qText, "Verajjab.ttf", R.id.answer2);
        
        TextView option3 = (TextView) findViewById(R.id.answer3);
        option3.setText(Utility.capitalise(answers.get(2)));
        setFont(qText, "Verajjab.ttf", R.id.answer3);
        
        TextView option4 = (TextView) findViewById(R.id.answer4);
        option4.setText(Utility.capitalise(answers.get(3)));
        setFont(qText, "Verajjab.ttf", R.id.answer4);
	}
    

	public void onClick(View arg0) {
		
		
		
//		Log.e("QuestionActivity onClick", "...");
		
		/**
		 * validate a checkbox has been selected
		 */
		if (!checkAnswer()) return;

		
		/**
		 * check if end of game
		 */
		if (currentGame.isGameOver()){
			//Log.d("Questions", "End of game! lets add up the scores..");
			//Log.d("Questions", "Questions Correct: " + currentGame.getRight());
			//Log.d("Questions", "Questions Wrong: " + currentGame.getWrong());
			
			
			Intent i = new Intent(this, EndgameActivity.class);
			startActivity(i);
			finish();
		}
		else{
			
//			Log.e("onClick contd...", "calling increment...");
			//currentGame.set_ok_to_increment();
			currentGame.increment();
			
			Intent i = new Intent(this, QuestionActivity.class);
			startActivity(i);
			finish();
		}
	}
	
	
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		switch (keyCode)
		{
	
			
		case KeyEvent.KEYCODE_MENU :
			
			AboutDialogActivity about = new AboutDialogActivity(this);
			about.setTitle(R.string.info_str);
			about.show();
			return true; 
			
		//case KeyEvent.KEYCODE_BACK :

			//return true; 
					
		case KeyEvent.KEYCODE_SEARCH :
			String the_answer = currentQ.getAnswer();
			
			LayoutInflater inflater = getLayoutInflater();
			View layout = inflater.inflate(R.layout.toast_layout,
			                               (ViewGroup) findViewById(R.id.toast_layout_root));

			TextView text = (TextView) layout.findViewById(R.id.text);
			text.setText(Utility.capitalise(the_answer));
			
	        Typeface font = Typeface.createFromAsset(this.getAssets(), "Verajjab.ttf"); 
	        text.setTypeface(font);
			
			    
	        Toast toast = new Toast(getApplicationContext());
			toast.setGravity(Gravity.TOP|Gravity.CENTER, 0, 35);
			toast.setDuration(Toast.LENGTH_LONG);
			toast.setView(layout);
			toast.show();
			
			return true;
		}
		
		return super.onKeyDown(keyCode, event);
	}


	/**
	 * Check if a checkbox has been selected, and if it
	 * has then check if its correct and update gamescore
	 */
	private boolean checkAnswer() {
		String answer = getSelectedAnswer();
		if (answer==null){
			//Log.d("Questions", "No Checkbox selection made - returning");
			return false;
		}
		else {
				
			//Log.d("Questions", "Valid Checkbox selection made - check if correct");
			if (currentQ.getAnswer().equalsIgnoreCase(answer))
			{
				//Log.d("Questions", "Correct Answer!");
				currentGame.incrementRightAnswers();
			}
			else{
				//Log.d("Questions", "Incorrect Answer!");
				currentGame.incrementWrongAnswers();
			}
			return true;
		}
	}


	/**
	 * 
	 */
	private String getSelectedAnswer() {
		RadioButton c1 = (RadioButton)findViewById(R.id.answer1);
		RadioButton c2 = (RadioButton)findViewById(R.id.answer2);
		RadioButton c3 = (RadioButton)findViewById(R.id.answer3);
		RadioButton c4 = (RadioButton)findViewById(R.id.answer4);
		if (c1.isChecked())
		{
			return c1.getText().toString();
		}
		if (c2.isChecked())
		{
			return c2.getText().toString();
		}
		if (c3.isChecked())
		{
			return c3.getText().toString();
		}
		if (c4.isChecked())
		{
			return c4.getText().toString();
		}
		
		return null;
	}
	
}
