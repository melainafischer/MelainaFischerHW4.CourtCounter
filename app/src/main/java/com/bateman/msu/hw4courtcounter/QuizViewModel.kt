package com.bateman.msu.hw4courtcounter

import android.util.Log
import android.widget.TextView.SavedState
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
//import com.bateman.msu.hw4courtcounter

private const val TAG = "QuizViewModel"
const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"

class QuizViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    private val KEY_SCORE_TEAM_A = "scoreTeamA"
    private val KEY_SCORE_TEAM_B = "scoreTeamB"

    init {
        if (!savedStateHandle.contains(KEY_SCORE_TEAM_A)) {
            savedStateHandle.set(KEY_SCORE_TEAM_A, 0)
        }
        if (!savedStateHandle.contains(KEY_SCORE_TEAM_B)) {
            savedStateHandle.set(KEY_SCORE_TEAM_B, 0)
        }
    }

    fun updateScoreTeamA(points: Int) {
        savedStateHandle.set(KEY_SCORE_TEAM_A, scoreTeamA + points)
    }

    fun updateScoreTeamB(points: Int) {
        savedStateHandle.set(KEY_SCORE_TEAM_B, scoreTeamB + points)
    }

    val scoreTeamA: Int
        get() = savedStateHandle.get(KEY_SCORE_TEAM_A) ?: 0

    val scoreTeamB: Int
        get() = savedStateHandle.get(KEY_SCORE_TEAM_B) ?: 0
}