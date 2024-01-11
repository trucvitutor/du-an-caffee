package view;

import common.ExceptionHandler;
import controller.CustomerController;
import controller.OrderController;
import controller.ProductController;
import controller.StaffController;
import model.*;
import repository.CustomerTypeRepository;
import repository.ProductTypeRepository;
import repository.StaffTypeRepository;

import java.util.List;
import java.util.Scanner;


public class MainView {
    public static Scanner scanner = new Scanner(System.in);
    public static CustomerController controller = new CustomerController();
    public static OrderController orderController = new OrderController();
    public static ProductController productController = new ProductController();
    public static ProductTypeRepository productTypeRepository = new ProductTypeRepository();
    public static StaffController staffController = new StaffController();
    public static CustomerTypeRepository customerTypeRepository = new CustomerTypeRepository();
    public static StaffTypeRepository staffTypeRepository = new StaffTypeRepository();

    public static void menu() {
        int choice;
        while (true) {
            System.out.println("1.★ Quản lý khách hàng ★." + "\n" +
                    "2.★ Quản lý nhân viên ★." + "\n" +
                    "3.★ Quản lý sản phẩm ★." + "\n" +
                    "4.★ Order ★." + "\n" +
                    "5.✘ Thoát ✘");
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
                case 5:
                    return;
            }
        }
    }

    private static void orderManagement() {
        int choice;
        while (true) {
            System.out.println("1.thêm nước uống." + "\n" + "2.hiển thị nước uống" + "\n" + "3.sửa nước uống" + "\n" + "4.xóa nước uống");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addOrder();
                    break;
                case 2:
                    List<Order> orderList = orderController.findAll();
                    display(orderList);
                    break;
                case 3:

                    break;
                case 4:
                    break;
            }
        }
    }

    private static void addOrder() {

    }

    private static void display(List<Order> orderList) {
        for (Order o : orderList) {
            System.out.println(o);
        }
    }

