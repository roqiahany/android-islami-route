package com.example.islami.ui.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.islami.R


class TasbehFragment :Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tasbeh, container, false);
    }

    lateinit var counter :Button
    lateinit var zekr :Button
    var generalCounter = 0
    var count =0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        counter=requireView().findViewById(R.id.counter)
        zekr=requireView().findViewById(R.id.zekr)

        counter.setOnClickListener {
            count++
            generalCounter++

            if (generalCounter == 30) {
                count = 0
                zekr.setText("استغفرالله")

            }else if (generalCounter==60){
                count =0
                zekr.setText("سبحان الله")

            }
            else if (generalCounter==90){
                count =0
                zekr.setText("لا اله الا الله")
            }
            else if (generalCounter==120){
                count =0
                zekr.setText("الله اكبر")
            }
            else if (generalCounter==150){
                count =0
                zekr.setText("سبحان الله و بحمده ")
            }
            else if (generalCounter==180){
                count =0
                zekr.setText("سبحان الله العظيم")
            }
            else if (generalCounter==210){
                count =0
                zekr.setText("لا حول و لا قوة الا بالله")
            }
            counter.setText(count.toString())


        }


    }
    }



