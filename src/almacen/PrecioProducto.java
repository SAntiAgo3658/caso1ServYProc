package almacen;

public class PrecioProducto {

    // Atributos
    private String proveedor;
    private float precio;

    // Constructor
    public PrecioProducto(String proveedor, float precio) {
        this.proveedor = proveedor;
        this.precio = precio;

    }

    // Getters y Setters
    public String getProveedor() {
        return proveedor;

    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;

    }

    public float getPrecio() {
        return precio;

    }

    public void setPrecio(float precio) {
        this.precio = precio;

    }

}
