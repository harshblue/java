package printing;

public enum ColorCartridge {
	red("RED"), blue("BLUE"), green("GREEN");
	
	String name;
	
	ColorCartridge(String name1)
	{
		name=name1;
	}
	
	public String toString()
	{
		return name;
	}

}
