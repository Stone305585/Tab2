package com.example.tab2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

//项目主要的Activity，所有的fragment都嵌入到这里
public class MainActivity extends FragmentActivity implements
		TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener,
		OnClickListener {
	// 声明歌曲类别的专辑图片和名称
	/*
	 * private int[] images = { R.drawable.img1, R.drawable.img2,
	 * R.drawable.img3, R.drawable.img4, }; private String[] texts = { "轻松愉快",
	 * "热情劲爆", "淡雅舒缓", "高山流水",};
	 */
	// 声明fragment
	private MessageFragment messageFragment;
	private SettingFragment settingFragment;
	// 声明View
	private View setting_layout;
	private View message_layout;
	// 声明widget
	private ImageView message_image;
	private ImageView setting_image;
	private TextView message_text;
	private TextView setting_text;
	// 声明FragmentManager对fragment管理
	private FragmentManager fragmentManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		initViews();
		fragmentManager = getSupportFragmentManager();
		setTabSelection(0);
	}

	/**
	 * 初始化View
	 */
	private void initViews() {
		setting_layout = findViewById(R.id.setting_layout);
		message_layout = findViewById(R.id.message_layout);
		setting_image = (ImageView) findViewById(R.id.setting_image);
		message_image = (ImageView) findViewById(R.id.message_image);
		message_text = (TextView) findViewById(R.id.message_text);
		setting_text = (TextView) findViewById(R.id.setting_text);
		// 设置listener
		setting_layout.setOnClickListener(this);
		message_layout.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.message_layout:
			setTabSelection(0);
			break;
		case R.id.setting_layout:
			setTabSelection(1);
			break;
		default:
			break;
		}
	}

	// 实现setTabSelection()方法，根据选择的index参数来选择tab页
	private void setTabSelection(int index) {
		// clear之前的选择
		clearSelection();
		// 开启一个fragment....................support.v4
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		// 首先隐藏所有的fragment，防止出现多个fragment
		hideFragments(transaction);
		switch (index) {
		case 0:
			message_image.setImageResource(R.drawable.message_selected);
			message_text.setTextColor(Color.WHITE);
			if (messageFragment == null) {
				messageFragment = new MessageFragment();
				transaction.add(R.id.content, messageFragment);
			} else {
				transaction.show(messageFragment);
			}
			break;
		case 1:
			setting_image.setImageResource(R.drawable.setting_selected);
			setting_text.setTextColor(Color.WHITE);
			if (settingFragment == null) {
				settingFragment = new SettingFragment();
				transaction.add(R.id.content, settingFragment);
			} else {
				transaction.show(settingFragment);
			}
			break;
		}
		transaction.commit();
	}

	// 设置clear清空所有选中状态
	private void clearSelection() {
		message_image.setImageResource(R.drawable.message_unselected);
		message_text.setTextColor(Color.GRAY);
		setting_image.setImageResource(R.drawable.setting_unselected);
		setting_text.setTextColor(Color.GRAY);
	}

	// 隐藏所有的Fragment。。。。。。。。。
	private void hideFragments(FragmentTransaction transaction) {
		if (messageFragment != null) {
			transaction.hide(messageFragment);
		}
		if (settingFragment != null) {
			transaction.hide(settingFragment);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTabChanged(String tabId) {
		// TODO Auto-generated method stub

	}
}
