package picture.util;

public class PictureError extends Exception {
	private static final long serialVersionUID = 1L;
	
	public String errorMessage;
	 
    public PictureError(String errorMessage)
    {
         this.errorMessage = errorMessage;
    }
 
    public String toString()
    {
         return errorMessage;
    }
 
    public String getMessage()
    {
         return errorMessage;
    }
}
