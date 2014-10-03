package teamTheia.main;

import java.util.LinkedList;
import java.util.Queue;

import com.theeyetribe.client.GazeManager;
import com.theeyetribe.client.IGazeListener;
import com.theeyetribe.client.data.GazeData;

public class BoundryChecker implements IGazeListener {
	private final int SMOOTH_COUNTER = 20;
	private int screen_width;
	private int screen_height;
	private Queue<GazeData> gazeDataWindow;
	
	public BoundryChecker(GazeManager gm) {
		screen_height = gm.getScreenResolutionHeight();
		screen_width = gm.getScreenResolutionWidth();
		gazeDataWindow = new LinkedList<GazeData>();
	}
	
	public boolean boundry_check(GazeData gazeData) {
		if (gazeDataWindow.size() >= SMOOTH_COUNTER) {
			int sum_x = 0;
			int sum_y = 0;
			int n = gazeDataWindow.size();
			for (int i=0; i<n; i++) {
				sum_x += ((LinkedList<GazeData>) gazeDataWindow).get(i).smoothedCoordinates.x;
				sum_y += ((LinkedList<GazeData>) gazeDataWindow).get(i).smoothedCoordinates.y;
			}
			
			gazeDataWindow.clear();
			if (sum_x / n < 0.1 * screen_width || 
				sum_x / n > 0.9 * screen_width || 
				sum_y / n < 0.1 * screen_height || 
				sum_y / n > 0.9 * screen_height){
				System.out.println(sum_x / n);
				System.out.println(sum_y / n);
				return true;
			}			
		} else {
			gazeDataWindow.add(gazeData);
		}
		return false;
	}

	@Override
	public void onGazeUpdate(GazeData gazeData) {
		if (boundry_check(gazeData)) {
			System.out.println("True");
		}
	}
}
