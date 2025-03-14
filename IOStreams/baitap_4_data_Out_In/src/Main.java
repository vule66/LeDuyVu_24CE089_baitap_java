import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String file4 = "file4.txt";
        try(DataOutputStream nhapSo = new DataOutputStream( new FileOutputStream(file4));)        {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Nhap so nguyen: ");
                int so = scanner.nextInt();
                if (so == -1){
                    break;
                }
                nhapSo.writeInt(so);
            }
            nhapSo.flush();
            System.out.println("da luu vao file4.txt");
            nhapSo.flush();
        }catch (IOException e)
        {
                e.printStackTrace();
        }
        try(DataInputStream inSo = new DataInputStream(new FileInputStream("file4.txt"))){
            System.out.print("so nguyen da nhap la: ");
            while (true) {
                try {
                    System.out.print(inSo.readInt()+" ");
                } catch (EOFException e) {
                    break;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}