import almacen.Producto;
import almacen.Insertadora;
import almacen.PrecioProducto;

public class App {

    public static void main(String[] args) {

        Producto manzana = new Producto("manzana");

        Insertadora insertadora = new Insertadora(manzana, 10);
        Insertadora insertadora2 = new Insertadora(manzana, 5);
        Insertadora insertadora3 = new Insertadora(manzana, 6);

        insertadora.start();
        insertadora2.start();
        insertadora3.start();

        try {

            insertadora.join();
            insertadora2.join();
            insertadora3.join();
            
        } catch (InterruptedException e) {
           System.out.println(e.getMessage());

        }

        manzana.showPreciosYproveedores();

        System.out.println();

        manzana.showMejorPrecio();

    }

}
