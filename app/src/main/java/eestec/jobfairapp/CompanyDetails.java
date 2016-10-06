package eestec.jobfairapp;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by XMAN on 6.10.2016.
 */
public class CompanyDetails extends ListView {
    public CompanyDetails(Context context) {
        super(context);
    }
    public CompanyDetails(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CompanyDetails(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private void init(){
    }

    @Override
    public void onDraw(Canvas canvas) {

        super.onDraw(canvas);
    }
}

