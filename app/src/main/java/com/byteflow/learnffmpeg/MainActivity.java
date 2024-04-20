/**
 *
 * Created by 公众号：字节流动 on 2021/3/16.
 * https://github.com/githubhaohao/LearnFFmpeg
 * 最新文章首发于公众号：字节流动，有疑问或者技术交流可以添加微信 Byte-Flow ,领取视频教程, 拉你进技术交流群
 *
 * */

package com.byteflow.learnffmpeg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.byteflow.learnffmpeg.media.FFMediaPlayer;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String[] REQUEST_PERMISSIONS = {
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
    };
    private static final int PERMISSION_REQUEST_CODE = 1;
    private static  final String [] EXAMPLE_LIST = {
            "FFmpeg + ANativeWindow player",
            "FFmpeg + OpenGL ES player",
            "FFmpeg + OpenSL ES visual audio",
            "FFmpeg + OpenGL ES VR player",
            "FFmpeg + single video recorder",
            "FFmpeg + single audio recorder",
            "FFmpeg + AV recorder",
            "FFmpeg + stream media player",
            "FFmpeg + MediaCodec player"
    };

    private static final int FF_ANATIVE_WINDOWS_EXAMPLE = 0;
    private static final int FF_OPENGLES_EXAMPLE = 1;
    private static final int FF_OPENGLES_AUDIO_VISUAL_EXAMPLE = 2;
    private static final int FF_OPENGLES_VR_EXAMPLE = 3;
    private static final int FF_X264_VIDEO_RECORDER = 4;
    private static final int FF_FDK_AAC_AUDIO_RECORDER = 5;
    private static final int FF_AV_RECORDER = 6;
    private static final int FF_STREAM_MEDIA_PLAYER = 7;
    private static final int FF_MEDIACODEC_PLAYER = 8;

    private int mSampleSelectedIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
