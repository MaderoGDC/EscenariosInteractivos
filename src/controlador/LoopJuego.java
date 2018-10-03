package controlador;




import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Shape;
import modelo.Carro;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Estudiante
 */
public class LoopJuego extends AnimationTimer{
   private GraphicsContext gc; //Vista
   private Carro carro; //Modelo
   private Image Fondo;
   private Image Gato;
   private int renuevador = 0;
   private int despacio =0;
   private Image[] munieco;
    public LoopJuego(GraphicsContext gc) {
        this.gc = gc;
        this.carro = new Carro(0, 200);
        this.Fondo = new Image ("Imagenes/Fondo.png");
        this.Gato = new Image ("Imagenes/cats.gif");
        this.munieco = new Image[3];
        this.munieco[0] = new Image ("Imagenes/down0.png");
        this.munieco[1] = new Image ("Imagenes/down1.png");
        this.munieco[0] = new Image ("Imagenes/down0.png");
    }
       
    @Override
    public void handle(long l) {
      //Borrando el tablero
      gc.clearRect(0, 0, 1024,512); 
      //dibujo el fondo
      gc.drawImage(Fondo, 0, 0);
      
            //Dibujando el cuadrito que se mueve
      gc.fillRect(this.carro.getX(),this.carro.getY(), 30, 30);      
      gc.fillOval( 200,this.carro.getY(), 30, 30);
      gc.strokeRect(200,this.carro.getY(), 30, 30);
      gc.setStroke(Color.RED);
      
      Shape sRectangulo = new Rectangle(this.carro.getX(),this.carro.getY(), 30, 30);
      Shape sOvalo = new Rectangle(200,this.carro.getY(), 30, 30);
      Shape intersection = SVGPath.intersect(sRectangulo, sOvalo);
      if(intersection.getBoundsInLocal().getWidth() != -1){
          stop();
      }
      
      this.carro.mover();
//      //dibujo todos los gatos
//        gc.drawImage(Gato, 0, 0);
//      //dibujo primer gato
//      gc.drawImage(Gato, 0, 0, 132, 80, 20, 20, 132, 80);
//      //dibujo segundo gato
//      gc.drawImage(Gato, 396, 0, 132, 80, 160, 20, 132, 80);

    if(renuevador==6)
                renuevador=0;
    

          //gato que se mueve
          
    if(despacio%5 == 0){
            gc.drawImage(Gato, 132*renuevador, 0, 132, 80, 20, 20, 132, 80);
      
       
    }     
    despacio ++;
    renuevador++;

//    //dibujo todos los gatos
//         gc.drawImage(munieco[0], 0, 0,);
    }
}
