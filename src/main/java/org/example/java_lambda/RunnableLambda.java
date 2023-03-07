package org.example.java_lambda;

public class RunnableLambda {
    public static void main(String[] args) {
       /* MyThreadBehavior behavior = new MyThreadBehavior();
        Thread thread = new Thread(behavior);*/
        Runnable runnable = () -> System.out.println("Hello!");
        runnable.run();
        Thread thread = new Thread(() -> System.out.println("Hello!"));

    }
    public static class MyThreadBehavior implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello!");
        }
    }
}
