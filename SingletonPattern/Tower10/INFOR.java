package Tower10;

import org.example.Logger;

public class INFOR {
    Logger logger=Logger.getInstance();
    public  void log(String message)
    {
        logger.log("INFOR:"+message);
    }
}
