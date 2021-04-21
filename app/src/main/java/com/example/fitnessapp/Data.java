package com.example.fitnessapp;

import java.io.Serializable;

public class Data implements Serializable {
   private String heading;
   private long duration;
   private String times;
   private String show_duration;
   private int image;
   private int imageView;
   private int gif;

   public int getImageView() {
      return imageView;
   }

   public void setImageView(int imageView) {
      this.imageView = imageView;
   }

   public String getShow_duration() {
      return show_duration;
   }

   public void setShow_duration(String show_duration) {
      this.show_duration = show_duration;
   }


   public String getHeading() {
      return heading;
   }

   public void setHeading(String heading) {
      this.heading = heading;
   }

   public long getDuration() {
      return duration;
   }

   public void setDuration(long duration) {
      this.duration = duration;
   }

   public String getTime() {
      return times;
   }

   public void setTime(String time) {
      this.times = time;
   }

   public int getImage() {
      return image;
   }

   public void setImage(int image) {
      this.image = image;
   }

   public int getGif() {
      return gif;
   }

   public void setGif(int gif) {
      this.gif = gif;
   }
}
