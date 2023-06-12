package service;

import config.Config;
import model.Product;

/**
 * service có chức năng chính là xử lý logic.
 */

public class ProductService {
    private Product[] listProduct = new Product[100]; // tất cả các phần tử đều null

    private int size = 0;

    public void init() {
        Product p1 = new Product(1, "Product01", 100, "Quần hoa");
        Product p2 = new Product(2, "Product02", 120, "Áo phông");
        Product p3 = new Product(3, "Product03", 150, "PNJ");
        listProduct[0] = p1;
        listProduct[1] = p2;
        listProduct[2] = p3;
        size = 3;
    }

    public ProductService() {
        init();
    }

    public Product[] getListProduct() {  // hàm trả về danh sách các product
        return listProduct;
    }

    public boolean create(Product product) {         // hàm tạo một sản phẩm mới
        if (size > 100) {     // mảng danh sách product có số lượng giới hạn cố định
            //Nếu danh sách đã vượt quá số lượng giới hạn sẽ thông báo đầy và không cho tạo thêm sản phẩm rồi trả về true
            System.err.println("danh sách đã đầy, không thể thêm mới sản phẩm");
            return false;
        }

        for (int i = 0; i < listProduct.length; i++) {  // duyệt qua mảng sản phẩm, đến sản phẩm nào null thì gán sản phẩm đó bằng sản phẩm mới tạo
            if (listProduct[i] == null) {
                listProduct[i] = product;
                size++;
                return true; //nêu tạo thành công trả về true
            }
        }
        return true;
    }

    public Product findById(int id) {  //hàm tìm kiếm sản phẩm theo id
        for (Product p : listProduct) {
            if (p == null) {
                continue;
            }
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void update(Product product) {  // hàm cập nhật sản phẩm có tham số đầu vào là một sản phẩm
        for (int i = 0; i < listProduct.length; i++) {  //duyệt qua toàn bộ danh sách sản phẩm
            if (listProduct[i] == null) continue;   // Nếu gặp sản phẩm bị null thì bỏ qua bước lặp này
            if (listProduct[i].getId() == product.getId()) {
                listProduct[i] = product;  //Nếu đến một sản phẩm có ai đi bằng với ID của sản phẩm truyền vào thì sẽ gắn lại sản phẩm đó
                break;
            }
        }
    }

    public void delete(int id) {  // hàm xóa sản phẩm

        for (int i = 0; i < listProduct.length; i++) {  //xóa sản phẩm
            if (listProduct[i] == null) continue;
            if (listProduct[i].getId() == id) {
                listProduct[i] = null;
                size--;
                return;
            }
        }
    }
        public boolean checkNameExist (String name){
            for (Product p : listProduct) {
                if (p != null && p.getName().equals(name)) {
                    return true;
                }
            }
            return false;
        }

        public int getSize () { // lấy ra độ dài của mảng
            return this.size;
        }
    }
