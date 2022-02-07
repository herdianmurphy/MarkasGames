package com.markas.games.ui.games

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.markas.games.core.data.Resource
import com.markas.games.databinding.FragmentGamesBinding
import com.markas.games.core.adapter.PcGamesAdapter
import com.markas.games.core.adapter.PsGamesAdapter
import com.markas.games.core.adapter.XboxGamesAdapter
import com.markas.games.ui.detail.DetailGamesActivity
import org.koin.android.viewmodel.ext.android.viewModel

class GamesFragment : Fragment() {

    private val viewModel: GamesViewModel by viewModel()

    private var _binding: FragmentGamesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentGamesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val pcGamesAdapter = PcGamesAdapter()
            pcGamesAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailGamesActivity::class.java)
                intent.putExtra(DetailGamesActivity.EXTRA_DATA, selectedData)
                intent.putExtra("platform", "PC")
                startActivity(intent)
            }
            val psGamesAdapter = PsGamesAdapter()
            psGamesAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailGamesActivity::class.java)
                intent.putExtra(DetailGamesActivity.EXTRA_DATA, selectedData)
                intent.putExtra("platform", "PS5")
                startActivity(intent)
            }
            val xboxGamesAdapter = XboxGamesAdapter()
            xboxGamesAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailGamesActivity::class.java)
                intent.putExtra(DetailGamesActivity.EXTRA_DATA, selectedData)
                intent.putExtra("platform", "XBOX")
                startActivity(intent)
            }

            viewModel.pcGames.observe(viewLifecycleOwner, { games ->
                if (games != null) {
                    when (games) {
                        is Resource.Loading -> binding.layoutShimmerPc.shimmerViewContainer.startShimmer()
                        is Resource.Success -> {
                            binding.layoutShimmerPc.shimmerViewContainer.stopShimmer()
                            binding.layoutShimmerPc.shimmerViewContainer.visibility = View.GONE
                            binding.contentPc.visibility = View.VISIBLE
                            pcGamesAdapter.setData(games.data)
                        }
                        is Resource.Error -> {
                            binding.layoutShimmerPc.shimmerViewContainer.stopShimmer()
                            binding.layoutShimmerPc.shimmerViewContainer.visibility = View.GONE
                        }
                    }
                }
            })
            viewModel.psGames.observe(viewLifecycleOwner, { games ->
                if (games != null) {
                    when (games) {
                        is Resource.Loading -> binding.layoutShimmerPs.shimmerViewContainer.startShimmer()
                        is Resource.Success -> {
                            binding.layoutShimmerPs.shimmerViewContainer.stopShimmer()
                            binding.layoutShimmerPs.shimmerViewContainer.visibility = View.GONE
                            binding.contentPs.visibility = View.VISIBLE
                            psGamesAdapter.setData(games.data)
                        }
                        is Resource.Error -> {
                            binding.layoutShimmerPs.shimmerViewContainer.stopShimmer()
                            binding.layoutShimmerPs.shimmerViewContainer.visibility = View.GONE
                        }
                    }
                }
            })
            viewModel.xboxGames.observe(viewLifecycleOwner, { games ->
                if (games != null) {
                    when (games) {
                        is Resource.Loading -> binding.layoutShimmerXbox.shimmerViewContainer.startShimmer()
                        is Resource.Success -> {
                            binding.layoutShimmerXbox.shimmerViewContainer.stopShimmer()
                            binding.layoutShimmerXbox.shimmerViewContainer.visibility = View.GONE
                            binding.contentXbox.visibility = View.VISIBLE
                            xboxGamesAdapter.setData(games.data)
                        }
                        is Resource.Error -> {
                            binding.layoutShimmerXbox.shimmerViewContainer.stopShimmer()
                            binding.layoutShimmerXbox.shimmerViewContainer.visibility = View.GONE
                        }
                    }
                }
            })

            with(binding.recyclerPc) {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)
                setPadding(24, 0, 24, 0)
                adapter = pcGamesAdapter
            }
            with(binding.recyclerPs) {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)
                setPadding(24, 0, 24, 0)
                adapter = psGamesAdapter
            }
            with(binding.recyclerXbox) {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)
                setPadding(24, 0, 24, 0)
                adapter = xboxGamesAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}