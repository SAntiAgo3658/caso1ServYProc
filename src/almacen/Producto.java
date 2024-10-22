package almacen;

import java.util.concurrent.locks.ReentrantLock;

public class Producto {

    // Atributos
    private PrecioProducto[] preciosYproveedores;
    private String nombreProducto;
    private int numProveedores;
    private ReentrantLock cerrojo;

    // Constructor
    public Producto(String nombreProducto) {
        this.preciosYproveedores = new PrecioProducto[20];
        this.nombreProducto = nombreProducto;
        this.numProveedores = 0;
        this.cerrojo = new ReentrantLock();

    }

    // Getters y Setters
    public String getNombreProducto() {
        return nombreProducto;

    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;

    }

    public PrecioProducto[] getPreciosYproveedores() {

        entrarSeccionCritica();
        try {
            return preciosYproveedores;
        
        } finally {
            salirSeccionCritica();

        }

    }

    // Métodos
    public void addProd(String proveedor, float precio) {

        entrarSeccionCritica();

        try {

            if (numProveedores == preciosYproveedores.length) {
                System.out.println("No se permiten más proveedores");

            } else {
                preciosYproveedores[numProveedores] = new PrecioProducto(proveedor, precio);
                numProveedores++;

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            salirSeccionCritica();

        }

    }

    public void showPreciosYproveedores() {

        entrarSeccionCritica();

        try {

            if (numProveedores == 0) {

                System.out.println("No hay proveedores en este momento");

            } else {

                System.out.println(this.getNombreProducto() + ":");
                System.out.println();

                for (int i = 0; i < numProveedores; i++) {
                    System.out
                            .println(preciosYproveedores[i].getProveedor() + ", " + preciosYproveedores[i].getPrecio());
                }

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            salirSeccionCritica();
        }

    }

    public void showMejorPrecio() {

        entrarSeccionCritica();

        try {

            if (numProveedores == 0) {

                System.out.println("No hay proveedores en este momento");

            } else {

                PrecioProducto mejorProducto = new PrecioProducto(null, Float.POSITIVE_INFINITY);

                for (int i = 0; i < numProveedores; i++) {

                    if (preciosYproveedores[i].getPrecio() < mejorProducto.getPrecio()) {
                        mejorProducto = preciosYproveedores[i];

                    }

                }

                System.out.println(
                        "El mejor precio es: " + mejorProducto.getPrecio() + "$ de: " + mejorProducto.getProveedor());

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            salirSeccionCritica();

        }

    }

    public void entrarSeccionCritica() {
        cerrojo.lock();

    }

    public void salirSeccionCritica() {
        cerrojo.unlock();

    }

}
