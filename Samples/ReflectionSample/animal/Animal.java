package animal;

public abstract class Animal  implements Eating{
	public static String CATEGORY = "domestic";
	private String name;
	protected abstract String getSound();
	public Animal(String name) {
		this.name = name;
	}
}
