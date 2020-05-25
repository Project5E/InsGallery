package com.luck.picture.lib.instagram;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * ================================================
 * Created by JessYan on 2020/4/17 11:41
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public class InstagramCaptureButton extends View {
    private static final int OUTSIDE_PRESS_COLOR = 0xFFCCCCCC;
    private static final int OUTSIDE_NORMAL_COLOR = 0xFFEEEEEE;
    private static final int CENTER_PRESS_COLOR = 0xFFF5DA41;
    private static final int CENTER_NORMAL_COLOR = 0xFFFDE662;
    private Paint mPaint;
    private int insideColor = Color.WHITE;
    private int outsideColor = OUTSIDE_NORMAL_COLOR;
    private int centerColor = CENTER_NORMAL_COLOR;
    private float center_x;
    private float center_y;
    private float buttonRadius;
    private float buttonOutsideRadius;
    private float buttonInsideRadius;
    private float buttonCenterRadius;
    private boolean isPress;

    public InstagramCaptureButton(Context context) {
        super(context);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        center_x = getMeasuredWidth() / 2f;
        center_y = getMeasuredHeight() / 2f;
        buttonRadius = getMeasuredWidth() / 2f;
        buttonOutsideRadius = buttonRadius;
        buttonInsideRadius = buttonRadius * 0.75f;
        buttonCenterRadius = buttonRadius * 0.55f;
    }

    public void pressButton(boolean isPress) {
        if (this.isPress == isPress) {
            return;
        }
        this.isPress = isPress;
        if (isPress) {
            outsideColor = OUTSIDE_PRESS_COLOR;
            centerColor = CENTER_PRESS_COLOR;
        } else {
            outsideColor = OUTSIDE_NORMAL_COLOR;
            centerColor = CENTER_NORMAL_COLOR;
        }
        invalidate();
    }

    public boolean isPress() {
        return isPress;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setColor(outsideColor);
        canvas.drawCircle(center_x, center_y, buttonOutsideRadius, mPaint);
        mPaint.setColor(insideColor);
        canvas.drawCircle(center_x, center_y, buttonInsideRadius, mPaint);
        mPaint.setColor(centerColor);
        canvas.drawCircle(center_x, center_y, buttonCenterRadius, mPaint);
    }
}
