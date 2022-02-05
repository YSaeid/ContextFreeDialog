package context.free.dialog.helper;

import android.content.Context;

class ContextHelper implements ContextProvider<Context> {

    private final Context context;
    private final BuildContext buildContext;

    public ContextHelper(Context context, BuildContext buildContext) {
        this.context = context;
        this.buildContext = buildContext;
        init();
    }

    private void init() {
        buildContext.setContextHelper(this);
    }

    @Override
    public Context provideContext() {
        return context;
    }

}
