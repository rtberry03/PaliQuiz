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
		RadioButton c061 = (RadioButton)findViewById(R.id.ch_061Setting);
		RadioButton c7 = (RadioButton)findViewById(R.id.ch_07Setting);
		RadioButton c8 = (RadioButton)findViewById(R.id.ch_08Setting);
		RadioButton c9 = (RadioButton)findViewById(R.id.ch_09Setting);
		RadioButton c10 = (RadioButton)findViewById(R.id.ch_10Setting);
		RadioButton c11 = (RadioButton)findViewById(R.id.ch_11Setting);
		RadioButton c111 = (RadioButton)findViewById(R.id.ch_111Setting);
		RadioButton c12 = (RadioButton)findViewById(R.id.ch_12Setting);
		RadioButton c13 = (RadioButton)findViewById(R.id.ch_13Setting);
		RadioButton c131 = (RadioButton)findViewById(R.id.ch_131Setting);
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
		RadioButton c291 = (RadioButton)findViewById(R.id.ch_291Setting);
		RadioButton c30 = (RadioButton)findViewById(R.id.ch_30Setting);
		RadioButton c31 = (RadioButton)findViewById(R.id.ch_31Setting);
		RadioButton c32 = (RadioButton)findViewById(R.id.ch_32Setting);
		RadioButton c321 = (RadioButton)findViewById(R.id.ch_321Setting);
		RadioButton c322 = (RadioButton)findViewById(R.id.ch_322Setting);
		
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
			
		case Constants.CH_061 :
			c061.toggle();
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
			
		case Constants.CH_111 : 
			c111.toggle();
			break;
			
		case Constants.CH_12 :
			c12.toggle();
			break;
			
		case Constants.CH_13 : 
			c13.toggle();
			break;
			
		case Constants.CH_131 : 
			c131.toggle();
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
			
		case Constants.CH_291 : 
			c291.toggle();
			break;
			
		case Constants.CH_30 :
			c30.toggle();
			break;
			
		case Constants.CH_31 : 
			c31.toggle();
			break;
			
		case Constants.CH_32 : 
			c32.toggle();
			break;
			
		case Constants.CH_321 : 
			c321.toggle();
			break;
			
		case Constants.CH_322 : 
			c322.toggle();
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
		RadioButton c061 = (RadioButton)findViewById(R.id.ch_061Setting);
		RadioButton c7 = (RadioButton)findViewById(R.id.ch_07Setting);
		RadioButton c8 = (RadioButton)findViewById(R.id.ch_08Setting);
		RadioButton c9 = (RadioButton)findViewById(R.id.ch_09Setting);
		RadioButton c10 = (RadioButton)findViewById(R.id.ch_10Setting);
		RadioButton c11 = (RadioButton)findViewById(R.id.ch_11Setting);
		RadioButton c111 = (RadioButton)findViewById(R.id.ch_111Setting);
		RadioButton c12 = (RadioButton)findViewById(R.id.ch_12Setting);
		RadioButton c13 = (RadioButton)findViewById(R.id.ch_13Setting);
		RadioButton c131 = (RadioButton)findViewById(R.id.ch_131Setting);
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
		RadioButton c291 = (RadioButton)findViewById(R.id.ch_291Setting);
		RadioButton c30 = (RadioButton)findViewById(R.id.ch_30Setting);
		RadioButton c31 = (RadioButton)findViewById(R.id.ch_21Setting);
		RadioButton c32 = (RadioButton)findViewById(R.id.ch_22Setting);
		RadioButton c321 = (RadioButton)findViewById(R.id.ch_321Setting);
		RadioButton c322 = (RadioButton)findViewById(R.id.ch_322Setting);
			
		
		
		return (c1.isChecked() || c2.isChecked() || c3.isChecked() || 
				c4.isChecked() || c5.isChecked() || c6.isChecked() || 
				c061.isChecked() || c7.isChecked() || c8.isChecked() ||
				c9.isChecked() || c10.isChecked() || c11.isChecked() ||	
				c111.isChecked() ||	c12.isChecked() || c13.isChecked() || 
				c131.isChecked() ||	c14.isChecked() || c15.isChecked() || 
				c16.isChecked() || c17.isChecked() || c18.isChecked() || 
				c19.isChecked() || c20.isChecked() || c21.isChecked() || 
				c22.isChecked() || c23.isChecked() || c24.isChecked() || 
				c25.isChecked() || c26.isChecked() || c27.isChecked() || 
				c28.isChecked() || c29.isChecked() || c291.isChecked() ||
				c30.isChecked() || c31.isChecked() || c32.isChecked() || 
				c321.isChecked() || c322.isChecked());
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
		RadioButton c061 = (RadioButton)findViewById(R.id.ch_061Setting);
		RadioButton c7 = (RadioButton)findViewById(R.id.ch_07Setting);
		RadioButton c8 = (RadioButton)findViewById(R.id.ch_08Setting);
		RadioButton c9 = (RadioButton)findViewById(R.id.ch_09Setting);
		RadioButton c10 = (RadioButton)findViewById(R.id.ch_10Setting);
		RadioButton c11 = (RadioButton)findViewById(R.id.ch_11Setting);
		RadioButton c111 = (RadioButton)findViewById(R.id.ch_111Setting);
		RadioButton c12 = (RadioButton)findViewById(R.id.ch_12Setting);
		RadioButton c13 = (RadioButton)findViewById(R.id.ch_13Setting);
		RadioButton c131 = (RadioButton)findViewById(R.id.ch_131Setting);
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
		RadioButton c291 = (RadioButton)findViewById(R.id.ch_291Setting);
		RadioButton c30 = (RadioButton)findViewById(R.id.ch_30Setting);
		RadioButton c31 = (RadioButton)findViewById(R.id.ch_31Setting);
		RadioButton c32 = (RadioButton)findViewById(R.id.ch_32Setting);
		RadioButton c321 = (RadioButton)findViewById(R.id.ch_321Setting);
		RadioButton c322 = (RadioButton)findViewById(R.id.ch_322Setting);
		
				
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
		if (c061.isChecked())
		{
			return Constants.CH_061;
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
		if (c10.isChecked())
		{
			return Constants.CH_10;
		}
		if (c11.isChecked())
		{
			return Constants.CH_11;
		}
		if (c111.isChecked())
		{
			return Constants.CH_111;
		}
		if (c12.isChecked())
		{
			return Constants.CH_12;
		}
		if (c13.isChecked())
		{
			return Constants.CH_13;
		}
		if (c131.isChecked())
		{
			return Constants.CH_131;
		}
		if (c14.isChecked())
		{
			return Constants.CH_14;
		}
		if (c15.isChecked())
		{
			return Constants.CH_15;
		}
		if (c16.isChecked())
		{
			return Constants.CH_16;
		}
		if (c17.isChecked())
		{
			return Constants.CH_17;
		}
		if (c18.isChecked())
		{
			return Constants.CH_18;
		}
		if (c19.isChecked())
		{
			return Constants.CH_19;
		}
		if (c20.isChecked())
		{
			return Constants.CH_20;
		}
		if (c21.isChecked())
		{
			return Constants.CH_21;
		}
		if (c22.isChecked())
		{
			return Constants.CH_22;
		}
		if (c23.isChecked())
		{
			return Constants.CH_23;
		}
		if (c24.isChecked())
		{
			return Constants.CH_24;
		}
		if (c25.isChecked())
		{
			return Constants.CH_25;
		}	
		if (c26.isChecked())
		{
			return Constants.CH_26;
		}
		if (c27.isChecked())
		{
			return Constants.CH_27;
		}
		if (c28.isChecked())
		{
			return Constants.CH_28;
		}
		if (c29.isChecked())
		{
			return Constants.CH_29;
		}
		if (c291.isChecked())
		{
			return Constants.CH_291;
		}	
		if (c30.isChecked())
		{
			return Constants.CH_30;
		}
		if (c31.isChecked())
		{
			return Constants.CH_31;
		}
		if (c32.isChecked())
		{
			return Constants.CH_32;
		}
		if (c321.isChecked())
		{
			return Constants.CH_321;
		}
		if (c322.isChecked())
		{
			return Constants.CH_322;
		}
		
		return 1;
	}
	
}
