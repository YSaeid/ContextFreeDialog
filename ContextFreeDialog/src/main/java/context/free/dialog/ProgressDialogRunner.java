package context.free.dialog;

import android.app.Dialog;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import context.free.dialog.dialogs.progress.ContextFreeProgressDialog;
import context.free.dialog.dialogs.progress.ProgressDialogConfig;
import context.free.dialog.helper.ActivityHolder;
import context.free.dialog.helper.ActivityUtils;
import context.free.dialog.helper.BuildContext;
import context.free.dialog.helper.ProgressDialogConfigHelper;


public class ProgressDialogRunner extends AppCompatActivity {

    private Dialog dialog;
    private ContextFreeProgressDialog contextFreeProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityHolder.init(this);
        dialog = ProgressDialogConfigHelper.getInstance().getDialog();
        ProgressDialogConfig config = ProgressDialogConfigHelper.getInstance().getProgressConfig();
        if (dialog == null) {
            if (config == null) {
                config = ProgressDialogConfig.builder().build();
            }
            contextFreeProgressDialog = new ContextFreeProgressDialog(this, R.style.Theme_Transparent, config);
            contextFreeProgressDialog.setOnDismissListener(d -> {
                d.dismiss();
                finish();
            });
            contextFreeProgressDialog.show();
        } else {
//            dialog.getContext().setTheme(R.style.Theme_Transparent);
            getWindow().setDimAmount(0f);
//            dialog.getWindow().setDimAmount(0f);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setCancelable(true);
            dialog.setOnDismissListener(dialog1 -> {
                dialog1.dismiss();
                finish();
            });
            dialog.show();
        }


    }

    public void dismiss() {
        if (dialog != null) {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
        } else {
            if (contextFreeProgressDialog != null) {
                if (contextFreeProgressDialog.isShowing()) {
                    contextFreeProgressDialog.dismiss();
                    finish();
                }
            }
        }
    }

    @Override
    public void onBackPressed() {
        dismiss();
        super.onBackPressed();
    }
}