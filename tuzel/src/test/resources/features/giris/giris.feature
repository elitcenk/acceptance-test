Feature: Giriş yapilmasi
  Background:
    Given Browser acilir
  Scenario: Başarıyla giriş senaryosu
    Given Giriş sayfasına gelinir
    When Kullanıcı adı "talipk" ve parola "1234" girilir
    And Girişe basılır
    Then Tuzel sayfasına başarıyla girildiği görülür
  Scenario: Hatalı giriş senaryosu
    Given Giriş sayfasına gelinir
    When Kullanıcı adı "talipk" ve parola "12345" girilir
    And Girişe basılır
    Then Giriş sayfasında kalındığı görülür