package com.example.taveconnect

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.taveconnect.databinding.ActivityBurgerBinding

class BurgerActivity: AppCompatActivity() {
    private lateinit var binding: ActivityBurgerBinding
    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBurgerBinding.inflate(layoutInflater)
        val view = binding.root

        val gamePaused = intent.getBooleanExtra("gamePaused", false)

        val listFragment = ListFragment()

        // ListFragment에 gamePaused 값을 전달
        val bundle = Bundle()
        bundle.putBoolean("gamePaused", gamePaused)
        listFragment.arguments = bundle

        setContentView(view)

    }

    override fun onBackPressed() {
        val intent = Intent(this, GameActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP // 이전에 열려 있던 모든 Activity를 종료
        startActivity(intent)
        finish() // BurgerActivity를 종료
    }

    private fun Fragment.changeFragment() {
        /*class ButtonClickedReceiver : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                val intent2 = Intent(activity, LoadActivity::class.java)
                val gameActivity = activity as GameActivity
                val col1 = gameActivity.col1
                val col2 = gameActivity.col2
                val col3 = gameActivity.col3
                val col4 = gameActivity.col4
                val col5 = gameActivity.col5
                val col6 = gameActivity.col6
                val col7 = gameActivity.col7
                intent2.putExtra("col1", col1)
                intent2.putExtra("col2", col2)
                intent2.putExtra("col3", col3)
                intent2.putExtra("col4", col4)
                intent2.putExtra("col5", col5)
                intent2.putExtra("col6", col6)
                intent2.putExtra("col7", col7)
            }
        }*/

        manager.beginTransaction().replace(R.id.fv_burger, this).commit()
    }


}