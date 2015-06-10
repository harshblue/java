package printing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class CapitalReader extends BufferedReader {

	@Override
	public String readLine() throws IOException {
		// TODO Auto-generated method stub
		String line=super.readLine();
		if(line!=null)
			return line.toUpperCase();
		return null;
	}

	public CapitalReader(Reader in) {
		super(in);
		// TODO Auto-generated constructor stub
	}

}
