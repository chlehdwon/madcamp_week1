package com.example.madcamp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream
import kotlinx.android.synthetic.main.activity_main.*
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()
        val pagerAdapter = FragmentAdapter(supportFragmentManager)
        val pager = findViewById<ViewPager>(R.id.viewpager)
        pager.adapter = pagerAdapter
        val tab = findViewById<TabLayout>(R.id.tablayout)
        tab.setupWithViewPager(pager)
        tab.getTabAt(0)?.setIcon(R.drawable.icon1_white)
        tab.getTabAt(1)?.setIcon(R.drawable.icon2_black)
        tab.getTabAt(2)?.setIcon(R.drawable.icon3_black)
    }

    override fun onCreateOptionsMenu(menu: Menu?):Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.logout){
            mAuth.signOut()
            val intent = Intent(this@MainActivity, Login::class.java)
            finish()
            startActivity(intent)
            return true
        }
        return true
    }


    fun changer(index: Int){
        var viewpager: ViewPager = findViewById(R.id.viewpager)
        viewpager.setCurrentItem(index)
    }
}