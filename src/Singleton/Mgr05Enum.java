package Singleton;

/**
 * 借用枚举机制实现单例
 * 不可序列化，不可通过反射机制获取
 * 线程安全
 * 目前最好的实现方式
 */
public enum Mgr05Enum {

    INSTANCE;

    private final Mgr05 instance;

    Mgr05Enum() {
        instance = new Mgr05();
    }

    public Mgr05 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Mgr05Enum.INSTANCE.getInstance().hashCode());
            }).start();
        }
    }
}

class Mgr05 {

}
