package com.epam.tat.matrixprocessor.impl;

import com.epam.tat.matrixprocessor.IMatrixProcessor;
import com.epam.tat.matrixprocessor.exception.MatrixProcessorException;

/**
 * Function Description:
 * Complete the functions below. All methods must work with matrices of the double type.
 *
 * Constraints:
 * 0 < m < 10
 * 0 < n < 10
 * where m - number of rows in matrix
 * where n - number of columns in matrix
 *
 * In case of incorrect input values or inability to perform a calculation, the method should throw an appropriate
 * exception.
 *
 */
public class MatrixProcessor implements IMatrixProcessor {

	/**
	 * Matrix transpose is an operation on a matrix where its rows become columns with the same numbers.
	 * Ex.:
	 * |1 2|			|1 3 5|
	 * |3 4|   ====>	|2 4 6|
	 * |5 6|
	 *
	 * @param matrix - matrix for transposition
	 * @return the transposed matrix
	 */
	@Override
	public double[][] transpose(double[][] matrix) {
		if (matrix == null){
			throw new MatrixProcessorException();
		}else if(matrix.length == 0){
			throw new MatrixProcessorException();
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix.length == 2) {
					for (int g = 0; g < matrix.length; g++) {
						for (int h = 0; h < matrix[i].length; h++) {
							int temp = (int) matrix[g][h];
							matrix[g][h] = matrix[h][g];
							matrix[h][g] = temp;
						}
						return matrix;
					}
				} else if (matrix.length <= 1) {
					double[][] a_new = new double[matrix[i].length][matrix.length];
					for (int g = 0; g < matrix.length; g++) {
						for (int h = 0; h < matrix[i].length; h++) {
							a_new[h][g] = matrix[g][h];
						}
					}
					return a_new;
				} else if (matrix.length != matrix[i].length) {
					double[][] a_new = new double[matrix[i].length][matrix.length];
					for (int g = 0; g < matrix.length - 1; g++) {
						for (int h = 0; h <= matrix[i].length; h++) {
							a_new[g][h] = matrix[h][g];
						}

					}
					return a_new;
				}

			}
		}
		return matrix;
	}


	/**
	 * The method flips the matrix clockwise.
	 * Ex.:
	 * * |1 2|			|5 3 1|
	 * * |3 4|   ====>	|6 4 2|
	 * * |5 6|
	 *
	 * @param matrix - rotation matrix
	 * @return rotated matrix
	 */
	@Override
	public double[][] turnClockwise(double[][] matrix) {
		if (matrix == null){
			throw new MatrixProcessorException();
		}else if(matrix.length == 0){
			throw new MatrixProcessorException();
		}
		for (int i = 0; i < matrix.length; i++) {

			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix.length == 2 && matrix.length != matrix[i].length) {
					for (int g = matrix.length; g >= 0; g--) {
						for (int h = matrix[i].length; h >= 0; h--) {
							int temp = (int) matrix[g][h];
							matrix[g][h] = matrix[h][g];
							matrix[h][g] = temp;
						}
						return matrix;
					}
				} else if (matrix.length == 1) {
					double[][] a_new = new double[matrix[i].length][matrix.length];
					for (int g = 0; g < matrix.length; g++) {
						for (int h = 0; h < matrix[i].length; h++) {
							a_new[h][g] = matrix[g][h];
						}
					}
					return a_new;
				} else if (matrix.length != matrix[i].length) {
					double[][] a_new = new double[matrix[0].length][matrix.length];
					for (int g = 0; g < matrix[0].length; g++) {
						int n = matrix.length - 1;
						for (int h = 0; h < matrix.length; h++, n--) {
							a_new[g][h] = matrix[n][g];
						}
					}
					return a_new;
				} else if (matrix.length == matrix[i].length) {
					double[][] a_new = new double[matrix.length][matrix.length];
					for (int g = 0; g < matrix.length; g++) {
						int n = matrix.length - 1;
						for (int h = 0; h < matrix.length; h++, n--) {
							a_new[g][h] = matrix[n][g];
						}
					}
					return a_new;
				}
			}
		}
			return matrix;
		}



		/**
		 * This method multiplies matrix firstMatrix by matrix secondMatrix
		 *
		 * See {https://en.wikipedia.org/wiki/Matrix_multiplication}
		 *
		 * @param firstMatrix  - first matrix to multiply
		 * @param secondMatrix - second matrix to multiply
		 * @return result matrix
		 */
		@Override
		public double[][] multiplyMatrices ( double[][] firstMatrix, double[][] secondMatrix){
			if (firstMatrix == null | secondMatrix == null){
				throw new MatrixProcessorException();
			}else if(firstMatrix.length == 0 | secondMatrix.length == 0){
				throw new MatrixProcessorException();
			}

			double[][] result = new double[firstMatrix.length][];
			for (int o = 0; o < result.length; o++) result[o] = new double[secondMatrix[0].length];
			for (int i = 0; i < firstMatrix.length; i++) {
				for (int j = 0; j < secondMatrix[i].length; j++) {
					for (int k = 0; k < secondMatrix.length; k++) {
						result[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
						result[i][j] = Math.round(result[i][j] * Math.pow(10, 3)) / Math.pow(10, 3);
					}
				}
			}
			return result;
		}

		/**
		 * This method returns the inverse of the matrix
		 *
		 * See {https://en.wikipedia.org/wiki/Invertible_matrix}
		 *
		 * @param matrix - input matrix
		 * @return inverse matrix for input matrix
		 */
		@Override
		public double[][] getInverseMatrix ( double[][] inputMatrix){
			if (inputMatrix == null){
				throw new MatrixProcessorException();
			}else if(inputMatrix.length == 0){
					throw new MatrixProcessorException();
			}for (int num = 0; num < inputMatrix.length; num++){
				if(inputMatrix[num].length != inputMatrix.length){
					throw new MatrixProcessorException();
				}
			}

			double[][] result = new double[inputMatrix.length][inputMatrix.length];
			for (int i = 0; i < inputMatrix.length; i++)
				for (int j = 0; j < inputMatrix.length; j++) {
					if (i == j)
						result[i][j] = 1;
					else
						result[i][j] = 0;
				}

			double p = 0, q = 0, s = 0;
			for (int i = 0; i < inputMatrix.length; i++) {
				p = inputMatrix[i][i];
				for (int j = i + 1; j < inputMatrix.length; j++) {
					q = inputMatrix[j][i];
					for (int k = 0; k < inputMatrix.length; k++) {
						inputMatrix[j][k] = (double) (inputMatrix[i][k] * q - inputMatrix[j][k] * p);
						result[j][k] = (double) (result[i][k] * q - result[j][k] * p);
						result[j][k] = Math.round(result[j][k] * Math.pow(10, 4)) / Math.pow(10, 3);
					}
				}
			}
			for (int i = 0; i < inputMatrix.length; i++) {
				for (int j = inputMatrix.length - 1; j >= 0; j--) {
					s = 0;
					for (int k = inputMatrix.length - 1; k > j; k--)
						s += inputMatrix[j][k] * result[k][i];
					result[j][i] = (double) ((result[j][i] - s) / inputMatrix[j][j]);
					result[j][i] = Math.round(result[j][i] * Math.pow(10, 3)) / Math.pow(10, 3);
				}
			}
			return result;

		}

		/**
		 * This method returns the determinant of the matrix
		 *
		 * See {https://en.wikipedia.org/wiki/Determinant}
		 *
		 * @param matrix - input matrix
		 * @return determinant of input matrix
		 */
		@Override
		public double getMatrixDeterminant ( double[][] matrix){
			if (matrix == null){
				throw new MatrixProcessorException();
			}else if(matrix.length == 0){
				throw new MatrixProcessorException();
			}for (int num = 0; num < matrix.length; num++){
				if(matrix[num].length != matrix.length){
					throw new MatrixProcessorException();
				}
			}
			int n = matrix.length;
			if(n == 1){
				return matrix[0][0];
			}
			double result = 0;
			double temp[][] = new double[n-1][n-1];
			int l = 1;
			for(int i = 0; i < n; ++i){

				int x = 0, y = 0;
				for(int j = 1; j < n; ++j){
					for(int k = 0; k < n; ++k){
						if(i == k) continue;
						temp[x][y] = matrix[j][k];
						++y;
						if(y == n - 1){
							y = 0;
							++x;
						}
					}
				}
				result += l * matrix[0][i] * getMatrixDeterminant(temp);
				l *= (-1);
			}
			return result;

		}

	}

