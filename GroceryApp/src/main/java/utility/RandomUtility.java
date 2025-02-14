package utility;

import com.github.javafaker.Faker;

public class RandomUtility {

	public String createNewFakerUserName()
	{
		Faker faker = new Faker();
		String userName = faker.name().fullName();
		return userName;
	}
	
	public long createNewFakerPassword()
	{
		Faker faker = new Faker();
		long password = faker.number().randomNumber();
		return password;
	}
	
	public String createsubCategoryName()
	{
	Faker faker = new Faker();
	String subCategoryname = faker.food().spice();
	return subCategoryname;
	}
	
	public String createCategoryName()
	{
	Faker faker = new Faker();
	String Categoryname = faker.food().spice();
	return Categoryname;
	}
	
	public String CreateNewPhoneNumber()
	{
		Faker faker = new Faker();
		String phoneno = faker.number().digit();
		return phoneno;
	}
	
	public String CreateNewAddress()
	{
		Faker faker = new Faker();
		String address = faker.address().streetAddress();
		return address;
	}
	
	public String CreateNewCityName()
	{
		Faker faker = new Faker();
		String cityName = faker.address().cityName();
		return cityName;
	}


}
