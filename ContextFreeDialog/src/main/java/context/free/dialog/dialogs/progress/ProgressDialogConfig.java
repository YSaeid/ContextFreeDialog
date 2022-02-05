package context.free.dialog.dialogs.progress;


import android.view.Gravity;

import androidx.annotation.ColorRes;
import androidx.annotation.StringRes;

import context.free.dialog.R;

public final class ProgressDialogConfig {


    private final int resIdProgressColor;
    private final int resIdMessage;
    private final TextGravity textGravity;
    private final ProgressGravity progressGravity;


    private ProgressDialogConfig(Builder builder) {
        this.resIdProgressColor = builder.resIdProgressColor;
        this.resIdMessage = builder.resIdMessage;
        this.textGravity = builder.textGravity;
        this.progressGravity = builder.progressGravity;
    }

    public static Builder builder() {
        return new Builder();
    }

    public int getProgressColor() {
        return resIdProgressColor;
    }

    public int getMessage() {
        return resIdMessage;
    }

    public TextGravity getTextGravity() {
        return textGravity;
    }

    public ProgressGravity getProgressGravity() {
        return progressGravity;
    }

    public static class Builder {

        private int resIdProgressColor = R.color.default_progress_indeterminate_color;
        private int resIdMessage = R.string.default_progress_dialog_message;
        private TextGravity textGravity = TextGravity.LEFT;
        private ProgressGravity progressGravity = ProgressGravity.LEFT;

//        public static Builder getBuilder() {
//            return new Builder();
//        }

        public Builder setProgressColor(@ColorRes int resIdColor) {
            this.resIdProgressColor = resIdColor;
            return this;
        }

        public Builder setMessage(@StringRes int resIdMessage) {
            this.resIdMessage = resIdMessage;
            return this;
        }

        public Builder setTextGravity(TextGravity textGravity) {
            this.textGravity = textGravity;
            return this;
        }

        public Builder setProgressGravity(ProgressGravity progressGravity) {
            this.progressGravity = progressGravity;
            return this;
        }

        public ProgressDialogConfig build() {
            return new ProgressDialogConfig(this);
        }

    }

    public enum TextGravity {
        LEFT, RIGHT
    }

    public enum ProgressGravity {
        LEFT, RIGHT
    }

}
