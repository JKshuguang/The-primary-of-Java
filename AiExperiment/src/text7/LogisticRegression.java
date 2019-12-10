package text7;

public class LogisticRegression extends Regression{

    public double PreVal(Sample s) {
        double val = 0;
        for(int i = 0; i < paraNum; i++) {
            val += theta[i] * s.features[i];
        }
        return 1/(1 + Math.pow(Math.E, -val));
    }

    public double CostFun() {
        double sum = 0;
        for(int i = 0; i < samNum; i++) {
            double p = PreVal(sam[i]);
            double d = Math.log(p) * sam[i].label + (1 - sam[i].label) * Math.log(1 - p);
            sum += d;
        }
        return -1 * (sum / samNum);
    }
    
    public void Update() {
         double former = 0; // the cost before update
         double latter = CostFun(); // the cost after update
         double d = 0;
         double[] p = new double[paraNum];
         do {
             former = latter;
             //update theta
             for(int i = 0; i < paraNum; i++) {
                 // for theta[i]
                double d1 = 0;
                for(int j = 0; j < samNum; j++) {
                     d1 += (PreVal(sam[j]) - sam[j].value) * sam[j].features[i];
                 }
                 p[i] -= (rate * d1) / samNum;
             }
             latter = CostFun();

             if(former - latter < 0){
            	 System.out.println("¦Á is larger!!!");
            	 	break;
             }
         }while(former - latter > th);
         theta = p;
    }
}