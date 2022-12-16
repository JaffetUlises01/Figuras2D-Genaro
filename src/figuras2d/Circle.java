package figuras2d;

public class Circle extends Figura{
    public Circle(){
        initCenter();
    }
     private void initCenter(){
        this.CX = 0f;
        this.CY = 0f;
        this.R = 0.8f;
    }
    public void drawFigure(){
        this.drawCircle(20000);
    }
    public void move(int axis){
        this.moveCenter(axis);
    }
    
}
