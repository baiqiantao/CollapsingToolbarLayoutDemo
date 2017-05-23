package com.example.administrator.myapplication;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Fab在滚动时候的显示与隐藏，自定义上下滑动的动画
 */
public class ScrollAwareFABBehavior extends FloatingActionButton.Behavior {
	private boolean mIsAnimatingOut = false;
	
	public ScrollAwareFABBehavior(Context context, AttributeSet attrs) {
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
		if (dyConsumed > 0 && child.getVisibility() == View.VISIBLE) {
			child.animate().scaleX(0.0F).scaleY(0.0F).alpha(0.0F).setDuration(1500).start();
		} else if (dyConsumed < 0 && child.getVisibility() != View.VISIBLE) {
			child.animate().scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setDuration(1500).start();
		}
	}
}