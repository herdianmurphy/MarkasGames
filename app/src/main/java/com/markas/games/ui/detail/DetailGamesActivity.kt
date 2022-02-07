package com.markas.games.ui.detail

import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.google.android.material.appbar.AppBarLayout
import com.markas.games.R
import com.markas.games.core.domain.model.Games
import com.markas.games.databinding.DetailGamesBinding
import org.koin.android.viewmodel.ext.android.viewModel

class DetailGamesActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var binding: DetailGamesBinding
    private val detailGamesViewModel : DetailGamesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailGamesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val games = intent.getParcelableExtra<Games>(EXTRA_DATA)
        val i = intent
        val platform = i.getStringExtra("platform")

        showDetailGames(games, platform)
    }

    private fun showDetailGames(games: Games?, platform: String?) {
        games?.let {
            var isShow = true
            var scrollRange = -1
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            binding.appBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { barLayout, verticalOffset ->
                if (scrollRange == -1){
                    scrollRange = barLayout?.totalScrollRange!!
                }
                if (scrollRange + verticalOffset == 0){
                    binding.collapsingToolbar.title = games.name
                    binding.collapsingToolbar.setCollapsedTitleTextColor(Color.BLACK)
                    isShow = true
                } else if (isShow){
                    binding.collapsingToolbar.title = " "
                    isShow = false
                }
            })

            Glide.with(this@DetailGamesActivity)
                .load(games.backgroundImage)
                .into(binding.detailImage)

            binding.content.title.text = games.name
            binding.content.ratingBar.rating = games.rating.toFloat()
            binding.content.rating.text = games.rating.toString()

            var statusFavorite = games.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                when {
                    platform.equals("PC") -> {
                        statusFavorite = !statusFavorite
                        detailGamesViewModel.setFavoritePcGames(games, statusFavorite)
                        setStatusFavorite(statusFavorite)
                    }
                    platform.equals("PS5") -> {
                        statusFavorite = !statusFavorite
                        detailGamesViewModel.setFavoritePsGames(games, statusFavorite)
                        setStatusFavorite(statusFavorite)
                    }
                    platform.equals("XBOX") -> {
                        statusFavorite = !statusFavorite
                        detailGamesViewModel.setFavoriteXboxGames(games, statusFavorite)
                        setStatusFavorite(statusFavorite)
                    }
                }
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_filled))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_outlined))
        }
    }

    override fun onBackPressed() {
        finish()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
