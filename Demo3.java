public class Demo3 {
    public static void main(String[] args) {
        Thread t=new Thread(){
            @Override
            public void run() {
                while(true){
                    System.out.println("hello Thread");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
    }
}
