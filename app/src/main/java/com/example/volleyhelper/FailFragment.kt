package com.example.volleyhelper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentTransaction


class FailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_fail, container, false)

        val player1FailButton = view.findViewById<Button>(R.id.player1FailButton)
        val player2FailButton = view.findViewById<Button>(R.id.player2FailButton)
        val player3FailButton = view.findViewById<Button>(R.id.player3FailButton)
        val player4FailButton = view.findViewById<Button>(R.id.player4FailButton)
        val player5FailButton = view.findViewById<Button>(R.id.player5FailButton)
        val player6FailButton = view.findViewById<Button>(R.id.player6FailButton)
        val goBackButton = view.findViewById<Button>(R.id.goBackButton)
        val teamIndex:Int

        if(arguments?.getInt("teamIndex")?.toInt() == 1){
            teamIndex = 2
        }
        else{
            teamIndex = 1
        }

        player1FailButton.text = arguments?.getString("team${teamIndex.toString()}Player1Name")
        player2FailButton.text = arguments?.getString("team${teamIndex.toString()}Player2Name")
        player3FailButton.text = arguments?.getString("team${teamIndex.toString()}Player3Name")
        player4FailButton.text = arguments?.getString("team${teamIndex.toString()}Player4Name")
        player5FailButton.text = arguments?.getString("team${teamIndex.toString()}Player5Name")
        player6FailButton.text = arguments?.getString("team${teamIndex.toString()}Player6Name")

        goBackButton.setOnClickListener {
            val pointFragment = pointFragment()
            val bundle = arguments
            pointFragment.arguments = bundle

            val fragmentTransaction: FragmentTransaction? =
                activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.fragment, pointFragment)
            fragmentTransaction?.commit()
        }

        player1FailButton.setOnClickListener {
            addData(teamIndex!!, 1)
        }

        player2FailButton.setOnClickListener {
            addData(teamIndex!!, 2)
        }

        player3FailButton.setOnClickListener {
            addData(teamIndex!!, 3)
        }

        player4FailButton.setOnClickListener {
            addData(teamIndex!!, 4)
        }

        player5FailButton.setOnClickListener {
            addData(teamIndex!!, 5)
        }

        player6FailButton.setOnClickListener {
            addData(teamIndex!!, 6)
        }

        return view
    }

    private fun addData(teamIndex: Int, playerIndex: Int) {
        val playFragment = PlayFragment()
        val bundle = arguments
        val reverseTeamIndex = arguments?.getInt("teamIndex")
        val score = arguments?.getInt("team${reverseTeamIndex.toString()}Score")?.toInt()?.plus(1)
        if (score != null) {
            if (reverseTeamIndex == 1) {
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
            bundle?.putInt("team${teamIndex.toString()}Player${playerIndex}OutCount",arguments?.getInt("team${teamIndex}Player${playerIndex}OutCount")!!+1)
            for(i in 1..5){
                eventLogLines?.set(6-i, eventLogLines?.get(5-i))
            }
            eventLogLines?.set(0, "${playerName} hits it out")
            setLog.add("${playerName} hits it out for ${team1Score} : ${team2Score}")
        }
        else if(pointIndex == 2){
            bundle?.putInt("team${teamIndex.toString()}Player${playerIndex}ServeErrorCount",arguments?.getInt("team${teamIndex}Player${playerIndex}ServeErrorCount")!!+1)
            for(i in 1..5){
                eventLogLines?.set(6-i, eventLogLines?.get(5-i))
            }
            eventLogLines?.set(0, "${playerName} serves wrong")
            setLog.add("${playerName} serves wrong for ${team1Score} : ${team2Score}")
        }
        else if(pointIndex == 3){
            bundle?.putInt("team${teamIndex.toString()}Player${playerIndex}NetErrorCount",arguments?.getInt("team${teamIndex}Player${playerIndex}NetErrorCount")!!+1)
            for(i in 1..5){
                eventLogLines?.set(6-i, eventLogLines?.get(5-i))
            }
            eventLogLines?.set(0, "${playerName} makes a net error")
            setLog.add("${playerName} makes a net error for ${team1Score} : ${team2Score}")
        }
        else{
            bundle?.putInt("team${teamIndex.toString()}Player${playerIndex}PassErrorCount",arguments?.getInt("team${teamIndex}Player${playerIndex}PassErrorCount")!!+1)
            for(i in 1..5){
                eventLogLines?.set(6-i, eventLogLines?.get(5-i))
            }
            eventLogLines?.set(0, "${playerName} passes wrong")
            setLog.add("${playerName} passes wrong for ${team1Score} : ${team2Score}")
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