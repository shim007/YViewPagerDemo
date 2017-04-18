package cn.youngkaaa.yviewpagerdemo;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.youngkaaa.yviewpager.YViewPager;

public class BannerActivity extends AppCompatActivity {
    private static final String TAG = "BannerActivity";
    private YViewPager mYViewPager;
    private LinearLayout mLinearIndicator;
    private List<ImageView> mImageViews;
    private int mTotalCount = 0;
    private TextView mTextViewTitle;
    private List<String> mStringList;
    private TextView mTextViewCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        mYViewPager = (YViewPager) findViewById(R.id.viewpager1);
        mLinearIndicator = (LinearLayout) findViewById(R.id.linearIndicator);
        mTextViewTitle= (TextView) findViewById(R.id.tvTitle);
        mTextViewCircle= (TextView) findViewById(R.id.numIndicator);
        initImgs();

//        setIndicator(0);

        mYViewPager.setAdapter(new ImagePagerAdapter());

        setIndicator(2);

        mYViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setIndicator(position);
                Log.d(TAG,"POSITION=====>"+mYViewPager.getCurrentItem());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    private void setIndicator(int pos) {
        mLinearIndicator.removeAllViews();
        for (int i = 0; i < mImageViews.size(); i++) {
            int resId = i == pos ? R.drawable.circle_selected : R.drawable.circle_normal;
            ImageView indicator = new ImageView(this);
            indicator.setImageResource(resId);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(68, 68);
            indicator.setLayoutParams(lp);
            mLinearIndicator.addView(indicator);
        }
        mTextViewTitle.setText(mStringList.get(pos));
        mTextViewCircle.setText(pos+1+"/"+mImageViews.size());
    }


    private void initImgs() {
        mImageViews = new ArrayList<>();
        mStringList=new ArrayList<>();

        ViewPager.LayoutParams lp = new ViewPager.LayoutParams();
        lp.gravity = Gravity.LEFT;

        ImageView imageView1 = new ImageView(this);
        imageView1.setImageResource(R.drawable.jay_fantexi);
        imageView1.setScaleType(ImageView.ScaleType.CENTER_CROP);

        ImageView imageView2 = new ImageView(this);
        imageView2.setImageResource(R.drawable.jay_jay);
        imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);

        ImageView imageView3 = new ImageView(this);
        imageView3.setImageResource(R.drawable.logo);
        imageView3.setScaleType(ImageView.ScaleType.CENTER_CROP);

        ImageView imageView4 = new ImageView(this);
        imageView4.setImageResource(R.drawable.image2);
        imageView4.setScaleType(ImageView.ScaleType.CENTER_CROP);

        ImageView imageView5 = new ImageView(this);
        imageView5.setImageResource(R.drawable.jay_jay);
        imageView5.setScaleType(ImageView.ScaleType.CENTER_CROP);

        ImageView imageView6 = new ImageView(this);
        imageView6.setImageResource(R.drawable.logo);
        imageView6.setScaleType(ImageView.ScaleType.CENTER_CROP);

        imageView1.setLayoutParams(lp);
        imageView2.setLayoutParams(lp);
        imageView3.setLayoutParams(lp);
        imageView4.setLayoutParams(lp);
        imageView5.setLayoutParams(lp);
        imageView6.setLayoutParams(lp);

        mImageViews.add(imageView1);
        mImageViews.add(imageView2);
        mImageViews.add(imageView3);
        mImageViews.add(imageView4);
        mImageViews.add(imageView5);
        mImageViews.add(imageView6);
        mStringList.add("youngkaaa test 1");
        mStringList.add("hahahahha");
        mStringList.add("yyyyyyyyyyyyyyy");
        mStringList.add("aaaaaaaaaaaaaa");
        mStringList.add("pipipipipipipipipi");
        mStringList.add("kkkkkkkkkkkkkkkkk");

    }

    class ImagePagerAdapter extends PagerAdapter {
        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            View img = mImageViews.get(position);
            container.addView(img);
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(BannerActivity.this, position+"", Toast.LENGTH_SHORT).show();
                }
            });
//            Log.d(TAG,"############instantiateItem() end############");
            return img;
        }

        @Override
        public int getCount() {
            return mImageViews.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((View)object).setOnClickListener(null);
            container.removeView((View) object);
        }
    }
}
