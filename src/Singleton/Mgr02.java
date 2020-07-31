package Singleton;

/**
 * 懒汉模式
 * 使用的时候才会初始化，但是带来了线程不安全
 */
public class Mgr02 {

    private static Mgr02 INSTANCE;

    private Mgr02() {

    }

    public static Mgr02 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Mgr02();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()-> {
                System.out.println(Mgr02.getInstance().hashCode());
            }).start();
        }
    }

}
