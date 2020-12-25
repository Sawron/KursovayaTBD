package com.example.kursovayatbd.item

import com.example.kursovayatbd.R
import com.example.kursovayatbd.database.entity.VisitorEntity
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder

import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.visitor_item.*


class VisitorItem(
    private val visitor: VisitorEntity
) : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.id_visit.text = visitor.idVisit.toString()
        viewHolder.name_visit.text = visitor.nameVisit
        viewHolder.surname.text = visitor.surname
        viewHolder.address.text = visitor.address
        viewHolder.phone_number.text = visitor.phoneNumber
    }

    override fun getLayout(): Int {
        return R.layout.visitor_item
    }
}