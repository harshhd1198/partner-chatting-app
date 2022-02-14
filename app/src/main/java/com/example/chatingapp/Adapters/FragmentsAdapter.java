package com.example.chatingapp.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.chatingapp.Fragments.CallsFragment;
import com.example.chatingapp.Fragments.ChatsFragment;
import com.example.chatingapp.Fragments.StatusFragment;

public class FragmentsAdapter extends FragmentPagerAdapter {
    public FragmentsAdapter( FragmentManager fm) {
        super(fm);
    }




    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0: return  new ChatsFragment();
            case 1: return  new StatusFragment();
            case 2: return  new CallsFragment();
            default: return new ChatsFragment();
        }

    }

    @Override
    public int getCount() {
        return 3;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position==0){
            title = "CHATS";

        }
        if (position==1){
            title = "STATUS";

        } if (position==2){
            title = "CALLS";

        }
        return title;
    }
}
