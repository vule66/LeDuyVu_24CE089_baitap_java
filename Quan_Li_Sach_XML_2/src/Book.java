import java.util.Scanner;

public class Book {
    private String tenSach,IDsach,tacGia,namXuatBan,nhaXuatBan,soTrang,theLoai,giaTien;

    public Book() {
    }

    public Book(String tenSach, String tacGia, String namXuatBan, String nhaXuatBan, String soTrang, String theLoai, String giaTien, String IDsach) {
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.nhaXuatBan = nhaXuatBan;
        this.soTrang = soTrang;
        this.theLoai = theLoai;
        this.giaTien = giaTien;
        this.IDsach = IDsach;
    }

    public void addBook(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Tên sách: ");
        tenSach=sc.nextLine();
        System.out.println("Tên tác giả: ");
        tacGia=sc.nextLine();
        System.out.println("Năm xuất bản: ");
        namXuatBan=sc.nextLine();
        System.out.println("Nhà xuất bản: ");
        nhaXuatBan=sc.nextLine();
        System.out.println("Số trang: ");
        soTrang=sc.nextLine();
        System.out.println("Thể loại: ");
        theLoai=sc.nextLine();
        System.out.println("Giá: ");
        giaTien=sc.nextLine();
        System.out.println("Mã sách: ");
        IDsach=sc.nextLine();
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(String namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public String getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(String soTrang) {
        this.soTrang = soTrang;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(String giaTien) {
        this.giaTien = giaTien;
    }

    public String getIDsach() {
        return IDsach;
    }

    public void setIDsach(String IDsach) {
        this.IDsach = IDsach;
    }

}
