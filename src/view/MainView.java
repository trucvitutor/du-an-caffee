package view;

import common.ExceptionHandler;
import common.RegexHandler;
import controller.CustomerController;
import controller.OrderController;
import controller.ProductController;
import controller.StaffController;
import model.*;
import repository.CustomerTypeRepository;
import repository.ProductTypeRepository;
import repository.StaffTypeRepository;

import java.util.ArrayList;
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
            System.out.println("1.thêm nước uống." + "\n" + "2.hiển thị nước uống" + "\n" + "3.sửa nước uống" + "\n" + "4.xóa nước uống" + "\n" + "5. thoat");
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
                    editOrder();
                    break;
                case 4:
                    deletOrder();
                    break;
                case 5:
                    return;
            }
        }
    }

    private static void deletOrder() {
        System.out.println("Nhập id muốn xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("bạn chắc chắn muốn xóa không " + "\n" +
                "1.yes" + "\n" +
                "2.no");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                orderController.removeOrder(id);
                System.out.println("xóa thành công");
                break;
            case 2:
                break;
        }
    }

    private static void editOrder() {
        System.out.println("nhập id bạn muốn sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        Order order = orderController.findAllOrder(id);
        while (order != null) {
            System.out.println("Nhap code:");
            String code = scanner.nextLine();
            System.out.println("Chon khach hang: ");
            List<Person> customers = CustomerController.displayCustomer();
            Customer customer = choiceCustomer(customers);
            System.out.println("Chon nhan vien: ");
            List<Person> staffs = staffController.findAllStaff();
            Staff staff = choiceStaff(staffs);
            System.out.println("Chon san pham: ");
            List<Product> products = productController.findAllProduct();
            List<Product> productList = choiceProducts(products);
            order.setCode(code);
            order.setCustomer(customer);
            order.setProducts(productList);
            order.setStaff(staff);
            orderController.resetOrder(order);

        }
    }

    //int id, String code, Customer customer, Staff staff, List<Product> products
    private static void addOrder() {
        int id = ExceptionHandler.checkForParseInt("id");
        System.out.println("Nhap code:");
        String code = scanner.nextLine();
        System.out.println("Chon khach hang: ");
        List<Person> customers = CustomerController.displayCustomer();
        Customer customer = choiceCustomer(customers);
        System.out.println("Chon nhan vien: ");
        List<Person> staffs = staffController.findAllStaff();
        Staff staff = choiceStaff(staffs);
        System.out.println("Chon san pham: ");
        List<Product> products = productController.findAllProduct();
        List<Product> productList = choiceProducts(products);
        Order order = new Order(id, code, customer, staff, productList);
        orderController.saveOrder(order);
    }

    private static List<Product> choiceProducts(List<Product> products) {
        List<Product> productList = new ArrayList<>();
        while (true) {
            for (Product product : products) {
                System.out.println(product.getId() + ". " + product.getName());
            }
            int choiceStaff = ExceptionHandler.checkForParseInt("lựa chọn của bạn");
            if (choiceStaff == 0) {
                break;
            }
            for (Product product : products) {
                if (choiceStaff == product.getId()) {
                    productList.add(product);
                }
            }
        }
        return productList;
    }

    private static Staff choiceStaff(List<Person> people) {
        while (true) {
            for (Person c : people) {
                if (c instanceof Staff) {
                    System.out.println(c.getId() + ". " + c.getName());
                }
            }
            int choiceStaff = ExceptionHandler.checkForParseInt("lựa chọn của bạn");
            if (choiceStaff == 0) {
                return null;
            }
            for (Person person : people) {
                if (choiceStaff == person.getId()) {
                    if (person instanceof Staff) {
                        return (Staff) person;
                    }
                }
            }
        }
    }

    private static Customer choiceCustomer(List<Person> people) {
        while (true) {
            for (Person c : people) {
                if (c instanceof Customer) {
                    System.out.println(c.getId() + ". " + c.getName());
                }
            }
            System.out.println("0. Khách vãng lai");
            int choiceCustomer = ExceptionHandler.checkForParseInt("lựa chọn của bạn");
            if (choiceCustomer == 0) {
                return null;
            }
            for (Person person : people) {
                if (choiceCustomer == person.getId()) {
                    if (person instanceof Customer) {
                        return (Customer) person;
                    }
                }
            }
        }
    }

    private static void display(List<Order> orderList) {
        for (Order o : orderList) {
            System.out.println(o);
        }
    }


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
            String name = RegexHandler.checkRegexName();
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
        String name = RegexHandler.checkRegexName();
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
                    "4.xóa nhân viên" + "\n" + "5. thoat");
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
                case 5:
                    return;
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
            String name = RegexHandler.checkRegexName();
            System.out.println("Please enter your phoneNumber");
            int phoneNumber =  Integer.parseInt(RegexHandler.checkRegexName());
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
        String name = RegexHandler.checkRegexName();
        System.out.println("Please enter your phoneNumber");
        int phoneNumber = Integer.parseInt(RegexHandler.checkRegexName());
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
                    showCustomer();
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

    private static void showCustomer() {
        List<Person> customers = controller.displayCustomer();
        if (customers.isEmpty()) {
            System.out.println("Không có dữ liệu trong bảng!");
        } else {
            StringBuilder str = new StringBuilder("" +
                    "+----+----------------+-----------------+------------------------+-----------------+\n" +
                    "| ID | Tên khách hàng |  Số điện thoại  |         Email          | Loại khách hàng |\n" +
                    "+----+----------------+-----------------+------------------------+-----------------+\n");
            for (Person person : customers) {
                if (person instanceof Customer)
                    str.append(person);
            }
            System.out.println(str);
        }

//    private static void DeCus(List<Person> customers) {
//
//        for (Person a : customers) {
//            System.out.println(a);
//        }
//    }
    }

    private static void editCustomer() {
        System.out.println("Mời nhập id muốn edit: ");
        int id = Integer.parseInt(scanner.nextLine());
        Customer customer = controller.findId(id);
        if (customer != null) {
            System.out.println("Please enter your code");
            String code = scanner.nextLine();
            System.out.println("Please enter your name");
            String name = RegexHandler.checkRegexName();
            System.out.println("Please enter your phoneNumber");
            int phoneNumber = Integer.parseInt(RegexHandler.checkRegexName());
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
        String name = RegexHandler.checkRegexName();
        System.out.println("Please enter your phoneNumber");
        int phoneNumber = Integer.parseInt(RegexHandler.checkPhoneNumber());
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
