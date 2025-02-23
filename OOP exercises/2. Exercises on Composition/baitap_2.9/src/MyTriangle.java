public class MyTriangle {
    private MyPoint v1;
    private MyPoint v2;
    private MyPoint v3;
    public MyTriangle(int x1,int y1,int x2,int y2,int x3,int y3){
        this.v1 = new MyPoint(x2,y1);
        this.v2=new MyPoint(x2,y2);
        this.v3= new MyPoint(x3,y3);
    }
    public MyTriangle(MyPoint v1,MyPoint v2,MyPoint v3){
        this.v1=v1;
        this.v2=v2;
        this.v3=v3;
    }

    @Override
    public String toString() {
        return "MyTriangle[v1="+v1+",v2="+v2+",v3="+v3+"]";
    }
    public double getPerimeter(){
        double c1 = v1.distance(v2);
        double c2 = v2.distance(v3);
        double c3 = v3.distance(v1);
        return c1+c2+c3;
    }
    public String getType(){
        double c1 = v1.distance(v2);
        double c2 = v2.distance(v3);
        double c3 = v3.distance(v1);
        if(c1==c2 && c1== c3){
            return  "Equilateral";
        } else if (c1==c2 && c1!=c3) {
            return "Isosceles";
        }
        else return "Scalene";
    }
}
