package Singleton;

/**
 * 懒汉模式改进版
 * 线程安全，效率降低
 */
public class Mgr03 {

    private static Mgr03 INSTANCE;

    // 方式2，防止指令重排
//    private static volatile Mgr03 INSTANCE;

    private Mgr03(){}

    /**
     * 方式1
     * @return
     */
    public static synchronized Mgr03 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Mgr03();
        }
        return INSTANCE;
    }

    /**
     * 方式2
     * 这种锁效率高点
     * @return
     */
    public static Mgr03 getInstance2() {
        if (INSTANCE == null) {
            synchronized (Mgr03.class) {
                if (INSTANCE == null) {
                    return new Mgr03();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()-> {
                System.out.println(Mgr03.getInstance().hashCode());
            }).start();
        }
    }
}
