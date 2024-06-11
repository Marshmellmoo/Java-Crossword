public String checkAnswer(String[][] inputCrossword) {
    boolean check = true;
    int mistakeCounter = 0;
    String[][] ansKey = crossword.getGrid(); // assuming the grid contains the correct answers

    for (int row = 0; row < ansKey.length; row++) { 
        for (int col = 0; col < ansKey[0].length; col++) {
            if (inputCrossword[row][col].equals(String.valueOf(ansKey[row][col]))) {
                check = true;
            } else {
                check = false;
                mistakeCounter++;
            }
        }
    }

    if (check) {
        return "Congratulations! You correctly completed the crossword puzzle.";
    } else {
        return "Incorrect. Try again. You have " + mistakeCounter + " mistakes.";
    }
}
