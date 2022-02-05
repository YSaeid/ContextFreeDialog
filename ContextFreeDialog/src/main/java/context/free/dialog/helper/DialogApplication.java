package context.free.dialog.helper;

import android.app.Application;

public class DialogApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ContextHolder.init(this);
    }
}
