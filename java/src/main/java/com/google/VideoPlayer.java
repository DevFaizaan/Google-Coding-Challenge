package com.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class VideoPlayer {

  private final VideoLibrary videoLibrary;
  private Video currentVideo;
  private Video newVideo;
  private boolean playingVideo = false;
  private boolean paused = false;


  public VideoPlayer() {
    this.videoLibrary = new VideoLibrary();
  }

  public void numberOfVideos() {
    System.out.printf("%s videos in the library%n", videoLibrary.getVideos().size());
  }

  public void showAllVideos() {

//    int length = videoLibrary.getVideos().size();
//    System.out.println("Here's a list of all available videos: " + printVideo(Video video));
    System.out.println("Here's a list of all available videos:");

    List<String> names = new ArrayList<>();
    for(Video video: videoLibrary.getVideos()){
      names.add(video.getVideoId());
    }
    Collections.sort(names);

    for(String name: names){
      Video video = videoLibrary.getVideo(name);
      System.out.print(video.getTitle()
              + " (" +
              video.getVideoId()
              + ") ");
      System.out.print("[");
      int counter = 1;

      for (String tag: video.getTags()) {
        if(counter == video.getTags().size()){
          System.out.print(tag);
        }else{
          System.out.print(tag+" ");
          counter++;
        }
      }
      System.out.print("]\n");
    }
  }

  public void playVideo(String videoId) {
    Video video = videoLibrary.getVideo(videoId);

if(playingVideo == true){
  stopVideo();
  System.out.println("Playing video: " + video.getTitle());
}
else if(video != null && playingVideo== false){
      currentVideo = video;
      playingVideo = true;
      System.out.println("Playing video: " + video.getTitle());
    }
    else if(video == null){
      System.out.println("Cannot play video: Video does not exist");

    }


//    if(video.getVideoId() != videoId){
//      newVideo = video;
//
//      System.out.println("Stopping video: " + currentVideo.getTitle());
//      System.out.println("Playing video: " + newVideo.getTitle());
//    }
//
//    if(video != null){
//      currentVideo = video;
//      playingVideo = true;
//      System.out.println("Playing video: " + video.getTitle());
//    }
//    else{
//      System.out.println("Cannot play video: Video does not exist");
//    }
//
//    if (playingVideo)


  }



  public void stopVideo() {
    if(currentVideo !=null) {
      if (playingVideo == true) {
        System.out.println("Stopping video: " + currentVideo.getTitle());
        currentVideo = null;
        playingVideo = false;
      }
    }
    else {
      System.out.println("Cannot stop video: No video is currently playing");
    }
  }

  public void playRandomVideo() {
videoLibrary.getVideos();

    if(playingVideo == true){
      stopVideo();
      Random rand = new Random();
      int randy = rand.nextInt(videoLibrary.getVideos().size() - 1);
      Video randyVid = videoLibrary.getVideos().get(randy);
      playVideo(randyVid.getVideoId());
    }
    else{
      Random rand = new Random();
      int randy = rand.nextInt(videoLibrary.getVideos().size() - 1);
      Video randyVid = videoLibrary.getVideos().get(randy);
      playVideo(randyVid.getVideoId());
    }

  }

  public void pauseVideo() {
    if(playingVideo == true){
      System.out.println("Pausing video: " + currentVideo.getTitle());
      playingVideo = false;
      paused = true;
    }
    else if(paused == true && playingVideo == true){
      stopVideo();
      playVideo(newVideo.getTitle());
    }
    else
    {
      System.out.println("Video already paused: " + currentVideo.getTitle());
      paused= true;
    }

    if(currentVideo == null){
      System.out.println("Cannot pause video: No video is currently playing");
    }




  }

  public void continueVideo() {
    if (playingVideo == false && currentVideo != null) {
      System.out.println("Continuing video: " + currentVideo.getTitle());
    } else if (playingVideo) {
      System.out.println("Cannot continue video: Video is not paused");
    }
    else{
      System.out.println("Cannot continue video: No video is currently playing");
    }


  }

  public void showPlaying() {

    if(currentVideo != null){

      if(playingVideo){
        System.out.print("Currently playing: "+currentVideo.getTitle()
                + " (" +
                currentVideo.getVideoId()
                + ") ");
        System.out.print("[");
        int counter = 1;

        for (String tag: currentVideo.getTags()) {
          if(counter == currentVideo.getTags().size()){
            System.out.print(tag);
          }else{
            System.out.print(tag+" ");
            counter++;
          }
        }
        System.out.print("]");
      }else{
        System.out.print("Currently playing: "+currentVideo.getTitle()
                + " (" +
                currentVideo.getVideoId()
                + ") ");
        System.out.print("[");
        int counter = 1;

        for (String tag: currentVideo.getTags()) {
          if(counter == currentVideo.getTags().size()){
            System.out.print(tag);
          }else{
            System.out.print(tag+" ");
            counter++;
          }
        }
        System.out.print("] - PAUSED");
      }
    }else{
      System.out.println("No video is currently playing!");
    }
  }

  public void createPlaylist(String playlistName) {
    System.out.println("createPlaylist needs implementation");
  }

  public void addVideoToPlaylist(String playlistName, String videoId) {
    System.out.println("addVideoToPlaylist needs implementation");
  }

  public void showAllPlaylists() {
    System.out.println("showAllPlaylists needs implementation");
  }

  public void showPlaylist(String playlistName) {
    System.out.println("showPlaylist needs implementation");
  }

  public void removeFromPlaylist(String playlistName, String videoId) {
    System.out.println("removeFromPlaylist needs implementation");
  }

  public void clearPlaylist(String playlistName) {
    System.out.println("clearPlaylist needs implementation");
  }

  public void deletePlaylist(String playlistName) {
    System.out.println("deletePlaylist needs implementation");
  }

  public void searchVideos(String searchTerm) {
    System.out.println("searchVideos needs implementation");
  }

  public void searchVideosWithTag(String videoTag) {
    System.out.println("searchVideosWithTag needs implementation");
  }

  public void flagVideo(String videoId) {
    System.out.println("flagVideo needs implementation");
  }

  public void flagVideo(String videoId, String reason) {
    System.out.println("flagVideo needs implementation");
  }

  public void allowVideo(String videoId) {
    System.out.println("allowVideo needs implementation");
  }
}