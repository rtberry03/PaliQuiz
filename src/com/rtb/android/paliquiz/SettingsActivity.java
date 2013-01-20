package com.rtb.android.paliquiz;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;

import com.rtb.android.paliquiz.R;
import com.rtb.android.paliquiz.quiz.Constants;

/**
 * @author robert.hinds
 * with a lot of alterations by RTBerry
 */
public class SettingsActivity extends Activity implements OnClickListener{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        
        /**
         * set listener on update button
         */
        Button updateBtn = (Button) findViewById(R.id.updateBtn);
		updateBtn.setOnClickListener(this);
		
		/**
		 * Set selected button if saved
		 */
		updateButtonWithPreferences();
		
    }


	/**
	 * Method to update default check box
	 */
	private void updateButtonWithPreferences() {
		RadioButton c1 = (RadioButton)findViewById(R.id.ch_01Setting);
		RadioButton c2 = (RadioButton)findViewById(R.id.ch_02Setting);
		RadioButton c3 = (RadioButton)findViewById(R.id.ch_03Setting);
		RadioButton c4 = (RadioButton)findViewById(R.id.ch_04Setting);
		RadioButton c5 = (RadioButton)findViewById(R.id.ch_05Setting);
		RadioButton c6 = (RadioButton)findViewById(R.id.ch_06Setting);
		RadioButton c61 = (RadioButton)findViewById(R.id.ch_61Setting);
		RadioButton c7 = (RadioButton)findViewById(R.id.ch_07Setting);
		RadioButton c8 = (RadioButton)findViewById(R.id.ch_08Setting);
		RadioButton c9 = (RadioButton)findViewById(R.id.ch_09Setting);
		RadioButton c10 = (RadioButton)findViewById(R.id.ch_10Setting);
		RadioButton c11 = (RadioButton)findViewById(R.id.ch_11Setting);
		RadioButton c12 = (RadioButton)findViewById(R.id.ch_12Setting);
		RadioButton c13 = (RadioButton)findViewById(R.id.ch_13Setting);
		RadioButton c14 = (RadioButton)findViewById(R.id.ch_14Setting);
		RadioButton c15 = (RadioButton)findViewById(R.id.ch_15Setting);
		RadioButton c16 = (RadioButton)findViewById(R.id.ch_16Setting);
		RadioButton c17 = (RadioButton)findViewById(R.id.ch_17Setting);
		RadioButton c18 = (RadioButton)findViewById(R.id.ch_18Setting);
		RadioButton c19 = (RadioButton)findViewById(R.id.ch_19Setting);
		RadioButton c20 = (RadioButton)findViewById(R.id.ch_20Setting);
		RadioButton c21 = (RadioButton)findViewById(R.id.ch_21Setting);
		RadioButton c22 = (RadioButton)findViewById(R.id.ch_22Setting);
		RadioButton c23 = (RadioButton)findViewById(R.id.ch_23Setting);
		RadioButton c24 = (RadioButton)findViewById(R.id.ch_24Setting);
		RadioButton c25 = (RadioButton)findViewById(R.id.ch_25Setting);
		RadioButton c26 = (RadioButton)findViewById(R.id.ch_26Setting);
		RadioButton c27 = (RadioButton)findViewById(R.id.ch_27Setting);
		RadioButton c28 = (RadioButton)findViewById(R.id.ch_28Setting);
		RadioButton c29 = (RadioButton)findViewById(R.id.ch_29Setting);
		RadioButton c30 = (RadioButton)findViewById(R.id.ch_30Setting);
		
		SharedPreferences settings = getSharedPreferences(Constants.SETTINGS, 0);
		int diff = settings.getInt(Constants.CHAPTER, Constants.CH_01);
		
		switch (diff)
		{
		case Constants.CH_01 : 
			c1.toggle();
			break;
			
		case Constants.CH_02 : 
			c2.toggle();
			break;
			
		case Constants.CH_03 :
			c3.toggle();
			break;	
			
		case Constants.CH_04 : 
			c4.toggle();
			break;
			
		case Constants.CH_05 : 
			c5.toggle();
			break;
			
		case Constants.CH_06 :
			c6.toggle();
			break;
			
		case Constants.CH_61 :
			c61.toggle();
			break;
			
		case Constants.CH_07 : 
			c7.toggle();
			break;
			
		case Constants.CH_08 : 
			c8.toggle();
			break;
			
		case Constants.CH_09 :
			c9.toggle();
			break;
			
		case Constants.CH_10 : 
			c10.toggle();
			break;
			
		case Constants.CH_11 : 
			c11.toggle();
			break;
			
		case Constants.CH_12 :
			c12.toggle();
			break;
			
		case Constants.CH_13 : 
			c13.toggle();
			break;
			
		case Constants.CH_14 : 
			c14.toggle();
			break;
			
		case Constants.CH_15 :
			c15.toggle();
			break;
			
		case Constants.CH_16 : 
			c16.toggle();
			break;
			
		case Constants.CH_17 : 
			c17.toggle();
			break;
			
		case Constants.CH_18 :
			c18.toggle();
			break;
			
		case Constants.CH_19 : 
			c19.toggle();
			break;
			
		case Constants.CH_20 : 
			c20.toggle();
			break;
			
		case Constants.CH_21 :
			c21.toggle();
			break;
			
		case Constants.CH_22 : 
			c22.toggle();
			break;
			
		case Constants.CH_23 : 
			c23.toggle();
			break;
			
		case Constants.CH_24 :
			c24.toggle();
			break;
			
		case Constants.CH_25 : 
			c25.toggle();
			break;
			
		case Constants.CH_26 : 
			c26.toggle();
			break;
			
		case Constants.CH_27 :
			c27.toggle();
			break;
			
		case Constants.CH_28 : 
			c28.toggle();
			break;
			
		case Constants.CH_29 : 
			c29.toggle();
			break;
			
		case Constants.CH_30 :
			c30.toggle();
			break;
		}
	}





	public void onClick(View arg0) {
		/**
		 * check which settings set and return to menu
		 */
		if (!checkSelected())
		{
			return;
		}
		else
		{
			SharedPreferences settings = getSharedPreferences(Constants.SETTINGS, 0);
			Editor e = settings.edit();
			e.putInt(Constants.CHAPTER, getSelectedSetting());
			e.commit();
			finish();
		}
		
	}


	/**
	 * THE FOLLOWING FUNCTIONS MUST BE AMENDED WHEN THE DATABASE IS UPDATED WITH NEW CHAPTERS
	 * Method to check that a checkbox is selected
	 * 
	 * @return boolean
	 */
	private boolean checkSelected() {
		RadioButton c1 = (RadioButton)findViewById(R.id.ch_01Setting);
		RadioButton c2 = (RadioButton)findViewById(R.id.ch_02Setting);
		RadioButton c3 = (RadioButton)findViewById(R.id.ch_03Setting);
		RadioButton c4 = (RadioButton)findViewById(R.id.ch_04Setting);
		RadioButton c5 = (RadioButton)findViewById(R.id.ch_05Setting);
		RadioButton c6 = (RadioButton)findViewById(R.id.ch_06Setting);
		RadioButton c61 = (RadioButton)findViewById(R.id.ch_61Setting);
		RadioButton c7 = (RadioButton)findViewById(R.id.ch_07Setting);
		RadioButton c8 = (RadioButton)findViewById(R.id.ch_08Setting);
		RadioButton c9 = (RadioButton)findViewById(R.id.ch_09Setting);
		return (c1.isChecked() || c2.isChecked() || c3.isChecked() ||
				c4.isChecked() || c5.isChecked() || c6.isChecked() ||
				c61.isChecked() || c7.isChecked() || c8.isChecked() ||
				c9.isChecked()
				);
	}


	/**
	 * Get the selected setting 
	 */
	private int getSelectedSetting() {
		RadioButton c1 = (RadioButton)findViewById(R.id.ch_01Setting);
		RadioButton c2 = (RadioButton)findViewById(R.id.ch_02Setting);
		RadioButton c3 = (RadioButton)findViewById(R.id.ch_03Setting);
		RadioButton c4 = (RadioButton)findViewById(R.id.ch_04Setting);
		RadioButton c5 = (RadioButton)findViewById(R.id.ch_05Setting);
		RadioButton c6 = (RadioButton)findViewById(R.id.ch_06Setting);
		RadioButton c61 = (RadioButton)findViewById(R.id.ch_61Setting);
		RadioButton c7 = (RadioButton)findViewById(R.id.ch_07Setting);
		RadioButton c8 = (RadioButton)findViewById(R.id.ch_08Setting);
		RadioButton c9 = (RadioButton)findViewById(R.id.ch_09Setting);
		
		if (c1.isChecked())
		{
			return Constants.CH_01;
		}
		if (c2.isChecked())
		{
			return Constants.CH_02;
		}
		if (c3.isChecked())
		{
			return Constants.CH_03;
		}
		if (c4.isChecked())
		{
			return Constants.CH_04;
		}
		if (c5.isChecked())
		{
			return Constants.CH_05;
		}
		if (c6.isChecked())
		{
			return Constants.CH_06;
		}
		if (c61.isChecked())
		{
			return Constants.CH_61;
		}
		if (c7.isChecked())
		{
			return Constants.CH_07;
			
		}
		if (c8.isChecked())
		{
			return Constants.CH_08;
			
		}
		if (c9.isChecked())
		{
			return Constants.CH_09;
			
		}
		return 1;
	}
	
}
