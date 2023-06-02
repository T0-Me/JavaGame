package lfj.xunfang.utils;

import java.util.Random;

//计算工具类
public class NumberUtils {

    //生成随机数
    public static String getNumbercondition(int number){
        Random random = new Random();
        //number为范围————1 ~ number
        int num = random.nextInt(number) + 1;
        return (num<10 ? "0"+num : num+"");
    }

    //测试
//    public static void main(String[] args) {
//        System.out.println(getNumbercondition(15));
//    }
}


