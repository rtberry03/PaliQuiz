/**
 * 
 */
package com.rtb.android.paliquiz.quiz;

/**
 * @author robert.hinds
 * with a lot of alterations by RTBerry
 */
public class Helper {

	/**
	 * This method selects a end game response based on the players score
	 * 
	 * @param numCorrect - num correct answers
	 * @param numRounds - number of questions
	 * @return String comment
	 */
	

	public static String getResultComment(int numCorrect, int numRounds) {
		
		String comm="";
		String sadhu="Sadhu!";
	    String nicely_done="Nicely done";
	    String not_too_bad="Not too terribly bad";
	    String study_more="Study more and try again";
	    String improve_with="You are certain to improve with practice";
			
		int percentage = calculatePercentage(numCorrect, numRounds);
		
			if (percentage > 95){
				comm = sadhu;
			}else if (percentage >= 85){
				comm=nicely_done;
			}else if (percentage >= 75){
				comm=not_too_bad;
			}else if (percentage >= 50){
				comm=study_more;
			}else{
				comm=improve_with;
			}
		return comm;
	}
	
	private static int calculatePercentage(int numCorrect, int numRounds) {
		double frac = (double)numCorrect/(double)numRounds;
		int percentage = (int) (frac*100);
		return percentage;
	}
}
