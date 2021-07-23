import java.util.ArrayList;

public class Engine {
    private String brandName;
    private String modelNum;
    public ArrayList<Assembly> assys = new ArrayList<Assembly>();
    private String enginePath;

    public Engine() {
    }

    public Engine(String brandName, String modelNum, ArrayList<Assembly> assys, String enginePath) {
        this.brandName = brandName;
        this.modelNum = modelNum;
        this.assys = assys;
        this.enginePath = enginePath;
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

    // The engine assemblys have been made public so that
    // it is easier to access the associated methods
    // outside the class, rather than trying to
    // create an interface by creating public
    // methods that just mirror the arraylist
    // methods. There may be an easier ("proper") way to do this.


//    public ArrayList<Assembly> getAssys() {
//        return assys;
//    }
//
//    public void setAssys(ArrayList<Assembly> assys) {
//        this.assys = assys;
//    }


    public String getEnginePath() {
        return enginePath;
    }

    public void setEnginePath(String enginePath) {
        this.enginePath = enginePath;
    }

    @Override
    public String toString() {
        return
                 brandName + " " + modelNum;
    }
}
