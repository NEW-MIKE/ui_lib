package com.example.ui_demo_start.workview

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ui_demo_start.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TelescopeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_telescope)
    }

    companion object{
        fun actionStart(context: Context){
            val intent = Intent(context,TelescopeActivity::class.java)
            context.startActivity(intent)
        }
    }
}


fun main(){
    GlobalScope.launch {
        launch {

            test1()
            delay(10)
            println("i am ok1")
        }
        launch {

            test2()
            println("i am ok2")
        }
    }
    Thread.sleep(400)
}

suspend fun test1()
{
    delay(100)
    println(1)
}
suspend fun test2()
{
    delay(10)
    println(2)
}