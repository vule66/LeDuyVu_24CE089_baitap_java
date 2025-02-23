import java.util.Arrays;

public class Book {
    private String name;
    private Author[] author;
    private double price;
    private int qty;

    public Book(String name,Author[] author,double price){
        this.name=name;
        this.author=author;
        this.price=price;
        this.qty=0;
    }
    public Book(String name,Author[] author,double price,int qty){
        this.name=name;
        this.author=author;
        this.price=price;
        this.qty=qty;
    }

    public String getName() {

        return name;
    }

    public Author[] getAuthor() {

        return author;
    }

    public double getPrice() {

        return price;
    }

    public int getQty() {

        return qty;
    }

    public void setPrice(double price) {

        this.price = price;
    }

    public void setQty(int qty) {

        this.qty = qty;
    }

    public String getAuthorName(){
        StringBuilder names = new StringBuilder();
        for(int i=0;i<author.length;i++){
            names.append(author[i].getName());
            if (i<author.length-1){
                System.out.printf(",");
            }
        }
        return names.toString();
    }

    @Override
    public String toString() {
        StringBuilder authors = new StringBuilder();
        for(int i=0;i<author.length;i++){
            authors.append(author[i]);
            if (i<author.length-1){
                authors.append(",");
            }
        }
        return "Book[name:"+name+",author={"+ authors.toString() +"},price="+price+",qty="+qty+"]";
    }

}
