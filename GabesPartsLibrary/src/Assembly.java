import java.util.ArrayList;

public class Assembly {
    private String name;
    private String imageFilePath;
    public ArrayList<Part> parts = new ArrayList<Part>(); // There is a list of parts associated with each assembly
    private String assyPath;
    private String partsPath;

    public Assembly() {
    }

    public Assembly(String name, ArrayList<Part> parts) {
        this.name = name;
        this.parts = parts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public ArrayList<Part> getParts() {
//        return parts;
//    }
//
//    public void setParts(ArrayList<Part> parts) {
//        this.parts = parts;
//    }

    public String getImageFilePath() {
        return imageFilePath;
    }

    public void setImageFilePath(String imageFilePath) {
        this.imageFilePath = imageFilePath;
    }

    public String getAssyPath() {
        return assyPath;
    }

    public void setAssyPath(String assyPath) {
        this.assyPath = assyPath;
    }

    public String getPartsPath() {
        return partsPath;
    }

    public void setPartsPath(String partsPath) {
        this.partsPath = partsPath;
    }

    @Override
    public String toString() {
        return name;
    }

    // Mainly used for debugging purposes
    public String toFullString() {
        return name + " " + imageFilePath + " " + assyPath;

    }
}
