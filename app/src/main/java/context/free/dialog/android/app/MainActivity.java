package context.free.dialog.android.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetFileDescriptor;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.AndroidCharacter;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;

import context.free.dialog.ContextFreeDialog;
import context.free.dialog.ContextFreeDialogConfig;
import context.free.dialog.dialogs.progress.ProgressDialogConfig;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setMyFavoriteProgressDialog();


//
        ProgressDialogConfig config = ProgressDialogConfig.builder()
                .setMessage(R.string.progress_dialog_message)
                .setTextGravity(ProgressDialogConfig.TextGravity.LEFT)
                .setProgressGravity(ProgressDialogConfig.ProgressGravity.RIGHT)
                .setProgressColor(R.color.purple_500)
                .build();
        ContextFreeDialogConfig.setProgressDialogConfig(config);
        ContextFreeDialog.show();
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(ContextFreeDialog::dismiss, 3000L);

    }


    public void setMyFavoriteProgressDialog() {
        MyDialog dialog = new MyDialog(this);
        ContextFreeDialogConfig.setCustomProgressDialog(dialog);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.d(TAG, "onBackPressed: called!");
    }
}