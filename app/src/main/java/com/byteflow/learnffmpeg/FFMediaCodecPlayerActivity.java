/**
 *
 * Created by 公众号：字节流动 on 2021/3/16.
 * https://github.com/githubhaohao/LearnFFmpeg
 * 最新文章首发于公众号：字节流动，有疑问或者技术交流可以添加微信 Byte-Flow ,领取视频教程, 拉你进技术交流群
 *
 * */

package com.byteflow.learnffmpeg;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.Window;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.byteflow.learnffmpeg.media.FFMediaPlayer;
import com.byteflow.learnffmpeg.media.MySurfaceView;

import static com.byteflow.learnffmpeg.media.FFMediaPlayer.HWCODEC_PLAYER;
import static com.byteflow.learnffmpeg.media.FFMediaPlayer.MEDIA_PARAM_ASSET_MANAGER;
import static com.byteflow.learnffmpeg.media.FFMediaPlayer.MEDIA_PARAM_VIDEO_DURATION;
import static com.byteflow.learnffmpeg.media.FFMediaPlayer.MEDIA_PARAM_VIDEO_HEIGHT;
import static com.byteflow.learnffmpeg.media.FFMediaPlayer.MEDIA_PARAM_VIDEO_WIDTH;
import static com.byteflow.learnffmpeg.media.FFMediaPlayer.MSG_DECODER_DONE;
import static com.byteflow.learnffmpeg.media.FFMediaPlayer.MSG_DECODER_INIT_ERROR;
import static com.byteflow.learnffmpeg.media.FFMediaPlayer.MSG_DECODER_READY;
import static com.byteflow.learnffmpeg.media.FFMediaPlayer.MSG_DECODING_TIME;
import static com.byteflow.learnffmpeg.media.FFMediaPlayer.MSG_REQUEST_RENDER;
import static com.byteflow.learnffmpeg.media.FFMediaPlayer.VIDEO_RENDER_ANWINDOW;

public class FFMediaCodecPlayerActivity extends AppCompatActivity implements SurfaceHolder.Callback, FFMediaPlayer.EventCallback{
    private static final String TAG = "FFMediaCodecPlayerActivity";
    private static final String[] REQUEST_PERMISSIONS = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
    };
    private static final int PERMISSION_REQUEST_CODE = 1;
    private MySurfaceView mSurfaceView = null;
    private FFMediaPlayer mMediaPlayer = null;
    private String mVideoPath = "http://ser.89c.cn:10086/hls/wN9gJW1Sg/playlist.m3u8";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_media_player);
        mSurfaceView = findViewById(R.id.surface_view);
        mSurfaceView.getHolder().addCallback(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Log.d(TAG, "surfaceCreated() called with: surfaceHolder = [" + surfaceHolder + "]");
        mMediaPlayer = new FFMediaPlayer();
        mMediaPlayer.addEventCallback(this);
        mMediaPlayer.init(mVideoPath, HWCODEC_PLAYER, VIDEO_RENDER_ANWINDOW, surfaceHolder.getSurface());
        mMediaPlayer.setMediaParams(MEDIA_PARAM_ASSET_MANAGER, getAssets());
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int format, int w, int h) {
        Log.d(TAG, "surfaceChanged() called with: surfaceHolder = [" + surfaceHolder + "], format = [" + format + "], w = [" + w + "], h = [" + h + "]");
        mMediaPlayer.play();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Log.d(TAG, "surfaceDestroyed() called with: surfaceHolder = [" + surfaceHolder + "]");
        mMediaPlayer.stop();
        mMediaPlayer.unInit();
    }

    @Override
    public void onPlayerEvent(final int msgType, final float msgValue) {
        Log.d(TAG, "onPlayerEvent() called with: msgType = [" + msgType + "], msgValue = [" + msgValue + "]");
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                switch (msgType) {
                    case MSG_DECODER_INIT_ERROR:
                        break;
                    case MSG_DECODER_READY:
                        onDecoderReady();
                        break;
                    case MSG_DECODER_DONE:
                        break;
                    case MSG_REQUEST_RENDER:
                        break;
                    case MSG_DECODING_TIME:
                        break;
                    default:
                        break;
                }
            }
        });

    }

    private void onDecoderReady() {
//        int videoWidth = (int) mMediaPlayer.getMediaParams(MEDIA_PARAM_VIDEO_WIDTH);
//        int videoHeight = (int) mMediaPlayer.getMediaParams(MEDIA_PARAM_VIDEO_HEIGHT);
//        if(videoHeight * videoWidth != 0)
//            mSurfaceView.setAspectRatio(videoWidth, videoHeight);
//
//        int duration = (int) mMediaPlayer.getMediaParams(MEDIA_PARAM_VIDEO_DURATION);
    }
}
