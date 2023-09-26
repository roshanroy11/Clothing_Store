package clothing_store;

public class Product {
    private String productType_Dropdown;
    private String productName_Dropdown;
    private String productColor_Dropdown;
    private String productSize_Dropdown;

    private String state;



    public Product(String productType_Dropdown, String productName_Dropdown, String productColor_Dropdown, String productSize_Dropdown){
        this.productType_Dropdown = productType_Dropdown;
        this.productName_Dropdown = productName_Dropdown;
        this.productColor_Dropdown = productColor_Dropdown;
        this.productSize_Dropdown = productSize_Dropdown;
    }

    public Product(String productType_Dropdown, String productName_Dropdown, String productColor_Dropdown, String productSize_Dropdown, String state){
        this.productType_Dropdown = productType_Dropdown;
        this.productName_Dropdown = productName_Dropdown;
        this.productColor_Dropdown = productColor_Dropdown;
        this.productSize_Dropdown = productSize_Dropdown;
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getProductType_Dropdown() {
        return productType_Dropdown;
    }

    public void setProductType_Dropdown(String productType_Dropdown) {
        this.productType_Dropdown = productType_Dropdown;
    }

    public String getProductName_Dropdown() {
        return productName_Dropdown;
    }

    public void setProductName_Dropdown(String productName_Dropdown) {
        this.productName_Dropdown = productName_Dropdown;
    }

    public String getProductColor_Dropdown() {
        return productColor_Dropdown;
    }

    public void setProductColor_Dropdown(String productColor_Dropdown) {
        this.productColor_Dropdown = productColor_Dropdown;
    }

    public String getProductSize_Dropdown() {
        return productSize_Dropdown;
    }

    public void setProductSize_Dropdown(String productSize_Dropdown) {
        this.productSize_Dropdown = productSize_Dropdown;
    }

    // Product Type:
//    public String getProductType() {
//        return productType;
//    }
//    public void setProductType(String productType) {
//        this.productType = productType;
//    }
//
//    // Product Name
//    public String getProductName() {
//        return productName;
//    }
//    public void setProductName(String prodName) {
//        this.productName = prodName;
//    }
//
//    // Product Color
//    public String getProductColor() {
//        return productColor;
//    }
//    public void setProductColor(String prodColor) {
//        this.productColor = prodColor;
//    }
//
//    // Product Size
//    public String getProductSize() {
//        return productSize;
//    }
//    public void setProductSize(String prodSize) {
//        this.productSize = prodSize;
//    }
//
//    public String getStateName() {return stateName;}
//
//    public void setStateName(String stateName) {this.stateName = stateName;}


//    //Added New
//    public double getBrandPrice(String itemName) {
//        String item = itemName.toUpperCase();
//
//        switch (item){
//            case "NIKE":
//                return 40;
//            case "ADIDAS":
//                return 35;
//            case "PUMA":
//                return 30;
//            case "REEBOK":
//                return 25;
//            default:
//                System.out.println("Invalid Brand entered..");
//                return 0.0;
//        }
//    }
    //
////    // get the product type price for a product
//    public double getProductTypePrice(String PrdType) {
//        String item = PrdType.toUpperCase();
//        switch (item) {
//            case "SHIRT":
//                return 10;
//            case "PANT":
//                return 5;
//            case "HOODIE":
//                return 15;
//            default:
//                System.out.println("Invalid Product Type entered..");
//                return 0.0;
//        }
//    }

//    public double getStateTax(String stateName) {
//
//        String state = stateName.toUpperCase();
//
//        switch (state){
//            case "PA":
//                return .06;
//            case "NJ":
//                return .0662;
//            case "CT":
//                return .0635;
//            case "NY":
//                return .04;
//            case "FL":
//                return 0.06;
//            case "TX":
//                return 0.625;
//            default:
//                System.out.println("Invalid state entered..");
//                return 0.0;
//        }
//    }

}
