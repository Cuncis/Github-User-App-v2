package com.cuncisboss.githubuserappv2.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.cuncisboss.githubuserappv2.ui.detail.foll.FollowerFragment
import com.cuncisboss.githubuserappv2.ui.detail.foll.FollowingFragment

class ViewPagerAdapter(fragmentManager: FragmentManager): FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val pages = listOf(
        FollowerFragment(),
        FollowingFragment()
    )

    override fun getItem(position: Int): Fragment = pages[position]

    override fun getCount(): Int = pages.size

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Follower"
            else -> "Following"
        }
    }
}