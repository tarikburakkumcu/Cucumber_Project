@US001
Feature: US001 hotel anasayfa objelerinin kontrolu

      @TC001
      Scenario: TC001 Navbar'da bulunan elementlerin gorurunurlugu

          When kullanici hotel sayfasına gider
          And homeLink görünürlüğü kontrol edildi
          And roomsLink görünürlüğü kontrol edildi
          And restaurantLink görünürlüğü kontrol edildi
          And aboutLink görünürlüğü kontrol edildi
          And blogLink görünürlüğü kontrol edildi
          And contactLink görünürlüğü kontrol edildi
          And loginLink görünürlüğü kontrol edildi
          And Sayfayi kapatir

      @TC002
      Scenario: TC002 Navbar'da bulunan elementlerin kullanimi
          When kullanici hotel sayfasına gider
          And homeLink tıklar
          And roomsLink tıklar
          And restaurantLink tıklar
          And aboutLink tıklar
          And blogLink tıklar
          And contactLink tıklar
          And loginLink tıklar
          And Sayfayi kapatir

      @TC003
      Scenario: TC003 CHECK-IN DATE, CHECK-OUT DATE, ROOM, CUSTOMER elementleri gorunur olmali.
          When kullanici hotel sayfasına gider
          And CHECK-IN DATE elementine tiklanir ve giris tarihi icin secim yapilir.
          And CHECK-OUT DATE elementine tiklanir ve cikis tarihi icin secim yapilir.
          And ROOM elementine tiklanir ve dropdown menuden uygun, room type secilir.
          And CUSTOMER elemtine tiklanir ve dropdown menuden yetiskin kisi sayisi sacilir.
          And Sayfayi kapatir

      @TC004
      Scenario: TC004 Check Availability butonu kullaniciyi sectigi kriterlere gore uygun sayfaya yonlendirmeli.
          When kullanici hotel sayfasına gider
          And Kullanici uygun kriterleri sectikten sonra Check Availabilitybutonuna tiklar.
          And Sayfayi kapatir

      @TC005
      Scenario: TC005 Welcome to our hotel bolumu gorunur olmali
          When kullanici hotel sayfasına gider
          And Main Page'de ilgili bolum gorulene kadar scrolldown yapilir.
          And Sayfayi kapatir

      @TC006
      Scenario: TC006 Our Rooms bolumu ve icerisindeki elementler gorunur ve tiklanabilir olmali.
          When kullanici hotel sayfasına gider
          And Main Page'de ourRooms bolum gorulene kadar scrolldown yapilir.
          And Our Rooms bolumundeki birinciden altinci oda secenegine kadar tiklanir.
          And Sayfayi kapatir

      @TC007
      Scenario: TC007 Misafirlerin yorumlarinin bulundugu slider bolumu gorunur ve altindaki yonlendirme butonlari tiklanabilir olmali.
          When kullanici hotel sayfasına gider
          And  Main Page'de yorum bolum gorulene kadar scrolldown yapilir.
          And Musteri yorumlari bolumunde bulunan bes slider butonuna sirasiyla tiklanir.
          And Sayfayi kapatir


      @TC008
      Scenario: TC008 Recent Blog bolumu gorunur ve icerisindeki elementler tiklanabilir olmali.
          When kullanici hotel sayfasına gider
          And Main Page'de blog bolum gorulene kadar scrolldown yapilir.
          And Recent Blog bolumundeki birinciden altinci blog yazisina kadar tiklanir.
          And Sayfayi kapatir


      @TC009
      Scenario: TC009 Instagram kismi gorunur ve icerisindeki elementler tiklanabilir olmali.
          When kullanici hotel sayfasına gider
          And Main Page'de instagram bolum gorulene kadar scrolldown yapilir.
          And Instagram bolumundeki fotograflara sirasiyla tiklanir Next ve Previous elementlerine tiklanir.
          And Sayfayi kapatir


      @TC0010
      Scenario: TC010 Sayfanin en altinda bulunan footer bolumundeki Concort Hotel, Useful Links, Privacy ve Have a Questions? kisimlari gorunur olmali.
          When kullanici hotel sayfasına gider
          And Main Page'de sayfanin sonuna kadar scrolldown yapilir.
          And Sayfayi kapatir





