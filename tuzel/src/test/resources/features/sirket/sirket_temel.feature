Feature: sirket temel bilgileri kaydetme
  Background:
    Given Browser acilir
    And Giriş sayfasına gelinir
    And Kullanıcı adı "talipk" ve parola "1234" girilir
    And Girişe basılır
  Scenario: Sirket temel bilgileri basarili kayit
    Given "anasayfa" sayfasina gelinir
    When Sirket basvurusu butonuna tiklanir
    And Sirket temel basvurusunda tur secilir
    And Sirket temel basvurusunda isim olarak "muhammed sirketi" girilir
    And Sirket temel basvurusunda para birimi secilir
    And Sirket kaydet tiklanir
    Then Basarili growl mesajinin ciktigi gorulur
