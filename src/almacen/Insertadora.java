package almacen;

public class Insertadora extends Thread {

    private static int cont = 0;
    private Producto producto;
    private int numPreciosYproveedores;

    public Insertadora(Producto producto, int numPreciosYproveedores) {
        this.producto = producto;
        this.numPreciosYproveedores = numPreciosYproveedores;

    }

    public void run() {
        cont++;
        this.setName("Hilo" + cont);
        PrecioProducto precioProducto;

        for (int i = 0; i < numPreciosYproveedores; i++) {
            precioProducto = new PrecioProducto("proveedor" + i, i * 10 + 1);
            producto.addProd(precioProducto.getProveedor(), precioProducto.getPrecio());

        }

    }

    public static int getCont() {
        return cont;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getNumPreciosYproveedores() {
        return numPreciosYproveedores;
    }

    public void setNumPreciosYproveedores(int numPreciosYproveedores) {
        this.numPreciosYproveedores = numPreciosYproveedores;
    }

}
