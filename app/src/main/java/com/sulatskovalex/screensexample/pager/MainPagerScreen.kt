package com.sulatskovalex.screensexample.pager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.github.sulatskovalex.screens.PagerScreen
import com.sulatskovalex.screensexample.R
import com.sulatskovalex.screensexample.pager.screens.first.PageFirstScreen
import com.sulatskovalex.screensexample.pager.screens.second.PageSecondScreen
import com.sulatskovalex.screensexample.pager.screens.third.PageThirdScreen
import kotlinx.android.synthetic.main.screen_pager.view.*

class MainPagerScreen(
        presenter: MainPagerPresenter,
        override val screenTag: String = Tag)
    : PagerScreen<MainPagerScreen, MainPagerPresenter>(presenter) {
    companion object {

        const val Tag = "PAGER_SCREEN_MAIN"
    }

    override val firstScreenArg = Any()

    override val screenTags = arrayOf(PageFirstScreen.Tag, PageSecondScreen.Tag, PageThirdScreen.Tag)
    override val firstScreenTag: String = PageFirstScreen.Tag

    override fun createViewWithPager(inflater: LayoutInflater, parent: ViewGroup): View {
        val view = inflater.inflate(R.layout.screen_pager, parent, false)

        view.first_page.setOnClickListener { presenter.onFirstPageClick() }
        view.second_page.setOnClickListener { presenter.onSecondPageClick() }
        view.third_page.setOnClickListener { presenter.onThirdPageClick() }

        return view
    }

    override fun viewPagerSimpleListener(): ViewPager.SimpleOnPageChangeListener {
        return object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Toast.makeText(view.context, position.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun pager(createdView: View): ViewPager {
        return createdView.findViewById(R.id.pager_list)
    }
}
