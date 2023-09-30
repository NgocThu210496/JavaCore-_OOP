package ra.main;

import javafx.scene.input.DataFormat;
import ra.entity.Categories;
import ra.entity.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ShopManagement {
    public static Scanner scanner = new Scanner(System.in);
    private static Product[] arrProducts = new Product[100]; //tạo mảng arrProducts để chứa alldata cuar Product
    private static Categories[] arrCategories = new Categories[100];
    private static int indexProduct = 0; //khởi tạo chir số phần tử nhập data
    private static int curentCategories = 0;

    public static void main(String[] args) {
        //khởi tạo mảng và gán giá trị mặc định cho từng phần tử
        arrCategories = new Categories[100];
        for (int i = 0; i < arrCategories.length; i++) {
            arrCategories[i] = new Categories();
        }
        do {
            System.out.println("*************SHOP MENU*************");
            System.out.println("1. Quản lý danh mục");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.println("************************************");
            System.out.println("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    ShopManagement.menuCategories(scanner);
                    break;
                case 2:
                    ShopManagement.menuProducts(scanner);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.err.println("Chọn từ 1-3");
            }
        } while (true);
    }

    public static void menuCategories(Scanner scanner) {
        boolean exitMenuCatalog = true; //chỉ  thoát khỏi menuCategories thôi
        do {
            System.out.println("***********CATEGORIES MENU***********");
            System.out.println("1. Nhập thông tin các danh mục");
            System.out.println("2. Hiển thị thông tin các danh mục");
            System.out.println("3. Cập nhật thông tin danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Cập nhật trạng thái danh mục");
            System.out.println("6. Thoát");
            System.out.println("************************************");
            System.out.println("Lựa chọn của bạn: ");
            int choiceMenuCatalog = Integer.parseInt(scanner.nextLine());
            switch (choiceMenuCatalog) {
                case 1:
                    System.out.println("1. Nhập thông tin các danh mục");
                    ShopManagement.inputListCategories(scanner);
                    break;
                case 2:
                    System.out.println("2. Hiển thị thông tin các danh mục");
                    ShopManagement.displayListCategories();
                    break;
                case 3:
                    System.out.println("3. Cập nhật thông tin danh mục");
                    ShopManagement.updateCategories();
                    break;
                case 4:
                    System.out.println("4. Xóa danh mục");
                    ShopManagement.deleteCategories();
                    break;
                case 5:
                    System.out.println("5. Cập nhật trạng thái danh mục");
                    ShopManagement.updateStatusCategories();
                    break;
                case 6:
                    exitMenuCatalog = false;
                    break;
                default:
                    System.err.println("Vui long chọn 1-6");
            }
        } while (exitMenuCatalog);
    }

    public static void inputListCategories(Scanner scanner) {
        System.out.println("Nhập vào số danh mục cần nhập thông tin: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            //khởi tạo phần tử thức curent là một đối tượng danh mục cần nhập liệu
            arrCategories[curentCategories] = new Categories();
            //nhập thông tin danh mục
            arrCategories[curentCategories].inputDataCatalog(scanner, arrCategories, curentCategories);
            //tang curentCategories
            curentCategories++;
        }
    }

    public static void displayListCategories() {
        for (int i = 0; i < curentCategories; i++) {
            arrCategories[i].displayDataCatalog();
        }
    }

    public static void updateCategories() {
        int updateId = Integer.parseInt(scanner.nextLine());
        //neu k tim thay phan tu
        int updateCategoriesIndex = -1;
        //dể lưu trữ chỉ số (index) cần chỉnh sửa trong mảng Categories.
        for (int i = 0; i < curentCategories; i++) {
            //updateId là kiểu int nên phải ==
            if (arrCategories[i].getCatalogId() == updateId) {
                updateCategoriesIndex = i; // Tìm thấy danh mục cần cập nhật, thoát khỏi vòng lặp
                break;
            }
        }
        if (updateCategoriesIndex >= 0) { //chi so phan tu can cap nhat
            System.out.println("Tên danh mục: ");
            arrCategories[updateCategoriesIndex].setCatalogName(scanner.nextLine());
            System.out.println("Mô tả danh mục: ");
            arrCategories[updateCategoriesIndex].setDescriptions(scanner.nextLine());
            System.out.println("Trạng thái danh mục: ");
            arrCategories[updateCategoriesIndex].setCatalogStatus(Boolean.parseBoolean(scanner.nextLine()));
        } else {
            System.err.println("Mã danh mục không tồn tại");
        }
        System.out.println("Đã cập nhật thành công");
    }

    public static void deleteCategories() {
        System.out.println("Nhập mã danh mục cần xoá: ");
        int deleteId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < curentCategories; i++) {
            if (arrCategories[i].getCatalogId() == deleteId) {
                //để dịch chuyển các sản phẩm phía sau của sản phẩm bị xoá lên trước
                for (int j = i; j < curentCategories; j++) {
                    arrCategories[j] = arrCategories[j + 1];
                }
                curentCategories--;
            } else {
                System.err.println("Mã danh mục không tồn tại");
            }
        }
        System.out.println("Đã Xoá xong");
    }

    public static void updateStatusCategories() {
        System.out.println("Nhập mã danh mục cần cập nhật trạng thái: ");
        int statusUpdateCategoriesId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < curentCategories; i++) {
            if (arrCategories[i].getCatalogId() == statusUpdateCategoriesId) {
                arrCategories[i].setCatalogStatus(!arrCategories[i].isCatalogStatus());
            }
//            else {
//                System.err.println("Mã danh mục không tồn tại");
//            }
        }
        System.out.println("Đã cập nhật xong");
    }

    public static void menuProducts(Scanner scanner) {
        boolean exitMenuProduct = true;
        do {
            System.out.println("*************PRODUCT MANAGEMENT*************");
            System.out.println("1. Nhập thông tin n sản phẩm");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Sắp xếp các sản phẩm theo giá");
            System.out.println("4. Cập nhật thông tin sản phẩm theo mã sản phẩm");
            System.out.println("5. Xóa sản phẩm theo mã sản phẩm");
            System.out.println("6. Tìm kiếm các sản phẩm theo tên sản phẩm");
            System.out.println("7. Tìm kiếm sản phẩm trong khoảng giá a – b (a,b nhập từ bàn phím)");
            System.out.println("8. Thoát");
            System.out.println("************************************");
            System.out.println("Lựa chọn của bạn: ");
            int choiceMenuProduct = Integer.parseInt(ShopManagement.scanner.nextLine());
            switch (choiceMenuProduct) {
                case 1:
                    System.out.println("1. Nhập thông tin n sản phẩm");
                    ShopManagement.inputProduct(scanner);
                    break;
                case 2:
                    System.out.println("2. Hiển thị thông tin các sản phẩm");
                    ShopManagement.displayProduct();
                    break;
                case 3:
                    System.out.println("3. Sắp xếp các sản phẩm theo giá");
                    ShopManagement.sortProductPice();
                    break;
                case 4:
                    System.out.println("4. Cập nhật thông tin sản phẩm theo mã sản phẩm");

                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    exitMenuProduct = false;
                    break;
                default:
                    System.err.println("Vui long chọn 1-8");
            }
        } while (exitMenuProduct);
    }

    public static void inputProduct(Scanner scanner) {
        System.out.println("Nhập vào số sản phẩm: ");
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            //khởi tạo phần tử thức indexProduct là một đối tượng danh mục cần nhập liệu
            arrProducts[indexProduct] = new Product();
            arrProducts[indexProduct].inputDataProduct(scanner, arrProducts, indexProduct, arrCategories, curentCategories);
            indexProduct++;
        }
    }

    public static void displayProduct() {
        for (int i = 0; i < indexProduct; i++) {
            arrProducts[i].dispalyDataProduct();
        }
    }

    public static void sortProductPice() {
        Float[] priceSort = new Float[indexProduct];
        for (int i = 0; i < indexProduct; i++) {
            priceSort[i] = arrProducts[i].getPrice();
        }
        Product temp = null;
        for (int i = 0; i < indexProduct - 1; i++) {
            for (int j = i + 1; j < indexProduct; j++) {
                if (priceSort[i] < priceSort[j]) {
                    temp = arrProducts[i];
                    arrProducts[i] = arrProducts[j];
                    arrProducts[j] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp xong");
    }

    public static void updateProduct() throws ParseException {
        int newId = Integer.parseInt(scanner.nextLine());
        //neu k tim thay phan tu
        int updateProductIndex = -1;
        for (int i = 0; i < indexProduct; i++) {
            if (arrCategories[i].getCatalogId() == newId) {
                updateProductIndex = i; // Tìm thấy danh mục cần cập nhật, thoát khỏi vòng lặp
                break;
            }
        }
        if (updateProductIndex > 0) {
            System.out.println("Cập nhật tên sản phẩm: ");
            arrProducts[indexProduct].setProductName(scanner.nextLine());
            System.out.println("cập nhật giá sản phẩm: ");
            arrProducts[indexProduct].setPrice(Float.parseFloat(scanner.nextLine()));
            System.out.println("Cập nhật mô tả sản phẩm: ");
            arrProducts[indexProduct].setDescription(scanner.nextLine());
            System.out.println("Cập nhật ngày sản phẩm: ");
            arrProducts[indexProduct].setCreated(SimpleDateFormat.getDateTimeInstance().parse(scanner.nextLine()));
//            System.out.println("Cập nhật danh mục: ");
//            arrProducts[indexProduct].setCategories(Integer.parseInt(scanner.nextLine()));
            System.out.println("Cập nhật trạng thái sản phẩm: ");
            updaStatusProduct();

        }
    }
    public static void updaStatusProduct(){
        int productIndexToUpdate = Integer.parseInt(scanner.nextLine());
        // Kiểm tra xem chỉ số có hợp lệ không
        if (productIndexToUpdate >= 0 && productIndexToUpdate < indexProduct) {
            System.out.println("Cập nhật trạng thái sản phẩm (0: Đang bán, 1: Hết hàng, 2: Không bán): ");

            int newStatus = Integer.parseInt(scanner.nextLine());
            if (newStatus >= 0 && newStatus <= 2) {
                arrProducts[productIndexToUpdate].setProductStatus(newStatus);
                System.out.println("Đã cập nhật trạng thái sản phẩm thành công.");
            } else {
                System.err.println("Trạng thái không hợp lệ.");
            }
        } else {
            System.err.println("Chỉ số sản phẩm không hợp lệ.");
        }
    }
}
