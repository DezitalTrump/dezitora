package trumpapp.com.example;

//import com.example.helloworld.R;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MainActivity extends ActionBarActivity {
	private final String TAG = getClass().getSimpleName();
	//private Bt mBt;
	//private final Drawer mDrawer = new Drawer();
	private ArrayAdapter<String> mCandidateServers;
	private ArrayAdapter<String> mServers;
	private View mView;
	private final Handler mHandler = new Handler();
	
	
	

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        	
        mCandidateServers = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
    		mServers = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
 
        
        Intent intent = getIntent();
         if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }
    
    //@Override
    

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
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            RelativeLayout layout = (RelativeLayout) rootView;
            //final ImageView imageView1 = (ImageView) layout.findViewById(R.id.imageView1);
            final Button button1 = (Button) layout.findViewById(R.id.button1);
            final Button button2 = (Button) layout.findViewById(R.id.button2);
            final ImageView[] tehuda1 =new ImageView[13];
            final ImageView[] tehuda2 =new ImageView[13];
            
            
            int[] cardsIDarray = new int[] {R.id.iv0, R.id.iv1, R.id.iv2,R.id.iv3, R.id.iv4, R.id.iv5, R.id.iv6,
            								R.id.iv7, R.id.iv8, R.id.iv9,R.id.iv10, R.id.iv11, R.id.iv12,R.id.iv13,
            								R.id.iv14, R.id.iv15, R.id.iv16, R.id.iv17, R.id.iv18, R.id.iv19,
            								R.id.iv20, R.id.iv21, R.id.iv22,R.id.iv23, R.id.iv24, R.id.iv25};
           
            for(int i=0;i<13;i++)
              tehuda1[i] = (ImageView)layout.findViewById(cardsIDarray[i]);
            for(int i=0;i<13;i++)
                tehuda2[i] = (ImageView)layout.findViewById(cardsIDarray[i+13]);
            

            

            
            button1.setOnClickListener(new OnClickListener() {
			           
				@Override
				public void onClick(View v) {
					// TODO 自動生成されたメソッド・スタブ
				TypedArray cardsarray = getResources().obtainTypedArray(R.array.cards);
				
				boolean[] tehudacheck = new boolean[26];
				for(int i=0;i<26;i++){
					tehudacheck[i]=false;
					
				}
				int i;
			for(int j=0;j<13;j++){
				
				do{
				i = (int) (Math.floor(Math.random() * 26));
				}while(tehudacheck[i]==true);
				tehudacheck[i]=true;
				
				 Drawable drawable = cardsarray.getDrawable(i);
				 tehuda1[j].setImageDrawable(drawable);
			}
			for(int j=0;j<13;j++){
				
				do{
				i = (int) (Math.floor(Math.random() * 26));
				}while(tehudacheck[i]==true);
				tehudacheck[i]=true;
				
				 Drawable drawable = cardsarray.getDrawable(i);
				 tehuda2[j].setImageDrawable(drawable);
			}
				 
				 
				 
				 
				}
				
				
				});
            
            button2.setOnClickListener(new OnClickListener() {
		           
				@Override
				public void onClick(View v) {
					switch (v.getId()){
					case R.id.button2 :
						Intent intent = new Intent();
						intent.setClassName("trumpapp.com.example","trumpapp.com.example.StartMainActivity");
						startActivity(intent);
						break;
					}
					 
				}
				
				
				});
            
            
            
            /*imageView1.setOnTouchListener(new View.OnTouchListener() {
				
            	private int ox;
            	private int oy;
            	
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					// TODO 自動生成されたメソッド・スタブ
					int x = (int)event.getRawX();
					int y = (int)event.getRawY();
					
					switch(event.getAction()){
					case MotionEvent.ACTION_MOVE:
						int diffx = imageView1.getLeft() + (x - ox);
						int diffy = imageView1.getTop() + (y - oy);
						imageView1.layout(diffx, diffy, diffx + imageView1.getWidth(), diffy + imageView1.getHeight());
						
						break;
					
					}
					ox = x;
					oy = y;
					
					
					return true;
				}
			}) ;
            */
            
            return rootView;
        }

	
    }

}
