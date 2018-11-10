/*
 * Copyright (c) 2018, Kayra Urfalı
 * Kendi projelerimde daha rahat kullanabilmek için oluşturduğum Cebir kütüphanesidir.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package matematik;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * {@code Cebir} sınıfı, basit sayısal işlemleri gerçekleştirebilmek için yapmış olduğum
 * bir kütüphanedir.
 * 
 * <p>Bu kütüphanenin javanın {@code lang.Math} kütüphanesiyle hiçbir bağlantısı yoktur,
 * tamamen Türkçeleştirebilmek için kurduğum bir kütüphanedir.
 * 
 * @version 1.0
 * @author kayra
 */
public class Cebir {
    
    private Cebir(){}
    
    /**
     * Tanım olarak <b><i>double</i></b> değerinde olan PI sayısı modern tanıma göre,
     * dairenin çevresinin çapına bölümüdür. 
     * {@code Ç/R}
     */
    public static final double PI = 3.14159265358979323846;
    
    /**
     * Tanım olarak <b><i>double</i></b> değerinde olan E sayısı modern tanıma göre,
     * doğal logaritmanın tabanıdır. 
     */
    public static final double E = 2.7182818284590452354;

    /**
     * Tanım olarak <b><i>double</i></b> değerinde olan TAU sayısı Euler'in tanımına göre,
     * dairenin çevresinin yarıçapına bölümüdür. 
     * {@code Ç/r}
     */
    public static final double TAU = 6.28318530717958647692;
    
    /**
     * Girilen açıyı öncelikle metot içinde radyana dönüştürür,
     * daha sonra yaklaşım algoritmasıyla sinüs değerini bulur.
     * 
     * @param aci istenen açı
     * @return o açının sinüs değeri
     */
    public static double sin(double aci){
        double sum = 0d;
        
        double sonuc = 0d;
        
            //Girilen açı burada radyana dönüşür.
            if(aci >= 0)
            {  
                sonuc = ((aci%360)*PI)/180;
            }
            else if(aci < 0){
                sonuc = (((aci%360)+360)*PI)/180;
            }
            
            double radyan = sonuc;
        
            //Taylor serisi
        for (int i = 1; i < 10; i++){
            if(i%2 == 0){
                sum -= us(radyan, 2*i-1)/faktoriyel(2*i-1);
            }
            else if(i%2 == 1){
                sum += us(radyan, 2*i-1)/faktoriyel(2*i-1);
            }
        }
        return sum;
    }
    
    /**
     * Girilen açıyı öncelikle metot içinde radyana dönüştürür,
     * daha sonra yaklaşım algoritmasıyla kosinüs değerini bulur.
     * 
     * @param aci istenen açı
     * @return o açının cosinüs değeri
     */
    public static double cos(double aci){
        double sum = 0d;
        
        double sonuc = 0d;
        
            //Girilen açı burada radyana dönüşür.
            if(aci >= 0)
            {  
                sonuc = ((aci%360)*PI)/180;
            }
            else if(aci < 0){
                sonuc = (((aci%360)+360)*PI)/180;
            }
            
            double radyan = sonuc;
            
            //Taylor serisi
            for (int i = 0; i < 10; i++){
                if(i%2 == 0){
                    sum += us(radyan, 2*i)/faktoriyel(2*i);
                }
                else if(i%2 == 1){
                    sum -= us(radyan, 2*i)/faktoriyel(2*i);
                }
            }
        return sum;
    }
    /**
     * Parametredeki sayının faktöriyelini döndürür. Özel durumlar:
     * <ul>
     * <li>Eğer sayı negatifse null döner.
     * <li>20'den büyük sayıları yanlış gösteriyor.
     * </ul>
     * 
     * @param sayi girilecek sayi, <i>int</i> olarak
     * @return girilen sayının faktöriyeli, <i>int</i> olarak
     */
    public static long faktoriyel(long sayi){
        long sum = 1L;
        if (sayi == 0 || sayi == 1){
            sum = 1L;
        }else{ 
            for (long i = 2; i <= sayi; i++){
                sum *= i;
            }
        }
        return (sayi >= 0)? sum: null;
    }
    
