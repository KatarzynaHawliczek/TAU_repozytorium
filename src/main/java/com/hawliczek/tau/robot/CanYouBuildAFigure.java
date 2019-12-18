package com.hawliczek.tau.robot;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CanYouBuildAFigure
{
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		System.out.println("Sprawdź, czy możesz zbudować:");
		System.out.println("1 --> trójkąt");
		System.out.println("2 --> czworokąt");
		
		int n = sc.nextInt();
		int sides = 0;
		
		if(n == 1)
		{
			sides = 3;
			try
			{
                double[] input = getSideLengths(sides);
				triangleChecker(input);
			}
			catch(InputMismatchException e)
			{
				System.out.println("Nieprawidłowe dane!");
			}	
		}
		else if(n == 2)
		{
			sides = 4;
			try
			{
				double[] input = getSideLengths(sides);
				squareChecker(input);
			}
			catch(InputMismatchException e)
			{
				System.out.println("Nieprawidłowe dane!");
			}
		}
		else
		{
			System.out.println("Zły wybór.");
		}
	}
	
	public static double[] getSideLengths(int sides)
	{
		System.out.println("Podaj długości boków:");			
		double[] input = new double[sides];
		for(int i=0; i<sides ; i++)
		{
			input[i] = sc.nextDouble();
		}
		sc.close();
		return input;
	}
	
	public static void triangleChecker(double input[])
	{
		int max = findMax(input, 3);
		double sum = input[0] + input[1] + input[2];
		
		if(sum - (input[max]) <= input[max])
		{
			System.out.println("Nierozpoznano. Nie można zbudować trójkąta.");
		}
		else
		{
			if(input[0] == input[1]  && input[2] == input[0])
			{
				System.out.println("Trójkąt równoboczny.");
			}
			else if(input[0] != input[1] && input[2] != input[0] && input[1] != input[2])
			{
				System.out.println("Trójkąt różnoramienny.");
			}
			else
			{
				System.out.println("Trójkąt równoramienny.");
			}
		}
	}
	
	public static void squareChecker(double input[])
	{
		int max = findMax(input, 4);
		double sum = input[0] + input[1] + input[2] + input[3];
		
		if(sum - (input[max]) <= input[max])
		{
			System.out.println("Nierozpoznano. Nie można zbudować czworokąta.");
		}
		else if(input[0] == input[1] && input[1] == input[2] && input[2] == input[3])
		{
			System.out.println("Kwadrat lub romb.");
		}
		else if((input[0] == input[1] && input[2] == input[3]) || (input[1] == input[2] && input[3] == input[0] || (input[1] == input[3] && input[2] == input[0])))
		{
			System.out.println("Prostokąt lub równoległobok.");
		}
		else
		{
			System.out.println("Czworobok");
		}
	}
	
	public static int findMax(double tab[], int n)
	{
		double max = tab[0];
		int index = 0;
		
		for(int i=1; i<n; i++)
		{
			if(tab[i] > max)
			{
				max = tab[i];
				index = i;
			}
		}
		return index;
	}
}
