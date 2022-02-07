package com.markas.games.favorite.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.markas.games.core.adapter.FavoriteAdapter
import com.markas.games.core.utils.CustomItemDecoration
import com.markas.games.favorite.R
import com.markas.games.favorite.databinding.TabFavoritePcBinding
import com.markas.games.ui.detail.DetailGamesActivity
import org.koin.android.viewmodel.ext.android.viewModel

class TabFavoritePc : Fragment() {

    private var _binding: TabFavoritePcBinding? = null
    private val binding get() = _binding!!

    private val favoriteViewModel: FavoriteViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = TabFavoritePcBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val favoritePcAdapter = FavoriteAdapter()
            favoritePcAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailGamesActivity::class.java)
                intent.putExtra(DetailGamesActivity.EXTRA_DATA, selectedData)
                intent.putExtra("platform", "PC")
                startActivity(intent)
            }

            favoriteViewModel.favoritePc.observe(viewLifecycleOwner, { dataFavorite ->
                favoritePcAdapter.setData(dataFavorite)
                binding.viewEmpty.root.visibility = if (dataFavorite.isNotEmpty()) View.GONE else View.VISIBLE
            })

            with(binding.recyclerView) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                addItemDecoration(
                    CustomItemDecoration(resources.getDimensionPixelSize(R.dimen.recycler_margin))
                )
                adapter = favoritePcAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}