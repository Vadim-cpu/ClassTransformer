package tool;

import java.io.IOException;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass; // Wrapper for Class <?>
import javassist.CtConstructor;
import javassist.CtNewConstructor;
import javassist.NotFoundException;

public class ClassTransformer {

	public static Class<?> transform() throws NotFoundException, IOException, CannotCompileException {
		
		//Get the class manipulation tool = pool
		ClassPool pool = ClassPool.getDefault();
		pool.appendClassPath("C:\\Users\\Славик\\Desktop\\Vadim\\workspace\\CodeTransform\\bin");
		//pool.appendClassPath("bin");
		// .appendClassPath - in case of errors
		
		// load the desired class
		
		CtClass cc = pool.get("original.Box");
	    
	    // find the default constructor
			CtConstructor ccon= cc.getDeclaredConstructor(null);
	    // remove it
			cc.removeConstructor(ccon);

	    // create a new default constructor
			CtConstructor cstructor = CtNewConstructor.defaultConstructor( cc	) ;
	    // modify the constructor behaviour
			cstructor.setBody( "this.id = 100;");
			// add the constructor to the class
			cc.addConstructor(cstructor);
	    // return the modified class
			return cc.toClass();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		CtClass cc = pool.get("original.Box");
//		//cc.setSuperclass(pool.get("test.Point")); ->from documentation of javassist
//		
//		CtConstructor cscostructor = CtNewConstructor.make(
//				"public" + "Box" + "{" +
//						"id = 100;"
//					+"}", cc);
//		// add some default logic
//		cc.addConstructor(cscostructor);
//		
//		//save changed class
//		cc.writeFile();
	}
}
