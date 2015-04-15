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
	private String[] texts = { "�������", "���龢��", "�����滺",
			"��ɽ��ˮ",};
	
	  @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState) {  
		  //��һ�д����true����falseӰ���Ƿ��Զ��������ͼ������ͼ
        View messageLayout = inflater.inflate(R.layout.message_layout, container, false); 
        GridView gridview=(GridView)messageLayout.findViewById(R.id.gridview);
        //�����SimpleAdapter������������������map��baseAdapterû��
        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), fillMap(),R.layout.grid_item, 
        		new String[] { "imageView", "imageTitle" },
           	    new int[] { R.id.grid_image, R.id.grid_text });
        gridview.setAdapter(simpleAdapter);
		gridview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position,long id)
        	{
        		Toast.makeText(getActivity(),"��ѡ����"+(position+1)+"��ͼƬ",Toast.LENGTH_SHORT).show();
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