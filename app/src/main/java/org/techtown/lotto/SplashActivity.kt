package org.techtown.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)



        val handler = Handler(Looper.getMainLooper())
        val runnable = Runnable {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        handler.postDelayed(runnable,3000)
        //3초 후에 runnable객체가 실행되도록 함
        animationView.setOnClickListener{
            handler.removeCallbacks(runnable)
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)

            //main액티비티로 갔다가 다시 돌아오는 것 방지
            finish()
        }
    }

}