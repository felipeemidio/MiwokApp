package com.example.android.miwok;

/*
 * {@link Word} represents a vocubolary word that the use want to learn.
 * It contains a default translation and a Miwok translation for that.
 */
public class Word {

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private int mSoundResourceId;

    private static final int NO_IMAGE_PROVIDED = -1;

    public Word (String defaultWord, String miwokWord, int imageId, int soundId){
        this.mDefaultTranslation = defaultWord;
        this.mMiwokTranslation = miwokWord;
        this.mImageResourceId = imageId;
        this.mSoundResourceId = soundId;

    }

    public Word (String defaultWord, String miwokWord, int soundId){
        this.mDefaultTranslation = defaultWord;
        this.mMiwokTranslation = miwokWord;
        this.mSoundResourceId = soundId;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public int getmSoundResourceId() {
        return mSoundResourceId;
    }

    public boolean hasImage(){
        return this.mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
