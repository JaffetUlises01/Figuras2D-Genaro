package figuras2d;

public class Square extends Figura{
    public Square(){
        this.PUNTOS = new float[8][2];
        this.LINEAS = 4;
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
        
        
        //IZQUIERDA
        //INIT DOT
        this.PUNTOS[2][0] = -0.5f; 
        this.PUNTOS[2][1] = -0.5f;
        //END DOT
        this.PUNTOS[3][0] = -0.5f;  
        this.PUNTOS[3][1] = 0.5f;
        
        
        //ARRIBA
        //INIT DOT
        this.PUNTOS[4][0] = -0.5f; 
        this.PUNTOS[4][1] = 0.5f;
        //END DOT
        this.PUNTOS[5][0] = 0.5f;  
        this.PUNTOS[5][1] = 0.5f;
        
        
        //DERECHA
        //INIT DOT
        this.PUNTOS[6][0] = 0.5f; 
        this.PUNTOS[6][1] = 0.5f;
        //END DOT
        this.PUNTOS[7][0] = 0.5f;  
        this.PUNTOS[7][1] = -0.5f;
    }
}
