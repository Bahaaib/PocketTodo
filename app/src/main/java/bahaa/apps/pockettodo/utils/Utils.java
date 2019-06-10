package bahaa.apps.pockettodo.utils;

import android.content.Context;
import android.content.res.TypedArray;

import bahaa.apps.pockettodo.R;

public class Utils {
    public static int getToolbarHeight(Context context) {
        final TypedArray styledAttributes = context.getTheme().obtainStyledAttributes(
                new int[]{R.attr.actionBarSize});
        int toolbarHeight = (int) styledAttributes.getDimension(0, 0);
        styledAttributes.recycle();

        return toolbarHeight;
    }
}
