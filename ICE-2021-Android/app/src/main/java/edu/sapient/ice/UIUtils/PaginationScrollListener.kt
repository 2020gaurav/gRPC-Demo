package edu.sapient.ice.UIUtils

import android.view.ViewTreeObserver
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.LinearLayoutManager

abstract class PaginationScrollListener(var layoutManager: LinearLayoutManager, val scroll: NestedScrollView) :
    ViewTreeObserver.OnScrollChangedListener {
    override fun onScrollChanged() {
        val view = scroll.getChildAt(scroll.childCount - 1)

        val diff = view.bottom - (scroll.height + scroll.scrollY)
        if (diff == 0) {
            //your api call to fetch data
            loadMoreItems()
        }
    }

    protected abstract fun loadMoreItems()
}