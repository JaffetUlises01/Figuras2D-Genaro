package figuras2d;

import static com.jogamp.opengl.GL.GL_COLOR_BUFFER_BIT;
import static com.jogamp.opengl.GL.GL_LINE_LOOP;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Figura {
    float[][] PUNTOS;
    float scaleFactor;
    int LINEAS;
    float rotacion;
    float ejeX;
    float ejeY;
    float ejeZ;
    float CX;
    float CY; 
    float R;
    GLAutoDrawable drawable;
    public void setPuntos(float[][] pun){
        this.PUNTOS = pun;
        //System.out.println("Points map updated.");
    }
    public float[][] getPuntos(){
        return this.PUNTOS;
    }
    public void setLineas(int lin){
        this.LINEAS = lin;
    }
    public int getLineas(){
        return this.LINEAS;
    }
    public final void destroy() {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL_COLOR_BUFFER_BIT);
    }
    public void scale(){
        final GL2 gl = drawable.getGL().getGL2();
        gl.glScalef(scaleFactor, scaleFactor, 1f);
    }
    public void drawFigure(){
        int l = 0;
        int p = 0;
        final GL2 gl = drawable.getGL().getGL2();
        gl.glBegin (GL2.GL_LINES);
        while(l < LINEAS){
            String p1 = "x = ";
            String p2 = "x = ";
            gl.glBegin (GL2.GL_LINES);
            gl.glVertex3f(PUNTOS[p][0], PUNTOS[p][1], 0);
            p1+=PUNTOS[p][0];
            p1+="  y = ";
            p1+=PUNTOS[p][1];
            p++;
            gl.glVertex3f(PUNTOS[p][0], PUNTOS[p][1], 0);
            p2+=PUNTOS[p][0];
            p2+="  y = ";
            p2+=PUNTOS[p][1];
            p++;
            //System.out.println("Se ha dibujado el vertice  p1: "+p1+"   p2: "+p2);
            gl.glEnd();
            l++;
        }
        
        gl.glFlush();
    }
    public void drawCircle(int num_segments){
        final GL2 gl = drawable.getGL().getGL2();
        gl.glBegin(GL_LINE_LOOP);
        for(int ii = 0; ii < num_segments; ii++)
        {
            float theta = 2.0f * 3.1415926f * ii / num_segments;

            float x = (float) (R * cos(theta));//calculate the x component
            float y = (float) (R * sin(theta));//calculate the y component

            gl.glVertex2f(x + CX, y + CY);//output vertex

        }
        gl.glEnd();
    }
    public void rotate(){
        final GL2 gl = drawable.getGL().getGL2();
        gl.glRotatef(rotacion, 0f, 0f, 1f);
    }
    
    public void moveCenter(int axis){
        int n = 0;
        
            switch(axis){
                //IZQUIERDA
                case 1:
                    this.CX = this.CX - 0.1f;
                    break;
                //DERECHA
                case 2:
                    this.CX = this.CX + 0.1f;
                    break;
                //ARRIBA
                case 3:
                    this.CY = this.CY - 0.1f;
                    break;
                //ABAJO
                case 4:
                    this.CY = this.CY + 0.1f;
                    break;
            }
            
    }
    
    public void move(int axis){
        int n = 0;
        while(n<this.PUNTOS.length){
            switch(axis){
                //IZQUIERDA
                case 1:
                    this.PUNTOS[n][0] = this.PUNTOS[n][0] - 0.1f;
                    break;
                //DERECHA
                case 2:
                    this.PUNTOS[n][0] = this.PUNTOS[n][0] + 0.1f;
                    break;
                //ARRIBA
                case 3:
                    this.PUNTOS[n][1] = this.PUNTOS[n][1] - 0.1f;
                    break;
                //ABAJO
                case 4:
                    this.PUNTOS[n][1] = this.PUNTOS[n][1] + 0.1f;
                    break;
            }
            n++;
        }
    }
}
