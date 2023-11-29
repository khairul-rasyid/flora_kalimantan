package com.rasyid.florakalimantan

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvFlora : RecyclerView
    private val list = ArrayList<Flora>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFlora = findViewById(R.id.rv_flora)
        rvFlora.setHasFixedSize(true)

        list.addAll(getFlora())
        showRecyclerList()
    }

    private fun getFlora(): ArrayList<Flora> {
        val photo = resources.obtainTypedArray(R.array.photo)
        val name = resources.getStringArray(R.array.name)
        val desc = resources.getStringArray(R.array.desc)
        val listFlora = ArrayList<Flora>()
        for (i in name.indices) {
            val flora = Flora(name[i], desc[i], photo.getResourceId(i, -1))
            listFlora.add(flora)
        }
        return listFlora
    }

    private fun showRecyclerList() {
        rvFlora.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = FloraAdapter(list)
        rvFlora.adapter = listHeroAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.about_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about -> {
                val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveIntent)
            }

        }
        return super.onOptionsItemSelected(item)
    }
}