package teamTheia.main;

import java.util.ArrayList;

import com.theeyetribe.client.GazeManager;
import com.theeyetribe.client.data.GazeData;

public class GazeDataManager {
	public static ArrayList<GazeData> gazeDataCollector;
	private final static int SMOOTH_COUNTER = 100;
	private static int screen_width;
	private static int screen_height;
	private static ArrayList<GazeData> gazeDataWindow;
	
	public GazeDataManager(GazeManager gm) {
		screen_height = gm.getScreenResolutionHeight();
		screen_width = gm.getScreenResolutionWidth();
		gazeDataCollector = new ArrayList<GazeData>();
		gazeDataWindow = new ArrayList<GazeData>();
	}
	
	public static boolean boundry_check() {
		if (gazeDataWindow.size() >= SMOOTH_COUNTER) {
			int sum_x = 0;
			int sum_y = 0;
			int n = gazeDataWindow.size();
			for (int i=0; i<n; i++) {
				sum_x += gazeDataWindow.get(i).smoothedCoordinates.x;
				sum_y += gazeDataWindow.get(i).smoothedCoordinates.y;
			}
			if (sum_x / n < 0.2*screen_width || 
				sum_x / n > 0.8*screen_width || 
				sum_y / n < 0.2*screen_height || 
				sum_y / n > 0.8*screen_height){
				gazeDataWindow.clear();
				return true;
			}
				
		}
		gazeDataWindow.add(gazeDataCollector.get(gazeDataCollector.size()-1));
		return false;
	}
}
