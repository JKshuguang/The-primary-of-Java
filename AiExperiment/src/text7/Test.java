package text7;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Test {

    public static void main(String[] args) throws IOException {
        //read Sample.txt
        Sample[] sam = new Sample[25];
        int w = 0;
                
        long filePoint = 0;
        String s;
        RandomAccessFile file = new RandomAccessFile("resource//LinearSample.txt", "r");
        long fileLength = file.length();
                
        while(filePoint < fileLength) {
            s = file.readLine();
            //s --> sample
            String[] sub = s.split(" ");
           
            sam[w] = new Sample(sub.length);
            for(int i = 0; i < sub.length; i++) {
                if(i == sub.length - 1) {
                    sam[w].value = Double.parseDouble(sub[i]);
                }
                else {
                    sam[w].features[i] = Double.parseDouble(sub[i]);
                }
            }//for
            w++;
            filePoint = file.getFilePointer();
        }//while read file
        
        LinearRegression lr = new LinearRegression();
        double[] para = {0,0,0,0,0};
        double rate = 0.5;
        double th = 0.001;
        lr.Initialize(sam, w);
        lr.setPara(para, rate, th);
        lr.Update();
        lr.OutputTheta();
    }
    
}