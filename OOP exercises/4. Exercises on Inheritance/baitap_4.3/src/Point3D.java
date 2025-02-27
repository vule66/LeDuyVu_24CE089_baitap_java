public class Point3D extends Point2D {
    float z;

    public Point3D(float x, float y, float z){
        super(x, y);
        this.z = z;
    }
    public Point3D(){

        this.z = z;
    }
    public float getZ(){

        return z;
    }
    public void setZ(float z){

        this.z = z;
    }
    public void setXYZ(float x, float y, float z){
        super.setX(x);
        super.setY(y);
        this.z = z;
    }
    public float[] getXYZ(){
        float[] result = new float[3];
        result[0] = this.x;
        result[1] = this.y;
        result[2] = this.z;
        return result;
    }
    public String toString(){

        return super.toString() + "," + z;
    }
}