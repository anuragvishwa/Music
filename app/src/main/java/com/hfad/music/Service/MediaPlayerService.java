package com.hfad.music.Service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.IOException;

/**
 * Created by anurag on 28/10/17.
 */

public class MediaPlayerService extends Service implements MediaPlayer.OnPreparedListener,
MediaPlayer.OnCompletionListener,MediaPlayer.OnErrorListener,MediaPlayer.OnSeekCompleteListener,
MediaPlayer.OnInfoListener,MediaPlayer.OnBufferingUpdateListener,
        AudioManager.OnAudioFocusChangeListener{

    private final IBinder iBinder = new LocalBinder();
    private MediaPlayer mediaPlayer;

    //Used to pause/resume MediaPlayer
    private int resumePosition;

    //path to audio file
    private String mediaFile;

    private AudioManager audioManager;



    //Setup media player listeners:
     private void initMediaPlayer(){
         mediaPlayer = new MediaPlayer();
         mediaPlayer.setOnSeekCompleteListener(this);
         mediaPlayer.setOnErrorListener(this);
         mediaPlayer.setOnCompletionListener(this);
         mediaPlayer.setOnPreparedListener(this);
         mediaPlayer.setOnBufferingUpdateListener(this);
         mediaPlayer.setOnInfoListener(this);
         mediaPlayer.reset();

         mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

         try{
             //Set the data source to media file location:
             mediaPlayer.setDataSource(mediaFile);
         }
         catch(IOException e)
         {
            e.printStackTrace();
            stopSelf();
         }

         mediaPlayer.prepareAsync();

     }



    private void playMedia(){
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();

        }
    }

    private void stopMedia(){
        if(mediaPlayer == null) return;
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
    }

    private void resumeMedia(){
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.seekTo(resumePosition);
            mediaPlayer.start();
        }
    }


    @Nullable

    //Binder given to clients:
    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    @Override
    public void onAudioFocusChange(int focusState) {
        //Invoked when the audio  focus of the system is updated.

        switch(focusState){
            case AudioManager.AUDIOFOCUS_GAIN:
                //resume playback
                if(mediaPlayer == null)
                    initMediaPlayer();
                else if (!mediaPlayer.isPlaying())mediaPlayer.start();
                mediaPlayer.setVolume(1.0f,1.0f);
                break;

            case AudioManager.AUDIOFOCUS_LOSS:
                //lOST FOCUS for unbound amount of time: STOP playback and release mediaplayer:

                if(mediaPlayer.isPlaying()) mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
                break;

            case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                //Lost focus for a short time ,but we have to stop  playback .
                //We don't release the playback becasue plyback is likely to resume.

                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                }
                break;


            case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                //Lost focus for a short time , but it is okay to keep playing at attenual level:

                if(mediaPlayer.isPlaying()){
                    mediaPlayer.setVolume(0.1f,01.f);
                }
                break;

        }


    }

    private boolean requestAudioFocus(){
        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        int result = audioManager.requestAudioFocus(this,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN);

        if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
            //Focus gain
            return true;
        }
        //Could not gain focus
        return false;
    }

    private boolean removeAudioFocus(){
        return AudioManager.AUDIOFOCUS_REQUEST_GRANTED == audioManager.abandonAudioFocus(this);
    }

    @Override
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {

    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        //Invoked when playback of a media source has completed
        stopMedia();

        //Stop the service
        stopSelf();

    }

    @Override
    public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
        //Invoked when there has been an error during an asynchronous operation
        switch(i){
            case MediaPlayer.MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK:
                Log.d("MediaPlayer Error","MEDIA ERROR NOT VALID FOR PROGRESSIVE PLAYBACK"+i1);
                break;
            case MediaPlayer.MEDIA_ERROR_SERVER_DIED:
                Log.d("MediaPlayer Error", "MEDIA ERROR SERVER DIED " + i1);
                break;
            case MediaPlayer.MEDIA_ERROR_UNKNOWN:
                Log.d("MediaPlayer Error", "MEDIA ERROR UNKNOWN " + i1);
                break;
        }


        return false;
    }

    @Override
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i1) {
        return false;
    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        playMedia();
    }

    @Override
    public void onSeekComplete(MediaPlayer mediaPlayer) {

    }

    public class LocalBinder extends Binder{
        public MediaPlayerService getService(){
            return MediaPlayerService.this;
        }
    }

    public int onStartCommand(Intent intent,int flags,int startId){
        try {
            //An audio file is passed to the service through putExtra:
            mediaFile = intent.getExtras().getString("media");
        }
        catch(NullPointerException e){
            stopSelf();

        }

        //Request audio focus:
        if(requestAudioFocus() == false){
            //Could not gain focus

           stopSelf();
        }

        if(mediaFile!=null && mediaFile!=""){
            initMediaPlayer();
        }

        return super.onStartCommand(intent,flags,startId);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        if(mediaPlayer!=null){
            stopMedia();
            mediaPlayer.release();
        }

        removeAudioFocus();
    }

}
