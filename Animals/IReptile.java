/**
 * @author Patrick Luggasi 319266177
 * @author Ivan Borinseco 317366102
 * 
 * IReptile interface  
 *  
 * @param MAx_Speed by default and const is 5
 * @method SpeedUp- receive number of speed
 */

package Animals;

public interface IReptile {
	 static final int MAX_SPEED=5;
	 public void speedUp(int sp); 
}