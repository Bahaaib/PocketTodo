package bahaa.apps.pockettodo.main;

import android.support.v7.widget.RecyclerView;
import android.util.Log;

public abstract class CustomRecyclerviewListener extends RecyclerView.OnScrollListener {
    int scrollDist = 0;
    boolean isVisible = true;
    static final float MINIMUM = 20;

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        if (isVisible && scrollDist > MINIMUM) {
            Log.d("Statuss", "Hide " + scrollDist);
            hide();
            scrollDist = 0;
            isVisible = false;
        } else if (!isVisible && scrollDist < -MINIMUM) {
            Log.d("Statuss", "Show " + scrollDist);
            show();
            scrollDist = 0;
            isVisible = true;
        }
        if ((isVisible && dy > 0) || (!isVisible && dy < 0)) {
            Log.d("Statuss", "Add Up " + scrollDist);
            scrollDist += dy;
        }
    }

    public abstract void show();

    public abstract void hide();
}