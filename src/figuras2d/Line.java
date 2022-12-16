package figuras2d;

public class Line extends Figura{
    public Line(){
        this.PUNTOS = new float[2][2];
        this.LINEAS = 1;
        this.initDots();
    }
    private void initDots(){
        //INIT DOT
        this.PUNTOS[0][0] = -0.50f; 
        this.PUNTOS[0][1] = 0f;
        //END DOT
        this.PUNTOS[1][0] = 0.50f;  
        this.PUNTOS[1][1] = 0f;
    }
}
