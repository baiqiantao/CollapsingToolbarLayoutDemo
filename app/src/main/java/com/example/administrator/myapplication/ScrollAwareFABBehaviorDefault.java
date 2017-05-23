package com.example.administrator.myapplication;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Fab在滚动时候的显示与隐藏，直接借用了FloatingActionButton内置的动画效果，仅仅是在条件恰当的时候调用hide()和show()方法
 */
public class ScrollAwareFABBehaviorDefault extends FloatingActionButton.Behavior {

	public ScrollAwareFABBehaviorDefault(Context context, AttributeSet attrs) {
		super();
	}
	
	@Override
	public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child,
	                                   View directTargetChild, View target, int nestedScrollAxes) {
		// Ensure we react to vertical scrolling
		return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL
				|| super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);
	}
	
	@Override
	public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target,
	                           int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
		super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
		if (dyConsumed > 0 && child.getVisibility() == View.VISIBLE) {// User scrolled down and the FAB is currently visible
			child.hide();//如果要自定义动画效果，就在这里重新定义隐藏时的动画
			Snackbar.make(coordinatorLayout, "隐藏", Snackbar.LENGTH_SHORT).show();
		} else if (dyConsumed < 0 && child.getVisibility() != View.VISIBLE) {// User scrolled up and the FAB is currently not visible
			child.show();
			Snackbar.make(coordinatorLayout, "显示", Snackbar.LENGTH_SHORT).show();
		}
	}
}