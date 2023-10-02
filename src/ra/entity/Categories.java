package ra.entity;

import java.util.Scanner;

public class Categories {
   // private static int nextCatalogId = 1; // Biến để theo dõi mã danh mục tiếp theo
    private int catalogId;
    private String catalogName;
    private String descriptions; //mô tả danh mục
    private boolean catalogStatus; //true – hoạt động, false – không hoạt động


    public Categories() { // Hàm tạo mặc định
        //this.catalogId = nextCatalogId++;
    }

    public Categories(int catalogId, String catalogName, String descriptions, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    public void inputDataCatalog(Scanner scanner, Categories[] arrCategories, int curentCategories) {
        System.out.println("1.Nhập thông tin danh mục");
       /* if (arrCategories == null) {
            this.catalogId = 1;// ban dau phai la 1
        } else {
            //lay gia tri id cua phan tu cuoi cung +1
            this.catalogId = arrCategories[arrCategories.length - 1].getCatalogId() + 1;
        }*/
        if (curentCategories == 0) {
            this.catalogId = 1;// ban dau phai la 1
        } else {
            //lay gia tri id cua phan tu cuoi cung +1
            this.catalogId = arrCategories[curentCategories - 1].getCatalogId() + 1;
        }

        System.out.println("2.Nhập Tên danh mục");
        do {
            //có độ dài tối đa 50 ký tự,không trùng lặp.
            this.catalogName = scanner.nextLine();
            boolean isDuplicate = false;
            if (!this.catalogName.isEmpty() && this.catalogName.length() < 50) {
                //chuyển đổi trạng thái khi thoã mãn đk
                //khong trung lap
                for (int i = 0; i < curentCategories; i++) {
                    if (arrCategories[i].getCatalogName().equals(this.catalogName)) {
                        isDuplicate=true;
                        break;
                    }
                }
                if (isDuplicate) {
                    System.err.println("Tên danh mục đã tồn tại, mời nhập lại!");
                }
                else {
                    break;
                }
            } else {
                System.err.println("Nhập vào độ dài từ 1=>50 ký tự, mời nhập lại!");
            }
        } while (true);

        System.out.println("3.Mô tả danh mục");
        this.descriptions = scanner.nextLine();

        System.out.println("4.Nhập vào trạng thái danh mục: ");
        do {
            String status = scanner.nextLine();
            if (status.equals("true")) {
                this.catalogStatus = true;
                break;
            }
            if (status.equals("false")) {
                this.catalogStatus = false;
                break;
            }

            System.err.println("Không đúng định dạng,mời nhập Lại");
        }
        while (true);
    }

    public void displayDataCatalog() {
        System.out.printf("CatalogId: %d\nTen danh muc: %s\nMô tả danh mục: %s\nStatus: %s\n", this.catalogId, this.catalogName, this.descriptions, this.catalogStatus ? "Hoạt động" : "Không hoạt động");
        System.out.println("--------------------------------------");
    }

}
