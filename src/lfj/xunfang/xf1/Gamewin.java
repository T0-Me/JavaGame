package lfj.xunfang.xf1;

import jdk.jshell.JShell;
import lfj.xunfang.entity.*;
import lfj.xunfang.utils.Gameutils;
import lfj.xunfang.utils.NumberUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.security.Key;
import java.util.Random;

public class Gamewin extends JFrame {

    //定义游戏状态：0.未开始 1.游戏中 2.暂停 3.游戏失败 4.游戏通关
    public static int state = 0;

    //定义分数初始
    public static int souce = 0;

    //boss是否存在
    public static int boss = 0;

    public static int shallCount = 0;

    //定义游戏的重绘次数
    static int count = 0;

    //记录敌机产生个数
    int enemycount = 0;

    //初始化飞机的索引
    public static int planindix;

    //玩家飞机血量
    public static int heard = 1;

    //music
    public static int music = 0;

    //定义背景图
    BgObj bgObj = new BgObj(Gameutils.bgImg,0,-1966,2);

    //定义我方玩家飞机的对象
    public PlayerObj playerObj = new PlayerObj(Gameutils.playerImg,
            150,500,50,40,2,this);

    //危险警示对象
    public WarningObj warningObj = new WarningObj(Gameutils.warninImg,-140,270,120,70,0,this);

    //定义小BOSS的对象
    public XbossObj xbossObj = new XbossObj(Gameutils.xbossImg,250,-150,100,76,2,this);

    //定义绿色boss对象
    public Xboss1Obj xboss1Obj = new Xboss1Obj(Gameutils.xboss1Img,-150,300,102,79,2,this);

    //定义Boss对象
    public BossObj bossObj = null;



    public FireObj fireObj = null;
//    public BossObj bossObj = new BossObj(Gameutils.bossImg,
//            120,150,157,109,5,this);

//    public BulletObj bulletObj = new BulletObj()
    //顶我我方飞机子弹的对象
//    ShallObj shallObj = new ShallObj(Gameutils.shallImg ,
//            playerObj.getX()+19 , playerObj.getY()-18 , 14 , 29 , 8 , this);

    //定义图片对象
    Image offScreenImage = null;

    public static void main(String[] args) {
        //快捷方式创建对象 new Gamewin.var
        //快捷键创建对象 ctrl+alt+v
        Gamewin gamewin = new Gamewin();
        gamewin.load();
    }

    //定义敌机的图片对象
    Image enemyImg;


