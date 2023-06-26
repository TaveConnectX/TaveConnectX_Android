package com.example.taveconnect

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.taveconnect.databinding.ActivityHomeBinding
import com.kakao.sdk.auth.model.OAuthToken


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    val manager = supportFragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        showInit()
        initBottomNav()


    }


    // 초기 Fragment 설정
    fun showInit() {
        val transaction = manager.beginTransaction()
            .add(R.id.fv_main, ListFragment())
        transaction.commit()
    }

    private fun Fragment.changeFragment() {
        manager.beginTransaction().replace(R.id.fv_main, this).commit()
    }

    private fun initBottomNav() {

        binding.btnNavHome.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.main -> {
                    ListFragment().changeFragment()
                }
                R.id.explanation -> {
                    ExplainFragment().changeFragment()
                }
                R.id.option -> {
                    SettingFragment().changeFragment()
                }
                R.id.rank -> {
                    RankingFragment().changeFragment()
                }
            }
            return@setOnItemSelectedListener true
        }
    }

}