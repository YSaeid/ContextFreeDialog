package context.free.dialog.dialogs.progress;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.graphics.drawable.DrawableCompat;

import com.google.android.material.textview.MaterialTextView;

import context.free.dialog.databinding.DialogProgressBinding;

public class ContextFreeProgressDialog extends Dialog {

    private final Resources resources;
    private final ProgressDialogConfig config;

    public ContextFreeProgressDialog(@NonNull Context context, int themeResId, ProgressDialogConfig config) {
        super(context, themeResId);
        this.resources = context.getResources();
        this.config = config;
    }

    public Resources getResources() {
        return resources;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DialogProgressBinding binding = DialogProgressBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        ConstraintSet constraintSet = new ConstraintSet();
        ConstraintLayout layout = binding.constraintLayout;
        ProgressBar progressBar = binding.circularProgress;
        MaterialTextView message = binding.message;
        constraintSet.clear(progressBar.getId());
        constraintSet.clear(message.getId());
        int _16dp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16f, getResources().getDisplayMetrics());
        int _32dp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 32f, getResources().getDisplayMetrics());
        switch (config.getProgressGravity()) {
            case LEFT:
                constraintSet.clone(layout);
                constraintSet.connect(progressBar.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, _32dp);
                constraintSet.connect(progressBar.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, _32dp);
                constraintSet.connect(progressBar.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, _32dp);
                constraintSet.connect(message.getId(), ConstraintSet.START, progressBar.getId(), ConstraintSet.END, _16dp);
                constraintSet.connect(message.getId(), ConstraintSet.TOP, progressBar.getId(), ConstraintSet.TOP, _32dp);
                constraintSet.connect(message.getId(), ConstraintSet.BOTTOM, progressBar.getId(), ConstraintSet.BOTTOM, _32dp);
                constraintSet.connect(message.getId(), ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, _32dp);
                constraintSet.constrainedWidth(message.getId(), true);
                constraintSet.applyTo(layout);
                break;
            case RIGHT:
                constraintSet.clone(layout);
                constraintSet.connect(progressBar.getId(), ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, _32dp);
                constraintSet.connect(progressBar.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, _32dp);
                constraintSet.connect(progressBar.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, _32dp);
                constraintSet.setHorizontalBias(progressBar.getId(), 1f);
                constraintSet.connect(message.getId(), ConstraintSet.END, progressBar.getId(), ConstraintSet.START, _16dp);
                constraintSet.connect(message.getId(), ConstraintSet.TOP, progressBar.getId(), ConstraintSet.TOP, _32dp);
                constraintSet.connect(message.getId(), ConstraintSet.BOTTOM, progressBar.getId(), ConstraintSet.BOTTOM, _32dp);
                constraintSet.connect(message.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, _32dp);
                constraintSet.constrainedWidth(message.getId(), true);
                constraintSet.applyTo(layout);
                break;
        }
        switch (config.getTextGravity()) {
            case RIGHT:
                message.setGravity(Gravity.RIGHT);
                break;
            case LEFT:
                message.setGravity(Gravity.LEFT);
                break;
        }
        DrawableCompat.setTint(binding.circularProgress.getIndeterminateDrawable(), getResources().getColor(config.getProgressColor()));
        binding.message.setText(resources.getText(config.getMessage()));
    }
}
