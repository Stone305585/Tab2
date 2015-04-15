package com.example.tab2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class GridAdapter extends Activity {
	private int[] images = { R.drawable.img1, R.drawable.img2, R.drawable.img3,
			R.drawable.img4, };
	private String[] texts = { "轻松愉快", "热情劲爆", "淡雅舒缓",
			"高山流水",};


	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GridView gridview=(GridView)findViewById(R.id.gridview);
        
        
        // 生成动态数组，并且转入数据

		// 生成适配器的ImageItem <====> 动态数组的元素，两者一一对应
//        gridview.setAdapter(new ImageAdapter(this));
/*        SimpleAdapter simpleAdapter = new SimpleAdapter(this, fillMap(),R.layout.grid_item, 
        		new String[] { "imageView", "imageTitle" },
           	    new int[] { R.id.grid_image, R.id.grid_text });*/
        	 
              
//        gridview.setAdapter(simpleAdapter);
//		gridview.setBackgroundColor(getResources().getColor(R.color.grid_01));
		gridview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position,long id)
        	{
        		Toast.makeText(GridAdapter.this,"你选择了"+(position+1)+"号图片",Toast.LENGTH_SHORT).show();
        	}
        });
	}
		public List<Map<String, Object>> fillMap() {
			  List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			  for (int i = 0; i < texts.length; i++) {
			   Map<String, Object> map = new HashMap<String, Object>();
			   map.put("imageView", images[i]);
			   map.put("imageTitle", texts[i]);
			   list.add(map);
			  }
			  return list;
		}
}
