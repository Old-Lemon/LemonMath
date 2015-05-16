package lemon.engine.math;

public class Location {
	private Vector position;
	private Vector rotation;
	private Vector scale;
	public Location(){
		this(new Vector(), new Vector(), new Vector(1f, 1f, 1f));
	}
	public Location(Vector position, Vector rotation, Vector scale){
		this.position = position;
		this.rotation = rotation;
		this.scale = scale;
	}
	public void setX(float x){
		position.setX(x);
	}
	public float getX(){
		return position.getX();
	}
	public void setY(float y){
		position.setY(y);
	}
	public float getY(){
		return position.getY();
	}
	public void setZ(float z){
		position.setZ(z);
	}
	public float getZ(){
		return position.getZ();
	}
	public void setPitch(float pitch){
		rotation.setX(pitch);
	}
	public float getPitch(){
		return rotation.getX();
	}
	public void setYaw(float yaw){
		rotation.setY(yaw);
	}
	public float getYaw(){
		return rotation.getY();
	}
	public void setRoll(float roll){
		rotation.setZ(roll);
	}
	public float getRoll(){
		return rotation.getZ();
	}
	public Vector getPosition() {
		return position;
	}
	public void setScale(float scale){
		this.scale.setX(scale);
		this.scale.setY(scale);
		this.scale.setZ(scale);
	}
	public void setPosition(Vector position) {
		this.position = position;
	}
	public Vector getRotation() {
		return rotation;
	}
	public void setRotation(Vector rotation) {
		this.rotation = rotation;
	}
	public Vector getScale() {
		return scale;
	}
	public void setScale(Vector scale) {
		this.scale = scale;
	}
}