    //重写paint绘制方法——自定义绘制界面
    //游戏状态不一样，绘制的界面也不一样
    //注意：解决文字闪动问题，让图片的测绘和文字的测绘在同一个对象模板中完成
    @Override
    public void paint(Graphics g) {

        //初始化图片
        if(offScreenImage == null){
            offScreenImage = createImage(400,700);
        }

        //获取当前图片的画布对象
        Graphics gImage = offScreenImage.getGraphics();
        //使用画布对象填充一个具有宽度高度的范围
        gImage.drawRect(0,0,400,700);

        if(state == 0){
            //设置图片
            gImage.drawImage(Gameutils.bgImg,0,0,null);
            gImage.drawImage(Gameutils.bossImg,120,150,null);
            gImage.drawImage(Gameutils.boomImg,170,450,null);
            //添加文字样式——new Font(字体样式，字体类型，字体大小)
            gImage.setFont(new Font("微软清雅",Font.BOLD,40));
            //设置文字颜色
            gImage.setColor(Color.RED);
            //设置文字
            gImage.drawString("点击开始游戏",80,370);
        }
        else if(state == 1){
            //将爆炸集合放入物体集合  显示
            Gameutils.gameObjList.addAll(Gameutils.explodeObjList);
            //游戏运行中
//            //绘制背景图，只要游戏运行，则会一直移动
//            bgObj.paintSelf(gImage);
//            //绘制我方飞机
//            playerObj.paintSelf((gImage));
//            //绘制我方子弹
//            shallObj.paintSelf(gImage);

            //播放音乐
//            Music.playMusic(new File("../imgs/game_music.wav"));
//            if (music == 0){
                Music music1 = new Music();
                music1.start();
//            }



            //遍历物体集合统一进行绘制
            //快捷方式：Gameutils.gameObjList.for
            for (GameObj gameObj : Gameutils.gameObjList) {
                //统一绘制
                gameObj.paintSelf(gImage);
            }

            for (int i = 0 ; i < heard ; i++){
                gImage.drawImage(Gameutils.bloodImg,i*80+30 , 600 , null);
            }

            //在下一次绘制之前，删除gameObjList中要删除的物体元素
            Gameutils.gameObjList.removeAll(Gameutils.removeObjList);
        }

        //游戏暂停
        if(state == 2){
            //添加文字样式——new Font(字体样式，字体类型，字体大小)
            gImage.setFont(new Font("微软清雅",Font.BOLD,40));
            //设置文字颜色
            gImage.setColor(Color.RED);
            //设置文字
            gImage.drawString("游戏暂停",117,370);
        }

        //游戏结束
        if(state == 3){
            gImage.drawImage(Gameutils.boomImg,playerObj.getX()-5,playerObj.getY()-10,null);
            //添加文字样式——new Font(字体样式，字体类型，字体大小)
            gImage.setFont(new Font("微软清雅",Font.BOLD,40));
            //设置文字颜色
            gImage.setColor(Color.RED);
            //设置文字
            gImage.drawString("游戏结束",117,370);
        }

        //游戏胜利
        if(state == 4){
            gImage.drawImage(Gameutils.bossboomImg,bossObj.getX()+45,bossObj.getY()-10,null);
            //添加文字样式——new Font(字体样式，字体类型，字体大小)
            gImage.setFont(new Font("微软清雅",Font.BOLD,40));
            //设置文字颜色
            gImage.setColor(Color.RED);
            //设置文字
            gImage.drawString("游戏胜利",117,370);
        }

        //计分板
        Gameutils.doraw(gImage,souce+"连杀",Color.lightGray,30,100,40);

        //把新的内容，一次性绘制到主窗口
        g.drawImage(offScreenImage,0,0,null);

        //每次重绘之后，count值++
        count++;
//        System.out.println(Gameutils.gameObjList.size());
    }

