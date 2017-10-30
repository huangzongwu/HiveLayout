package com.example.hivelayout;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.widget.Toast;

import com.example.hivelayout.view.SixShape;
import com.example.hivelayout.view.SixShapeView;

public class MainActivity extends FragmentActivity implements SixShapeView.HiveItemOnClickListener{
	private SixShapeView sixShapeView;
	List<SixShape> sixShapeViewList = new ArrayList<SixShape>();
	/**
	 * ��ͥ��ϵ
	 */
	private Integer[] drawables;
	/**
	 * ��ѡ����Ŀ��programId
	 */
	private List<Integer> programIds = new ArrayList<Integer>();
	/**
	 * �ﳲ�����Ƿ��Ѿ���ʾ�ı�ʶ ���������ʾ��ôonWindowFocusChanged �����Ͳ������������ͼ��
	 */
	private boolean isShow = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		Rect outRect = new Rect();
		getWindow().findViewById(Window.ID_ANDROID_CONTENT).getDrawingRect(outRect);
		setContentView(R.layout.sport_item_page_layout);

		initCache();
		initView();
		initData();
	}

	private void initCache() {
		// û��programId����programId��Ϊ<0
			drawables = new Integer[15];
			drawables[0] = R.drawable.sport_item_page_father_sport_15_girl_00;
			programIds.add(-1);
			drawables[1] = R.drawable.sport_item_page_father_sport_15_boy_1;
			programIds.add(-2);
			drawables[2] = R.drawable.sport_item_page_father_sport_15_boy_2;
			programIds.add(1);
			drawables[3] = R.drawable.sport_item_page_father_sport_15_boy_3;
			programIds.add(-3);
			drawables[4] = R.drawable.sport_item_page_father_sport_15_boy_4;
			programIds.add(2);
			drawables[5] = R.drawable.sport_item_page_father_sport_15_boy_5;
			programIds.add(5);
			drawables[6] = R.drawable.sport_item_page_father_sport_15_boy_6;
			programIds.add(7);
			drawables[7] = R.drawable.sport_item_page_father_sport_15_boy_7;
			programIds.add(4);
			drawables[8] = R.drawable.sport_item_page_father_sport_15_boy_8;
			programIds.add(8);
			drawables[9] = R.drawable.sport_item_page_father_sport_15_boy_9;
			programIds.add(3);
			drawables[10] = R.drawable.sport_item_page_father_sport_15_boy_10;
			programIds.add(103);
			drawables[11] = R.drawable.sport_item_page_father_sport_15_boy_11;
			programIds.add(101);
			drawables[12] = R.drawable.sport_item_page_father_sport_15_boy_12;
			programIds.add(100);
			drawables[13] = R.drawable.sport_item_page_father_sport_15_boy_13;
			programIds.add(102);
			drawables[14] = R.drawable.sport_item_page_father_sport_15_boy_14;
			programIds.add(-4);
		for (int i = 0; i < drawables.length; i++) {
			SixShape sixShape = new SixShape();
			sixShape.setDrawableId(drawables[i]);
			sixShape.setProgramId(programIds.get(i));
			sixShape.setTag(i);
			sixShapeViewList.add(sixShape);
		}
	}

	private void initView() {
		sixShapeView = (SixShapeView) findViewById(R.id.main_page_six_shape_view);
	}

	private void initData() {

	}

	/**
	 * ���������Activityʱ��Ҫ������Щ���ݣ������ onWindowFocusChanged �����н��У�
	 * ����õ���ĳЩ���ݿ����Ǵ���ģ����磬Ӧ������߿�Ļ�ȡ��
	 */
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		if (hasFocus && !isShow) {
			Dimension dimen1 = getScreenCanvansHeitht(this);
			sixShapeView.initShapeView(sixShapeViewList, 20, this, dimen1.mHeight, this);
			isShow = true;
		}
	}

	/**
	 * �û����������=��Ļ��-֪ͨ����-״̬����
	 * 
	 * @param activity
	 * @return
	 */
	private Dimension getScreenCanvansHeitht(Activity activity) {
		Dimension dimen = new Dimension();
		// �û�����������
		Rect outRect = new Rect();
		activity.getWindow().findViewById(Window.ID_ANDROID_CONTENT).getDrawingRect(outRect);
		dimen.mWidth = outRect.width();
		dimen.mHeight = outRect.height();
		return dimen;
	}

	private class Dimension {
		public int mWidth;
		public int mHeight;

		public Dimension() {
		}
	}
	@Override
	public void hiveItemOnClick(int position) {
		SixShape shape = sixShapeViewList.get(position);
		System.out.println("shape tag:" + position);
		System.out.println("shape Id:" + shape.getProgramId());
		int programId = shape.getProgramId();
		if (programId < 0) {
			Toast.makeText(MainActivity.this, getResources().getString(R.string.sport_item_page_not_well),
					Toast.LENGTH_SHORT).show();
		}
	}

}

