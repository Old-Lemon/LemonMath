package lemon.engine.math;

public class TransformationMatrix {
	public static Matrix getTranslation(Vector vector){
		Matrix matrix = Matrix.getIdentity(4);
		matrix.set(0, 3, vector.getX());
		matrix.set(1, 3, vector.getY());
		matrix.set(2, 3, vector.getZ());
		return matrix;
	}
	public static Matrix getRotation(Vector vector){
		Matrix matrix = getRotationX(vector.getX());
		matrix = matrix.multiply(getRotationY(vector.getY()));
		matrix = matrix.multiply(getRotationZ(vector.getZ()));
		return matrix;
	}
	public static Matrix getRotationX(float angle){
		Matrix matrix = Matrix.getIdentity(4);
		float cos = (float) Math.cos(Math.toRadians(angle));
		float sin = (float) Math.sin(Math.toRadians(angle));
		matrix.set(1, 1, cos);
		matrix.set(2, 1, sin);
		matrix.set(1, 2, -sin);
		matrix.set(2, 2, cos);
		return matrix;
	}
	public static Matrix getRotationY(float angle){
		Matrix matrix = Matrix.getIdentity(4);
		float cos = (float) Math.cos(Math.toRadians(angle));
		float sin = (float) Math.sin(Math.toRadians(angle));
		matrix.set(0, 0, cos);
		matrix.set(2, 0, -sin);
		matrix.set(0, 2, sin);
		matrix.set(2, 2, cos);
		return matrix;
	}
	public static Matrix getRotationZ(float angle){
		Matrix matrix = Matrix.getIdentity(4);
		float cos = (float) Math.cos(Math.toRadians(angle));
		float sin = (float) Math.sin(Math.toRadians(angle));
		matrix.set(0, 0, cos);
		matrix.set(0, 1, sin);
		matrix.set(1, 0, -sin);
		matrix.set(1, 1, cos);
		return matrix;
	}
	public static Matrix getScalar(Vector vector){
		Matrix matrix = Matrix.getIdentity(4);
		matrix.set(0, 0, vector.getX());
		matrix.set(1, 1, vector.getY());
		matrix.set(2, 2, vector.getZ());
		return matrix;
	}
	public static Matrix get(Vector translation, Vector rotation, Vector scalar){
		return TransformationMatrix.getTranslation(translation)
				.multiply(TransformationMatrix.getRotation(rotation))
				.multiply(TransformationMatrix.getScalar(scalar));
	}
	public static Matrix get(Vector translation, Vector rotation){
		return TransformationMatrix.getTranslation(translation)
				.multiply(TransformationMatrix.getRotation(rotation));
	}
	public static Matrix get(Location location){
		return get(location.getPosition(), location.getRotation(), location.getScale());
	}
}
