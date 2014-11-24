package trumpapp.com.example;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class Recruitment extends ActionBarActivity {

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Intent intent = getIntent();
        

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }
    

    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
			View rootView = inflater.inflate(R.layout.recruitment,container, false);
			RelativeLayout layout = (RelativeLayout) rootView;
			final Button Back = (Button) layout.findViewById(R.id.button3);
	        final Button Start = (Button) layout.findViewById(R.id.button4);
	       
	        	Back.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 自動生成されたメソッド・スタブ
					switch (v.getId()){
					case R.id.button3 :
						Intent intent = new Intent();
						intent.setClassName("trumpapp.com.example","trumpapp.com.example.StartMainActivity");
						startActivity(intent);
						
						break;
					}
				}
			});

	        Start.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 自動生成されたメソッド・スタブ
					switch (v.getId()){
					case R.id.button4 :
						Intent intent = new Intent();
						intent.setClassName("trumpapp.com.example","trumpapp.com.example.MainActivity");
						startActivity(intent);
						
						break;
					}
				}
			});
	        
			
			return rootView;
		}
    }
}