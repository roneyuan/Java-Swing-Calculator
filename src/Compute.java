
public class Compute {

	public float firstnumber;
	public float secondnumber;
	
	public Compute(float firstnumber) {
		this.firstnumber = firstnumber;
	}	
	public Compute(float firstnumber, float secondnumber) {
		this.firstnumber = firstnumber;
		this.secondnumber = secondnumber;
	}
	
	
	public Compute add(Compute secondnumber) {
		return new Compute(this.firstnumber + this.secondnumber);
	}
	
	
	public Compute div(Compute secondnumber) {
		return new Compute(this.firstnumber/this.secondnumber);
	}

}
