package org.rpascacio.appfacturas;


import org.rpascacio.appfacturas.modelo.*;
import java.util.Scanner;

public class EjemploFactura {
    public static void main(String[] args) {
        Cliente cliente=new Cliente();
        cliente.setNif("5555-5");
        cliente.setNombre("Rommer");

        Scanner sc =new Scanner(System.in);
        System.out.print("Ingrese la descripción de la factura :");
        String desc= sc.nextLine();
        Factura factura=new Factura(desc,cliente);

        Producto producto;
       /* String nombre;
        float precio;
        int cantidad;*/

        System.out.println();

        for (int i = 0; i < 5; i++) {
            producto=new Producto();
            System.out.print("Ingrese producto n° " +  producto.getCodigo() +  ": ");
            //nombre= sc.next();//solo para una sola palabra, si son mas de 2 palabras, sale error
            //nombre= sc.nextLine();
            producto.setNombre(sc.nextLine());

            System.out.print("Ingrese el precio : ");
            //precio=sc.nextFloat();
            producto.setPrecio(sc.nextFloat());

            System.out.print("Ingrese la cantidad : ");
            //cantidad=sc.nextInt();

            //ItemFactura item=new ItemFactura(sc.nextInt(),producto);
            factura.addItemsFacturas(new ItemFactura(sc.nextInt(),producto));

            System.out.println();
            sc.nextLine();
        }
        //System.out.println(factura.generarDetalle());
        System.out.println(factura);

    }
}
