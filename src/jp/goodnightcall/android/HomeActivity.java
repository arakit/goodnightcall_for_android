package jp.goodnightcall.android;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class HomeActivity extends Activity  implements View.OnClickListener{

	//�ϐ��錾
	private Button mCallBtn;
	private ImageButton mSettingBtn;
	private TextView mNameView;


//    private MonkeyPhone phone;
//    private EditText numberField;



	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_home);

		mNameView = (TextView) findViewById(R.id.home_name);
		mNameView.setText("はる");


		mCallBtn=(Button)findViewById(R.id.home_call);
		mCallBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(HomeActivity.this, WaitingActivity.class);
				intent.putExtra("phone_number", "+818035259682");
				startActivity(intent);
			}
		});

		mSettingBtn=(ImageButton)findViewById(R.id.home_setting_btn);
		mSettingBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent intent = new Intent(HomeActivity.this, SettingActivity.class);
				startActivity(intent);
			}
		});
	}



    @Override
    public void onClick(View view)
    {
//    	if (view.getId() == R.id.dialButton)
//    		phone.connect(numberField.getText().toString());
//        else if (view.getId() == R.id.hangupButton)
//            phone.disconnect();
    }




	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.top, menu);
		return false;
	}



}
