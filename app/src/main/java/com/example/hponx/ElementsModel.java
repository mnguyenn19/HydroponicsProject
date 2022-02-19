package com.example.hponx;

public class ElementsModel {
    String elementName;
    String elementAbbreviation;
    String elementDescription;
    int image;

    public ElementsModel(String elementName, String elementAbbreviation, int image, String elementDescription) {
        this.elementName = elementName;
        this.elementAbbreviation = elementAbbreviation;
        this.image = image;
        this.elementDescription = elementDescription;
    }

    public String getElementName() {
        return elementName;
    }

    public String getElementAbbreviation() {
        return elementAbbreviation;
    }

    public int getImage() {
        return image;
    }

    public String getDescription() {
        return elementDescription;
    }
}
