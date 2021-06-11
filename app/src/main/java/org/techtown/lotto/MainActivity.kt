package org.techtown.lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val lotteryNumbers = arrayListOf(number1,number2,number3,number4,number5,number6)
        val countDownTimer = object:CountDownTimer(3000,100){
            override fun onTick(p0: Long) {
                lotteryNumbers.forEach{
                    val randomNumber = (Math.random()*45 + 1).toInt() //1~45의 랜덤값
                    it.text = "$randomNumber"
                }
            }
            //전체 3초 중에서 0.1초마다 랜덤값이 바뀜
            override fun onFinish() {
            }
        }

        lotteryButton.setOnClickListener{
            if(lotteryButton.isAnimating){
             lotteryButton.cancelAnimation()
             countDownTimer.cancel()
            }
            else {
                lotteryButton.playAnimation()
                countDownTimer.start()
            }
        }
    }
}