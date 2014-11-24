package trumpapp.com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class StartMainActivity extends ActionBarActivity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.startactivity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.startfragment_main,container, false);
			RelativeLayout layout = (RelativeLayout) rootView;
	        final Button button = (Button) layout.findViewById(R.id.button);
	        final Button button1 = (Button) layout.findViewById(R.id.button1);
	        final EditText name = (EditText) layout.findViewById(R.id.editText1);
	        

	        button.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 自動生成されたメソッド・スタブ
					switch (v.getId()){
					case R.id.button :
						Intent intent = new Intent();
						intent.setClassName("trumpapp.com.example","trumpapp.com.example.Recruitment");
						startActivity(intent);
						
						break;
					}
				}
			});
	        
	        
	        button1.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 自動生成されたメソッド・スタブ
					switch (v.getId()){
					case R.id.button1 :
						Intent intent = new Intent();
						intent.setClassName("trumpapp.com.example","trumpapp.com.example.Participation");
						startActivity(intent);
						
						break;
					}
				}
			});
			
			return rootView;
		}

		protected Activity getContext() {
			// TODO 自動生成されたメソッド・スタブ
			return null;
		}
	}

}
