package projetreconnaissancefaciale.Controleurs;

import com.googlecode.javacv.cpp.opencv_core.IplImage;
import static com.googlecode.javacv.cpp.opencv_core.cvCreateImage;
import static com.googlecode.javacv.cpp.opencv_highgui.cvLoadImage;
import static com.googlecode.javacv.cpp.opencv_imgproc.CV_COMP_CHISQR;
import static com.googlecode.javacv.cpp.opencv_imgproc.CV_HIST_ARRAY;
import static com.googlecode.javacv.cpp.opencv_imgproc.CV_RGB2GRAY;
import com.googlecode.javacv.cpp.opencv_imgproc.CvHistogram;
import static com.googlecode.javacv.cpp.opencv_imgproc.cvCalcHist;
import static com.googlecode.javacv.cpp.opencv_imgproc.cvCompareHist;
import static com.googlecode.javacv.cpp.opencv_imgproc.cvCreateHist;
import static com.googlecode.javacv.cpp.opencv_imgproc.cvCvtColor;
import static com.googlecode.javacv.cpp.opencv_imgproc.cvGetMinMaxHistValue;
import static com.googlecode.javacv.cpp.opencv_imgproc.cvNormalizeHist;
import java.io.File;

/**
 *
 * @author Victor
 */
public class comparaisonFace {

    public static String matchValue(String userFace) {
        
        File f = new File("img/trainingFace");
        File[] listefichiers=f.listFiles();
        
        double j = 255;
        double h = 0;
        String b = "";
        int i;

        
        for(i=0;i<listefichiers.length;i++){
            String s = listefichiers[i].toString();
            if (s.endsWith(".jpg")){
                IplImage baseImage = cvLoadImage(userFace);
                CvHistogram hist = getHueHistogram(baseImage);
                IplImage contrastImage = cvLoadImage(s);
                CvHistogram hist1 = getHueHistogram(contrastImage);

                h = cvCompareHist(hist, hist1, CV_COMP_CHISQR);
                if(h<j){
                    System.out.println(j);
                    j=h;
                    System.out.println(j);
                    b=s;
                } 
            }
            
        }
       
        return b;
    }
    
    private static CvHistogram getHueHistogram(IplImage image) {
        if (image == null || image.nChannels() < 1) {
            new Exception("Erreur!");
        }
        IplImage greyImage = cvCreateImage(image.cvSize(), image.depth(), 1);
        cvCvtColor(image, greyImage, CV_RGB2GRAY);

//bins and value-range
        int numberOfBins = 256;
        float minRange = 0f;
        float maxRange = 255f;
// Allocate histogram object
        int dims = 1;
        int[] sizes = new int[]{numberOfBins};
        int histType = CV_HIST_ARRAY;
        float[] minMax = new float[]{minRange, maxRange};
        float[][] ranges = new float[][]{minMax};
        int uniform = 1;
        CvHistogram hist = cvCreateHist(dims, sizes, histType, ranges, uniform);
// Compute histogram
        int accumulate = 0;
        IplImage mask = null;
        IplImage[] aux = new IplImage[]{greyImage};

        cvCalcHist(aux, hist, accumulate, null);
        cvNormalizeHist(hist, 1);

        cvGetMinMaxHistValue(hist, minMax, minMax, sizes, sizes);
        return hist;
    }
}