    /**
     * Sayının belirtilen üssünü döner.
     * 
     * @param taban <i>int</i> cinsinde
     * @param us sayının üssü
     * @return 
     */
    public static double us(int taban, int us){
        double sonuc = 1;
        
        if(us < 0){
            double tersTaban = 1/(double)taban;
            int pozUs = (-1)*us;
            
            return us(tersTaban, pozUs);            
        }
        else {
            int kontrol;
            while(true){
                kontrol = us%2;
                us = (int)Math.floor(us/2);
                
                if (kontrol == 1){
                    sonuc *= taban;
                }
                if (us == 0){
                    break;
                }
                taban *= taban;
            }
        }
        return sonuc;
    }
    
    /**
     * Sayının belirtilen üssünü döner.
     * 
     * @param taban <i>int</i> cinsinde
     * @param us sayının üssü <i>double</i> cinsinde
     * @return 
     */
    public static double us(int taban, double us){
        return StrictMath.pow(taban, us);
    }
    
    /**
     * Sayının belirtilen üssünü döner.
     * 
     * @param taban <i>double</i> cinsinde
     * @param us sayının üssü <i>int</i> cinsinde
     * @return 
     */
    public static double us(double taban, int us){
        double sonuc;
        
        switch (us) {
            case 0:
                return 1;
            case 1:
                return taban;
            default:
                double tmp = us(taban, us/2);
                if(us%2 == 0) {
                    sonuc = tmp*tmp;
                }
                else{
                   sonuc = tmp*tmp*taban;
                }    
        }
        return sonuc;
    }
    
    /**
     * Sayının belirtilen üssünü döner.
     * 
     * @param taban <i>double</i> cinsinde
     * @param us sayının üssü <i>double</i> cinsinde
     * @return 
     */
    public static double us(double taban, double us){
        return StrictMath.pow(taban, us);
    }
    
    /**
     * Girilen açıyı {@code radyan} cinsinden yaklaşık değerini döndürür.
     * 
     * @param aci <i>double</i> cinsinden
     * @return açının radyanı
     */
    public static double radyanaCevir(double aci){
        double sonuc = 0;
        
            if(aci >= 0)
            {  
                sonuc = ((aci%360)*PI)/180;
            }
            else if(aci < 0){
                sonuc = (((aci%360)+360)*PI)/180;
            }
            return sonuc;
    }
    /**
     * Girilen radyanı {@code açı} cinsinden yaklaşık değerini döndürür.
     * 
     * @param radyan <i>double</i> cinsinden
     * @return açının radyanı
     */
    public static double aciyaCevir(double radyan){
        double sonuc = 0;
        
            if(radyan >= 0)
            {  
                sonuc = ((radyan%TAU)*180)/PI;
            }
            else if(radyan < 0){
                //TAU = 2*PI
                sonuc = (((radyan%TAU) + TAU)*180)/PI;
            }
            return sonuc;
    }
    /**
     * Girilen sayının mutlak {@code int} değerini döner.
     * Eğer girilen sayı pozitif ise sayiyi döner.
     * Eğer sayı negatif ise sayının negatifini döner.
     *
     * <p>Eğer sayı,{@link Integer#MIN_VALUE} değerine eşitse
     * - gösterilebilir en büyük negatif {@code int} değeri - 
     * sonuç sayının aynısı olur.
     *
     * @param   sayi   mutlak değeri istenen sayı
     * @return  girilen sayının mutlak değeri.
     */
    public static int mutlak(int sayi){
        return (sayi <= 0)? -sayi : sayi;
    }
    
    /**
     * Girilen sayının mutlak {@code long} değerini döner.
     * Eğer girilen sayı pozitif ise sayiyi döner.
     * Eğer sayı negatif ise sayının negatifini döner.
     *
     * <p>Eğer sayı,{@link Long#MIN_VALUE} değerine eşitse
     * - gösterilebilir en büyük negatif {@code long} değeri - 
     * sonuç sayının aynısı olur.
     *
     * @param   sayi   mutlak değeri istenen sayı
     * @return  girilen sayının mutlak değeri.
     */
    public static long mutlak(long sayi){
        return (sayi <= 0)? -sayi : sayi;
    }
    /**
     * Girilen sayının mutlak {@code float} değerini döner.
     * Eğer girilen sayı pozitif ise sayiyi döner.
     * Eğer sayı negatif ise sayının negatifini döner.
     * Özel durumlar:
     * <ul><li>Eğer <b>sayi</b> pozitif sıfır ya da negatif sıfır ise, pozitif
     * sıfır döner.
     * <li>Eğer <b>sayi</b> pozitif sonsuz ya da negatif sonsuz ise, pozitif
     * sonsuz döner.
     * </ul>
     *
     * @param   sayi   mutlak değeri istenen sayı
     * @return  girilen sayının mutlak değeri.
     */
    public static float mutlak(float sayi){
        return (sayi <= 0.0F)? -sayi : sayi;
    }
    
