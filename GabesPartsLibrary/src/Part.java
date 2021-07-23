public class Part {
    private int diagLoc; // Location on Pictorial Diagram
    private String name;
    private String partNum;
    private String desc;
    private float price;
    private int quantity;
    private String picPath; // Path to part picture

    public Part() {
    }

    public Part(int diagLoc, String name, String partNum, String desc, float price, int quantity, String picPath) {
        this.diagLoc = diagLoc;
        this.name = name;
        this.partNum = partNum;
        this.desc = desc;
        this.price = price;
        this.quantity = quantity;
        this.picPath = picPath;
    }


    public int getDiagLoc() {
        return diagLoc;
    }

    public void setDiagLoc(int diagLoc) {
        this.diagLoc = diagLoc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPartNum() {
        return partNum;
    }

    public void setPartNum(String partNum) {
        this.partNum = partNum;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    @Override
    public String toString() {
        return
                diagLoc + " | " + name;
    }
}
