/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matematik;

import static matematik.Cebir.cos;
import static matematik.Cebir.sin;
/**
 *
 * @author kayra
 */
public class MatriksIslem {

    private static boolean ucBoyutMu;
    public double[][] ROTASYON_Z,ROTASYON_X,ROTASYON_Y;
    
    public MatriksIslem(double aci){
        ROTASYON_Z = new double[][]{
            { cos(aci), -sin(aci), 0},
            { sin(aci),  cos(aci), 0},
            {0, 0, 1}
        };
        ROTASYON_X = new double[][]{
            {1, 0, 0},
            {0, cos(aci), -sin(aci)},
            {0, sin(aci),  cos(aci)}
        };
        ROTASYON_Y = new double[][]{		
            { cos(aci), 0, -sin(aci)},
            {0, 1, 0},
            { sin(aci), 0, cos(aci)}			
        };
    }
    
    public static double[][] vecToMatrix(Vektor v){
        double[][] m = null;
        
        if (v.boyut() == 3){
            m = new double[3][1];
            
            m[0][0] = v.x;
            m[1][0] = v.y;
            m[2][0] = v.z;
            
        }
        if (v.boyut() == 2){
            m = new double[2][1];

            m[0][0] = v.x;
            m[1][0] = v.y;
        }
        if (v.boyut() == 1){
            m = new double[1][1];

            m[0][0] = v.x;
        }
        
        return m;
    }
    
    public static String matriksYazdir(double[][] matriks){
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
            
    public static Vektor matrixToVec(double[][] matriks){
        Vektor vektor = new Vektor();
        if(!ucBoyutMu){
            vektor.x = matriks[0][0];
            if (matriks.length > 1){
                vektor.y = matriks[1][0];
            }
            if (matriks.length > 2){
                vektor.z = matriks[2][0];
            }
        }
        return vektor;
    }
    public static Vektor matriksCarpim(double[][] a, Vektor b){
        double[][] m = vecToMatrix(b);
        return matrixToVec(matriksCarpim(a,m));
    }
    
    public static Vektor matriksToplam(double[][] a, Vektor b){
        ucBoyutMu = false;
        double[][] m = vecToMatrix(b);
        return matrixToVec(matriksToplam(a,m));
    }
    
    public static Vektor matriksCikarma(double[][] a, Vektor b){
        ucBoyutMu = false;
        double[][] m = vecToMatrix(b);
        return matrixToVec(matriksCikarma(a,m));
    }
    
    public static double[][] matriksCikarma(double[][] a, double[][] b){
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
    
    public static double[][] matriksToplam(double[][] a, double[][] b){
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
    public static double[][] matriksCarpim(double[][] a, double[][] b){
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
