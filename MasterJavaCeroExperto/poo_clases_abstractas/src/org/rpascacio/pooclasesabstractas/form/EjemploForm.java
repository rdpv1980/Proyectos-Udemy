package org.rpascacio.pooclasesabstractas.form;

import org.rpascacio.pooclasesabstractas.form.elementos.ElementoForm;
import org.rpascacio.pooclasesabstractas.form.elementos.InputForm;
import org.rpascacio.pooclasesabstractas.form.elementos.SelectForm;
import org.rpascacio.pooclasesabstractas.form.elementos.TextAreaForm;
import org.rpascacio.pooclasesabstractas.form.elementos.select.Opcion;
import org.rpascacio.pooclasesabstractas.form.validador.EmailValidador;
import org.rpascacio.pooclasesabstractas.form.validador.LargoValidador;
import org.rpascacio.pooclasesabstractas.form.validador.NoNuloValidador;
import org.rpascacio.pooclasesabstractas.form.validador.RequeridoValidador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploForm {
    public static void main(String[] args) {

        InputForm username= new InputForm("username");
        username.addValidador(new RequeridoValidador());

        InputForm password=new InputForm("clave","password");
        password.addValidador(new RequeridoValidador());
        password.addValidador(new LargoValidador(6,2));

        InputForm email=new InputForm("email","enail");
        email.addValidador(new RequeridoValidador())
                .addValidador(new EmailValidador());

        InputForm edad=new InputForm("edad","number");
        edad.addValidador(new RequeridoValidador());

        TextAreaForm experiencia=new TextAreaForm("exp",5,9);

        SelectForm lenguaje=new SelectForm("lenguaje");
        lenguaje.addValidador(new NoNuloValidador());

        Opcion java=new Opcion("1","Java");
        lenguaje.addOpcion(java)
 /*       lenguaje.addOpcion(new Opcion("2","Python"));
        lenguaje.addOpcion(new Opcion("3","Javascript"));
        lenguaje.addOpcion(new Opcion("4","TypeScript"));
        lenguaje.addOpcion(new Opcion("5","PHP"));*/
        .addOpcion(new Opcion("2","Python"))
        .addOpcion(new Opcion("3","Javascript"))
        .addOpcion(new Opcion("4","TypeScript").setSelected(true))
        .addOpcion(new Opcion("5","PHP"));

        ElementoForm saludar=new ElementoForm("saludo"){
            @Override
            public String dibujarHtml() {
                return "<input disabled name='"+this.nombre +"' value=\"" + this.valor + "\">";
            }
        };

        saludar.setValor("Hola que tal este campo está deshabilitado");
        username.setValor("rommer");
        password.setValor("a1b2c3");
        email.setValor("john.doecorreo.com");
        edad.setValor("28l");
        experiencia.setValor("... más de 10 años de experiencia ...");
        java.setSelected(true);

       /* List<ElementoForm> elementos=new ArrayList<>();
        elementos.add(username);
        elementos.add(password);
        elementos.add(email);
        elementos.add(edad);
        elementos.add(experiencia);
        elementos.add(lenguaje);*/

        //Con Arrays

        List<ElementoForm> elementos= Arrays.asList(username,password,email,edad,experiencia,lenguaje,saludar);

/*        for (ElementoForm e:elementos){
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        }*/

        elementos.forEach(e -> {
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        });

        elementos.forEach(e ->{
            if(!e.isValid()){
                e.getErrores().forEach(System.out::println);
                //e.getErrores().forEach(err -> System.out.println(e.getNombre()+ " : " + err));
            }
        });


    }
}
