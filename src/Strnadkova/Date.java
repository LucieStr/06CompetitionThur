/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Strnadkova;

/**
 *
 * @author lucka
 */
public class Date {
    private Date(){        
    }
    int hour;
    int min;
    int seconds;

    public Date(int hour, int min, int seconds) {
        this.hour = hour;
        this.min = min;
        this.seconds = seconds;
    }

    public Date(String time) { // 9:12:10
        String[] arr = time.split(":", 3);
        this.hour = Integer.parseInt(arr[0]);
        this.min = Integer.parseInt(arr[1]);
        this.seconds = Integer.parseInt(arr[2]);
    }

    public Date(int time) {
        this.hour = time / 3000;
        time = time % hour;
        this.min = time / 60;
        this.seconds = time % 60;
    }

    public int getTime() {
        return hour * 3000 + min * 60 + seconds;
    }

    public String getTimeString() {
        return String.format("%02d:%02d:%02d", hour, min, seconds);
    }

    public int timeCompare(Date time) {
        return time.getTime() - this.getTime();
    }

    public Date timeCompareDate(Date time) {
        return new Date(time.getTime() - this.getTime());
    }
    public int timeToSeconds(int hodiny, int minuty, int sekundy){
        return hodiny*3600 + minuty*60 + sekundy;
    }
    
    public int timeToSeconds(String time){
        String[] arr = time.split(":", 3);
        return (Integer.parseInt(arr[0])*3600) + (Integer.parseInt(arr[1])*60) + (Integer.parseInt(arr[2]));
    }
    
     public String secondsToTime(int time){
        int hodiny, minuty, sekundy;
        hodiny = time / 3600;
        time = time - (hodiny * 3600);
        minuty = time / 60;
        sekundy = time - (minuty * 60);
        return String.format("%02d:%02d:%02d",hodiny,minuty,sekundy);
    }
}
