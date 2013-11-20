package jp.goodnightcall.android;



import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class TalkingActivity extends Activity {

	Button mButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_talking2);

		mButton = (Button) findViewById(R.id.talking_call_cancel);

		mButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if( WaitingActivity.sPhone!=null ){
					WaitingActivity.sPhone.disconnect();
					WaitingActivity.sPhone = null;
				}
				finish();
			}
		});


	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.talking, menu);
		return true;
	}

}
