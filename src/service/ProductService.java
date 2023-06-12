package service;

import model.Product;

public class ProductService {
    private Product[] listProduct= new Product[100]; // tất cả các phần tử đều null
    private int size = 0;
    public void init(){
       Product p1= new Product(1,"Product01",100,"Quần hoa");
        Product p2= new Product(2,"Product02",120,"Áo phông");
        Product p3= new Product(3,"Product03",150,"PNJ");
        listProduct[0]=p1;
        listProduct[1]=p2;
        listProduct[2]=p3;
        size=3;
    }
    public ProductService() {
        init();
    }

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
            if(p==null){
                continue;
            }
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
    public boolean checkNameExist(String name){
        for (Product p: listProduct) {
            if(p!=null&& p.getName().equals(name)){
                return  true;
            }
        }
        return  false;
    }
    public int getSize(){
        return this.size;
    }
}
