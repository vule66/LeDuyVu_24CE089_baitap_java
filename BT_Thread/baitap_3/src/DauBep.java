public class DauBep extends Thread {
    private BanAn banAn;

    public DauBep(BanAn banAn) {
        this.banAn = banAn;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            synchronized (banAn) {
                while (banAn.soMonTrenBan >= 5) {  // Chờ khi bàn đầy
                    try {
                        banAn.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                banAn.soMonTrenBan++;
                System.out.println("Dau bep da nau mon thu " + i);
                banAn.notifyAll();
            }
            try {
                Thread.sleep(2000);  // Giả lập thời gian nấu ăn
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}