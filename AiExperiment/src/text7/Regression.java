package text7;

public abstract class Regression {

    double[] theta; //parameters
    int paraNum; //the number of parameters
    double rate; //learning rate
    Sample[] sam; // samples
    int samNum; // the number of samples
    double th; // threshold value
    
    /**
     * initialize the samples
     * @param s : training set
     * @param num : the number of training samples
     */
    public void Initialize(Sample[] s, int num) {
        samNum = num;
        sam = new Sample[samNum];
        for(int i = 0; i < samNum; i++) {
            sam[i] = s[i];
        }
    }
    
    /**
     * initialize all parameters
     * @param para : theta
     * @param learning_rate 
     * @param threshold 
     */
    public void setPara(double[] para, double learning_rate, double threshold) {
        paraNum = para.length;
        theta = para;
        rate = learning_rate;
        th = threshold;
    }
    
    /**
     * predicte the value of sample s
     * @param s : prediction sample
     * @return : predicted value
     */
    public abstract double PreVal(Sample s);
    
    /**
     * calculate the cost of all samples
     * @return : the cost
     */
    public abstract double CostFun();
    
    /**
     * update the theta
     */
    public abstract void Update();
    
    public void OutputTheta() {
        System.out.println("The parameters are:");
        for(int i = 0; i < paraNum; i++) {
            System.out.print(theta[i] + " ");
        }
        System.out.println(CostFun());
    }
}