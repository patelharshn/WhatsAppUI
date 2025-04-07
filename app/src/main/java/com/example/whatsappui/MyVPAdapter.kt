package com.example.whatsappui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyVPAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> ChatsFragment()
            1 -> StatusFragment()
            2 -> ProfileFragment()
            3 -> CallsFragment()
            else -> ChatsFragment()
        }
    }
}