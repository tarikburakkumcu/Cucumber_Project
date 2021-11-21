@US003
Feature: US001 register sayfasi kayit olusturma

  @TC001
  Scenario: TC001 Anasayfadan login linkine gecis

    When kullanici hotel sayfasına gider
    And login linkine tiklar
    And Sayfayi kapatir


  @TC002
  Scenario: TC002 Register sayfası New Acount linkine gecis

    When kullanici hotel sayfasına gider
    And login linkine tiklar
    And Login sayfasındaki creat a new account butonuna tiklandi
    And Sayfayi kapatir

  @TC003
  Scenario: TC003 Register sayfasındaki kayıt bilgileri doldurulur

    When kullanici hotel sayfasına gider
    And login linkine tiklar
    And Login sayfasındaki creat a new account butonuna tiklandi
    And Register sayfasına ulasıldı ve Kullanıcı adı gönderildi
    And Password gönderildi
    And Email gönderildi
    And İsim-soyisim gönderildi
    And Telefon gönderildi
    And SSN gönderildi
    And Ehliyet gönderildi
    And Ülke seçildi
    And Eyalet seçildi
    And Adres gönderildi
    And Meslek gönderildi
    And Doğum tarihi gönderildi
    And Sayfayi kapatir


  @TC004
  Scenario: TC004 Register sayfasındaki girisi yapılan degerler kaydedilir

    When kullanici hotel sayfasına gider
    And login linkine tiklar
    And Login sayfasındaki creat a new account butonuna tiklandi
    And Register sayfasına ulasıldı ve Kullanıcı adı gönderildi
    And Password gönderildi
    And Email gönderildi
    And İsim-soyisim gönderildi
    And Telefon gönderildi
    And SSN gönderildi
    And Ehliyet gönderildi
    And Ülke seçildi
    And Eyalet seçildi
    And Adres gönderildi
    And Meslek gönderildi
    And Doğum tarihi gönderildi
    And Save Buttonuna tiklandi
    And Sayfayi kapatir


  @TC005
  Scenario: TC005 Kaydın başarı ile kardedildigi kontrol edilir

    When kullanici hotel sayfasına gider
    And login linkine tiklar
    And Login sayfasındaki creat a new account butonuna tiklandi
    And Register sayfasına ulasıldı ve Faker clasından üretilen  Kullanıcı adı gönderildi
    And Faker clasından üretilen Password gönderildi
    And Faker clasından üretilen Email gönderildi
    And Faker clasından üretilen İsim-soyisim gönderildi
    And Faker clasından üretilen Telefon gönderildi
    And SSN gönderildi
    And Ehliyet gönderildi
    And Ülke seçildi
    And Eyalet seçildi
    And Adres gönderildi
    And Meslek gönderildi
    And Doğum tarihi gönderildi
    And Save Buttonuna tiklandi
    And Alert içindeki başarı ile kaydedildi mesajı görüldü
    And Ok Buttonuna tiklandi
    And Sayfayi kapatir

