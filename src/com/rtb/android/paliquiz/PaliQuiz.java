/**
 * 
 */
package com.rtb.android.paliquiz;

import com.rtb.android.paliquiz.quiz.GamePlay;

import android.app.Application;

/**
 * @author rob
 * with a lot of alterations by RTBerry
 */
public class PaliQuiz extends Application{
	private GamePlay currentGame;

	/**
	 * @param currentGame the currentGame to set
	 */
	public void setCurrentGame(GamePlay currentGame) {
		this.currentGame = currentGame;
	}

	/**
	 * @return the currentGame
	 */
	public GamePlay getCurrentGame() {
		return currentGame;
	}
}
