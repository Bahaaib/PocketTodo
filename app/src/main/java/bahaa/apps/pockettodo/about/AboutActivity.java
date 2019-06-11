package bahaa.apps.pockettodo.about;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import bahaa.apps.pockettodo.R;
import bahaa.apps.pockettodo.core.BaseActivity;
import bahaa.apps.pockettodo.main.MainActivity;
import bahaa.apps.pockettodo.main.MainFragment;

public class AboutActivity extends BaseActivity {
    private TextView mVersionTextView;
    private String appVersion = "0.1";
    private Toolbar toolbar;
    private TextView contactMe;
    String theme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        theme = getSharedPreferences(MainFragment.THEME_PREFERENCES, MODE_PRIVATE).getString(MainFragment.THEME_SAVED, MainFragment.LIGHTTHEME);
        if (theme.equals(MainFragment.DARKTHEME)) {
            Log.d("Statuss", "One");
            setTheme(R.style.CustomStyle_DarkTheme);
        } else {
            Log.d("Statuss", "One");
            setTheme(R.style.CustomStyle_LightTheme);
        }

        super.onCreate(savedInstanceState);

        final Drawable backArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        if (backArrow != null) {
            backArrow.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        }
        try {
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), 0);
            appVersion = info.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(backArrow);
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(AboutActivity.this, MainActivity.class);
                main.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(main);
            }
        });
    }

    @Override
    protected int contentViewLayoutRes() {
        return R.layout.about_layout;
    }

    @NonNull
    protected Fragment createInitialFragment() {
        return AboutFragment.newInstance();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (NavUtils.getParentActivityName(this) != null) {
                    NavUtils.navigateUpFromSameTask(this);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
