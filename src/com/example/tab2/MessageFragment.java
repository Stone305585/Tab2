package com.example.tab2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MessageFragment extends Fragment { 
	private int[] images = { R.drawable.img1, R.drawable.img2, R.drawable.img3,
			R.drawable.img4, };
	private String[] texts = { "轻松愉快", "热情劲爆", "淡雅舒缓",
			"高山流水",};
	
	  @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState) {  
		  //下一行代码的true或者false影响是否自动添加子视图到该视图
        View messageLayout = inflater.inflate(R.layout.message_layout, container, false); 
        GridView gridview=(GridView)messageLayout.findViewById(R.id.gridview);
        //这里的SimpleAdapter可以在里面引用两个map，baseAdapter没试
        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), fillMap(),R.layout.grid_item, 
        		new String[] { "imageView", "imageTitle" },
           	    new int[] { R.id.grid_image, R.id.grid_text });
        gridview.setAdapter(simpleAdapter);
		gridview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position,long id)
        	{
        		Toast.makeText(getActivity(),"你选择了"+(position+1)+"号图片",Toast.LENGTH_SHORT).show();
        	}
        });
        return messageLayout;  
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