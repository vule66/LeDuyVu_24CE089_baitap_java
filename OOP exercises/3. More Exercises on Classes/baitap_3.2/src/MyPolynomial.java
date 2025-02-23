public class MyPolynomial {
    private double[] coeffs;
    public MyPolynomial(double... cosffs){
        this.coeffs=cosffs;
    }
    public int getDegree(){
        return this.coeffs.length-1;
    }

    @Override
    public String toString() {
        StringBuilder m = new StringBuilder();
        for(int i=getDegree();i>=0;i--){
            if (coeffs[i] != 0) {
                if (m.length() > 0) m.append(" + ");
                m.append(coeffs[i]).append("x^").append(i);
            }
        }
        return m.toString().replace("x^0","").replace("x^1","x");
    }

    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i < coeffs.length; i++) {
            result += coeffs[i] * Math.pow(x, i);
        }
        return result;
    }

    public MyPolynomial add(MyPolynomial right) {
        int maxDegree = Math.max(this.getDegree(), right.getDegree());
        double[] newCoeffs = new double[maxDegree + 1];

        for (int i = 0; i <= maxDegree; i++) {
            double c1 = (i <= this.getDegree()) ? this.coeffs[i] : 0;
            double c2 = (i <= right.getDegree()) ? right.coeffs[i] : 0;
            newCoeffs[i] = c1 + c2;
        }
        return new MyPolynomial(newCoeffs);
    }

    public MyPolynomial multiply(MyPolynomial right) {
        int newDegree = this.getDegree() + right.getDegree();
        double[] newCoeffs = new double[newDegree + 1];

        for (int i = 0; i <= this.getDegree(); i++) {
            for (int j = 0; j <= right.getDegree(); j++) {
                newCoeffs[i + j] += this.coeffs[i] * right.coeffs[j];
            }
        }
        return new MyPolynomial(newCoeffs);
    }
}
