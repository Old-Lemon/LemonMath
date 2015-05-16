package lemon.engine.math;

public class ProjectionMatrix {
	private ProjectionMatrix(){}
	public static Matrix getPerspective(float fov, float aspect, float zNear, float zFar) { 
		Matrix matrix = new Matrix(4);
		float yScale = (float) (1/Math.tan(Math.toRadians(fov/2)));
		float xScale = yScale/aspect;
		matrix.set(0, 0, xScale);
		matrix.set(1, 1, yScale);
		matrix.set(2, 2, -(zNear+zFar)/(zFar-zNear));
		matrix.set(2, 3, (-2*zNear*zFar)/(zFar-zNear));
		matrix.set(3, 2, -1);
		matrix.set(3, 3, 0);
		return matrix;
	}
}
