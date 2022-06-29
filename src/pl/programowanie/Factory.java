package pl.programowanie;

public class Factory {

    private static int number;
    private int sum;
    private int time = (int)(Math.random()*2900+100);

    public Factory(Storage storage) {
        number++;
        new Thread(
                () -> {
                    while (!Thread.currentThread().isInterrupted()) {
                        if (storage.size() < 99) {
                            storage.add(new Baloon());
                            sum++;
                        } else {
                            synchronized (storage){
                                try {
                                    storage.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        try {
                            Thread.sleep(time);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        ).start();
    }

    public int getNumber() {
        return number;
    }

    public int getSum(){
        return sum;
    }
}