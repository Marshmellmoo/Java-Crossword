public String checkAnswer(String[][] inputCrossword) {
	boolean check = true; 
	int mistakeCounter = 0;
	//2D array for answer key grid (check)
	String ansKey[][] = new String[5][5]; //unfinished 
	
	for (int row = 0; row < ansKey.length; row++) { //replace size with row length of grid
    	for (int col = 0; col < ansKey[0].length; col++) {
    		if (inputCrossword[row][col].equals(ansKey[row][col])) {
    			check = true; 
    		}
    		
    		else {
    			check = false;
    			mistakeCounter++; 
    		}
    		}
    	}

	if (check = true) {
		System.out.println("Congratulations! You correctly completed the crossword puzzle.");
        } 
	else {
		System.out.println("Incorrect. Try again. You have " + mistakeCounter + "mistakes.");
        }
}}
