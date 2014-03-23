
import static com.googlecode.javacv.cpp.opencv_core.cvFlip;
import static com.googlecode.javacv.cpp.opencv_highgui.cvSaveImage;
import com.googlecode.javacv.CanvasFrame;
import com.googlecode.javacv.FrameGrabber;
import com.googlecode.javacv.VideoInputFrameGrabber;
import com.googlecode.javacv.cpp.opencv_core.IplImage;

public class GrabberShow implements Runnable { 
//final int INTERVAL=1000;///you may use interval
    IplImage image; 
    CanvasFrame canvas = new CanvasFrame("Web Cam"); 
    public GrabberShow() {
        canvas.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
    }
  @Override
  public void run() {
      //0 pour la premiere webcam , 1 pour la suivante
      FrameGrabber grabber = new VideoInputFrameGrabber(0);
      
      int i=0;
      try {
          grabber.start();
          IplImage img;
          while (true) { 
              img = grabber.grab();
              if (img != null) { 
                  
                  cvFlip(img, img, 1);//permet de s'assurer que l'image est dans le bon sens
                  cvSaveImage("img/"+(i++)+"-victor.jpg", img);
                  // show image on window 
                  canvas.showImage(img); 
              } 
            //Thread.sleep(INTERVAL); 
          } 
      } catch (FrameGrabber.Exception e) {
          System.out.println("Erreur de webcam");
          System.exit(0);
      } 
  }

    public static void main(String[] args) {
        GrabberShow gs = new GrabberShow();
        Thread th = new Thread(gs);
        th.start();
    }
}
