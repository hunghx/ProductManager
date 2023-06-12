import config.Config;
import config.Validate;
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

                    updateProduct();
                    // cập nhật thông tin sản phẩm
                    break;
                case 4:
                    // xóa sản phẩm
                    deleteProduct();
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
        while (true){
            String name = Config.scanner().nextLine();
            if (Validate.checkProductName(name)){
                if (!productController.checkNameExist(name)){
                    newProduct.setName(name);
                    break;
                }else {
                    System.err.println("Tên sản phẩm đã tồn tại , vui lòng nhập lại");
                    continue;
                }
            }

            System.err.println("Không hợp lệ!");
            System.out.println("Vui long nhập lại");
        }

//        newProduct.setName(Config.scanner().nextLine());
        System.out.println("Nhập vào gia");
        while (true){
            double price = Config.scanner().nextDouble();
            if (Validate.checkProductPrice(price)){
                newProduct.setPrice(price);
                break;
            }
            System.err.println("Không hợp lệ!");
            System.out.println("Vui long nhập lại");
        }
//        newProduct.setPrice(Config.scanner().nextDouble());
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
    //  update
    public  static void updateProduct(){
        System.out.println("Nhap vao id cua san pham can sua");
        int id = Config.scanner().nextInt();
        // kiem tra ton tai cua product
        Product product = productController.findById(id);
        if (product!=null){
            System.out.println("ID - "+product.getId());
            System.out.println("Nhap vao ten moi ( ten cu : "+product.getName()+" )");
            product.setName(Config.scanner().nextLine());
            System.out.println("Nhap vao gia moi ( gia cu : "+product.getPrice()+" )");
            product.setPrice(Config.scanner().nextDouble());
            System.out.println("Nhap vao mo ta moi ( mo ta cu : "+product.getDescription()+" )");
            product.setDescription(Config.scanner().nextLine());
            productController.update(product);
            System.out.println("Cap nhat thanh cong");
        }else {
            System.err.println("khong tim thay san pham can sua");
        }
    }
    public  static  void deleteProduct(){
        System.out.println("Nhap vao id cua san pham can xoa");
        int id = Config.scanner().nextInt();
        // kiem tra ton tai cua product
        Product product = productController.findById(id);
        if (product!=null){
            productController.delete(id);
            System.out.println("Xoa thanh cong");
        }else{
            System.err.println("khong tim thay san pham can xoa");
        }
    }

}