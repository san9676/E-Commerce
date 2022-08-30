import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class ValidateJavaDate {
	protected String input="";
	protected boolean output;
	
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public boolean getOutput() {
		return output;
	}
	public void setOutput(boolean output) {
		this.output = output;
	}
	
	public void validate() {
		
		    try
		    {
		        LocalDate.parse(input,
                    DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss")
                            .withResolverStyle(ResolverStyle.STRICT)
				);
		        output=true;
		    }
		    
		    catch (DateTimeParseException e)
		    {
		        
		        output=false;
		    }
		   
	}
	

}
