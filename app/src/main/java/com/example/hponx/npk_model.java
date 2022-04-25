package com.example.hponx;

public class npk_model {

    String Abrev,Image,Name,Value;

    npk_model()
    {

    }
    public npk_model(String abrev, String image, String name, String value) {
        this.Abrev = abrev;
        this.Image = image;
        this.Name = name;
        this.Value = value;
    }

    public String getAbrev() {
        return Abrev;
    }

    public void setAbrev(String abrev) {
        this.Abrev = abrev;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        this.Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        this.Value = value;
    }
}
