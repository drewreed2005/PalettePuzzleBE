package com.nighthawk.spring_portfolio.mvc.fibonacci;

public class MatrixExponentiation extends Fibonacci {
    @Override
    protected long performCalculation(Integer n) {
		this.name = "Matrix Exponentiation";
		
        // base case
        if (n == 0) {
			return 0;
		}
		// creating the base matrix
		long[][] baseMatrix = {{1, 1}, {1, 0}};
		// initializing result matrix to the identity matrix
		long[][] resultMatrix = {{1, 0}, {0, 1}};

		// matrix exponentiation
		while (n > 0) {
			if (n % 2 == 1) {
				resultMatrix = multiplyMatrices(resultMatrix, baseMatrix);
			}
			baseMatrix = multiplyMatrices(baseMatrix, baseMatrix);
			n /= 2;
		}

		// result is in the top right corner of the final matrix
		return resultMatrix[0][1];
	}

	// method to multiply two matrices
	private long[][] multiplyMatrices(long[][] matrix1, long[][] matrix2) {
		int rows1 = matrix1.length;
		int cols1 = matrix1[0].length;
		int cols2 = matrix2[0].length;

		long[][] result = new long[rows1][cols2];
		for (int i = 0; i < rows1; i++) {
			for (int j = 0; j < cols2; j++) {
				for (int k = 0; k < cols1; k++) {
					result[i][j] += matrix1[i][k] * matrix2[k][j];
				}
			}
		}

		return result;
    }
}
