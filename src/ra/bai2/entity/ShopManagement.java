package ra.bai2.entity;

import java.util.Scanner;

public class ShopManagement {
    public static Scanner scanner = new Scanner(System.in);
    private static Product[] arrProducts = new Product[100]; //tạo mảng arrProducts để chứa alldata cuar Product
    private static Categories[] arrCategories = new Categories[100];
    private static int indexProduct=0; //khởi tạo chir số phần tử nhập data
    private static int  curentCategories=0;
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
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    exitMenuCatalog = false;
                    break;
                default:
                    System.err.println("Vui long chọn 1-6");
            }
        } while (exitMenuCatalog);
    }
    public static void  inputListCategories(Scanner scanner){
        System.out.println("Nhập vào số danh mục cần nhập thông tin: ");
        int n= Integer.parseInt(scanner.nextLine());
        for(int i=0; i<n;i++){
            //khởi tạo phần tử thức curent là một đối tượng danh mục cần nhập liệu
            arrCategories[curentCategories]= new Categories();
            //nhập thông tin danh mục
            arrCategories[curentCategories].inputDataCatalog(scanner,arrCategories,curentCategories);
            //tang curentCategories
            curentCategories++;
        }
    }
    public static void displayListCategories(){
        for(int i=0; i<curentCategories;i++){

        }
    }

    public static void menuProducts(Scanner scanner) {
        boolean exitMenuCatalog = true;
        do {
            System.out.println("*************PRODUCT MANAGEMENT*************");
            System.out.println("1. Nhập thông tin n danh mục");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Sắp xếp các sản phẩm theo giá");
            System.out.println("4. Cập nhật thông tin sản phẩm theo mã sản phẩm");
            System.out.println("5. Xóa sản phẩm theo mã sản phẩm");
            System.out.println("6. Tìm kiếm các sản phẩm theo tên sản phẩm");
            System.out.println("7. Tìm kiếm sản phẩm trong khoảng giá a – b (a,b nhập từ bàn phím)");
            System.out.println("8. Thoát");
            System.out.println("************************************");
            System.out.println("Lựa chọn của bạn: ");
            int choiceMenuCatalog = Integer.parseInt(ShopManagement.scanner.nextLine());
            switch (choiceMenuCatalog) {
                case 1:
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
                    exitMenuCatalog = false;
                    break;
                default:
                    System.err.println("Vui long chọn 1-8");
            }
        } while (exitMenuCatalog);
    }
}
