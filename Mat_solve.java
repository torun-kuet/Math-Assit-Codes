package com.torunarea.math_assist;
public class Mat_solve {


    public float two(float[][] a)
    {
        return a[0][0]*a[1][1]-a[0][1]*a[1][0];
    }
    public float three(float[][] a)
    {
        float sum=0;
        for(int i=0;i<3;i++)
        {
            sum=sum+(float)(Math.pow(-1,i))*a[0][i]*two(arraymade(a,0,i,3));
        }
        return sum;
    }
    public float five(float [][]a)
    {
        float sum=0;
        for(int i=0;i<a.length;i++)
        {
            sum=sum+(float)(Math.pow(-1,i))*a[0][i]*four(arraymade(a,0,i,a.length));
        }
        return sum;
    }
    public float four(float[][] a)
    {
        float sum=0;
        for(int i=0;i<a.length;i++)
        {
            sum=sum+(float)(Math.pow(-1,i))*a[0][i]*three(arraymade(a,0,i,a.length));
        }
        return sum;
    }

    public float[][] add(float[][]a,float[][]b)
    {
        int row =a.length;
        int column=a[0].length;
        float [][]c=new float[row][column];
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                c[i][j]=a[i][j]+b[i][j];

            }
        }

        return c;

    }
    public float[][] sub(float[][]a,float[][]b)
    {
        int row =a.length;
        int column=b.length;
        float [][]c=new float[row][column];
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                c[i][j]=a[i][j]-b[i][j];

            }
        }

        return c;

    }
    public float[][] mul(float[][]a,float[][]b) {
        int acol = a[0].length;
        int brow = b.length;
        int arow = a.length;
        int bcol = b[0].length;

        float [][]c=new float[arow][bcol];

        for (int k = 0; k < bcol; k++) {
            for (int i = 0; i < arow; i++) {
                float sum = 0;

                for (int j = 0; j < acol; j++) {
                   sum+=a[i][j]*b[j][k];

                }

                c[i][k]=sum;

            }

        }

        return c;
    }

    public float [][]trans(float [][]a)
    {
        float[][]b=new float[a.length][a[0].length];
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a[0].length;j++)
            {
                b[j][i]=a[i][j];
            }
        }


        return b;
    }

    public float[][] coeff3(float[][] a)
    {
        float[][]b=new float[a.length][a[0].length];

        for(int i=0;i<a.length;i++)
        {

            for(int j=0;j<a[0].length;j++)
            {
                b[i][j]=(float)(Math.pow(-1,i+j)*two(arraymade(a,i,j,3)));

            }
        }
        return b;
    }
    public float[][] coeff4(float[][] a)
    {
        float[][]b=new float[a.length][a[0].length];

        for(int i=0;i<a.length;i++)
        {

            for(int j=0;j<a[0].length;j++)
            {
                b[i][j]=(float)(Math.pow(-1,i+j)*three(arraymade(a,i,j,3)));

            }
        }
        return b;
    }
    public float[][] coeff5(float[][] a)
    {
        float[][]b=new float[a.length][a[0].length];

        for(int i=0;i<a.length;i++)
        {

            for(int j=0;j<a[0].length;j++)
            {
                b[i][j]=(float)(Math.pow(-1,i+j)*four(arraymade(a,i,j,3)));

            }
        }
        return b;
    }


    private float[][] div(float [][]a,float k)
    {
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a[0].length;j++)
            {
                a[i][j]=a[i][j]/k;
            }
        }
        return a;

    }




    private float [][] arraymade (float[][] array,int r,int c,int n)
    {
        float[][] narray=new float[n-1][n-1];
        int t1=0;
        for(int i=0;i<array.length;i++)
        {

            int t2=0;

            for(int j=0;j<array.length;j++)
            {

                if((i!=r)&&(j!=c))
                {

                    narray[t1][t2]=array[i][j];
                    t2++;

                }

            }
            if(i!=r)
            {
                t1++;
            }

        }
        return narray;

    }
    public float [][]inv3(float [][]a)
    {
       return div(trans(coeff3(a)),three(a));
    }
    public float [][]inv4(float [][]a)
    {
        return div(trans(coeff3(a)),four(a));
    }
    public float [][]inv5(float [][]a)
    {
        return div(trans(coeff3(a)),five(a));
    }


}
