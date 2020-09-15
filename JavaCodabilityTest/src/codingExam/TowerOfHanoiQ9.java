package codingExam;
/*9. Write a java program to Implement tower of hanoi using stack data structure.
 * */
public class TowerOfHanoiQ9 {
	static DynamicStack[] tower;
	public static void towersOfHanoi(int n) {
		 
         tower = new DynamicStack[4];
        for (int i = 0; i <= 3; i++){
            tower[i] = new DynamicStack(4);
        }
        for (int d = n; d > 0; d--){
            
            tower[1].push(new Integer(d)); 
        }
        
        showTowerStates(n, 1, 2, 3);
    }
 
    public static void showTowerStates(int n, int source, int intermediate, int destination) {
         
        if (n > 0) {
            try{
                showTowerStates(n - 1, source, destination, intermediate);
                Integer d = (Integer) tower[source].pop(); 
                
                tower[destination].push(d); 
                System.out.println("Move disk " + d 
                        + " from tower "+ source + " to top of tower " + destination);
                showTowerStates(n - 1, destination,intermediate, source);
            } catch(Exception ex){}
        }
    }
 
    public static void main(String[] args) {
        System.out.println("Running 3 disk problem:");
        towersOfHanoi(3);
    }
}
 

