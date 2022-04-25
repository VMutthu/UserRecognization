/*
 * FaceSDK Library Sample
 * Copyright (C) 2020 Luxand, Inc.
 * 
 * FaceImageView - display photo and mark faces
 */

package com.example.userrecognization;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.luxand.FSDK;
import com.luxand.FSDK.TFacePosition;
import com.luxand.FSDK.TFaces;

@SuppressLint("AppCompatCustomView")
public class FaceImageView extends ImageView {
	private Paint painter;
    public TFaces detectedFaces;
    public int faceImageWidthOrig;
	long mTouchedID;
	String templatePath;
    
	public void Init() {
		faceImageWidthOrig = 0;
		detectedFaces = new TFaces();
		painter = new Paint();
        painter.setColor(Color.GREEN);
        painter.setStrokeWidth(1);
        painter.setStyle(Paint.Style.STROKE);

	}
	
	public FaceImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		Init();
	}
	public FaceImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		Init();
	}
	public FaceImageView(Context context) {
		super(context);
		Init();
	}

	
	//display detected faces
	public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        
		if (faceImageWidthOrig > 0 && detectedFaces.faces != null) {
			//scale detected face
	        int displayedWidth = this.getWidth();
	        //int displayedHeight = this.getHeight();

			for (TFacePosition detectedFace : detectedFaces.faces) {
				double ratio = displayedWidth / (faceImageWidthOrig * 1.0);
				int xc = (int) (detectedFace.xc * ratio);
				int yc = (int) (detectedFace.yc * ratio);
				int w = (int) (detectedFace.w * ratio);
				mTouchedID = 1;
				String name = "muthu";

				//draw detected face
				canvas.drawRect(xc - w / 2, yc - w / 2, xc + w / 2, yc + w / 2, painter);

			}
        }
    }
	
	//remove white borders of image to mark face correctly
	@Override 
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
         Drawable drawable = getDrawable();
         if (drawable != null) {
                 int width = MeasureSpec.getSize(widthMeasureSpec);
                 int height = (int) Math.ceil((float) width * (float) drawable.getIntrinsicHeight() / (float) drawable.getIntrinsicWidth());
                 setMeasuredDimension(width, height);
         } else {
                 super.onMeasure(widthMeasureSpec, heightMeasureSpec);
         }
    }
}
