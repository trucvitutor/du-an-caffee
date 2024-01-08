package view;

import controller.CustomerController;
import controller.OrderController;
import controller.ProductController;
import controller.StaffController;

import java.util.Scanner;

public class MainView {
    public static final Scanner scanner = new Scanner(System.in);
    public static CustomerController controller = new CustomerController();
    public static OrderController orderController = new OrderController();
    public static ProductController productController = new ProductController();
    public static StaffController staffController = new StaffController();

    public static void menu() {
        int choice;
        while (true) {
            System.out.println("1.quản lý khách hàng." + "\n" +
                    "2.quản lý nhân viên." + "\n" + "3.quản lý sản phẩm." + "\n" + "4.order");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    customerManagement();
                    break;
                case 2:
                    staffManager();
                    break;
                case 3:
                    ProductManagement();
                    break;
                case 4:
                    orderManagement();
                    break;
            }
        }
    }

    private static void orderManagement() {
        int choice;
        while (true) {
            System.out.println("1.thêm nước uống." + "\n" + "2.hiển thị nước uống" + "\n" + "3.sửa nước uống" + "\n" + "4.xóa nước uống");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        }
    }

    private static void ProductManagement() {
        int choice;
        while (true) {
            System.out.println("1.thêm sản phẩm" + "\n" + "2.hiển thị sản phẩm" + "\n" + "3.sửa sản phẩm" + "\n" +
                    "4.xóa sản phẩm");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        }
    }

    private static void staffManager() {
        int choice;
        while (true) {
            System.out.println("1.thêm nhân viên" + "\n" + "2.hiển thị nhân viên" + "\n" + "3.sửa nhân viên" + "\n" +
                    "4.xóa nhân viên");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        }
    }

    private static void customerManagement() {
        int choice;
        while (true) {
            System.out.println("1.thêm khách hàng" + "\n" + "2.hiển thị khách hàng" + "\n" + "3.sửa khách hàng" + "\n" +
                    "4.xóa khách hàng");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        }
    }
}
