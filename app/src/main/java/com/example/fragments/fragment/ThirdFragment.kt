package com.example.fragments.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.fragments.R
import com.example.fragments.model.User
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class ThirdFragment : Fragment() {

    private lateinit var textView: TextView
    private var send3: Send3? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        send3 = if (context is Send3)
            context
        else
            throw RuntimeException("Error")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_third, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btn: MaterialButton = view.findViewById(R.id.btn)
        val editText1: TextInputEditText = view.findViewById(R.id.editText)
        val editText2: TextInputEditText = view.findViewById(R.id.editText2)
        textView = view.findViewById(R.id.textView)

        btn.setOnClickListener {
            send3?.send3(User(editText1.text.toString().trim(), editText2.text.toString().trim()))
        }
    }
    interface Send3 {
        fun send3(user: User)
    }
    fun setUser(user: User) {
        textView.text = "${user.name}\n${user.lastName}"
    }

    override fun onDetach() {
        super.onDetach()
        send3 = null
    }
}