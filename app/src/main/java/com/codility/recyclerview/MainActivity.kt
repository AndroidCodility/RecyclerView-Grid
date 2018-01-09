package com.codility.recyclerview

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                setTitle(R.string.title_recycler_view)
                getUserList()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                setTitle(R.string.title_recycler_grid_view)
                getUserGridViewList()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        //Set List
        getUserList()
    }

    private fun getUserList() {
        recyclerView.visibility = View.VISIBLE
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val users = ArrayList<User>()

        for (i in 1..20) {
            users.add(User("Govind ".plus(i), "New BEL Road, " + "Bangalore".plus(i)))
        }

        val myAdapter = MyAdapter(users)
        recyclerView.adapter = myAdapter

    }

    private fun getUserGridViewList() {
        recyclerView.visibility = View.VISIBLE
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val users = ArrayList<User>()

        for (i in 1..20) {
            users.add(User("Rastogi ".plus(i), "Siliguri, " + "Darjeeling"))
        }

        val myAdapter = MyAdapter(users)
        recyclerView.adapter = myAdapter

    }
}
