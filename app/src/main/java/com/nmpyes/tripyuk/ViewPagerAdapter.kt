package com.nmpyes.tripyuk

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(val activity: AppCompatActivity, val fragments: ArrayList<Fragment>) :
    FragmentStateAdapter(activity){
    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    override fun getItemCount(): Int {
        return fragments.size
    }
}