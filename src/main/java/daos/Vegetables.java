package daos;

import java.util.List;

public class Vegetables implements DTOInterface {
    private Integer vegetableId;
    private String vegetableName;
    private String vegetableColor;
    private String vegetableTexture;
    private String vegetableWeight;

    public Vegetables(){}
    public Vegetables(String vegetableName){};
    public Vegetables(Integer vegetableId, String vegetableName, String vegetableColor, String vegetableTexture, String vegetableWeight){}

    public Integer getVegetableId() {
        return vegetableId;
    }

    public void setVegetableId(Integer vegetableId) {
        this.vegetableId = vegetableId;
    }

    public String getVegetableName() {
        return vegetableName;
    }

    public void setVegetableName(String vegetableName) {
        this.vegetableName = vegetableName;
    }

    public String getVegetableColor() {
        return vegetableColor;
    }

    public void setVegetableColor(String vegetableColor) {
        this.vegetableColor = vegetableColor;
    }

    public String getVegetableTexture() {
        return vegetableTexture;
    }

    public void setVegetableTexture(String vegetableTexture) {
        this.vegetableTexture = vegetableTexture;
    }

    public String getVegetableWeight() {
        return vegetableWeight;
    }

    public void setVegetableWeight(String vegetableWeight) {
        this.vegetableWeight = vegetableWeight;
    }



    @Override
    public Integer getID() {
        return vegetableId;
    }
}
