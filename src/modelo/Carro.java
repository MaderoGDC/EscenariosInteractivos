/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Estudiante
 */
public class Carro {
    private int x;
    private int y;
    private Llanta[] llantas;
    private Chasis chasis;

    public Carro(int x, int y) {
        this.x = x;
        this.y = y;
        this.llantas = new Llanta[2];
        //Inicializar Llantas - tomando como referencia x y del carro
        this.llantas[0]= new Llanta(x, y);
        this.llantas[1] = new Llanta(x, y);
        //Inicializar Chasis - tomando como referencia x,y del carro
        this.chasis = new Chasis(x, y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void mover (){
      this.x++;
    }
    
    
}
