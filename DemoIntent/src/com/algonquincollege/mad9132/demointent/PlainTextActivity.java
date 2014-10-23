package com.algonquincollege.mad9132.demointent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Demo Android's Intent.
 *
 * Usage: enter some text, click the settings menu item and select the letter you wish to
 *        capitalize, and perform a long-press.
 *        Click the Clear button to clear the text.
 *
 * Navigation: PlainTextActivity --- LONG PRESS ---> CapitalizedTextActivity
 *
 * Features:
 *     two (multiple) activities
 *     intent
 *     CharacterPickerDialog (a specialized picker as a dialog)
 *     handling long-press events
 *     event handling by implementing an interface
 *     event handling with an anonymous inner class
 *
 * Limitations:
 *     the lab is very, very different from this demo; simply renaming (er, refactoring) project
 *         "Demo" to "Lab" is 0 (zero)
 *     DO study this demo to learn
 *     DO apply what you've learned from this demo to build the lab :)
 *     there is only one intent from PlainTextActivity to CapitalizedTextActivity
 *     THEREFORE, I challenge you to implement the other intent to go from CapitalizedTextActivity
 *         back to PlainTextActivity & display the message with all occurrences of the selected
 *         letter in lower-case.
 *     the toast messages should be externalized
 *
 * @author Gerald.Hurdle@AlgonquinCollege.com
 *
 */
public class PlainTextActivity extends Activity implements Constants, OnLongClickListener {
	private char                  mLetter;
	private CharacterPickerDialog mLetterDialog;
	private EditText              mPlainText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_plain_text);

		mLetter = DEFAULT_LETTER;

        mLetterDialog = new CharacterPickerDialog(this, new View(this), null, LETTERS, false) {
        	@Override
            public void onClick(View v) {
        		int index = LETTERS.indexOf( ((Button)v).getText().toString() );
        		if ( index >= 0 ) {
        			mLetter = LETTERS.charAt( index );
        		}
            	dismiss();
            }
        };

        Button clearButton = (Button) findViewById( R.id.button_plain );
		clearButton.setOnClickListener( new OnClickListener() {
			@Override
			public void onClick(View v) {
				mPlainText.setText( "" );
			}
		});

		mPlainText = (EditText) findViewById( R.id.text_plain );

		findViewById( R.id.activity_plain ).setOnLongClickListener( this );
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.plain_text, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_author) {
			return true;
		}
		if (id == R.id.action_settings) {
			mLetterDialog.show();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onLongClick(View v) {
	    String plainText = mPlainText.getText().toString();
	    if ( plainText.isEmpty() ) {
			Toast.makeText(getApplicationContext(), "Empty Message!", Toast.LENGTH_LONG).show();
			return false;
	    }
	    
	    Intent intent = new Intent( getApplicationContext(), CapitalizedTextActivity.class );
	    intent.setFlags( Intent.FLAG_ACTIVITY_CLEAR_TOP );
	    intent.putExtra( THE_MESSAGE, plainText );
	    intent.putExtra( THE_LETTER, mLetter );
	    startActivity( intent );
	    
	    return false;
	}
}
