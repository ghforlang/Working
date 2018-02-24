package picture;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.apache.commons.lang.time.DateFormatUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.util.*;
import java.util.List;

/**
 * @author fanwh
 * @version v1.0
 * @create on 2017/10/14 17:28
 */
public class PictureUtil {
    private static void createImage(String fileLocation, BufferedImage image) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fileLocation);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ImageIO.write(image,"jpeg",bos);
            bos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(null != fos){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void generatePrescriptionGraphic(String path, DataModel model,int width,int height) throws IOException, WriterException {

        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, width, height);
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("宋体", Font.BOLD, 20));

        int imageCharWidth = 0;
        int dx = 100;
        int dy = 40;
        int middleX = width/2;
        BufferedImage logoImage = ImageIO.read(new File("D://tools//picture//test_tittle.jpg"));
        System.out.println(middleX-((int)(logoImage.getWidth()/2)));
        graphics.drawImage(logoImage,middleX-((int)(logoImage.getWidth()/2)),dy/2,null);
        ModelHead head = model.getHead();
        ModelBody body = model.getBody();
        ModelFooter footer = model.getFooter();

        int markLen = 0;
        //标题
        dy+= logoImage.getHeight() + Constants.LINE_DISTANCE_COMMON;
        graphics.setFont(Constants.TITLE_FONT);
        markLen = graphics.getFontMetrics().charsWidth(head.getTitle().toCharArray(),0,head.getTitle().toCharArray().length);
        graphics.drawString(head.getTitle(), middleX - (int)(markLen/2), dy);
        dy += 40;

        //头部
        graphics.setFont(Constants.CONTENT_FONT);
        graphics.drawString(Constants.PRESCRIPTION_CREATED_DATE + DateFormatUtils.format(body.getPrescriptionCreateDate(),"yyyy-MM-dd"),50,dy);
        dy += Constants.LINE_DISTANCE_COMMON;
        graphics.drawString(Constants.PRESCRIPTION_ORDER_NO + body.getPrescriptionOrderNO(),50,dy);
        dy += Constants.LINE_DISTANCE_COMMON;
        graphics.drawString(Constants.DIAGNOSIS_DOCTOR + body.getDoctorName(),50,dy);
        dy += Constants.LINE_DISTANCE_COMMON;
        List<String> strList = strSplit(body.getFirstDiagnosis(),17,17);
        int markLength = graphics.getFontMetrics().charsWidth(Constants.FIRST_DIGAGNOSIS.toCharArray(),0,Constants.FIRST_DIGAGNOSIS.toCharArray().length);
        for (int i=0;i<strList.size();i++) {
            if(i <1){
                graphics.drawString(Constants.FIRST_DIGAGNOSIS + strList.get(i),50,dy);
            }else{
                graphics.drawString(strList.get(i),markLength + 50,dy);
            }
            dy += Constants.LINE_DISTANCE_COMMON;
        }

        //分割线
        graphics.setFont(Constants.HEAD_BODY_LINE);
        graphics.drawLine(50,dy,width-50,dy);

        //药品列表
        dy += Constants.LINE_DISTANCE_COMMON;
        int listNo = 1;
        graphics.setFont(Constants.CONTENT_FONT);
        for(DrugIssue drug : body.getDrugInfos()){
            graphics.drawString(listNo + "." + drug.getDrugStandName(),50,dy);
            dy += Constants.LINE_DISTANCE_COMMON;
            graphics.drawString(drug.getSpecification() + "g*" + drug.getUnitsPerBox() + drug.getUnit() + "          "
                    + drug.getTotal() + drug.getTotalUnit() + "          " + drug.getDoctorAdvice(),70,dy);
            dy += Constants.LINE_DISTANCE_COMMON;
            graphics.drawString(Constants.USEAGE_MARK,70,dy);
            dy += Constants.LINE_DISTANCE_COMMON;
            graphics.drawString(drug.getUsage() + "    " + drug.getDaliyTimes() +
                    "     每次" + drug.getDosagePerTime() + drug.getUnit() + "    用药" + drug.getDrugDays() + "天",70,dy );
            dy += Constants.LINE_DISTANCE_COMMON;
            listNo ++;
        }

        //分割线
        graphics.setFont(Constants.BODY_LINE);
        graphics.drawLine(50,dy,width -50,dy);
        dy += Constants.LINE_DISTANCE_COMMON;

        List<String> adviceStrList = strSplit(body.getSuggestion(),16,21);
        graphics.setFont(Constants.CONTENT_FONT);
        for(int i=0;i<adviceStrList.size();i++){
            if(i == 0){
                graphics.drawString(Constants.SUGGESTION + adviceStrList.get(i),50,dy);
            }else{
                graphics.drawString(adviceStrList.get(i),50,dy);
            }
            dy += Constants.LINE_DISTANCE_COMMON;
        }
        dy += 10;

        //文案
        graphics.setFont(Constants.FOOTER_FONT);
        markLen = graphics.getFontMetrics().charsWidth(Constants.APP_ONLINE_STORE_NAME.toCharArray(),0,Constants.APP_ONLINE_STORE_NAME.toCharArray().length);
        graphics.drawString(Constants.APP_ONLINE_STORE_NAME,middleX-(int)(markLen/2),dy);
        dy += Constants.LINE_DISTANCE_COMMON;

        //药店标记
        markLen = graphics.getFontMetrics().charsWidth(footer.getDrugStoreName().toCharArray(),0,footer.getDrugStoreName().toCharArray().length);
        graphics.drawString(footer.getDrugStoreName(),middleX-(int)(markLen/2),dy);
        dy += Constants.LINE_DISTANCE_COMMON;

        //二维码
        String qrCodeUrl = footer.getQrCodeUrl();
        BufferedImage qrCodeImage = createQrCode(qrCodeUrl,200);
        graphics.drawImage(qrCodeImage,middleX - (int)(qrCodeImage.getWidth()/2),dy,null);

        //文案1
        markLen = graphics.getFontMetrics().charsWidth(footer.getCopyWriting1().toCharArray(),0,footer.getCopyWriting1().toCharArray().length);
        graphics.setFont(Constants.FOOTER_FONT);
        graphics.drawString(footer.getCopyWriting1(),middleX - (int)(markLen/2),dy + 20);

        //文案2
        dy += qrCodeImage.getHeight();
        markLen = graphics.getFontMetrics().charsWidth(footer.getCopyWriting2().toCharArray(),0,footer.getCopyWriting2().toCharArray().length);
        graphics.setFont(Constants.FOOTER_FONT);
        graphics.drawString(footer.getCopyWriting2(),middleX - (int)(markLen/2),dy);

        dy += 30;
        graphics.setFont(Constants.CONTENT_FONT);
        List<String> footerWords = strSplit(footer.getNote(),18,21);
        for(int i=0;i<footerWords.size();i++){
            if(i == 0){
                graphics.drawString(Constants.FOOTER_NOTE + footerWords.get(i),50,dy);
                dy += Constants.LINE_DISTANCE_COMMON;
            }else{
                graphics.drawString(footerWords.get(i),50,dy);
                dy += Constants.LINE_DISTANCE_COMMON;
            }
        }
        createImage(path, image);
    }

    private static List<String> strSplit(String src,int firstLineLength,int otherLineLength){
        List<String> result = new ArrayList<>();
        String subStr = null;
        if(firstLineLength < src.length()){
            subStr = src.substring(0,firstLineLength);
            result.add(subStr);
            for(int i=firstLineLength;i<src.length();i+=otherLineLength){
                if(i + otherLineLength > src.length()){
                    subStr = src.substring(i,src.length());
                }else{
                    subStr = src.substring(i,i + otherLineLength);
                }
                result.add(subStr);
            }
        }else{
            subStr = src.substring(0,src.length());
            result.add(subStr);
        }

        return result;
    }

    private static BufferedImage createQrCode(String content,int size) throws WriterException {
        Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<EncodeHintType, ErrorCorrectionLevel>();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);  // 矫错级别
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        //创建比特矩阵(位矩阵)的QR码编码的字符串
        BitMatrix byteMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, size, size, hintMap);
        // 使BufferedImage勾画QRCode  (matrixWidth 是行二维码像素点)
        int matrixWidth = byteMatrix.getWidth();
        BufferedImage image = new BufferedImage(matrixWidth, matrixWidth, BufferedImage.TYPE_INT_RGB);
        image.createGraphics();
        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, matrixWidth, matrixWidth);
        // 使用比特矩阵画并保存图像
        graphics.setColor(Color.BLACK);
        for (int i = 0; i < matrixWidth; i++) {
            for (int j = 0; j < matrixWidth; j++) {
                if (byteMatrix.get(i, j)) {
                    graphics.fillRect(i, j, 1, 1);
                }
            }
        }
        return image;
    }

    public static void main(String[] args) throws IOException, WriterException {
        long start = System.currentTimeMillis();

        generatePrescriptionGraphic("D://tools//picture//test2.jpg",DataUtils.getDataModel(),400,900);
        System.out.println(System.currentTimeMillis() - start);
//        File file = new File("D://tools//picture//qr.jpg");

//        ImageIO.write(createQrCode("https://www.baidu.com/pan/souotjojoutosl.jsp",200),"jpeg",new FileOutputStream(file));
    }
}
