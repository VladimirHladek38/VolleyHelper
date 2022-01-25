package com.example.volleyhelper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction

class PlayerStatsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_player_stats, container, false)

        val selectedPlayer = view.findViewById<TextView>(R.id.selectedPlayer)
        val hitScore = view.findViewById<TextView>(R.id.hitScore)
        val aceScore = view.findViewById<TextView>(R.id.aceScore)
        val blockScore = view.findViewById<TextView>(R.id.blockScore)
        val blockOutScore = view.findViewById<TextView>(R.id.blockOutScore)
        val outScore = view.findViewById<TextView>(R.id.outScore)
        val serveErrorScore = view.findViewById<TextView>(R.id.serveErrorScore)
        val netErrorScore = view.findViewById<TextView>(R.id.netErrorScore)
        val passErrorScore = view.findViewById<TextView>(R.id.passErrorScore)
        val goBackButton = view.findViewById<Button>(R.id.goBackButton)

        var selectedTeamIndex = arguments?.getInt("teamIndex")
        var selectedPlayerIndex = arguments?.getInt("playerIndex")

        selectedPlayer.text = "${arguments?.getString("team${selectedTeamIndex}Player${selectedPlayerIndex}Name")}s stats"

        hitScore.text = "${arguments?.getInt("team${selectedTeamIndex}Player${selectedPlayerIndex}HitCount")} hits"
        aceScore.text = "${arguments?.getInt("team${selectedTeamIndex}Player${selectedPlayerIndex}AceCount")} aces"
        blockScore.text = "${arguments?.getInt("team${selectedTeamIndex}Player${selectedPlayerIndex}BlockCount")} blocks"
        blockOutScore.text = "${arguments?.getInt("team${selectedTeamIndex}Player${selectedPlayerIndex}BlockOutScore")} block outs"
        outScore.text = "${arguments?.getInt("team${selectedTeamIndex}Player${selectedPlayerIndex}OutCount")} outs"
        serveErrorScore.text = "${arguments?.getInt("team${selectedTeamIndex}Player${selectedPlayerIndex}ServeErrorCount")} serve errors"
        netErrorScore.text = "${arguments?.getInt("team${selectedTeamIndex}Player${selectedPlayerIndex}NetErrorCount")} net errors"
        passErrorScore.text = "${arguments?.getInt("team${selectedTeamIndex}Player${selectedPlayerIndex}PassErrorCount")} pass errors"

        goBackButton.setOnClickListener {
            val statsFragment = StatsFragment()
            val bundle = arguments
            statsFragment.arguments = bundle

            val fragmentTransaction: FragmentTransaction? =
                activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.fragment, statsFragment)
            fragmentTransaction?.commit()
        }

        return view
    }
}