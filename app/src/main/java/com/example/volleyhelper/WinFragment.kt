package com.example.volleyhelper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction


class WinFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_win, container, false)

        val winner = view.findViewById<TextView>(R.id.winner)
        val finalTeam1Score = view.findViewById<TextView>(R.id.finalTeam1Score)
        val finalTeam2Score = view.findViewById<TextView>(R.id.finalTeam2Score)
        val mvp = view.findViewById<TextView>(R.id.mvp)
        val playerStatsButton = view.findViewById<Button>(R.id.playerStatsButton)
        val setLogButton = view.findViewById<Button>(R.id.setLogButton)
        val playAgainButton = view.findViewById<Button>(R.id.playAgainButton)


        winner.text = "${arguments?.getString("team${arguments?.getInt("winningTeamIndex")}Name")} won"
        finalTeam1Score.text = arguments?.getInt("team1Score").toString()
        finalTeam2Score.text = arguments?.getInt("team2Score").toString()
        mvp.text = "MVP: ${getBestPlayerName()}"

        playerStatsButton.setOnClickListener {
            val statsFragment = StatsFragment()
            val bundle = arguments
            statsFragment.arguments = bundle

            val fragmentTransaction: FragmentTransaction? =
                activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.fragment, statsFragment)
            fragmentTransaction?.commit()
        }

        setLogButton.setOnClickListener {
            val setLogFragment = SetLogFragment()
            val bundle = arguments
            setLogFragment.arguments = bundle

            val fragmentTransaction: FragmentTransaction? =
                activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.fragment, setLogFragment)
            fragmentTransaction?.commit()
        }

        playAgainButton.setOnClickListener {
            val startFragment = StartFragment()

            val fragmentTransaction: FragmentTransaction? =
                activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.fragment, startFragment)
            fragmentTransaction?.commit()
        }

        return view
    }

    private fun getBestPlayerName(): String {
        var playerScores = arrayListOf<Int>(0,0,0,0,0,0,0,0,0,0,0,0)

        for(j in 1..2) {
            for (i in 1..6) {
                playerScores[i-1 + (j-1)*6] = (calculatePlayerScore(j,i))
            }
        }

        var bestPlayerIndex = 1
        var bestScore = playerScores[0]
        for(i in 1..11){
            if(playerScores[i] > bestScore){
                bestScore = playerScores[i]
                bestPlayerIndex = i+1
            }
        }

        if(bestPlayerIndex > 6){
            return arguments?.getString("team2Player${bestPlayerIndex-6}Name").toString()
        }
        return arguments?.getString("team1Player${bestPlayerIndex}Name").toString()
    }

    private fun calculatePlayerScore(teamIndex: Int, playerIndex: Int): Int {
        var pointCount = arguments?.getInt("team${teamIndex}Player${playerIndex}HitCount")?.plus(
            arguments?.getInt("team${teamIndex}Player${playerIndex}AceCount")!!)?.plus(
            arguments?.getInt("team${teamIndex}Player${playerIndex}BlockCount")!!)?.plus(
            arguments?.getInt("team${teamIndex}Player${playerIndex}BlockOutCount")!!)

        var errorCount = arguments?.getInt("team${teamIndex}Player${playerIndex}OutCount")?.plus(
            arguments?.getInt("team${teamIndex}Player${playerIndex}ServeErrorCount")!!)?.plus(
            arguments?.getInt("team${teamIndex}Player${playerIndex}NetErrorCount")!!)?.plus(
            arguments?.getInt("team${teamIndex}Player${playerIndex}PassErrorCount")!!)
        if (pointCount != null) {
            return pointCount - errorCount!!
        }
        return 0
    }
}