import java.util.ArrayList;

public class Assembly {
    private String name;
    private String imageFilePath;
    private ArrayList<Part> parts = new ArrayList<Part>(); // There is a list of parts associated with each assembly

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

    public ArrayList<Part> getParts() {
        return parts;
    }

    public void setParts(ArrayList<Part> parts) {
        this.parts = parts;
    }

    public String getImageFilePath() {
        return imageFilePath;
    }

    public void setImageFilePath(String imageFilePath) {
        this.imageFilePath = imageFilePath;
    }
}
