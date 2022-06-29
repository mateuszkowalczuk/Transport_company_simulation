package pl.programowanie;

public class Transporter extends Thread{

    private static int number;
    private String status = "Oczekiwanie";
    private static boolean loading = false;
    private static int lap = 0;

    public Transporter(Storage storage){
        number++;

        new Thread(
                () -> {
                    while(!Thread.currentThread().isInterrupted()) {
                        if (loading == false && storage.size() > 9) {
                            loading = true;
                            Baloon[] baloons = new Baloon[10];
                            int time = (int)(Math.random() * 500 + 500);

                            status = "Załadunek";
                            for (int i = 0; i < 10; i++) {
                                baloons[i] = storage.peek();

                                while (storage.size() == 0) {
                                    try {
                                        Thread.sleep(100);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                storage.remove();

                                try {
                                    Thread.sleep(time);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            if (++lap != 1) {
                                try {
                                    Thread.sleep(10000 - time * 10);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            loading = false;

                            status = " Dostawa ";
                            try {
                                Thread.sleep(time * 10);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            status = "Oczekiwanie";
                        }
                    }
                }).start();
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return status;
    }
}