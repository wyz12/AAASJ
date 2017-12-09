package zxwl.com.aaasj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 滑动
     */
    private TextView mOne;
    /**
     * 滑动
     */
    private TextView mTwo;
    /**
     * 滑动
     */
    private TextView mThree;
    /**
     * 滑动
     */
    private TextView mFour;
    private TextView mFive;
    private float ax;
    private float ay;
    /**
     * 滑动
     */
    private TextView mAone;
    /**
     * 滑动
     */
    private TextView mAtwo;
    /**
     * 滑动
     */
    private TextView mAthree;
    /**
     * 滑动
     */
    private TextView mAfour;
    /**
     * 滑动
     */
    private TextView mAfive;
    /**
     * 图片处理
     */
    private Button mButton;
    private LinearLayout mQing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


        LinearLayout huang = (LinearLayout) findViewById(R.id.huang);
        LinearLayout qing = (LinearLayout) findViewById(R.id.qing);

        qing.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // 按下屏幕的操作
                        mAone.setText("按下");
                        ax = event.getX();
                        ay = event.getY();
                        mAtwo.setText(ax + "");
                        mAthree.setText(ay + "");
                        break;

                    case MotionEvent.ACTION_MOVE:
                        float x = event.getX();
                        float y = event.getY();
                        mAtwo.setText(x + "");
                        mAthree.setText(y + "");
                        // 在屏幕上移动的操作
                        mAone.setText("移动");

                        break;
                    case MotionEvent.ACTION_UP:
                        // 离开屏幕的操作
                        float x1 = event.getX();
                        float y1 = event.getY();

                        if (x1 < ax) {
                            mAfour.setText("左移了");
                        } else {
                            mAfour.setText("右移了");
                        }
                        if (y1 < ay) {
                            mAfive.setText("上移了");
                        } else {
                            mAfive.setText("下移了");
                        }
                        mAone.setText("离开");


                        break;
                    case (MotionEvent.ACTION_CANCEL):
                        // 手势撤消的操作
                        // 一般认为不能由用户主动触发。
                        // 系统在运行到一定程度下无法继续响应你的后续动作时会产生此事件
                        break;
                    default:
                        break;
                }
                // 这个返回值如果是false的话，那么它只会接受到第一个ACTION_DOWN的效果，
                // 后面的它认为没有触发，所以要想继续监听后续事件，需要返回值为true
                return true;
            }
        });

        huang.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // 按下屏幕的操作
                        mOne.setText("按下");
                        ax = event.getX();
                        ay = event.getY();
                        mTwo.setText(ax + "");
                        mThree.setText(ay + "");
                        break;

                    case MotionEvent.ACTION_MOVE:
                        float x = event.getX();
                        float y = event.getY();
                        mTwo.setText(x + "");
                        mThree.setText(y + "");
                        // 在屏幕上移动的操作
                        mOne.setText("移动");

                        break;
                    case MotionEvent.ACTION_UP:
                        // 离开屏幕的操作
                        float x1 = event.getX();
                        float y1 = event.getY();

                        if (x1 < ax) {
                            mFour.setText("左移了");
                        } else {
                            mFour.setText("右移了");
                        }
                        if (y1 < ay) {
                            mFive.setText("上移了");
                        } else {
                            mFive.setText("下移了");
                        }
                        mOne.setText("离开");


                        break;
                    case (MotionEvent.ACTION_CANCEL):
                        // 手势撤消的操作
                        // 一般认为不能由用户主动触发。
                        // 系统在运行到一定程度下无法继续响应你的后续动作时会产生此事件
                        break;
                    default:
                        break;
                }
                // 这个返回值如果是false的话，那么它只会接受到第一个ACTION_DOWN的效果，
                // 后面的它认为没有触发，所以要想继续监听后续事件，需要返回值为true
                return true;
            }
        });


    }


    private void initView() {
        mOne = (TextView) findViewById(R.id.one);
        mTwo = (TextView) findViewById(R.id.two);
        mThree = (TextView) findViewById(R.id.three);
        mFour = (TextView) findViewById(R.id.four);
        mFive = (TextView) findViewById(R.id.five);
        mOne.setOnClickListener(this);
        mAone = (TextView) findViewById(R.id.aone);
        mAtwo = (TextView) findViewById(R.id.atwo);
        mAthree = (TextView) findViewById(R.id.athree);
        mAfour = (TextView) findViewById(R.id.afour);
        mAfive = (TextView) findViewById(R.id.afive);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);
        mQing = (LinearLayout) findViewById(R.id.qing);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.one:
                break;
            case R.id.button:
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
                break;
        }
    }
}
