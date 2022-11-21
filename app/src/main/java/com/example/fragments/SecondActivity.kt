package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragments.fragment.FourthFragment
import com.example.fragments.fragment.ThirdFragment
import com.example.fragments.model.User

class SecondActivity : AppCompatActivity(), ThirdFragment.Send3, FourthFragment.Send4 {
    private lateinit var thirdFragment: ThirdFragment
    private lateinit var fourthFragment: FourthFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        supportActionBar?.hide()

        thirdFragment = ThirdFragment()
        fourthFragment = FourthFragment()
        beginTransaction()
    }

    private fun beginTransaction() {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame1, thirdFragment)
            replace(R.id.frame2, fourthFragment)
            commit()
        }
    }

    override fun send4(user: User) {
        thirdFragment.setUser(user)
    }

    override fun send3(user: User) {
        fourthFragment.setUser(user)
    }
}