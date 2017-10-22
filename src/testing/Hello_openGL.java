package testing;

import static org.lwjgl.opengl.GL11.*; //11 stands for version 1.1  //must be static in order for it to compile; openGL methods are static
import org.lwjgl.opengl.*;
import org.lwjgl.*;

public class Hello_openGL {
	
	public Hello_openGL() {
		
		
		try { //this try-catch statement is required.
			Display.setDisplayMode(new DisplayMode(640,480)); //width, height for display window
			Display.setTitle("Hello, LWJGL!"); //title of window
			Display.create();
			
		}catch(LWJGLException e) {
			e.printStackTrace();
		}
		
		//initialization code
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();               //resets any previous projection matrices
		glOrtho(0, 640, 480, 0, 1, -1); //parameters: leftmost x coordinate, rightmost x coordinate, 
		                                            //lower-most y coordinate, upper-most y coordinate, 
													//closest z coordinate, farthest z coordinate. 1,-1 is fine for 2D image rendering.
		
		//glMatrixMode(GL_MODELVIEW); //not sure if this line is needed. It seems redundant to me (see line 22)
		
		
		while(!Display.isCloseRequested()) { //while the x button (close) has not been clicked, do the following
			//render code
			
			glClear(GL_COLOR_BUFFER_BIT); //when using 3D, use glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); //yes, that is a bitwise operator
			
			glBegin(GL_QUADS);
				glVertex2i(400,400); //upper left
				glVertex2i(450,400); //upper right
				glVertex2i(450,450); //bottom right
				glVertex2i(400,450); //bottom left
			glEnd();	
			
			glBegin(GL_LINES); //constants are final ints. Begin says where the points are starting for drawing shapes
				glVertex2i(100, 100); //the number, which is a 2 here, can be 2, 3, or 4, and that means how many components the vertex will have.
				glVertex2i(200, 200); //the letter, which is an i here, specifies type. There are three letters that can be used: i, f, and d. 
									  //i means int, f means float, and d means double. 
			glEnd();           //end area where points are specified for shape called in Begin
			
			
			
			Display.update();
			Display.sync(60); //set FPS cap of 6 
		}
		
		Display.destroy(); //close window when x button has been clicked (while loop has closed).
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Hello_openGL();
	}

}
