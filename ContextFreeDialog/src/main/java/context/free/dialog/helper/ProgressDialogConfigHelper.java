package context.free.dialog.helper;

import android.app.Dialog;

import context.free.dialog.dialogs.progress.ProgressDialogConfig;

public class ProgressDialogConfigHelper {

    public static final ProgressDialogConfigHelper CONFIG_HELPER = new ProgressDialogConfigHelper();
    private ProgressDialogConfig config;
    private Dialog dialog;

    public static ProgressDialogConfigHelper getInstance() {
        return CONFIG_HELPER;
    }

    public void setProgressConfig(ProgressDialogConfig config) {
        this.config = config;
    }

    public ProgressDialogConfig getProgressConfig() {
        return config;
    }

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }

    public Dialog getDialog() {
        return dialog;
    }
}
