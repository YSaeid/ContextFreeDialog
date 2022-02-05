package context.free.dialog;

import android.app.Dialog;

import context.free.dialog.dialogs.progress.ProgressDialogConfig;
import context.free.dialog.helper.ProgressDialogConfigHelper;

public class ContextFreeDialogConfig {

    public static void setProgressDialogConfig(ProgressDialogConfig config) {
        ProgressDialogConfigHelper.getInstance().setProgressConfig(config);
    }

    public static void setCustomProgressDialog(Dialog customProgressDialog) {
        ProgressDialogConfigHelper.getInstance().setDialog(customProgressDialog);
    }

}
