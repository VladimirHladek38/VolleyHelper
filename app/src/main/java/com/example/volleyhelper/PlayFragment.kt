package com.example.volleyhelper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import java.lang.StrictMath.abs

class PlayFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_play, container, false)

        val team1Name = view.findViewById<TextView>(R.id.team1Name)
        val team2Name = view.findViewById<TextView>(R.id.team2Name)
        val team1Score = view.findViewById<TextView>(R.id.finalTeam1Score)
        val team2Score = view.findViewById<TextView>(R.id.finalTeam2Score)
        val team1Scores = view.findViewById<Button>(R.id.team1ScoresButton)
        val team2Scores = view.findViewById<Button>(R.id.team2ScoresButton)
        val eventLog = view.findViewById<TextView>(R.id.eventLog)

        val eventLogLines = arguments?.getStringArrayList("eventLogLines")

        eventLog.text = formatStringList(eventLogLines)

        team1Name.text = arguments?.getString("team1Name").toString()
        team2Name.text = arguments?.getString("team2Name").toString()

        team1Scores.text = "${team1Name.text} scores"
        team2Scores.text = "${team2Name.text} scores"

        team1Score.text = arguments?.getInt("team1Score").toString()
        team2Score.text = arguments?.getInt("team2Score").toString()

        var team1ScoreInteger = arguments?.getInt("team1Score")
        var team2ScoreInteger = arguments?.getInt("team2Score")

        print(team1ScoreInteger)
        println(team2ScoreInteger)

        if(team1ScoreInteger != null && team2ScoreInteger != null){
            if(abs(team1ScoreInteger - team2ScoreInteger) >= 2) {
                if (team1ScoreInteger >= 25) {
                    endSet(1)

                } else if (team2ScoreInteger >= 25) {
                    endSet(2)
                }
            }
        }

        team1Scores.setOnClickListener {
            addScore(1)
        }

        team2Scores.setOnClickListener {
            addScore(2)
        }


        return view
    }

    private fun endSet(winningTeamIndex: Int) {
        val winFragment = WinFragment()
        val bundle = arguments
        bundle?.putInt("winningTeamIndex",winningTeamIndex)
        winFragment.arguments = bundle

        val fragmentTransaction: FragmentTransaction? =
            activity?.supportFragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.fragment, winFragment)
        fragmentTransaction?.commit()
    }

    private fun formatStringList(stringList: ArrayList<String>?): String {
        var product = stringList?.get(0)
        for(i in 1..5){
            product = "${product}\n${stringList?.get(i)}"
        }
        return product.toString()
    }

    private fun addScore(teamIndex: Int) {
        val pointFragment = pointFragment()
        val bundle = arguments
        bundle?.putInt("teamIndex",teamIndex)
        pointFragment.arguments = bundle

        val fragmentTransaction: FragmentTransaction? =
            activity?.supportFragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.fragment, pointFragment)
        fragmentTransaction?.commit()

    }
}