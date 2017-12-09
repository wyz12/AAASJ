package zxwl.com.aaasj;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 旋转
     */
    private Button mXuanzuan;
    /**
     * 缩小
     */
    private Button mSuoxiao;
    /**
     * 放大
     */
    private Button mFangda;
    /**
     * 平移
     */
    private Button mPingyi;
    /**
     * 拼接
     */
    private Button mPinjie;
    private ImageView mAimage;
    private ImageView mBimage;
    private ImageView mCimage;
    private float alpha;
    private Bitmap bitmap;
    private Bitmap bitmap2;
    private Bitmap bitmap11;
    private Bitmap bitmap22;
    private CheckBox mYz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.aab);
        bitmap2 = BitmapFactory.decodeResource(getResources(), R.mipmap.aac);
        mAimage.setImageBitmap(bitmap);
        mBimage.setImageBitmap(bitmap2);

    }

    private void initView() {
        mXuanzuan = (Button) findViewById(R.id.xuanzuan);
        mXuanzuan.setOnClickListener(this);
        mSuoxiao = (Button) findViewById(R.id.suoxiao);
        mSuoxiao.setOnClickListener(this);
        mFangda = (Button) findViewById(R.id.fangda);
        mFangda.setOnClickListener(this);
        mPingyi = (Button) findViewById(R.id.pingyi);
        mPingyi.setOnClickListener(this);
        mPinjie = (Button) findViewById(R.id.pinjie);
        mPinjie.setOnClickListener(this);
        mAimage = (ImageView) findViewById(R.id.Aimage);
        mBimage = (ImageView) findViewById(R.id.Bimage);
        mCimage = (ImageView) findViewById(R.id.Cimage);


        mYz = (CheckBox) findViewById(R.id.yz);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.xuanzuan:
                if (alpha < 345) {
                    alpha += 15;
                } else {
                    alpha = 0;
                }
                if(mYz.isChecked()){
                    bitmap11 = rotateBitmap(bitmap, alpha);
                    mAimage.setImageBitmap(bitmap11);
                }else{
                    bitmap22 = rotateBitmap(bitmap2, alpha);
                    mBimage.setImageBitmap(bitmap22);
                }

                break;
            case R.id.suoxiao:
                break;
            case R.id.fangda:
                break;
            case R.id.pingyi:
                break;
            case R.id.pinjie:
                if(bitmap11!=null&&bitmap22!=null){
                    Bitmap bitmap = newBitmap(bitmap11, bitmap22);
                    mCimage.setImageBitmap(bitmap);
                }


                break;
        }
    }

    private Bitmap rotateBitmap(Bitmap origin, float alpha) {
        if (origin == null) {
            return null;
        }
        int width = origin.getWidth();
        int height = origin.getHeight();
        Matrix matrix = new Matrix();
//        matrix.setRotate(alpha);
//        Bitmap newBM = Bitmap.createBitmap(origin, 0, 0, width, height, matrix, false);

        // 围绕原地进行旋转
        matrix.setRotate(alpha, origin.getWidth() / 2, origin.getHeight() / 2);
        Bitmap createBmp = Bitmap.createBitmap(origin.getWidth(), origin.getHeight(), origin.getConfig());
        Canvas canvas = new Canvas(createBmp);
        Paint paint = new Paint();
        canvas.drawBitmap(origin, matrix, paint);
        if (createBmp.equals(origin)) {
            return createBmp;
        }
        origin = null;
        return createBmp;
    }


    private Bitmap newBitmap(Bitmap bit1, Bitmap bit2) {

        int width = bit1.getWidth();
        int height = bit1.getHeight() + bit2.getHeight();
        //创建一个空的Bitmap(内存区域),宽度等于第一张图片的宽度，高度等于两张图片高度总和
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        //将bitmap放置到绘制区域,并将要拼接的图片绘制到指定内存区域
        Canvas canvas = new Canvas(bitmap);
        canvas.drawBitmap(bit1, 0, 0, null);
        canvas.drawBitmap(bit2, 0, bit1.getHeight(), null);
        return bitmap;
    }

}
