public class Main {
    private static String lastWord = "";
    public static void main(String[] args) {

        Thread egg = new EggThread();
        Thread chicken = new ChickenThread();

        egg.start();
        chicken.start();

        try {
            egg.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (chicken.isAlive()) {
            try {
                chicken.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        if ("Яйцо".equals(lastWord)) {
            System.out.println("Спор окончен. Победило Яйцо");
        } else {
            System.out.println("Спор окончен. Победила Курица");
        }
    }

    public static synchronized void setLastWord(String word) {
        lastWord = word;
    }
}
class EggThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Яйцо");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ChickenThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Курица");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}