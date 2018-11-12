package cc.brainbook.view.checkableframelayout;

/**
 * Description.
 *
 * @author Robert Han
 * @email brainbook.cc@outlook.com
 * @website www.brainbook.cc
 * @time 2018/7/12 13:05
 */

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;

public class CheckableFrameLayout extends FrameLayout implements Checkable {

    public CheckableFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private boolean mChecked = false;

    @Override
    public void toggle() {
        setChecked(!mChecked);
    }

    @Override
    public boolean isChecked() {
        return mChecked;
    }

    @Override
    public void setChecked(boolean checked) {
        if (mChecked != checked) {
            mChecked = checked;
            refreshDrawableState();
            for (int i = 0, len = getChildCount(); i < len; i++) {
                final View child = getChildAt(i);
                if (child instanceof Checkable) {
                    ((Checkable) child).setChecked(checked);
                }
            }
        }
    }
}

