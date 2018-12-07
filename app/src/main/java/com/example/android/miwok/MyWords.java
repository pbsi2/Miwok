package com.example.android.miwok;

public class MyWords {
    private int imageResId;
    private int soundResId;
    private String mDefaultTranslation;
    private String mMiwokTranslation;

    public MyWords(int image, int sound, String defaultTranslation, String miwokTranslation){
        imageResId = image;
        soundResId = sound;
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }
    public int getImageId(){
        return imageResId;
    }
    public int getSoundId(){
        return soundResId;
    }
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }
}
