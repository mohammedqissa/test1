import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import javax.swing.JFrame;
import com.jogamp.opengl.util.FPSAnimator;
import java.util.Scanner;

/**
 * Created by mohammedissa on 12/27/16.
 */
public class Main implements GLEventListener {

    float angl =0;

    static GLCanvas glcanvas = null;

    public void display(GLAutoDrawable drawable) {
        final GL2 gl = glcanvas.getGL().getGL2();

        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();



        gl.glRotatef(angl,0f,1f,0f);


        gl.glBegin(GL2.GL_TRIANGLE_FAN);
        float ballRadius = 0.8f;
        gl.glColor3f(1.0f, 0.0f, 0f);  // Blue
        gl.glVertex2f(0.0f, 0.0f);       // Center of circle
        int numSegments = 6;
        float angle;
        for (int i = 0; i <= numSegments; i++) { // Last vertex same as first vertex
            angle = (float) (i* 2.0f * Math.PI / numSegments);  // 360 deg for all segments
            gl.glVertex2f((float) Math.cos(angle+Math.PI/2) * ballRadius, (float) Math.sin(angle+Math.PI/2)  *ballRadius);
        }
        gl.glEnd();

        angl+=.1;


        gl.glFlush();


    }

    public void dispose(GLAutoDrawable arg0) {}

    public void init(GLAutoDrawable arg0) {}

    public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {}

    public static void main(String[] args) {
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        glcanvas = new GLCanvas(capabilities);
        Main l = new Main();
        glcanvas.addGLEventListener(l);
        glcanvas.setSize(500, 600);

        final JFrame frame = new JFrame("");
        frame.getContentPane().add(glcanvas);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);


        final FPSAnimator animator = new FPSAnimator(glcanvas,300,true);
        animator.start();
    }

    public static float[] convert(int x , int y){
        float[] pos = new float[2] ;
        if( x >= 250){
            pos[0] = (float)(x - 250)/(float)250;
        }else{
            pos[0] = (float)(250-x)/(float)-250;
        }

        if(y >= 300){
            pos[1] = (float)-( y - 300) / (float)300 ;
        }else {
            pos[1] = (float)(300-y) / (float)300 ;
        }

        System.out.println(pos[0]+","+ pos[1]);

        return pos ;
    }

}
