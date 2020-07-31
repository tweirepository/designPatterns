package Singleton;

/**
 * 饿汉模式，类加载时直接初始化，线程安全
 */
public class Mgr01 {

    private static final Mgr01 INSTANCE = new Mgr01();

    private Mgr01 (){};


    public static Mgr01 getInstance() { return INSTANCE;}

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()-> {
                System.out.println(Mgr01.getInstance().hashCode());
            }).start();
        }
    }

}
