package context.free.dialog.helper;

import androidx.fragment.app.FragmentActivity;

public class ActivityUtils implements ActivityProvider {

    private final FragmentActivity activity;
    private final BuildContext buildContext;

    public ActivityUtils(FragmentActivity activity, BuildContext buildContext) {
        this.activity = activity;
        this.buildContext = buildContext;
        init();
    }

    private void init() {
        buildContext.setActivityUtils(this);
    }

    @Override
    public FragmentActivity requireActivity() {
        return activity;
    }
}
