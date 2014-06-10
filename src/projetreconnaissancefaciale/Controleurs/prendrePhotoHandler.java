package projetreconnaissancefaciale.Controleurs;

import com.googlecode.javacv.OpenCVFrameGrabber;
import com.googlecode.javacv.cpp.opencv_core;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import static com.googlecode.javacv.cpp.opencv_core.cvFlip;
import static com.googlecode.javacv.cpp.opencv_highgui.cvSaveImage;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Perraudeau
 */
/**
 * Thread pour la webcam
 *
 * @author
 */
public class prendrePhotoHandler implements Runnable {

    private final JLabel label;
    private static boolean running = false;

    public prendrePhotoHandler(JLabel jl) {
        label = jl;
    }

    @Override
    public void run() {

        try {

            OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
            grabber.setImageWidth(label.getWidth());
            grabber.setImageHeight(label.getHeight());
            grabber.start();

            while (running) {
                IplImage img = grabber.grab();
                cvFlip(img, img, 1);
                label.setIcon(new ImageIcon(img.getBufferedImage()));
            }
            grabber.stop();
            grabber.release();
        } catch (Exception ex) {
        }
    }

    //Demarre le thread 
    public void start() {
        new Thread(this).start();
        running = true;
    }

    //Arrete le thread
    public void stop() {
        running = false;
    }

    /**
     * sauvegarde la photo
     *
     * @param user
     */
    public static void sauvegardePhoto(String user) {
        String file = "img/userFace/User_" + user + ".jpg";
        try {
            final OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
            try {
                grabber.start();
                opencv_core.IplImage img = grabber.grab();
                cvSaveImage(file, img);
                //Detection of the face
                String s[] = {file, user};
                FaceDetection.main(s);
                grabber.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
            File fileD = new File(file);
        } catch (Exception e) {
        }
    }

    /**
     * check if the user photo exist or not.
     *
     * @param user
     * @return true if the file exist however false.
     */
    public static boolean verificationPhoto(String user) {
        File f = new File("img/userFace/User_" + user + ".jpg");
        boolean value = true;
        if (f.exists()) {
            value = false;
        } else {
            value = true;
        }
        return value;
    }

    /**
     * delete a user photo.
     *
     * @param user
     */
    public static void supprimerPhoto(String user) {
        File f = new File("img/userFace/User_" + user + ".jpg");
        f.delete();
    }

}
