package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragments.fragment.FirstFragment
import com.example.fragments.fragment.SecondFragment

class MainActivity : AppCompatActivity(), FirstFragment.FirstListener, SecondFragment.SecondListener {
    private lateinit var firstFragment: FirstFragment
    private lateinit var secondFragment: SecondFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        firstFragment = FirstFragment()
        secondFragment = SecondFragment()

        replaceFragments()
    }

    override fun sendFirst(text: String) {
        secondFragment.secondText(text)
    }

    override fun sendSecond(text: String) {
        firstFragment.firstText(text)
    }

    private fun replaceFragments() {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame1, firstFragment)
            replace(R.id.frame2, secondFragment)
            commit()
        }
    }
}