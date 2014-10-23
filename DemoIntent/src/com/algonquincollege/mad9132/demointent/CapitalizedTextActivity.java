package com.algonquincollege.mad9132.demointent;

import util.StringUtil;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * Display plainMessage with all occurrences of letter in upper-case.
 *
 * @author Gerald.Hurdle@AlgonquinCollege.com
 *
 */
public class CapitalizedTextActivity extends Activity implements Constants {
	private EditText mCapitalizedText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_capitalized_text);

        Button clearButton = (Button) findViewById( R.id.button_plain );
		clearButton.setOnClickListener( new OnClickListener() {
			@Override
			public void onClick(View v) {
				mCapitalizedText.setText( "" );
			}
		});

		mCapitalizedText = (EditText) findViewById( R.id.text_plain );
		// Get the bundle of extras that was sent to this activity
		Bundle bundle = getIntent().getExtras();
		if ( bundle != null ) {
			String plainMessage = bundle.getString( THE_MESSAGE );
			char letter = bundle.getChar( THE_LETTER );
			mCapitalizedText.setText( StringUtil.capitalize(plainMessage, letter) );
		}
	}
}
