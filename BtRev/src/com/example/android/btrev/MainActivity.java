package com.example.android.btrev;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	private final String TAG = getClass().getSimpleName();
	private Bt mBt;
	private final Drawer mDrawer = new Drawer();
	private ArrayAdapter<String> mCandidateServers;
	private ArrayAdapter<String> mServers;
	private View mView;
	private final Handler mHandler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mCandidateServers = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
		mServers = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
		mView = new View(this) {
			@Override
			protected void onDraw(Canvas canvas) {
				if (mBt.isConnected()) {
					mDrawer.paint(canvas, mBt.getBoard().board);
				}
			}
		};

		mView.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				int action = event.getAction();
				boolean result = false;
				if (MotionEvent.ACTION_DOWN == action && mBt.isConnected()) {
					result = true;
					int x = mDrawer.getX(event);
					int y = mDrawer.getY(event);
					Log.d(TAG, "onTouchEvent: x=" + event.getX() + "(" + x + ") y=" + event.getY() + "(" + y + ")");
					String message = mBt.getBoard().put(x, y);
					if (message != null) {
						invalidate();
						mBt.sendMessage(message);
					}
				}
				return result;
			}
		});
		mBt = new Bt(this, mCandidateServers, mServers);
		setContentView(mView);
	}

	@Override
	protected void onResume() {
		super.onResume();
		mBt.turnOn();
	}

	@Override
	protected void onPause() {
		super.onPause();
		mBt.cancel();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}


	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		int itemId = item.getItemId();
		if (itemId == R.id.menu_discoverable) {
			mBt.startDiscoverable();
		} else if (itemId == R.id.menu_start_server) {
			mBt.startServer();
		} else if (itemId == R.id.menu_search_server) {
			mCandidateServers.clear();
			ListView lv = new ListView(this);
			lv.setAdapter(mCandidateServers);
			lv.setScrollingCacheEnabled(false);
			final AlertDialog dialog = new AlertDialog.Builder(this)
			.setTitle(R.string.title_dialog)
			.setPositiveButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					mBt.cancelDiscovery();
				}
			})
			.setView(lv)
			.create();
			lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> items, View view, int position, long id) {
					dialog.dismiss();
					String address = mCandidateServers.getItem(position);
					if (mServers.getPosition(address) == -1) {
						mServers.add(address);
					}
					mBt.cancelDiscovery();
				}
			});
			dialog.show();
			mBt.searchServer();
		} else if (itemId == R.id.menu_connect) {
			ListView lv = new ListView(this);
			final AlertDialog dialog = new AlertDialog.Builder(this)
			.setTitle(R.string.title_dialog)
			.setPositiveButton(android.R.string.cancel, null)
			.setView(lv)
			.create();
			lv.setAdapter(mServers);
			lv.setScrollingCacheEnabled(false);
			lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> items, View view, int position, long id) {
					dialog.dismiss();
					String address = mServers.getItem(position);
					mBt.connect(address);
				}
			});
			dialog.show();
		}
		return true;
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		mBt.onActivityResult(requestCode, resultCode, data);
	}

	public void invalidate() {
		mHandler.post(new Runnable() {
			@Override
			public void run() {
				mView.invalidate();
			}
		});
	}
}
