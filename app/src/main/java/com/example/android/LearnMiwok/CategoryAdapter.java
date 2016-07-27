package com.example.android.LearnMiwok;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by tusharsharma on 27/07/16.
 */
public class CategoryAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[]{"Numbers","Family","Colors","Phrases"};

    public CategoryAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position){

        if (position==0)
            return new NumbersFragment();
        else if (position==1)
            return new FamilyFragment();
        else if (position==2)
            return new ColorsFragment();
        else return new PhrasesFragment();
    }

    @Override
    public int getCount(){

        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position){
        return tabTitles[position];
    }

}
