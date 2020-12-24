package Electronicequipment;


public class electronic {

    private String id; //编号
    private String name; //名称
    private String price; //价格
    private String number; //数量
    private String proplace; //生产地

    public electronic() {
        super();
    }

    public electronic(String id, String name, String price, String number, String proplace) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.number = number;
        this.proplace = proplace;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getProplace() {
        return this.proplace;
    }

    public void setProplace(String proplace) {
        this.proplace = proplace;
    }

}
