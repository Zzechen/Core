package com.zzc.utilscore;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created : zzc
 * Time : 2017/5/2
 * Email : zzc1259@163.com
 * Description : ${desc}
 */

public class ActivityUtils {
    private static final String BRAND_HUAWEI = "Huawei";//华为
    private static final String BRAND_MEIZU = "Meizu";//魅族
    private static final String BRAND_XIAOMI = "Xiaomi";//小米
    private static final String BRAND_SONY = "Sony";//索尼
    private static final String BRAND_OPPO = "OPPO";//oppo
    private static final String BRAND_LG = "LG";//LG
    private static final String BRAND_VIVO = "vivo";//vivo
    private static final String BRAND_LETV = "Letv";//乐视
    private static final String BRAND_ZTE = "ZTE";//中兴
    private static final String BRAND_YULONG = "YuLong";//酷派
    private static final String BRAND_LENOVO = "LENOVO";//联想

    private ActivityUtils() {
    }

    /**
     * 为指定的Activity加载Fragment，并通过id进行保存
     *
     * @param fragmentManager
     * @param fragment
     * @param frameId         保存的id
     */
    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                             @NonNull Fragment fragment, int frameId) {
        if (fragmentManager != null && fragment != null) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(frameId, fragment);
            transaction.commit();
        }
    }

    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                             @NonNull Fragment fragment, int frameId, String tag) {
        if (fragmentManager != null && fragment != null) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(frameId, fragment, tag);
            transaction.commit();
        }
    }

    public static void intent2Permission(@NonNull Context context) {
        context.startActivity(getIntent());
    }

    private static Intent getIntent() {
        Intent intent = null;
        switch (Build.BRAND) {
            case BRAND_HUAWEI:
                intent = new Intent();
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("packageName", BuildConfig.APPLICATION_ID);
                ComponentName compH = new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");
                intent.setComponent(compH);
                break;
            case BRAND_MEIZU:
                intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                intent.putExtra("packageName", BuildConfig.APPLICATION_ID);
                break;
            case BRAND_XIAOMI:
                intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
                ComponentName componentName = new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
                intent.setComponent(componentName);
                intent.putExtra("extra_pkgname", BuildConfig.APPLICATION_ID);
                break;
            case BRAND_SONY:
                intent = new Intent();
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("packageName", BuildConfig.APPLICATION_ID);
                ComponentName compS = new ComponentName("com.sonymobile.cta", "com.sonymobile.cta.SomcCTAMainActivity");
                intent.setComponent(compS);
                break;
            case BRAND_OPPO:
                intent = new Intent();
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("packageName", BuildConfig.APPLICATION_ID);
                ComponentName comp = new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity");
                intent.setComponent(comp);
                break;
            case BRAND_LG:
                intent = new Intent("android.intent.action.MAIN");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("packageName", BuildConfig.APPLICATION_ID);
                ComponentName compL = new ComponentName("com.android.settings", "com.android.settings.Settings$AccessLockSummaryActivity");
                intent.setComponent(compL);
                break;
            case BRAND_LETV:
                intent = new Intent();
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("packageName", BuildConfig.APPLICATION_ID);
                ComponentName compLE = new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.PermissionAndApps");
                intent.setComponent(compLE);
                break;
//            case BRAND_VIVO:
//
//                break;
//            case BRAND_ZTE:
//                break;
//            case BRAND_YULONG:
//                break;
//            case BRAND_LENOVO:
//                break;
            default:
                intent = new Intent();
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                if (Build.VERSION.SDK_INT >= 9) {
                    intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.fromParts("package", BuildConfig.APPLICATION_ID, null));
                } else if (Build.VERSION.SDK_INT <= 8) {
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
                    intent.putExtra("com.android.settings.ApplicationPkgName", BuildConfig.APPLICATION_ID);
                }
                break;
        }
        return intent;
    }
}
