package wjc.ivan.oschina.services;

import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import static android.content.Context.WINDOW_SERVICE;

/**
 * Created by 龙心诚 on 2018/6/28 0028.
 */

public class FloatingService extends Service {
    WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
    WindowManager windowManager;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        showFloatingWindow();

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void showFloatingWindow() {
        if (Settings.canDrawOverlays(this)) {
            // 获取WindowManager服务
            windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

            // 新建悬浮窗控件
            Button button = new Button(getApplicationContext());
            button.setText("Home");
            button.setBackgroundColor(Color.GRAY);
            button.getBackground().setAlpha(200);
            //button.setBackground("#e0000000"");
            button.setOnTouchListener(new FloatingOnTouchListener());
            button.setOnClickListener(new FloatingOnClickListener());
            //button.setOnLongClickListener(new FloatingLongOnClickListener());

            // 设置LayoutParam

            if (Build.VERSION.SDK_INT >= 28) {
                layoutParams.type = WindowManager.LayoutParams.TYPE_PHONE;
            } else {
                layoutParams.type = WindowManager.LayoutParams.TYPE_PHONE;
            }
            layoutParams.format = PixelFormat.RGBA_8888;
            layoutParams.width = 120;
            layoutParams.height = 120;
            layoutParams.x = 300;
            layoutParams.y = 300;
            layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                    | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;

            // 将悬浮窗控件添加到WindowManager
            windowManager.addView(button, layoutParams);
        }
    }
    private class FloatingOnTouchListener implements View.OnTouchListener {
        private int x;
        private int y;

        @Override
        public boolean onTouch(View view, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    x = (int) event.getRawX();
                    y = (int) event.getRawY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    int nowX = (int) event.getRawX();
                    int nowY = (int) event.getRawY();
                    int movedX = nowX - x;
                    int movedY = nowY - y;
                    x = nowX;
                    y = nowY;
                    layoutParams.x = layoutParams.x + movedX;
                    layoutParams.y = layoutParams.y + movedY;

                    // 更新悬浮窗控件布局
                    windowManager.updateViewLayout(view, layoutParams);
                    break;
                default:
                    break;
            }
            return false;
        }
    }

    private class FloatingOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent home = new Intent(Intent.ACTION_MAIN);
            home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            home.addCategory(Intent.CATEGORY_HOME);
            startActivity(home);
        }
    }

}
