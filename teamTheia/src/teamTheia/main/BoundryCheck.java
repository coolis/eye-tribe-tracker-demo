package teamTheia.main;

import java.util.ArrayList;

import com.theeyetribe.client.GazeManager;
import com.theeyetribe.client.IGazeListener;
import com.theeyetribe.client.data.GazeData;

public class BoundryCheck {
	private static int SMOOTH_COUNTER = 100;
	private int screen_width;
	private int screen_height;
	public static ArrayList<GazeData> gaceDataCollector = new ArrayList<GazeData>();
	
	public BoundryCheck(GazeManager gm) {
		this.screen_height = gm.getScreenResolutionHeight();
		this.screen_width = gm.getScreenResolutionWidth();
	}
	
	public void updateGazePoint(GazeData gazeData) {
		
	}

}
