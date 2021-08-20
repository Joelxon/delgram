package com.example.delgram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.delgram.AddPostActivity
import com.example.delgram.R
import com.example.delgram.databinding.ActivityMainBinding
import com.example.delgram.fragments.HomeFragment
import com.example.delgram.fragments.ProfileFragment
import com.example.delgram.fragments.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {

                R.id.nav_home -> {
                    moveToFragment(HomeFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_search -> {
                    moveToFragment(SearchFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_add -> {
                    item.isChecked = false
                    startActivity(Intent(this@MainActivity, AddPostActivity::class.java))
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_profile -> {
                    moveToFragment(ProfileFragment())
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        if (isCreate) {
            moveToFragment(ProfileFragment())
            isCreate = false
        } else {
            moveToFragment(HomeFragment())
        }
        mBinding.bottomNavView.setOnNavigationItemSelectedListener (onNavigationItemSelectedListener)



    }


    private fun moveToFragment(fragment: Fragment) {
        val fragmentTrans = supportFragmentManager.beginTransaction()
        fragmentTrans.replace(mBinding.fragmentContainer.id, fragment)
        fragmentTrans.commit()
    }

    companion object {
        var isCreate = false
        var moveTo = false
    }
}
