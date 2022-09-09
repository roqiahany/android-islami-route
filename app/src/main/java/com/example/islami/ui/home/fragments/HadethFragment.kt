package com.example.islami.ui.home.fragments

import android.content.Intent
import android.os.Bundle
import android.os.ParcelFileDescriptor.open
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R
import com.example.islami.constants

import com.example.islami.ui.hadethDetails.HadethDetailsActivity
import com.example.islami.ui.home.fragments.adapter.HadethNamesAdapter
import com.example.islami.ui.home.fragments.adapter.SuraNamesAdapter
import com.example.islami.ui.suraDetails.SuraDetailsActivity
import java.nio.channels.AsynchronousFileChannel.open
import java.nio.channels.AsynchronousServerSocketChannel.open
import java.nio.channels.AsynchronousSocketChannel.open
import java.nio.channels.DatagramChannel.open


class HadethFragment :Fragment() {
    val chapterNames = listOf(
        "الحد يث الأول",
        "الحد يث الثاني",
        "الحد يث الـثـالـث",
        "الحد يث الـرابع",
        "الحد يث الخامس",
        "الحد يث السادس",
        "الحد يث السابع",
        "الحد يث الثامن",
        "الحديث التاسع",
        "الحديث العاشر",
        "الحديث الحادي عشر",
        "الحد يث الثاني عشر",
        "الحد يث الثالث عشر",
        "الحد يث الرابع عشر",
        "الحد يث الخامس عشر",
        "الحديث السادس عشر",
        "الحديث السابع عشر",
        "الحديث الثامن عشر",
        "الحد يث التاسع عشر",
        "الحد يث العشرون"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hadeth, container, false);
    }

    lateinit var recyclerViewHadeth: RecyclerView
    lateinit var adapterHadeth: HadethNamesAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
    }

    fun initRecycler() {
        recyclerViewHadeth = requireView().findViewById(R.id.recycler_view)
        adapterHadeth = HadethNamesAdapter(chapterNames)
        adapterHadeth.onHadethClickListener = object : HadethNamesAdapter.OnHadethClickListener {
            override fun onHadethClick(pos: Int, name: String) {
                // Toast.makeText(requireActivity(),name,Toast.LENGTH_LONG).show()
                showHadethDetails(pos, name)

            }

        }
        recyclerViewHadeth.adapter = adapterHadeth

    }

    fun showHadethDetails(pos: Int, name: String) {
        val intent = Intent(requireActivity(), HadethDetailsActivity::class.java)
        intent.putExtra("hadeth_name",name)
        intent.putExtra("hadeth_pos",pos)

        startActivity(intent);
    }

}

