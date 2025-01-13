// 懒汉模式实现的单例模式
class SingletonLazy {
    // 此处先把这个实例的引用设为null，先不着急创建实例
    private static volatile SingletonLazy instance = null;

    private static Object locker = new Object();

    public static SingletonLazy getInstance() {
        //在这个条件中判定当前是否应该要加锁
        if (instance == null) {
            synchronized (locker) {
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }

    private SingletonLazy() {

    }
}

public class Demo28 {
    public static void main(String[] args) {
        SingletonLazy s1 = SingletonLazy.getInstance();
        SingletonLazy s2 = SingletonLazy.getInstance();
        System.out.println(s1 == s2);
    }
}
