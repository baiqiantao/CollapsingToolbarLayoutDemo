package com.example.administrator.myapplication;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends ListActivity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String[] array = {"默认样式，SHORT", //
				"默认样式，LONG", //
				"点击事件，setAction", //
				"设置Snackbar的文字和背景颜色",};
		for (int i = 0; i < array.length; i++) {
			array[i] = i + "、" + array[i];
		}
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<String>(Arrays.asList(array))));
	}

	@Override
	protected void onListItemClick(ListView l, View view, int position, long id) {
		switch (position) {
			case 0:
				Snackbar.make(view, "默认样式的Snackbar", Snackbar.LENGTH_SHORT).show();
				break;
			case 1:
				Snackbar.make(view, "默认样式的Snackbar默认样式的Snackbar默认样式的Snackbar", Snackbar.LENGTH_LONG).show();
				break;
			case 2:
				Snackbar.make(view, "点击事件", Snackbar.LENGTH_LONG)
						.setAction("点击", new View.OnClickListener() {
							@Override
							public void onClick(View v) {
								Toast.makeText(MainActivity.this, "点击事件", Toast.LENGTH_SHORT).show();
							}
						})
						.setActionTextColor(0xffff0000)//设置右侧文字的颜色
						.show();
				break;
			case 3:
				Snackbar snackbar = Snackbar.make(view, "设置Snackbar的文字和背景颜色", Snackbar.LENGTH_LONG);
				snackbar.getView().setBackgroundColor(0xff0000ff);//设置Snackbar背景颜色
				((TextView) snackbar.getView().findViewById(R.id.snackbar_text)).setTextColor(0xffff0000);//设置Snackbar文字颜色
				snackbar.show();
				break;
		}
	}
}