package lemon.engine.math;

import java.nio.FloatBuffer;
import java.util.Arrays;

import org.lwjgl.BufferUtils;

public class Matrix {
	private float[][] matrix;
	public Matrix(int rows, int columns){
		matrix = new float[rows][columns];
	}
	public Matrix(int size){
		this(size, size);
	}
	public void set(int row, int column, float value){
		matrix[row][column] = value;
	}
	public float get(int row, int column){
		return matrix[row][column];
	}
	public int getRows(){
		return matrix.length;
	}
	public int getColumns(){
		return matrix[0].length;
	}
	public FloatBuffer toFloatBuffer(){
		FloatBuffer buffer = BufferUtils.createFloatBuffer(16);
		for(int j=0;j<getColumns();++j){
			for(int i=0;i<getRows();++i){
				buffer.put(get(i, j));
			}
		}
		buffer.flip();
		return buffer;
	}
	public Matrix multiply(Matrix matrix){
		if(getColumns()!=matrix.getRows()){
			throw new IllegalArgumentException("You cannot multiply "+getRows()+" x "+getColumns()+" by "+matrix.getRows()+" x "+matrix.getColumns());
		}
		Matrix product = new Matrix(getRows(), matrix.getColumns());
		for(int i=0;i<getRows();++i){
			for(int j=0;j<matrix.getColumns();++j){
				float sum = 0;
				for(int k=0;k<matrix.getRows();++k){
					sum+=get(i, k)*matrix.get(k, j);
				}
				product.set(i, j, sum);
			}
		}
		return product;
	}
	public static Matrix getIdentity(int size){
		Matrix matrix = new Matrix(size);
		for(int i=0;i<size;++i){
			matrix.set(i, i, 1);
		}
		return matrix;
	}
	public String toString(){
		return Arrays.deepToString(matrix);
	}
}
