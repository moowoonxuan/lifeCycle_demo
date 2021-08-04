package com.example.lifecycle_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.lifecycle_demo.Models.Question

class SecondActivity : AppCompatActivity() {

    private lateinit var myModel : Question

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Log.i("LifeCycle","onCreate")

        val btn: Button = findViewById(R.id.btnAdd)
        val tv: TextView = findViewById(R.id.tvQuestion)
        val tvName: TextView = findViewById(R.id.tvName)

        //myModel = Question()
        //myModel = ViewModelProvider(this).get(Question::class.java)
        myModel = Question.getInstance()

        tv.text = myModel.getQuestion()
        tvName.text = myModel.name

//        if(savedInstanceState != null)
//         tv.text = savedInstanceState?.getString("question")

        btn.setOnClickListener()
        {
            tv.text = myModel.generateQuestion()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("LifeCycle","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("LifeCycle","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("LifeCycle","onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.i("LifeCycle","onResume")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("LifeCycle","onResume")
    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//
//        var q = findViewById<TextView>(R.id.tvQuestion).text.toString()
//                outState.putString("question", q)
//    }


//    fun generateQuestion(): String {
//        var no1 = (Math.random() * 100).toInt()
//        var no2 = (Math.random() * 100).toInt()
//
//        return "${no1} + ${no2} = ?"
//    }
}