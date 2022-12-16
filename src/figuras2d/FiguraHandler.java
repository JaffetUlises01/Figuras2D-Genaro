package figuras2d;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;

public class FiguraHandler implements GLEventListener {
   private final GLProfile profile = GLProfile.get(GLProfile.GL2);
   private final GLCapabilities capabilities = new GLCapabilities(profile);
   
   // The canvas
   public final GLCanvas glcanvas = new GLCanvas(capabilities);
   public  Figura figura;
   public FiguraHandler(){
       glcanvas.addGLEventListener(this);
       glcanvas.setSize(400, 400);
   }
   
   @Override
   public void display(GLAutoDrawable drawable) {
       //FLUJO:
       //1.- Se obtiene el contexto del canvas
       //2.- En caso de haber buffers, se limpia 
       //3.- Antes de realizar el dibujado, se rota el canvas
       //4.- La figura es dibujada
       //5.- La figura es escalada segun el factor de escala
      figura.drawable = drawable;
      figura.destroy();
      figura.rotate();
      figura.drawFigure();
      figura.scale();
   }
   
   @Override
   public void dispose(GLAutoDrawable arg0) {
      //method body
   }
   
   @Override
   public void init(GLAutoDrawable arg0) {
      // method body    
   }
   
   @Override
   public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
      // method body
   }
   
   //end of main
	
}//end of classimport javax.media.opengl.GL2;