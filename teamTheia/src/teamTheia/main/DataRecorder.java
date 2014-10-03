package teamTheia.main;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

import com.theeyetribe.client.GazeManager;
import com.theeyetribe.client.IGazeListener;
import com.theeyetribe.client.data.GazeData;

public class DataRecorder implements IGazeListener{
	private Queue recorded_data;
	private PrintWriter out;
	
	public DataRecorder(String filename) {
		recorded_data = new LinkedList();
		try {
			out = new PrintWriter(filename);
		} catch (Exception e) {
			System.out.println("open file error");
		}
	}
	
	@Override
    public void onGazeUpdate(GazeData gazeData)
    {
		String raw_x = String.valueOf(gazeData.rawCoordinates.x);
		String raw_y = String.valueOf(gazeData.rawCoordinates.y);
		String smooth_x = String.valueOf(gazeData.smoothedCoordinates.x);
		String smooth_y = String.valueOf(gazeData.smoothedCoordinates.y);
		String raw_x_l = String.valueOf(gazeData.leftEye.rawCoordinates.x);
		String raw_y_l = String.valueOf(gazeData.leftEye.rawCoordinates.y);
		String raw_x_r = String.valueOf(gazeData.rightEye.rawCoordinates.x);
		String raw_y_r = String.valueOf(gazeData.rightEye.rawCoordinates.y);
		String smooth_x_l = String.valueOf(gazeData.leftEye.smoothedCoordinates.x);
		String smooth_y_l = String.valueOf(gazeData.leftEye.smoothedCoordinates.y);
		String smooth_x_r = String.valueOf(gazeData.rightEye.smoothedCoordinates.x);
		String smooth_y_r = String.valueOf(gazeData.rightEye.smoothedCoordinates.y);
		String time_stamp = gazeData.timeStampString;
		
		
		out.println(raw_x + "," + raw_y + "," + smooth_x + "," + smooth_y + "," + 
					raw_x_l + "," + raw_y_l + "," + raw_x_r + "," + raw_y_r + "," + 
					smooth_x_l + "," + smooth_y_l + "," + smooth_x_r + "," + smooth_y_r + "," + time_stamp);
		
    }

}
