package testscript;


public class BrowserCommands extends Base {
	public void browserCommands()
	{
		String title=driver.getTitle();
	}


	public static void main(String[] args) {
		BrowserCommands browsercommands=new BrowserCommands();
		browsercommands.initialiseBrowser();
		browsercommands.browserCommands();
		browsercommands.browserQuit();

	}

}
