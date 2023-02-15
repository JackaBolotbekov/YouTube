package com.example.youtube.ui.fragments

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.youtube.R
import com.example.youtube.base.BaseFragment
import com.example.youtube.databinding.FragmentYouTubeBinding
import com.example.youtube.ui.adapters.VideosCategoriesAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class YouTubeFragment :
    BaseFragment<FragmentYouTubeBinding, YouTubeViewModel>(R.layout.fragment_you_tube) {

    override val viewModel: YouTubeViewModel by viewModels()
    override val binding by viewBinding(FragmentYouTubeBinding::bind)
    private val videoAdapter = VideosCategoriesAdapter()

    override fun setupSubscribes() {
        subscribeToVideoPopular()
    }

    override fun initialize() = with(binding.recyclerView) {
        adapter = videoAdapter
    }

    private fun subscribeToVideoPopular() {
        viewModel.fetchVideosPopular("us", "mostPopular", "snippet").observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                videoAdapter.submitData(it)
            }
        }
    }
}