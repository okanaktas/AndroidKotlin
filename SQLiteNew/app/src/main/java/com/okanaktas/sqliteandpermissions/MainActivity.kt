package com.okanaktas.sqliteandpermissions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.okanaktas.sqliteandpermissions.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        try {
            //openOrCreate varsa aç yoksa yarat.
            //mode private demek sadece bu app içerisinden ulaşabileceğiz.
            //veritabanın adını büyük harfla yazıyorum.
            val myDatabase = this.openOrCreateDatabase("Musicians", MODE_PRIVATE, null)

            //table ismi küçük harf ile yazılır ve genelde veritabanı ismi ile aynı olur.
            //bir tabla oluştur eğer yoksa (create table if not exısts) ve adını da musicians koy.
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS musicians (id INTEGER PRIMARY KEY,name VARCHAR, age INT)")

            //insert into -> içine koy
            //musicians tablosunun içerisindeki name ve age sütunlarının içerisine kaydedeceğim ve değerleri values tan sonraki değerler olacak
            /*
            myDatabase.execSQL("INSERT INTO musicians (name, age) VALUES ('OKAN',27)")
            myDatabase.execSQL("INSERT INTO musicians (name, age) VALUES ('BERKAY',9)")
             */

            //ismi OKAN olanı bul ve yasini 35 yap
            //myDatabase.execSQL("UPDATE musicians SET age = 35 WHERE name = 'OKAN'")

            //id si 1 olanı bul ve name i oradaki değer ile değiştir.
            myDatabase.execSQL("UPDATE musicians SET name = 'Okan Aktas' WHERE id = 1")

            //Silme işlemi
            //myDatabase.execSQL("DELETE FROM musicians WHERE name = 'BERKAY'")

            //veritabanın girdiğimiz değerleri çekmek için bir cursor oluşturmamız gerek
            //query yazmak demek veritabınında veri çekmek, sorgu yazmak anlamına geliyor.
            //cursor virgülden sonraki filtreleme yapacak mısın kısmı. Oraya null diyorum çünkü kendim yapablirim.

            //Filtreleme işlemi cursor yani select kısmında yapılıyor. Aşağıdaki örnekte sadece ismi okan olan değerleri gösterir.
            //val cursor = myDatabase.rawQuery("SELECT * FROM musicians WHERE name = 'okan'",null)
            //val cursor = myDatabase.rawQuery("SELECT * FROM musicians WHERE age = 3",null)

            //name sütununda s ile bitenleri getir.
            //val cursor = myDatabase.rawQuery("SELECT * FROM musicians WHERE name LIKE '%s'",null)

            //name sütununda k ile başlayanları getir.
            //val cursor = myDatabase.rawQuery("SELECT * FROM musicians WHERE name LIKE 'k%'",null)

            //standart
            val cursor = myDatabase.rawQuery("SELECT * FROM musicians", null)


            //val cursor = myDatabase.rawQuery("SELECT * FROM musicians", null)

            //kaçıncı indexte kayıtlı olduğu bilgisini alma kısmı
            val nameIndex = cursor.getColumnIndex("name")
            val ageIndex = cursor.getColumnIndex("age")
            val idIndex = cursor.getColumnIndex("id")

            //cursor, mouse imleci gibi tek tek sütunlarda gezinecek
            while (cursor.moveToNext()) {
                println("Name: ${cursor.getString(nameIndex)}")
                println("Age: ${cursor.getInt(ageIndex)}")
                println("Id: ${cursor.getInt(idIndex)}")
            }
            //açtığımız cursor u kapatıyoruz ki daha verimli bir kod olsun
            cursor.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}