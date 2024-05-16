/*
 * E5.13 Write a program that translates a letter grade into a number grade. Letter grades are A, B, C, D, and F, possibly followed by + or –. Their numeric values are 4, 3, 2, 1, and 0. There is no F+ or F–. A + increases the numeric value by 0.3, a – decreases it by 0.3. However, an A+ has value 4.0.
 */

import java.util.Scanner;

public class LetterGrades {

	public static void main(String[] args) {
		
		Scanner myObj = new Scanner(System.in);
		System.out.print("Enter letter grade: ");
		String grade = myObj.nextLine();
		
		String sign = grade.substring(grade.length() - 1, grade.length());
		int checksign = "-+".indexOf(sign);
		
		double GPA;
		
		if (grade.substring(0, 1).equals("A")) {
			
			GPA = 4.0;
			
			if (sign.equals("-")) {
				
				GPA = GPA - 0.3;
				
			}
			
		} else if (grade.substring(0, 1).equals("B")) {
			
			GPA = 3.0;
			
			if (sign.equals("+")) {
				
				GPA = GPA + 0.3;
				
			} else if (sign.equals("-")) {
				
				GPA = GPA - 0.3;
				
			}
			
		} else if (grade.substring(0, 1).equals("C")) {
			
			GPA = 2.0;
			
			if (sign.equals("+")) {
				
				GPA = GPA + 0.3;
				
			} else if (sign.equals("-")) {
				
				GPA = GPA - 0.3;
				
			}
			
		} else if (grade.substring(0, 1).equals("D")) {
			
			GPA = 1.0;
			
			if (sign.equals("+")) {
				
				GPA = GPA + 0.3;
				
			} else if (sign.equals("-")) {
				
				GPA = GPA - 0.3;
				
			}
			
		} else if (grade.substring(0, 1).equals("F") && checksign == -1) {
			
			GPA = 0.0;
			
		} else {
			
			GPA = 0.0;
			System.out.println("Error: Not a possible letter grade.");
			
		}
		
		
		System.out.println("GPA is: " + GPA);
			
		}

	}


