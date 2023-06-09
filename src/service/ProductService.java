package service;

import config.Config;
import model.Product;

public class ProductService {
    private Product[] listProduct= new Product[100]; // tất cả các phần tử đều null

    private int size = 0;

    public Product[] getListProduct() {
        return listProduct;
    }
    public boolean create(Product product){
        if (size>100) {
            System.err.println("danh sách đã đầy, không thể thêm mới sản phẩm");
            return false;
        }

        for (int i = 0; i < listProduct.length; i++) {
            if(listProduct[i]==null){
                listProduct[i] = product;
                size++;
                break;
            }
        }
        return true;
    }
    public  Product findById(int id){
        for (Product p:listProduct) {
            if (p == null) continue;
            if(p.getId()== id){
                return p;
            }
        }
        return null;
    }
    public void update(Product product){
        for (int i = 0; i < listProduct.length; i++) {
            if (listProduct[i] == null) continue;
            if(listProduct[i].getId()== product.getId()){
                listProduct[i] = product;
                break;
            }
        }
    }
    public void delete(int id){
        Product product = findById(id);
        if (product != null){
        System.out.println("sản phẩm bạn chọn là: " + product);
        System.out.println("bạn có chắc muốn xóa sp đó?");
        System.out.println("1. có");
        System.out.println("2. không");
        int choice = Config.scanner().nextInt();
        if (choice == 1){
        for (int i = 0; i < listProduct.length; i++) {
            if (listProduct[i] == null) continue;
            if(listProduct[i].getId()== id){
                listProduct[i] = null;
                size--;
                return;
            }
        }}}else System.out.println("không tìm thấy sản phẩm đó");
    }
    public int getSize(){
        return this.size;
    }
}
