import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeInTimeZones {
	public static void main(String[] args) {
		
        // GMT (Greenwich Mean Time)
		ZonedDateTime gmt = ZonedDateTime.now(ZoneId.of("GMT"));
		
        // IST (Indian Standard Time)
		ZonedDateTime ist = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
		
        // PST (Pacific Standard Time)
		ZonedDateTime pst = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
		
		System.out.println("Time as per gmt : " + gmt);
		System.out.println("Time as per ist : " + ist);
		System.out.println("Time as per pst : " + pst);
	}
}