//    private static Order addOrder() {
//        System.out.println("Please enter your id");
//        int id = Integer.parseInt(scanner.nextLine());
//        System.out.println("Please enter your code");
//        String code = scanner.nextLine();
//        System.out.println("Please enter your customer");
//        Customer customer = new Customer();
//        System.out.println("Please enter your totalPay");
//        int totalPay = Integer.parseInt(scanner.nextLine());
//        System.out.println("Please enter your staff");
//        Staff staff = new Staff();
//        return new Order(id, code, customer, totalPay, staff);
//    }

    private static void ProductManagement() {
        int choice;
        while (true) {
            System.out.println("1.thêm sản phẩm" + "\n" + "2.hiển thị sản phẩm" + "\n" + "3.sửa sản phẩm" + "\n" +
                    "4.xóa sản phẩm" + "\n" + "5. thoát ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    List<Product> productList = productController.findAllProduct();
                    displayProduct(productList);
                    break;
                case 3:
                    editProduct();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                    return;
            }
        }
    }

    private static void deleteProduct() {
        System.out.println("Nhập id muốn xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("bạn chắc chắn muốn xóa không " + "\n" +
                "1.yes" + "\n" +
                "2.no");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                productController.removeProduct(id);
                System.out.println("xóa thành công");
                break;
            case 2:
                break;
        }
    }

    private static void editProduct() {
        System.out.println("nhập id bạn muốn sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        Product product = productController.findIdProduct(id);
        while (product != null) {
            System.out.println("Please enter your name");
            String name = scanner.nextLine();
            System.out.println("Please enter your price");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.println("Please enter your productType");
            List<ProductType> products = productTypeRepository.findProduct();
            ProductType productType = choiceProductType(products);
            product.setName(name);
            product.setPrice(price);
            product.setProductType(productType);
            ProductController.editPro(product);
        }

    }

    private static void displayProduct(List<Product> productList) {
        for (Product t : productList) {
            System.out.println(t);
        }
    }

    private static void addProduct() {
        System.out.println("Please enter your id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter your name");
        String name = scanner.nextLine();
        System.out.println("Please enter your price");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Please enter your productType");
        List<ProductType> products = productTypeRepository.findProduct();
        ProductType productType = choiceProductType(products);
        Product product = new Product(id, name, price, productType);
        ProductController.saveProduct(product);

    }

    private static void staffManager() {
        int choice;
        while (true) {
            System.out.println("1.thêm nhân viên" + "\n" + "2.hiển thị nhân viên" + "\n" + "3.sửa nhân viên" + "\n" +
                    "4.xóa nhân viên");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addStaff();
                    break;
                case 2:
                    List<Person> people = staffController.findAllStaff();
                    showStaff(people);
                    break;
                case 3:
                    editStaff();
                    break;
                case 4:
                    deleteStaff();
                    break;
            }
        }
    }

    private static void deleteStaff() {
        System.out.println("Nhập id muốn xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("bạn chắc chắn muốn xóa không " + "\n" +
                "1.yes" + "\n" +
                "2.no");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                StaffController.removeStaff(id);
                System.out.println("xóa thành công");
                break;
            case 2:
                break;
        }

    }

    private static void editStaff() {
        System.out.println("nhập id bạn muốn sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        Staff staff = StaffController.findidStaff(id);
        while (staff != null) {
            System.out.println("Please enter your code");
            String code = scanner.nextLine();
            System.out.println("Please enter your name");
            String name = scanner.nextLine();
            System.out.println("Please enter your phoneNumber");
            int phoneNumber = Integer.parseInt(scanner.nextLine());
            System.out.println("Please enter your gmail");
            String gmail = scanner.nextLine();
            System.out.println(" nhập idCard ");
            String idCard = scanner.nextLine();
            System.out.println(" nhập salary");
            double salary = Double.parseDouble(scanner.nextLine());
            System.out.println("nhập address");
            String address = scanner.nextLine();
            System.out.println("nhập StaffType");
            List<StaffType> StaffTypes = staffTypeRepository.findAll();
            StaffType staffType = choiceStaffType(StaffTypes);
            staff.setCode(code);
            staff.setName(name);
            staff.setPhoneNumber(phoneNumber);
            staff.setGmail(gmail);
            staff.setIdCard(idCard);
            staff.setSalary(salary);
            staff.setAddress(address);
            staff.setStaffType(staffType);
            staffController.resetStaff(staff);
        }


    }

    private static void showStaff(List<Person> people) {
        for (Person a : people) {
            System.out.println(a);
        }
    }

    private static void addStaff() {
        System.out.println(" Mời bạn nhập: ");
        System.out.println("Please enter your id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter your code");
        String code = scanner.nextLine();
        System.out.println("Please enter your name");
        String name = scanner.nextLine();
        System.out.println("Please enter your phoneNumber");
        int phoneNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter your gmail");
        String gmail = scanner.nextLine();
        System.out.println(" nhập idCard ");
        String idCard = scanner.nextLine();
        System.out.println(" nhập salary");
        double salary = Double.parseDouble(scanner.nextLine());
        System.out.println("nhập address");
        String address = scanner.nextLine();
        System.out.println("nhập StaffType");
        List<StaffType> StaffTypes = staffTypeRepository.findAll();
        StaffType staffType = choiceStaffType(StaffTypes);
        Person staffTypes = new Staff(id, code, name, phoneNumber, gmail, idCard, salary, address, staffType);
        StaffController.addSta(staffTypes);


    }

    private static void customerManagement() {
        int choice;
        while (true) {
            System.out.println("1.thêm khách hàng" + "\n" + "2.hiển thị khách hàng" + "\n" + "3.sửa khách hàng" + "\n" +
                    "4.xóa khách hàng" + "\n" +
                    "5.thoát.");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    List<Person> customers = controller.displayCustomer();
                    DeCus(customers);
                    break;
                case 3:
                    editCustomer();
                    break;
                case 4:
                    deleteCustumer();
                    break;
                case 5:
                    return;
            }
        }
    }

    private static void DeCus(List<Person> customers) {
        for (Person a : customers) {
            System.out.println(a);
        }
    }


    private static void editCustomer() {
        System.out.println("Mời nhập id muốn edit: ");
        int id = Integer.parseInt(scanner.nextLine());
        Customer customer = controller.findId(id);
        if (customer != null) {
            System.out.println("Please enter your code");
            String code = scanner.nextLine();
            System.out.println("Please enter your name");
            String name = scanner.nextLine();
            System.out.println("Please enter your phoneNumber");
            int phoneNumber = Integer.parseInt(scanner.nextLine());
            System.out.println("Please enter your gmail");
            String gmail = scanner.nextLine();
            System.out.println("Please enter your customerType");
            List<CustomerType> customerTypes = customerTypeRepository.findAll();
            CustomerType customerType = choiceCustomerType(customerTypes);
            customer.setCode(code);
            customer.setName(name);
            customer.setPhoneNumber(phoneNumber);
            customer.setGmail(gmail);
            customer.setCustomerType(customerType);
            controller.updateCustomer(customer);

        }
    }


    private static void addCustomer() {
        System.out.println("mời bạn nhập:");
        System.out.println("Please enter your id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter your code");
        String code = scanner.nextLine();
        System.out.println("Please enter your name");
        String name = scanner.nextLine();
        System.out.println("Please enter your phoneNumber");
        int phoneNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter your gmail");
        String gmail = scanner.nextLine();
        System.out.println("Please enter your customerType");
        List<CustomerType> customerTypes = customerTypeRepository.findAll();
        CustomerType customerType = choiceCustomerType(customerTypes);
        Person customer = new Customer(id, code, name, phoneNumber, gmail, customerType);
        controller.addCus(customer);
    }

    private static CustomerType choiceCustomerType(List<CustomerType> customerTypes) {
        while (true) {
            for (CustomerType ct : customerTypes) {
                System.out.println(ct.getId() + ". " + ct.getName());
            }
            int choiceCustomerType = ExceptionHandler.checkForParseInt("lựa chọn của bạn");
            for (CustomerType ct : customerTypes) {
                if (choiceCustomerType == ct.getId()) {
                    return ct;
                }
            }
        }
    }

    private static StaffType choiceStaffType(List<StaffType> StaffTypes) {
        while (true) {
            for (StaffType ct : StaffTypes) {
                System.out.println(ct.getId() + ". " + ct.getName());
            }
            int choiceStaffType = ExceptionHandler.checkForParseInt("lựa chọn của bạn");
            for (StaffType ct : StaffTypes) {
                if (choiceStaffType == ct.getId()) {
                    return ct;
                }
            }
        }
    }

    private static ProductType choiceProductType(List<ProductType> productTypes) {
        while (true) {
            for (ProductType ct : productTypes) {
                System.out.println(ct.getId() + ". " + ct.getName());
            }
            int choiceProductType = ExceptionHandler.checkForParseInt("lựa chọn của bạn");
            for (ProductType ct : productTypes) {
                if (choiceProductType == ct.getId()) {
                    return ct;
                }
            }
        }
    }


    private static void deleteCustumer() {
        System.out.println("Nhập id muốn xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("bạn chắc chắn muốn xóa không " + "\n" +
                "1.yes" + "\n" +
                "2.no");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                controller.removeCustomer(id);
                System.out.println("xóa thành công");
                break;
            case 2:
                break;
        }


    }
}
