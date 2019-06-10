package bahaa.apps.pockettodo.remainder;

import android.os.Bundle;
import android.support.annotation.NonNull;

import bahaa.apps.pockettodo.R;
import bahaa.apps.pockettodo.core.BaseActivity;

public class ReminderActivity extends BaseActivity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int contentViewLayoutRes() {
        return R.layout.reminder_layout;
    }

    @NonNull
    @Override
    protected ReminderFragment createInitialFragment() {
        return ReminderFragment.newInstance();
    }
}
