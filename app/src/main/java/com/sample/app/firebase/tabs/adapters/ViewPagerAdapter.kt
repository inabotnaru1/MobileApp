package com.sample.app.firebase.tabs.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.sample.app.firebase.tabs.fragments.CommunityFragment
import com.sample.app.firebase.tabs.fragments.TasksFragment
import com.sample.app.firebase.tabs.fragments.CalendarFragment


class ViewPagerAdapter(fragmentManager: FragmentManager):
    FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val tabTitles: Array<String> = arrayOf(
        "Tasks",
        "Calendar",
        "Community"
    )

    private val pagerFragments: Array<Fragment> = arrayOf(
        TasksFragment(),
        CalendarFragment(),
        CommunityFragment()
    )

    override fun getItem(position: Int): Fragment {
        return pagerFragments[position]
    }

    override fun getCount(): Int {
        return pagerFragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitles[position]
    }
}