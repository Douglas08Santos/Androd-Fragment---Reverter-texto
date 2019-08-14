package com.example.reverterfragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_text.*

class TextFragment:Fragment() {
    var myListerner: OnInverterListener? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (!(context is OnInverterListener)){
            throw RuntimeException("Não é um OnInverterListener")
        }
        myListerner = context as OnInverterListener


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var myview: View = inflater.inflate(R.layout.fragment_text, container, false)

        var btnInverter = myview.findViewById<Button>(R.id.btnInverter)

        btnInverter.setOnClickListener {
            if (myListerner != null){
                var texto:String = edtTexto.text.toString()
                myListerner?.onInverter(texto)
            }

        }

        return myview


    }

    interface OnInverterListener {
        fun onInverter(text:String):Unit

    }
}