package ra.bai1.entity;

import java.util.Scanner;

public class Product {
    private String productid;
    private String productName;
    private float importPrice; //Giá nhập
    private float exportPrice; //Giá xuất
    private float profit;//Lợi nhuận
    private int quantity; //Số lượng sản phẩm
    private String descriptions;//Mô tả sản phẩm
    private boolean status; //Trạng thái sản phẩm

    //đa hình: thể hiện qua overLoadding và overriding
    public Product() {
    }

    public Product(String productid, String productName, float importPrice, float exportPrice, int quantity, String descriptions, boolean status) {
        this.productid = productid;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.status = status;
    }

    //overLoadding: contrucstor cùng tên nhưng khác nhau về số lượng tham số và kiểu tham số
    //overriding: giống nhau về kiểu tham số
    public Product(String productid, String productName, float importPrice, float exportPrice, float profit, int quantity, String descriptions, boolean status) {
        this.productid = productid;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.profit = profit;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.status = status;
    }

    public String getProductid() {
        return productid;
    }

    public String getProductName() {
        return productName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public float getProfit() {
        return profit;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public boolean isStatus() {
        return status;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public float calculateProfit(){ //tinh loi nhuan
        return profit = exportPrice-importPrice;
    }
    public void inputData(Scanner scanner, Product[] products){
        System.out.println("Nhập thông tin sản phẩm: ");
        System.out.println("Mã sản phẩm: ");
        this.productid= scanner.nextLine();
        System.out.println("Tên sản phẩm: ");
        this.productName=scanner.nextLine();
        System.out.println("Giá nhập: ");
        this.importPrice=Float.parseFloat(scanner.nextLine());
        System.out.println("Giá xuất: ");
        this.exportPrice=Float.parseFloat(scanner.nextLine());
        System.out.println("Số lượng sản phẩm: ");
        this.quantity=Integer.parseInt(scanner.nextLine());
        System.out.println("Mô tả sản phẩm: ");
        this.descriptions=scanner.nextLine();
        System.out.println("Trạng thái sản phẩm");
        this.status=Boolean.parseBoolean(scanner.nextLine());
    }
    public void displayData(){
        System.out.println("*******THÔNG TIN SINH VIÊN*********");
        System.out.printf("Mã sản phẩm: %s\nTên sản phẩm: %s\nGiá nhập: %f\n" ,this.productid, this.productName, this.importPrice);
        System.out.printf("Giá xuất: %f\nSố lượng sản phẩm: %d\nMô tả sản phẩm: %s\n" ,this.exportPrice, this.quantity,this.descriptions);
        System.out.println("Trạng thái sản phẩm: " + (this.isStatus() ? "Đang bán" : "Không bán"));
    }
    //thuộc tính ghi đè: cùng

    @Override
    public String toString() {
        return "Product{" +
                "productid='" + productid + '\'' +
                ", productName='" + productName + '\'' +
                ", importPrice=" + importPrice +
                ", exportPrice=" + exportPrice +
                ", profit=" + profit +
                ", quantity=" + quantity +
                ", descriptions='" + descriptions + '\'' +
                ", status=" + status +
                '}';
    }
}
