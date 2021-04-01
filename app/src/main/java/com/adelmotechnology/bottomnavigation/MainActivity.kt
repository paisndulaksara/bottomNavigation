package com.adelmotechnology.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import nl.joery.animatedbottombar.AnimatedBottomBar
import java.util.concurrent.ThreadLocalRandom

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val homeFragment = HomeFragment()
        val breadFragment = BreadFragment()
        val cartFragment = CartFragment()
        val alarmFragment = AlarmFragment()

        makeCurrentFragment(homeFragment)

        bottom_bar.setOnTabSelectListener(object : AnimatedBottomBar.OnTabSelectListener {
            override fun onTabSelected(
                lastIndex: Int,
                lastTab: AnimatedBottomBar.Tab?,
                newIndex: Int,
                newTab: AnimatedBottomBar.Tab
            ) {

                when(newIndex){
                    0 -> makeCurrentFragment(homeFragment);
                    1 -> makeCurrentFragment(breadFragment);
                    2 -> makeCurrentFragment(cartFragment);
                    3 -> makeCurrentFragment(alarmFragment);
                    else -> makeCurrentFragment(breadFragment);
                }

                Log.d("bottom_bar", "Selected index: $newIndex, title: ${newTab.title}")


            }

            // An optional method that will be fired whenever an already selected tab has been selected again.
            override fun onTabReselected(index: Int, tab: AnimatedBottomBar.Tab) {
                Log.d("bottom_bar", "Reselected index: $index, title: ${tab.title}")
            }
        });

    }

    private fun makeCurrentFragment(fragment: Fragment) {

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.wrapper,fragment)
            commit()
        }

    }


}