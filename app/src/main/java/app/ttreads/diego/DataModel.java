package app.ttreads.diego;

public class DataModel {
    String raza;
    String tipo;
    int id_;
    int image;
    public DataModel(String raza, String tipo, int id_, int image) {
        this.raza = raza;
        this.tipo = tipo;
        this.id_ = id_;
        this.image=image;
    }
    public String getRaza() {
        return raza;
    }
    public String getTipo() {
        return tipo;
    }
    public int getImage() {
        return image;
    }
    public int getId() {
        return id_;
    }
}
