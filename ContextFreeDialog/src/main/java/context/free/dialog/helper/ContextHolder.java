package context.free.dialog.helper;

import android.content.Context;

class ContextHolder {

    public static void init(Context context) {
        new ContextHelper(context, BuildContext.get());
    }

}
