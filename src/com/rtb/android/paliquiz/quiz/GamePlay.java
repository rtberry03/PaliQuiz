/**
 * 
 */
package com.rtb.android.paliquiz.quiz;

import java.util.ArrayList;
import java.util.List;

/**
 * @author robert.hinds
 * with a lot of alterations by RTBerry
 * This class represents the current game being played
 * tracks the score and player details
 *
 */
public class GamePlay {
	
	private int numRounds;
	private int chapter;
	private String playerName;
	private int right;
	private int wrong;
	private int round;
	
	private List<Question> questions = new ArrayList<Question>();
	
	
	//sloppy work-around
	//SNAFU RE:  QuestionActivity onCreate... 
	//just a screen orientation change?  if so, don't increment next question  
	//or did the user really click Next? if so, then increment next question
	
	//private int ok_to_increment=0;

	/**
	 * @so OK to increment
	 */
	//public void set_ok_to_increment() {
	//	ok_to_increment=1;
	//}
	/**
	 * @so not OK to increment
	 */
	//public void clear_ok_to_increment() {
	//	ok_to_increment=0;
	//}
	
//	public int return_ok_to_increment() {
//		return ok_to_increment;
//	}

	
	
	//see below at getNextQuestion()
	//end of my sloppy work-around - xxoo RTB
	
	
	
	/**
	 * @return the playerName
	 */
	public int getTotalRounds() {
		return numRounds;
	}
	
	/**
	 * @return the playerName
	 */
	public String getPlayerName() {
		return playerName;
	}
	/**
	 * @param playerName the playerName to set
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	/**
	 * @return the right
	 */
	public int getRight() {
		return right;
	}
	/**
	 * @param right the right to set
	 */
	public void setRight(int right) {
		this.right = right;
	}
	/**
	 * @return the wrong
	 */
	public int getWrong() {
		return wrong;
	}
	/**
	 * @param wrong the wrong to set
	 */
	public void setWrong(int wrong) {
		this.wrong = wrong;
	}
	/**
	 * @return the round
	 */
	public int getRound() {
		return round;
	}
	/**
	 * @param round the round to set
	 */
	public void setRound(int round) {
		this.round = round;
	}
	/**
	 * @param chapter the chapter to set
	 */
	public void setChapter(int chapter) {
		this.chapter = chapter;
	}
	/**
	 * @return the chapter
	 */
	public int getChapter() {
		return chapter;
	}
	/**
	 * @param questions the questions to set
	 */
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	/**
	 * @param q the question to add
	 */
	public void addQuestions(Question q) {
		this.questions.add(q);
	}
	
	/**
	 * @return the questions
	 */
	public List<Question> getQuestions() {
		return questions;
	}
	
	//this caused indexing problems...
	//public Question getNextQuestion(){
	//	
		//get the question
	//	Question next = questions.get(this.getRound());
		//update the round number to the next round
		
	//	if (this.getRound()==0) {
	//		Log.e("INITIALIZED","getNextQuestion()");
	//		set_ok_to_increment();
	//	}
	//	if (ok_to_increment==1) {
	//		Log.e("INCREMENTING ROUND","getNextQuestion()");
	//		this.setRound(this.getRound()+1);
	//		clear_ok_to_increment();
	//	}
	//	return next;
	//}
	
	public Question getCurrentQuestion(){
		
		//get the question
		Question current = questions.get(this.getRound());
		return current;
	}
	
	public void increment(){
		if (this.getRound()==(this.getTotalRounds()-1)) {
//			Log.e("NOT INCREMENTING ROUND","increment()");
		}
		
		if (this.getRound()<(this.getTotalRounds()-1)) {
//			Log.e("INCREMENTING ROUND","increment()");
			this.setRound(this.getRound()+1);
		}
	}
	
	/**
	 * method to increment the number of correct answers this game
	 */
	public void incrementRightAnswers(){
		right ++;
	}
	
	/**
	 * method to increment the number of incorrect answers this game
	 */
	public void incrementWrongAnswers(){
		wrong ++;
	}
	/**
	 * @param numRounds the numRounds to set
	 */
	public void setNumRounds(int numRounds) {
		this.numRounds = numRounds;
	}
	/**
	 * @return the numRounds
	 */
	public int getNumRounds() {
		return numRounds;
	}
	
	/**
	 * method that checks if the game is over
	 * @return boolean
	 */
	public boolean isGameOver(){
		return (getRound() >= (getNumRounds()-1));
	}


}