    //批量创建子弹和敌机
    public void creatObj(){
        //没重绘10次就生成一颗子弹
        if(count % 8 == 0) {
            if(shallCount == 0){
                //添加子弹对象，添加到集合
                Gameutils.shellObjlist.add(new ShallObj(Gameutils.shallImg,
                        playerObj.getX() + 19, playerObj.getY() - 18, 14, 29, 8, this));
                //每添加一个子弹，就把子弹放入集合中
                Gameutils.gameObjList.add(Gameutils.shellObjlist.get(Gameutils.shellObjlist.size() - 1));
            }
            if(shallCount == 1){
                Gameutils.doubleshellObjList.add(new DoubleshellObj(Gameutils.doubleshellImg,
                        playerObj.getX()+20,playerObj.getY()-20,32,64,12,this
                ));
                Gameutils.gameObjList.add(Gameutils.doubleshellObjList.get(
                        Gameutils.doubleshellObjList.size()-1));
            }
            if(shallCount == 2){
                Gameutils.tripleshellObjList.add(new TripleshellObj(Gameutils.tripleshellImg,
                        playerObj.getX()-10,playerObj.getY()-50,64,182,15,this
                ));
                Gameutils.gameObjList.add(Gameutils.tripleshellObjList.get(
                        Gameutils.tripleshellObjList.size()-1));
            }

//            if (shallCount == 1){
//                //添加子弹对象，添加到集合
//                Gameutils.shellObjlist.add(new ShallObj(Gameutils.shallImg,
//                        playerObj.getX() + 19, playerObj.getY() - 18, 14, 29, 8, this));
//                //每添加一个子弹，就把子弹放入集合中
//                Gameutils.gameObjList.add(Gameutils.shellObjlist.get(Gameutils.shellObjlist.size() - 1));
//                //添加子弹对象，添加到集合
//                Gameutils.shellObjlist.add(new ShallObj(Gameutils.shallImg,
//                        playerObj.getX() + 39, playerObj.getY() - 18, 14, 29, 8, this));
//                //每添加一个子弹，就把子弹放入集合中
//                Gameutils.gameObjList.add(Gameutils.shellObjlist.get(Gameutils.shellObjlist.size() - 1));
//            }
//            if(shallCount == 2){
//                //添加子弹对象，添加到集合
//                Gameutils.shellObjlist.add(new ShallObj(Gameutils.shallImg,
//                        playerObj.getX() + 19, playerObj.getY() - 18, 14, 29, 8, this));
//                //每添加一个子弹，就把子弹放入集合中
//                Gameutils.gameObjList.add(Gameutils.shellObjlist.get(Gameutils.shellObjlist.size() - 1));
//                //添加子弹对象，添加到集合
//                Gameutils.shellObjlist.add(new ShallObj(Gameutils.shallImg,
//                        playerObj.getX() + 39, playerObj.getY() - 18, 14, 29, 8, this));
//                //每添加一个子弹，就把子弹放入集合中
//                Gameutils.gameObjList.add(Gameutils.shellObjlist.get(Gameutils.shellObjlist.size() - 1));
//                //添加子弹对象，添加到集合
//                Gameutils.shellObjlist.add(new ShallObj(Gameutils.shallImg,
//                        playerObj.getX() - 1, playerObj.getY() - 18, 14, 29, 8, this));
//                //每添加一个子弹，就把子弹放入集合中
//                Gameutils.gameObjList.add(Gameutils.shellObjlist.get(Gameutils.shellObjlist.size() - 1));
//            }
            //添加子弹对象，添加到集合
//            Gameutils.shellObjlist.add(new ShallObj(Gameutils.shallImg,
//                    playerObj.getX() + 19, playerObj.getY() - 18, 14, 29, 8, this));
//            //每添加一个子弹，就把子弹放入集合中
//            Gameutils.gameObjList.add(Gameutils.shellObjlist.get(Gameutils.shellObjlist.size() - 1));
        }
        //战利品掉落
        if(count % 100 == 0 ){
            fireObj = new FireObj(Gameutils.fireImg,(int)(Math.random()*(512/50))*50,0,50,52,5,this);
            Gameutils.gameObjList.add(fireObj);
        }
        //每绘制20次就生成一架敌机
        if(count % 20 == 0){
            //随机生成一架敌方飞机的图片
            enemyImg = new ImageIcon(
                    Gamewin.class.getResource("../imgs/ep" + NumberUtils.getNumbercondition(15) + ".png")).getImage();
            //获取敌机的宽度高度
            int enemywidch = enemyImg.getWidth(null);
            int enemyheight = enemyImg.getHeight(null);
            //创建敌方战斗机对象，添加到敌方战斗机集合
            Gameutils.enemyObjlist.add(
                    new EnemyObj(enemyImg,(int) Math.ceil(Math.random()* (400/enemywidch))*enemywidch,0,
                    enemywidch,enemyheight,10,this));

            //每添加一个敌机的对象，添加到敌机集合中
            Gameutils.gameObjList.add(Gameutils.enemyObjlist.get(Gameutils.enemyObjlist.size()-1));

            //自加
            enemycount++;
        }

        //当消灭是个敌机时，boss出现
        if(enemycount == 50 && bossObj == null){
            bossObj = new BossObj(Gameutils.bossImg, 120,150,157,109,5,this);
            Gameutils.gameObjList.add(bossObj);
        }

        if(enemycount == 45 ){
            Gameutils.gameObjList.add(warningObj);
        }

        if(enemycount == 48 ){
            Gameutils.removeObjList.add(warningObj);
        }

        //批量创建小BOSS  contains检测是否存在某个对象或者值  && (!Gameutils.xbossObjList.contains(xbossObj))
        if(count % 100 == 0 && (!Gameutils.xbossObjList.contains(xbossObj))){
            Gameutils.xbossObjList.add(xbossObj);
            Gameutils.gameObjList.add(Gameutils.xbossObjList.get(Gameutils.xbossObjList.size()-1));
        }

        //绿色boss创建
        if(count == 100){
            Gameutils.xboss1ObjList.add(xboss1Obj);
            Gameutils.gameObjList.add(Gameutils.xboss1ObjList.get(Gameutils.xboss1ObjList.size()-1));
        }

        //创建boss大招
        if( new Random().nextInt(15)>13){
            if(Gameutils.gameObjList.contains(bossObj)){
                Gameutils.bossexBulleObjList.add(new BossexBulleObj(Gameutils.bossexbulletImg,
                        bossObj.getX()+45,bossObj.getY()-10,
                        51,72,10,this));
                Gameutils.gameObjList.add(Gameutils.bossexBulleObjList.get(
                        Gameutils.bossexBulleObjList.size()-1));
            }
        }

        //创建小BOSS的跟踪弹
        if(count % 100 == 0 ){
            //contains  检测某某对象或某数据是否存在
            if(Gameutils.gameObjList.contains(xbossObj)){
                Gameutils.littleboss2bulletObjList.add(new Littleboss2bulletObj(
                        Gameutils.boss2bulletImg,xbossObj.getX()+30,
                        xbossObj.getY()+30,21,59,2,this));
                Gameutils.gameObjList.add(Gameutils.littleboss2bulletObjList.get(
                        Gameutils.littleboss2bulletObjList.size()-1));
            }

            //为绿boss添加子弹
            if(Gameutils.gameObjList.contains(xboss1Obj)){
                Gameutils.littleboss1bulletObjList.add(new Littleboss1bulletObj(
                        Gameutils.boss1bulletImg,xboss1Obj.getX()+30,xboss1Obj.getY()+30,
                        25,26,10,this
                ));
                Gameutils.gameObjList.add(Gameutils.littleboss1bulletObjList.get(
                        Gameutils.littleboss1bulletObjList.size()-1
                ));
            }
        }

        //批量生产敌方的子弹 &&——并且  ||——或者
        if(count % 30 == 0 && bossObj != null){
            Gameutils.bulletObjsList.add(new BulletObj(Gameutils.bulletImg, bossObj.getX()+80, bossObj.getY()+60,
                    14,25,5,this));
            //每添加一个子弹集合都放到物体集合
            Gameutils.gameObjList.add(Gameutils.bulletObjsList.get(Gameutils.bulletObjsList.size()-1));
        }
    }

