package com.nighthawk.spring_portfolio.mvc.fibonacci;

public class MatrixExponentiation extends Fibonacci {
    @Override
    protected long performCalculation(Integer n) {
		this.name = "Matrix Exponentiation";
        return findTheNthTerm(n);
    }

    private void multiply(int a[][], int b[][]) {
		int mul[][] = new int[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				mul[i][j] = 0;
				for (int k = 0; k < 3; k++)
					mul[i][j] += a[i][k]
								* b[k][j];
			}
		}

		for (int i=0; i<3; i++)
			for (int j=0; j<3; j++)
				// updating matrix
				a[i][j] = mul[i][j]; 
	}
	
	// Function to compute F raise to power n-2
	private int power(int F[][], int n) {
		int M[][] = {{1, 1, 1}, {1, 0, 0},
							{0, 1, 0}};
	
		if (n == 1)
			return F[0][0] + F[0][1];
	
		power(F, n / 2);
		multiply(F, F);
	
		if (n%2 != 0)
			multiply(F, M);
	
		// Multiply it with initial values 
		return F[0][0] + F[0][1] ;
	}

    private long findTheNthTerm(Integer n) {
        int F[][] = {{1, 1, 1}, {1, 0, 0}, {0, 1, 0}};
        return power(F, n-2);
    }
}
