package ra.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Product {
    private String productid;
    private String productName;
    private float price;
    private String description;
    private Date created;

    private Categories categories; //có kiểu lớp là Categories
    private int productStatus; //0: Đang bán – 1: Hết hàng – 2: Không bán

    public Product() {
    }

    public Product(String productid, String productName, float price, String description, Date created, Categories categories, int productStatus) {
        this.productid = productid;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.created = created;
        this.categories = categories;
        this.productStatus = productStatus;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductid() {
        return productid;
    }

    public String getProductName() {
        return productName;
    }

    public float getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreated() {
        return created;
    }

    public Categories getCategories() {
        return categories;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void inputDataProduct(Scanner scanner, Product[] arrProduct, int indexProduct, Categories[] arrCategories, int curentCategories) {
        System.out.println("Nhập thông tin của sản phẩm");
        /*gồm 4 ký tự bắt đầu là một trong 3 ký tự (C: các đồ uống là café,
         S: các đồ uống là sinh tố, A: các đồ ăn nhanh), không được trùng lặp*/
        System.out.println("Nhập vào mã đồ uống: ");
        do {

            this.productid = scanner.nextLine();
            boolean check = false;
            if (productid.length() == 4) {
                if (productid.startsWith("C") || productid.startsWith("S") || productid.startsWith("A")) {

                    //không được trùng lặp
                    for (int i = 0; i < indexProduct; i++) {
                        if (productName.equals(arrProduct[i].getProductName())) {
                            check = true;
                            break;
                        }
                    }
                    if (check) {
                        System.err.println("Đã tồn tại mã sản phẩm, vui lòng nhập lại!");

                    }else {
                        //nếu thoả mãn thì vào đây
                        //check = true;
                        break;
                    }
                } else {
                    System.err.println("C: các đồ uống là café,S: các đồ uống là sinh tố, A: các đồ ăn nhanh, vui lòng nhập lại!");
                }

            } else
                System.err.println("Độ dài phải đủ 4 ký tự, mời nhập lại!");

        } while (true);


        System.out.println("Nhập tên đồ uống"); //tên sản phẩm đồ uống, có từ 10-50 ký tự,
        do {
            this.productName = scanner.nextLine();
            boolean checkDink = false;
            if (!(this.productName.length() > 10) || this.productName.length() < 50) {
                //không được trùng lặp
                for (int i = 0; i < indexProduct; i++) {
                    //this.productName.equals(arrProduct[i].getProductName())
                    if (arrProduct[i].getProductName().equals(this.productName)) {
                        checkDink = true;
                        break;

                    }
                }
                if (checkDink) {
                    System.err.println("Tên đồ uống đã bị trùng lặp, vui lòng nhập lại");
                }
                else {
                    break;
                }
            }
            else {
                System.err.println("Nhập  tên sản phẩm đồ uống, có từ 10-50 ký tự,mời nhập lại!");
            }
        } while (true);


        do {
            System.out.println("Giá sản phẩm"); //giá sản phẩm có giá trị lớn hơn 0
            this.price = Float.parseFloat(scanner.nextLine());
            if (!(this.price > 0)) {
                System.out.println("Giá sản phẩm có giá trị lớn hơn 0, mời nhập lại!");
            } else {
                break;
            }
        } while (true);

        System.out.println("Mô tả sản phẩm");
        this.description = scanner.nextLine();

        //ngày nhập sản phẩm có định dạng dd/mm/yyyy
        System.out.println("Ngày nhập sản phẩm: ");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        String birthDateStr = scanner.nextLine();
        try {
            //or Data created
            this.created = sdf.parse(birthDateStr);
            System.out.println("Ngày nhập sản phẩm la: " + this.created);
        } catch (Exception ex) {
            System.err.println("Ngày nhập sản phẩm không đúng định dạng, vui lòng  nhập lại!");
        }

        System.out.println("Mã danh mục mà sản phẩm thuộc về");
        System.out.println("Chọn danh mục của sản phẩm ");
        //hiển thị ra các danh mục
        for (int i = 0; i < curentCategories; i++) {
            System.out.println(i + 1 + "." + arrCategories[i].getCatalogName());
        }
        System.out.println("Lựa chọn của bạn");
        //choice: chỉ số phần tử catalog đc chọn
        int choice = Integer.parseInt(scanner.nextLine());
        //lay ten danh muc trong phan tu doi tuong Categories
        this.categories = arrCategories[choice - 1];  // categories là catalogId

        System.out.println("Nhập vào trạng thái");
        do {

            int status = Integer.parseInt(scanner.nextLine());
            if (status == 0) {
                this.productStatus = 0;
                break;
            }
            if (status == 1) {
                this.productStatus = 1;
                break;
            }
            if (status == 2) {
                this.productStatus = 2;
                break;
            }

            System.out.println("Không đúng định dạng,mời nhập Lại");
        } while (true);
    }

    public void displayProductStatus() {
        String statusText;
        switch (this.productStatus) {
            case 0:
                statusText = "Đang bán";
                break;
            case 1:
                statusText = "Hết hàng";
                break;
            case 2:
                statusText = "Không bán";
                break;
            default:
                statusText = "Trạng thái không xác định";
        }
        System.out.println("Trạng thái sản phẩm: " + statusText);
    }

    public void dispalyDataProduct() {
        System.out.printf("Mã đồ uống: %s\nTên đồ uống: %s\nGiá sản phẩm: %f\n", this.productid, this.productName, this.price);
        System.out.printf("Mô tả sản phẩm: %s\nNgày nhập sản phẩm: %tF\nMã danh mục mà sản phẩm: %d\n", this.description, this.created, this.categories.getCatalogId());
        displayProductStatus(); // Gọi phương thức displayProductStatus() ở đây
    }
}
