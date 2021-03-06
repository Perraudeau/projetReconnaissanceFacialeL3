package projetreconnaissancefaciale.Controleurs;

import com.googlecode.javacv.OpenCVFrameGrabber;
import com.googlecode.javacv.cpp.opencv_core;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import static com.googlecode.javacv.cpp.opencv_core.cvFlip;
import static com.googlecode.javacv.cpp.opencv_highgui.cvSaveImage;
import projetreconnaissancefaciale.Controleurs.Jsch;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

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
    private final JButton butValider;
    private final JToggleButton butPhoto;
    private static boolean running = false;

    public prendrePhotoHandler(JLabel jl,JButton bt,JToggleButton bt2) {
        label = jl;
        butValider =bt;
        butPhoto=bt2;
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
            label.setText("Vous n'avez pas de webcam ! ");
            butPhoto.setEnabled(false);
            butValider.setEnabled(false);
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
                Jsch jsch = new Jsch();
                jsch.send(file);
                //Detection of the face
                String s[] = {file, user};
                FaceDetection.main(s);
                grabber.stop();
            } catch (Exception e) {
                e.printStackTrace();

            }
            File fileD = new File(file);
        } catch (Exception e) {
            System.out.println("Erreur au niveau de la sauvegarde d'image webcam");
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
