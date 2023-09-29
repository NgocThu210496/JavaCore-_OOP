package ra.bai1.entity.imp;

import ra.bai1.entity.Product;

import java.util.Scanner;

public class ProductImp {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Product[] products=new Product[100];
        products[0] = new Product("1","P1",8,10,6,"P1",true);
        products[1] = new Product("2","P2",4,12,40,"P2",true);
        products[2] = new Product("3","P3",3,6,15,"P3",true);
        products[3] = new Product("4","P4",2,3,0,"P4",false);
        products[4] = new Product("5","P5",4,8,20,"P5",true);

        int currentIndex=5;
        int choice;
        do {
            System.out.println("*********MENU********");
            System.out.println("1. Nhập thông tin n sản phẩm (n nhập từ bàn phím)");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Tính lợi nhuận các sản phẩm");
            System.out.println("4. Sắp xếp các sản phẩm theo lợi nhuận giảm dần");
            System.out.println("5. Thống kê các sản phẩm theo giá");
            System.out.println("6. Tìm các sản phẩm theo tên sản phẩm");
            System.out.println("7. Nhập sản phẩm");
            System.out.println("8. Bán sản phẩm");
            System.out.println("9. Cập nhật trạng thái sản phẩm");
            System.out.println("10. Nhập mã sản phẩm cần xoá");
            System.out.println("11. Nhập mã sản phẩm cần sửa");
            System.out.println("0. Thoát");
            System.out.println("************************");
            System.out.println("Nhập lựa chọn của bạn: ");
            choice= Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    System.out.println("1. Nhập thông tin n sản phẩm (n nhập từ bàn phím)");
                    int n = Integer.parseInt(scanner.nextLine());
                    // để thêm n sản phẩm vào danh sách
                    for (int i = 0; i < n; i++) {
                        if (currentIndex < products.length) {
                           // tạo một đối tượng sản phẩm mới và lưu nó vào mảng products ở vị trí currentIndex.
                            products[currentIndex] = new Product();
                            products[currentIndex].inputData(scanner, products);
                            currentIndex++; // tăng lên sau mỗi lần thêm sản phẩm
                        } else { //Nếu currentIndex vượt quá độ dài của mảng products
                            System.out.println("Bộ nhớ bị tràn.");
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("2. Hiển thị thông tin các sản phẩm");
                    for(int i=0; i<currentIndex;i++){
                        products[i].displayData();
                    }
                    break;
                case 3:
                    System.out.println("3. Tính lợi nhuận các sản phẩm");
                    for(int i=0; i<currentIndex;i++){
                        products[i].calculateProfit();
                        System.out.println("Lợi nhuận của sản phẩm thứ " + (i + 1) + ": " + products[i].getProfit());
                    }
                    break;
                case 4:
                    System.out.println("4. Sắp xếp các sản phẩm theo lợi nhuận giảm dần");
                    Float[] priceSort = new Float[currentIndex];
                    for (int i = 0; i < currentIndex; i++) {
                        priceSort[i] = products[i].calculateProfit();
                    }
                    Product temp = null;
                    for (int i = 0; i < currentIndex - 1; i++) {
                        for (int j = i + 1; j < currentIndex; j++) {
                            if (priceSort[i] < priceSort[j]) {
                                temp = products[i];
                                products[i] = products[j];
                                products[j]= temp;
                            }
                        }
                    }
                    System.out.println("Đã sắp xếp xong");
                    break;
                case 5:
                    System.out.println("5. Thống kê sản phẩm theo giá");
                    System.out.print("Nhập giá bắt đầu: ");
                    float fromPrice=Float.parseFloat(scanner.nextLine());
                    System.out.print("Nhập giá kết thúc: ");
                    float toPrice= Float.parseFloat(scanner.nextLine());
                    //countProductPriceRange: để theo dõi số lượng sản phẩm có giá bán trong khoảng từ fromPrice đến toPrice.
                    int countProductPriceRange=0;
                    for(int i=0; i<currentIndex;i++){
                        float productPrice = products[i].getExportPrice(); //để lấy giá bán của sản phẩm i trong mảng products
                        // productPrice:là biến tạm
                        if (productPrice >= fromPrice && productPrice <= toPrice) {
                            countProductPriceRange++;
                        }

                    }System.out.println("Số lượng sản phẩm có giá từ " + fromPrice + " đến " + toPrice + " là: " + countProductPriceRange);
                    break;
                case 6:
                    System.out.println("6. Tìm sản phẩm theo tên");
                    System.out.print("Nhập tên sản phẩm cần tìm: ");
                    String searchName = scanner.nextLine();
                    boolean test = false; //tim san pham co hay khong
                    for (int i = 0; i < currentIndex; i++) {
                        String productName = products[i].getProductName().toLowerCase(); // Chuyển tên sản phẩm về chữ thường để tìm kiếm không phân biệt hoa thường
                        if (productName.contains(searchName.toLowerCase())) {
                            products[i].displayData(); // Hiển thị thông tin sản phẩm tìm thấy
                            test = true;
                        }
                    }
                    if (!test) {
                        System.err.println("Không tìm thấy sản phẩm nào có tên: " + searchName);
                    }
                    break;
                case 7:
                    System.out.println("7. Nhập sản phẩm");
                    System.out.print("Nhập mã sản phẩm: ");
                    String productid  = scanner.nextLine();
                    System.out.print("Nhập số lượng sản phẩm cần nhập: ");
                    //quantityToAdd: số lượng sản phẩm mà người dùng muốn nhập thêm vào hệ thống
                    int quantityToAdd = Integer.parseInt(scanner.nextLine());
                    boolean productFound = false; //chưa tìm thấy sản phẩm có mã sản phẩm tương ứng
                    for (int i = 0; i < currentIndex; i++) {
                        // so sánh mã sản phẩm (productid) của sản phẩm tại vị trí hiện tại trong danh sách với mã sản phẩm mà người dùng đã nhập.
                        if (products[i].getProductid().equals(productid)) {
                            //lệnh để cập nhật số lượng (quantity) của sản phẩm
                            //getQuantity():lấy giá trị hiện tại của số lượng của sản phẩm
                            //setQuantity: gán giá trị mới cho số lượng của sản phẩm
                            products[i].setQuantity(products[i].getQuantity() + quantityToAdd);
                            productFound = true;
                            break;
                        }
                    }

                    if (productFound) {
                        System.out.println("Nhập sản phẩm thành công.");
                    } else {
                        System.err.println("Không tìm thấy sản phẩm có mã: " + productid);
                    }
                    break;
                case 8:
                    System.out.println("8. Bán sản phẩm");
                    System.out.print("Nhập tên sản phẩm cần bán: ");
                    String productNameToSell = scanner.nextLine();
                    boolean productFoundForSale = false; //sản phẩm cần bán có tồn tại trong danh sách sản phẩm hay không.
                    for (int i = 0; i < currentIndex; i++) {
                        // tên sản phẩm tại vị trí hiện tại i có khớp với tên sản phẩm mà người dùng đã nhập không.
                        //equalsIgnoreCase():được sử dụng để so sánh không phân biệt chữ hoa chữ thường.
                        if (products[i].getProductName().equalsIgnoreCase(productNameToSell)) {
                            System.out.print("Nhập số lượng sản phẩm cần bán: ");
                            int quantityToSell = scanner.nextInt();
                            scanner.nextLine();

                            if (products[i].getQuantity() >= quantityToSell) {
                                products[i].setQuantity(products[i].getQuantity()-quantityToSell);
                                System.out.println("Bán sản phẩm thành công.");
                            } else {
                                System.err.println("Số lượng sản phẩm không đủ để bán.");
                            }
                            productFoundForSale = true;
                            break;
                        }
                    }
                    if (!productFoundForSale) {
                        System.err.println("Không tìm thấy sản phẩm có tên: " + productNameToSell);
                    }
                    break;
                case 9:
                    System.out.println("Nhập mã sản phẩm cần cập nhật trạng thái:");
                    String statusEditId = scanner.nextLine();
                    for (int i = 0; i < currentIndex; i++) {
                        if (products[i].getProductid().equals(statusEditId)) {
                            products[i].setStatus(!products[i].isStatus());
                        }
                    }
                    System.out.println("Đã cập nhật xong");
                    break;
                case 10:
                    System.out.println("Nhập mã sản phẩm cần xoá: ");
                    String deleteId=scanner.nextLine();
                    for(int i=0;i<currentIndex;i++){
                        if(products[i].getProductid().equals(deleteId)){
                            for(int j=i;j<currentIndex;j++){
                                products[j]=products[j+1];
                            }
                            currentIndex--;
                        }
                    } System.out.println("Đã Xoá xong");
                    break;
                case 11:
                    System.out.println("11. Nhập mã sản phẩm cần sửa: ");
                    String updateId=scanner.nextLine();
                    //updateIndex: để lưu trữ chỉ số (index) cần chỉnh sửa trong mảng products.
                    int updateIndex=-1;//neu k tim thay phan tu
                    for(int i=0;i<currentIndex;i++){
                        if(products[i].getProductid().equals(updateId)){
                            updateIndex=i;
                            break;
                        }
                    }
                    if(updateIndex>=0){ //chi so phan tu can cap nhat
                        System.out.println("Ten SP");
                        products[updateIndex].setProductName(scanner.nextLine());
                        System.out.println("Giá nhập");
                        products[updateIndex].setImportPrice(Integer.parseInt(scanner.nextLine()));
                        System.out.println("Giá xuất");
                        products[updateIndex].setExportPrice(Float.parseFloat(scanner.nextLine()));
                        System.out.println("Số lượng sản phẩm");
                        products[updateIndex].setQuantity(Integer.parseInt(scanner.nextLine()));
                        System.out.println("Mô tả sản phẩm");
                        products[updateIndex].setDescriptions(scanner.nextLine());
                        System.out.println("Trạng thái sản phẩm");
                        products[updateIndex].setStatus(Boolean.parseBoolean(scanner.nextLine()));
                    }else {
                        System.err.println("Ma SV Khong ton tai");
                    }
                    System.out.println("Đã cập nhật thầnh công");
                   break;

                case 0:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Chức năng không hợp lệ. Vui lòng chọn lại.");
            }

        }while (true);
    }
}