    /**
     * Girilen sayının mutlak {@code double} değerini döner.
     * Eğer girilen sayı pozitif ise sayiyi döner.
     * Eğer sayı negatif ise sayının negatifini döner.
     * Özel durumlar:
     * <ul><li>Eğer <b>sayi</b> pozitif sıfır ya da negatif sıfır ise, pozitif
     * sıfır döner.
     * <li>Eğer <b>sayi</b> pozitif sonsuz ya da negatif sonsuz ise, pozitif
     * sonsuz döner.
     * </ul>
     *
     * @param   sayi   mutlak değeri istenen sayı
     * @return  girilen sayının mutlak değeri.
     */
    public static double mutlak(double sayi){
        return (sayi <= 0.0D)? -sayi : sayi;
    }
    
    /**
     * Bu metod üs metodunun üs parametresini 1/2 yaparak kullanır ve
     * {@code double} değeri döner.
     * Özel durumlar:
     * <ul><li>Eğer girdi sayı değilse veya sayı sıfırdan küçükse 
     * NaN döner.
     * </ul>
     * @param num karekökü alınacak sayı
     * @return girilen sayının karekökü
     */
    public static double karekok(double num){
        List<String> sayi = Cebir.ciftAyir(num);

        double pairNum = Double.parseDouble(sayi.get(0));
        double closestNum = 0;
        double closestPerfSq = 0;
        double nextCalc;

        for (int i = 9; 0 <= i; i--) {
            closestPerfSq = Cebir.us(i, 2);
            if (closestPerfSq <= pairNum) {
                closestNum = i;
                sayi.remove(0);
                break;
            }
        }

        double araSayi = pairNum - closestPerfSq;
        for (int j = 0; j <= 13; j++) {
            if (!sayi.isEmpty()) {
                araSayi = araSayi * 100 + Double.parseDouble(sayi.get(0));
            } else {
                araSayi = araSayi * 100;
            }
            for (int i = 9; 0 <= i; i--) {
                nextCalc = (closestNum * 20 + i) * i;
                
                if (nextCalc <= araSayi) {

                    closestNum = closestNum * 10 + i;

                    araSayi = araSayi - nextCalc;
                    
                    if (!sayi.isEmpty()) {
                        sayi.remove(0);
                    }
                    break;
                }
            }
        }
        BigDecimal b = new BigDecimal(closestNum);
        
        String toStr = b.toString();

        char[] toChr = toStr.toCharArray();

        boolean done = false;
        LinkedList<Character> chr = new LinkedList<>();

        chr.add(0, 'a');
        int recordComma = 0;
        int currentNum = 0;
        
        for (int k = 0; k < toChr.length; k++) {

            currentNum = (int) (currentNum * 10 + (Integer.parseInt(Character.toString(toChr[k]))));

            if (currentNum * currentNum > num && !done) {
                chr.add(k, '.');
                chr.add(k + 1, toChr[k]);
                recordComma = k;
                done = true;

            } else if (chr.get(recordComma) == '.') {
                chr.add(k + 1, toChr[k]);

            } else {
                if (chr.get(0) == 'a') {
                    chr.remove(0);
                }
                chr.add(k, toChr[k]);

            }
        }

        char[] yeni = new char[toChr.length + 1];
        Iterator it = chr.iterator();

        int index = 0;
        while (it.hasNext()) {
            yeni[index] = (char) it.next();

            index++;
        }

        String s = new String(yeni);
        Double d = Double.parseDouble(s);
        
        return d;
    }
    
