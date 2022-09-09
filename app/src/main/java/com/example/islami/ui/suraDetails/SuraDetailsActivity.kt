package com.example.islami.ui.suraDetails

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R
import com.example.islami.constants

class SuraDetailsActivity : AppCompatActivity() {
    lateinit var titleTextView :TextView
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: versesAdapter


    @SuppressLint("UseSupportActionBar")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_sura_details)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        titleTextView =findViewById(R.id.title_text_view)
        initRecyclerView()
       val suraName:String = intent.getStringExtra(constants.Extra_Sura_Name) as String
        val suraPos:Int =intent.getIntExtra(constants.Extra_Sura_pos,-1)
        titleTextView.setText(suraName)
        readSuraFile(suraPos)


    }

    private fun initRecyclerView() {
        recyclerView=findViewById(R.id.recycler_view)
        adapter= versesAdapter()
        recyclerView.adapter=adapter
    }

    fun readSuraFile(pos:Int){
        val fileName="${pos+1}.txt"
        val fileContent = assets.open(fileName).bufferedReader().use { it.readText()}
        val verses :List<String> =fileContent.split("\n");
        adapter.changeData(verses)


    }

}