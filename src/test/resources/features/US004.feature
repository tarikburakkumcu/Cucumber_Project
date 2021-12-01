@US004
Feature: US004 register sayfasi kayit olusturma

  @TC001
  Scenario: TC001 Anasayfadan login sayfasina gecip login olduktan sonra otelleri listeleyip addHotel linkine tıklanması

    When anasayfadan login yapılarak istenen sayfaya gidildi
    And hotel management linkine tıklandı
    And hotel list linkine tıklandı
    And addHotel  linkine tıklandı

  @TC002
  Scenario: TC002 addHotel sayfasında ilgili yerlere bilgiler girilmesi

    When anasayfadan login yapılarak istenen sayfaya gidildi
    And hotel management linkine tıklandı
    And hotel list linkine tıklandı
    And addHotel  linkine tıklandı
    And Code name adress phone ve mail kutuları doldurulur

  @TC003
  Scenario: TC003 addHotel sayfasında ilgili yerlere bilgiler girilmesi ve grup secilip kaydelimesi

    When anasayfadan login yapılarak istenen sayfaya gidildi
    And hotel management linkine tıklandı
    And hotel list linkine tıklandı
    And addHotel  linkine tıklandı
    And Code name adress phone ve mail kutuları doldurulur
    And "idGroup" dropdown butonuna tıklayıp Grup seçiniz
    And Otel kayıt butonuna tıklandı

  @TC004
  Scenario: TC004 Kayıt sonrası cıkan mesajın kontrolü yapılıp ok tuşuna basılır ve Hotel list menüsüne gecilir
    When anasayfadan login yapılarak istenen sayfaya gidildi
    And hotel management linkine tıklandı
    And hotel list linkine tıklandı
    And addHotel  linkine tıklandı
    And Code name adress phone ve mail kutuları doldurulur
    And "idGroup" dropdown butonuna tıklayıp Grup seçiniz
    And Otel kayıt butonuna tıklandı
    And Hotel was inserted successfully yazısının görünürlüğü test edildi
    And Ok butonuna tıklandı
    And Hotel List  menüsüne tıklandı

  @TC005
  Scenario: TC005 Yapılan kayıdın otel listesinde olduğu kontrol edildi

    When anasayfadan login yapılarak istenen sayfaya gidildi
    And hotel management linkine tıklandı
    And hotel list linkine tıklandı
    And addHotel  linkine tıklandı
    And Code name adress phone ve mail kutuları doldurulur
    And "idGroup" dropdown butonuna tıklayıp Grup seçiniz
    And Otel kayıt butonuna tıklandı
    And Hotel was inserted successfully yazısının görünürlüğü test edildi
    And Ok butonuna tıklandı
    And Hotel List  menüsüne tıklandı
    And Kayıt oldugumuz id numarası kutucuga girildi
    And Yönetici olarak otel tipi konusunda secim yapıldı
    And Yönetici olarak unique bir kaydın yapıldıgı dogrulandı