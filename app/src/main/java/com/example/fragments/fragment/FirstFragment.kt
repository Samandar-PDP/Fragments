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

class FirstFragment : Fragment() {

    private lateinit var textView: TextView

    private var firstListener: FirstListener? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button: Button = view.findViewById(R.id.btn)
        val editText: EditText = view.findViewById(R.id.editText)
        textView = view.findViewById(R.id.textView)

        button.setOnClickListener {
            firstListener?.sendFirst(editText.text.toString().trim())
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        firstListener = if (context is FirstListener)
            context
        else
            throw RuntimeException("Error occurred!")
    }

    override fun onDetach() {
        super.onDetach()
        firstListener = null
    }

    fun firstText(text: String) {
        textView.text = text
    }

    interface FirstListener {
        fun sendFirst(text: String)
    }
}