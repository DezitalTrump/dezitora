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
import android.widget.TextView;



@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class Participation extends ActionBarActivity {

	
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
			View rootView = inflater.inflate(R.layout.participation,container, false);
			RelativeLayout layout = (RelativeLayout) rootView;
	        final Button button5 = (Button) layout.findViewById(R.id.button5);
	        final TextView playerName = (TextView) layout.findViewById(R.id.textView2);
	        

	        button5.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 自動生成されたメソッド・スタブ
					switch (v.getId()){
					case R.id.button5 :
						Intent intent = new Intent();
						intent.setClassName("trumpapp.com.example","trumpapp.com.example.StartMainActivity");
						startActivity(intent);
						
						break;
					}
				}
			});
	        
	        	playerName.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 自動生成されたメソッド・スタブ
					switch (v.getId()){
					case R.id.textView2 :
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