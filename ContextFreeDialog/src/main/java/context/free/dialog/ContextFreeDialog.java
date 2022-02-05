package context.free.dialog;

import android.content.Intent;

import context.free.dialog.helper.BuildContext;

public class ContextFreeDialog {

    public static void show() {
        Intent intent = new Intent(BuildContext.get().getContext(), ProgressDialogRunner.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        BuildContext.get().getContext().startActivity(intent);
    }

    public static void dismiss() {
        if (BuildContext.get().requireActivity() instanceof ProgressDialogRunner) {
            ((ProgressDialogRunner) BuildContext.get().requireActivity()).dismiss();
        }
    }
}
