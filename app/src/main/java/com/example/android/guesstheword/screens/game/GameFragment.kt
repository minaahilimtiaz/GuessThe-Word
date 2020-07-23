
package com.example.android.guesstheword.screens.game

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import com.example.android.guesstheword.R
import com.example.android.guesstheword.databinding.GameFragmentBinding

class GameFragment : Fragment() {

    private lateinit var binding: GameFragmentBinding
    private lateinit var viewModel: GameViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.game_fragment, container, false)
        viewModel= ViewModelProviders.of(this).get(GameViewModel::class.java)
        binding.correctButton.setOnClickListener { onCorrect() }
        binding.skipButton.setOnClickListener { onSkip() }
        binding.endGameButton.setOnClickListener { onEnd() }
        updateScreen();
        return binding.root

    }

    private fun onSkip() {
        viewModel.onSkip()
        updateScoreText()
        updateWordText()
    }

    private fun onCorrect() {
        viewModel.onCorrect()
        updateWordText()
        updateScoreText()
    }

    private fun onEnd(){
       val endAction = GameFragmentDirections.actionGameToScore()
       endAction.score=viewModel.score
        Log.d("Game Frag", endAction.toString())
        Toast.makeText(context, "Game Ended!", Toast.LENGTH_SHORT).show()
        NavHostFragment.findNavController(this).navigate(endAction)
    }

    private fun updateWordText() {
        binding.wordText.text = viewModel.word
    }

    private fun updateScoreText() {
        binding.scoreText.text = viewModel.score.toString()
    }

    private fun updateScreen(){
        updateScoreText()
        updateWordText()
    }
}
