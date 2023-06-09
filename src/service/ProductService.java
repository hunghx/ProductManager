package service;

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
            if(p.getId()== id){
                return p;
            }
        }
        return null;
    }
    public void update(Product product){
        for (int i = 0; i < listProduct.length; i++) {
            if(listProduct[i].getId()== product.getId()){
                listProduct[i] = product;
                break;
            }
        }
    }
    public void delete(int id){
        for (int i = 0; i < listProduct.length; i++) {
            if(listProduct[i].getId()== id){
                listProduct[i] = null;
                size--;
                break;
            }
        }
    }
    public int getSize(){
        return this.size;
    }
}
