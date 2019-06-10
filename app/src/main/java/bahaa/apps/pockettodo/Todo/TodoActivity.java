package bahaa.apps.pockettodo.Todo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import bahaa.apps.pockettodo.R;
import bahaa.apps.pockettodo.core.BaseActivity;

public class TodoActivity extends BaseActivity {
    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int contentViewLayoutRes() {
        return R.layout.activity_add_to_do;
    }

    @NonNull
    @Override
    protected Fragment createInitialFragment() {
        return TodoFragment.newInstance();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
