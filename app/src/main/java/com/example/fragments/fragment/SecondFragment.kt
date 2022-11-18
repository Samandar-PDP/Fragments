package com.example.fragments.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.fragments.R

class SecondFragment : Fragment() {
    private var secondListener: SecondListener? = null
    private lateinit var textView: TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button: Button = view.findViewById(R.id.btn)
        val editText: EditText = view.findViewById(R.id.editText)
        textView = view.findViewById(R.id.textView)

        button.setOnClickListener {
            secondListener?.sendSecond(editText.text.toString().trim())
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        secondListener = if (context is SecondListener)
            context
        else
            throw RuntimeException("Error")
    }

    override fun onDetach() {
        super.onDetach()
        secondListener = null
    }

    fun secondText(text: String) {
        textView.text = text
    }

    interface SecondListener {
        fun sendSecond(text: String)
    }
}