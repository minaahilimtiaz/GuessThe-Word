package com.example.android.guesstheword.screens.score

import android.util.Log
import androidx.lifecycle.ViewModel

class ScoreViewModel(val score: Int) : ViewModel() {

    val finalScore: Int = score

    init {
        Log.i("ScoreFragment", "Sore Fragment Creaetd")
    }

}