package com.submission.yugioh

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.submission.yugioh.MainActivity.Companion.DATA_TAG
import com.submission.yugioh.databinding.ActivityDetailBinding
import com.submission.yugioh.model.Card
import com.submission.yugioh.repository.Repository
import com.submission.yugioh.utils.Constants.progressIndicator

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<Card>(DATA_TAG)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        val cardType =  "Card Type : ${data?.type}"
        val level =  "Level : ${data?.level}"
        val atk =  "ATK : ${data?.atk}"
        val def =  "DEF : ${data?.def}"
        val imgHD = data?.card_images!![0].image_url
        val imgSmall = data?.card_images!![0].image_url_small

        with(binding) {
            tvName.text = data?.name
            tvInfo.text = cardType
            tvInfo2.text = level
            tvInfo3.text = atk
            tvInfo4.text = def
            tvDescription.text = data?.desc
            Glide.with(this@DetailActivity)
                .load(imgSmall)
                .placeholder(this@DetailActivity.progressIndicator())
                .error(android.R.color.darker_gray)
                .into(ivCard)
        }

        binding.actionShare.setOnClickListener {
            val share = Intent()
            share.action = Intent.ACTION_SEND
            share.type = "text/plain"
            share.putExtra(Intent.EXTRA_TEXT, "Link : ${imgHD}")
            startActivity(Intent.createChooser(share, "Share via"))
        }

        binding.btnBack.setOnClickListener { onBackPressed() }
    }
}