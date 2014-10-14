/**
 * 	author Eric Lin
 * 	Completed
 * 		Game4 class
 */


public class Game4 extends Game{
	public void playerOneMove(){
		int tempNum = AI.selectNum();
		Test2.addText("Remaining:" + total + "\n");
		Test2.addText("AI chooses " + tempNum + " sticks\n");
		total = total - tempNum;
		Test2.addText("\n");
		player=1;
	}
	
	public void playerTwoMove(){
		player = 2;
		Test2.addText("Remaining:" + total + "\n");
		Test2.addText("Player1: How many do you choose?(1-"+ MAX +")\n");
		String str1 = Main.input();
		inputError(str1,1,MAX);
	}
	
	public void playerLoss(){
		if(player==2){
			Test2.addText("Player1 loses\n\n");
		}
		else{
			Test2.addText("AI loses\n\n");
		}
	}
}