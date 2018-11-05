/*
 * Copyright (c) 2018, Kayra Urfalı
 * Kendi projelerimde daha rahat kullanabilmek için oluşturduğum Vektör kütüphanesidir.
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

import java.io.Serializable;

/**
 * {@code Vektor} sınıfı matriks işlemlerinde kolaylık sağlamak için, bir
 * koordinat tutucu olarak tasarlanmıştır.
 * 
 * @version 1.0
 * @author kayra
 */
public class Vektor implements Serializable{
    
    /**
     * Vektörün alacağı X koordinat değeri.
     */
    public double x;

    /**
     * Vektörün alacağı Y koordinat değeri.
     */
    public double y;

    /**
     * Vektörün alacağı Z koordinat değeri.
     */
    public double z;
    
    /**
     * Bellekte yer kaplamaz, sadece {@code Vektor} nesnesini {@code double[]}
     * listeye dönüştürürken çağırılır.
     */ 
    public transient double[] array;
    
    /**
     * Eğer sonradan koordinat ekleme işlemi yapılacaksa default constructor metot.
     */
    public Vektor(){}
    
    /**
     * 1 Boyutlu vektörlerin alacağı yapıcı(constructor) metot.
     * 
     * @param x   vektörün alacağı x koordinat değeri
     */
    public Vektor(double x){
        this.x = x;
    }
    
