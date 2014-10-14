/**
 * 	author Eric Lin
 * 	Completed
 * 		Player vs trained AI
 */

public class Game3 {
	private final int TIMES = 1000;
	private final int MAX = 4;
	private int initial;
	private int total;
	private int player = 2;
	private boolean repeat = true;
	private AI bot1;
	private AI bot2;
	
	public Game3(){
		Test2.addText("Initial stick amount:(10-100)\n");
		String str = Main.input();
		numError(str, 10, 100);
	}
	
	public void gameStart(){
		
		while(total>0 && repeat==true){
			if(player==2){
				player=1;
				Test2.addText("Remaining:" + total + "\n");
				Test2.addText("Player1: How many do you choose?(1-"+ MAX +")\n");
				String str1 = Main.input();
				inputError(str1,1,MAX);
			}
			else{
				int tempNum = bot1.chooseNum(total);
				bot1.updateTemp(total, tempNum);
				Test2.addText("Remaining:" + total + "\n");
				Test2.addText("AI chooses " + tempNum + " sticks\n");
				total = total - tempNum;
				Test2.addText("\n");
				player=2;
			}
		}
		if(repeat==true){
			if(player==1){
				Test2.addText("Player" + player + " loses\n\n");
				bot1.improve();
			}
			else{
				Test2.addText("AI loses\n\n");
			}
			bot1.editTemp();
			player = (int)(Math.random()*2+1);
			restart();
		}
	}
	
	public void numError(String temp, int min, int max){
		if(Main.isInteger(temp)){
			int num = Integer.parseInt(temp);
			if(num>=min && num<=max){
				total = num;
				initial = num;
				bot1 = new AI(total,MAX);
				bot2 = new AI(total,MAX);
				trainAI(bot1, bot2);
				Test2.addText("\n");
				gameStart();
			}
			else{
				Test2.addText("error: input int not within range of "+ min + " and " + max + "\n");
				numError(Main.input(),min,max);
			}
		}
		else if(Main.checkInput(temp)){
			Test2.addText("error: input not an int\n");
			numError(Main.input(),min,max);
		}
		else{
			repeat = false;
		}
	}
	
	public void trainAI(AI bot1, AI bot2){
		Test2.addText("AI in training...\n");
		for(int x=0; x<TIMES; x++){
			while(total>0){
				if(player==2){
					player=1;
					int tempNum = bot1.chooseNum(total);
					bot1.updateTemp(total, tempNum);
					total = total - tempNum;
				}
				else{
					player=2;
					int tempNum = bot2.chooseNum(total);
					bot2.updateTemp(total, tempNum);
					total = total - tempNum;
				}
			}
			if(player==1){
					bot2.improve();
			}
			else{
				bot1.improve();
			}
			bot1.editTemp();
			bot2.editTemp();
			player = 2;
			total = initial;
		}
	}
	
	public void inputError(String temp, int min, int max){
		if(Main.isInteger(temp)){
			int num = Integer.parseInt(temp);
			if(num>=min && num<=max){
				total -= num;
				Test2.addText("Player1 chose " + num + " sticks\n\n");
			}
			else{
				Test2.addText("error: input int not within range of "+ min + " and " + max + "\n");
				inputError(Main.input(),min,max);
			}
		}
		else if(checkInput(temp)){
			Test2.addText("error: input not an int\n");
			inputError(Main.input(),min,max);
			
		}
		else{
			repeat = false;
		}
	}
	
	public boolean getRepeat(){
		return repeat;
	}
	
	public void restart(){
		Test2.addText("Play again?(0-1)\n");
		restartError(Main.input(),0,1);
	}
	
	public void restartError(String num, int min, int max){
		if(Main.isInteger(num)){
			int num2 = Integer.parseInt(num);
			if(num2>=min && num2<=max){
				if(num2==0){
					Test2.addText("Game3 ended\n\n");
					repeat = false;
				}
				else{
					total = initial;
					Test2.addText("\n");
				}
			}
			else{
				Test2.addText("error: input int not within range of "+ min + " and " + max + "\n");
				restartError(Main.input(),min,max);
			}
		}
		else if(Main.checkInput(num)){
			Test2.addText("error: input not an int\n");
			restartError(Main.input(),min,max);
		}
		else{
			repeat = false;
		}
	}
	
	public static boolean checkInput(String str){
		if(str.toUpperCase().equals("ENDGAME")){
			Test2.addText("Game3 ended\n\n");
			return false;
		}
		else{
			return true;
		}
	}
}