    /**
     * Bu metod üs metodunun üs parametresini 1/3 yaparak kullanır ve
     * {@code double} değeri döner.
     * Özel durumlar:
     * <ul><li>Eğer girdi sayı değilse veya sayı sıfırdan küçükse 
     * NaN döner.
     * </ul>
     * @param sayi karekökü alınacak sayı
     * @return girilen sayının karekökü
     */
    public static double kupkok(double sayi){
        return StrictMath.cbrt(sayi);
    }
    
    /**
     * Bu metod üs metodunu kullanır ve {@code double} değeri döner.
     * Özel durumlar:
     * <ul><li>Eğer girdi sayı değilse veya sayı sıfırdan küçükse 
     * NaN döner.
     * </ul>
     * @param sayi karekökü alınacak sayı {@code double} olarak
     * @param kok  alınması istenen kök değeri, {@code double}
     * ya da {@code int} şeklinde, ama asla 1/rakam şeklinde değil
     * 
     * @return girilen sayının karekökü
     */
    public static double kok(double sayi, double kok){
        return us(sayi, 1/kok);
    }
    
    /**
     * Sayıyı bir alt tam sayıya yuvarlar.
     * 
     * @param sayi tabana yuvarlanacak sayı
     * @return  sayının {@code double} taban değeri örn. 3.5 --> 3.0
     * @see #yuvarla(double) 
     */
    public static double taban(double sayi){
        return StrictMath.floor(sayi);
    }
    
    /**
     * Sayıyı bir üst tam sayıya yuvarlar.
     * <ul><li>Eğer sayı negatif ondalıklı bir sayı ise, yani -1 ile 0 arasında
     * ise sonuç negatif 0 olur.
     * </ul>
     * @param sayi tavana yuvarlanacak sayı
     * @return  sayının {@code double} tavan değeri örn. 3.5 --> 4.0
     * @see #yuvarla(double) 
     */
    public static double tavan(double sayi){
        return StrictMath.ceil(sayi);
    }
    
    /**
     * Sayıyı bir normalde yaptığımız şekilde yuvarlar.
     * <ul><li>Eğer sayı negatif ondalıklı bir sayı ise, yani -1 ile 0 arasında
     * ise sonuç negatif 0 olur.
     * </ul>
     * @param sayi tabana yuvarlanacak sayı
     * @return  sayının {@code double} taban değeri örn. 3.5 --> 4.0
     * @see #tavan(double), #taban(double) 
     */
    public static double yuvarla(double sayi){
        double taban = StrictMath.floor(sayi);
        double tavan = StrictMath.ceil(sayi);
        
        return (sayi < taban+0.5)? taban: tavan;
    }
    
    /**
     * @usage: <ul><li>float[] kume = {1, 5, 8, 10};
     * <li>Cebir.ort(kume);
     * </ul>
     * @param kume aritmetik ortlaması alınacak sayılar kümesi
     * @return  sayıların aritmetik ortlaması
     */
    public static double ort(double[] kume){
        double artToplam = 0.0f;
        for(double eleman: kume){
            artToplam += eleman;
        }
        return artToplam/kume.length;
    }
    
    /**
     * 
     * @param kume  geometrik ortalaması alınması istenen sayı kümesi
     * @return verilen kümenin geometrik ortalaması
     */
    public static double gOrt(double[] kume){
        double carpim = 1;
        for (double eleman: kume){
            carpim *= eleman;
        }
        return kok(carpim, 1/kume.length);
    }
    /**
     * @usage: <ul><li>float[] kume = {1, 5.7, 8.24};
     * <li>Cebir.stSapma(kume);
     * </ul>
     * @param kume standart sapması alınacak sayılar kümesi
     * @return sayıların standart sapması
     */
    public static double stSapma(double[] kume){
        double aOrt = ort(kume);
        double sTop = 0;
        for(double eleman: kume){
            sTop += us(eleman-aOrt, 2);
        }
        return karekok(sTop/(kume.length-1));
    }
    
