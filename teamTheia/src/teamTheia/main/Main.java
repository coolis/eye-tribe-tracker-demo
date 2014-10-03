package teamTheia.main;

import com.theeyetribe.client.GazeManager;
import com.theeyetribe.client.IGazeListener;
import com.theeyetribe.client.GazeManager.ApiVersion;
import com.theeyetribe.client.GazeManager.ClientMode;
import com.theeyetribe.client.data.GazeData;

public class Main
{	
    public static void main(String[] args)
    {
        final GazeManager gm = GazeManager.getInstance();
        boolean success = gm.activate(ApiVersion.VERSION_1_0, ClientMode.PUSH);
        //GazeDataManager gdm = new GazeDataManager(gm);
        //final GazeListener gazeListener = new GazeListener();
        //gm.addGazeListener(gazeListener);
        //DataRecorder dr = new DataRecorder("mark.txt");
        //gm.addGazeListener(dr);    
        BoundryChecker bc = new BoundryChecker(gm);
        gm.addGazeListener(bc);
    }
}
