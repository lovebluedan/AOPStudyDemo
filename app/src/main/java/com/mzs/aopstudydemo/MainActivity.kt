package com.mzs.aopstudydemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

open class MainActivity : AppCompatActivity() {

    companion object{
        const val TAG = "MainActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button2.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                test()
            }
        })

        button1.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                test()
            }
        })
    }

    fun test(){
        println("Hello,I am LIN")
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}
