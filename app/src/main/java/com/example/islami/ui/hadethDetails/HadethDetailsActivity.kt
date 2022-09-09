package com.example.islami.ui.hadethDetails

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R
import com.example.islami.constants
import com.example.islami.ui.suraDetails.versesAdapter

class HadethDetailsActivity : AppCompatActivity() {
    lateinit var titleTextViewhadeth : TextView
    lateinit var recyclerViewHadeth: RecyclerView
    lateinit var adapterHadeth : VersesAdapterHadeth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hadeth_details)

        setSupportActionBar(findViewById(R.id.toolbar_hadeth))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        titleTextViewhadeth =findViewById(R.id.title_text_view_hadeth)
         initRecyclerViewHadeth()

        val hadethName:String = intent.getStringExtra("hadeth_name") as String
        val hadethPos:Int =intent.getIntExtra("hadeth_pos",-1)

        titleTextViewhadeth.setText(hadethName)

        readHadethFile(hadethPos)


    }
    fun initRecyclerViewHadeth(){
        recyclerViewHadeth=findViewById(R.id.recycler_view_details)
        adapterHadeth= VersesAdapterHadeth()
        recyclerViewHadeth.adapter=adapterHadeth

    }
    fun readHadethFile(pos :Int) {
        val fileNamehadeth ="h${pos+1}.txt"
        val fileContenthadeth = assets.open(fileNamehadeth).bufferedReader().use {it .readText() }
        val verses :List<String> =fileContenthadeth.split("\n");
        adapterHadeth.changeDataHadeth(verses)

    }
}