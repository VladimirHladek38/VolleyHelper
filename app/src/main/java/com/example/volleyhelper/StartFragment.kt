package com.example.volleyhelper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentTransaction


class StartFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_start, container, false)

        val startButton = view.findViewById<Button>(R.id.startButton)
        val editTeam1Name = view.findViewById<EditText>(R.id.editTeam1Name)
        val editTeam2Name = view.findViewById<EditText>(R.id.editTeam2Name)

        var team1playerList = ArrayList<Player>()
        var team2playerList = ArrayList<Player>()


        startButton.setOnClickListener {
            team1playerList = setupTeam1Data()
            team2playerList = setupTeam2Data()
            var team1 = Team(
                editTeam1Name.text.toString(),
                team1playerList,
                0
            )
            var team2 = Team(
                editTeam2Name.text.toString(),
                team2playerList,
                0
            )

            val bundle = Bundle()
            bundle.putString("team1Name",team1.teamName.toString())
            //bundle.putInt("team1Score",0)

            for (i in 1..6){
                bundle.putString("team1Player${i}Name",team1.playerList[i-1].name)
                bundle.putInt("team1Player${i}HitCount",team1.playerList[i-1].hitCount)
                bundle.putInt("team1Player${i}AceCount",team1.playerList[i-1].aceCount)
                bundle.putInt("team1Player${i}BlockCount",team1.playerList[i-1].blockCount)
                bundle.putInt("team1Player${i}BlockOutCount",team1.playerList[i-1].blockOutCount)
                bundle.putInt("team1Player${i}OutCount",team1.playerList[i-1].outCount)
                bundle.putInt("team1Player${i}ServeErrorCount",team1.playerList[i-1].serveErrorCount)
                bundle.putInt("team1Player${i}NetErrorCount",team1.playerList[i-1].netErrorCount)
                bundle.putInt("team1Player${i}PassErrorCount",team1.playerList[i-1].passErrorCount)
            }
            bundle.putString("team2Name",team2.teamName.toString())
            //bundle.putInt("team2Score",0)
            for (i in 1..6){
                bundle.putString("team2Player${i}Name",team2.playerList[i-1].name)
                bundle.putInt("team2Player${i}HitCount",team2.playerList[i-1].hitCount)
                bundle.putInt("team2Player${i}AceCount",team2.playerList[i-1].aceCount)
                bundle.putInt("team2Player${i}BlockCount",team2.playerList[i-1].blockCount)
                bundle.putInt("team2Player${i}BlockOutCount",team2.playerList[i-1].blockOutCount)
                bundle.putInt("team2Player${i}OutCount",team2.playerList[i-1].outCount)
                bundle.putInt("team2Player${i}ServeErrorCount",team2.playerList[i-1].serveErrorCount)
                bundle.putInt("team2Player${i}NetErrorCount",team2.playerList[i-1].netErrorCount)
                bundle.putInt("team2Player${i}PassErrorCount",team2.playerList[i-1].passErrorCount)
            }

            bundle.putStringArrayList("eventLogLines", arrayListOf("", "", "", "", "", ""))
            bundle.putStringArrayList("setLog", arrayListOf<String>("The set starts:"))

            val playFragment=PlayFragment()

            playFragment.arguments = bundle

            val fragmentTransaction: FragmentTransaction? =
                activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.fragment, playFragment)
            fragmentTransaction?.commit()
        }

        return  view
    }

    private fun setupTeam1Data(): ArrayList<Player> {
        val editTeam1Player1Name = view?.findViewById<EditText>(R.id.editTeam1Player1Name)
        val editTeam1Player2Name = view?.findViewById<EditText>(R.id.editTeam1Player2Name)
        val editTeam1Player3Name = view?.findViewById<EditText>(R.id.editTeam1Player3Name)
        val editTeam1Player4Name = view?.findViewById<EditText>(R.id.editTeam1Player4Name)
        val editTeam1Player5Name = view?.findViewById<EditText>(R.id.editTeam1Player5Name)
        val editTeam1Player6Name = view?.findViewById<EditText>(R.id.editTeam1Player6Name)
        val list = ArrayList<Player>()
        list.add(
            Player(
                editTeam1Player1Name?.text.toString(),
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0
            )
        )
        list.add(
            Player(
                editTeam1Player2Name?.text.toString(),
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0
            )
        )
        list.add(
            Player(
                editTeam1Player3Name?.text.toString(),
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0
            )
        )
        list.add(
            Player(
                editTeam1Player4Name?.text.toString(),
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0
            )
        )
        list.add(
            Player(
                editTeam1Player5Name?.text.toString(),
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0
            )
        )
        list.add(
            Player(
                editTeam1Player6Name?.text.toString(),
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0
            )
        )
        return list
    }

    private fun setupTeam2Data(): ArrayList<Player> {
        val editTeam2Player1Name = view?.findViewById<EditText>(R.id.editTeam2Player1Name)
        val editTeam2Player2Name = view?.findViewById<EditText>(R.id.editTeam2Player2Name)
        val editTeam2Player3Name = view?.findViewById<EditText>(R.id.editTeam2Player3Name)
        val editTeam2Player4Name = view?.findViewById<EditText>(R.id.editTeam2Player4Name)
        val editTeam2Player5Name = view?.findViewById<EditText>(R.id.editTeam2Player5Name)
        val editTeam2Player6Name = view?.findViewById<EditText>(R.id.editTeam2Player6Name)
        val list = ArrayList<Player>()
        list.add(
            Player(
                editTeam2Player1Name?.text.toString(),
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0
            )
        )
        list.add(
            Player(
                editTeam2Player2Name?.text.toString(),
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0
            )
        )
        list.add(
            Player(
                editTeam2Player3Name?.text.toString(),
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0
            )
        )
        list.add(
            Player(
                editTeam2Player4Name?.text.toString(),
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0
            )
        )
        list.add(
            Player(
                editTeam2Player5Name?.text.toString(),
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0
            )
        )
        list.add(
            Player(
                editTeam2Player6Name?.text.toString(),
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0
            )
        )
        return list
    }
}