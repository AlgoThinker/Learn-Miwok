package com.example.android.LearnMiwok;

/**
 * Created by tusharsharma on 15/07/16.
 */
public class Word {

    private String mDefaultTranslation ;

    private String mMiwokTranslation;

    private int mImageResourceId = -1;

    private int mAudioResourceId ;

    public Word(String defaultTranslation, String miwokTranslation , int audioResourceId){

        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;
    }

    public Word(String defaultTranslation, String miwokTranslation , int imageResourceId, int audioResourceId){

        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    public String getmDefaultTranslation(){
        return mDefaultTranslation;
    }

    public String getmMiwokTranslation(){
        return mMiwokTranslation;
    }

    public int getmImageResourceId(){return mImageResourceId;}

    public boolean hasImage(){

        if(mImageResourceId < 0)

            return false;

        return true;
    }

    public int getmAudioResourceId(){
        return mAudioResourceId;
    }
}
