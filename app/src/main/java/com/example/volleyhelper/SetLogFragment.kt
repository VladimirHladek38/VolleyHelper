package com.example.volleyhelper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SetLogFragment : Fragment() {
    private lateinit var setLogRecyclerAdapter: SetLogRecyclerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setLogRecyclerAdapter = SetLogRecyclerAdapter()
        setLogRecyclerAdapter.postItemsList(arguments?.getStringArrayList("setLog")!!)
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_set_log, container, false)

        val finalTeam1Score = view.findViewById<TextView>(R.id.finalTeam1Score)
        val finalTeam2Score = view.findViewById<TextView>(R.id.finalTeam2Score)
        val setLogRecyclerView = view.findViewById<RecyclerView>(R.id.setLogRecyclerView)
        val goBackButton = view.findViewById<Button>(R.id.goBackButton)

        setLogRecyclerView.adapter = setLogRecyclerAdapter
        setLogRecyclerView.layoutManager = LinearLayoutManager(this.context)

        finalTeam1Score.text = arguments?.getInt("team1Score").toString()
        finalTeam2Score.text = arguments?.getInt("team2Score").toString()

        goBackButton.setOnClickListener {
            val winFragment = WinFragment()
            val bundle = arguments
            winFragment.arguments = bundle

            val fragmentTransaction: FragmentTransaction? =
                activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.fragment, winFragment)
            fragmentTransaction?.commit()
        }

        return view
    }

}