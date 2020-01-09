/*
 *  Program od koleżanki z ławki: Anna Prusinowska s13677.
 *  Testowany za pomocą Robot Framework
 */
package com.hawliczek.tau.test.robot.zad2;

import java.util.Scanner;

public class FigureRecognizer {

	public static final int yes = 1;
	public static final int no = 2;
	public static int variable1;
	public static int variable2;
	public static int variable3;
	public static int variable4;
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		
		System.out.println("Podaj długości boków");
		giveMeParams();

	}

	private static void giveMeParams() throws Exception {

		write("Podaj 1 parametr");
		variable1 = sc.nextInt();
		write("Podaj 2 parametr");
		variable2 = sc.nextInt();
		write("Podaj 3 parametr");
		variable3 = sc.nextInt();

		write("Czy chcesz podać 4 parametr? Jeśli tak, wybierz 1, jeśli nie, wybierz 2");
		int answear = sc.nextInt();
		if (answear == yes) {
			System.out.println("Podaj 4 parametr");
			variable4 = sc.nextInt();

			checkIsSquad(variable1, variable2, variable3, variable4);

		} else if (answear == no) {

			checkIsTriangle(variable1, variable2, variable3);

		}

	}

	private static void checkIsSquad(int a, int b, int c, int d) throws Exception {

		int sumOfThree;
		int theLongestSide = searchMaxOfFour(a, b, c, d);

		if (a == theLongestSide) {
			sumOfThree = b + c + d;
			if (sumOfThree > a) {
				write("Figura jest czworobokiem");
				// whichTriangleItIs(a, b, c);

			}
		} else if (b == theLongestSide) {
			sumOfThree = a + c + d;
			if (sumOfThree > b) {
				write("Figura jest czworobokiem");
				// whichTriangleItIs(a, b, c);
				whichSquadItIs(a, b, c, d);
			}
		} else if (c == theLongestSide) {
			sumOfThree = a + b + d;
			if (sumOfThree > c) {
				write("Figura jest czworobokiem");
				whichSquadItIs(a, b, c, d);
			}
		} else if (d == theLongestSide) {
			sumOfThree = a + b + c;
			if (sumOfThree > d) {
				write("Figura jest czworobokiem");
				whichSquadItIs(a, b, c, d);
			} else {
				write("To nie jest czworobok");
			}
		}

	}

	private static void checkIsTriangle(int a, int b, int c) throws Exception {

		int sumOfTwo;
		int theLongestSide = searchMaxOfThree(a, b, c);

		if (a == theLongestSide) {
			sumOfTwo = b + c;
			if (sumOfTwo > a) {
				write("Figura jest trójkątem");
				whichTriangleItIs(a, b, c);

			}
		} else if (b == theLongestSide) {
			sumOfTwo = a + c;
			if (sumOfTwo > b) {
				write("Figura jest trójkątem");
				whichTriangleItIs(a, b, c);
			}
		} else if (c == theLongestSide) {
			sumOfTwo = a + b;
			if (sumOfTwo > c) {
				write("Figura jest trójkątem");
				whichTriangleItIs(a, b, c);
			} else {
				write("To nie jest trójkąt");
			}
		}

	}

	private static void whichSquadItIs(int a, int b, int c, int d) throws Exception {

		if (a == b && b == c && c == d) {
			write("Czworokąt o bokach " + "a=" + a + " b=" + b + " c=" + c + " d=" + d + " jest kwadratem lub rombem");
		} else if ((a == b && c == d) || (a == c && b == d) || (a == d && b == c)) {
			write("Czworokąt o bokach " + "a=" + a + " b=" + b + " c=" + c + " d=" + d + " jest prostokątem lub równoległobokiem");

		} else {
			write("Czworokąt o bokach " + "a=" + a + " b=" + b + " c=" + c + " d=" + d
					+ " nie jest ani kwadratem, ani rombem, ani prostokątem, ani równoległobokiem");
		}

	}

	private static void whichTriangleItIs(int a, int b, int c) throws Exception {

		if (a == b && b == c) {
			write("Trójkąt o bokach " + "a=" + a + " b=" + b + " c=" + c + " jest równoboczny");
		} else if (a == b || a == c || b == c) {
			write("Trójkąt o bokach " + "a=" + a + " b=" + b + " c=" + c + " jest równoramienny");

		} else {
			write("Trójkąt o bokach " + "a=" + a + " b=" + b + " c=" + c + " jest różnoboczny");
		}

	}

	private static int searchMaxOfThree(int a, int b, int c) throws Exception {

		int[] triangleSides = { a, b, c };
		int max = 0;
		for (int i = 0; i < triangleSides.length; i++) {
			if (triangleSides[i] > max) {
				max = triangleSides[i];
			}
		}
		return max;

	}

	private static int searchMaxOfFour(int a, int b, int c, int d) throws Exception {

		int[] quadrangleSides = { a, b, c, d };
		int max = 0;
		for (int i = 0; i < quadrangleSides.length; i++) {
			if (quadrangleSides[i] > max) {
				max = quadrangleSides[i];
			}
		}
		return max;
	}

	private static void write(String text) throws Exception {

		System.out.println(text);
	}

}