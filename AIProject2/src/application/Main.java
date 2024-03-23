//1200644-Mohammad Obeid
//1193288-Motaz Namoura
package application;
	
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Main extends Application {
	private static boolean human=false,ai=false;
	private static String maximum="";
	private static String availableplaces[];
	private static String bestmoveindexes="";
	private static String winner="";
	private static String turn="";
	private static int bg=-1;
	public static String[][] board = {
            {"","",""},
            {"","",""},
            {"","",""}
        };
	private static int aiWins = 0;
	private static int humanWins = 0;
	private static int tie=0;
	private static Button b1=new Button("");
	private static Button b2=new Button("");
	private static Button b3=new Button("");
	private static Button b4=new Button("");
	private static Button b5=new Button("");
	private static Button b6=new Button("");
	private static Button b7=new Button("");
	private static Button b8=new Button("");
	private static Button b9=new Button("");
	private static Font font = Font.font("Verdana", FontWeight.BOLD, 20);
	private static String turn2="";
	private static Text game=new Text("Game: 0");
	private static Button TwoHuman=new Button("Two Players");
	private static Text humanwins=new Text("Human Wins: 0");
	private static Text aiwins=new Text("AI Wins: 0");
	private static Text tiegames=new Text("Draw Games: 0");
	private static Button nextgame=new Button("Next Game");
	private static Pane boardplay=new Pane();
	public static int counter=1;
	private static int [][] animwin=new int[2][3];
	private static int [][] diagwin=new int[2][1];

	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = new Pane();
			Scene scene = new Scene(root,400,400);
			
			Scene scene2=new Scene(boardplay,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Button easy=new Button("Easy");
			easy.setLayoutX(100);
			easy.setLayoutY(50);
			easy.setPrefWidth(200);
			easy.setBackground(new Background(new BackgroundFill(Color.valueOf("#EEE5E5"), CornerRadii.EMPTY, Insets.EMPTY)));
			
			
			game.setLayoutX(150);
			game.setLayoutY(30);
			game.setFont(font);
			
			humanwins.setLayoutX(10);
			humanwins.setLayoutY(300);
			
			aiwins.setLayoutX(10);
			aiwins.setLayoutY(320);
			
			tiegames.setLayoutX(10);
			tiegames.setLayoutY(340);
			
			nextgame.setLayoutX(130);
			nextgame.setLayoutY(300);
			
			
			TwoHuman.setLayoutX(10);
			TwoHuman.setLayoutY(100);
			TwoHuman.setPrefWidth(200);
			TwoHuman.setBackground(new Background(new BackgroundFill(Color.valueOf("#EEE5E5"), CornerRadii.EMPTY, Insets.EMPTY)));
			Button vsAI=new Button("Play against Computer");
			vsAI.setLayoutX(100);
			vsAI.setLayoutY(150);
			vsAI.setPrefWidth(200);
			vsAI.setBackground(new Background(new BackgroundFill(Color.valueOf("#EEE5E5"), CornerRadii.EMPTY, Insets.EMPTY)));
			root.setBackground(new Background(new BackgroundFill(Color.valueOf("#DDCECD"), CornerRadii.EMPTY, Insets.EMPTY)));
			root.getChildren().addAll(vsAI);
			vsAI.setOnAction(e->{
				whostarts();
				for(int i=0;i<=1;i++) {
					for(int j=0;j<=2;j++) {
						animwin[i][j]=0;
					}
				}
				for(int i=0;i<2;i++) {
					diagwin[i][0]=0;
				}
				for(int i=0;i<=2;i++) {
					for(int j=0;j<=2;j++) {
					board[i][j]="";
					}
				}
				if(maximum.equals("ai"))startnewgameAI();
				System.out.println(maximum);
				primaryStage.setScene(scene2);
				
			});
			
			
			b1.setBackground(new Background(new BackgroundFill(Color.valueOf("#EEE5E5"), CornerRadii.EMPTY, Insets.EMPTY)));
			b1.setPrefWidth(50);
			b1.setPrefHeight(50);
			b1.setLayoutX(85);
			b1.setLayoutY(50);
			
			
			b2.setBackground(new Background(new BackgroundFill(Color.valueOf("#EEE5E5"), CornerRadii.EMPTY, Insets.EMPTY)));
			b2.setPrefWidth(50);
			b2.setPrefHeight(50);
			b2.setLayoutX(165);
			b2.setLayoutY(50);
		
			
			
			b3.setBackground(new Background(new BackgroundFill(Color.valueOf("#EEE5E5"), CornerRadii.EMPTY, Insets.EMPTY)));
			b3.setPrefWidth(50);
			b3.setPrefHeight(50);
			b3.setLayoutX(245);
			b3.setLayoutY(50);
			
			
			b4.setBackground(new Background(new BackgroundFill(Color.valueOf("#EEE5E5"), CornerRadii.EMPTY, Insets.EMPTY)));
			b4.setPrefWidth(50);
			b4.setPrefHeight(50);
			b4.setLayoutX(85);
			b4.setLayoutY(140);
			
			
			
			
			b5.setBackground(new Background(new BackgroundFill(Color.valueOf("#EEE5E5"), CornerRadii.EMPTY, Insets.EMPTY)));
			b5.setPrefWidth(50);
			b5.setPrefHeight(50);
			b5.setLayoutX(165);
			b5.setLayoutY(140);
			
			
			
			b6.setBackground(new Background(new BackgroundFill(Color.valueOf("#EEE5E5"), CornerRadii.EMPTY, Insets.EMPTY)));
			b6.setPrefWidth(50);
			b6.setPrefHeight(50);
			b6.setLayoutX(245);
			b6.setLayoutY(140);
			
			
			
			
			b7.setBackground(new Background(new BackgroundFill(Color.valueOf("#EEE5E5"), CornerRadii.EMPTY, Insets.EMPTY)));
			b7.setPrefWidth(50);
			b7.setPrefHeight(50);
			b7.setLayoutX(85);
			b7.setLayoutY(220);
			
			
			
			
			b8.setBackground(new Background(new BackgroundFill(Color.valueOf("#EEE5E5"), CornerRadii.EMPTY, Insets.EMPTY)));
			b8.setPrefWidth(50);
			b8.setPrefHeight(50);
			b8.setLayoutX(165);
			b8.setLayoutY(220);
			
			
			
			
			b9.setBackground(new Background(new BackgroundFill(Color.valueOf("#EEE5E5"), CornerRadii.EMPTY, Insets.EMPTY)));
			b9.setPrefWidth(50);
			b9.setPrefHeight(50);
			b9.setLayoutX(245);
			b9.setLayoutY(220);
			
			boardplay.getChildren().addAll(b1,b2,b3,b4,b5,b6,b7,b8,b9,game,humanwins,aiwins,tiegames,nextgame);
			
			nextgame.setOnAction(e->{
				if(counter<5) {
				turn2="";
				
				System.out.println("mmmmm"+maximum);
				boardplay.getChildren().clear();
				boardplay.getChildren().addAll(b1,b2,b3,b4,b5,b6,b7,b8,b9,game,humanwins,aiwins,tiegames,nextgame);
				b1.setText("");b2.setText("");b3.setText("");b4.setText("");b5.setText("");b6.setText("");b7.setText("");b8.setText("");b9.setText("");
				counter+=1;
				for(int i=0;i<=1;i++) {
					for(int j=0;j<=2;j++) {
						animwin[i][j]=0;
					}
				}
				for(int i=0;i<2;i++) {
					diagwin[i][0]=0;
				}
				for(int i=0;i<=2;i++) {
					for(int j=0;j<=2;j++) {
					board[i][j]="";
					}
				}
				String x="Game "+counter+":";
				game.setText(x);
				whostarts();
				if(maximum.equals("ai"))startnewgameAI();
				}
				else {
					Alert alertType=new Alert(AlertType.INFORMATION);
			    	alertType.setTitle("Information Dialog Box");// line 2
			    	alertType.setHeaderText("X O");// line 3
			    	if(aiWins>humanWins) {
			    		alertType.setContentText("AI won !!");
			    	}
			    	else if(humanWins>aiWins) {
			    		alertType.setContentText("Human Won !!");
			    	}
			    	else {
			    		alertType.setContentText("Draw !!");
			    	}
			    	alertType.show();
				}
				
			});
			//b1 for row=0,col=0
			b1.setOnAction(e->{
				if(b1.getText().equals("")) {
					b1.setText("X");
					b1.setFont(font);
					newgame(0,0);
					startnewgameAI();
					drawanimations(board);
				}
				gameended(board);
			});
			
			//b2 for row=0,col=1
			b2.setOnAction(e->{
				if(b2.getText().equals("")) {
					b2.setText("X");
					b2.setFont(font);
					newgame(0,1);
					startnewgameAI();
					drawanimations(board);
				}
				gameended(board);
			});
			
			//b3 for row=0,col=2
			b3.setOnAction(e->{
				if(b3.getText().equals("")) {
					b3.setText("X");
					b3.setFont(font);
					newgame(0,2);
					startnewgameAI();
					drawanimations(board);
				}
				gameended(board);
			});
			
			//b4 for row=1,col=0
			b4.setOnAction(e->{
				if(b4.getText().equals("")) {
					b4.setText("X");
					b4.setFont(font);
					newgame(1,0);
					startnewgameAI();
					drawanimations(board);
				}
				gameended(board);
			});
			
			//b5 for row=1,col=1
			b5.setOnAction(e->{
				if(b5.getText().equals("")) {
					b5.setText("X");
					b5.setFont(font);
					newgame(1,1);
					startnewgameAI();
					drawanimations(board);
				}
				gameended(board);
			});
			
			//b6 for row=1,col=2
			b6.setOnAction(e->{
				if(b6.getText().equals("")) {
					b6.setText("X");
					b6.setFont(font);
					newgame(1,2);
					startnewgameAI();
					drawanimations(board);
				}
				gameended(board);
			});
			
			//b7 for row=2,col=0
			b7.setOnAction(e->{
				if(b7.getText().equals("")) {
					b7.setText("X");
					b7.setFont(font);
					newgame(2,0);
					startnewgameAI();
					drawanimations(board);
				}
				gameended(board);
				
			});
			
			//b8 for row=2,col=1
			b8.setOnAction(e->{
				if(b8.getText().equals("")) {
					b8.setText("X");
					b8.setFont(font);
					newgame(2,1);					
					startnewgameAI();
					drawanimations(board);
					
				}
				gameended(board);
			});
			//b9 for row=2,col=2
			b9.setOnAction(e->{
				if(b9.getText().equals("")) {
					b9.setFont(font);
					b9.setText("X");
					newgame(2,2);
					startnewgameAI();
					drawanimations(board);
				}
				gameended(board);
			});
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void drawanimations(String [][]board) {
			String win=checkLastWin(board);
			Line line = new Line(1.0f, -40f, 1.0f, 150.0f);
			Line line2 = new Line(110f, 90.0f, 280.0f, 90.0f);
			Group group2 = new Group(line2);
			Group group = new Group(line);
			Line line3 = new Line(85f,52.0f, 288.0f, 265.0f);
			Group group3 = new Group(line3);
			
			
			Line line4 = new Line(293,54.0f,85f,272.0f);
			Group group4 = new Group(line4);


			if(animwin[0][0]==3) {
				line2.setTranslateX(-5);
		        line2.setTranslateY(-15);
		        boardplay.getChildren().add(group2);
		        System.out.println("s");
			}
			else if(animwin[0][1]==3) {
				line2.setTranslateX(-5);
		        line2.setTranslateY(75);
		        boardplay.getChildren().add(group2);
		        System.out.println("q");
			}
			else if(animwin[0][2]==3) {
				line2.setTranslateX(-5);
		        line2.setTranslateY(154);
				boardplay.getChildren().add(group2);
		        System.out.println("d");
			}
			else if(animwin[1][0]==3) {
				line.setTranslateX(110);
		        line.setTranslateY(105);
				boardplay.getChildren().add(group);
		        System.out.println("f");
			}
			else if(animwin[1][1]==3) {
				line.setTranslateX(190);
		        line.setTranslateY(100);
				boardplay.getChildren().add(group);
		        System.out.println("r");
			}
			else if(animwin[1][2]==3) {
				line.setTranslateX(270);
		        line.setTranslateY(100);
				boardplay.getChildren().add(group);
		        System.out.println("n");
			}
			
			else if(diagwin[0][0]==1) {
//				line3.setTranslateX(270);
//		        line3.setTranslateY(100);
				boardplay.getChildren().add(group3);
		        System.out.println("n");
			}
			else if(diagwin[1][0]==1) {
//				line3.setTranslateX(270);
//		        line3.setTranslateY(100);
		        boardplay.getChildren().add(group4);
		        System.out.println("n");
			}
			if(!win.equals("")) {
			System.out.println("sssssss");
			
		}
	}
	
	
	public static void gameended(String [][]board) {
		if(!winner.equals("")) {
		
			String x1="Human Wins: "+humanWins;
			humanwins.setText(x1);
		
		
			String x2="AI Wins: "+aiWins;
			aiwins.setText(x2);
		
		
			String x3="Draw Games: "+tie;
			tiegames.setText(x3);
			}
	}
		
	
	public void startnewgameAI() {
            if (checkNoEmptySpots(board)) {
                System.out.println("TIE");
                return;
            }
            //board
//           X X O
//           O O X
//           ' ' '  
//            
            //x
            
//            X X O
//            O O X
//            ' ' '
            printBoard(board);
            String [][] x=new String[3][3];
            for(int i=0;i<=2;i++) {
				for(int j=0;j<=2;j++) {
					x[i][j]="";
				}
			}
			for(int i=0;i<=2;i++) {
				for(int j=0;j<=2;j++) {
					x[i][j]=board[i][j];
				}
			}

            generatebestmove(board);
            if(!x[0][0].equals(board[0][0]) && !board[0][0].equals("X")) {
            	b1.setText("O");
				b1.setFont(font);
            }
            else if(!x[0][1].equals(board[0][1]) && !board[0][1].equals("X")) {
            	b2.setText("O");
				b2.setFont(font);
            }
            else if(!x[0][2].equals(board[0][2]) && !board[0][2].equals("X")) {
            	b3.setText("O");
				b3.setFont(font);
            }
            else if(!x[1][0].equals(board[1][0]) && !board[1][0].equals("X")) {
            	b4.setText("O");
				b4.setFont(font);
            }
            else if(!x[1][1].equals(board[1][1]) && !board[1][1].equals("X")) {
            	b5.setText("O");
				b5.setFont(font);
            }
            else if(!x[1][2].equals(board[1][2]) && !board[1][2].equals("X")) {
            	b6.setText("O");
				b6.setFont(font);
            }
            else if(!x[2][0].equals(board[2][0]) && !board[2][0].equals("X")) {
            	b7.setText("O");
				b7.setFont(font);
            }
            else if(!x[2][1].equals(board[2][1]) && !board[2][1].equals("X")) {
            	b8.setText("O");
				b8.setFont(font);
            }
            else if(!x[2][2].equals(board[2][2]) && !board[2][2].equals("X")) {
            	b9.setText("O");
				b9.setFont(font);
            }

            winner = checkWinner(board);
            System.out.println("\nNew Game Tree After Move\n");
            printBoard(board);
            if (!winner.equals("")) {
                System.out.println("Player " + winner + " wins");
                if (winner.equals("ai")) {
                    aiWins++;
                } else if(winner.equals("human")) {
                    humanWins++;
                }
                else {
                	tie++;
                }
                return;
            }
            
        	

        
	}
		
		
		
	public static void newgame(int row,int col) {
				maximum="human";///updateeeetddddddddddddddd
            	playerMove(board, row,col);
                
                winner = checkWinner(board);
                
                printBoard(board);
                if (!winner.equals("")) {
                    System.out.println("Player " + winner + " wins");
                    if (winner.equals("ai")) {
                        aiWins++;
                    } else if(winner.equals("human")) {
                        humanWins++;
                    }
                    else {
                    	tie++;
                    }
                    return;
                }
                winner = checkWinner(board);
                System.out.println("\nNew Game Tree After Move\n");
                printBoard(board);
            
        }
	
	
	
	
	private static void playerMove(String[][] board, int row, int col) {//updated
		board[row][col] = "X";
    }
	
 
	
	
    public static void generatebestmove(String [][]board){
    	String winner=checkWinner(board);
      	if(maximum.equals("ai")) {
      	if(winner.equals("")) {
      		int bestMaxScore=Integer.MIN_VALUE;//-2147483
      		 String bestMoveIndexes = "";
      		for(int i=0;i<=2;i++) {
      			for(int j=0;j<=2;j++) {
      				if(board[j][i].equals("")){
      				board[j][i]="O";
      				turn="human";
      				int score=minimax(board);//7
      				board[j][i]="";
      				if(score>bestMaxScore) {
      				bestMaxScore=Math.max(bestMaxScore, score);
      				bestMoveIndexes=j+","+i;//1,1
      				}
      				
      			}
      		}
      		
      	}
      	String []r=bestMoveIndexes.split(",");
      	board[Integer.valueOf(r[0])][Integer.valueOf(r[1])]="O";
//      	printBoard(board);
      	}
      	}
      	else {
      		if(winner.equals("")) {
          		int bestMinScore=Integer.MAX_VALUE;//2147483
          		 String bestMoveIndexes = "";
          	for(int i=0;i<=2;i++) {
          		for(int j=0;j<=2;j++) {
          			if(board[j][i].equals("")){
          				board[j][i]="O";
          				turn ="human";
          				int score=minimax(board);//minimaxFunction to be called/////////////////////////////
          				board[j][i]="";
          				if(score<bestMinScore) {
          				bestMinScore=Math.min(bestMinScore, score);
          				bestMoveIndexes=j+","+i;}
          			}
          		}
          		
          	}
          	String []r=bestMoveIndexes.split(",");
          	board[Integer.valueOf(r[0])][Integer.valueOf(r[1])]="O";
      	}
      
    }
    }
    
    public static int minimax(String [][]board) {
    	String winner=checkWinner(board);//function that checks if there is a winner
    	if(!winner.equals("")) {
    		if(maximum.equals("ai")) {
        		if(winner.equals("ai"))return 1;
        		if(winner.equals("human"))return -1;    	    		
        		if(winner.equals("tie"))return 0;}
    		else {
    			if(winner.equals("ai"))return -1;
        		if(winner.equals("human"))return 1;    	    		
        		if(winner.equals("tie"))return 0;}	
    	}
    	
        if (turn.equals("ai")) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {
                    if (board[j][i].equals("")) {
                        board[j][i] = "O";
                        turn="human";
                        int score = minimax(board);
                        bestScore = Math.max(score, bestScore);
                        board[j][i] = ""; // Undo the move

                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {
                    if (board[j][i].equals("")) {
                        board[j][i] = "X";
                        turn="ai";
                        int score = minimax(board);
                        bestScore = Math.min(score, bestScore);
                        board[j][i] = ""; // Undo the move

                    }
                }
            }
            return bestScore;
        } 
    }
    
    
    
    public static boolean checkNoEmptySpots(String [][]board){
    	int flag=0;
    	for (int i=0;i<=2;i++) {
            for (int j=0;j<=2;j++) {
            	if(board[i][j].equals("")) {
            		flag=1;
            		break;
            	}
            	
            }
            if(flag==1)break;
            
    	}
    	if(flag==1) {
        	return false;
        }
        return true;
    }
    public static void whostarts() {
    	int x=(int)(Math.random()*(2-0))+0;
    	if(x==0) {
    		human=true;
    		maximum="human";
    	}
    	else {
    		ai=true;
        	maximum="ai";
    	}
    }
    
    
    public static String checkWinner(String [][]board) {
    	
    	String winner="";//updated
    	int flag=0;
    	// check horizontally 
    	for(int i=0;i<=2;i++) {
    		if(board[i][0].equals("X") && board[i][1].equals("X") && board[i][2].equals("X") && !board[i][0].equals("")) {//updated
    			winner="human";
    			flag=1;
    			break;
    		}
    		if(board[i][0].equals("O") && board[i][1].equals("O") && board[i][2].equals("O") && !board[i][0].equals("")) {//updated
    			winner="ai";
    			flag=1;
    			break;
    		}
    		else {
    			continue;
    		}
    	}
    	
    	
    	
    	// check vertically
    	for(int i=0;i<=2;i++) {
    		if(board[0][i].equals("X") && board[1][i].equals("X") && board[2][i].equals("X")) {//updated
    			winner="human";
    			flag=1;
    			break;
    		}
    		if(board[0][i].equals("O") && board[1][i].equals("O") && board[2][i].equals("O")) {//updated
    			winner="ai";
    			flag=1;
    			break;
    		}
    		else {
    			continue;
    		} 
    	}
    	
    	// check the diagonal
    		if(board[0][0].equals("X") && board[1][1].equals("X") && board[2][2].equals("X")) {//updated
    			winner="human";
    			flag=1;
    		}
    		if(board[0][0].equals("O") && board[1][1].equals("O") && board[2][2].equals("O")) {//updated
    			winner="ai";
    			flag=1;
    		}

    	
    	
    	
    	
    	// check the invert of diagonal
    		if(board[0][2].equals("X") && board[1][1].equals("X") && board[2][0].equals("X")) {//updated
    			winner="human";
    			flag=1;
    		}
    		if(board[0][2].equals("O") && board[1][1].equals("O") && board[2][0].equals("O")) {//updated
    			winner="ai";
    			flag=1;
    		}

    	
    	if(flag==0 && checkNoEmptySpots(board)==true) {
    		winner="tie";
    	}
    	return winner;
    	
    }
    
    
public static String checkLastWin(String [][]board) {
       	int flag=0;
       	String x="";
    	// check horizontally 
    	for(int i=0;i<=2;i++) {
    		if(board[i][0].equals("X") && board[i][1].equals("X") && board[i][2].equals("X")) {
    			animwin[0][i]=3;
    			x="ssss";
    			break;
    		}
    		if(board[i][0].equals("O") && board[i][1].equals("O") && board[i][2].equals("O")) {
    			animwin[0][i]=3;
    			x="ssss";
    			break;
    		}
    		else {
    			continue;
    		}
    	}
    	
    	
    	
    	// check vertically
    	for(int i=0;i<=2;i++) {
    		if(board[0][i].equals("X") && board[1][i].equals("X") && board[2][i].equals("X")) {
    			animwin[1][i]=3;
    			x="ssss";
    			break;
    		}
    		if(board[0][i].equals("O") && board[1][i].equals("O") && board[2][i].equals("O")) {
    			animwin[1][i]=3;
    			x="ssss";
    			break;
    		}
    		else {
    			continue;
    		} 
    	}
    	
    	// check the diagonal
    		if(board[0][0].equals("X") && board[1][1].equals("X") && board[2][2].equals("X")) {
    			diagwin[0][0]=1;
    			x="ssss";
    		}
    		if(board[0][0].equals("O") && board[1][1].equals("O") && board[2][2].equals("O")) {
    			diagwin[0][0]=1;
    			x="ssss";
    		}

    	
    	
    	
    	
    	// check the invert of diagonal
    		if(board[0][2].equals("X") && board[1][1].equals("X") && board[2][0].equals("X")) {
    			diagwin[1][0]=1;
    			x="ssss";
    		}
    		if(board[0][2].equals("O") && board[1][1].equals("O") && board[2][0].equals("O")) {
    			diagwin[1][0]=1;
    			x="ssss";
    		}
    	
    	return x;
    	
    }

    public static void printBoard(String[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
    }

  
    
}