package com.example.kursovayatbd.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.kursovayatbd.R
import com.example.kursovayatbd.database.serializable_data.DataVisitors
import com.example.kursovayatbd.database.Database
import com.example.kursovayatbd.database.entity.VisitorEntity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.menu_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    lateinit var database: Database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        setContentView(R.layout.activity_main)
        initDataBase()
    }

    override fun onResume() {
        super.onResume()
        navigationView.bringToFront()
        setupMenuActions()
        replaceFragment(
            DataVisitors(
                database.visitorDao().getAllVisitors()
            )
        )
    }


    private fun setupMenuActions() {
        menuButton.setOnClickListener {
            drawerLayout.open()
        }
        visitors.setOnClickListener {
            replaceFragment(
                DataVisitors(
                    database.visitorDao().getAllVisitors()
                )
            )
            drawerLayout.close()
        }

    }

    private fun replaceFragment(data: Serializable){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, TableFragment().apply {
                this.arguments = Bundle().apply {
                    putSerializable(
                        "data", data
                    )
                }
            }).commit()
    }

    private fun initDataBase() {

        database = Room.databaseBuilder(this@MainActivity, Database::class.java, "database")
            .allowMainThreadQueries().build().also { it.clearAllTables() }

        database.visitorDao().insertVisitorEntity(
            VisitorEntity(
                1,
                "2020-02-01 20:46:55",
                "87",
                "80435 American Ash Junction",
                "573-336-5408"
            )
        )
        database.visitorDao().insertVisitorEntity(
            VisitorEntity(
                2,
                "2019-12-01 21:41:55",
                "35",
                "6 Village Drive",
                "646-827-4673"
            )
        )
        database.visitorDao().insertVisitorEntity(
            VisitorEntity(
                3,
                "2020-04-02 02:46:51",
                "64",
                "21486 Mitchell Hill",
                "516-981-8126"
            )
        )
        database.visitorDao().insertVisitorEntity(
            VisitorEntity(
                4,
                "2019-02-03 12:26:53",
                "12",
                "06 Prairieview Way",
                "543-531-3588"
            )
        )
        database.visitorDao().insertVisitorEntity(
            VisitorEntity(
                5,
                "2020-12-12 14:13:00",
                "Binnion",
                "0 Maple Wood Trail",
                "714-429-8181"
            )
        )


    }
}