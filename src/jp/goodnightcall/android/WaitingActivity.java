package jp.goodnightcall.android;


import jp.crudefox.chikara.util.CFUtil;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.twilio.example.hellomonkey.MonkeyPhone;

public class WaitingActivity extends Activity {

	private Handler mHandler = new Handler();

    private MonkeyPhone mPhone;

    public static MonkeyPhone sPhone;

    private String mPhpneNumber;


    private Button mCancelBtn;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_waiting);

		Bundle args = getIntent().getExtras();

		String phone_number = mPhpneNumber = args.getString("phone_number");

		mCancelBtn = (Button) findViewById(R.id.waiting_call_cancel);

		CFUtil.Log("phone_number = "+mPhpneNumber);

		mPhone = new MonkeyPhone(getApplicationContext());
		sPhone = mPhone;


		mCancelBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try{
					if(mPhone!=null){
						mPhone.disconnect();
						mPhone = null;
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				finish();
			}
		});
	}



	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
	}


	@Override
	protected void onStart() {
		super.onStart();

		mHandler.postDelayed(new Runnable() {
			@Override
			public void run() {
				if(mPhone!=null){
					CFUtil.Log("connect" + mPhpneNumber);
					mPhone.connect(mPhpneNumber);
					mPhone = null;

					mHandler.postDelayed(new Runnable() {
						@Override
						public void run() {
							Intent intent = new Intent(WaitingActivity.this, TalkingActivity.class);
							startActivity(intent);
						}
					}, 10000);

				}
			}
		}, 5000);


	}


	@Override
	protected void onStop() {
		super.onStop();

		if(mPhone!=null){
			mPhone.disconnect();
		}

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.waiting, menu);
		return true;
	}

}
