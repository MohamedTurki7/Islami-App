package com.route.appislami.ui.chapterDetails

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.route.appislami.R
import com.route.appislami.databinding.ActivityChapterDetailsBinding

class ChapterDetailsActivity : AppCompatActivity() {
    private var chapterPosition: Int = -1
    private lateinit var chapterTittle: String
    private lateinit var tvTittle: TextView
    private lateinit var versesRecycle: RecyclerView
    private lateinit var binding: ActivityChapterDetailsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChapterDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding
        initParams()
        initViews()
        readChapter()


    }

    private fun readChapter() {
        val allFileContent = assets.open("${chapterPosition + 1}.txt")
            .bufferedReader().use { it.readText() }
        val versesList = allFileContent.split("\n")
        bindVersesToRecyclerViewAdapter(versesList)
    }

    private fun bindVersesToRecyclerViewAdapter(versesList: List<String>) {
        val versesAdapter = VersesAdapter(versesList)
        versesRecycle.adapter = versesAdapter


    }


    private fun initViews() {
        val toolbar: Toolbar = findViewById(R.id.tool_bar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        title = null
        tvTittle = findViewById(R.id.chapter_tittle)
        versesRecycle = findViewById(R.id.verses_recycle)
        tvTittle.text = chapterTittle

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun initParams() {
        chapterPosition = intent.getIntExtra(EXTRA_POSITION, -1)
        chapterTittle = intent.getStringExtra(EXTRA_TITTLE) ?: ""

    }

    companion object {
        const val EXTRA_TITTLE = "tittle"
        const val EXTRA_POSITION = "position"

    }

}