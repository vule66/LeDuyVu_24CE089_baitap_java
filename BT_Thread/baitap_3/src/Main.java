public class Main {
    public static void main(String[] args) {
        BanAn banAn = new BanAn(); // Đối tượng chia sẻ giữa hai luồng
        DauBep dauBep = new DauBep(banAn);
        Khach k1 = new Khach(banAn);

        dauBep.start();
        k1.start();
    }
}