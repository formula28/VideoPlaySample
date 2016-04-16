package com.formula.sample.videoplaysample.util;

import android.net.Uri;
import android.util.Log;

import com.formula.sample.videoplaysample.App;

import java.io.File;

/**
 * Created by @formula on 2016/04/17.
 */
public class ResourcesUtil {
    // リソース取得先モード.
    public static enum ResMode {
        APP_RESOURCE,       //アプリ内リソース.
        DEVICE_STORAGE,     //端末内リソース.
    }
    private static final ResMode RES_MODE = ResMode.DEVICE_STORAGE;
    // 端末内リソースファイルパス.
    public static final String DEVICE_STORAGE_DIR_PATH = "/data/local/tmp/";
    // リソースの種別名.
    public static final String RES_TYPE_DRAWABLE = "drawable";
    public static final String RES_TYPE_RAW = "raw";

    /**
     * リソース名からURI文字列取得.
     * @param resFilename リソースファイル名.
     * @param resType リソース種別.
     * @return URI文字列.
     */
    public static String getResUriStr(String resFilename, String resType) {
        String uri = "";
        switch(RES_MODE) {
        case DEVICE_STORAGE:
            uri = DEVICE_STORAGE_DIR_PATH + resFilename;
            if (new File(uri).exists()) {
                break;
            }
        case APP_RESOURCE:
            int id = App.getInstance().getResources()
                    .getIdentifier(removeFileExtension(resFilename), resType, App.getInstance().getPackageName());
            uri = "android.resource://" + App.getInstance().getPackageName() + "/" + String.valueOf(id);
            break;
        default:
            break;
        }
        Log.d(App.LOGTAG, "getResUriStr : " + uri);
        return uri;
    }
    /**
     * リソース名からURI取得.
     * @param resFilename リソースファイル名.
     * @param resType リソース種別.
     * @return URI.
     */
    public static Uri getResUri(String resFilename, String resType) {
        return Uri.parse(getResUriStr(resFilename, resType));
    }

    /**
     * 拡張子抜きファイル名取得(拡張子なし、またはファイル名の最初がドットのファイルはそのまま).
     * @param aFilename ファイル名.
     * @return 拡張子抜きファイル名.
     */
    public static String removeFileExtension(String aFilename) {
        String ret = aFilename;
        int lastDotPos = aFilename.lastIndexOf('.');
        if (lastDotPos > 0) {
            ret = aFilename.substring(0, lastDotPos);
        }
        return ret;
    }
}
