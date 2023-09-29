package ra.bai2.entity;

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

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
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
    public static void inputProduct(){

    }
}
