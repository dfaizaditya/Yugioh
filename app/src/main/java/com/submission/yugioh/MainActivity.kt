package com.submission.yugioh

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.submission.yugioh.databinding.ActivityMainBinding
import com.submission.yugioh.model.Card
import com.submission.yugioh.repository.Repository
import com.submission.yugioh.utils.Resource

class MainActivity : AppCompatActivity() {

    private lateinit var cardAdapter: CardAdapter
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    private var list: List<Card> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)

        viewModel = ViewModelProvider(this@MainActivity, viewModelFactory).get(MainViewModel::class.java)

        getData()
        setRecycler()

        binding.aboutPage.setOnClickListener {
            val mIntent = Intent(this@MainActivity, AboutActivity::class.java)
            startActivity(mIntent)
        }
    }

    private fun getData() {
        with(binding) {
            viewModel.getData().observe(this@MainActivity) { response ->
                when (response) {
                    is Resource.Loading -> {
                        progressBar.isVisible = true
                    }
                    is Resource.Success -> {
                        progressBar.isVisible = false
                        list = response.data.data
                        cardAdapter.submitList(list)
                    }
                    is Resource.Error -> {
                        progressBar.isVisible = false
                        Toast.makeText(this@MainActivity, response.error, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun setRecycler() {
        binding.rvCard.apply {
            cardAdapter = CardAdapter()

            adapter = cardAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)

            cardAdapter.setOnItemClickCallback(object : CardAdapter.OnItemClickCallback {
                override fun onItemClicked(data: Card) {
                    intentToDetail(data)
                }
            })
        }
    }

    private fun intentToDetail(data: Card) {
        Intent(this@MainActivity, DetailActivity::class.java).also {
            it.putExtra(DATA_TAG, data)
            startActivity(it)
        }
    }

    companion object {
        const val DATA_TAG = "Data :"
    }
}