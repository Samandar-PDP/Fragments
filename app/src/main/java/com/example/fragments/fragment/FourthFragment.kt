package com.example.fragments.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.fragments.R
import com.example.fragments.model.User
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class FourthFragment : Fragment() {

    private lateinit var textView: TextView
    private var send4: Send4? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        send4 = if (context is Send4)
            context
        else
            throw RuntimeException("Error")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btn: MaterialButton = view.findViewById(R.id.btn)
        val editText1: TextInputEditText = view.findViewById(R.id.editText)
        val editText2: TextInputEditText = view.findViewById(R.id.editText2)
        textView = view.findViewById(R.id.textView)
        btn.setOnClickListener {
            send4?.send4(User(editText1.text.toString().trim(), editText2.text.toString().trim()))
            Toast.makeText(requireContext(), "Hello", Toast.LENGTH_SHORT).show()
        }
    }
    interface Send4 {
        fun send4(user: User)
    }

    override fun onDetach() {
        super.onDetach()
        send4 = null
    }
    fun setUser(user: User) {
        textView.text = "${user.name}\n${user.lastName}"
    }
}