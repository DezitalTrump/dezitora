package com.example.android.btrev;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;

public class Drawer {
	private volatile int mWidth;

	public int getX(MotionEvent event) {
		int cellWH = mWidth / 8;
		return (int) (event.getX() / cellWH);
	}

	public int getY(MotionEvent event) {
		int cellWH = mWidth / 8;
		return (int) (event.getY() / cellWH);
	}

	public void paint(Canvas canvas, int[][] board) {
		if (mWidth == 0) {
			mWidth = canvas.getWidth();
		}
		Paint paint = new Paint();
		// ボードの描画
		paint.setColor(Color.GREEN);
		canvas.drawRect(new Rect(0, 0, mWidth, canvas.getHeight()), paint);
		paint.setColor(Color.BLACK);
		int cellWH = mWidth / 8;
		int offx = 0;
		int offy = 0;
		for (int i = 0; i <= 8; i ++) {
			canvas.drawLine(offx, offy, offx + cellWH * 8, offy, paint);
			offy += cellWH;
		}
		offy = 0;
		for (int i = 0; i <= 8; i++) {
			canvas.drawLine(offx, offy, offx, offy + cellWH * 8, paint);
			offx += cellWH;
		}

		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= 8; j++) {
				float left = (i - 1) * cellWH + 2 + 2;
				float top = (j - 1) * cellWH + 2 + 2;
				float right = left + cellWH - 4;
				float bottom = top + cellWH - 4;
				RectF oval = new RectF(left, top, right, bottom);
				if (board[i][j] == Board.COLOR_BLACK) {
					paint.setColor(Color.BLACK);
					canvas.drawArc(oval, 0, 360, false, paint);
				} else if (board[i][j] == Board.COLOR_WHITE) {
					paint.setColor(Color.WHITE);
					canvas.drawArc(oval, 0, 360, false, paint);
				}
			}
		}
	}
}
