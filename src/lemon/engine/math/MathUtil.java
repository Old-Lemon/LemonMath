package lemon.engine.math;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MathUtil {
	
	private MathUtil() {}

	public static boolean[] convertMods(int bitset) {
		boolean[] mods = new boolean[4];
		if ((bitset & (1 << 0)) == 1) mods[0] = true;
		if ((bitset & (1 << 1)) == 1) mods[1] = true;
		if ((bitset & (1 << 2)) == 1) mods[2] = true;
		if ((bitset & (1 << 3)) == 1) mods[3] = true;
		return mods;
	}
	@Deprecated
	public static float normalize(float x, float max){
		return (((((x+max)%(max*2))+(max*2))%(max*2))-max);
	}
	public static float toRadians(float degrees){
		return (float) Math.toRadians(degrees);
	}
	public static float toDegrees(float radians){
		return (float) Math.toDegrees(radians);
	}
	public static float getIntersection(Vector origin, Vector direction, Vector a, Vector b, Vector c){
		//TODO
	}
	public static void orderByDistance(List<Vector> vectors, final Vector origin){
		Collections.sort(vectors, new Comparator<Vector>(){
			@Override
			public int compare(Vector vector, Vector vector2) {
				float distance = origin.getDistance(vector);
				float distance2 = origin.getDistance(vector2);
				if(distance==distance2){
					return 0;
				}
				return distance>distance2?1:-1;
			}
		});
	}
}
