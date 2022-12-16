package figuras2d;

import com.jogamp.opengl.awt.GLCanvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Consola extends javax.swing.JFrame {

    Figura FIGURA_ACTUAL;
    FiguraHandler fh;
    String consoleLogText;
    char action;
    //float rotacionX;
    //float rotacionY;
    float rotacionZ;
    float scaleFactor;
    Figura[] FIGURAS;
    public Consola() {
        FIGURAS = new Figura[5];
        FIGURAS[0] = new Line();
        FIGURAS[1] = new Triangle();
        FIGURAS[2] = new Square();
        FIGURAS[3] = new Rectangle();
        FIGURAS[4] = new Circle();
        action = 'm';
        //rotacionX = 0;
        //rotacionY = 0;
        rotacionZ = 0;
        FIGURA_ACTUAL = new Line();
        FIGURA_ACTUAL.ejeY = 0f;
        FIGURA_ACTUAL.ejeX = 0f;
        FIGURA_ACTUAL.ejeZ = 1.0f;
        FIGURA_ACTUAL.rotacion = 0f;
        FIGURA_ACTUAL.scaleFactor = 1f;
        fh = new FiguraHandler();
        fh.figura = FIGURA_ACTUAL;
        GLCanvas glcanvas = fh.glcanvas;
        
        initComponents();
        consoleLogText = "--------------Renderizado de figuras con OpenGL con JOGL--------------\n";
        consoleLog.setText(consoleLogText);
        consoleLogText+="-------Modo de manipulacion activado: Mover------\n";
        consoleLog.setText(consoleLogText);
        manejoCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String actions = "mrs";
                String[] actionsNames = new String[3];
                actionsNames[0]="Mover";
                actionsNames[1]="Rotar";
                actionsNames[2]="Escalar";
                action = actions.charAt(manejoCombo.getSelectedIndex());
                
                String output = "-------Modo de manipulacion activado: "+actionsNames[manejoCombo.getSelectedIndex()]+"------\n";
                consoleLogText+=output;
                consoleLog.setText(consoleLogText);
                jPanel1.requestFocus();
            }
        });
        figuraCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String[] figurasNames = new String[5];
                figurasNames[0]="Linea";
                figurasNames[1]="Triangulo";
                figurasNames[2]="Cuadrado";
                figurasNames[3]="Rectangulo";
                figurasNames[4]="Circulo";
                FIGURA_ACTUAL = FIGURAS[figuraCombo.getSelectedIndex()];
                FIGURA_ACTUAL.ejeY = 0f;
                FIGURA_ACTUAL.ejeX = 0f;
                FIGURA_ACTUAL.ejeZ = 1f;
                FIGURA_ACTUAL.rotacion = 0f;
                fh = new FiguraHandler();                    
                fh.figura = FIGURA_ACTUAL;
                String output = "------Dibujando: "+figurasNames[figuraCombo.getSelectedIndex()]+"------\n";
                consoleLogText+=output;
                consoleLog.setText(consoleLogText);
                GLCanvas glcanvas = fh.glcanvas;
                graficos.remove(0);
                graficos.add(glcanvas);
                jPanel1.requestFocus();
            }
        });
        jPanel1.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent ke) {
                
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                if(ke.getKeyCode() == KeyEvent.VK_LEFT){
                    fh = new FiguraHandler();                    
                    if(action == 'm'){
                        consoleLogText+="Moviendo la figura a la izquierda 1 unidad\n";
                        consoleLog.setText(consoleLogText);
                        FIGURA_ACTUAL.move(1);
                        fh.figura = FIGURA_ACTUAL;
                        GLCanvas glcanvas = fh.glcanvas;
                        graficos.remove(0);
                        graficos.add(glcanvas);
                    }
                    if(action == 'r'){
                        
                        if(rotacionZ <= 360 && rotacionZ >= 0){
                            rotacionZ = rotacionZ +20f;
                        }else{
                            rotacionZ = rotacionZ + 20f;
                            rotacionZ = rotacionZ - 360f;
                        }
                        consoleLogText+="Rotando la figura en el eje Z hacia la izquierda "+rotacionZ+" grados\n";
                        consoleLog.setText(consoleLogText);
                        FIGURA_ACTUAL.rotacion = rotacionZ;
                        fh.figura = FIGURA_ACTUAL;
                        GLCanvas glcanvas = fh.glcanvas;
                        graficos.remove(0);
                        graficos.add(glcanvas);
                    }
                }
                if(ke.getKeyCode() == KeyEvent.VK_RIGHT){
                    fh = new FiguraHandler();
                    if(action == 'm'){
                        consoleLogText+="Moviendo la figura a la derecha 1 unidad\n";
                        consoleLog.setText(consoleLogText);
                        FIGURA_ACTUAL.move(2);
                        fh.figura = FIGURA_ACTUAL;
                        GLCanvas glcanvas = fh.glcanvas;
                        graficos.remove(0);
                        graficos.add(glcanvas);
                    }
                    if(action == 'r'){
                        
                        if(rotacionZ <= 360 && rotacionZ >= 0){
                            rotacionZ = rotacionZ - 20f;
                        }else{
                            rotacionZ = rotacionZ - 20f;
                            rotacionZ = rotacionZ + 360f;
                        }
                        consoleLogText+="Rotando la figura en el eje Z hacia la derecha "+rotacionZ+" grados\n";
                        consoleLog.setText(consoleLogText);
                        FIGURA_ACTUAL.rotacion = rotacionZ;
                        fh.figura = FIGURA_ACTUAL;
                        GLCanvas glcanvas = fh.glcanvas;
                        graficos.remove(0);
                        graficos.add(glcanvas);
                    }
                    
                }
                if(ke.getKeyCode() == KeyEvent.VK_UP){
                    fh = new FiguraHandler();
                    if(action == 'm'){
                        consoleLogText+="Moviendo la figura hacia arriba 1 unidad\n";
                        consoleLog.setText(consoleLogText);
                        FIGURA_ACTUAL.move(4);
                        fh.figura = FIGURA_ACTUAL;
                        GLCanvas glcanvas = fh.glcanvas;
                        graficos.remove(0);
                        graficos.add(glcanvas);
                    }
                    if(action == 's'){
                        scaleFactor = scaleFactor + 0.10f;
                        consoleLogText+="Escalando a factor de "+scaleFactor+"\n";
                        consoleLog.setText(consoleLogText);
                        FIGURA_ACTUAL.scaleFactor = scaleFactor;
                        fh.figura = FIGURA_ACTUAL;
                        GLCanvas glcanvas = fh.glcanvas;
                        graficos.remove(0);
                        graficos.add(glcanvas);
                    }
                }
                if(ke.getKeyCode() == KeyEvent.VK_DOWN){
                    fh = new FiguraHandler();
                    if(action == 'm'){
                        consoleLogText+="Moviendo la figura hacia abajo 1 unidad\n";
                        consoleLog.setText(consoleLogText);
                        FIGURA_ACTUAL.move(3);
                        fh.figura = FIGURA_ACTUAL;
                        GLCanvas glcanvas = fh.glcanvas;
                        graficos.remove(0);
                        graficos.add(glcanvas);
                    }
                    if(action == 's'){
                        scaleFactor = scaleFactor - 0.10f;
                        consoleLogText+="Escalando a factor de "+scaleFactor+"\n";
                        consoleLog.setText(consoleLogText);
                        FIGURA_ACTUAL.scaleFactor = scaleFactor;
                        fh.figura = FIGURA_ACTUAL;
                        GLCanvas glcanvas = fh.glcanvas;
                        graficos.remove(0);
                        graficos.add(glcanvas);
                    }
                }
                
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
            
        });
        jPanel1.requestFocus();
        this.graficos.add(glcanvas);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        graficos = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        figuraCombo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        manejoCombo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        consoleLog = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        graficos.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout graficosLayout = new javax.swing.GroupLayout(graficos);
        graficos.setLayout(graficosLayout);
        graficosLayout.setHorizontalGroup(
            graficosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        graficosLayout.setVerticalGroup(
            graficosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        jLabel1.setText("Seleccione una figura.");

        figuraCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Linea", "Triangulo", "Cuadrado", "Rectangulo",  "Circulo"}));

        jLabel2.setText("Seleccione un modo de manipulación.");

        manejoCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mover", "Rotar", "Escalar"}));

        jLabel3.setText("Una vez seleccionado el modo:");

        jLabel4.setText("-Con las flechas puede mover la figura");

        jLabel5.setText("-Las flechas izquierda y derecha manejan la rotación de la figura");

        consoleLog.setEditable(false);
        consoleLog.setColumns(20);
        consoleLog.setRows(5);
        jScrollPane1.setViewportView(consoleLog);

        jLabel7.setText("Log");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel6.setText("-Arriba y abajo ajustaran el zoom(escalado)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 36, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(manejoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(figuraCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(figuraCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manejoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setText("FIGURA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(graficos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(graficos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea consoleLog;
    private javax.swing.JComboBox<String> figuraCombo;
    public javax.swing.JPanel graficos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> manejoCombo;
    // End of variables declaration//GEN-END:variables
}
