package printing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class Printer<T> implements IMachine {

	public String modelNumber="q";
	private boolean isOn;
	private T cartridge;
	private String textToPrint;
	//private List<Page> pages= new ArrayList<Page>();
	private Map<Integer,Page> pagesMap = new HashMap<Integer,Page>();
	
	@PrintingDevice(defaultPrintMethode="print",defaultCopies=5)
	public Printer(boolean isOn1,String modelNumber1,T cartridge)
	{
		new Machine(isOn1);
		modelNumber=modelNumber1;
		this.cartridge=cartridge;
	}
	
	public String print(int copies){
		if (copies<0)
			throw new IllegalArgumentException("cannot print negative copies");  
		textToPrint=getTextFromFile();	
		for(int i=0; i<copies;i++)
		{
			//pages.add(new Page(modelNumber+ " "+ String.valueOf(i)));
			pagesMap.put(Integer.valueOf(i),new Page(modelNumber+ " "+ String.valueOf(i)) );
			if(isOn)
			{
				System.out.println(textToPrint);
			}
		}
		return textToPrint;

	}
	
	@Deprecated
	private String getTextFromFile() {
		FileReader reader = null;
		String allText="";
		CapitalReader capReader =null;
		try {
			reader = new FileReader("/Users/sree/Documents/Java/helloworld/src/printing/sampletext.txt");
			BufferedReader bReader = new BufferedReader(reader);
			capReader= new CapitalReader(bReader);
			String line="";
			try {
				while((line=capReader.readLine())!=null)
				{
					allText+=line;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(reader !=null)
				try {
					capReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
		}
		return allText;
	}

	public void outputPageNumber(Integer i)
	{
		System.out.println(pagesMap.get(i).getText());
		
	}
	
	public <U> void printWithCartridge(U cat1, String message){
		System.out.println(cat1.toString());
		System.out.println(message);
	} 
	
	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		isOn=true;
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		isOn=false;
	}
	
	public T getCatridge(){
		return cartridge;
	}

}
