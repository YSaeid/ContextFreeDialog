package context.free.dialog.helper;

import androidx.fragment.app.FragmentActivity;

public class ActivityHolder {

    public static void init(FragmentActivity activity) {
        new ActivityUtils(activity, BuildContext.get());
    }

}
