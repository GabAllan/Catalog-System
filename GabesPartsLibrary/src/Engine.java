import java.util.ArrayList;

public class Engine {
    private String brandName;
    private String modelNum;
    private ArrayList<Assembly> assys = new ArrayList<Assembly>();

    public Engine() {
    }

    public Engine(String brandName, String modelNum, ArrayList<Assembly> assys) {
        this.brandName = brandName;
        this.modelNum = modelNum;
        this.assys = assys;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelNum() {
        return modelNum;
    }

    public void setModelNum(String modelNum) {
        this.modelNum = modelNum;
    }

    public ArrayList<Assembly> getAssys() {
        return assys;
    }

    public void setAssys(ArrayList<Assembly> assys) {
        this.assys = assys;
    }
}
