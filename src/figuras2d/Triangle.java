package figuras2d;

public class Triangle extends Figura{
    public Triangle(){
        this.PUNTOS = new float[6][2];
        this.LINEAS = 3;
        this.initDots();
    }
    private void initDots(){
        //BASE
        //INIT DOT
        this.PUNTOS[0][0] = -0.50f; 
        this.PUNTOS[0][1] = -0.50f;
      
        //END DOT
        this.PUNTOS[1][0] = 0.50f;  
        this.PUNTOS[1][1] = -0.50f;
      
      
      
        //CATETO IZQUIERDO
        //INIT DOT
        this.PUNTOS[2][0] = 0f;     
        this.PUNTOS[2][1] = 0.50f;
        
        //END DOT
        this.PUNTOS[3][0] = -0.50f; 
        this.PUNTOS[3][1] = -0.50f;
      
      
      
        //CATETO DERECHO
        //INIT DOT
        this.PUNTOS[4][0] = -0f;    
        this.PUNTOS[4][1] = 0.50f;
        
        //END DOT
        this.PUNTOS[5][0] = 0.50f;  
        this.PUNTOS[5][1] = -0.50f;
    }
}