    /**
     * 2 Boyutlu vektörlerin alacağı yapıcı(constructor) metot.
     * 
     * @param x   vektörün alacağı x koordinat değeri
     * @param y   vektörün alacağı y koordinat değeri
     */
    public Vektor(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    /**
     * 3 Boyutlu vektörlerin alacağı yapıcı(constructor) metot.
     * 
     * @param x   vektörün alacağı x koordinat değeri
     * @param y   vektörün alacağı y koordinat değeri
     * @param z   vektörün alacağı z koordinat değeri
     */
    public Vektor(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    /**
     * Parametreye girilen x değerini çağırılan vektöre tanımlar.
     * 
     * @param x  vektore atanması istenen x değeri
     * @return   yeni değerleriyle {@code Vektör}
     */
    public Vektor ekle(double x){
        this.x = x;
        return this;
    }
    
    /**
     * Parametreye girilen x ve y değerini çağırılan vektöre tanımlar.
     * 
     * @param x  vektore atanması istenen x değeri
     * @param y  vektore atanması istenen y değeri
     * @return   yeni değerleriyle {@code Vektör}
     */
    public Vektor ekle(double x, double y){
        this.x = x;
        this.y = y;
        return this;
    }
    
    /**
     * Parametreye girilen x, y ve z değerini çağırılan vektöre tanımlar.
     * 
     * @param x  vektore atanması istenen x değeri
     * @param y  vektore atanması istenen y değeri
     * @param z  vektore atanması istenen z değeri
     * @return   yeni değerleriyle {@code Vektör}
     */
    public Vektor ekle(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }
    
    /**
     * Çağırılan vektöre parametredeki vektörün değerlerini atar.
     * 
     * @param v   çağırılan vektöre atanması istenen vektör
     * @return    yeni değerleriyle {@code Vektör} tipi
     */
    public Vektor ekle(Vektor v){
        x = v.x;
        y = v.y;
        z = v.z;
        
        return this;
    }
    
    /**
     * Parametreye girilen ve elemanları olan listeyi, 3 boyutlu {@code Vektör}
     * haline çevirir.
     * 
     * @param kaynak {@code Vektör}e değerlerinin atanması istenen 1,2,3+ 
     * boyutlu liste
     * @return   yeni değerleriyle {@code Vektör}
     */
    public Vektor ekle(double[] kaynak){
        if (kaynak.length >= 1) {
            x = kaynak[0];
        }else{
            x = 0;
            System.out.println("Listede vektore eklenecek eleman bulunmalidir.");
        }
        if (kaynak.length >= 2) {
            x = kaynak[0];
            y = kaynak[1];
        }else{
            y = 0;
        }
        if (kaynak.length >= 3) {
            z = kaynak[2];
        }else{
             z = 0;
        }
        return this;
    }
    
    /**
     * Çağırılan {@code Vektor} nesnesini kopyalar.
     * 
     * @usage: <ul><li>Vektor nesne2 = new Vektor(x,y,z);
     * <li>Vektor nesne1 = nesne2.kopyala();</ul>
     * @return  vektörün tüm parametreleriyle aynısı, {@code Vektor} olarak
     */
    public Vektor kopyala(){
        return new Vektor(x,y,z);
    }
    
    /**
     * Parametreye girilen {@code double[]} listesi içine, çağırılan Vektörün
     * elemanlarını atar.
     * 
     * @param hedef  içine vektör elemanları aktarılması istenen {@code double[]}
     * @return  <ul><li>
     * liste boş ise belirtilen vektörün tüm elemanlarını {@code double[]}
     * şeklinde döndürür
     * <li>liste uzunluğu 1 ve 1 den büyükse sırasıyla x,y,z koordinatlarını
     * {@code double[]} şeklinde döndürür
     * </ul>
     */
    public double[] aktar(double[] hedef) {
        
        if (hedef == null) {
            return new double[] {x, y, z};
        }
        if (hedef.length >= 1) {
            hedef[0] = x;
        }
        if (hedef.length >= 2) {          
          hedef[1] = y;
        }
        if (hedef.length >= 3) {
          hedef[2] = z;
        }
        return hedef;
    }
    
    /**
     * Çağırılan vektörün uzunluğunu döner.
     * 
     * @brief Kullanılan formül √x²+y²+z²
     * @return Vektörün uzunluğu
     */
    public double uzunluk(){
        return Cebir.karekok(x*x + y*y + z*z);
    }
    
    
    /**
     * Çağırılan vektör ile parametredeki vektörü toplar.
     * 
     * @brief Unutmayın ki, iki vektörün toplanabilmesi için aynı boyutlara sahip
     * olmalıdırlar.
     * @param v Çağırılan vektör ile toplanması istenen vektör
     * @return  İki vektörün toplanmış halini {@code Vektor} olarak.
     */
    public Vektor topla(Vektor v){
        x += v.x;
        y += v.y;
        z += v.z;
        
        return this;
    }
    
    /**
     * Çağırılan vektör ile parametredeki x değerini toplar.
     * 
     * @param x  Çağırılan vektör ile toplanması istenen x koordinatı
     * @return   Vektörün toplanmış hali, {@code Vektor} şeklinde
     */
    public Vektor topla(double x) {
        this.x += x;
        
        return this;
    }
    
    /**
     * Çağırılan vektör ile parametredeki x ve y değerini toplar.
     * 
     * @param x  Çağırılan vektör ile toplanması istenen x koordinatı
     * @param y  Çağırılan vektör ile toplanması istenen y koordinatı
     * @return   Vektörün toplanmış hali, {@code Vektor} şeklinde
     */
    public Vektor topla(double x, double y) {
        this.x += x;
        this.y += y;
        
        return this;
    }
    
    /**
     * Çağırılan vektör ile parametredeki x, y ve z değerini toplar.
     * 
     * @param x  Çağırılan vektör ile toplanması istenen x koordinatı
     * @param y  Çağırılan vektör ile toplanması istenen y koordinatı
     * @param z  Çağırılan vektör ile toplanması istenen z koordinatı
     * @return   Vektörün toplanmış hali, {@code Vektor} şeklinde
     */
    public Vektor topla(double x, double y, double z) {
        this.x += x;
        this.y += y;
        this.z += z;
        
        return this;
    }
    
    /**
     * Bu metot diğer static topla() metodunu belirtilen parametrelerde
     * tekrar çağırır.
     * 
     * @param v1    herhangi bir {@code Vektor} değişkeni
     * @param v2    herhangi bir {@code Vektor} değişkeni
     * @return  iki vektörün toplamını {@code Vektor} şeklinde
     */
    public static Vektor topla(Vektor v1, Vektor v2) {
        return topla(v1, v2, null);
    }
    
    /**
     * Diğer topla() metotlarının aksine statictir, yani metotları direk class
     * üzerinden çağırır, yeni nesne oluşturmaya gerek duyulmaz.
     * 
     * @param v1    herhangi bir {@code Vektor} değişkeni
     * @param v2    herhangi bir {@code Vektor} değişkeni
     * @param hedef  toplamanın sonucunun atanacağı {@code Vektor}
     * @return iki vektörün toplama işlemi sonucunu:
     * <ul><li>3. parametre {@code null} ise (sadece bu metotta null olur
     * {@link #topla(matematik.Vektor, matematik.Vektor) }) yeni {@code Vektor}
     * <li>3. parametre belirtildiyse, yeni değerleriyle o vektör</ul>
     */
    public static Vektor topla(Vektor v1, Vektor v2, Vektor hedef) {
        if (hedef == null) {
          hedef = new Vektor(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
        } else {
          hedef.ekle(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
        }
        return hedef;
    }
    
    /**
     * Çağırılan vektör ile parametredeki x değerini çıkarır.
     * 
     * @param x  Çağırılan vektör ile çıkarılması istenen x koordinatı
     * @return   Vektörün çıkarılmış hali, {@code Vektor} şeklinde
     */
    public Vektor cikar(double x) {
        this.x -= x;
        
        return this;
    }
    
    /**
     * Çağırılan vektör ile parametredeki x ve y değerini çıkarır.
     * 
     * @param x  Çağırılan vektör ile çıkarılması istenen x koordinatı
     * @param y  Çağırılan vektör ile çıkarılması istenen y koordinatı
     * @return   Vektörün çıkarılmış hali, {@code Vektor} şeklinde
     */
    public Vektor cikar(double x, double y) {
        this.x -= x;
        this.y -= y;
        
        return this;
    }
    
    /**
     * Çağırılan vektör ile parametredeki x, y ve z değerini çıkarır.
     * 
     * @param x  Çağırılan vektör ile çıkarılması istenen x koordinatı
     * @param y  Çağırılan vektör ile çıkarılması istenen y koordinatı
     * @param z  Çağırılan vektör ile çıkarılması istenen z koordinatı
     * @return   Vektörün çıkarılmış hali, {@code Vektor} şeklinde
     */
    public Vektor cikar(double x, double y, double z) {
        this.x -= x;
        this.y -= y;
        this.z -= z;
        
        return this;
    }
    
    /**
     * Çağırılan vektör ile parametredeki vektörü çıkarır.
     * 
     * @brief Unutmayın ki, iki vektörün çıkarılabilmesi için aynı boyutlara sahip
     * olmalıdırlar.
     * @param v Çağırılan vektör ile çıkarılması istenen vektör
     * @return  İki vektörün çıkarılmış halini {@code Vektor} olarak.
     */
    public Vektor cikar(Vektor v){
        x -= v.x;
        y -= v.y;
        z -= v.z;
        
        return this;
    }
    
    /**
     * Bu metot diğer static cikar() metodunu belirtilen parametrelerde
     * tekrar çağırır.
     * 
     * @param v1    herhangi bir {@code Vektor} değişkeni
     * @param v2    herhangi bir {@code Vektor} değişkeni
     * @return  iki vektörün farkını {@code Vektor} şeklinde
     */
    public static Vektor cikar(Vektor v1, Vektor v2){
        return cikar(v1, v2, null);
    }
    
    /**
     * Diğer çıkar() metotlarının aksine statictir, yani metotları direk class
     * üzerinden çağırır, yeni nesne oluşturmaya gerek duyulmaz.
     * 
     * @param v1    herhangi bir {@code Vektor} değişkeni
     * @param v2    herhangi bir {@code Vektor} değişkeni
     * @param hedef  çıkarmanın sonucunun atanacağı {@code Vektor}
     * @return iki vektörün çıkarma işlemi sonucunu:
     * <ul><li>3. parametre {@code null} ise (sadece bu metotta null olur
     * {@link #cikar(matematik.Vektor, matematik.Vektor) }) yeni {@code Vektor}
     * <li>3. parametre belirtildiyse, yeni değerleriyle o vektör</ul>
     */
    public static Vektor cikar(Vektor v1, Vektor v2, Vektor hedef) {
        if (hedef == null) {
          hedef = new Vektor(v1.x - v2.x, v1.y - v2.y, v1.z - v2.z);
        } else {
          hedef.ekle(v1.x - v2.x, v1.y - v2.y, v1.z - v2.z);
        }
        return hedef;
    }
    
    
    /**
     * Static olan kardeşinin yanı sıra sınıfın main metodu üzerinde kullanılması
     * için yeni bir nesne oluşturularak çağırılır.
     * 
     * @usage: Vektor nesne1 = new Vektor(x1,y1,z1); 
     * Vektor nesne2 = new Vektor(x2,y2,z2);
     * nesne1.uzaklik(nesne2);
     * 
     * @param v   herhangi bir {@code Vektor} değişkeni
     * @return İki vektör arası uzaklık
     */
    public double uzaklik(Vektor v) {
        double ux = x - v.x;
        double uy = y - v.y;
        double uz = z - v.z;
        
        return Cebir.karekok(ux*ux + uy*uy + uz*uz);
    }
    
    /**
     * Yeni bir nesne oluşturmadan sınıfın metodu üzerinden çağırılır.
     * 
     * @usage: Vektor.uzaklik(Vektor1, Vektor2)
     * @param v1    herhangi bir {@code Vektör} değişkeni
     * @param v2    herhangi bir {@code Vektör} değişkeni
     * @return İki vektör arası uzaklık
     */
    public static double uzaklik(Vektor v1, Vektor v2) {
        double ux = v1.x - v2.x;
        double uy = v1.y - v2.y;
        double uz = v1.z - v2.z;
        
        return Cebir.karekok(ux*ux + uy*uy + uz*uz);
    }
    
    @Override
    public String toString() {
      return "[ " + x + ", " + y + ", " + z + " ]";
    }
    
    /**
     * Çağırılan vektörü {@code double[]} liste olarak döndürür.
     * 
     * @return {@code Vektor} nesnesinin array hali
     */
    public double[] array() {
        if (array == null) {
          array = new double[3];
        }
        
        array[0] = x;
        array[1] = y;
        array[2] = z;
        
        return array;
    }
    
    @Override
    public boolean equals(Object obj) {
      if (!(obj instanceof Vektor)) {
        return false;
      }
      
      final Vektor p = (Vektor) obj;
      
      return x == p.x && y == p.y && z == p.z;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.z) ^ (Double.doubleToLongBits(this.z) >>> 32));
        return hash;
    }
}