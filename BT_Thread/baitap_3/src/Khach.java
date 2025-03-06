public class Khach extends Thread {
    private BanAn banAn;

    public Khach(BanAn banAn) {
        this.banAn = banAn;
    }
    public void run() {
        for (int i = 1; i <= 10; i++) {
            synchronized (banAn) {
                while (banAn.soMonTrenBan == 0) {  // Chờ khi bàn có món
                    try {
                        banAn.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                banAn.soMonTrenBan--;
                System.out.println("Khach da an mon thu " + i);
                banAn.notifyAll();
            }
            try {
                Thread.sleep(3000);  // Giả lập thời gian ăn
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


