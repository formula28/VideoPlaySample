package com.formula.sample.videoplaysample;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.VideoView;

import com.formula.sample.videoplaysample.util.ResourcesUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by @formula on 2016/04/16.
 */
public class VideoController {
    List<VideoView> mVideoViewList;
    List<String> mVideoContentList;

    public VideoController() {
        mVideoViewList = new ArrayList<VideoView>();
        mVideoContentList = new ArrayList<String>();
    }

    /**
     * VideoViewの追加.
     * @param vv VideoView.
     */
    public void addVideoView(VideoView vv) {
        if (vv != null) {
            mVideoViewList.add(vv);
        }
    }
    /**
     * Videoファイル名ｓの追加.
     * @param aFileName ファイル名.
     */
    public void addVideoFile(String aFileName) {
        if (aFileName != null) {
            mVideoContentList.add(aFileName);
        }
    }

    /**
     * 再生開始.
     */
    public void start() {
        Log.d(App.LOGTAG, "start enter");
        VideoView vv = mVideoViewList.get(0);
        if (vv != null
                && !vv.isPlaying()) {
            String path = ResourcesUtil.getResUriStr(mVideoContentList.get(0), ResourcesUtil.RES_TYPE_RAW);
            Log.d(App.LOGTAG, path);
            vv.setVideoPath(path);
            vv.setVisibility(View.VISIBLE);
            vv.start();
            vv.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                }
            });
        }
        Log.d(App.LOGTAG, "start leave");
    }

    /**
     * 再生停止.
     */
    public void stop() {
        VideoView vv = mVideoViewList.get(0);
        if (vv != null
                && vv.isPlaying()) {
            vv.stopPlayback();
            vv.setVisibility(View.INVISIBLE);
        }
    }

    /**
     * 再生中判定.
     * @return 再生中かどうか(true:再生中, false:再生中でない).
     */
    public boolean isPlaying() {
        boolean ret = false;
        if (mVideoViewList != null) {
            for (VideoView vv : mVideoViewList) {
                if (vv != null && vv.isPlaying()) {
                    ret = true;
                    break;
                }
            }
        }
        return ret;
    }
}
