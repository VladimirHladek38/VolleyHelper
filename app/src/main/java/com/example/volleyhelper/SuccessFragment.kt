package com.example.volleyhelper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentTransaction


class SuccessFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_success, container, false)
        val player1SuccessButton = view.findViewById<Button>(R.id.player1SuccessButton)
        val player2SuccessButton = view.findViewById<Button>(R.id.player2SuccessButton)
        val player3SuccessButton = view.findViewById<Button>(R.id.player3SuccessButton)
        val player4SuccessButton = view.findViewById<Button>(R.id.player4SuccessButton)
        val player5SuccessButton = view.findViewById<Button>(R.id.player5SuccessButton)
        val player6SuccessButton = view.findViewById<Button>(R.id.player6SuccessButton)
        val goBackButton = view.findViewById<Button>(R.id.goBackButton)

        val teamIndex = arguments?.getInt("teamIndex")?.toInt()

        player1SuccessButton.text = arguments?.getString("team${teamIndex.toString()}Player1Name")
        player2SuccessButton.text = arguments?.getString("team${teamIndex.toString()}Player2Name")
        player3SuccessButton.text = arguments?.getString("team${teamIndex.toString()}Player3Name")
        player4SuccessButton.text = arguments?.getString("team${teamIndex.toString()}Player4Name")
        player5SuccessButton.text = arguments?.getString("team${teamIndex.toString()}Player5Name")
        player6SuccessButton.text = arguments?.getString("team${teamIndex.toString()}Player6Name")

        goBackButton.setOnClickListener {
            val pointFragment = pointFragment()
            val bundle = arguments
            pointFragment.arguments = bundle

            val fragmentTransaction: FragmentTransaction? =
                activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.fragment, pointFragment)
            fragmentTransaction?.commit()
        }

        player1SuccessButton.setOnClickListener {
            addData(teamIndex!!, 1)
        }

        player2SuccessButton.setOnClickListener {
            addData(teamIndex!!, 2)
        }

        player3SuccessButton.setOnClickListener {
            addData(teamIndex!!, 3)
        }

        player4SuccessButton.setOnClickListener {
            addData(teamIndex!!, 4)
        }

        player5SuccessButton.setOnClickListener {
            addData(teamIndex!!, 5)
        }

        player6SuccessButton.setOnClickListener {
            addData(teamIndex!!, 6)
        }

        return view
    }

    private fun addData(teamIndex: Int, playerIndex: Int) {
        val playFragment = PlayFragment()
        val bundle = arguments
        val score = arguments?.getInt("team${teamIndex.toString()}Score")?.toInt()?.plus(1)
        if (score != null) {
            if (teamIndex == 1) {
                bundle?.putInt("team1Score", score)
            }
            else{
                bundle?.putInt("team2Score", score)
            }
        }

        val pointIndex = arguments?.getInt("pointIndex")


        val eventLogLines = arguments?.getStringArrayList("eventLogLines")
        val setLog :MutableList<String>
        setLog = arguments?.getStringArrayList("setLog")!!
        val playerName = arguments?.getString("team${teamIndex.toString()}Player${playerIndex}Name")
        var team1Score = bundle?.getInt("team1Score")
        var team2Score = bundle?.getInt("team2Score")
        if(pointIndex == 1){
            bundle?.putInt("team${teamIndex.toString()}Player${playerIndex}HitCount",arguments?.getInt("team${teamIndex}Player${playerIndex}HitCount")!!+1)
            for(i in 1..5){
                eventLogLines?.set(6-i, eventLogLines?.get(5-i))
            }
            eventLogLines?.set(0, "${playerName} hits")
            setLog.add("${playerName} hits for ${team1Score} : ${team2Score}")
        }
        else if(pointIndex == 2){
            bundle?.putInt("team${teamIndex.toString()}Player${playerIndex}AceCount",arguments?.getInt("team${teamIndex}Player${playerIndex}AceCount")!!+1)
            for(i in 1..5){
                eventLogLines?.set(6-i, eventLogLines?.get(5-i))
            }
            eventLogLines?.set(0, "${playerName} aces")
            setLog.add("${playerName} aces for ${team1Score} : ${team2Score}")
        }
        else if(pointIndex == 3){
            bundle?.putInt("team${teamIndex.toString()}Player${playerIndex}BlockCount",arguments?.getInt("team${teamIndex}Player${playerIndex}BlockCount")!!+1)
            for(i in 1..5){
                eventLogLines?.set(6-i, eventLogLines?.get(5-i))
            }
            eventLogLines?.set(0, "${playerName} blocks")
            setLog.add("${playerName} blocks for ${team1Score} : ${team2Score}")
        }
        else{
            bundle?.putInt("team${teamIndex.toString()}Player${playerIndex}BlockOutCount",arguments?.getInt("team${teamIndex}Player${playerIndex}BlockOutCount")!!+1)
            for(i in 1..5){
                eventLogLines?.set(6-i, eventLogLines?.get(5-i))
            }
            eventLogLines?.set(0, "${playerName} gets a block out")
            setLog.add("${playerName} gets a block out for ${team1Score} : ${team2Score}")
        }

        var setLogArrayList: ArrayList<String>
        setLogArrayList = setLog as ArrayList<String>
        bundle?.putStringArrayList("setLog", setLogArrayList)

        playFragment.arguments = bundle

        val fragmentTransaction: FragmentTransaction? =
            activity?.supportFragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.fragment, playFragment)
        fragmentTransaction?.commit()
    }
}