package projetreconnaissancefaciale.Controleurs;

import com.googlecode.javacv.cpp.opencv_contrib.FaceRecognizer;
import static com.googlecode.javacv.cpp.opencv_contrib.createFisherFaceRecognizer;
import com.googlecode.javacv.cpp.opencv_core;
import static com.googlecode.javacv.cpp.opencv_core.CV_AA;
import static com.googlecode.javacv.cpp.opencv_core.IPL_DEPTH_8U;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_core.MatVector;
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
import static com.googlecode.javacv.cpp.opencv_imgproc.CV_BGR2GRAY;
import static com.googlecode.javacv.cpp.opencv_imgproc.cvCvtColor;
import static com.googlecode.javacv.cpp.opencv_imgproc.cvResize;
import com.googlecode.javacv.cpp.opencv_objdetect;
import static com.googlecode.javacv.cpp.opencv_objdetect.cvHaarDetectObjects;
import java.io.File;
import java.io.FilenameFilter;
import projetreconnaissancefaciale.Modeles.UtilisateurModel;

/**
 *
 * @author Perraudeau
 */
public class OpenCVFaceRecognizer {

    // le fichier de detection Cascade utilise 
    private static final String CASCADE_FILE = "img/haarcascade_frontalface_alt.xml";

    /**
     * Compare une photo avec la base de visage et retourne l'id de
     * l'utilisateur le plus probable
     *
     * @param photo chemin de la photo
     * @return idUser int
     */
    public static int comparaison(String photo) {

        int predictedLabel = 0;
        // Chargement de l'image de base
        System.out.println(photo);
        IplImage originalImage = cvLoadImage(photo, 1);

        // On crée une "grayscale image" pour la reconnaissance.
        IplImage grayImage = IplImage.create(originalImage.width(),
                originalImage.height(), IPL_DEPTH_8U, 1);

        // On convertie l'image de base en "grayscale image"
        cvCvtColor(originalImage, grayImage, CV_BGR2GRAY);

        opencv_core.CvMemStorage storage = opencv_core.CvMemStorage.create();

        // On utilise le fichier de detection Cascade
        opencv_objdetect.CvHaarClassifierCascade cascade = new opencv_objdetect.CvHaarClassifierCascade(
                cvLoad(CASCADE_FILE));

        // Detection des visages
        opencv_core.CvSeq faces = cvHaarDetectObjects(grayImage, cascade, storage, 1.1, 1, 0);

        //On cree des carres autour des tetes
        for (int i = 0; i < faces.total(); i++) {
            opencv_core.CvRect r = new opencv_core.CvRect(cvGetSeqElem(faces, i));
            cvRectangle(originalImage, cvPoint(r.x(), r.y()),
                    cvPoint(r.x() + r.width(), r.y() + r.height()), opencv_core.CvScalar.YELLOW, 1, CV_AA, 0);

            //Coupe la photo au niveau des visages 
            cvSetImageROI(originalImage, r);
            IplImage cropped = cvCreateImage(cvGetSize(originalImage), originalImage.depth(), originalImage.nChannels());
            cvCopy(originalImage, cropped);

            //redimensionnement des photos
            IplImage destination = cvCreateImage(cvSize(160, 160), originalImage.depth(), originalImage.nChannels());
            cvResize(originalImage, destination);

            //base de donnée des visages
            String trainingDir = "img/trainingFace";

            File root = new File(trainingDir);

            /**
             * Filtre pour delimiter seulement la recherche aux jpg
             */
            FilenameFilter jpgFilter = new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(".jpg");
                }
            };

            /**
             * Partie sur la reconnaissance faciale
             */
            File[] imageFiles = root.listFiles(jpgFilter);

            MatVector images = new MatVector(imageFiles.length);

            int[] labels = new int[imageFiles.length];

            int counter = 0;
            int label;

            IplImage img;
            IplImage grayImg;

            //Boucle qui verifie l'image donnée avec chaques images dans la base de donnée
            for (File image : imageFiles) {
                img = cvLoadImage(image.getAbsolutePath());

                //On récupère l'id de l'utilisateur
                String email = image.getName().split("_")[2];
                label = UtilisateurModel.IdGetter(email);

                grayImg = IplImage.create(img.width(), img.height(), IPL_DEPTH_8U, 1);

                cvCvtColor(img, grayImg, CV_BGR2GRAY);

                images.put(counter, grayImg);

                labels[counter] = label;

                counter++;
            }

            IplImage greyTestImage = IplImage.create(destination.width(), destination.height(), IPL_DEPTH_8U, 1);

            //Méthode de reconnaissance FisherFace
            FaceRecognizer faceRecognizer = createFisherFaceRecognizer();
            faceRecognizer.train(images, labels);

            cvCvtColor(destination, greyTestImage, CV_BGR2GRAY);
            //Id probable, si 0 est retourner c'est qu'il n'y a pas de vissage correspondant
            predictedLabel = faceRecognizer.predict(greyTestImage);

        }
        return predictedLabel;
    }

}
