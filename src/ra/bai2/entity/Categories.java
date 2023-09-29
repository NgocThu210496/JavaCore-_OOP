package ra.bai2.entity;

import java.util.Scanner;

public class Categories {
    private int catalogId;
    private String catalogName;
    private String descriptions; //mô tả danh mục
    private boolean catalogStatus; //true – hoạt động, false – không hoạt động

    public Categories() {
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
        System.out.println("Nhập thông tin danh mục:");
        if (arrCategories == null) {
            this.catalogId = 1;// ban dau phai la 1
        } else {
            //lay gia tri id cua phan tu cuoi cung +1
            this.catalogId = arrCategories[arrCategories.length - 1].getCatalogId() + 1;
        }
        System.out.println("Nhập Tên danh mục");

        do {
               //có độ dài tối đa 50 ký tự,không trùng lặp.
            this.catalogName = scanner.nextLine();
            if (!this.catalogName.isEmpty() && this.catalogName.length() < 50) {
                //chuyển đổi trạng thái khi thoã mãn đk
                boolean check = false;
                //khong trung lap
                for (int i = 0; i < curentCategories; i++) {
                    if (this.catalogName.equals(arrCategories[i].getCatalogName())) {
                        System.err.println("Tên danh mục đã tồn tai, mời nhập lại!");

                    } else {
                        //khi vao day thi da thoa man dieu kien do dai<50 va k trung lap
                        check = true;
                    }
                }
                if (check) {
                    break;
                }
            } else {
                System.err.println("Nhập vào độ dài từ 1=>50 ký tự, mời nhập lại!");
            }
        } while (true);

        System.out.println("Mô tả danh mục");
        this.descriptions = scanner.nextLine();

        System.out.println("Nhập vào trạng thái danh mục: ");
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

            System.out.println("Không đúng định dạng,mời nhập Lại");

        }
        while (true);
    }
    public void displayData() {
        System.out.printf("CatalogId: %d\n Ten danh muc: %s\nMô tả danh mục: %s\nStatus: %b\n", this.catalogId, this.catalogName, this.descriptions, this.catalogStatus);
    }

}
