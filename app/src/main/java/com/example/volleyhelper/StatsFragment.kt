package com.example.volleyhelper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction

class StatsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_stats, container, false)

        val team1Playe1StatsButton = view.findViewById<Button>(R.id.team1Player1StatsButton)
        val team1Playe2StatsButton = view.findViewById<Button>(R.id.team1Player2StatsButton)
        val team1Playe3StatsButton = view.findViewById<Button>(R.id.team1Player3StatsButton)
        val team1Playe4StatsButton = view.findViewById<Button>(R.id.team1Player4StatsButton)
        val team1Playe5StatsButton = view.findViewById<Button>(R.id.team1Player5StatsButton)
        val team1Playe6StatsButton = view.findViewById<Button>(R.id.team1Player6StatsButton)
        val team2Playe1StatsButton = view.findViewById<Button>(R.id.team2Player1StatsButton)
        val team2Playe2StatsButton = view.findViewById<Button>(R.id.team2Player2StatsButton)
        val team2Playe3StatsButton = view.findViewById<Button>(R.id.team2Player3StatsButton)
        val team2Playe4StatsButton = view.findViewById<Button>(R.id.team2Player4StatsButton)
        val team2Playe5StatsButton = view.findViewById<Button>(R.id.team2Player5StatsButton)
        val team2Playe6StatsButton = view.findViewById<Button>(R.id.team2Player6StatsButton)
        val goBackButton = view.findViewById<Button>(R.id.goBackButton)

        goBackButton.setOnClickListener {
            val winFragment = WinFragment()
            val bundle = arguments
            winFragment.arguments = bundle

            val fragmentTransaction: FragmentTransaction? =
                activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.fragment, winFragment)
            fragmentTransaction?.commit()
        }

        team1Playe1StatsButton.text = arguments?.getString("team1Player1Name")
        team1Playe2StatsButton.text = arguments?.getString("team1Player2Name")
        team1Playe3StatsButton.text = arguments?.getString("team1Player3Name")
        team1Playe4StatsButton.text = arguments?.getString("team1Player4Name")
        team1Playe5StatsButton.text = arguments?.getString("team1Player5Name")
        team1Playe6StatsButton.text = arguments?.getString("team1Player6Name")
        team2Playe1StatsButton.text = arguments?.getString("team2Player1Name")
        team2Playe2StatsButton.text = arguments?.getString("team2Player2Name")
        team2Playe3StatsButton.text = arguments?.getString("team2Player3Name")
        team2Playe4StatsButton.text = arguments?.getString("team2Player4Name")
        team2Playe5StatsButton.text = arguments?.getString("team2Player5Name")
        team2Playe6StatsButton.text = arguments?.getString("team2Player6Name")

        team1Playe1StatsButton.setOnClickListener {
            viewPlayerStats(1, 1)
        }

        team1Playe2StatsButton.setOnClickListener {
            viewPlayerStats(1, 2)
        }

        team1Playe3StatsButton.setOnClickListener {
            viewPlayerStats(1, 3)
        }

        team1Playe4StatsButton.setOnClickListener {
            viewPlayerStats(1, 4)
        }

        team1Playe5StatsButton.setOnClickListener {
            viewPlayerStats(1, 5)
        }

        team1Playe6StatsButton.setOnClickListener {
            viewPlayerStats(1, 6)
        }

        team2Playe1StatsButton.setOnClickListener {
            viewPlayerStats(2, 1)
        }

        team2Playe2StatsButton.setOnClickListener {
            viewPlayerStats(2, 2)
        }

        team2Playe3StatsButton.setOnClickListener {
            viewPlayerStats(2, 3)
        }

        team2Playe4StatsButton.setOnClickListener {
            viewPlayerStats(2, 4)
        }

        team2Playe5StatsButton.setOnClickListener {
            viewPlayerStats(2, 5)
        }

        team2Playe6StatsButton.setOnClickListener {
            viewPlayerStats(2, 6)
        }

        return view
    }

    private fun viewPlayerStats(teamIndex: Int, playerIndex: Int) {
        val playerStatsFragment = PlayerStatsFragment()
        val bundle = arguments
        bundle?.putInt("teamIndex", teamIndex)
        bundle?.putInt("playerIndex", playerIndex)

        playerStatsFragment.arguments = bundle

        val fragmentTransaction: FragmentTransaction? =
            activity?.supportFragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.fragment, playerStatsFragment)
        fragmentTransaction?.commit()
    }
}