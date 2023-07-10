package com.example.taveconnect

import android.content.Intent
import android.media.SoundPool
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.taveconnect.databinding.ActivityLoadBinding
import java.util.Random

private var turn: Int = 0

class LoadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoadBinding
    // Fragment 매니저
    val manager = supportFragmentManager

    private val soundPool: SoundPool by lazy {
        SoundPool.Builder().build()
    }

    private val col1: IntArray by lazy {
        intent.getSerializableExtra("col1") as IntArray
    }
    private val col2: IntArray by lazy {
        intent.getSerializableExtra("col2") as IntArray
    }
    private val col3: IntArray by lazy {
        intent.getSerializableExtra("col3") as IntArray
    }
    private val col4: IntArray by lazy {
        intent.getSerializableExtra("col4") as IntArray
    }
    private val col5: IntArray by lazy {
        intent.getSerializableExtra("col5") as IntArray
    }
    private val col6: IntArray by lazy {
        intent.getSerializableExtra("col6") as IntArray
    }
    private val col7: IntArray by lazy {
        intent.getSerializableExtra("col7") as IntArray
    }

    fun load() {
        turn = 0
        setTurn(turn)
        var i = 0
        var coo = "iv_gm_1_"
        while (i < col1.size) {
            if (col1[i] == 1) {
                i++
                val coord = coo + i
                val ivId = resources.getIdentifier(coord, "id", packageName)
                val imageView = findViewById<ImageView>(ivId)
                imageView.setImageResource(R.drawable.ic_black)
            } else if (col1[i] == 2) {
                i++
                val coord = coo + i
                val ivId = resources.getIdentifier(coord, "id", packageName)
                val imageView = findViewById<ImageView>(ivId)
                imageView.setImageResource(R.drawable.ic_white)
            } else {
                i++
            }
        }

        i = 0
        coo = "iv_gm_2_"
        while (i < col2.size) {
            if (col2[i] == 1) {
                i++
                val coord = coo + i
                val ivId = resources.getIdentifier(coord, "id", packageName)
                val imageView = findViewById<ImageView>(ivId)
                imageView.setImageResource(R.drawable.ic_black)
            } else if (col2[i] == 2) {
                i++
                val coord = coo + i
                val ivId = resources.getIdentifier(coord, "id", packageName)
                val imageView = findViewById<ImageView>(ivId)
                imageView.setImageResource(R.drawable.ic_white)
            } else {
                i++
            }
        }

        i = 0
        coo = "iv_gm_3_"
        while (i < col3.size) {
            if (col3[i] == 1) {
                i++
                val coord = coo + i
                val ivId = resources.getIdentifier(coord, "id", packageName)
                val imageView = findViewById<ImageView>(ivId)
                imageView.setImageResource(R.drawable.ic_black)
            } else if (col3[i] == 2) {
                i++
                val coord = coo + i
                val ivId = resources.getIdentifier(coord, "id", packageName)
                val imageView = findViewById<ImageView>(ivId)
                imageView.setImageResource(R.drawable.ic_white)
            } else {
                i++
            }
        }

        i = 0
        coo = "iv_gm_4_"
        while (i < col4.size) {
            if (col4[i] == 1) {
                i++
                val coord = coo + i
                val ivId = resources.getIdentifier(coord, "id", packageName)
                val imageView = findViewById<ImageView>(ivId)
                imageView.setImageResource(R.drawable.ic_black)
            } else if (col4[i] == 2) {
                i++
                val coord = coo + i
                val ivId = resources.getIdentifier(coord, "id", packageName)
                val imageView = findViewById<ImageView>(ivId)
                imageView.setImageResource(R.drawable.ic_white)
            } else {
                i++
            }
        }

        i = 0
        coo = "iv_gm_5_"
        while (i < col5.size) {
            if (col5[i] == 1) {
                i++
                val coord = coo + i
                val ivId = resources.getIdentifier(coord, "id", packageName)
                val imageView = findViewById<ImageView>(ivId)
                imageView.setImageResource(R.drawable.ic_black)
            } else if (col5[i] == 2) {
                i++
                val coord = coo + i
                val ivId = resources.getIdentifier(coord, "id", packageName)
                val imageView = findViewById<ImageView>(ivId)
                imageView.setImageResource(R.drawable.ic_white)
            } else {
                i++
            }
        }

        i = 0
        coo = "iv_gm_6_"
        while (i < col6.size) {
            if (col6[i] == 1) {
                i++
                val coord = coo + i
                val ivId = resources.getIdentifier(coord, "id", packageName)
                val imageView = findViewById<ImageView>(ivId)
                imageView.setImageResource(R.drawable.ic_black)
            } else if (col6[i] == 2) {
                i++
                val coord = coo + i
                val ivId = resources.getIdentifier(coord, "id", packageName)
                val imageView = findViewById<ImageView>(ivId)
                imageView.setImageResource(R.drawable.ic_white)
            } else {
                i++
            }
        }

        i = 0
        coo = "iv_gm_7_"
        while (i < col7.size) {
            if (col7[i] == 1) {
                i++
                val coord = coo + i
                val ivId = resources.getIdentifier(coord, "id", packageName)
                val imageView = findViewById<ImageView>(ivId)
                imageView.setImageResource(R.drawable.ic_black)
            } else if (col7[i] == 2) {
                i++
                val coord = coo + i
                val ivId = resources.getIdentifier(coord, "id", packageName)
                val imageView = findViewById<ImageView>(ivId)
                imageView.setImageResource(R.drawable.ic_white)
            } else {
                i++
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoadBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        load()

        val receivedArrays = intent.getSerializableExtra("arrays") as Array<IntArray>

        var sharedPreferences = getSharedPreferences("게임상태", MODE_PRIVATE)
        var editor = sharedPreferences.edit()

        // 효과음
        var soundId = soundPool.load(this, R.raw.hit, 1)

        // 타이머 구현
        val tv_sec = findViewById<TextView>(R.id.tv_second)
        val difficulty = intent.getStringExtra("difficulty")
        val sec = when (difficulty) {
            "easy" -> 60000 // 쉬운 난이도의 타이머 시간 (예: 60초)
            "normal" -> 30000 // 보통 난이도의 타이머 시간 (예: 30초)
            "hard" -> 15000 // 어려운 난이도의 타이머 시간 (예: 15초)
            else -> 30000 // 기본값으로 설정할 타이머 시간 (예: 30초)
        }
        val countDownTimer = object : CountDownTimer(sec.toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val num = (millisUntilFinished / 1000).toInt()
                tv_sec!!.text = Integer.toString(num + 1)

                if(num==0)
                {
                    if(turn == 0)
                    {
                        turn = 3
                        setTurn(turn)
                    }
                    else if(turn == 1)
                    {
                        turn = 2
                        setTurn(turn)
                    }
                }
            }

            override fun onFinish() {

            }
        }.start()

        showBurger()

        binding.tvOut.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        // 1열
        fun onImageViewClick1(view: View) {

            countDownTimer.onFinish()
            countDownTimer.start()
            var i = 0
            val coo = "iv_gm_1_"
            while (i < col1.size) {
                if (col1[i] == 0 && turn == 0) {
                    col1[i] = 1
                    i++
                    val coord = coo + i
                    val packageName = packageName
                    val ivId = resources.getIdentifier(coord, "id", packageName)
                    val imageView = findViewById<ImageView>(ivId)
                    imageView.setImageResource(R.drawable.ic_black)
                    soundPool.play(soundId, 1f, 1f, 0, 0, 1f)
                    val arrays = arrayOf(col1, col2, col3, col4, col5, col6, col7)
                    if(checkFourConnectedB(arrays) == true) {
                        countDownTimer.cancel()
                        turn = 2
                        setTurn(turn)
                        break
                    }
                    turn = 1
                    setTurn(turn)
                    Handler(Looper.getMainLooper()).postDelayed({
                        whiteRandom()
                        soundPool.play(soundId, 1f, 1f, 0, 0, 1f)
                        turn = 0
                        setTurn(turn)
                        countDownTimer.onFinish()
                        countDownTimer.start()
                        if(checkFourConnectedB(arrays) == true) {
                            countDownTimer.cancel()
                            turn = 3
                            setTurn(turn)
                        }
                    }, 3000)
                    break
                }
                i++
            }
        }

        fun onImageViewClick2(view: View) {

            countDownTimer.onFinish()
            countDownTimer.start()
            var i = 0
            val coo = "iv_gm_2_"
            while (i < col2.size) {
                if (col2[i] == 0 && turn == 0) {
                    col2[i] = 1
                    i++
                    val coord = coo + i
                    val packageName = packageName
                    val ivId = resources.getIdentifier(coord, "id", packageName)
                    val imageView = findViewById<ImageView>(ivId)
                    imageView.setImageResource(R.drawable.ic_black)
                    soundPool.play(soundId, 1f, 1f, 0, 0, 1f)
                    val arrays = arrayOf(col1, col2, col3, col4, col5, col6, col7)
                    if(checkFourConnectedB(arrays) == true) {
                        countDownTimer.cancel()
                        turn = 2
                        setTurn(turn)
                        break
                    }
                    turn = 1
                    setTurn(turn)
                    Handler(Looper.getMainLooper()).postDelayed({
                        whiteRandom()
                        soundPool.play(soundId, 1f, 1f, 0, 0, 1f)
                        turn = 0
                        setTurn(turn)
                        countDownTimer.onFinish()
                        countDownTimer.start()
                        if(checkFourConnectedB(arrays) == true) {
                            countDownTimer.cancel()
                            turn = 3
                            setTurn(turn)
                        }
                    }, 3000)
                    break
                }
                i++
            }
        }

        fun onImageViewClick3(view: View) {

            countDownTimer.onFinish()
            countDownTimer.start()
            var i = 0
            val coo = "iv_gm_3_"
            while (i < col3.size) {
                if (col3[i] == 0 && turn == 0) {
                    col3[i] = 1
                    i++
                    val coord = coo + i
                    val packageName = packageName
                    val ivId = resources.getIdentifier(coord, "id", packageName)
                    val imageView = findViewById<ImageView>(ivId)
                    imageView.setImageResource(R.drawable.ic_black)
                    soundPool.play(soundId, 1f, 1f, 0, 0, 1f)
                    val arrays = arrayOf(col1, col2, col3, col4, col5, col6, col7)
                    if(checkFourConnectedB(arrays) == true) {
                        countDownTimer.cancel()
                        turn = 2
                        setTurn(turn)
                        break
                    }
                    turn = 1
                    setTurn(turn)
                    Handler(Looper.getMainLooper()).postDelayed({
                        whiteRandom()
                        soundPool.play(soundId, 1f, 1f, 0, 0, 1f)
                        turn = 0
                        setTurn(turn)
                        countDownTimer.onFinish()
                        countDownTimer.start()
                        if(checkFourConnectedB(arrays) == true) {
                            countDownTimer.cancel()
                            turn = 3
                            setTurn(turn)
                        }
                    }, 3000)
                    break
                }
                i++
            }
        }

        fun onImageViewClick4(view: View) {

            countDownTimer.onFinish()
            countDownTimer.start()
            var i = 0
            val coo = "iv_gm_4_"
            while (i < col4.size) {
                if (col4[i] == 0 && turn == 0) {
                    col4[i] = 1
                    i++
                    val coord = coo + i
                    val packageName = packageName
                    val ivId = resources.getIdentifier(coord, "id", packageName)
                    val imageView = findViewById<ImageView>(ivId)
                    imageView.setImageResource(R.drawable.ic_black)
                    soundPool.play(soundId, 1f, 1f, 0, 0, 1f)
                    val arrays = arrayOf(col1, col2, col3, col4, col5, col6, col7)
                    if(checkFourConnectedB(arrays) == true) {
                        countDownTimer.cancel()
                        turn = 2
                        setTurn(turn)
                        break
                    }
                    turn = 1
                    setTurn(turn)
                    Handler(Looper.getMainLooper()).postDelayed({
                        whiteRandom()
                        soundPool.play(soundId, 1f, 1f, 0, 0, 1f)
                        turn = 0
                        setTurn(turn)
                        countDownTimer.onFinish()
                        countDownTimer.start()
                        if(checkFourConnectedB(arrays) == true) {
                            countDownTimer.cancel()
                            turn = 3
                            setTurn(turn)
                        }
                    }, 3000)
                    break
                }
                i++
            }
        }

        fun onImageViewClick5(view: View) {

            countDownTimer.onFinish()
            countDownTimer.start()
            var i = 0
            val coo = "iv_gm_5_"
            while (i < col5.size) {
                if (col5[i] == 0 && turn == 0) {
                    col5[i] = 1
                    i++
                    val coord = coo + i
                    val packageName = packageName
                    val ivId = resources.getIdentifier(coord, "id", packageName)
                    val imageView = findViewById<ImageView>(ivId)
                    imageView.setImageResource(R.drawable.ic_black)
                    soundPool.play(soundId, 1f, 1f, 0, 0, 1f)
                    val arrays = arrayOf(col1, col2, col3, col4, col5, col6, col7)
                    if(checkFourConnectedB(arrays) == true) {
                        countDownTimer.cancel()
                        turn = 2
                        setTurn(turn)
                        break
                    }
                    turn = 1
                    setTurn(turn)
                    Handler(Looper.getMainLooper()).postDelayed({
                        whiteRandom()
                        soundPool.play(soundId, 1f, 1f, 0, 0, 1f)
                        turn = 0
                        setTurn(turn)
                        countDownTimer.onFinish()
                        countDownTimer.start()
                        if(checkFourConnectedB(arrays) == true) {
                            countDownTimer.cancel()
                            turn = 3
                            setTurn(turn)
                        }
                    }, 3000)
                    break
                }
                i++
            }
        }

        fun onImageViewClick6(view: View) {

            countDownTimer.onFinish()
            countDownTimer.start()
            var i = 0
            val coo = "iv_gm_6_"
            while (i < col6.size) {
                if (col6[i] == 0 && turn == 0) {
                    col6[i] = 1
                    i++
                    val coord = coo + i
                    val packageName = packageName
                    val ivId = resources.getIdentifier(coord, "id", packageName)
                    val imageView = findViewById<ImageView>(ivId)
                    imageView.setImageResource(R.drawable.ic_black)
                    soundPool.play(soundId, 1f, 1f, 0, 0, 1f)
                    val arrays = arrayOf(col1, col2, col3, col4, col5, col6, col7)
                    if(checkFourConnectedB(arrays) == true) {
                        countDownTimer.cancel()
                        turn = 2
                        setTurn(turn)
                        break
                    }
                    turn = 1
                    setTurn(turn)
                    Handler(Looper.getMainLooper()).postDelayed({
                        whiteRandom()
                        soundPool.play(soundId, 1f, 1f, 0, 0, 1f)
                        turn = 0
                        setTurn(turn)
                        countDownTimer.onFinish()
                        countDownTimer.start()
                        if(checkFourConnectedB(arrays) == true) {
                            countDownTimer.cancel()
                            turn = 3
                            setTurn(turn)
                        }
                    }, 3000)
                    break
                }
                i++
            }
        }

        fun onImageViewClick7(view: View) {

            countDownTimer.onFinish()
            countDownTimer.start()
            var i = 0
            val coo = "iv_gm_7_"
            while (i < col7.size) {
                if (col7[i] == 0 && turn == 0) {
                    col7[i] = 1
                    i++
                    val coord = coo + i
                    val packageName = packageName
                    val ivId = resources.getIdentifier(coord, "id", packageName)
                    val imageView = findViewById<ImageView>(ivId)
                    imageView.setImageResource(R.drawable.ic_black)
                    soundPool.play(soundId, 1f, 1f, 0, 0, 1f)
                    val arrays = arrayOf(col1, col2, col3, col4, col5, col6, col7)
                    if(checkFourConnectedB(arrays) == true) {
                        countDownTimer.cancel()
                        turn = 2
                        setTurn(turn)
                        break
                    }
                    turn = 1
                    setTurn(turn)
                    Handler(Looper.getMainLooper()).postDelayed({
                        whiteRandom()
                        soundPool.play(soundId, 1f, 1f, 0, 0, 1f)
                        turn = 0
                        setTurn(turn)
                        countDownTimer.onFinish()
                        countDownTimer.start()
                        if(checkFourConnectedB(arrays) == true) {
                            countDownTimer.cancel()
                            turn = 3
                            setTurn(turn)
                        }
                    }, 3000)
                    break
                }
                i++
            }
        }


        binding.ivGm11.setOnClickListener {
            onImageViewClick1(it)
        }
        binding.ivGm12.setOnClickListener {
            onImageViewClick1(it)
        }
        binding.ivGm13.setOnClickListener {
            onImageViewClick1(it)
        }
        binding.ivGm14.setOnClickListener {
            onImageViewClick1(it)
        }
        binding.ivGm15.setOnClickListener {
            onImageViewClick1(it)
        }
        binding.ivGm16.setOnClickListener {
            onImageViewClick1(it)
        }

        binding.ivGm21.setOnClickListener {
            onImageViewClick2(it)
        }
        binding.ivGm22.setOnClickListener {
            onImageViewClick2(it)
        }
        binding.ivGm23.setOnClickListener {
            onImageViewClick2(it)
        }
        binding.ivGm24.setOnClickListener {
            onImageViewClick2(it)
        }
        binding.ivGm25.setOnClickListener {
            onImageViewClick2(it)
        }
        binding.ivGm26.setOnClickListener {
            onImageViewClick2(it)
        }

        binding.ivGm31.setOnClickListener {
            onImageViewClick3(it)
        }
        binding.ivGm32.setOnClickListener {
            onImageViewClick3(it)
        }
        binding.ivGm33.setOnClickListener {
            onImageViewClick3(it)
        }
        binding.ivGm34.setOnClickListener {
            onImageViewClick3(it)
        }
        binding.ivGm35.setOnClickListener {
            onImageViewClick3(it)
        }
        binding.ivGm36.setOnClickListener {
            onImageViewClick3(it)
        }

        binding.ivGm41.setOnClickListener {
            onImageViewClick4(it)
        }
        binding.ivGm42.setOnClickListener {
            onImageViewClick4(it)
        }
        binding.ivGm43.setOnClickListener {
            onImageViewClick4(it)
        }
        binding.ivGm44.setOnClickListener {
            onImageViewClick4(it)
        }
        binding.ivGm45.setOnClickListener {
            onImageViewClick4(it)
        }
        binding.ivGm46.setOnClickListener {
            onImageViewClick4(it)
        }

        binding.ivGm51.setOnClickListener {
            onImageViewClick5(it)
        }
        binding.ivGm52.setOnClickListener {
            onImageViewClick5(it)
        }
        binding.ivGm53.setOnClickListener {
            onImageViewClick5(it)
        }
        binding.ivGm54.setOnClickListener {
            onImageViewClick5(it)
        }
        binding.ivGm55.setOnClickListener {
            onImageViewClick5(it)
        }
        binding.ivGm56.setOnClickListener {
            onImageViewClick5(it)
        }

        binding.ivGm61.setOnClickListener {
            onImageViewClick6(it)
        }
        binding.ivGm62.setOnClickListener {
            onImageViewClick6(it)
        }
        binding.ivGm63.setOnClickListener {
            onImageViewClick6(it)
        }
        binding.ivGm64.setOnClickListener {
            onImageViewClick6(it)
        }
        binding.ivGm65.setOnClickListener {
            onImageViewClick6(it)
        }
        binding.ivGm66.setOnClickListener {
            onImageViewClick6(it)
        }

        binding.ivGm71.setOnClickListener {
            onImageViewClick7(it)
        }
        binding.ivGm72.setOnClickListener {
            onImageViewClick7(it)
        }
        binding.ivGm73.setOnClickListener {
            onImageViewClick7(it)
        }
        binding.ivGm74.setOnClickListener {
            onImageViewClick7(it)
        }
        binding.ivGm75.setOnClickListener {
            onImageViewClick7(it)
        }
        binding.ivGm76.setOnClickListener {
            onImageViewClick7(it)
        }


    }

    // 4목 완성 확인
    fun checkFourConnectedB(arrays: Array<IntArray>): Boolean {
        // Check horizontal direction for black (1) and white (2) stones
        for (row in arrays.indices) {
            for (col in 0 until arrays[row].size - 3) {
                if ((arrays[row][col] == 1 || arrays[row][col] == 2) &&
                    arrays[row][col] == arrays[row][col + 1] &&
                    arrays[row][col] == arrays[row][col + 2] &&
                    arrays[row][col] == arrays[row][col + 3]
                ) {
                    return true
                }
            }
        }

        // Check vertical direction for black (1) and white (2) stones
        for (col in arrays[0].indices) {
            for (row in 0 until arrays.size - 3) {
                if ((arrays[row][col] == 1 || arrays[row][col] == 2) &&
                    arrays[row][col] == arrays[row + 1][col] &&
                    arrays[row][col] == arrays[row + 2][col] &&
                    arrays[row][col] == arrays[row + 3][col]
                ) {
                    return true
                }
            }
        }

        // Check diagonal direction (\) for black (1) and white (2) stones
        for (row in 0 until arrays.size - 3) {
            for (col in 0 until arrays[row].size - 3) {
                if ((arrays[row][col] == 1 || arrays[row][col] == 2) &&
                    arrays[row][col] == arrays[row + 1][col + 1] &&
                    arrays[row][col] == arrays[row + 2][col + 2] &&
                    arrays[row][col] == arrays[row + 3][col + 3]
                ) {
                    return true
                }
            }
        }

        // Check diagonal direction (/) for black (1) and white (2) stones
        for (row in 0 until arrays.size - 3) {
            for (col in 3 until arrays[row].size) {
                if ((arrays[row][col] == 1 || arrays[row][col] == 2) &&
                    arrays[row][col] == arrays[row + 1][col - 1] &&
                    arrays[row][col] == arrays[row + 2][col - 2] &&
                    arrays[row][col] == arrays[row + 3][col - 3]
                ) {
                    return true
                }
            }
        }

        return false
    }

    // 백돌 랜덤 함수
    private fun whiteRandom() {
        val random = Random()
        val ranNum = random.nextInt(6) + 1

        if(ranNum == 1) {
            var i = 0
            val coo = "iv_gm_1_"
            while (i < col1.size) {
                if (col1[i] == 0) {
                    col1[i] = 2
                    i++
                    val coord = coo + i
                    val packageName = packageName
                    val ivId = resources.getIdentifier(coord, "id", packageName)
                    val imageView = findViewById<ImageView>(ivId)
                    imageView.setImageResource(R.drawable.ic_white)
                    break
                }
                i++
            }
        }
        else if(ranNum == 2) {
            var i = 0
            val coo = "iv_gm_2_"
            while (i < col2.size) {
                if (col2[i] == 0) {
                    col2[i] = 2
                    i++
                    val coord = coo + i
                    val packageName = packageName
                    val ivId = resources.getIdentifier(coord, "id", packageName)
                    val imageView = findViewById<ImageView>(ivId)
                    imageView.setImageResource(R.drawable.ic_white)
                    break
                }
                i++
            }
        }
        else if(ranNum == 3) {
            var i = 0
            val coo = "iv_gm_3_"
            while (i < col3.size) {
                if (col3[i] == 0) {
                    col3[i] = 2
                    i++
                    val coord = coo + i
                    val packageName = packageName
                    val ivId = resources.getIdentifier(coord, "id", packageName)
                    val imageView = findViewById<ImageView>(ivId)
                    imageView.setImageResource(R.drawable.ic_white)
                    break
                }
                i++
            }
        }
        else if(ranNum == 4) {
            var i = 0
            val coo = "iv_gm_4_"
            while (i < col4.size) {
                if (col4[i] == 0) {
                    col4[i] = 2
                    i++
                    val coord = coo + i
                    val packageName = packageName
                    val ivId = resources.getIdentifier(coord, "id", packageName)
                    val imageView = findViewById<ImageView>(ivId)
                    imageView.setImageResource(R.drawable.ic_white)

                    break
                }
                i++
            }
        }
        else if(ranNum == 5) {
            var i = 0
            val coo = "iv_gm_5_"
            while (i < col5.size) {
                if (col5[i] == 0) {
                    col5[i] = 2
                    i++
                    val coord = coo + i
                    val packageName = packageName
                    val ivId = resources.getIdentifier(coord, "id", packageName)
                    val imageView = findViewById<ImageView>(ivId)
                    imageView.setImageResource(R.drawable.ic_white)
                    break
                }
                i++
            }
        }
        else if(ranNum == 6) {
            var i = 0
            val coo = "iv_gm_6_"
            while (i < col6.size) {
                if (col6[i] == 0) {
                    col6[i] = 2
                    i++
                    val coord = coo + i
                    val packageName = packageName
                    val ivId = resources.getIdentifier(coord, "id", packageName)
                    val imageView = findViewById<ImageView>(ivId)
                    imageView.setImageResource(R.drawable.ic_white)
                    break
                }
                i++
            }
        }
        else {
            var i = 0
            val coo = "iv_gm_7_"
            while (i < col7.size) {
                if (col7[i] == 0) {
                    col7[i] = 2
                    i++
                    val coord = coo + i
                    val packageName = packageName
                    val ivId = resources.getIdentifier(coord, "id", packageName)
                    val imageView = findViewById<ImageView>(ivId)
                    imageView.setImageResource(R.drawable.ic_white)

                    break
                }
                i++
            }
        }
    }

    fun setTurn(t: Int) {
        val tv_turn = findViewById<TextView>(R.id.tv_yourturn)
        if(t == 1)
        {   tv_turn.text = "Opponent Turn" }
        else if(t == 0)
        {   tv_turn.text = "Your Turn"  }
        else if(t==2)
        {   tv_turn.text = "You Win!!"
            binding.tvOut.visibility = View.VISIBLE }
        else if(t==3)
        {   tv_turn.text = "You Lost.."
            binding.tvOut.visibility = View.VISIBLE }
    }


    // BurgerFragment 클릭 이벤트
    fun showBurger() {
        binding.btnBurger.setOnClickListener {
            val intent = Intent(this, BurgerActivity::class.java)
            startActivity(intent)
        }
    }
}

