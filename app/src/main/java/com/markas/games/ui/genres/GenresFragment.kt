package com.markas.games.ui.genres

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.markas.games.core.adapter.GenresAdapter
import com.markas.games.core.data.Resource
import com.markas.games.databinding.FragmentGenresBinding
import org.koin.android.viewmodel.ext.android.viewModel

class GenresFragment : Fragment() {

    private val viewModel: GenresViewModel by viewModel()

    private var _binding: FragmentGenresBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGenresBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val genresAdapter = GenresAdapter()
            genresAdapter.onItemClick = { selectedData ->
                Toast.makeText(activity, "Cooming soon", Toast.LENGTH_SHORT).show()
            }

            viewModel.genresList.observe(viewLifecycleOwner, { genres ->
                if (genres != null) {
                    when (genres) {
                        is Resource.Loading -> binding.layoutShimmer.shimmerViewContainer.startShimmer()
                        is Resource.Success -> {
                            binding.layoutShimmer.shimmerViewContainer.stopShimmer()
                            binding.layoutShimmer.shimmerViewContainer.visibility = View.GONE
                            binding.recyclerView.visibility = View.VISIBLE
                            genresAdapter.setData(genres.data)
                        }
                        is Resource.Error -> {
                            binding.layoutShimmer.shimmerViewContainer.stopShimmer()
                            binding.layoutShimmer.shimmerViewContainer.visibility = View.GONE
                        }
                    }
                }
            })

            with(binding.recyclerView) {
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                adapter = genresAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}