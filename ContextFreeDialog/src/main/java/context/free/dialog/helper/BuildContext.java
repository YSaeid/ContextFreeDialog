package context.free.dialog.helper;

import android.content.Context;

import androidx.fragment.app.FragmentActivity;

public class BuildContext {

    private ContextHelper contextHelper;
    private ActivityUtils activityUtils;

    private static final class ContextBuilderLoader {
        private static final BuildContext CONTEXT_BUILDER = new BuildContext();
    }

    public static BuildContext get() {
        return ContextBuilderLoader.CONTEXT_BUILDER;
    }

    public void setContextHelper(ContextHelper contextHelper) {
        this.contextHelper = contextHelper;
    }

    public void setActivityUtils(ActivityUtils activityUtils) {
        this.activityUtils = activityUtils;
    }

    public Context getContext() {
        return contextHelper.provideContext();
    }

    public FragmentActivity requireActivity() {
        return activityUtils.requireActivity();
    }
}
