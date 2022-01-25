package com.example.volleyhelper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction


class pointFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_point, container, false)

        val scoringTeam = view.findViewById<TextView>(R.id.scoringTeam)
        val goBackButton = view.findViewById<Button>(R.id.goBackButton)
        val hitButton = view.findViewById<Button>(R.id.hitButton)
        val aceButton = view.findViewById<Button>(R.id.aceButton)
        val blockButton = view.findViewById<Button>(R.id.blockButton)
        val blockOutButton = view.findViewById<Button>(R.id.blockOutButton)
        val outButton = view.findViewById<Button>(R.id.outButton)
        val serveErrorButton = view.findViewById<Button>(R.id.serveErrorButton)
        val netErrorButton = view.findViewById<Button>(R.id.netErrorButton)
        val passErrorButton = view.findViewById<Button>(R.id.passErrorButton)


        val scoringTeamIndex = arguments?.getInt("teamIndex")
        val scoringTeamName = arguments?.getString("team${scoringTeamIndex}Name")
            .toString()

        scoringTeam.text = "${scoringTeamName} score"

        goBackButton.setOnClickListener {
            val playFragment = PlayFragment()
            val bundle = arguments
            playFragment.arguments = bundle

            val fragmentTransaction: FragmentTransaction? =
                activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.fragment, playFragment)
            fragmentTransaction?.commit()
        }

        hitButton.setOnClickListener {
            success(1)
        }

        aceButton.setOnClickListener {
            success(2)
        }

        blockButton.setOnClickListener {
            success(3)
        }

        blockOutButton.setOnClickListener {
            success(4)
        }

        outButton.setOnClickListener {
            failure(1)
        }

        serveErrorButton.setOnClickListener {
            failure(2)
        }

        netErrorButton.setOnClickListener {
            failure(3)
        }

        passErrorButton.setOnClickListener {
            failure(4)
        }

        return view
    }

    private fun success(pointIndex: Int) {
        val successFragment = SuccessFragment()
        val bundle = arguments
        bundle?.putInt("pointIndex",pointIndex)
        successFragment.arguments = bundle

        val fragmentTransaction: FragmentTransaction? =
            activity?.supportFragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.fragment, successFragment)
        fragmentTransaction?.commit()
    }

    private fun failure(pointIndex: Int) {
        val failFragment = FailFragment()
        val bundle = arguments
        bundle?.putInt("pointIndex",pointIndex)
        failFragment.arguments = bundle

        val fragmentTransaction: FragmentTransaction? =
            activity?.supportFragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.fragment, failFragment)
        fragmentTransaction?.commit()
    }
}