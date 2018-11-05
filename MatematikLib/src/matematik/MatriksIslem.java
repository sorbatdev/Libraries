/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matematik;

/**
 *
 * @author kayra
 */
public class MatriksIslem {
    private boolean ucBoyutMu;
    
    public double[][] vecToMatrix(Vektor v){
        double[][] m = new double[3][1];
        
        m[0][0] = v.x;
        m[1][0] = v.y;
        m[2][0] = v.z;
        
        return m;
    }
    
    public String matriksYazdir(double[][] matriks){
        int sutun = matriks[0].length;
        int satir = matriks.length;
        System.out.println(satir + "x" + sutun);
        System.out.println("---------------");
        for(int i = 0; i < satir; i++){
            for(int j = 0; j < sutun ; j++){
                System.out.println(matriks[i][j] + " ");
            }
        }
        return null;
    }
            
    public Vektor matrixToVec(double[][] matriks){
        Vektor vektor = new Vektor();
        if (!ucBoyutMu){
            vektor.x = matriks[0][0];
            vektor.y = matriks[1][0];
            if (matriks.length > 2){
                vektor.z = matriks[2][0];
            }
        }else {
        }
        return vektor;
    }
    public Vektor matriksCarpim(double[][] a, Vektor b){
        double[][] m = vecToMatrix(b);
        return matrixToVec(matriksCarpim(a,m));
    }
    
    public Vektor matriksToplam(double[][] a, Vektor b){
        ucBoyutMu = false;
        double[][] m = vecToMatrix(b);
        return matrixToVec(matriksToplam(a,m));
    }
    
    public Vektor matriksCikarma(double[][] a, Vektor b){
        ucBoyutMu = false;
        double[][] m = vecToMatrix(b);
        return matrixToVec(matriksCikarma(a,m));
    }
    
    public double[][] matriksCikarma(double[][] a, double[][] b){
        int sutunA = a[0].length;
        int satirA = a.length;
        int sutunB = b[0].length;
        int satirB = b.length;
        
        double sonuc[][] = new double[satirA][sutunA];
        
        if (sutunA == sutunB && satirA == satirB){
            for (int i = 0; i < satirA; i++) {
                for (int j = 0; j < sutunB; j++) {
                    sonuc[i][j] = -a[i][j] + b[i][j];
                }
            }
            
        }else{
           System.out.println("Matris boyutları aynı değil!!");
           return null; 
        }
        return sonuc;
    }
    public double[][] matriksToplam(double[][] a, double[][] b){
        int sutunA = a[0].length;
        int satirA = a.length;
        int sutunB = b[0].length;
        int satirB = b.length;
        
        double sonuc[][] = new double[satirA][sutunA];
        
        if (sutunA == sutunB && satirA == satirB){
            for (int i = 0; i < satirA; i++) {
                for (int j = 0; j < sutunB; j++) {
                    sonuc[i][j] = a[i][j] + b[i][j];
                }
            }
            
        }else{
           System.out.println("Matris boyutları aynı değil!!");
           return null; 
        }
        return sonuc;

    }
    public double[][] matriksCarpim(double[][] a, double[][] b){
        int sutunA = a[0].length;
        int satirA = a.length;
        int sutunB = b[0].length;
        int satirB = b.length;
        
        double sonuc[][] = new double[satirA][sutunB];
        
        if (sutunA != satirB){
            System.out.println("Ön matriksin sütunları ile art matriksin satırları eşit değil!!");
            return null;
        }else{
            for (int i = 0; i < satirA; i++) {
                for (int j = 0; j < sutunB; j++) {
                    double satirToplam = 0;
                    for (int k = 0; k < sutunA; k++) {
                        satirToplam += a[i][k] * b[k][j];
                    }
                    sonuc[i][j] = satirToplam;
                }
            }
        }
        return sonuc;
    }  
}
