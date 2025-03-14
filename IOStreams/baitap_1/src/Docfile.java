import java.io.*;

public class Docfile {
    public static void main(String[] args) {
   try{
       InputStreamReader input = new InputStreamReader(new FileInputStream("C:\\Users\\VUXLEE\\Documents\\IdeaProjects\\IOStreams\\baitap_1\\src\\file.txt"),"UTF-8");
       OutputStreamWriter output = new OutputStreamWriter(new FileOutputStream("file2.txt"), "UTF-8");
       int byData;
       while ((byData = input.read()) != -1) {
           output.write(byData);
       }
       input.close();
       output.close();
   } catch (Exception e) {
       e.printStackTrace();
   }
    }
}