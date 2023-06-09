import config.Config;
import controller.ProductController;
import model.Product;

public class Main {
    static ProductController productController = new ProductController();
    public static void main(String[] args) {

        int choice ;
        while (true){
            System.out.println("=================MENU=================");
            System.out.println("1. Hiển thị toàn bộ sản phẩm");
            System.out.println("2. Thêm mới sản phẩm");
            System.out.println("3. Cập nhập thông tin sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Thoát");
            System.out.println("Hãy nhập vào lựa chọn của bạn");
            choice = Config.scanner().nextInt();
            switch (choice){
                case 1:
                    // hiển thị danh sách
                    displayListProduct();
                    break;
                case 2:
                    createNewProduct();
                    // thêm mới sản phẩm
                    break;
                case 3:
                    // cập nhật thông tin sản phẩm
                    break;
                case 4:
                    // xóa sản phẩm
                    break;
                case 5:
                    //
                    System.out.println("Thoát chương trình");
                    System.exit(0);
                default:
                    System.err.println("hãy nhập 1 số từ 1 đến 5");
            }
        }
    }
    public static void displayListProduct(){
        // Lấy ra dánh sách sanr phẩm
        if (productController.getSize()==0){
            System.err.println("Danh sách sản phẩm trống");
            return;
        }
        Product[] list = productController.getAll();
        System.out.println("Danh sách Sản phẩm");
        for (Product p :list) {
            if(p!=null){
                System.out.println(p);
            }
        }
    }
    public static void createNewProduct(){
        Product newProduct = new Product();
        int id = getNewId();
        newProduct.setId(id);
        System.out.println("Id = "+id);
        System.out.println("Nhập vào tên");
        newProduct.setName(Config.scanner().nextLine());
        System.out.println("Nhập vào gia");
        newProduct.setPrice(Config.scanner().nextDouble());
        System.out.println("Nhập vào mo ta");
        newProduct.setDescription(Config.scanner().nextLine());
        boolean check = productController.createProduct(newProduct);
        if (check){
            System.out.println("Thêm mới thành công");
        }
    }
    public static int getNewId(){
        Product[] list = productController.getAll();
        int idMax = 0;
        for (Product p: list) {
            if(p==null){
                continue;
            }
            if(idMax < p.getId()){
                idMax = p.getId();
            }
        }
        return idMax+1;
    }

}