    /**
     * Parametreye girilen double değerini sayı çiftlerine ayırır.
     * 
     * @param sayi çiftlere ayrılması istenen sayı
     * @return  çiftlere ayrılmış sayının liste hali
     */
    public static List<String> ciftAyir(double sayi){
        
        List<String> pairs;
        pairs = new ArrayList<>();
          
        boolean tek = false;
        
        String number = String.valueOf(sayi);
        String strNumber = Double.toString(sayi);
        
        String[][] spt = new String[1][2];
        spt[0] = strNumber.split("\\.");
        
        String[] tamKisim = spt[0][0].split("(?!^)");
        String[] ondalikKisim = spt[0][1].split("(?!^)");
        
        if(tamKisim.length%2 == 0 && ondalikKisim.length%2 == 1){
            tek = true;
        }
        
        String[] seperated = number.split("(?!^)");
        
        if(seperated.length%2 == 0){
            if(!tek){
                String pair;
                String lonePair = seperated[0];
                pairs.add(lonePair);

                for(int i = 1 ; i<seperated.length; i+=2){
                    String pair1 = "";
                    String pair2 = "";
                    if(!".".equals(seperated[i]) && ".".equals(seperated[i+1])){
                        pair1 = seperated[i];
                        pair2 = seperated[i+2];

                        if(!"".equals(pair1) && !"".equals(pair2)){
                            pair = pair1 + pair2;
                            pairs.add(pair);
                        }

                        i++;

                    }else if(!".".equals(seperated[i]) && !".".equals(seperated[i+1])){
                        pair1 = seperated[i];
                        pair2 = seperated[i+1];                   
                        if(!"".equals(pair1) && !"".equals(pair2)){
                            pair = pair1 + pair2;
                            pairs.add(pair);
                        }
                    }
                    else{
                        i--;
                    }

                }
            }else{
                
                String pair;
                
                for(int i = 0 ; i<seperated.length; i+=2){
                    String pair1 = "";
                    String pair2 = "";
                    try{
                        if(".".equals(seperated[i]) && !".".equals(seperated[i+1])){
                            i++;
                            pair1 = seperated[i];

                            if(seperated.length >= i+3){
                                pair2 = seperated[i+1];
                            }else{
                                pair2 = "0";
                            }

                            if(!"".equals(pair1) && !"".equals(pair2)){
                                pair = pair1 + pair2;
                                pairs.add(pair);
                            }

                        }else if(!".".equals(seperated[i]) && !".".equals(seperated[i+1])){
                            pair1 = seperated[i];
                            pair2 = seperated[i+1];

                            if(!"".equals(pair1) && !"".equals(pair2)){
                                pair = pair1 + pair2;
                                pairs.add(pair);
                            }
                        }
                    }catch(ArrayIndexOutOfBoundsException e){
                        pair1 = seperated[i];
                        pair2 = "0";
                        
                        if(!"".equals(pair1) && !"".equals(pair2)){
                            pair = pair1 + pair2;
                            pairs.add(pair);
                        }
                    }
                }
            }
        }else{
            
                String pair;

                boolean lonely1 = false;
                boolean lonely2 = false;
                boolean bitti = false;

                for(int i = 0 ; i < seperated.length; i+=2){
                    String pair1 = "";
                    String pair2 = "";
                    if(".".equals(seperated[i])){
                        i--;
                    }
                    else if(".".equals(seperated[i+1])){
                        if(seperated.length == 3){
                            if(!lonely2) {
                                String lonePair = seperated[0];
                                pairs.add(lonePair);
                                lonely2 = true;
                            }
                            
                            pair1 = seperated[i+2];
                            pair2 = "0";

                            if (!"".equals(pair1) && !"".equals(pair2)) {
                                pair = pair1 + pair2;
                                pairs.add(pair);
                                break;
                            }
                                
                        }else{
                            pair1 = seperated[i];
                            pair2 = seperated[i+2];

                            if(!"".equals(pair1) && !"".equals(pair2)){
                                pair = pair1 + pair2;
                                pairs.add(pair);
                            }
                        }
                    }
                    else{

                        if(!lonely1) {
                            String lonePair = seperated[0];
                            pairs.add(lonePair);
                            lonely1 = true;
                        }

                        pair1 = seperated[i+1];
                        pair2 = seperated[i+2];

                        if (!"".equals(pair1) && !"".equals(pair2)) {
                            pair = pair1 + pair2;
                            pairs.add(pair);
                        }

                        if(".".equals(seperated[i+3])){
                            bitti=true;
                        }

                        if(bitti) break;
                    }

                }
        }   
        return pairs;
    }
}