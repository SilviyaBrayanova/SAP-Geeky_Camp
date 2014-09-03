package sap2homework;

public class Car {
	private int horsepower;
	private String color;
	private String licensePlate;
	
	public Car(int horsepower, String color, String licensePlate) {
		this.horsepower = horsepower;
		this.color = color;
		this.licensePlate = licensePlate;
	}

	public int getHorsepower() {
		return horsepower;
	}

	public void setHorsepower(int horsepower) {
		this.horsepower = horsepower;
	}

	public String getColor() {
		return color;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return licensePlate;
	}
	
	public static void findGreenCarsUsedByTeachers(Person... people) {
		boolean found = false;
		System.out.println("Green cars driven by teachers:");
		for(Person person:people) {
			if(person instanceof Teacher && person.getCar() != null && person.getCar().getColor().equals("Green")) {
				System.out.println(person.getCar());
				found = true;
			}
		}
		if(!found) {
			System.out.println("No teachers drive a green car :(");
		}
	}
	
	public static void findBMWUsedByParents(Person... people) {
		boolean found = false;
		System.out.println("BMWs driven by parents:");
		for(Person person:people) {
			if(person.hasChild() && person.getCar() instanceof BMW) {
				System.out.println(person.getCar());
				found = true;
			}
		}
		if(!found) {
			System.out.println("People with children don't drive BMWs :(");
		}
	}
}
