package testscript;

public class NavigationCommands extends Base {
	public void navigationCode()
	{
		driver.navigate().to("https://www.google.com/");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.navigate().to("https://www.vaned.com/blog/net-listing-real-estate/");
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		
	}

	public static void main(String[] args) {
		NavigationCommands navigationcommands = new NavigationCommands();
		navigationcommands.initialiseBrowser();
		navigationcommands.navigationCode();
		navigationcommands.browserQuit();

  	}

}
