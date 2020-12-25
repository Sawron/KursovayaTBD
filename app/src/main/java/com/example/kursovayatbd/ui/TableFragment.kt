package com.example.kursovayatbd.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.kursovayatbd.R
import com.example.kursovayatbd.database.serializable_data.DataVisitors
import com.example.kursovayatbd.item.VisitorItem
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.table_layout.*

class TableFragment() : Fragment(R.layout.table_layout) {

    private val adapter = GroupAdapter<GroupieViewHolder>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv.adapter = adapter
        val data = requireArguments().getSerializable("data")
        when (data) {
            is DataVisitors -> {
                requireActivity().toolbar.titleToolbar.text = "walk"
                adapter.addAll(data.visitors.map {
                    VisitorItem(it)
                })
            }
        }
    }

}