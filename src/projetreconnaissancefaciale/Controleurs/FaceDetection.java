package projetreconnaissancefaciale.Controleurs;

/**
 * @author Perraudeau
 */
import static com.googlecode.javacv.cpp.opencv_core.CV_AA;
import com.googlecode.javacv.cpp.opencv_core.CvMemStorage;
import com.googlecode.javacv.cpp.opencv_core.CvRect;
import com.googlecode.javacv.cpp.opencv_core.CvScalar;
import com.googlecode.javacv.cpp.opencv_core.CvSeq;
import static com.googlecode.javacv.cpp.opencv_core.IPL_DEPTH_8U;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import static com.googlecode.javacv.cpp.opencv_core.cvCopy;
import static com.googlecode.javacv.cpp.opencv_core.cvCreateImage;
import static com.googlecode.javacv.cpp.opencv_core.cvGetSeqElem;
import static com.googlecode.javacv.cpp.opencv_core.cvGetSize;
import static com.googlecode.javacv.cpp.opencv_core.cvLoad;
import static com.googlecode.javacv.cpp.opencv_core.cvPoint;
import static com.googlecode.javacv.cpp.opencv_core.cvRectangle;
import static com.googlecode.javacv.cpp.opencv_core.cvSetImageROI;
import static com.googlecode.javacv.cpp.opencv_core.cvSize;
import static com.googlecode.javacv.cpp.opencv_highgui.cvLoadImage;
import static com.googlecode.javacv.cpp.opencv_highgui.cvSaveImage;
import static com.googlecode.javacv.cpp.opencv_imgproc.CV_BGR2GRAY;
import static com.googlecode.javacv.cpp.opencv_imgproc.cvCvtColor;
import static com.googlecode.javacv.cpp.opencv_imgproc.cvResize;
import com.googlecode.javacv.cpp.opencv_objdetect.CvHaarClassifierCascade;
import static com.googlecode.javacv.cpp.opencv_objdetect.cvHaarDetectObjects;

/**
 * controleur pour la reconnaissance faciale qui permet la creation de cadres
 * autour des visages pour faciliter la reconnaissance
 *
 */
public class FaceDetection {

    // le fichier de detection Cascade utilise 
    private static final String CASCADE_FILE = "img/haarcascade_frontalface_alt.xml";

    public static void main(String[] args) throws Exception {

        // Chargement de l'image de base
        IplImage originalImage = cvLoadImage(args[0], 1);

        // On crée une "grayscale image" pour la reconnaissance.
        IplImage grayImage = IplImage.create(originalImage.width(),
                originalImage.height(), IPL_DEPTH_8U, 1);

        // On convertie l'image de base en "grayscale image"
        cvCvtColor(originalImage, grayImage, CV_BGR2GRAY);

        CvMemStorage storage = CvMemStorage.create();

        // On utilise le fichier de detection Cascade
        CvHaarClassifierCascade cascade = new CvHaarClassifierCascade(
                cvLoad(CASCADE_FILE));

        // Detection des visages
        CvSeq faces = cvHaarDetectObjects(grayImage, cascade, storage, 1.1, 1, 0);

        //On cree des carres autour des tetes
        for (int i = 0; i < faces.total(); i++) {
            CvRect r = new CvRect(cvGetSeqElem(faces, i));
            cvRectangle(originalImage, cvPoint(r.x(), r.y()),
                    cvPoint(r.x() + r.width(), r.y() + r.height()), CvScalar.YELLOW, 1, CV_AA, 0);

            //Coupe la photo au niveau des visages 
            cvSetImageROI(originalImage, r);
            IplImage cropped = cvCreateImage(cvGetSize(originalImage), originalImage.depth(), originalImage.nChannels());
            cvCopy(originalImage, cropped);

            //Redimensionnement
            IplImage destination = cvCreateImage(cvSize(160, 160), originalImage.depth(), originalImage.nChannels());
            cvResize(originalImage, destination);
            //On sauvegarde l'image dans un nouveau fichier
            cvSaveImage("img/trainingFace/User_Detection_" + args[1] + "_" + System.currentTimeMillis() + ".jpg", destination);
        }

    }
}
