package com.route.appislami.ui.hadethDetails

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.route.appislami.databinding.ActivityHadethDetailsBinding
import com.route.appislami.ui.home.hadeth.Hadeth

class HadethDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityHadethDetailsBinding
    var hadeth: Hadeth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        readExtras()
        initViews()
    }

    private fun initViews() {
        title = null
        setSupportActionBar(binding.toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        binding.chapterTittle.text = hadeth?.title
        binding.content.content.text = hadeth?.content
    }

    private fun readExtras() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            hadeth = intent.getParcelableExtra(EXTRA_HADETH, Hadeth::class.java)
        } else {
            hadeth = intent.getParcelableExtra(EXTRA_HADETH) as Hadeth?
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    companion object {
        const val EXTRA_HADETH = "hadeth"
    }
}