package bahaa.apps.pockettodo.about;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import bahaa.apps.pockettodo.R;
import bahaa.apps.pockettodo.core.BaseFragment;

public class AboutFragment extends BaseFragment {
    private TextView mVersionTextView;
    private String appVersion = "0.1";
    private Toolbar toolbar;
    private TextView contactMe;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mVersionTextView = (TextView) view.findViewById(R.id.aboutVersionTextView);
        mVersionTextView.setText(String.format(getResources().getString(R.string.app_version), appVersion));
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);

        contactMe = (TextView) view.findViewById(R.id.aboutContactMe);

        contactMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    @LayoutRes
    protected int layoutRes() {
        return R.layout.fragment_about;
    }

    public static AboutFragment newInstance() {
        return new AboutFragment();
    }
}