    //加载页面数据
    public void load() {
        //显示窗口 true显示 false不显示
        this.setVisible(true);
        //设置宽度高度
        this.setSize(400,700);
        //把窗口放到屏幕中间
        this.setLocationRelativeTo(null);
        //点击关闭窗口，退出程序
        this.setDefaultCloseOperation(Gamewin.EXIT_ON_CLOSE);
        //设置窗口不可放大缩小
        this.setResizable(false);
        //创建图片并加载
        //“..”返回上一级目录
        ImageIcon imageIcon =
                new ImageIcon(this.getClass().getResource("../imgs/qq.jpeg"));
        //设置标题图标
        this.setIconImage(imageIcon.getImage());
        //设置标题文字
        this.setTitle("腾讯游戏——飞机大战");

        /**
         * 通过点击事件，来实现开始游戏
         * 事件：
         * 事件发生的位置：事件源 this
         * 事件监听：监听事件->鼠标左键点击监听事件
         * 事件的处理 -> 方法处理
         */
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //可以开始游戏的前提，判断：1.鼠标左键点击 2.当前状态是游戏未开始
                if(state == 0 && e.getButton() == 1){
                    //重新执行paint绘制方法，绘制游戏开始界面
                    //每隔25毫秒，不断进行重绘
                    //修改state值为1，游戏处于运行状态
                    state = 1;
                    //绘制
                    repaint();
                }
            }
        });

        //将游戏中的物体添加到物体集集合中
        Gameutils.gameObjList.add(bgObj);
        Gameutils.gameObjList.add(playerObj);
        //获取飞机的索引
        planindix = Gameutils.gameObjList.indexOf(playerObj);
//        Gameutils.gameObjList.add(bossObj);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode() == 32){
                    System.out.println("你点击了空格");
                    switch (state){
                        case 1:
                            state = 2;
                            break;
                        case 2:
                            state = 1;
                            break;
                    }
                    //按下esc
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    dispose();
                    System.out.println("检测到esc，退出游戏");
                    //退出程序
                    System.exit(0);
                }
            }
        });

        while(true){
            //当游戏处于运行状态时
            if(state == 1)
            {
                //调用子弹添加到物体集合打的方法，产生子弹和飞机
                creatObj();
                //绘制的方法，绘制游戏开始的页面
                repaint();
            }
            //线程，休眠25毫秒
            try {
                Thread.sleep(25);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
