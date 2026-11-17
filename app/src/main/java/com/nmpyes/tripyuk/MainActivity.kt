package com.nmpyes.tripyuk

import androidx.fragment.app.Fragment
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.nmpyes.tripyuk.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val fragments: ArrayList<Fragment> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragments.add(HomeFragment())
        fragments.add(ExploreFragment())
        fragments.add(FavoriteFragment())
        fragments.add(PlannerFragment())

        binding.viewPager.adapter = ViewPagerAdapter(this, fragments)

        binding.viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                val itemId = binding.bottomNav.menu.getItem(position).itemId
                binding.bottomNav.selectedItemId = itemId

            }
        })
        binding.bottomNav.setOnItemSelectedListener {
            binding.viewPager.currentItem = when(it.itemId){
                R.id.itemHome -> 0
                R.id.itemExplore -> 1
                R.id.itemFavorite -> 2
                R.id.itemPlanner -> 3
                else -> 0
            }
            true
        }
    }
}