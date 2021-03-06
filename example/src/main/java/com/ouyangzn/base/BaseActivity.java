package com.ouyangzn.base;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

/**
 * @author Ouyang
 *         Description：Activity基类,包含一些activity的通用操作
 */
public abstract class BaseActivity extends AppCompatActivity {

  public static final int REQUEST_PERMISSION = 1;
  protected String TAG = "BaseActivity";
  protected Context mContext;
  private com.ouyangzn.utils.Toast mToast;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    TAG = this.getClass().getSimpleName();
    mContext = this;
    mToast = com.ouyangzn.utils.Toast.getInstance(mContext);
    initData();
    initView(savedInstanceState);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
  }

  @Override public boolean onTouchEvent(MotionEvent event) {
    // 点击界面隐藏软键盘
    if (null != this.getCurrentFocus()) {
      InputMethodManager mInputMethodManager =
          (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
      return mInputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(),
          0);
    }
    return super.onTouchEvent(event);
  }

  /** 初始化数据 */
  protected abstract void initData();

  /** 初始化界面及控件,需要在此方法setContentView */
  protected abstract void initView(Bundle savedInstanceState);

  @Override public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
  }

  @Override protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
  }

  protected void toast(String content) {
    mToast.show(content, Toast.LENGTH_SHORT);
  }

  /**
   * 打开一个activity
   *
   * @param clazz 要打开的activity
   * @param <T>
   */
  public <T> void openActivity(Class<T> clazz) {
    startActivity(new Intent(mContext, clazz));
    //        overridePendingTransition(R.anim.anim_slide_in,
    //                R.anim.anim_slide_out);
  }

  /**
   * 打开一个activity
   *
   * @param clazz 要打开的activity
   * @param data 要携带过去的数据
   * @param <T>
   */
  public <T> void openActivity(Class<T> clazz, Bundle data) {
    Intent intent = new Intent(mContext, clazz);
    intent.putExtras(data);
    startActivity(intent);
    //        overridePendingTransition(R.anim.anim_slide_in,
    //                R.anim.anim_slide_out);
  }

  /**
   * 打开一个activity
   *
   * @param clazz 要打开的activity
   * @param requestCode 请求码
   * @param <T>
   */
  public <T> void openActivityForResult(Class<T> clazz, int requestCode) {
    Intent intent = new Intent(mContext, clazz);
    startActivityForResult(intent, requestCode);
    //        overridePendingTransition(R.anim.anim_slide_in,
    //                R.anim.anim_slide_out);
  }

  /**
   * 打开一个activity
   *
   * @param clazz 要打开的activity
   * @param requestCode 请求码
   * @param data 要携带过去的数据
   * @param <T>
   */
  public <T> void openActivityForResult(Class<T> clazz, int requestCode, Bundle data) {
    Intent intent = new Intent(mContext, clazz);
    intent.putExtras(data);
    startActivityForResult(intent, requestCode);
    //        overridePendingTransition(R.anim.anim_slide_in,
    //                R.anim.anim_slide_out);
  }

  /**
   * 检查是否有权限，适用于Android6.0系统,目前对国产改版系统不起作用
   *
   * @param permissionType 详见{@link android.Manifest.permission}类
   */
  protected boolean checkPermission(String permissionType) {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
      return true;
    }
    int checkCallPhonePermission = ContextCompat.checkSelfPermission(mContext, permissionType);
    if (checkCallPhonePermission != PackageManager.PERMISSION_GRANTED) {// 没有权限，去申请
      Log.d(TAG, "------检查权限 = 没有权限");
      ActivityCompat.requestPermissions(this, new String[] { permissionType }, REQUEST_PERMISSION);
      return false;
    } else {
      Log.d(TAG, "------检查权限 = 有权限");
      // 有权限
      return true;
    }
  }

  // ------------------------暂时留着以后加---------------------------
  //    @Override
  //    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
  //        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
  //        if (requestCode == REQUEST_PERMISSION) {
  //
  //        }
  //    }

  @Override public void onBackPressed() {
    super.onBackPressed();
    //        overridePendingTransition(R.anim.anim_push_in,
    //                R.anim.anim_push_out);
  }

  public void finish() {
    super.finish();
    //        overridePendingTransition(R.anim.anim_push_in,
    //                R.anim.anim_push_out);
  }
}
