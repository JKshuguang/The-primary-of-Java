
package text1;

// ������������

// ����������һ���ж��еĿ�ʼ

// ��һ���ж����Ƿ���������

// ���������

// ȫ����iΪ�У�j������

public class BaHuangHouDemo {

    public static void main(String[]args) {

        //�ڷ�ÿ�еĻʺ��������

        //index[0]=0�������һ���ʺ���ڵ�0�С�

        int []index= new int[8];

        //��ʼ��ÿ���ʺ��Ƿ���ڣ��������Ϊ-1����������

        for(int i=0;i<8;i++)

        {

            index[i]=-1;

        }

        //��һ�������ڵ�һ��

        index[0]=0;

        //kΪ����Ѱ�ҵĻʺ�

        int k=1;

        //����8���ʺ�

        while(k<=7){

            int j;

            j=startlie(k,index);

            //���۴���0�Ϳ��ԣ���Ϊ��һ���ʺ�λ��Ϊ0�У����������ʺ�����0��

            if(j>=0){

                index[k]=j;

                k++;

            }

            else

            {

                //Ҫ����ǰ�����ʵĻʺ��λ����1��

                // ���ɣ����統ǰ����Ѱ��k=5�����������ʺ󣬵������ʺ�û�ҵ���ȷλ�ã����ݵ�����ʺ�

                //��ʱ���ܾ��ò��ý��������ʺ��λ����Ϊ-1����Ϊ�����ҵ������ʺ����Ե������ʺ��λ�û��ǳ�ʼ����-1��

                //��������ݵ�����ʺ�Ҳû�ҵ���ȷλ�ã���������ʺ���ŵ�λ��Ϊԭ��λ�ã�

                // ��ʱ������ʺ��λ�þ�Ҫ��Ϊ-1�ˣ�Ȼ����û�ҵ�������ʺ�������Ҫ��û�ҵ��Ļʺ��λ����Ϊ-1.

               index[k]=-1;

                k--;

                //

            }

        }

        for(int i=0;i<8;i++)

        {

            index[i]=index[i]*2+1;

            //System.out.print(index[i]);

        }

        pp(index);

    }

    public static int startlie(int k,int index[]){

 

        //�����˻��ݵ��뷨�������ʱ�����ĵ�k�еĻʺ������Ϊ-1

        //����ûʺ󲻴��ڣ����ͷ��ʼ�жϣ�

        //�����k�еĻʺ���������˵��֮ǰ����Ĳ���ȷ��

        //���ԴӸ��������һ�н���Ѱ�ҡ�

        int lie;

        if(index[k]==-1)

        {

            lie=0;

        }

        else

            lie=index[k]+1;

        for(int j=lie;j<8;j++)

        {

            if(isvaild(k,j,index))

            {

                return j;

            }

        }

        return -1;

    }

    public static boolean isvaild(int k,int j,int index[])

    {

 

        //jΪ��ǰ�жϵ���

        //�ж��Ƿ���֮ǰ����Щ�ʺ���һ����

        //һֱѰ�ҵ���k-1���ʺ󣬼���һ���ʺ�

        for(int i=0;i<k;i++)

        {

            if(index[i]==j)

            {

                return false;

            }

        }

        //�жϵ�ǰ���Ƿ�����һ���ʺ������б���ϣ�

        // kΪ��ǰѰ�ҵĻʺ󣬹���һ���ʺ�Ϊk-1

        //xo

        //ox

        //��ʱ��ǰ����ǰһ�оͻ����һ���˻ʺ����λ����ͬ

        //xoo

        //ooo

        //oox

        //��ʱ����ǰ����ȥ�Ƚ�����һ���˻ʺ�

        for (int lie=j-1,hang=k-1;lie>=0&&hang>=0;lie--,hang-- )

        {

            if(index[hang]==lie) {

                return false;

            }

        }

        //�жϵ�ǰ���Ƿ�����һ���ʺ������б���ϣ�

        //ox

        //xo

        //��ǰ�����һ�У��ͻ�����һ���ʺ�����������

            for (int lie=j+1,hang=k-1;lie>=0&&hang>=0;lie++,hang-- )

            {

                if(index[hang]==lie)

                {

                    return false;

                }

        }

        return true;

    }

    public static void pp(int []index)

    {

        //0��4��7��5��2��6��1��3

        //int[] index ={1,9,15,11,5,13,3,7};

        //int n;

        for(int i=0;i<8;i++) {

            for (int j = 0; j <= 16; j++) {

                if (j % 2 != 0) {

                    if (j == index[i]) {

                        System.out.print("Q");

                    } else

                        System.out.print(" ");

                }

                else if(j%2==0){

                    System.out.print("|");

                }

            }

            System.out.println("");

        }

 

 

    }

}
