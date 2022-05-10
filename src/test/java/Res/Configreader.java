package res;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.io.File;  


public class Configreader {

    private String filepath;
	private String username;
	private String password;
	private String url;
	private String pgn;

	public Configreader(String filepath) {
        this.filepath=filepath;
		readconfigs();
    }
    
    public void readconfigs(){
		
		try {
			
			List<String> Lines = Files.readAllLines(Paths.get(filepath));
			url=get_value(0,Lines);
			username=get_value(1,Lines);
			password=get_value(2,Lines);
			pgn=get_value(3,Lines);
			File Pgn = new File(pgn);
			pgn=Pgn.getAbsolutePath();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String get_value(Integer index, List<String> Lines)
	{
		String[] splitted=Lines.get(index).split("=");
		return splitted[1];
	}
	
	public String getusername()
	{
		return username;
	}
	
	public String getpassword(){
		return password;
	}
	
	public String getpgn()
	{
		return pgn;
	}
	public String geturl()
	{
		return url;
	}
}
