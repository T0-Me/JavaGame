package lfj.xunfang.entity;

//import lfj.xunfang.xf1.Gamewin;
//
//import java.io.*;
//import javax.sound.sampled.*;
//
//public class Music {
//
//    public static void music_start(){
//        AePlayWave apw = new AePlayWave("E:\\我的\\认知实习\\第一节课\\untitled\\src\\lfj\\xunfang\\imgs\\game_music.wav");
//        apw.start();
//        Gamewin.music = 1;
//    }
//
//}
//class AePlayWave extends Thread{
//    private String filename;
//    public AePlayWave(String wavfile){
//        filename = wavfile;
//    }
//    public void run(){
//        File soundFile = new File(filename);
//        System.out.println(soundFile);
//        AudioInputStream audioInputStream = null;
//        try{
//            audioInputStream =AudioSystem.getAudioInputStream(soundFile);
//        }catch (Exception e) {
//            // TODO: handle exception
//            e.printStackTrace();
//            return;
//        }
//        AudioFormat format = audioInputStream.getFormat();
//        SourceDataLine auline = null;
//        DataLine.Info info = new DataLine.Info(null, null);
//        try{
//            auline = (SourceDataLine) AudioSystem.getLine(info);
//            auline.open(format);
//        } catch(Exception e){
//            e.printStackTrace();
//            return ;
//        }
//        auline.start();
//        int nBytesRead = 0;
//        //这是缓冲
//
//        byte[] abData = new byte[1024];
//        try{
//            while(nBytesRead != -1){
//                nBytesRead = audioInputStream.read(abData, nBytesRead, nBytesRead);
//                if(nBytesRead >= 0){
//                    auline.write(abData, 0, nBytesRead);
//                }
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//            return ;
//        }finally{
//            auline.drain();
//            auline.close();
//        }
//    }
//}

import lfj.xunfang.xf1.Gamewin;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Music extends Thread{
    public static boolean player = false;
    public void run() {
        if (!player){
            player = true;
            System.out.println("音乐开启");
            try {
                File audioFile = new File(
                        "F:\\java_project\\game\\src\\lfj\\xunfang\\imgs\\game_music.wav");
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(audioFile));
                clip.loop(Clip.LOOP_CONTINUOUSLY); // 循环播放
                Thread.sleep(10000*100); // 播放10秒钟
                clip.stop(); // 停止播放
            } catch (Exception e) {
                System.out.println("无法播放音频文件：" + e.getMessage());
            }
    }
}



//import javax.sound.sampled.AudioSystem;
//import javax.sound.sampled.Clip;
//import java.io.File;
//
//public class Music {
//    private static boolean played = false;
//
//    public static void main(String[] args) {
//        if (!played) { // 检查是否已经播放过
//            played = true;
//            new Thread(() -> {
//                try {
//                    Clip clip = AudioSystem.getClip();
//                    clip.open(AudioSystem.getAudioInputStream(new File("E:\\我的\\认知实习\\第一节课\\untitled\\src\\lfj\\xunfang\\imgs\\game_music.wav")));
//                    clip.loop(Clip.LOOP_CONTINUOUSLY); // 循环播放
//                } catch (Exception e) {
//                    System.out.println("无法播放音频文件：" + e.getMessage());
//                }
//            }).start();
//        }
//    }
}