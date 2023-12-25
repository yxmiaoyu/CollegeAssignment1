package base;

//供应商信息
public class Supply {

    //供应商名称
    public String supplier;
    //供应商联系地址
    public String address;
    //供应商联系电话
    public String telephone;

    public Supply(String supplier, String address, String telephone) {
        this.supplier = supplier;
        this.address = address;
        this.telephone = telephone;
    }

    public String toString() {
        return "\n供应商信息：\n供应商名称：" + this.supplier
                + "，联系地址：" + this.address
                + "，联系电话：" + this.telephone;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
