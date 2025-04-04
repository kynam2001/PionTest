package com.vigelos.piontest.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.vigelos.piontest.R
import com.vigelos.piontest.data.model.DetailContent
import com.vigelos.piontest.databinding.ActivityDetailBinding
import com.vigelos.piontest.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val viewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        viewModel.detailJson.observe(this) {
            binding.title.text = it.title
            binding.description.text = it.description
            for(section in it.sections){
                when(section.section_type){
                    1 -> {
                        binding.type1.text = "Section 1 demo"
                        binding.textType1.text = (section.content as DetailContent.TextContent).text
                    }
                    2 -> {
                        binding.type2.text = "Section 2 demo"
                        binding.videoType2.setVideoPath((section.content as DetailContent.VideoContent).href)
                        binding.videoType2.start()
                    }
                    3 -> {
                        binding.type3.text = "Section 3 demo"
                        Glide.with(this).load((section.content as DetailContent.ImageContent).href).into(binding.imageType3)
                    }
                }
            }
        }
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.fetchDetailJson()
        }
    }
}