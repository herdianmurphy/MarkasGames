package com.markas.games.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.markas.games.R
import com.markas.games.databinding.ActivityMainBinding
import com.markas.games.ui.games.GamesFragment
import com.markas.games.ui.genres.GenresFragment

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var isDoubleBackToExitPressedOnce = false

    private val gamesFragment = GamesFragment()
    private val genresFragment = GenresFragment()
    private var active: Fragment = gamesFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
    }

    private fun setupUI() {
        openGamesFragment()
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Markas Games"

        supportFragmentManager.beginTransaction().add(R.id.frameLayout, gamesFragment, "2")
            .hide(gamesFragment).commit()
        supportFragmentManager.beginTransaction().add(R.id.frameLayout, genresFragment, "1")
            .hide(genresFragment).commit()

        supportFragmentManager.beginTransaction().hide(active).show(gamesFragment).commit()
        active = gamesFragment

        binding.btnCenter.setOnClickListener(this)
        binding.menuBottom.setItemSelected(R.id.games)
        binding.menuBottom.setOnItemSelectedListener {
            when (it) {
                R.id.games -> {
                    openGamesFragment()
                }
                R.id.genres -> {
                    openGenresFragment()
                }
            }
        }
    }

    private fun openGamesFragment() {
        binding.tvCenter.visibility = View.INVISIBLE
        supportFragmentManager.beginTransaction().hide(active).show(gamesFragment).commit()
        active = gamesFragment
    }

    private fun openFavoriteList() {
        val uri = Uri.parse("games://favorite")
        startActivity(Intent(Intent.ACTION_VIEW, uri))
        overridePendingTransition(R.anim.slide_up, R.anim.fade_out)
    }

    private fun openGenresFragment() {
        binding.tvCenter.visibility = View.INVISIBLE
        supportFragmentManager.beginTransaction().hide(active).show(genresFragment).commit()
        active = genresFragment
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_center -> {
                openFavoriteList()
            }
        }
    }
}