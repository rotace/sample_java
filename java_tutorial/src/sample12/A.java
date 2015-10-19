/**
 * 
 */
package sample12;

/**
 * @author usr
 *
 */
public class A extends Base{
	int aField = 10;
	boolean aMethod() {
		System.out.println("aMethod:baseField:" + baseField);
		return !baseMethod();
	}
}
