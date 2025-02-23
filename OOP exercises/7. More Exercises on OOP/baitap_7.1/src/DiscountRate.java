public class DiscountRate {
    private static final double serviceDiscountPremium = 0.2;
    private static final double serviceDiscountGold = 0.15;
    private static final double serviceDiscountSilver = 0.1;
    private static final double productDiscountPrmium = 0.1;
    private static final double productDiscountGold = 0.1;
    private static final double productDiscountSilver = 0.1;

    public static double getServiceDiscountRate(String type) {
        if(type == null) {
            return 0.0;
        }

        switch (type) {
            case "Premium":
                return serviceDiscountPremium;
            case "Gold":
                return serviceDiscountGold;
            case "Silver":
                return serviceDiscountSilver;
            default:
                return 0.0;
        }
    }
    public static double getProductDiscountRate(String type) {
        if(type == null) {
            return 0.0;
        }
        switch (type) {
            case "Premium":
                return productDiscountPrmium;
            case "Gold":
                return productDiscountGold;
            case "Silver":
                return productDiscountSilver;
            default:
                return 0.0;
        }
    }

}
