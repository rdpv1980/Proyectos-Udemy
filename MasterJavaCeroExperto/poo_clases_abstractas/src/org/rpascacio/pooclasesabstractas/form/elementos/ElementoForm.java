package org.rpascacio.pooclasesabstractas.form.elementos;

import org.rpascacio.pooclasesabstractas.form.validador.LargoValidador;
import org.rpascacio.pooclasesabstractas.form.validador.Validador;
import org.rpascacio.pooclasesabstractas.form.validador.mensaje.MensajeFormateable;

import java.util.ArrayList;
import java.util.List;

abstract public class ElementoForm {

    protected String valor;
    protected String nombre;

    private List<Validador> validadores;
    private List<String> errores;

    public ElementoForm() {
        this.validadores=new ArrayList<>();
        this.errores=new ArrayList<>();
    }

    public ElementoForm(String nombre) {
        this();
        this.nombre = nombre;
    }

    public ElementoForm addValidador(Validador validador){
        this.validadores.add(validador);
        return this;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }



    public List<String> getErrores() {
        return errores;
    }

    public boolean isValid(){
        for (Validador v:validadores) {
            if (!v.esValido(this.valor)){
                if (v instanceof MensajeFormateable){
                    this.errores.add(((LargoValidador) v).getMensajeFormateado(nombre));
                    //this.errores.add(String.format(v.getMensaje(), nombre)); // sale nulo, averiguar , pq no se seteo
                    //el nombre en el EjemploForm
                }
                else{
                    this.errores.add(String.format(v.getMensaje(),nombre));
                }

                //this.errores.add(v.getMensaje());
            }
        }
        return this.errores.isEmpty();
    }

    abstract public String dibujarHtml();
}
